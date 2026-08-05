<?php

declare(strict_types=1);

namespace App\Reportes;

use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;
use Throwable;

/**
 * Folio fiscal (UUID) de un CFDI a partir de su folio corto, resuelto en
 * vivo contra `facturas33` en la fuente SICRET correspondiente
 * (sicrePR/sicreGero) — mismo patrón de acceso y misma tolerancia a fallos
 * que App\Liberacion\ContenedorLookup/SicretEstatusLookup: solo lectura,
 * nunca lanza, batch por `source` para evitar N consultas contra un host
 * remoto.
 *
 * Existe específicamente para el reporte de Guías Liberadas
 * (GuiasLiberadasReportRepository): el folio fiscal del CFDI *nuevo* ya
 * viene incluido en `sicret_write_log.detalle` de
 * `completar_datos_fiscales`, pero el del CFDI *anterior* nunca se capturó
 * — `PdoSicretGateway::liberar()` solo guardó el folio corto (ej.
 * "PR65259") antes de limpiar `factImpresa`. Este lookup cierra ese hueco
 * sin tocar el log existente.
 */
final class CfdiFolioFiscalLookup
{
    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @param array<int, array{folio: ?string, source: string}> $folios
     * @return array<string, string> "source|folio" => folioFiscal
     */
    public function porFolio(array $folios): array
    {
        $porSource = [];

        foreach ($folios as $item) {
            $folio = $item["folio"] ?? null;

            if ($folio === null || $folio === "") {
                continue;
            }

            $porSource[$item["source"]][] = $folio;
        }

        $resultado = [];

        foreach ($porSource as $sourceName => $foliosDeFuente) {
            $source = $this->buscarFuente($sourceName);

            if ($source === null) {
                continue;
            }

            foreach ($this->consultarFolioFiscal($source, array_values(array_unique($foliosDeFuente))) as $folio => $folioFiscal) {
                $resultado[$sourceName . "|" . $folio] = $folioFiscal;
            }
        }

        return $resultado;
    }

    /**
     * @param string[] $folios
     * @return array<string, string> folio => folioFiscal
     */
    private function consultarFolioFiscal(Source $source, array $folios): array
    {
        if ($folios === []) {
            return [];
        }

        try {
            $placeholders = implode(",", array_fill(0, count($folios), "?"));

            $stmt = $source->connection()->prepare(
                "SELECT folio, folioFiscal FROM facturas33 WHERE folio IN ({$placeholders})"
            );
            $stmt->execute(array_values($folios));

            $resultado = [];

            foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
                $folioFiscal = trim((string) $row["folioFiscal"]);

                if ($folioFiscal !== "") {
                    $resultado[$row["folio"]] = $folioFiscal;
                }
            }

            return $resultado;
        } catch (Throwable $e) {
            $this->logger->error("No se pudo resolver folio fiscal contra SICRET", [
                "source" => $source->name(),
                "error" => $e->getMessage(),
            ]);

            return [];
        }
    }

    private function buscarFuente(string $name): ?Source
    {
        foreach ($this->sourceRegistry->all() as $source) {
            if ($source->name() === $name) {
                return $source;
            }
        }

        return null;
    }
}
