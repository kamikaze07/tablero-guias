<?php

declare(strict_types=1);

namespace App\Notifications\Consumers\Mattermost\Templates;

/**
 * Bloques "**Origen → Destino:**\n- PR..." para los mensajes de Mattermost
 * de Timbrado/Liberación, uno por grupo de App\Timbrado\RutaLookup::
 * agruparPorRuta() — centralizado aquí para que los 6 templates (Solicitada/
 * Aprobada/Rechazada de cada módulo) lo compartan en vez de repetir el
 * `sprintf` (nació en TimbradoRequestedTemplate, único que lo tenía antes).
 */
final class RutaBloque
{
    /**
     * @param array<int, array{origen: string, destino: string, guias: array<int, array{num_guia: string, contenedor?: ?string, cliente?: ?string}>}> $rutas
     */
    public static function lista(array $rutas): string
    {
        $bloques = [];

        foreach ($rutas as $ruta) {
            $bloques[] = sprintf("**%s → %s:**\n%s", $ruta['origen'], $ruta['destino'], GuiaLinea::lista($ruta['guias']));
        }

        return implode("\n\n", $bloques);
    }

    /**
     * Sección "PR" de los 6 templates: prioriza las rutas agrupadas
     * (origen/destino, ver lista()) sobre la lista plana de guías, y esta
     * sobre el `guiaId` crudo del evento — compatibilidad con disparos
     * antiguos/manuales que no traen ninguno de los dos. Las rutas ya
     * incluyen su propio encabezado por grupo, así que solo la lista plana
     * y el guiaId necesitan el literal "**PR:**".
     */
    public static function seccionPr(mixed $rutas, mixed $guias, string $guiaId): string
    {
        if (is_array($rutas) && $rutas !== []) {
            return self::lista($rutas);
        }

        if (is_array($guias) && $guias !== []) {
            return "**PR:**\n" . GuiaLinea::lista($guias);
        }

        return "**PR:**\n{$guiaId}";
    }
}
