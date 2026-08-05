<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\TimbradoRequested;

class TimbradoRequestedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof TimbradoRequested;
    }

    public function render(DomainEvent $event): string
    {
        /** @var TimbradoRequested $event */
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        // Agrupado por (origen, destino) — ver
        // App\Timbrado\RutaLookup::agruparPorRuta() / RutaBloque::seccionPr().
        $pr = RutaBloque::seccionPr($event->data['rutas'] ?? null, null, $event->guiaId);

        return sprintf(
            "📄 **SOLICITUD DE TIMBRADO**\n\n%s\n\n**Empresa:**\n%s\n\n**Usuario que solicita:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );
    }
}
