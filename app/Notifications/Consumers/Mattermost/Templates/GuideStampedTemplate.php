<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideStamped;

class GuideStampedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof GuideStamped;
    }

    public function render(DomainEvent $event): string
    {
        /** @var GuideStamped $event */
        return sprintf("✅ **Guía Timbrada**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
