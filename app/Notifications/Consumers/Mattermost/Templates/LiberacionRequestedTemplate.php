<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\LiberacionRequested;

class LiberacionRequestedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof LiberacionRequested;
    }

    public function render(DomainEvent $event): string
    {
        /** @var LiberacionRequested $event */
        return sprintf("🔓 **Solicitud de Liberación**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
