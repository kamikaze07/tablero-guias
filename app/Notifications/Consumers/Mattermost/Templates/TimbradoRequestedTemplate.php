<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\TimbradoRequested;

class TimbradoRequestedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof TimbradoRequested;
    }

    public function render(DomainEvent $event): string
    {
        /** @var TimbradoRequested $event */
        return sprintf("🔔 **Solicitud de Timbrado**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
