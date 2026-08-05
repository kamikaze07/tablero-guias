<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Sync\ResuelveFuenteSicret;
use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;
use Throwable;

/**
 * Cliente comercial que generó la solicitud de una guía, resuelto en vivo
 * contra SICRET — dato que ATLAS no sincroniza a `guias` (ver
 * App\Sync\GuideWatcher). Se arma consultando, en la fuente correspondiente
 * (sicrePR/sicreGero, ver App\Sync\SourceRegistry), `llamadas_historicas`
 * (`num_guia`) contra `emp_generadora` (`clave_gene` -> `nombre_corto`).
 *
 * Es exactamente el campo que App\Timbrado\RutaLookup documenta como el
 * error de su primera versión: se usó por accidente para resolver el
 * ORIGEN geográfico de la guía, cuando en realidad identifica al cliente
 * comercial que la generó — dato distinto, con su propio lugar en el
 * mensaje/tablero, nunca como sustituto de la ruta.
 *
 * `num_guia` puede repetirse en `llamadas_historicas` (varias llamadas
 * sobre la misma guía a lo largo de su ciclo de vida) — se toma la más
 * reciente (`num_llama` más alto).
 *
 * En App\Liberacion, no App\Timbrado, por el mismo motivo que
 * ContenedorLookup: resolver un dato de SICRET a partir de `num_guia`/
 * `source` es una operación genérica que no pertenece a ningún módulo de
 * negocio en particular — Timbrado y Liberación la necesitan por igual.
 */
final class ClienteLookup
{
    use ResuelveFuenteSicret;

    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @param array<int, array{num_guia: string, source: string}> $guias
     * @return array<string, string> num_guia => nombre corto del cliente (vacío si no se resolvió)
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

            foreach ($this->consultarClientes($source, $numGuias) as $numGuia => $cliente) {
                $resultado[$numGuia] = $cliente;
            }
        }

        return $resultado;
    }

    /**
     * @param string[] $numGuias
     * @return array<string, string>
     */
    private function consultarClientes(Source $source, array $numGuias): array
    {
        if ($numGuias === []) {
            return [];
        }

        try {
            $placeholders = implode(',', array_fill(0, count($numGuias), '?'));

            $stmt = $source->connection()->prepare(
                "SELECT lh.num_guia, eg.nombre_corto
                 FROM llamadas_historicas lh
                 JOIN emp_generadora eg ON eg.clave_gene = lh.clave_gene
                 WHERE lh.num_guia IN ({$placeholders})
                 ORDER BY lh.num_llama DESC"
            );
            $stmt->execute(array_values($numGuias));

            $resultado = [];

            foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
                // ORDER BY ... DESC arriba: la primera fila vista por
                // num_guia es la llamada más reciente, así que ??= descarta
                // las repeticiones más viejas sin necesidad de agrupar en SQL.
                $resultado[$row['num_guia']] ??= $this->normalizarTexto($row['nombre_corto']);
            }

            return $resultado;
        } catch (Throwable $e) {
            // Mismo criterio que App\Timbrado\RutaLookup: SICRET
            // inalcanzable no debe impedir crear/consultar la solicitud —
            // el cliente es información complementaria.
            $this->logger->error('No se pudo resolver cliente contra SICRET', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            return [];
        }
    }

    /**
     * Igual que porNumGuia(), pero además del nombre corto (para mostrar)
     * regresa `clave_gene` — el identificador real del cliente en
     * `emp_generadora`. Se agrega como método nuevo, sin tocar
     * porNumGuia()/consultarClientes(), porque `porNumGuia()` ya tiene
     * múltiples consumidores en producción (App\Liberacion\SolicitudLiberacionService,
     * App\Timbrado\SolicitudTimbradoService) que esperan un string plano
     * por guía — cambiar su forma de retorno los habría roto a todos.
     *
     * Uso previsto: App\Timbrado\RutaLookup::agruparPorClienteYRuta(), que
     * necesita un identificador de cliente más confiable que el nombre
     * corto (dos clientes reales distintos podrían compartir nombre corto;
     * el mismo cliente podría traer variaciones de captura en el nombre).
     *
     * @param array<int, array{num_guia: string, source: string}> $guias
     * @return array<string, array{clave_gene: ?int, nombre: string}> num_guia => datos del cliente
     */
    public function conClaveGenePorNumGuia(array $guias): array
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

            foreach ($this->consultarClientesConClave($source, $numGuias) as $numGuia => $cliente) {
                $resultado[$numGuia] = $cliente;
            }
        }

        return $resultado;
    }

    /**
     * @param string[] $numGuias
     * @return array<string, array{clave_gene: ?int, nombre: string}>
     */
    private function consultarClientesConClave(Source $source, array $numGuias): array
    {
        if ($numGuias === []) {
            return [];
        }

        try {
            $placeholders = implode(',', array_fill(0, count($numGuias), '?'));

            $stmt = $source->connection()->prepare(
                "SELECT lh.num_guia, eg.clave_gene, eg.nombre_corto
                 FROM llamadas_historicas lh
                 JOIN emp_generadora eg ON eg.clave_gene = lh.clave_gene
                 WHERE lh.num_guia IN ({$placeholders})
                 ORDER BY lh.num_llama DESC"
            );
            $stmt->execute(array_values($numGuias));

            $resultado = [];

            foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
                // Mismo criterio de deduplicación que consultarClientes():
                // la primera fila vista por num_guia es la llamada más
                // reciente (ORDER BY ... DESC).
                $resultado[$row['num_guia']] ??= [
                    'clave_gene' => $row['clave_gene'] !== null ? (int) $row['clave_gene'] : null,
                    'nombre' => $this->normalizarTexto($row['nombre_corto']),
                ];
            }

            return $resultado;
        } catch (Throwable $e) {
            $this->logger->error('No se pudo resolver cliente (con clave) contra SICRET', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            return [];
        }
    }
}
