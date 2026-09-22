<?php

declare(strict_types=1);

namespace App\Timbrado;

use App\Sync\ResuelveFuenteSicret;
use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;
use Throwable;

/**
 * Origen/Destino (nombre corto) de una guía, resuelto en vivo contra
 * SICRET — dato que ATLAS no sincroniza a `guias` (ver
 * App\Sync\GuideWatcher). Se arma consultando, en la fuente correspondiente
 * (sicrePR/sicreGero, ver App\Sync\SourceRegistry), las Ubicaciones del
 * Complemento Carta Porte de la guía: `tras_cartaporte_ubic` (num_guia =
 * `guia`, `tipo_ubic` IN ('ORIGEN','DESTINO')).
 *
 * IMPORTANTE — historial de dos correcciones sobre datos reales:
 *
 * 1. (27/jul) La primera versión resolvía "origen" desde
 *    `llamadas_historicas.clave_gene` + `emp_generadora.nombre_corto`, que
 *    en realidad es el CLIENTE que generó la solicitud (comercial), no la
 *    ubicación física de origen del Complemento Carta Porte.
 *
 * 2. (28/jul, guías PR-220189/PR-220190 de sicreGero) La segunda versión
 *    unía AMBOS extremos por `clave_gene_desti` contra
 *    `emp_destinataria.clave_desti` — funciona bien para DESTINO (se
 *    verificó contra `llamadas_historicas.clave_desti` y contra varias
 *    guías reales), pero para ORIGEN ese campo demostró ser NO CONFIABLE:
 *    puede apuntar a una fila de `emp_destinataria` sin relación real con
 *    la guía (en el caso reportado, decía "MIQUETLA 829" en vez de
 *    "CITRICOS SAAO S.A. DE C.V.", la empresa real de la Ubicación
 *    ORIGEN). La resolución correcta para ORIGEN es por RFC contra
 *    `emp_generadora.rfc` — pero solo cuando ese RFC resuelve a un único
 *    `nombre_corto` ahí (un RFC genérico de SAT para público en
 *    general/extranjero, o uno no registrado en el catálogo, da cero o
 *    varios resultados distintos): en ese caso se usa como respaldo el
 *    `nombre` completo de la propia Ubicación — no hay nombre corto
 *    disponible, pero es preferible mostrar el nombre real a mostrar el de
 *    una empresa equivocada. Ver consultarRutas()/nombreCortoOrigenPorRfc().
 *
 * 3. (11/ago, guías Whirlpool de sicrePR/sicreGero) El sufijo "(ciudad)"
 *    se armaba con `localidad` (código de catálogo SAT), que resultó NO
 *    CONFIABLE: para el registro maestro de Ubicación ORIGEN de Whirlpool
 *    (id OR300289, reutilizado en cientos de guías) quedó mal capturado
 *    como "TORREÓN" cuando la dirección real es Apodaca, Nuevo León —
 *    error a nivel del registro maestro, no de una guía puntual, así que
 *    se arrastraba a toda guía que lo reutilizara. `ciudad` (texto libre
 *    capturado junto con calle/CP) sí es consistente con la dirección
 *    real en todos los casos verificados, así que ahora tiene prioridad;
 *    `localidad` queda solo como respaldo si `ciudad` viene vacío. Ver
 *    conLocalidad().
 *
 * 4. (27/ago, guías PR-220481/PR-220482 de sicreGero) La resolución de
 *    DESTINO por `clave_gene_desti` contra `emp_destinataria.clave_desti`
 *    (nota #2) demostró ser el MISMO problema NO CONFIABLE ya visto en
 *    ORIGEN: la fila `clave_desti=265` tiene `rfc="QW12"` (placeholder de
 *    catálogo, no un RFC real) y `nombreCorto="WTF COMALES REYNOSA"` — sin
 *    relación con la guía real, cuyo Complemento Carta Porte trae RFC
 *    `API931215HZ3` (APIALTAMIRA) y nombre "ADMINISTRACION PORTUARIA
 *    INTEGRAL DE ALTAMIRA". Se corrige aplicando a DESTINO el mismo
 *    esquema que ya usa ORIGEN: resolver por RFC contra
 *    `emp_destinataria.rfc` solo cuando resuelve a un único `nombreCorto`,
 *    y caer al `nombre` completo de la propia Ubicación en cualquier otro
 *    caso (RFC sin match, o con varios nombres distintos). `clave_gene_desti`
 *    ya no se usa para resolver el nombre. Ver
 *    nombreCortoDestinoPorRfc()/consultarRutas().
 *
 * Nada de esto se persiste en ATLAS: es solo lectura, igual que el resto
 * de App\Sync.
 *
 * Usado por App\Timbrado\SolicitudTimbradoService para enriquecer el
 * drawer de autorización (trafico-system) y el mensaje de Mattermost de
 * una Solicitud de Timbrado con la ruta de cada guía, agrupada por
 * (origen, destino) — ver agruparPorRuta().
 */
final class RutaLookup
{
    use ResuelveFuenteSicret;

    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @param array<int, array{num_guia: string, source: string}> $guias
     * @return array<string, array{origen: string, destino: string}> num_guia => ruta
     */
    public function porNumGuia(array $guias): array
    {
        $porSource = [];

        foreach ($guias as $guia) {
            $porSource[$guia['source']][] = $guia['num_guia'];
        }

        $resultado = [];

        foreach ($porSource as $sourceName => $numGuias) {
            $source = $this->buscarFuente($this->sourceRegistry, $sourceName);

            if ($source === null) {
                continue;
            }

            foreach ($this->consultarRutas($source, $numGuias) as $numGuia => $ruta) {
                $resultado[$numGuia] = $ruta;
            }
        }

        return $resultado;
    }

    /**
     * Agrupa las guías por (origen, destino) de mayor a menor tamaño de
     * grupo — mismo orden que debe pintar tanto el drawer de autorización
     * como el mensaje de Mattermost (ver
     * App\Notifications\Consumers\Mattermost\Templates\TimbradoRequestedTemplate).
     * Empates de tamaño se resuelven por orden de aparición (usort es
     * estable desde PHP 8.0). Una guía sin ruta resoluble (SICRET sin
     * `llamadas_historicas` para ese folio, o inalcanzable) cae en su
     * propio grupo "N/A" en vez de romper el agrupado completo.
     *
     * @param array<int, array{guia_id?: int, num_guia: string, source: string}> $guias
     * @return array<int, array{origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string}>}>
     */
    public function agruparPorRuta(array $guias): array
    {
        $rutas = $this->porNumGuia($guias);
        $sinRuta = ['origen' => 'N/A', 'destino' => 'N/A'];

        $grupos = [];

        foreach ($guias as $guia) {
            $ruta = $rutas[$guia['num_guia']] ?? $sinRuta;

            if ($ruta['origen'] === '' && $ruta['destino'] === '') {
                $ruta = $sinRuta;
            }

            $clave = $ruta['origen'] . '→' . $ruta['destino'];

            if (!isset($grupos[$clave])) {
                $grupos[$clave] = ['origen' => $ruta['origen'], 'destino' => $ruta['destino'], 'guias' => []];
            }

            $grupos[$clave]['guias'][] = [
                'guia_id' => $guia['guia_id'] ?? null,
                'num_guia' => $guia['num_guia'],
            ];
        }

        $grupos = array_values($grupos);

        usort($grupos, static fn (array $a, array $b): int => count($b['guias']) <=> count($a['guias']));

        return $grupos;
    }

    /**
     * Agrupa por Cliente + Origen + Destino ("Grupo Inteligente") en vez de
     * solo por ruta — Sprint 1 de knowledge/sprint1_grupo_inteligente.md.
     * Se agrega como método nuevo, independiente de agruparPorRuta(), que
     * se deja intacto para no afectar a su único consumidor actual
     * (App\Timbrado\SolicitudTimbradoService, que sigue usándolo para
     * `rutas` sin ningún cambio de comportamiento).
     *
     * IMPORTANTE: esto NO agrupa CFDIs. Cada guía dentro de un grupo sigue
     * generando su propio CFDI con su propio Complemento Carta Porte — el
     * grupo es únicamente un contexto de captura para Facturación (ver
     * knowledge/auditoria_viabilidad_drawer_timbrado.md).
     *
     * @param array<int, array{guia_id?: int, num_guia: string, source: string}> $guias
     * @param array<string, array{clave_gene: ?int, nombre: string}> $clientes num_guia => cliente (App\Liberacion\ClienteLookup::conClaveGenePorNumGuia())
     * @return array<int, array{cliente: array{clave_gene: ?int, nombre: string}, origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string}>}>
     */
    public function agruparPorClienteYRuta(array $guias, array $clientes): array
    {
        $rutas = $this->porNumGuia($guias);

        return $this->combinarEnGrupos($guias, $clientes, $rutas);
    }

    /**
     * Núcleo puro del algoritmo de agrupación — sin I/O, para poder
     * probarse con datos de prueba sin tocar SICRET (ver
     * knowledge/sprint1_grupo_inteligente.md §11).
     *
     * Clave de agrupación: `clave_gene` del cliente cuando se pudo
     * resolver (identificador real, evita fusionar/separar por variaciones
     * de texto del nombre); si no, cae al nombre normalizado. Igual que
     * agruparPorRuta(), una guía sin ruta resoluble cae en el grupo
     * "N/A"→"N/A" en vez de romper el agrupado completo.
     *
     * @param array<int, array{guia_id?: int, num_guia: string}> $guias
     * @param array<string, array{clave_gene: ?int, nombre: string}> $clientes
     * @param array<string, array{origen: string, destino: string}> $rutas
     * @return array<int, array{cliente: array{clave_gene: ?int, nombre: string}, origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string}>}>
     */
    private function combinarEnGrupos(array $guias, array $clientes, array $rutas): array
    {
        $sinCliente = ['clave_gene' => null, 'nombre' => ''];
        $sinRuta = ['origen' => 'N/A', 'destino' => 'N/A'];

        $grupos = [];

        foreach ($guias as $guia) {
            $cliente = $clientes[$guia['num_guia']] ?? $sinCliente;
            $ruta = $rutas[$guia['num_guia']] ?? $sinRuta;

            if ($ruta['origen'] === '' && $ruta['destino'] === '') {
                $ruta = $sinRuta;
            }

            $claveCliente = $cliente['clave_gene'] !== null
                ? 'ID:' . $cliente['clave_gene']
                : 'NOMBRE:' . $cliente['nombre'];

            $clave = $claveCliente . '|' . $ruta['origen'] . '→' . $ruta['destino'];

            if (!isset($grupos[$clave])) {
                $grupos[$clave] = [
                    'cliente' => $cliente,
                    'origen' => $ruta['origen'],
                    'destino' => $ruta['destino'],
                    'guias' => [],
                ];
            }

            $grupos[$clave]['guias'][] = [
                'guia_id' => $guia['guia_id'] ?? null,
                'num_guia' => $guia['num_guia'],
            ];
        }

        $grupos = array_values($grupos);

        usort($grupos, static fn (array $a, array $b): int => count($b['guias']) <=> count($a['guias']));

        return $grupos;
    }

    /**
     * @param string[] $numGuias
     * @return array<string, array{origen: string, destino: string}>
     */
    private function consultarRutas(Source $source, array $numGuias): array
    {
        if ($numGuias === []) {
            return [];
        }

        try {
            $pdo = $source->connection();
            $placeholders = implode(',', array_fill(0, count($numGuias), '?'));

            $stmt = $pdo->prepare(
                "SELECT guia, tipo_ubic, nombre, rfc, ciudad, localidad
                 FROM tras_cartaporte_ubic
                 WHERE guia IN ({$placeholders})"
            );
            $stmt->execute(array_values($numGuias));
            $ubicaciones = $stmt->fetchAll(PDO::FETCH_ASSOC);

            $rfcsDestino = [];
            $rfcsOrigen = [];

            foreach ($ubicaciones as $u) {
                if ($u['tipo_ubic'] === 'DESTINO' && trim((string) $u['rfc']) !== '') {
                    $rfcsDestino[] = trim($u['rfc']);
                }

                if ($u['tipo_ubic'] === 'ORIGEN' && trim((string) $u['rfc']) !== '') {
                    $rfcsOrigen[] = trim($u['rfc']);
                }
            }

            $nombreCortoPorRfcDestino = $this->nombreCortoDestinoPorRfc($pdo, array_values(array_unique($rfcsDestino)));
            $nombreCortoPorRfcOrigen = $this->nombreCortoOrigenPorRfc($pdo, array_values(array_unique($rfcsOrigen)));

            $resultado = [];

            foreach ($ubicaciones as $u) {
                $numGuia = $u['guia'];
                $resultado[$numGuia] ??= ['origen' => '', 'destino' => ''];
                $ciudad = $this->normalizarTexto($u['ciudad']);
                $localidad = $this->normalizarTexto($u['localidad']);

                if ($u['tipo_ubic'] === 'ORIGEN') {
                    $rfc = trim((string) $u['rfc']);
                    // Sin nombre_corto único en emp_generadora (RFC
                    // genérico/no registrado, ver docblock de la clase):
                    // se cae al nombre completo de la propia Ubicación en
                    // vez de dejarlo vacío o mostrar una empresa ajena.
                    $nombre = $nombreCortoPorRfcOrigen[$rfc] ?? $this->normalizarTexto($u['nombre']);
                    $resultado[$numGuia]['origen'] = $this->conLocalidad($nombre, $ciudad, $localidad);
                }

                if ($u['tipo_ubic'] === 'DESTINO') {
                    $rfc = trim((string) $u['rfc']);
                    // Sin nombreCorto único en emp_destinataria (RFC
                    // placeholder de catálogo/no registrado, ver nota #4
                    // del docblock de la clase): se cae al nombre completo
                    // de la propia Ubicación en vez de mostrar una empresa
                    // ajena.
                    $nombre = $nombreCortoPorRfcDestino[$rfc] ?? $this->normalizarTexto($u['nombre']);
                    $resultado[$numGuia]['destino'] = $this->conLocalidad($nombre, $ciudad, $localidad);
                }
            }

            return $resultado;
        } catch (Throwable $e) {
            // SICRET inalcanzable u otro error de lectura no debe impedir
            // crear/consultar la solicitud — la ruta es información
            // complementaria, no un requisito para el flujo de negocio.
            $this->logger->error('No se pudo resolver origen/destino contra SICRET', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            return [];
        }
    }

    /**
     * Nombre corto del DESTINO por RFC — solo cuando ese RFC resuelve a un
     * único `nombreCorto` en `emp_destinataria`. Mismo esquema que
     * nombreCortoOrigenPorRfc(): un RFC placeholder de catálogo (p. ej.
     * "QW12") o uno que no está registrado ahí da cero o varios resultados
     * distintos — en ambos casos el llamador debe caer al nombre completo
     * de la propia Ubicación (ver consultarRutas() y nota #4 del docblock
     * de la clase).
     *
     * @param string[] $rfcs
     * @return array<string, string>
     */
    private function nombreCortoDestinoPorRfc(PDO $pdo, array $rfcs): array
    {
        if ($rfcs === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($rfcs), '?'));

        $stmt = $pdo->prepare(
            "SELECT rfc, MIN(nombreCorto) AS nombreCorto
             FROM emp_destinataria
             WHERE rfc IN ({$placeholders})
             GROUP BY rfc
             HAVING COUNT(DISTINCT nombreCorto) = 1"
        );
        $stmt->execute(array_values($rfcs));

        $resultado = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $resultado[$row['rfc']] = $this->normalizarTexto($row['nombreCorto']);
        }

        return $resultado;
    }

    /**
     * Nombre corto del ORIGEN por RFC — solo cuando ese RFC resuelve a un
     * único `nombre_corto` en `emp_generadora`. Un RFC genérico de SAT
     * (p. ej. "XXXXXXXXXX"/"XEXX010101000", público en general o
     * extranjero) o uno que no está registrado ahí da cero o varios
     * resultados distintos — en ambos casos el llamador debe caer al
     * nombre completo de la propia Ubicación (ver consultarRutas()).
     *
     * @param string[] $rfcs
     * @return array<string, string>
     */
    private function nombreCortoOrigenPorRfc(PDO $pdo, array $rfcs): array
    {
        if ($rfcs === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($rfcs), '?'));

        $stmt = $pdo->prepare(
            "SELECT rfc, MIN(nombre_corto) AS nombre_corto
             FROM emp_generadora
             WHERE rfc IN ({$placeholders})
             GROUP BY rfc
             HAVING COUNT(DISTINCT nombre_corto) = 1"
        );
        $stmt->execute(array_values($rfcs));

        $resultado = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $resultado[$row['rfc']] = $this->normalizarTexto($row['nombre_corto']);
        }

        return $resultado;
    }

    /**
     * `ciudad` (texto libre capturado junto con calle/CP, consistente con
     * la dirección real de la Ubicación) tiene prioridad sobre `localidad`
     * (código de catálogo SAT): ver corrección 3 en el docblock de la
     * clase — `localidad` puede quedar mal capturado a nivel del registro
     * maestro de Ubicación y arrastrarse a todas las guías que lo
     * reutilizan, aunque `ciudad`/`estado` sí sean correctos.
     */
    private function conLocalidad(string $nombre, string $ciudad, string $localidad): string
    {
        $sufijo = $ciudad !== '' ? $ciudad : $localidad;

        return $sufijo === '' ? $nombre : "{$nombre}({$sufijo})";
    }
}
