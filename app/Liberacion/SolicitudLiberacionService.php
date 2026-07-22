<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use PDO;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Domain\Events\LiberacionRequested;
use App\Domain\Events\LiberacionApproved;
use App\Domain\Events\LiberacionRejected;

/**
 * Orquestador del módulo — mismo rol que App\Sync\GuideWatcher dentro de
 * App\Sync: valida, coordina los repositorios de una sola responsabilidad
 * cada uno, gestiona la transacción, y publica el evento. Ningún
 * repositorio individual abre ni cierra su propia transacción.
 */
final class SolicitudLiberacionService
{
    private const ORIGEN = 'trafico-system';
    private const EVENTO_LIBERACION_SOLICITADA = 'guia.liberacion_solicitada';
    private const EVENTO_APROBADA = 'solicitud_liberacion.aprobada';
    private const EVENTO_RECHAZADA = 'solicitud_liberacion.rechazada';
    private const ACTOR_TABLERO = 'facturacion-tablero';

    public function __construct(
        private readonly PDO $connection,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly GuiaEstadoTableroRepository $guiaEstadoTableroRepository,
        private readonly SolicitudLiberacionRepository $solicitudRepository,
        private readonly SolicitudLiberacionDetalleRepository $detalleRepository,
        private readonly SolicitudLiberacionHistorialRepository $historialRepository,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
    ) {
    }

    /**
     * Crea una Solicitud de Liberación para el lote completo o rechaza
     * el lote completo — nunca una aceptación parcial (ver
     * knowledge/modules/solicitudes-liberacion/security.md §3).
     *
     * @return array<string, mixed>
     */
    public function crear(SolicitudLiberacionPayload $payload): array
    {
        $guias = $this->resolverGuias($payload->numGuias);
        $this->verificarDisponibilidad($guias);

        $this->connection->beginTransaction();

        try {
            $solicitudId = $this->solicitudRepository->insertar(self::ORIGEN, $payload->motivo);

            $this->detalleRepository->insertarLote($solicitudId, $guias);

            foreach ($guias as $guia) {
                if (!$this->guiaEstadoTableroRepository->intentarMarcarSolicitada($guia['guia_id'])) {
                    // Otra solicitud reclamó la guía entre la verificación
                    // previa y esta transacción — se revierte el lote completo.
                    throw SolicitudLiberacionValidationException::guiaNoDisponible([
                        $guia['num_guia'] => GuiaEstadoTableroRepository::ESTADO_SOLICITADA_LIBERACION,
                    ]);
                }
            }

            $this->historialRepository->registrar(
                solicitudId: $solicitudId,
                evento: 'CREADA',
                estadoAnterior: null,
                estadoNuevo: 'PENDIENTE',
                actor: self::ORIGEN,
                detalle: $payload->motivo,
            );

            $this->connection->commit();
        } catch (\Throwable $e) {
            $this->connection->rollBack();

            if (!$e instanceof SolicitudLiberacionValidationException) {
                $this->logger->error('Error al crear solicitud de liberación', [
                    'error' => $e->getMessage(),
                ]);
            }

            throw $e;
        }

        $this->logger->info('Solicitud de liberación creada', [
            'solicitud_id' => $solicitudId,
            'total_guias' => count($guias),
        ]);

        $this->publicarEvento($solicitudId, $guias);

        $solicitud = $this->solicitudRepository->encontrarPorId($solicitudId);
        $solicitud['guias'] = array_map(
            static fn (array $g): array => ['guia_id' => $g['guia_id'], 'num_guia' => $g['num_guia']],
            $guias,
        );

        if ($this->dispatcher) {
            // Se asume 1 guía por simplicidad en el evento de dominio, o se lanza por cada guía.
            // Para mantener consistencia con los eventos:
            foreach ($guias as $guia) {
                $this->dispatcher->dispatch(new LiberacionRequested($guia['num_guia'], ['solicitud_id' => $solicitudId]));
            }
        }

        return $solicitud;
    }

    /** @return array<string, mixed>|null */
    public function obtener(int $id): ?array
    {
        $solicitud = $this->solicitudRepository->encontrarPorId($id);

        if ($solicitud === null) {
            return null;
        }

        $solicitud['guias'] = $this->detalleRepository->porSolicitud($id);
        $solicitud['historial'] = $this->historialRepository->porSolicitud($id);

        return $solicitud;
    }

    /**
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string} $filtros
     * @return array{total: int, page: int, perPage: int, data: array<int, array<string, mixed>>}
     */
    public function listar(array $filtros, int $page, int $perPage): array
    {
        return [
            'total' => $this->solicitudRepository->contar($filtros),
            'page' => $page,
            'perPage' => $perPage,
            'data' => $this->solicitudRepository->listar($filtros, $page, $perPage),
        ];
    }

    /**
     * Panel de trabajo de Facturación — vista aplanada por guía, con
     * filtros/orden resueltos server-side (el frontend nunca filtra ni
     * ordena por su cuenta, ver knowledge/modules/solicitudes-liberacion/).
     *
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string, num_guia?: ?string, num_guias?: ?string[], operador?: ?string, source?: ?string} $filtros
     * @return array{total: int, page: int, perPage: int, data: array<int, array<string, mixed>>}
     */
    public function listarConDetalleGuia(array $filtros, string $sort, string $dir, int $page, int $perPage): array
    {
        return [
            'total' => $this->solicitudRepository->contarConDetalleGuia($filtros),
            'page' => $page,
            'perPage' => $perPage,
            'data' => $this->solicitudRepository->listarConDetalleGuia($filtros, $sort, $dir, $page, $perPage),
        ];
    }

    /** @return array<string, mixed> */
    public function kpis(): array
    {
        return [
            ...$this->solicitudRepository->kpis(),
            'guias_por_timbrar' => $this->guiaEstadoTableroRepository->contarPorTimbrar(),
        ];
    }

    /**
     * Aprueba una solicitud PENDIENTE — no ejecuta nada contra SICRET:
     * solo abre la puerta para que App\Liberacion\Execution\LiberacionExecutor
     * (ya corriendo en bin/monitoring-engine.php) la recoja en su próximo
     * ciclo. Ver knowledge/modules/solicitudes-liberacion/workflow.md.
     *
     * @return array<string, mixed>
     */
    public function aprobar(int $id, ?string $actor): array
    {
        $actor ??= self::ACTOR_TABLERO;

        $solicitud = $this->solicitudRepository->encontrarPorId($id)
            ?? throw SolicitudLiberacionValidationException::solicitudNoEncontrada($id);

        if ($solicitud['estado'] !== SolicitudLiberacionRepository::ESTADO_PENDIENTE) {
            throw SolicitudLiberacionValidationException::solicitudNoPendiente($id, (string) $solicitud['estado']);
        }

        if (!$this->solicitudRepository->marcarAprobada($id, $actor)) {
            // Otro revisor la resolvió entre la lectura y este UPDATE.
            $actual = $this->solicitudRepository->encontrarPorId($id);

            throw SolicitudLiberacionValidationException::solicitudNoPendiente($id, (string) ($actual['estado'] ?? 'DESCONOCIDO'));
        }

        $this->historialRepository->registrar(
            solicitudId: $id,
            evento: 'APROBADA',
            estadoAnterior: SolicitudLiberacionRepository::ESTADO_PENDIENTE,
            estadoNuevo: SolicitudLiberacionRepository::ESTADO_APROBADA,
            actor: $actor,
            detalle: null,
        );

        $this->logger->info('Solicitud de liberación aprobada', ['solicitud_id' => $id, 'actor' => $actor]);

        $guias = $this->detalleRepository->porSolicitud($id);

        $this->eventPublisher->publish(self::EVENTO_APROBADA, [
            'solicitud_id' => $id,
            'actor' => $actor,
            'guias' => array_map(
                static fn (array $g): array => ['id' => (int) $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);

        if ($this->dispatcher) {
            foreach ($guias as $guia) {
                $this->dispatcher->dispatch(new LiberacionApproved($guia['num_guia'], ['solicitud_id' => $id, 'actor' => $actor]));
            }
        }

        return $this->obtener($id) ?? throw SolicitudLiberacionValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Rechaza una solicitud PENDIENTE y revierte cada guía del lote a
     * GENERADA — decisión de este sprint (ver
     * knowledge/modules/solicitudes-liberacion/future-considerations.md §2,
     * pregunta dejada abierta explícitamente "para el sprint de
     * Facturación"): permite que Tráfico corrija y vuelva a solicitar.
     *
     * @return array<string, mixed>
     */
    public function rechazar(int $id, ?string $actor, string $motivo): array
    {
        $motivo = trim($motivo);

        if ($motivo === '') {
            throw SolicitudLiberacionValidationException::motivoRechazoRequerido();
        }

        $actor ??= self::ACTOR_TABLERO;

        $solicitud = $this->solicitudRepository->encontrarPorId($id)
            ?? throw SolicitudLiberacionValidationException::solicitudNoEncontrada($id);

        if ($solicitud['estado'] !== SolicitudLiberacionRepository::ESTADO_PENDIENTE) {
            throw SolicitudLiberacionValidationException::solicitudNoPendiente($id, (string) $solicitud['estado']);
        }

        $guias = $this->detalleRepository->porSolicitud($id);

        $this->connection->beginTransaction();

        try {
            if (!$this->solicitudRepository->marcarRechazada($id, $actor)) {
                $actual = $this->solicitudRepository->encontrarPorId($id);

                throw SolicitudLiberacionValidationException::solicitudNoPendiente($id, (string) ($actual['estado'] ?? 'DESCONOCIDO'));
            }

            foreach ($guias as $guia) {
                $this->guiaEstadoTableroRepository->marcarEstado(
                    (int) $guia['guia_id'],
                    GuiaEstadoTableroRepository::ESTADO_ASIGNADA_AL_OPERADOR,
                );
            }

            $this->historialRepository->registrar(
                solicitudId: $id,
                evento: 'RECHAZADA',
                estadoAnterior: SolicitudLiberacionRepository::ESTADO_PENDIENTE,
                estadoNuevo: SolicitudLiberacionRepository::ESTADO_RECHAZADA,
                actor: $actor,
                detalle: $motivo,
            );

            $this->connection->commit();
        } catch (\Throwable $e) {
            $this->connection->rollBack();

            if (!$e instanceof SolicitudLiberacionValidationException) {
                $this->logger->error('Error al rechazar solicitud de liberación', [
                    'solicitud_id' => $id,
                    'error' => $e->getMessage(),
                ]);
            }

            throw $e;
        }

        $this->logger->info('Solicitud de liberación rechazada', ['solicitud_id' => $id, 'actor' => $actor]);

        $this->eventPublisher->publish(self::EVENTO_RECHAZADA, [
            'solicitud_id' => $id,
            'actor' => $actor,
            'motivo' => $motivo,
            'guias' => array_map(
                static fn (array $g): array => ['id' => (int) $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);

        if ($this->dispatcher) {
            foreach ($guias as $guia) {
                $this->dispatcher->dispatch(new LiberacionRejected($guia['num_guia'], ['solicitud_id' => $id, 'motivo' => $motivo]));
            }
        }

        return $this->obtener($id) ?? throw SolicitudLiberacionValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Resuelve cada folio a su fila en ATLAS. Rechaza el lote completo si
     * algún folio no existe o es ambiguo entre fuentes (ver security.md §2)
     * — nunca asume una fuente por defecto.
     *
     * @param string[] $numGuias
     * @return array<int, array{guia_id: int, num_guia: string}>
     */
    private function resolverGuias(array $numGuias): array
    {
        $filas = $this->guiaLookupRepository->buscarPorNumGuia($numGuias);

        $porNumGuia = [];

        foreach ($filas as $fila) {
            $porNumGuia[$fila['num_guia']][] = $fila;
        }

        $noEncontradas = [];
        $ambiguas = [];
        $resueltas = [];

        foreach ($numGuias as $numGuia) {
            $coincidencias = $porNumGuia[$numGuia] ?? [];

            if ($coincidencias === []) {
                $noEncontradas[] = $numGuia;

                continue;
            }

            if (count($coincidencias) > 1) {
                $ambiguas[$numGuia] = array_column($coincidencias, 'source');

                continue;
            }

            $resueltas[] = [
                'guia_id' => (int) $coincidencias[0]['id'],
                'num_guia' => $numGuia,
            ];
        }

        if ($noEncontradas !== []) {
            throw SolicitudLiberacionValidationException::guiaNoEncontrada($noEncontradas);
        }

        if ($ambiguas !== []) {
            $primerNumGuia = array_key_first($ambiguas);

            throw SolicitudLiberacionValidationException::guiaAmbigua($primerNumGuia, $ambiguas[$primerNumGuia]);
        }

        return $resueltas;
    }

    /**
     * Verificación previa (best effort, no atómica) para responder con un
     * error claro antes de abrir la transacción. La garantía real contra
     * condiciones de carrera la da
     * GuiaEstadoTableroRepository::intentarMarcarSolicitada() dentro de
     * la transacción (ver database-design.md §1).
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     */
    private function verificarDisponibilidad(array $guias): void
    {
        $estados = $this->guiaEstadoTableroRepository->estadosActuales(
            array_column($guias, 'guia_id'),
        );

        $noDisponibles = [];

        foreach ($guias as $guia) {
            $estado = $estados[$guia['guia_id']] ?? GuiaEstadoTableroRepository::ESTADO_GENERADA;

            if ($estado !== GuiaEstadoTableroRepository::ESTADO_GENERADA && $estado !== GuiaEstadoTableroRepository::ESTADO_ASIGNADA_AL_OPERADOR) {
                $noDisponibles[$guia['num_guia']] = $estado;
            }
        }

        if ($noDisponibles !== []) {
            throw SolicitudLiberacionValidationException::guiaNoDisponible($noDisponibles);
        }
    }

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    private function publicarEvento(int $solicitudId, array $guias): void
    {
        $this->eventPublisher->publish(self::EVENTO_LIBERACION_SOLICITADA, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => ['id' => $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);
    }
}
