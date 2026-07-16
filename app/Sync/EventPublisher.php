<?php

declare(strict_types=1);

namespace App\Sync;

interface EventPublisher
{
    /** @param array<string, mixed> $payload */
    public function publish(string $event, array $payload): void;
}
