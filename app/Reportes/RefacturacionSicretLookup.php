<?php

declare(strict_types=1);

namespace App\Reportes;

use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;
use Throwable;

/**
 * Cierra el mismo hueco que CfdiFolioFiscalLookup pero para el CFDI *nuevo*
 * del reporte de Guías Liberadas: `GuiasLiberadasReportRepository` solo
 * encuentra folio/folioFiscal nuevos cuando `FiscalDataWatcher` tuvo que
 * completar un `facturas33.folioFiscal` vacío (queda en
 * `sicret_write_log.completar_datos_fiscales`). Cuando la factura nueva ya
 * nace con folioFiscal lleno (el caso normal de timbrado) ese watcher nunca
 * la toca, nunca se escribe el log, y el reporte marcaba "Pendiente de
 * refacturar" para siempre aunque SICRET ya tuviera el dato correcto —
 * confirmado 2026-07-31 contra PR-226052..056 (source sicrePR): las 5 ya
 * tenían folioFiscal desde el timbrado mismo, sin ninguna fila de
 * completar_datos_fiscales.
 *
 * Resuelve en vivo contra `facturas33`, misma tolerancia a fallos que
 * CfdiFolioFiscalLookup/SicretEstatusLookup: solo lectura, nunca lanza.
 */
final class RefacturacionSicretLookup
{
    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @param array<int, array{num_guia: string, source: string, despues_de: string}> $items
     * @return array<string, array{folio: string, folioFiscal: ?string}> clave() => datos
     */
    public function porGuia(array $items): array
    {
        $resultado = [];

        foreach ($items as $item) {
            $source = $this->buscarFuente($item['source']);

            if ($source === null) {
                continue;
            }

            $dato = $this->consultarFacturaNueva($source, $item['num_guia'], $item['despues_de']);

            if ($dato !== null) {
                $resultado[self::clave($item)] = $dato;
            }
        }

        return $resultado;
    }

    /**
     * Bug real (confirmado 2026-08-10, PR-226593/594): una guía puede
     * liberarse y refacturarse más de una vez en su historia. Antes esta
     * clave era solo "source|num_guia" — con dos solicitudes pendientes
     * para la MISMA guía en el mismo lote de porGuia(), la segunda pisaba
     * el resultado de la primera en $resultado, y ambas solicitudes
     * terminaban persistiendo (write-once, ver
     * GuiasLiberadasReportRepository::persistirRefacturacion()) el mismo
     * CFDI "nuevo" incorrecto para una de las dos. Se agrega `despues_de`
     * (el `confirmed_at` de ESA solicitud específica) a la clave para que
     * cada solicitud resuelva y persista su propio resultado sin pisar el
     * de otra liberación anterior/posterior de la misma guía.
     *
     * @param array{num_guia: string, source: string, despues_de: string} $item
     */
    public static function clave(array $item): string
    {
        return $item['source'] . '|' . $item['num_guia'] . '|' . $item['despues_de'];
    }

    /**
     * La factura nueva es la primera que aparece en `facturas33` para este
     * `num_guia` después de `confirmed_at` de esta liberación específica —
     * mismo criterio de "la más próxima después" que ya usa
     * GuiasLiberadasReportRepository para correlacionar con el log.
     *
     * @return ?array{folio: string, folioFiscal: ?string}
     */
    private function consultarFacturaNueva(Source $source, string $numGuia, string $despuesDe): ?array
    {
        try {
            $stmt = $source->connection()->prepare(
                'SELECT folio, folioFiscal FROM facturas33
                 WHERE cartaporte = :num_guia AND fecha > :despues_de
                 ORDER BY fecha ASC LIMIT 1'
            );
            $stmt->execute(['num_guia' => $numGuia, 'despues_de' => $despuesDe]);

            $row = $stmt->fetch(PDO::FETCH_ASSOC);

            if ($row === false) {
                return null;
            }

            $folioFiscal = trim((string) $row['folioFiscal']);

            return [
                'folio' => (string) $row['folio'],
                'folioFiscal' => $folioFiscal !== '' ? $folioFiscal : null,
            ];
        } catch (Throwable $e) {
            $this->logger->error('No se pudo resolver refacturación contra SICRET', [
                'source' => $source->name(),
                'num_guia' => $numGuia,
                'error' => $e->getMessage(),
            ]);

            return null;
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
