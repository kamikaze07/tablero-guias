<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use App\Timbrado\RutaLookup;
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
        private readonly ContenedorLookup $contenedorLookup,
        private readonly RutaLookup $rutaLookup,
        private readonly ClienteLookup $clienteLookup,
        private readonly GuiaEstadoTableroRepository $guiaEstadoTableroRepository,
        private readonly SolicitudLiberacionRepository $solicitudRepository,
        private readonly SolicitudLiberacionDetalleRepository $detalleRepository,
        private readonly SolicitudLiberacionHistorialRepository $historialRepository,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
        private readonly ?SicretEstatusLookup $sicretEstatusLookup = null,
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
        $guias = $this->resolverGuias($payload->numGuias, $payload->source);
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
                actor: $payload->solicitante ?? self::ORIGEN,
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

        // ContenedorLookup::porNumGuia() necesita `source` por guía —
        // $guias aquí viene de resolverGuias(), que solo trae guia_id/
        // num_guia. Bug real encontrado 2026-07-28: sin conSource(), esto
        // producía "Undefined array key 'source'" (ContenedorLookup.php:54)
        // — con display_errors activo, ese warning se antepone como HTML al
        // JSON de la respuesta y el cliente (AtlasClient en trafico-system)
        // lo rechaza como "ATLAS devolvió una respuesta inválida", aunque
        // la solicitud ya se hubiera creado con éxito. Mismo patrón que ya
        // usa guiasParaWebSocket() en este archivo — y ahora también
        // RutaLookup/ClienteLookup, que necesitan lo mismo.
        $guiasConSource = $this->conSource($guias);
        $contenedores = $this->contenedorLookup->porNumGuia($guiasConSource);
        $clientes = $this->clienteLookup->porNumGuia($guiasConSource);
        $rutas = $this->aplicarDatos($this->rutaLookup->agruparPorRuta($guiasConSource), $contenedores, $clientes);

        $solicitud = $this->solicitudRepository->encontrarPorId($solicitudId);
        $solicitud['guias'] = array_map(
            static fn (array $g): array => [
                'guia_id' => $g['guia_id'],
                'num_guia' => $g['num_guia'],
                'contenedor' => $contenedores[$g['num_guia']] ?? '',
            ],
            $guias,
        );
        $solicitud['rutas'] = $rutas;

        if ($this->dispatcher) {
            // Un solo mensaje de Mattermost por solicitud, con todas las
            // guías del lote agrupadas por (origen, destino) — nunca uno
            // por guía (ver
            // App\Notifications\Consumers\Mattermost\Templates\LiberacionRequestedTemplate).
            $this->dispatcher->dispatch(new LiberacionRequested(
                implode("\n", array_map(static fn (array $g): string => "- {$g['num_guia']}", $guias)),
                [
                    'solicitud_id' => $solicitudId,
                    'usuario' => $payload->solicitante ?? self::ORIGEN,
                    'empresa' => $payload->source ?? 'N/A',
                    'rutas' => $rutas,
                ],
            ));
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

        $guiasConSource = $this->conSource($this->detalleRepository->porSolicitud($id));
        $contenedores = $this->contenedorLookup->porNumGuia($guiasConSource);
        $clientes = $this->clienteLookup->porNumGuia($guiasConSource);

        $solicitud['guias'] = array_map(
            static fn (array $g): array => [
                'guia_id' => $g['guia_id'],
                'num_guia' => $g['num_guia'],
                'contenedor' => $contenedores[$g['num_guia']] ?? '',
                'cliente' => $clientes[$g['num_guia']] ?? '',
            ],
            $guiasConSource,
        );
        $solicitud['rutas'] = $this->aplicarDatos($this->rutaLookup->agruparPorRuta($guiasConSource), $contenedores, $clientes);
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
        $data = $this->solicitudRepository->listarConDetalleGuia($filtros, $sort, $dir, $page, $perPage);

        // Contenedor, Origen/Destino de RUTA (nombre corto + localidad) y
        // Cliente por guía — ver App\Liberacion\ContenedorLookup /
        // App\Timbrado\RutaLookup / App\Liberacion\ClienteLookup.
        $guiasConSource = array_map(
            static fn (array $row): array => ['num_guia' => $row['num_guia'], 'source' => $row['source']],
            $data,
        );
        $contenedores = $this->contenedorLookup->porNumGuia($guiasConSource);
        $rutas = $this->rutaLookup->porNumGuia($guiasConSource);
        $clientes = $this->clienteLookup->porNumGuia($guiasConSource);

        foreach ($data as &$row) {
            $ruta = $rutas[$row['num_guia']] ?? ['origen' => '', 'destino' => ''];
            $row['contenedor'] = $contenedores[$row['num_guia']] ?? '';
            $row['ruta_origen'] = $ruta['origen'];
            $row['ruta_destino'] = $ruta['destino'];
            $row['cliente'] = $clientes[$row['num_guia']] ?? '';
        }
        unset($row);

        return [
            'total' => $this->solicitudRepository->contarConDetalleGuia($filtros),
            'page' => $page,
            'perPage' => $perPage,
            'data' => $data,
        ];
    }

    /** @return array<string, mixed> */
    public function kpis(): array
    {
        return [
            ...$this->solicitudRepository->kpis(),
            'guias_por_timbrar' => $this->guiaEstadoTableroRepository->contarPorTimbrarHoy(),
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
            'guias' => $this->guiasParaWebSocket($guias),
        ]);

        if ($this->dispatcher) {
            // Antes despachaba un LiberacionApproved POR guía (spam en
            // Mattermost para lotes grandes) — alineado al mismo criterio
            // que TimbradoApproved: un solo mensaje por solicitud, con la
            // lista completa de guías.
            $this->dispatcher->dispatch(new LiberacionApproved(
                implode("\n", array_map(static fn (array $g): string => "- {$g['num_guia']}", $guias)),
                [
                    'solicitud_id' => $id,
                    'usuario' => $actor,
                    'empresa' => $this->resolverEmpresas($guias),
                    'rutas' => $this->rutasParaEvento($guias),
                ],
            ));
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
            'guias' => $this->guiasParaWebSocket($guias),
        ]);

        if ($this->dispatcher) {
            // Mismo criterio que crear(): un solo mensaje de Mattermost por
            // solicitud, con la lista completa de guías, el usuario real
            // que rechazó y la empresa resuelta desde `guias` (el rechazo
            // no recibe un payload con `source`, a diferencia de crear()).
            $this->dispatcher->dispatch(new LiberacionRejected(
                implode("\n", array_map(static fn (array $g): string => "- {$g['num_guia']}", $guias)),
                [
                    'solicitud_id' => $id,
                    'motivo' => $motivo,
                    'usuario' => $actor,
                    'empresa' => $this->resolverEmpresas($guias),
                    'rutas' => $this->rutasParaEvento($guias),
                ],
            ));
        }

        return $this->obtener($id) ?? throw SolicitudLiberacionValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Resuelve cada folio a su fila en ATLAS. Rechaza el lote completo si
     * algún folio no existe o es ambiguo entre fuentes (ver security.md §2)
     * — nunca asume una fuente por defecto.
     *
     * `$source`, cuando viene informado por el llamador (trafico-system
     * manda la empresa activa de la sesión — ver
     * SolicitudLiberacionPayload::fromArray(), campo que ya anticipaba
     * security.md §2.2 como pendiente), desambigua un `num_guia` que exista
     * en más de una fuente en vez de rechazarlo directamente: se descartan
     * las coincidencias de cualquier otra fuente antes de decidir si el
     * folio quedó resuelto, es ambiguo o no existe. Con `$source` null
     * (compatibilidad con llamadores que no lo manden) el comportamiento es
     * exactamente el de siempre — nunca se asume una fuente por defecto.
     *
     * @param string[] $numGuias
     * @return array<int, array{guia_id: int, num_guia: string}>
     */
    private function resolverGuias(array $numGuias, ?string $source = null): array
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

            if ($source !== null) {
                $coincidencias = array_values(array_filter(
                    $coincidencias,
                    static fn (array $fila): bool => $fila['source'] === $source,
                ));
            }

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
     * `empresa` para notificaciones que ocurren después de crear() (p. ej.
     * rechazar()), donde ya no se tiene el `source` que mandó trafico-system
     * en el payload original — se resuelve en vivo desde `guias`. Casi
     * siempre una sola empresa; si el lote mezcla fuentes, se listan todas.
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     */
    private function resolverEmpresas(array $guias): string
    {
        $filas = $this->guiaLookupRepository->buscarPorId(array_column($guias, 'guia_id'));
        $fuentes = array_unique(array_column($filas, 'source'));

        return $fuentes === [] ? 'N/A' : implode(', ', $fuentes);
    }

    /**
     * Verificación previa (best effort, no atómica) para responder con un
     * error claro antes de abrir la transacción. La garantía real contra
     * condiciones de carrera la da
     * GuiaEstadoTableroRepository::intentarMarcarSolicitada() dentro de
     * la transacción (ver database-design.md §1) — incluso si esta
     * verificación pre-aprobara por error una guía ya reclamada por otra
     * solicitud, el compare-and-swap de esa llamada la rechazaría igual.
     *
     * Regla de negocio (confirmada en vivo, guía PR-220212/sicreGero,
     * 2026-07-28): una guía sigue siendo elegible para Liberación mientras
     * su estatus REAL en SICRET sea "Asignada Al Operador" — sin importar
     * qué diga `guia_estado_tablero` en ATLAS. SICRET no transiciona
     * `guias.estatus` al facturar (permanece en "Asignada Al Operador"
     * indefinidamente, aunque la guía ya tenga `factimpresa`/timbrado
     * real), así que `guia_estado_tablero` puede quedar en TIMBRADO (vía
     * DirectStampingWatcher/TimbradoConfirmationWatcher) para una guía que,
     * en SICRET, sigue siendo perfectamente elegible. Por eso, para
     * cualquier guía que ATLAS marque como no disponible, se hace una
     * segunda verificación en vivo directamente contra SICRET antes de
     * rechazarla definitivamente.
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     */
    private function verificarDisponibilidad(array $guias): void
    {
        $estados = $this->guiaEstadoTableroRepository->estadosActuales(
            array_column($guias, 'guia_id'),
        );

        $noDisponiblesSegunAtlas = [];

        foreach ($guias as $guia) {
            $estado = $estados[$guia['guia_id']] ?? GuiaEstadoTableroRepository::ESTADO_GENERADA;

            if ($estado !== GuiaEstadoTableroRepository::ESTADO_GENERADA && $estado !== GuiaEstadoTableroRepository::ESTADO_ASIGNADA_AL_OPERADOR) {
                $noDisponiblesSegunAtlas[$guia['guia_id']] = ['num_guia' => $guia['num_guia'], 'estado' => $estado];
            }
        }

        $noDisponibles = $this->descartarPorEstatusRealEnSicret($noDisponiblesSegunAtlas);

        if ($noDisponibles !== []) {
            throw SolicitudLiberacionValidationException::guiaNoDisponible($noDisponibles);
        }
    }

    /**
     * De las guías que ATLAS considera no disponibles, quita las que SICRET
     * confirma en vivo que siguen "Asignada Al Operador" — ver docblock de
     * verificarDisponibilidad(). Si SicretEstatusLookup no está configurado
     * (compatibilidad con instanciaciones antiguas del servicio) o SICRET no
     * responde, se conserva el bloqueo original (fail-closed, nunca
     * fail-open ante una fuente inalcanzable).
     *
     * @param array<int, array{num_guia: string, estado: string}> $noDisponiblesSegunAtlas guia_id => datos
     * @return array<string, string> num_guia => estado (el resultado final a rechazar)
     */
    private function descartarPorEstatusRealEnSicret(array $noDisponiblesSegunAtlas): array
    {
        if ($noDisponiblesSegunAtlas === [] || $this->sicretEstatusLookup === null) {
            return array_combine(
                array_map(static fn (array $d): string => $d['num_guia'], $noDisponiblesSegunAtlas),
                array_map(static fn (array $d): string => $d['estado'], $noDisponiblesSegunAtlas),
            );
        }

        $sourcePorId = [];
        foreach ($this->guiaLookupRepository->buscarPorId(array_keys($noDisponiblesSegunAtlas)) as $fila) {
            $sourcePorId[(int) $fila['id']] = $fila['source'];
        }

        $noDisponibles = [];

        foreach ($noDisponiblesSegunAtlas as $guiaId => $datos) {
            $source = $sourcePorId[$guiaId] ?? null;
            $estatusEnVivo = $source !== null
                ? $this->sicretEstatusLookup->estatusActual($source, $datos['num_guia'])
                : null;

            if ($source === null || !$this->sicretEstatusLookup->esAsignadaAlOperador($estatusEnVivo)) {
                $noDisponibles[$datos['num_guia']] = $datos['estado'];
            }
        }

        return $noDisponibles;
    }

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    private function publicarEvento(int $solicitudId, array $guias): void
    {
        $this->eventPublisher->publish(self::EVENTO_LIBERACION_SOLICITADA, [
            'solicitud_id' => $solicitudId,
            'guias' => $this->guiasParaWebSocket($guias),
        ]);
    }

    /**
     * Enriquece `guia_id`/`num_guia` con la fila completa de `guias` para
     * los eventos de WebSocket que alimentan el tablero de Tráfico en vivo
     * — ver App\Liberacion\GuiaLookupRepository::buscarCompletoPorId(). Sin
     * esto, trafico.js solo puede mover una tarjeta ya existente en
     * pantalla, nunca crearla, así que una guía de una jornada anterior sin
     * actividad al cargar la página queda invisible pese al evento.
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     * @return array<int, array<string, mixed>>
     */
    private function guiasParaWebSocket(array $guias): array
    {
        $completas = $this->guiaLookupRepository->buscarCompletoPorId(array_column($guias, 'guia_id'));

        $porId = [];
        foreach ($completas as $fila) {
            $porId[(int) $fila['id']] = $fila;
        }

        $completasConDato = array_values(array_filter(array_map(
            static fn (array $g): ?array => $porId[$g['guia_id']] ?? null,
            $guias,
        )));

        $contenedores = $this->contenedorLookup->porNumGuia($completasConDato);

        return array_map(
            static fn (array $g): array => [...$g, 'contenedor' => $contenedores[$g['num_guia']] ?? ''],
            $completasConDato,
        );
    }

    /**
     * `solicitud_liberacion_detalle` no guarda `source` (ver schema) — se
     * resuelve aquí desde `guias` para App\Liberacion\ContenedorLookup, que
     * necesita saber contra qué fuente de SICRET (sicrePR/sicreGero)
     * consultar cada folio.
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     * @return array<int, array{guia_id: int, num_guia: string, source: string}>
     */
    private function conSource(array $guias): array
    {
        $porId = [];

        foreach ($this->guiaLookupRepository->buscarPorId(array_column($guias, 'guia_id')) as $fila) {
            $porId[(int) $fila['id']] = $fila['source'];
        }

        return array_map(
            static fn (array $g): array => [...$g, 'source' => $porId[$g['guia_id']] ?? ''],
            $guias,
        );
    }

    /**
     * Agrega `contenedor`/`cliente` a cada guía dentro de los grupos que
     * arma App\Timbrado\RutaLookup::agruparPorRuta() — esos grupos no
     * cargan `source`, así que ambos mapas (num_guia => dato) deben venir
     * ya resueltos (ver App\Liberacion\ContenedorLookup::porNumGuia() /
     * App\Liberacion\ClienteLookup::porNumGuia()). Mismo helper que
     * App\Timbrado\SolicitudTimbradoService.
     *
     * @param array<int, array{origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string}>}> $rutas
     * @param array<string, string> $contenedores
     * @param array<string, string> $clientes
     * @return array<int, array{origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string, contenedor: string, cliente: string}>}>
     */
    private function aplicarDatos(array $rutas, array $contenedores, array $clientes): array
    {
        foreach ($rutas as &$ruta) {
            $ruta['guias'] = array_map(
                static fn (array $g): array => [
                    ...$g,
                    'contenedor' => $contenedores[$g['num_guia']] ?? '',
                    'cliente' => $clientes[$g['num_guia']] ?? '',
                ],
                $ruta['guias'],
            );
        }
        unset($ruta);

        return $rutas;
    }

    /**
     * Rutas agrupadas (origen/destino + contenedor/cliente por guía,
     * resolviendo primero `source`, ya que estas filas vienen de
     * `solicitud_liberacion_detalle` sin esa columna) — usado por los
     * mensajes de Mattermost de aprobar()/rechazar().
     *
     * @param array<int, array{guia_id: int, num_guia: string}> $guias
     * @return array<int, array{origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string, contenedor: string, cliente: string}>}>
     */
    private function rutasParaEvento(array $guias): array
    {
        $guiasConSource = $this->conSource($guias);
        $contenedores = $this->contenedorLookup->porNumGuia($guiasConSource);
        $clientes = $this->clienteLookup->porNumGuia($guiasConSource);

        return $this->aplicarDatos($this->rutaLookup->agruparPorRuta($guiasConSource), $contenedores, $clientes);
    }
}
