<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Infrastructure\Sicret\SicretGateway;
use App\Monitoring\Evidence\Evidence;
use App\Monitoring\EvidenceWatcher;
use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;

/**
 * Completa `facturas33.folioFiscal`/`idccp` en SICRET a partir del XML del
 * CFDI ya generado — cierra la ventana entre "ya se timbró" y "alguien
 * copió el UUID/IdCCP a mano" (confirmado con datos reales: 27/jul había
 * 10 facturas del día sin este dato, con el XML ya disponible en la
 * carpeta OUT).
 *
 * Independiente a propósito de TimbradoConfirmationWatcher/
 * DirectStampingWatcher: consulta `facturas33` directo en SICRET (no las
 * tablas de ATLAS) porque ese es el único lugar que sabe, sin importar si
 * la guía pasó por una Solicitud de Timbrado o se timbró directo, qué
 * folios ya están esperando este dato. Si el parseo del XML falla aquí,
 * nunca afecta el estado de una solicitud ni el resto del Runtime.
 */
final class FiscalDataWatcher extends EvidenceWatcher
{
    private const DIAS_HACIA_ATRAS = 15;

    public function __construct(
        private readonly SourceRegistry $readSourceRegistry,
        private readonly FiscalDataEvidenceSource $evidenceSource,
        private readonly SicretGateway $sicretGateway,
        private readonly SyncLogger $logger,
    ) {
    }

    /** @return iterable<array{source: string, num_guia: string, folio: string}> */
    protected function pendientes(): iterable
    {
        $desde = (new \DateTimeImmutable('-' . self::DIAS_HACIA_ATRAS . ' days'))->format('Y-m-d H:i:s');

        foreach ($this->readSourceRegistry->all() as $source) {
            foreach ($this->pendientesDeFuente($source, $desde) as $pendiente) {
                yield $pendiente;
            }
        }
    }

    /** @return iterable<array{source: string, num_guia: string, folio: string}> */
    private function pendientesDeFuente(Source $source, string $desde): iterable
    {
        $stmt = $source->connection()->prepare(
            "SELECT folio, cartaporte AS num_guia
             FROM facturas33
             WHERE (folioFiscal = '' OR folioFiscal IS NULL)
               AND folio != ''
               AND cartaporte IS NOT NULL AND cartaporte != ''
               AND fecha >= :desde"
        );
        $stmt->execute(['desde' => $desde]);

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $fila) {
            yield [
                'source' => $source->name(),
                'num_guia' => (string) $fila['num_guia'],
                'folio' => (string) $fila['folio'],
            ];
        }
    }

    protected function buscarEvidencia(mixed $item): Evidence
    {
        return $this->evidenceSource->buscar($item);
    }

    /** @param array{source: string, num_guia: string, folio: string} $item */
    protected function alConfirmar(mixed $item, Evidence $evidencia): void
    {
        /** @var array{folioFiscal: string, idccp: ?string} $dato */
        $dato = $evidencia->dato();

        $actualizado = $this->sicretGateway->completarDatosFiscales(
            $item['source'],
            $item['num_guia'],
            $item['folio'],
            $dato['folioFiscal'],
            $dato['idccp'],
        );

        if ($actualizado) {
            $this->logger->info('FiscalDataWatcher: folioFiscal/idccp completados', [
                'source' => $item['source'],
                'num_guia' => $item['num_guia'],
                'folio' => $item['folio'],
            ]);
        }
    }

    /** @param array{source: string, num_guia: string, folio: string} $item */
    protected function alFallar(mixed $item, string $motivo): void
    {
        $this->logger->error('FiscalDataWatcher: no se pudo leer el XML', [
            'source' => $item['source'],
            'num_guia' => $item['num_guia'],
            'folio' => $item['folio'],
            'motivo' => $motivo,
        ]);
    }
}
