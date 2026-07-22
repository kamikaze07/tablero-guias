<?php

namespace App\Domain\Events;

interface DomainEvent
{
    public function getEventName(): string;
    public function getOccurredOn(): \DateTimeImmutable;
    public function getPayload(): array;
}
