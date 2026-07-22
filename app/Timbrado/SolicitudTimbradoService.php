<?php

declare(strict_types=1);

namespace App\Timbrado;

use App\Liberacion\GuiaLookupRepository;
use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use PDO;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Domain\Events\TimbradoRequested;
use App\Domain\Events\TimbradoApproved;
use App\Domain\Events\TimbradoRejected;

/**
 * Orquestador del módulo — mismo rol que
 * App\Liberacion\SolicitudLiberacionService, deliberadamente más simple:
 * Solicitar Timbrado no ejecuta nada contra SICRET ni mueve ninguna máquina
 * de estados de la guía (App\Liberacion\GuiaEstadoTableroRepository no
 * aplica aquí — esa tabla es exclusiva del flujo de Liberación). Este
 * servicio únicamente valida, resuelve los folios y registra la solicitud.
 *
 * Reutiliza GuiaLookupRepository de App\Liberacion tal cual: resolver
 * `num_guia` -> fila de ATLAS es una operación genérica que no pertenece a
 * ningún módulo de negocio en particular.
 */
final class SolicitudTimbradoService
{
    private const ORIGEN = 'trafico-system';
    private const EVENTO_TIMBRADO_SOLICITADO = 'guia.timbrado_solicitado';
    private const EVENTO_APROBADA = 'solicitud_timbrado.aprobada';
    private const EVENTO_RECHAZADA = 'solicitud_timbrado.rechazada';
    private const ACTOR_TABLERO = 'facturacion-tablero';

    public function __construct(
        private readonly PDO $connection,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly SolicitudTimbradoRepository $solicitudRepository,
        private readonly SolicitudTimbradoDetalleRepository $detalleRepository,
        private readonly SolicitudTimbradoHistorialRepository $historialRepository,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
    ) {
    }

    /**
     * Crea una Solicitud de Timbrado para el lote completo o rechaza el
     * lote completo — mismo principio de "todo o nada" que Liberación.
     *
     * @return array<string, mixed>
     */
    public function crear(SolicitudTimbradoPayload $payload): array
    {
        $guias = $this->resolverGuias($payload->numGuias);

        $this->connection->beginTransaction();

        try {
            $solicitudId = $this->solicitudRepository->insertar(self::ORIGEN, $payload->solicitante);

            $this->detalleRepository->insertarLote($solicitudId, $guias);

            $this->historialRepository->registrar(
                solicitudId: $solicitudId,
                evento: 'CREADA',
                actor: $payload->solicitante ?? self::ORIGEN,
                detalle: null,
            );

            $this->connection->commit();
        } catch (\Throwable $e) {
            $this->connection->rollBack();

            if (!$e instanceof SolicitudTimbradoValidationException) {
                $this->logger->error('Error al crear solicitud de timbrado', [
                    'error' => $e->getMessage(),
                ]);
            }

            throw $e;
        }

        $this->logger->info('Solicitud de timbrado creada', [
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
            foreach ($guias as $guia) {
                $this->dispatcher->dispatch(new TimbradoRequested($guia['num_guia'], ['solicitud_id' => $solicitudId]));
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

    /** @return array<string, mixed> */
    public function kpis(): array
    {
        return $this->solicitudRepository->kpis();
    }

    /**
     * Panel de trabajo de Facturación / consumidores de solo lectura —
     * vista aplanada por guía, mismo rol que
     * App\Liberacion\SolicitudLiberacionService::listarConDetalleGuia().
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

    /**
     * Aprueba una solicitud PENDIENTE.
     *
     * @return array<string, mixed>
     */
    public function aprobar(int $id, ?string $actor): array
    {
        $actor ??= self::ACTOR_TABLERO;

        $solicitud = $this->solicitudRepository->encontrarPorId($id)
            ?? throw SolicitudTimbradoValidationException::solicitudNoEncontrada($id);

        if ($solicitud['estado'] !== SolicitudTimbradoRepository::ESTADO_PENDIENTE) {
            throw SolicitudTimbradoValidationException::solicitudNoPendiente($id, (string) $solicitud['estado']);
        }

        if (!$this->solicitudRepository->marcarAprobada($id, $actor)) {
            $actual = $this->solicitudRepository->encontrarPorId($id);
            throw SolicitudTimbradoValidationException::solicitudNoPendiente($id, (string) ($actual['estado'] ?? 'DESCONOCIDO'));
        }

        $this->historialRepository->registrar(
            solicitudId: $id,
            evento: 'APROBADA',
            actor: $actor,
            detalle: null,
        );

        $this->logger->info('Solicitud de timbrado aprobada', ['solicitud_id' => $id, 'actor' => $actor]);

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
                $this->dispatcher->dispatch(new TimbradoApproved($guia['num_guia'], ['solicitud_id' => $id, 'actor' => $actor]));
            }
        }

        return $this->obtener($id) ?? throw SolicitudTimbradoValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Rechaza una solicitud PENDIENTE.
     *
     * @return array<string, mixed>
     */
    public function rechazar(int $id, ?string $actor, string $motivo): array
    {
        $motivo = trim($motivo);

        if ($motivo === '') {
            throw SolicitudTimbradoValidationException::motivoRechazoRequerido();
        }

        $actor ??= self::ACTOR_TABLERO;

        $solicitud = $this->solicitudRepository->encontrarPorId($id)
            ?? throw SolicitudTimbradoValidationException::solicitudNoEncontrada($id);

        if ($solicitud['estado'] !== SolicitudTimbradoRepository::ESTADO_PENDIENTE) {
            throw SolicitudTimbradoValidationException::solicitudNoPendiente($id, (string) $solicitud['estado']);
        }

        if (!$this->solicitudRepository->marcarRechazada($id, $actor)) {
            $actual = $this->solicitudRepository->encontrarPorId($id);
            throw SolicitudTimbradoValidationException::solicitudNoPendiente($id, (string) ($actual['estado'] ?? 'DESCONOCIDO'));
        }

        $this->historialRepository->registrar(
            solicitudId: $id,
            evento: 'RECHAZADA',
            actor: $actor,
            detalle: $motivo,
        );

        $this->logger->info('Solicitud de timbrado rechazada', ['solicitud_id' => $id, 'actor' => $actor]);

        $guias = $this->detalleRepository->porSolicitud($id);

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
                $this->dispatcher->dispatch(new TimbradoRejected($guia['num_guia'], ['solicitud_id' => $id, 'motivo' => $motivo]));
            }
        }

        return $this->obtener($id) ?? throw SolicitudTimbradoValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Resuelve cada folio a su fila en ATLAS. Rechaza el lote completo si
     * algún folio no existe o es ambiguo entre fuentes — misma regla que
     * App\Liberacion\SolicitudLiberacionService::resolverGuias().
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
            throw SolicitudTimbradoValidationException::guiaNoEncontrada($noEncontradas);
        }

        if ($ambiguas !== []) {
            $primerNumGuia = array_key_first($ambiguas);

            throw SolicitudTimbradoValidationException::guiaAmbigua($primerNumGuia, $ambiguas[$primerNumGuia]);
        }

        return $resueltas;
    }

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    private function publicarEvento(int $solicitudId, array $guias): void
    {
        $this->eventPublisher->publish(self::EVENTO_TIMBRADO_SOLICITADO, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => ['id' => $g['guia_id'], 'num_guia' => $g['num_guia']],
                $guias,
            ),
        ]);
    }
}
