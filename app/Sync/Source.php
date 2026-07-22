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

    /**
     * Descarta la conexión activa para forzar que la próxima llamada a
     * connection() abra una conexión nueva. Usado cuando la conexión
     * cacheada murió (p. ej. "MySQL server has gone away") y no se
     * detectaría de otro modo hasta el próximo reinicio del proceso.
     */
    public function reconnect(): void
    {
        $this->connection = null;
    }
}
