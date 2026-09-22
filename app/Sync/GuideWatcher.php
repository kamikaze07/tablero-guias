<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;
use PDOException;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Domain\Events\GuideCreated;

final class GuideWatcher implements Watcher
{
    private const TABLE = 'guias';
    private const BATCH_SIZE = 500;
    public const RECONCILIATION_LOOKBACK_NUM = 1000;
    public const RECONCILIATION_LOOKBACK_HOURS = 24;

    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

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
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
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

        // 1. Escaneo Primario de Guías Nuevas (num > checkpoint)
        do {
            $rows = $this->fetchBatch($source, $checkpoint, $isFirstRun);

            foreach ($rows as $row) {
                $record = GuiaRecord::fromSourceRow($source->name(), $row);
                $result = $this->guiaRepository->saveOrUpdate($record);

                $checkpoint = max($checkpoint, $record->sourceNum);
                $this->checkpointStore->update($source->name(), $checkpoint);

                if ($this->handleSyncResult($result, $record)) {
                    $synced++;
                }
            }

            if ($rows !== []) {
                $this->logger->info('Lote de guías sincronizado (Primary Scan)', [
                    'source' => $source->name(),
                    'lote' => count($rows),
                    'checkpoint' => $checkpoint,
                ]);
            }
        } while (count($rows) === self::BATCH_SIZE);

        // 2. Reconciliación Acotada de Números Reutilizados / Cambios (num <= checkpoint)
        if ($checkpoint > 0) {
            $synced += $this->reconcileSource($source, $checkpoint);
        }

        return $synced;
    }

    private function reconcileSource(Source $source, int $checkpoint): int
    {
        $minNum = max(1, $checkpoint - self::RECONCILIATION_LOOKBACK_NUM);
        $sinceTimestamp = (new \DateTimeImmutable(sprintf('-%d hours', self::RECONCILIATION_LOOKBACK_HOURS)))->format('Y-m-d H:i:s');

        $rows = $this->fetchReconciliationBatch($source, $minNum, $checkpoint, $sinceTimestamp);
        $synced = 0;

        foreach ($rows as $row) {
            $record = GuiaRecord::fromSourceRow($source->name(), $row);
            $result = $this->guiaRepository->saveOrUpdate($record);

            if ($this->handleSyncResult($result, $record)) {
                $synced++;
                $this->logger->info('Reconciliación detectó cambio/reutilización en guía', [
                    'status' => $result->status->value,
                    'source' => $record->source,
                    'source_num' => $record->sourceNum,
                    'num_guia' => $record->numGuia,
                    'fecha_c' => $record->fechaC->format('Y-m-d H:i:s'),
                ]);
            }
        }

        return $synced;
    }

    /**
     * Procesa el resultado de la sincronización y emite eventos diferenciados según el tipo de cambio.
     */
    private function handleSyncResult(SyncResult $result, GuiaRecord $record): bool
    {
        if ($result->isUnchanged() || $result->atlasId === null) {
            return false;
        }

        if ($result->isInserted() || $result->isReusedReplaced()) {
            $this->publishDetected($result->atlasId, $record);
        } elseif ($result->isUpdated()) {
            $this->publishUpdated($result->atlasId, $record);
        }

        return true;
    }

    private function publishDetected(int $atlasId, GuiaRecord $record): void
    {
        $this->eventPublisher->publish('guia.detectada', [
            'id' => $atlasId,
            'source' => $record->source,
            'num_guia' => $record->numGuia,
            'fecha' => $record->fecha->format('Y-m-d H:i:s'),
            'nombre' => $record->nombre,
            'tipo' => $record->tipo,
            'servicio' => $record->servicio,
            'placas1' => $record->placas1,
            'estado' => $record->estado,
            'operador' => $record->operador,
        ]);

        if ($this->dispatcher) {
            $this->dispatcher->dispatch(new GuideCreated($record->numGuia, [
                'id' => $atlasId,
                'source' => $record->source,
                'empresa' => $record->source,
                'fecha' => $record->fecha->format('Y-m-d H:i:s'),
                'estado' => $record->estado,
            ]));
        }
    }

    private function publishUpdated(int $atlasId, GuiaRecord $record): void
    {
        $this->eventPublisher->publish('guia.actualizada', [
            'id' => $atlasId,
            'source' => $record->source,
            'num_guia' => $record->numGuia,
            'fecha' => $record->fecha->format('Y-m-d H:i:s'),
            'nombre' => $record->nombre,
            'tipo' => $record->tipo,
            'servicio' => $record->servicio,
            'placas1' => $record->placas1,
            'estado' => $record->estado,
            'operador' => $record->operador,
        ]);
    }

    /** @return array<int, array<string, mixed>> */
    private function fetchBatch(Source $source, int $checkpoint, bool $isFirstRun): array
    {
        try {
            return $this->runFetchBatch($source, $checkpoint, $isFirstRun);
        } catch (PDOException $e) {
            if (!$this->isConnectionLost($e)) {
                throw $e;
            }

            $this->logger->error('Conexión perdida con la fuente, reconectando', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            $source->reconnect();

            return $this->runFetchBatch($source, $checkpoint, $isFirstRun);
        }
    }

    /** @return array<int, array<string, mixed>> */
    private function fetchReconciliationBatch(Source $source, int $minNum, int $checkpoint, string $sinceTimestamp): array
    {
        try {
            return $this->runFetchReconciliationBatch($source, $minNum, $checkpoint, $sinceTimestamp);
        } catch (PDOException $e) {
            if (!$this->isConnectionLost($e)) {
                throw $e;
            }

            $this->logger->error('Conexión perdida con la fuente durante reconciliación, reconectando', [
                'source' => $source->name(),
                'error' => $e->getMessage(),
            ]);

            $source->reconnect();

            return $this->runFetchReconciliationBatch($source, $minNum, $checkpoint, $sinceTimestamp);
        }
    }

    private function isConnectionLost(PDOException $e): bool
    {
        return in_array((int) ($e->errorInfo[1] ?? 0), self::CONNECTION_LOST_ERROR_CODES, true);
    }

    /** @return array<int, array<string, mixed>> */
    private function runFetchBatch(Source $source, int $checkpoint, bool $isFirstRun): array
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

    /** @return array<int, array<string, mixed>> */
    private function runFetchReconciliationBatch(Source $source, int $minNum, int $checkpoint, string $sinceTimestamp): array
    {
        $sql = 'SELECT ' . self::COLUMNS . ' FROM ' . self::TABLE . '
                WHERE num >= :min_num AND num <= :checkpoint AND fecha_c >= :since
                ORDER BY num ASC';

        $stmt = $source->connection()->prepare($sql);
        $stmt->bindValue(':min_num', $minNum, PDO::PARAM_INT);
        $stmt->bindValue(':checkpoint', $checkpoint, PDO::PARAM_INT);
        $stmt->bindValue(':since', $sinceTimestamp, PDO::PARAM_STR);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
