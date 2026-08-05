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
        $pr = RutaBloque::seccionPr($event->data['rutas'] ?? null, $event->data['guias'] ?? null, $event->guiaId);
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        return sprintf(
            "🔓 **SOLICITUD DE LIBERACIÓN**\n\n%s\n\n**Empresa:**\n%s\n\n**Usuario que solicita:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );
    }
}
