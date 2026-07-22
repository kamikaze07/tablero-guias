<?php

declare(strict_types=1);

namespace App\Monitoring\Liberacion;

use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Monitoring\EvidenceWatcher;
use App\Sync\EventPublisher;

/**
 * Confirma, con evidencia real de SICRET (nunca por suposición), que una
 * Solicitud de Liberación en estado EJECUTANDO realmente concluyó — ver
 * Principio 4 de la arquitectura de ATLAS ("ATLAS siempre trabaja con
 * evidencia"). Dónde y cómo se busca esa evidencia está delegado a
 * EvidenceSource (SicretStateEvidenceSource hoy); esta clase solo decide
 * qué hacer con el resultado.
 *
 * `pendientes()` opera a nivel de GUÍA individual, no de solicitud: un
 * lote puede tener algunas guías ya confirmadas y otras no. La solicitud
 * completa pasa a COMPLETADA solo cuando TODAS sus guías fueron
 * confirmadas.
 */
final class LiberationConfirmationWatcher extends EvidenceWatcher
{
    private const EVENTO_COMPLETADA = 'guia.liberacion_completada';
    private const EVENTO_ERROR = 'guia.liberacion_error';
    private const ACTOR = 'liberation-confirmation-watcher';

    public function __construct(
        private readonly SolicitudLiberacionRepository $solicitudRepository,
        private readonly SolicitudLiberacionDetalleRepository $detalleRepository,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly GuiaEstadoTableroRepository $guiaEstadoTableroRepository,
        private readonly SolicitudLiberacionHistorialRepository $historialRepository,
        private readonly EvidenceSource $evidenceSource,
        private readonly EventPublisher $eventPublisher,
    ) {
    }

    protected function pendientes(): iterable
    {
        foreach ($this->solicitudRepository->listarPorEstado(SolicitudLiberacionRepository::ESTADO_EJECUTANDO) as $solicitud) {
            $solicitudId = (int) $solicitud['id'];
            $guias = $this->detalleRepository->porSolicitud($solicitudId);
            $sourcesPorGuiaId = $this->resolverSources(array_column($guias, 'guia_id'));

            foreach ($guias as $guia) {
                $guiaId = (int) $guia['guia_id'];

                yield [
                    'solicitud_id' => $solicitudId,
                    'guia_id' => $guiaId,
                    'num_guia' => (string) $guia['num_guia'],
                    'source' => $sourcesPorGuiaId[$guiaId] ?? null,
                ];
            }
        }
    }

    protected function buscarEvidencia(mixed $item): Evidence
    {
        return $this->evidenceSource->buscar($item);
    }

    protected function alConfirmar(mixed $item, Evidence $evidencia): void
    {
        $solicitudId = (int) $item['solicitud_id'];

        $this->guiaEstadoTableroRepository->marcarEstado((int) $item['guia_id'], GuiaEstadoTableroRepository::ESTADO_POR_TIMBRAR);

        if (!$this->solicitudCompleta($solicitudId)) {
            return;
        }

        $this->solicitudRepository->marcarCompletada($solicitudId);

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'COMPLETADA',
            estadoAnterior: SolicitudLiberacionRepository::ESTADO_EJECUTANDO,
            estadoNuevo: SolicitudLiberacionRepository::ESTADO_COMPLETADA,
            actor: self::ACTOR,
            detalle: null,
        );

        $guias = $this->detalleRepository->porSolicitud($solicitudId);
        $this->eventPublisher->publish(self::EVENTO_COMPLETADA, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => ['id' => (int) $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);
    }

    protected function alFallar(mixed $item, string $motivo): void
    {
        $solicitudId = (int) $item['solicitud_id'];

        $this->guiaEstadoTableroRepository->marcarEstado((int) $item['guia_id'], GuiaEstadoTableroRepository::ESTADO_ERROR);
        $this->solicitudRepository->marcarError($solicitudId, $motivo);

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'ERROR',
            estadoAnterior: SolicitudLiberacionRepository::ESTADO_EJECUTANDO,
            estadoNuevo: SolicitudLiberacionRepository::ESTADO_ERROR,
            actor: self::ACTOR,
            detalle: $motivo,
        );

        $guias = $this->detalleRepository->porSolicitud($solicitudId);
        $this->eventPublisher->publish(self::EVENTO_ERROR, [
            'solicitud_id' => $solicitudId,
            'motivo' => $motivo,
            'guias' => array_map(
                static fn (array $g): array => ['id' => (int) $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);
    }

    private function solicitudCompleta(int $solicitudId): bool
    {
        $guias = $this->detalleRepository->porSolicitud($solicitudId);
        $estados = $this->guiaEstadoTableroRepository->estadosActuales(array_column($guias, 'guia_id'));

        foreach ($guias as $guia) {
            if (($estados[(int) $guia['guia_id']] ?? null) !== GuiaEstadoTableroRepository::ESTADO_POR_TIMBRAR) {
                return false;
            }
        }

        return true;
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
