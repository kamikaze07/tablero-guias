<?php

declare(strict_types=1);

namespace App\Liberacion\Execution;

use App\Infrastructure\Sicret\SicretGateway;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use App\Sync\Watcher;

/**
 * Orquestación de dominio de Liberación: decide CUÁNDO ejecutar (hay una
 * solicitud APROBADA, ver Principio de "Sicret no debe conocer el
 * dominio") y QUÉ pedir (qué guías, con qué source), pero nunca CÓMO se
 * escribe en SICRET — eso es responsabilidad exclusiva de SicretGateway,
 * inyectado como interfaz.
 *
 * implements App\Sync\Watcher porque, mecánicamente, es la misma forma
 * que cualquier otra unidad de trabajo periódica de ATLAS (una pasada,
 * cuenta de resultados) — corre dentro del mismo proceso/motor que
 * App\Monitoring\Liberacion\LiberationConfirmationWatcher
 * (bin/monitoring-engine.php), aunque conceptualmente es "Ejecución", no
 * "Monitoreo": aquí se decide y se actúa, en el otro solo se confirma.
 *
 * PENDIENTE (fuera de alcance de este sprint): no existe todavía ningún
 * componente que escriba solicitud_liberacion.estado = APROBADA — eso es
 * responsabilidad del futuro Panel de Trabajo de Facturación. Este
 * Executor queda completo y corriendo, simplemente no encontrará trabajo
 * pendiente hasta que ese panel exista.
 */
final class LiberacionExecutor implements Watcher
{
    private const EVENTO_EJECUTANDO = 'guia.liberacion_ejecutando';
    private const EVENTO_ERROR = 'guia.liberacion_error';
    private const ACTOR = 'liberacion-executor';

    public function __construct(
        private readonly SolicitudLiberacionRepository $solicitudRepository,
        private readonly SolicitudLiberacionDetalleRepository $detalleRepository,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly GuiaEstadoTableroRepository $guiaEstadoTableroRepository,
        private readonly SolicitudLiberacionHistorialRepository $historialRepository,
        private readonly SicretGateway $sicretGateway,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
    ) {
    }

    public function run(): int
    {
        $ejecutadas = 0;

        foreach ($this->solicitudRepository->listarPorEstado(SolicitudLiberacionRepository::ESTADO_APROBADA) as $solicitud) {
            if ($this->ejecutar((int) $solicitud['id'])) {
                $ejecutadas++;
            }
        }

        return $ejecutadas;
    }

    private function ejecutar(int $solicitudId): bool
    {
        $guias = $this->detalleRepository->porSolicitud($solicitudId);
        $sourcesPorGuiaId = $this->resolverSources(array_column($guias, 'guia_id'));

        try {
            foreach ($guias as $guia) {
                $guiaId = (int) $guia['guia_id'];
                $source = $sourcesPorGuiaId[$guiaId]
                    ?? throw new \RuntimeException("No se pudo resolver \"source\" para guia_id {$guiaId}.");

                $this->sicretGateway->liberar($source, (string) $guia['num_guia']);
            }
        } catch (\Throwable $e) {
            $this->marcarError($solicitudId, $e->getMessage());

            return false;
        }

        $this->solicitudRepository->marcarEjecutando($solicitudId);

        foreach ($guias as $guia) {
            $this->guiaEstadoTableroRepository->marcarEstado(
                (int) $guia['guia_id'],
                GuiaEstadoTableroRepository::ESTADO_EJECUTANDO,
            );
        }

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'EJECUTANDO',
            estadoAnterior: SolicitudLiberacionRepository::ESTADO_APROBADA,
            estadoNuevo: SolicitudLiberacionRepository::ESTADO_EJECUTANDO,
            actor: self::ACTOR,
            detalle: null,
        );

        $this->eventPublisher->publish(self::EVENTO_EJECUTANDO, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => ['id' => (int) $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);

        $this->logger->info('LiberacionExecutor: solicitud en ejecución', ['solicitud_id' => $solicitudId]);

        return true;
    }

    private function marcarError(int $solicitudId, string $motivo): void
    {
        $this->solicitudRepository->marcarError($solicitudId, $motivo);

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'ERROR',
            estadoAnterior: SolicitudLiberacionRepository::ESTADO_APROBADA,
            estadoNuevo: SolicitudLiberacionRepository::ESTADO_ERROR,
            actor: self::ACTOR,
            detalle: $motivo,
        );

        $this->eventPublisher->publish(self::EVENTO_ERROR, [
            'solicitud_id' => $solicitudId,
            'motivo' => $motivo,
        ]);

        $this->logger->error('LiberacionExecutor: fallo al ejecutar solicitud', [
            'solicitud_id' => $solicitudId,
            'error' => $motivo,
        ]);
    }

    /**
     * @param int[] $guiaIds
     * @return array<int, string> guia_id => source
     */
    private function resolverSources(array $guiaIds): array
    {
        $map = [];

        foreach ($this->guiaLookupRepository->buscarPorId($guiaIds) as $fila) {
            $map[(int) $fila['id']] = (string) $fila['source'];
        }

        return $map;
    }
}
