<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideCreated;

class GuideCreatedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof GuideCreated;
    }

    public function render(DomainEvent $event): string
    {
        /** @var GuideCreated $event */
        return sprintf("🆕 **Nueva Guía Creada**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
