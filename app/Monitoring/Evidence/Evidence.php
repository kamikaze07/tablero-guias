<?php

declare(strict_types=1);

namespace App\Monitoring\Evidence;

/**
 * Resultado uniforme de buscar evidencia de que una operación concluyó,
 * sin importar el origen (base de datos SICRET, sistema de archivos, y en
 * el futuro una API o cola de mensajes) — EvidenceWatcher::run() decide
 * qué hacer solo con esta forma, nunca con el origen concreto.
 *
 * Exactamente uno de los tres estados aplica: pendiente (ni confirmada ni
 * fallida — se reintentará en el siguiente ciclo), confirmada, o fallida.
 */
final class Evidence
{
    private function __construct(
        private readonly bool $confirmada,
        private readonly bool $fallida,
        private readonly ?string $motivoFalla,
        private readonly mixed $dato,
    ) {
    }

    public static function pendiente(): self
    {
        return new self(false, false, null, null);
    }

    public static function confirmada(mixed $dato = null): self
    {
        return new self(true, false, null, $dato);
    }

    public static function fallida(string $motivo, mixed $dato = null): self
    {
        return new self(false, true, $motivo, $dato);
    }

    public function estaConfirmada(): bool
    {
        return $this->confirmada;
    }

    public function estaFallida(): bool
    {
        return $this->fallida;
    }

    public function motivoFalla(): ?string
    {
        return $this->motivoFalla;
    }

    /** Dato crudo de la evidencia (p. ej. la fila de SICRET, o la ruta del archivo encontrado), para bitácora/auditoría. */
    public function dato(): mixed
    {
        return $this->dato;
    }
}
