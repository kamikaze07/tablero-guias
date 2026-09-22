<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

/**
 * Línea "- PR (Contenedor: X, Cliente: Y)" para las listas de guías en los
 * mensajes de Mattermost de Timbrado/Liberación — mismo criterio que
 * EmpresaLabel: centralizada aquí para que ningún template la repita.
 * Contenedor y Cliente se omiten cuando la guía no los trae (ver
 * App\Liberacion\ContenedorLookup / App\Liberacion\ClienteLookup, no toda
 * guía tiene los dos).
 */
final class GuiaLinea
{
    /** @param array{num_guia: string, contenedor?: ?string, cliente?: ?string} $guia */
    public static function desde(array $guia): string
    {
        $contenedor = self::sanearTexto(trim((string) ($guia['contenedor'] ?? '')));
        $cliente = self::sanearTexto(trim((string) ($guia['cliente'] ?? '')));

        $detalles = [];

        if ($contenedor !== '') {
            $detalles[] = "Contenedor: {$contenedor}";
        }

        if ($cliente !== '') {
            $detalles[] = "Cliente: {$cliente}";
        }

        return $detalles === []
            ? "- {$guia['num_guia']}"
            : "- {$guia['num_guia']} (" . implode(', ', $detalles) . ')';
    }

    /** @param array<int, array{num_guia: string, contenedor?: ?string, cliente?: ?string}> $guias */
    public static function lista(array $guias): string
    {
        return implode("\n", array_map([self::class, 'desde'], $guias));
    }

    private static function sanearTexto(string $texto): string
    {
        if (str_contains($texto, "\xC3\x83") || str_contains($texto, "\xC3\x82")) {
            $reparado = @mb_convert_encoding($texto, 'ISO-8859-1', 'UTF-8');
            if ($reparado !== false && mb_check_encoding($reparado, 'UTF-8')) {
                return $reparado;
            }
        }
        return $texto;
    }
}
