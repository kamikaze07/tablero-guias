<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Domain\Events\GuideStamped;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Monitoring\Evidence\Evidence;
use App\Monitoring\EvidenceWatcher;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Sync\EventPublisher;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoDetalleRepository;

/**
 * Detecta guías que Facturación timbró directo en SICRET sin que Tráfico
 * levantara una Solicitud de Timbrado en el tablero — caso real: Facturación
 * ya sabe que debe timbrar y no espera la solicitud. A diferencia de
 * App\Monitoring\Timbrado\TimbradoConfirmationWatcher (que confirma una
 * Solicitud ya existente), aquí nunca hay una fila en `solicitud_timbrado`
 * que revisar: se parte directo de la guía cruda, con evidencia más
 * estricta (ver DirectStampingEvidenceSource) ya que no hay ningún
 * "ESPERANDO_TIMBRADO" previo que confirme la intención.
 *
 * pendientes() (ver SolicitudTimbradoDetalleRepository::pendientesTimbradoDirecto())
 * ya excluye tanto las guías con una Solicitud de Timbrado registrada
 * (esas las confirma TimbradoConfirmationWatcher) como las que este mismo
 * Watcher ya confirmó antes — nunca hay doble notificación entre los dos.
 */
final class DirectStampingWatcher extends EvidenceWatcher
{
    private const EVENTO_COMPLETADO = 'guia.timbrado_completado';
    private const DIAS_HACIA_ATRAS = 15;
    private const NOTA_MATTERMOST = 'Se timbró sin una Solicitud de Timbrado previa en el tablero.';

    public function __construct(
        private readonly SolicitudTimbradoDetalleRepository $detalleRepository,
        private readonly GuiaEstadoTableroRepository $guiaEstadoTableroRepository,
        private readonly DirectStampingEvidenceSource $evidenceSource,
        private readonly EventPublisher $eventPublisher,
        private readonly SyncLogger $logger,
        private readonly ?NotificationDispatcher $dispatcher = null,
    ) {
    }

    /** @return iterable<array{guia_id: int, num_guia: string, source: string}> */
    protected function pendientes(): iterable
    {
        return $this->detalleRepository->pendientesTimbradoDirecto(self::DIAS_HACIA_ATRAS);
    }

    protected function buscarEvidencia(mixed $item): Evidence
    {
        return $this->evidenceSource->buscar($item);
    }

    protected function alConfirmar(mixed $item, Evidence $evidencia): void
    {
        /** @var array{factura_impresa: string, estatus: string, usuario?: ?string} $dato */
        $dato = $evidencia->dato();
        $facturaImpresa = $dato['factura_impresa'];
        $usuario = $dato['usuario'] ?? null;

        $this->guiaEstadoTableroRepository->marcarTimbradoDirecto(
            (int) $item['guia_id'],
            $facturaImpresa,
        );

        $this->eventPublisher->publish(self::EVENTO_COMPLETADO, [
            'guias' => [[
                'id' => $item['guia_id'],
                'num_guia' => $item['num_guia'],
                'factura_impresa' => $facturaImpresa,
            ]],
        ]);

        $this->logger->info('DirectStampingWatcher: guía timbrada sin Solicitud de Timbrado', [
            'guia_id' => $item['guia_id'],
            'num_guia' => $item['num_guia'],
        ]);

        if ($this->dispatcher) {
            $this->dispatcher->dispatch(new GuideStamped($item['num_guia'], [
                'empresa' => $item['source'],
                'factura_impresa' => $facturaImpresa,
                'usuario' => $usuario,
                'nota' => self::NOTA_MATTERMOST,
            ]));
        }
    }

    /**
     * Nunca se espera invocar en la práctica — mismo motivo que
     * TimbradoConfirmationWatcher::alFallar(): una guía con "fuente
     * desconocida" o que deja de existir en SICRET es una inconsistencia
     * real que vale la pena registrar, pero no tiene ninguna transición de
     * estado que deshacer (nunca se marcó nada hasta que hay evidencia
     * confirmada).
     */
    protected function alFallar(mixed $item, string $motivo): void
    {
        $this->logger->error('DirectStampingWatcher: evidencia fallida inesperada', [
            'guia_id' => $item['guia_id'],
            'num_guia' => $item['num_guia'],
            'motivo' => $motivo,
        ]);
    }
}
