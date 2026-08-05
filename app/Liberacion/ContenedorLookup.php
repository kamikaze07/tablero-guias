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
 * Contenedor(es) de una guía, resuelto en vivo contra SICRET — dato que
 * ATLAS no sincroniza a `guias` (ver App\Sync\GuideWatcher). Se arma
 * consultando, en la fuente correspondiente (sicrePR/sicreGero, ver
 * App\Sync\SourceRegistry), `tras_cartaporte_mercancias_contenedores`
 * (`guia` = num_guia, columna `matricula`).
 *
 * En App\Liberacion (no App\Timbrado, aunque nació para ese módulo) por el
 * mismo motivo que GuiaLookupRepository vive aquí: resolver un dato de
 * SICRET a partir de `num_guia`/`source` es una operación genérica que no
 * pertenece a ningún módulo de negocio en particular — Timbrado y
 * Liberación la necesitan por igual (tablero de Tráfico, tablero y avisos
 * de Facturación, Mattermost).
 *
 * No confundir con App\Timbrado\RutaLookup (origen/destino): dato
 * distinto, tabla distinta, pero mismo patrón de acceso solo-lectura y
 * misma tolerancia a que SICRET no responda (nunca bloquea el flujo de
 * negocio por un dato complementario).
 *
 * La inmensa mayoría de guías trae un solo contenedor, pero existen casos
 * reales con dos — se devuelven todas las matrículas encontradas, unidas
 * por ", " al servirse (ver agruparPorGuia()), nunca se trunca a la
 * primera.
 */
final class ContenedorLookup
{
    use ResuelveFuenteSicret;

    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @param array<int, array{num_guia: string, source: string}> $guias
     * @return array<string, string> num_guia => "MATRICULA1, MATRICULA2" (vacío si no se encontró ninguna)
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

            foreach ($this->consultarContenedores($source, $numGuias) as $numGuia => $matriculas) {
                $resultado[$numGuia] = implode(', ', $matriculas);
            }
        }

        return $resultado;
    }

    /**
     * @param string[] $numGuias
     * @return array<string, string[]> num_guia => matrículas
     */
    private function consultarContenedores(Source $source, array $numGuias): array
    {
        if ($numGuias === []) {
            return [];
        }

        try {
            $placeholders = implode(',', array_fill(0, count($numGuias), '?'));

            $stmt = $source->connection()->prepare(
                "SELECT guia, matricula
                 FROM tras_cartaporte_mercancias_contenedores
                 WHERE guia IN ({$placeholders})
                 ORDER BY num_conte ASC"
            );
            $stmt->execute(array_values($numGuias));

            $resultado = [];

            foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
                $matricula = $this->normalizarTexto($row['matricula']);

                if ($matricula === '') {
                    continue;
                }

                // Duplicados reales en SICRET (mismo `guia` + `matricula`
                // en dos filas de tras_cartaporte_mercancias_contenedores,
                // visto en datos de producción) — nunca se repite la misma
                // matrícula dos veces para una guía.
                if (!in_array($matricula, $resultado[$row['guia']] ?? [], true)) {
                    $resultado[$row['guia']][] = $matricula;
                }
            }

            return $resultado;
        } catch (Throwable $e) {
            // Mismo criterio que App\Timbrado\RutaLookup: SICRET
            // inalcanzable no debe impedir crear/consultar la solicitud —
            // el contenedor es información complementaria.
            $this->logger->error('No se pudo resolver contenedor contra SICRET', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            return [];
        }
    }
}
