<?php

declare(strict_types=1);

namespace App\Liberacion;

final class SolicitudLiberacionPayload
{
    /** @param string[] $numGuias */
    private function __construct(
        public readonly string $motivo,
        public readonly array $numGuias,
    ) {
    }

    /**
     * Valida únicamente la forma del payload (tipos, campos obligatorios,
     * duplicados dentro del propio lote). No consulta la base de datos —
     * eso es responsabilidad de SolicitudLiberacionService, que resuelve
     * cada folio contra la tabla `guias` de ATLAS.
     *
     * @param array<string, mixed> $data
     */
    public static function fromArray(array $data): self
    {
        $motivo = is_string($data['motivo'] ?? null) ? trim($data['motivo']) : '';

        if ($motivo === '') {
            throw SolicitudLiberacionValidationException::motivoRequerido();
        }

        $guias = $data['guias'] ?? null;

        if (!is_array($guias) || $guias === []) {
            throw SolicitudLiberacionValidationException::guiasRequeridas();
        }

        $numGuias = [];

        foreach ($guias as $guia) {
            $numGuia = is_array($guia) && is_string($guia['num_guia'] ?? null)
                ? trim($guia['num_guia'])
                : '';

            if ($numGuia === '') {
                throw SolicitudLiberacionValidationException::payloadInvalido(
                    'Cada elemento de "guias" debe incluir un "num_guia" no vacío.'
                );
            }

            $numGuias[] = $numGuia;
        }

        $duplicadas = array_keys(array_filter(
            array_count_values($numGuias),
            static fn (int $veces): bool => $veces > 1,
        ));

        if ($duplicadas !== []) {
            throw SolicitudLiberacionValidationException::guiasDuplicadas($duplicadas);
        }

        return new self($motivo, $numGuias);
    }
}
