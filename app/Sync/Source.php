<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;

final class Source
{
    private ?PDO $connection = null;

    public function __construct(
        private readonly string $name,
        private readonly \Closure $connectionFactory,
    ) {
    }

    public function name(): string
    {
        return $this->name;
    }

    public function connection(): PDO
    {
        return $this->connection ??= ($this->connectionFactory)();
    }
}
