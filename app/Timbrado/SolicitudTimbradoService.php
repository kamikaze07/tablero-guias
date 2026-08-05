<?php

declare(strict_types=1);

namespace App\Timbrado;

use App\Liberacion\ClienteLookup;
use App\Liberacion\ContenedorLookup;
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
        private readonly RutaLookup $rutaLookup,
        private readonly ContenedorLookup $contenedorLookup,
        private readonly ClienteLookup $clienteLookup,
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
        $guias = $this->resolverGuias($payload->numGuias, $payload->source);

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

        // Origen/Destino (nombre corto + localidad) y Cliente por guía,
        // agrupados de mayor a menor tamaño de grupo — ver
        // App\Timbrado\RutaLookup / App\Liberacion\ClienteLookup. El mismo
        // agrupado alimenta tanto el drawer de autorización (trafico-system,
        // vía este arreglo) como el mensaje de Mattermost de abajo.
        $contenedores = $this->contenedorLookup->porNumGuia($guias);
        $clientesDetalle = $this->clienteLookup->conClaveGenePorNumGuia($guias);
        $clientes = array_map(static fn (array $c): string => $c['nombre'], $clientesDetalle);
        $rutas = $this->aplicarDatos($this->rutaLookup->agruparPorRuta($guias), $contenedores, $clientes);

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
        // Grupo Inteligente (Sprint 1, knowledge/sprint1_grupo_inteligente.md):
        // agrupado por Cliente+Origen+Destino, campo NUEVO — `rutas` arriba
        // se deja intacto para no romper ningún consumidor actual (drawer,
        // Mattermost). NO agrupa CFDIs: cada guía sigue timbrándose por
        // separado, el grupo es solo contexto de captura para sprints
        // futuros que aún no consumen este campo.
        $solicitud['grupos'] = $this->rutaLookup->agruparPorClienteYRuta($guias, $clientesDetalle);

        if ($this->dispatcher) {
            // Un solo mensaje de Mattermost por solicitud, con todas las
            // guías del lote agrupadas por (origen, destino) — nunca uno
            // por guía (ver
            // App\Notifications\Consumers\Mattermost\Templates\TimbradoRequestedTemplate).
            $this->dispatcher->dispatch(new TimbradoRequested(
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
        $clientesDetalle = $this->clienteLookup->conClaveGenePorNumGuia($guiasConSource);
        $clientes = array_map(static fn (array $c): string => $c['nombre'], $clientesDetalle);

        $solicitud['guias'] = array_map(
            static fn (array $g): array => [
                ...$g,
                'contenedor' => $contenedores[$g['num_guia']] ?? '',
                'cliente' => $clientes[$g['num_guia']] ?? '',
            ],
            $guiasConSource,
        );
        $solicitud['rutas'] = $this->aplicarDatos($this->rutaLookup->agruparPorRuta($guiasConSource), $contenedores, $clientes);
        // Grupo Inteligente (Sprint 1) — ver comentario equivalente en crear().
        $solicitud['grupos'] = $this->rutaLookup->agruparPorClienteYRuta($guiasConSource, $clientesDetalle);
        $solicitud['historial'] = $this->historialRepository->porSolicitud($id);

        return $solicitud;
    }

    /**
     * Agrega `contenedor`/`cliente` a cada guía dentro de los grupos que
     * arma App\Timbrado\RutaLookup::agruparPorRuta() — esos grupos no
     * cargan `source`, así que ambos mapas (num_guia => dato) deben venir
     * ya resueltos (ver App\Liberacion\ContenedorLookup::porNumGuia() /
     * App\Liberacion\ClienteLookup::porNumGuia()).
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
     * `solicitud_timbrado_detalle` no guarda `source` (ver schema) — se
     * resuelve aquí desde `guias` para App\Timbrado\RutaLookup, que
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
        $data = $this->solicitudRepository->listarConDetalleGuia($filtros, $sort, $dir, $page, $perPage);

        // Origen/Destino de RUTA (nombre corto + localidad) y Cliente por
        // guía — ver App\Timbrado\RutaLookup / App\Liberacion\ClienteLookup.
        // Nombrados `ruta_*` a propósito: la fila ya trae `origen` (columna
        // `solicitud_timbrado.origen`, quién CREÓ la solicitud — siempre
        // "trafico-system", nada que ver con geografía) y sobrescribirlo
        // habría sido un bug silencioso. trafico-system (AvisosModel)
        // agrupa estas filas por solicitud_id y usa estos campos para el
        // mismo agrupado por ruta que ve el drawer de autorización.
        $guiasConSource = array_map(
            static fn (array $row): array => ['num_guia' => $row['num_guia'], 'source' => $row['source']],
            $data,
        );
        $rutas = $this->rutaLookup->porNumGuia($guiasConSource);
        $contenedores = $this->contenedorLookup->porNumGuia($guiasConSource);
        $clientes = $this->clienteLookup->porNumGuia($guiasConSource);

        foreach ($data as &$row) {
            $ruta = $rutas[$row['num_guia']] ?? ['origen' => '', 'destino' => ''];
            $row['ruta_origen'] = $ruta['origen'];
            $row['ruta_destino'] = $ruta['destino'];
            $row['cliente'] = $clientes[$row['num_guia']] ?? '';
            $row['contenedor'] = $contenedores[$row['num_guia']] ?? '';
        }
        unset($row);

        return [
            'total' => $this->solicitudRepository->contarConDetalleGuia($filtros),
            'page' => $page,
            'perPage' => $perPage,
            'data' => $data,
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
            'guias' => $this->guiasParaWebSocket($guias),
        ]);

        if ($this->dispatcher) {
            // Mismo criterio que rechazar(): un solo mensaje de Mattermost
            // por solicitud, con la lista completa de guías, nunca uno por
            // guía (ver App\Notifications\Consumers\Mattermost\Templates\TimbradoApprovedTemplate).
            $this->dispatcher->dispatch(new TimbradoApproved(
                implode("\n", array_map(static fn (array $g): string => "- {$g['num_guia']}", $guias)),
                [
                    'solicitud_id' => $id,
                    'usuario' => $actor,
                    'empresa' => $this->resolverEmpresas($guias),
                    'rutas' => $this->rutasParaEvento($guias),
                ],
            ));
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
            'guias' => $this->guiasParaWebSocket($guias),
        ]);

        if ($this->dispatcher) {
            // Mismo criterio que crear(): un solo mensaje de Mattermost por
            // solicitud, con la lista completa de guías, el usuario real
            // que rechazó y la empresa resuelta desde `guias` (el rechazo
            // no recibe un payload con `source`, a diferencia de crear()).
            $this->dispatcher->dispatch(new TimbradoRejected(
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

        return $this->obtener($id) ?? throw SolicitudTimbradoValidationException::solicitudNoEncontrada($id);
    }

    /**
     * Resuelve cada folio a su fila en ATLAS. Rechaza el lote completo si
     * algún folio no existe o es ambiguo entre fuentes — misma regla que
     * App\Liberacion\SolicitudLiberacionService::resolverGuias().
     *
     * `$source`, cuando viene informado por el llamador (trafico-system
     * manda la empresa activa de la sesión — ver
     * SolicitudTimbradoPayload::fromArray()), desambigua un `num_guia` que
     * exista en más de una fuente en vez de rechazarlo directamente: se
     * descartan las coincidencias de cualquier otra fuente antes de decidir
     * si el folio quedó resuelto, es ambiguo o no existe. Si `$source` es
     * null (compatibilidad con llamadores que no lo manden), el
     * comportamiento es exactamente el de siempre.
     *
     * @param string[] $numGuias
     * @return array<int, array{guia_id: int, num_guia: string, source: string}>
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
                'source' => $coincidencias[0]['source'],
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

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    private function publicarEvento(int $solicitudId, array $guias): void
    {
        $this->eventPublisher->publish(self::EVENTO_TIMBRADO_SOLICITADO, [
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
     * Rutas agrupadas (origen/destino + contenedor/cliente por guía,
     * resolviendo primero `source`, ya que estas filas vienen de
     * `solicitud_timbrado_detalle` sin esa columna) — usado por los
     * mensajes de Mattermost de aprobar()/rechazar(), que a diferencia de
     * crear() no reciben `source` en el payload original.
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
