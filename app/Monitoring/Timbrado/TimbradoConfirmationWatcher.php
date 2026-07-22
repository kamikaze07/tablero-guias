<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Domain\Events\GuideStamped;
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
 * Puente TEMPORAL entre ATLAS y el timbrado manual de SICRET — ver
 * App\Monitoring\Timbrado\StampingEvidenceSource para las dos condiciones
 * de evidencia. El día que Forsis timbre directamente desde su propio
 * sistema de Facturación, esta clase (y su entry point en
 * bin/monitoring-engine.php) se elimina sin tocar nada más del Runtime:
 * ningún otro componente conoce la carpeta OUT ni el formato del XML,
 * todos reaccionan únicamente al evento de dominio `guia.timbrado_completado`
 * / `GuideStamped` que este watcher emite.
 *
 * Mismo patrón que
 * App\Monitoring\Liberacion\LiberationConfirmationWatcher, con una
 * diferencia deliberada: aquí cada "pendiente" es la SOLICITUD completa
 * (todas sus guías), no una guía individual — evita tener que agregar una
 * columna de estado por guía a `solicitud_timbrado_detalle` solo para este
 * puente temporal (ver StampingEvidenceSource::buscar(), confirma todo o
 * nada).
 */
final class TimbradoConfirmationWatcher extends EvidenceWatcher
{
    private const EVENTO_COMPLETADO = 'guia.timbrado_completado';
    private const ACTOR = 'timbrado-confirmation-watcher';

    public function __construct(
        private readonly SolicitudTimbradoRepository $solicitudRepository,
        private readonly SolicitudTimbradoDetalleRepository $detalleRepository,
        private readonly GuiaLookupRepository $guiaLookupRepository,
        private readonly SolicitudTimbradoHistorialRepository $historialRepository,
        private readonly StampingEvidenceSource $evidenceSource,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
    ) {
    }

    /** @return iterable<array{solicitud_id: int, guias: array<int, array{guia_id: int, num_guia: string, source: ?string}>}> */
    protected function pendientes(): iterable
    {
        foreach ($this->solicitudRepository->listarPorEstado(SolicitudTimbradoRepository::ESTADO_ESPERANDO_TIMBRADO) as $solicitud) {
            $solicitudId = (int) $solicitud['id'];
            $guias = $this->detalleRepository->porSolicitud($solicitudId);
            $sourcesPorGuiaId = $this->resolverSources(array_column($guias, 'guia_id'));

            yield [
                'solicitud_id' => $solicitudId,
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
        return $this->evidenceSource->buscar($item);
    }

    protected function alConfirmar(mixed $item, Evidence $evidencia): void
    {
        $solicitudId = (int) $item['solicitud_id'];

        if (!$this->solicitudRepository->marcarTimbrado($solicitudId)) {
            // Ya no estaba en ESPERANDO_TIMBRADO (otro ciclo se adelantó) —
            // nada que hacer, se ignora sin error.
            return;
        }

        $this->historialRepository->registrar(
            solicitudId: $solicitudId,
            evento: 'TIMBRADO',
            actor: self::ACTOR,
            detalle: null,
        );

        /** @var array{guias: array<int, array{guia_id: int, num_guia: string, factura_impresa: string}>} $dato */
        $dato = $evidencia->dato();
        $guias = $dato['guias'];

        $this->eventPublisher->publish(self::EVENTO_COMPLETADO, [
            'solicitud_id' => $solicitudId,
            'guias' => array_map(
                static fn (array $g): array => [
                    'id' => $g['guia_id'],
                    'num_guia' => $g['num_guia'],
                    'factura_impresa' => $g['factura_impresa'],
                ],
                $guias,
            ),
        ]);

        $this->logger->info('TimbradoConfirmationWatcher: solicitud timbrada', [
            'solicitud_id' => $solicitudId,
            'total_guias' => count($guias),
        ]);

        if ($this->dispatcher) {
            foreach ($guias as $guia) {
                $this->dispatcher->dispatch(new GuideStamped($guia['num_guia'], [
                    'solicitud_id' => $solicitudId,
                    'factura_impresa' => $guia['factura_impresa'],
                ]));
            }
        }
    }

    /**
     * Nunca se invoca en la práctica: StampingEvidenceSource nunca
     * devuelve evidencia fallida (ver docblock de esa clase — el sprint
     * solo contempla dos desenlaces, pendiente o confirmado). Se
     * implementa igual, sin transición de estado, porque EvidenceWatcher
     * lo exige como parte de su contrato común con
     * LiberationConfirmationWatcher.
     */
    protected function alFallar(mixed $item, string $motivo): void
    {
        $this->logger->error('TimbradoConfirmationWatcher: evidencia fallida inesperada', [
            'solicitud_id' => $item['solicitud_id'],
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
