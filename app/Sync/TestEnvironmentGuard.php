<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;
use RuntimeException;

final class TestEnvironmentGuard
{
    /**
     * Garantiza técnicamente que ninguna prueba se ejecute contra la base de datos de producción.
     * Si la conexión detecta la base de datos 'atlas', 'sicrePR' o 'sicreGero', detiene la ejecución inmediatamente.
     */
    public static function assertSafeTestEnvironment(PDO $connection, string $databaseName): void
    {
        $currentDb = strtolower(trim($databaseName));

        if ($currentDb === 'atlas' || $currentDb === 'sicrepr' || $currentDb === 'sicregero') {
            throw new RuntimeException(sprintf(
                'FATAL SECURITY GUARD: Test suite is refusing to execute against production database "%s". All automated tests MUST connect to an isolated test database (e.g. atlas_test).',
                $databaseName
            ));
        }

        $stmt = $connection->query('SELECT DATABASE()');
        $activeDb = strtolower((string) $stmt->fetchColumn());

        if ($activeDb === 'atlas' || $activeDb === 'sicrepr' || $activeDb === 'sicregero') {
            throw new RuntimeException(sprintf(
                'FATAL SECURITY GUARD: Active PDO session is connected to production database "%s". Execution halted immediately.',
                $activeDb
            ));
        }
    }
}
