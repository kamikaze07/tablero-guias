<?php
namespace App\Notifications\Contracts;

use App\Domain\Events\DomainEvent;

interface EventConsumer
{
    public function handle(DomainEvent $event): void;
    public function supports(DomainEvent $event): bool;
}
