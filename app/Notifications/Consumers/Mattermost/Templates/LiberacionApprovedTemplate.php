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
        $pr = RutaBloque::seccionPr($event->data['rutas'] ?? null, $event->data['guias'] ?? null, $event->guiaId);
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        return sprintf(
            "✅ **LIBERACIÓN APROBADA**\n\n%s\n\n**Empresa:**\n%s\n\n**Usuario que aprobó:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );
    }
}
