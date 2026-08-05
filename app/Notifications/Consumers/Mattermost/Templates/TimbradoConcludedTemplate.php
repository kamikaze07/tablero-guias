<?php

declare(strict_types=1);

namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\TimbradoConcluded;

class TimbradoConcludedTemplate implements MattermostTemplate
{
    public function supports(DomainEvent $event): bool
    {
        return $event instanceof TimbradoConcluded;
    }

    public function render(DomainEvent $event): string
    {
        /** @var TimbradoConcluded $event */
        $pr = RutaBloque::seccionPr($event->data['rutas'] ?? null, $event->data['guias'] ?? null, $event->guiaId);
        $empresa = EmpresaLabel::desde($event->data['empresa'] ?? null);
        $usuario = $event->data['usuario'] ?? 'Sistema';
        $fecha = $event->getOccurredOn()->format('d/m/Y');
        $hora = $event->getOccurredOn()->format('H:i:s');

        return sprintf(
            "✅ **TIMBRADO CONCLUIDO**\n\n%s\n\n**Empresa:**\n%s\n\n**Usuario que realizó el timbrado:**\n%s\n\n**Fecha:**\n%s\n\n**Hora:**\n%s",
            $pr, $empresa, $usuario, $fecha, $hora
        );
    }
}
