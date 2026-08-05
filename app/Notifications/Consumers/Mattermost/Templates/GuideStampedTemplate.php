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
        $pr = $event->guiaId;
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');
        $nota = $event->data['nota'] ?? null;

        $mensaje = sprintf(
            "✅ **PR TIMBRADO**\n\n**PR:**\n%s\n\n**Empresa:**\n%s\n\n**Usuario que realizó el timbrado:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );

        if ($nota !== null) {
            $mensaje .= sprintf("\n\n**Observación:**\n%s", $nota);
        }

        return $mensaje;
    }
}
