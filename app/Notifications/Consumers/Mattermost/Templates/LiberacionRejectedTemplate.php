<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\LiberacionRejected;

class LiberacionRejectedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof LiberacionRejected;
    }

    public function render(DomainEvent $event): string
    {
        /** @var LiberacionRejected $event */
        $pr = RutaBloque::seccionPr($event->data['rutas'] ?? null, $event->data['guias'] ?? null, $event->guiaId);
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $motivo = $event->data['motivo'] ?? 'Desconocido';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        return sprintf(
            "⛔ **LIBERACIÓN RECHAZADA**\n\n%s\n\n**Empresa:**\n%s\n\n**Usuario que rechazó:**\n%s\n\n**Motivo del rechazo:**\n> %s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $motivo, $fecha, $hora
        );
    }
}
