<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\TestNotificationEvent;

class TestNotificationTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof TestNotificationEvent;
    }

    public function render(DomainEvent $event): string
    {
        return "Mensaje de prueba desde ATLAS.\n\nProbando funcionalidad de notificaciones con la nueva plataforma.";
    }
}
