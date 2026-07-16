<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;

final class GuideWatcher implements Watcher
{
    private const TABLE = 'guias';
    private const BATCH_SIZE = 500;

    private const COLUMNS = <<<'SQL'
        num, num_guia, folio_imp, fecha, fecha_c, fecha_d, num_llama, estado,
        nombre, tipo, num_vale, diesel, servicio, rem1, placas1, rem2, placas2,
        estatus, pedido, comen_pre, factura, manifiesto, ticket1, tons1,
        ticket2, tons2, operador, prefactura, factimpresa, linea, km,
        claveproductoSat, claveUnidadSat, `do`, lid, actualizacion
        SQL;

    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly CheckpointStore $checkpointStore,
        private readonly GuiaRepository $guiaRepository,
        private readonly SyncLogger $logger,
    ) {
    }

    public function run(): int
    {
        $totalSynced = 0;

        foreach ($this->sourceRegistry->all() as $source) {
            $totalSynced += $this->syncSource($source);
        }

        return $totalSynced;
    }

    private function syncSource(Source $source): int
    {
        $checkpoint = $this->checkpointStore->get($source->name());
        $isFirstRun = $checkpoint === 0;
        $synced = 0;

        do {
            $rows = $this->fetchBatch($source, $checkpoint, $isFirstRun);

            foreach ($rows as $row) {
                $record = GuiaRecord::fromSourceRow($source->name(), $row);
                $inserted = $this->guiaRepository->insert($record);

                // El checkpoint solo avanza tras confirmar la inserción
                // (o confirmar que el registro ya existía en ATLAS).
                $checkpoint = $record->sourceNum;
                $this->checkpointStore->update($source->name(), $checkpoint);

                if ($inserted) {
                    $synced++;
                }
            }

            if ($rows !== []) {
                $this->logger->info('Lote sincronizado', [
                    'source' => $source->name(),
                    'lote' => count($rows),
                    'checkpoint' => $checkpoint,
                ]);
            }
        } while (count($rows) === self::BATCH_SIZE);

        return $synced;
    }

    /** @return array<int, array<string, mixed>> */
    private function fetchBatch(Source $source, int $checkpoint, bool $isFirstRun): array
    {
        $sql = 'SELECT ' . self::COLUMNS . ' FROM ' . self::TABLE . ' WHERE num > :checkpoint';

        if ($isFirstRun) {
            $sql .= ' AND fecha >= :today';
        }

        $sql .= ' ORDER BY num ASC LIMIT :batch';

        $stmt = $source->connection()->prepare($sql);
        $stmt->bindValue(':checkpoint', $checkpoint, PDO::PARAM_INT);

        if ($isFirstRun) {
            $stmt->bindValue(':today', (new \DateTimeImmutable('today'))->format('Y-m-d H:i:s'));
        }

        $stmt->bindValue(':batch', self::BATCH_SIZE, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
