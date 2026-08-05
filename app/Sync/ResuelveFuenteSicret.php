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

    /** SICRET trae de repente espacios NBSP (U+00A0) de relleno — trim() normal no los quita. */
    private function normalizarTexto(?string $valor): string
    {
        return trim(str_replace("\xC2\xA0", ' ', (string) $valor));
    }
}
