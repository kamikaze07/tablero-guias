<?php

declare(strict_types=1);

namespace App\Liberacion;

final class SolicitudLiberacionPayload
{
    /** @param string[] $numGuias */
    private function __construct(
        public readonly string $motivo,
        public readonly array $numGuias,
        public readonly ?string $source,
        public readonly ?string $solicitante,
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

        // Opcional a propósito (retrocompatible): si no viene, se preserva
        // el comportamiento de siempre (rechazar como ambiguo un num_guia
        // que exista en más de una fuente, ver
        // SolicitudLiberacionService::resolverGuias()). Cuando sí viene,
        // desambigua por fuente en vez de solo detectar la colisión — ver
        // knowledge/modules/solicitudes-liberacion/security.md §2.2, que ya
        // anticipaba este campo pendiente.
        $source = is_string($data['source'] ?? null) && trim($data['source']) !== ''
            ? trim($data['source'])
            : null;

        // Opcional a propósito (retrocompatible) — mismo campo y mismo
        // motivo que en SolicitudTimbradoPayload::fromArray(): identifica al
        // usuario real de trafico-system para las notificaciones de
        // Mattermost (ver App\Liberacion\SolicitudLiberacionService::crear());
        // sin esto, el actor quedaba fijo en "trafico-system" para toda
        // solicitud, sin importar quién la generó.
        $solicitante = is_string($data['solicitante'] ?? null) && trim($data['solicitante']) !== ''
            ? trim($data['solicitante'])
            : null;

        return new self($motivo, $numGuias, $source, $solicitante);
    }
}
