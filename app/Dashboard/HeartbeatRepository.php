<?php

declare(strict_types=1);

namespace App\Dashboard;

use PDO;

final class HeartbeatRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /** @return array<string, mixed>|null */
    public function latest(string $engineName): ?array
    {
        $stmt = $this->connection->prepare(
            'SELECT status, last_cycle_at, last_success_at, last_error
             FROM sync_heartbeat
             WHERE engine_name = :engine_name'
        );

        $stmt->execute(['engine_name' => $engineName]);
        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        return $row === false ? null : $row;
    }
}
