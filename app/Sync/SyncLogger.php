<?php

declare(strict_types=1);

namespace App\Sync;

final class SyncLogger
{
    public function __construct(private readonly string $logFile)
    {
    }

    /** @param array<string, mixed> $context */
    public function info(string $message, array $context = []): void
    {
        $this->write('INFO', $message, $context);
    }

    /** @param array<string, mixed> $context */
    public function error(string $message, array $context = []): void
    {
        $this->write('ERROR', $message, $context);
    }

    /** @param array<string, mixed> $context */
    private function write(string $level, string $message, array $context): void
    {
        $line = sprintf(
            '[%s] %s: %s%s' . PHP_EOL,
            (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            $level,
            $message,
            $context === [] ? '' : ' ' . json_encode($context, JSON_UNESCAPED_UNICODE)
        );

        file_put_contents($this->logFile, $line, FILE_APPEND);
    }
}
