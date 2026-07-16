<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;

final class CheckpointStore
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Devuelve el último `num` de origen confirmado en ATLAS para la fuente.
     * 0 significa que la fuente nunca se ha sincronizado.
     */
    public function get(string $source): int
    {
        $stmt = $this->connection->prepare(
            'SELECT last_num FROM sync_checkpoints WHERE source = :source'
        );
        $stmt->execute(['source' => $source]);
        $value = $stmt->fetchColumn();

        return $value === false ? 0 : (int) $value;
    }

    /**
     * Avanza el checkpoint de la fuente. Nunca lo retrocede, incluso si
     * se invoca fuera de orden.
     */
    public function update(string $source, int $lastNum): void
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO sync_checkpoints (source, last_num)
             VALUES (:source, :last_num)
             ON DUPLICATE KEY UPDATE last_num = GREATEST(last_num, VALUES(last_num))'
        );

        $stmt->execute([
            'source' => $source,
            'last_num' => $lastNum,
        ]);
    }
}
