<?php

declare(strict_types=1);

namespace App\Monitoring;

use App\Monitoring\Evidence\Evidence;
use App\Sync\Watcher;

/**
 * Template method del patrón "buscar evidencia -> confirmar -> actualizar
 * estado -> emitir evento" (Principio 4 de ATLAS: nunca se asume que una
 * operación concluyó, siempre se confirma con evidencia objetiva del
 * sistema origen). Toda la parte común (iterar pendientes, decidir si
 * confirmar/fallar/reintentar) vive aquí una sola vez; cada Watcher
 * concreto solo implementa 4 métodos pequeños y específicos de su propio
 * proceso de negocio.
 *
 * implements App\Sync\Watcher (no una interfaz "Monitor" propia) para que
 * todo ATLAS comparta un único contrato de "unidad de trabajo periódica,
 * una pasada, cuenta de cambios confirmados" entre App\Sync y
 * App\Monitoring — decisión explícita para no duplicar un mismo concepto
 * bajo dos nombres.
 */
abstract class EvidenceWatcher implements Watcher
{
    final public function run(): int
    {
        $confirmados = 0;

        foreach ($this->pendientes() as $item) {
            $evidencia = $this->buscarEvidencia($item);

            if ($evidencia->estaConfirmada()) {
                $this->alConfirmar($item, $evidencia);
                $confirmados++;

                continue;
            }

            if ($evidencia->estaFallida()) {
                $this->alFallar($item, (string) $evidencia->motivoFalla());

                continue;
            }

            // Ni confirmada ni fallida: sigue pendiente, se reintenta en
            // el siguiente ciclo del MonitoringEngine — no es un error.
        }

        return $confirmados;
    }

    /** @return iterable<mixed> */
    abstract protected function pendientes(): iterable;

    abstract protected function buscarEvidencia(mixed $item): Evidence;

    abstract protected function alConfirmar(mixed $item, Evidence $evidencia): void;

    abstract protected function alFallar(mixed $item, string $motivo): void;
}
