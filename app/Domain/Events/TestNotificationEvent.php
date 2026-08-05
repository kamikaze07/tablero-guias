<?php
namespace App\Domain\Events;

class TestNotificationEvent implements DomainEvent
{
    private \DateTimeImmutable $occurredOn;

    public function __construct()
    {
        $this->occurredOn = new \DateTimeImmutable();
    }

    public function getEventName(): string
    {
        return 'TestNotificationEvent';
    }

    public function getOccurredOn(): \DateTimeImmutable
    {
        return $this->occurredOn;
    }

    public function getPayload(): array
    {
        return [];
    }
}
