<?php

namespace App\Domain\Events;

abstract class BaseDomainEvent implements DomainEvent
{
    protected \DateTimeImmutable $occurredOn;

    public function __construct()
    {
        $this->occurredOn = new \DateTimeImmutable();
    }

    public function getEventName(): string
    {
        $path = explode('\\', static::class);
        return array_pop($path);
    }

    public function getOccurredOn(): \DateTimeImmutable
    {
        return $this->occurredOn;
    }
}
