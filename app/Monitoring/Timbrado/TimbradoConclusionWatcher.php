<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Domain\Events\TimbradoConcluded;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Monitoring\Evidence\Evidence;
use App\Monitoring\EvidenceWatcher;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoRepository;

/**
 * Watcher de conclusión definitiva de Timbrado in ATLAS.
 * 
 * Monitor de solo lectura independiente hacia SICRET que verifica en `facturas33`
 * cuándo una solicitud tiene en todas sus guías `folioFiscal <> '' AND idccp <> ''`.
 * Realiza transición compare-and-set a `CONCLUIDA`.
 */
final class TimbradoConclusionWatcher extends EvidenceWatcher
{
    private const EVENTO_CONCLUIDO = 'guia.timbrado_concluido';
    private const ACTOR = 'timbrado-conclusion-watcher';

    public function __construct(
        private readonly SolicitudTimbradoRepository $solicitudRepository,
        private readonly SolicitudTimbradoDetalleRepository $detalleRepository,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly SolicitudTimbradoHistorialRepository $historialRepository,
        private readonly TimbradoConclusionEvidenceSource $evidenceSource,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
        private readonly ?GuiaEstadoTableroRepository $guiaEstadoTableroRepository = null,
    ) {
    }

    /** @return iterable<array{solicitud_id: int, creada_en: string, guias: array<int, array{guia_id: int, num_guia: string, source: ?string}>}> */
    protected function pendientes(): iterable
    {
        foreach ($this->solicitudRepository->listarPendientesConclusion() as $solicitud) {
            $solicitudId = (int) $solicitud['id'];
            $guias = $this->detalleRepository->porSolicitud($solicitudId);
            $sourcesPorGuiaId = $this->resolverSources(array_column($guias, 'guia_id'));

            yield [
                'solicitud_id' => $solicitudId,
                // Ver docblock de TimbradoConclusionEvidenceSource::tieneDatosFiscales():
                // la fecha de creación de ESTA solicitud es lo que le permite
                // a la evidencia distinguir "ya se cumplió" de "ve evidencia
                // de una solicitud anterior distinta".
                'creada_en' => (string) $solicitud['created_at'],
                'guias' => array_map(
                    static fn (array $g): array => [
                        'guia_id' => (int) $g['guia_id'],
                        'num_guia' => (string) $g['num_guia'],
                        'source' => $sourcesPorGuiaId[(int) $g['guia_id']] ?? null,
                    ],
                    $guias,
                ),
            ];
        }
    }

    protected function buscarEvidencia(mixed $item): Evidence
    {
        if (!$this->solicitudCompleta($item['guias'], $item['creada_en'])) {
            return Evidence::pendiente();
        }

        return $this->evidenceSource->buscar($item);
    }

    /**
     * Condición solicitudCompleta(): confirmada SOLO si todas las guías de la
     * solicitud cumplen la condición al mismo tiempo — patrón idéntico y sin
     * simplificaciones de LiberacionConfirmationWatcher::solicitudCompleta():
     * si en un lote de 3 guías 2 ya tienen datos y 1 no, la solicitud completa
     * queda en espera, NO transita a medias ni emite eventos fragmentados.
     *
     * @param array<int, array{guia_id: int, num_guia: string, source: ?string}> $guias
     */
    private function solicitudCompleta(array $guias, string $creadaEn): bool
    {
        return $this->evidenceSource->solicitudCompleta($guias, $creadaEn);
    }

    protected function alConfirmar(mixed $item, Evidence $evidencia): void
    {
        $solicitudId = (int) $item['solicitud_id'];

        if (!$this->solicitudRepository->marcarConcluida($solicitudId)) {
            // Protección contra concurencia si el estado cambió a uno terminal de forma paralela.
            return;
        }

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'CONCLUIDA',
            actor: self::ACTOR,
            detalle: null,
        );

        /**
         * @var array{solicitud_id: int, guias: array<int, array{guia_id: int, num_guia: string, source: ?string, factura_impresa: string, usuario: ?string}>} $dato
         *
         * Bug real (Sprint 9.2): una solicitud podía llegar a CONCLUIDA sin
         * pasar nunca por TIMBRADO (ver docblock de
         * TimbradoConclusionEvidenceSource::buscar()) — antes de esta
         * corrección, este método nunca escribía
         * `solicitud_timbrado_detalle.factura_impresa`, dejándolo vacío pese
         * a que el CFDI ya estaba correcto y completo en SICRET. Esto rompía
         * la descarga de PDF/XML (`public/api/timbrado-carta-porte.php`,
         * que exige `factura_impresa` no vacío) incluso con la solicitud ya
         * en CONCLUIDA. Se replica aquí, con la evidencia ya resuelta por
         * TimbradoConclusionEvidenceSource, el mismo `marcarFacturaImpresa()`
         * que ya usa TimbradoConfirmationWatcher::alConfirmar() para el
         * flujo de TIMBRADO — es idempotente (mismo UPDATE por guia_id), así
         * que corre sin riesgo tanto si TIMBRADO ya lo había poblado como si
         * esta es la primera vez que se escribe.
         */
        $dato = $evidencia->dato();
        $guias = $dato['guias'];

        $this->detalleRepository->marcarFacturaImpresa($solicitudId, array_map(
            static fn (array $g): array => ['guia_id' => $g['guia_id'], 'factura_impresa' => $g['factura_impresa']],
            $guias,
        ));

        // Mismo bug real (Sprint 9.2), esta vez sobre `guia_estado_tablero`
        // en lugar de `solicitud_timbrado_detalle`: una solicitud del Motor
        // de Timbrado Automático de trafico-system nunca pasa por
        // ESPERANDO_TIMBRADO, así que TimbradoConfirmationWatcher — el
        // único que hasta ahora escribía esta tabla — nunca se ejecuta para
        // ella. Sin esto, la guía queda para siempre sin fila en
        // `guia_estado_tablero` pese a estar timbrada y facturada de
        // verdad: sin badge de "timbrada" en trafico-system y sin entrada
        // de rescate en guia-historial.php (su bloque 2b exige justo esta
        // fila). Se reutiliza marcarTimbradoDirecto() — mismo método que ya
        // usa DirectStampingWatcher para el caso análogo de timbrado
        // directo en SICRET — es idempotente si TimbradoConfirmationWatcher
        // ya la había escrito antes (mismos valores).
        foreach ($guias as $guia) {
            $this->guiaEstadoTableroRepository?->marcarTimbradoDirecto($guia['guia_id'], $guia['factura_impresa']);
        }

        $this->eventPublisher->publish(self::EVENTO_CONCLUIDO, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => [
                    'id' => $g['guia_id'],
                    'num_guia' => $g['num_guia'],
                ],
                $guias,
            ),
        ]);

        $this->logger->info('TimbradoConclusionWatcher: solicitud concluida con folioFiscal e idccp', [
            'solicitud_id' => $solicitudId,
            'total_guias' => count($guias),
        ]);

        if ($this->dispatcher) {
            $sourcePorGuiaId = array_column($guias, 'source', 'guia_id');

            foreach ($guias as $guia) {
                $usuario = $guia['usuario'] ?? $this->resolverUsuarioAprobador($solicitudId);

                $this->dispatcher->dispatch(new TimbradoConcluded($guia['num_guia'], [
                    'solicitud_id' => $solicitudId,
                    'empresa' => $sourcePorGuiaId[$guia['guia_id']] ?? null,
                    'usuario' => $usuario,
                ]));
            }
        }
    }

    /**
     * Devuelve el actor del evento APROBADA de la bitácora si no se resolvió
     * un usuario desde SICRET. Ya no se realiza fallback al evento CREADA (quien
     * levantó la solicitud desde Tráfico), para evitar notificar erróneamente en
     * Mattermost que quien solicitó el timbrado fue quien lo realizó/aprobó.
     */
    private function resolverUsuarioAprobador(int $solicitudId): ?string
    {
        foreach ($this->historialRepository->porSolicitud($solicitudId) as $evento) {
            if ($evento['evento'] === 'APROBADA') {
                return $evento['actor'];
            }
        }

        return null;
    }

    protected function alFallar(mixed $item, string $motivo): void
    {
        $this->logger->error('TimbradoConclusionWatcher: evidencia fallida inesperada', [
            'solicitud_id' => $item['solicitud_id'] ?? null,
            'motivo' => $motivo,
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
