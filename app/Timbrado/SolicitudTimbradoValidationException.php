<?php

declare(strict_types=1);

namespace App\Timbrado;

final class SolicitudTimbradoValidationException extends \RuntimeException
{
    /** @param array<string, mixed> $context */
    private function __construct(
        public readonly string $errorCode,
        public readonly int $httpStatus,
        string $message,
        public readonly array $context = [],
    ) {
        parent::__construct($message);
    }

    public static function payloadInvalido(string $detalle): self
    {
        return new self('payload_invalido', 400, $detalle);
    }

    public static function guiasRequeridas(): self
    {
        return new self('guias_requeridas', 400, 'Debe incluir al menos una guía en "guias".');
    }

    /** @param string[] $numGuias */
    public static function guiasDuplicadas(array $numGuias): self
    {
        return new self(
            'guias_duplicadas',
            400,
            'El lote contiene guías repetidas.',
            ['guias' => $numGuias],
        );
    }

    /** @param string[] $numGuias */
    public static function guiaNoEncontrada(array $numGuias): self
    {
        return new self(
            'guia_no_encontrada',
            404,
            'Una o más guías no existen en ATLAS.',
            ['guias' => $numGuias],
        );
    }

    /** @param string[] $sources */
    public static function guiaAmbigua(string $numGuia, array $sources): self
    {
        return new self(
            'guia_ambigua',
            409,
            'La guía existe en más de una fuente y no puede resolverse de forma única.',
            ['num_guia' => $numGuia, 'sources' => $sources],
        );
    }

    public static function solicitudNoEncontrada(int $id): self
    {
        return new self(
            'solicitud_no_encontrada',
            404,
            "No existe una solicitud con id {$id}.",
        );
    }

    public static function solicitudNoPendiente(int $id, string $estadoActual): self
    {
        return new self(
            'solicitud_no_pendiente',
            409,
            "La solicitud {$id} no puede procesarse porque su estado es {$estadoActual}.",
            ['estado' => $estadoActual],
        );
    }

    public static function motivoRechazoRequerido(): self
    {
        return new self(
            'motivo_rechazo_requerido',
            400,
            'Se requiere un motivo para rechazar la solicitud.',
        );
    }

    public static function accionInvalida(string $accion): self
    {
        return new self(
            'accion_invalida',
            400,
            "La acción '{$accion}' no es válida.",
        );
    }
}
