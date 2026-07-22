<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideStampFailed;

class GuideStampFailedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof GuideStampFailed;
    }

    public function render(DomainEvent $event): string
    {
        /** @var GuideStampFailed $event */
        return sprintf("❌ **Error en Timbrado de Guía**\n- Guía ID: %s\n- Fecha: %s", $event->guiaId, $event->getOccurredOn()->format('Y-m-d H:i:s'));
    }
}
