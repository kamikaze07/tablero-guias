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
        $pr = $event->guiaId;
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        return sprintf(
            "🆕 **NUEVA GUÍA CREADA**\n\n**PR:**\n%s\n\n**Empresa:**\n%s\n\n**Creada por:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );
    }
}
