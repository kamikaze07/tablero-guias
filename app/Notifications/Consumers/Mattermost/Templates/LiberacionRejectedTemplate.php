<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\LiberacionRejected;

class LiberacionRejectedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof LiberacionRejected;
    }

    public function render(DomainEvent $event): string
    {
        /** @var LiberacionRejected $event */
        return sprintf("❌ **Liberación Rechazada**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
