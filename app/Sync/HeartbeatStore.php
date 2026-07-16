<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;

final class HeartbeatStore
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Registra el resultado de un ciclo del SynchronizationEngine.
     * `last_success_at` solo avanza cuando el ciclo no tuvo error.
     */
    public function recordCycle(string $engineName, string $status, int $recordsSynced, ?string $error = null): void
    {
        $now = (new \DateTimeImmutable())->format('Y-m-d H:i:s');
        $lastSuccessAt = $error === null ? $now : null;

        $stmt = $this->connection->prepare(
            'INSERT INTO sync_heartbeat
                (engine_name, status, last_cycle_at, last_success_at, last_error, cycles_completed, records_synced_total)
             VALUES
                (:engine_name, :status, :last_cycle_at, :last_success_at, :last_error, 1, :records_synced)
             ON DUPLICATE KEY UPDATE
                status = VALUES(status),
                last_cycle_at = VALUES(last_cycle_at),
                last_success_at = COALESCE(VALUES(last_success_at), last_success_at),
                last_error = VALUES(last_error),
                cycles_completed = cycles_completed + 1,
                records_synced_total = records_synced_total + VALUES(records_synced_total)'
        );

        $stmt->execute([
            'engine_name' => $engineName,
            'status' => $status,
            'last_cycle_at' => $now,
            'last_success_at' => $lastSuccessAt,
            'last_error' => $error,
            'records_synced' => $recordsSynced,
        ]);
    }
}
