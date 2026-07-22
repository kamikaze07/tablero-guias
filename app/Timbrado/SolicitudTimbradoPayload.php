<?php

declare(strict_types=1);

namespace App\Timbrado;

final class SolicitudTimbradoPayload
{
    /** @param string[] $numGuias */
    private function __construct(
        public readonly array $numGuias,
        public readonly ?string $solicitante,
    ) {
    }

    /**
     * Valida únicamente la forma del payload (tipos, campos obligatorios,
     * duplicados dentro del propio lote). No consulta la base de datos —
     * eso es responsabilidad de SolicitudTimbradoService, que resuelve cada
     * folio contra la tabla `guias` de ATLAS.
     *
     * A diferencia de SolicitudLiberacionPayload, no exige "motivo": Solicitar
     * Timbrado es un proceso independiente de Solicitar Liberación y su
     * contrato de negocio (definido por trafico-system) no contempla ese
     * campo — no se cambia el estado de la guía, solo se registra la
     * intención para que Facturación la atienda.
     *
     * @param array<string, mixed> $data
     */
    public static function fromArray(array $data): self
    {
        $guias = $data['guias'] ?? null;

        if (!is_array($guias) || $guias === []) {
            throw SolicitudTimbradoValidationException::guiasRequeridas();
        }

        $numGuias = [];

        foreach ($guias as $guia) {
            $numGuia = is_array($guia) && is_string($guia['num_guia'] ?? null)
                ? trim($guia['num_guia'])
                : '';

            if ($numGuia === '') {
                throw SolicitudTimbradoValidationException::payloadInvalido(
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
            throw SolicitudTimbradoValidationException::guiasDuplicadas($duplicadas);
        }

        $solicitante = is_string($data['solicitante'] ?? null) && trim($data['solicitante']) !== ''
            ? trim($data['solicitante'])
            : null;

        return new self($numGuias, $solicitante);
    }
}
