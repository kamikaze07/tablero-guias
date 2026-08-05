<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

/**
 * Traduce el `source` crudo de SICRET (p. ej. "sicrePR", "sicreGero") al
 * nombre de empresa que reconoce el usuario de negocio — mismo criterio que
 * `empresaLabel()` en public/assets/js/facturacion.js, aquí centralizado
 * para que ningún MattermostTemplate lo repita.
 *
 * Admite una lista separada por comas (ver
 * SolicitudTimbradoService::resolverEmpresas() / SolicitudLiberacionService
 * equivalente) para el caso, poco común, de un lote de guías que mezcla
 * fuentes.
 */
final class EmpresaLabel
{
    public static function desde(?string $source): string
    {
        if ($source === null || trim($source) === '') {
            return 'N/A';
        }

        $labels = array_map(
            static fn (string $token): string => str_contains(strtolower(trim($token)), 'gero') ? 'GERO' : 'FORSIS',
            explode(',', $source),
        );

        return implode(', ', array_unique($labels));
    }
}
