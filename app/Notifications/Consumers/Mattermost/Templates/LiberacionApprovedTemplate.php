<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\LiberacionApproved;

class LiberacionApprovedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof LiberacionApproved;
    }

    public function render(DomainEvent $event): string
    {
        /** @var LiberacionApproved $event */
        return sprintf("✅ **Liberación Aprobada**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
