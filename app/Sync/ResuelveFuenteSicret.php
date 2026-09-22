<?php

declare(strict_types=1);

namespace App\Sync;

/**
 * Búsqueda de una Source por nombre + normalización de texto crudo de
 * SICRET (NBSP de relleno) — repetido igual en cada lookup de solo-lectura
 * contra SICRET (RutaLookup, ContenedorLookup, ClienteLookup) antes de esta
 * extracción.
 */
trait ResuelveFuenteSicret
{
    private function buscarFuente(SourceRegistry $sourceRegistry, string $name): ?Source
    {
        foreach ($sourceRegistry->all() as $source) {
            if ($source->name() === $name) {
                return $source;
            }
        }

        return null;
    }

    /** SICRET trae de repente espacios NBSP (U+00A0) de relleno y doble codificación UTF-8. */
    private function normalizarTexto(?string $valor): string
    {
        if ($valor === null) {
            return '';
        }

        $str = (string) $valor;

        if (str_contains($str, "\xC3\x83") || str_contains($str, "\xC3\x82")) {
            $reparado = @mb_convert_encoding($str, 'Windows-1252', 'UTF-8');
            if ($reparado !== false && mb_check_encoding($reparado, 'UTF-8')) {
                $str = $reparado;
            }
        }

        return trim(str_replace(["\xC2\xA0", "\xA0"], ' ', $str));
    }
}
