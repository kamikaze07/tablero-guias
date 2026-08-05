<?php

declare(strict_types=1);

namespace App\Dashboard;

use App\Liberacion\SolicitudLiberacionRepository;
use App\Sync\EventPublisher;
use App\Sync\HeartbeatStore;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoRepository;

/**
 * Corte de jornada operativa (07:00, ver App\Dashboard\BusinessDay) de los
 * tableros de Tráfico y Facturación — mismo rol y misma forma que
 * App\Sync\SynchronizationEngine / App\Monitoring\MonitoringEngine
 * (bucle propio + heartbeat), deliberadamente: proceso independiente
 * (bin/daily-cutover-engine.php, contenedor atlas-daily-cutover).
 *
 * No "limpia" ninguna tabla: findToday()/kpis() ya recalculan la ventana
 * de "hoy" contra las 07:00 en cada lectura (ver BusinessDay::containing());
 * este motor solo persiste el resumen de la jornada que acaba de cerrar y
 * avisa a los tableros abiertos para que refresquen de inmediato.
 */
final class DailyCutoverEngine
{
    private const ENGINE_NAME = 'daily-cutover-engine';

    public function __construct(
        private readonly GuiaBoardRepository $guiaBoardRepository,
        private readonly SolicitudLiberacionRepository $liberacionRepository,
        private readonly SolicitudTimbradoRepository $timbradoRepository,
        private readonly ResumenDiarioRepository $resumenRepository,
        private readonly EventPublisher $eventPublisher,
        private readonly HeartbeatStore $heartbeatStore,
        private readonly SyncLogger $logger,
        private readonly int $pollingIntervalSeconds,
    ) {
    }

    public function start(): void
    {
        $this->logger->info('DailyCutoverEngine iniciado', [
            'polling_interval_seconds' => $this->pollingIntervalSeconds,
        ]);

        while (true) {
            $this->runCycle();
            sleep($this->pollingIntervalSeconds);
        }
    }

    private function runCycle(): void
    {
        try {
            $generado = $this->generarResumenSiHaceFalta();

            $this->heartbeatStore->recordCycle(self::ENGINE_NAME, 'idle', $generado ? 1 : 0);

            if ($generado) {
                $this->logger->info('Resumen diario generado en el corte de jornada');
            }
        } catch (\Throwable $e) {
            $this->logger->error('Error en el ciclo del corte de jornada', ['error' => $e->getMessage()]);
            $this->heartbeatStore->recordCycle(self::ENGINE_NAME, 'error', 0, $e->getMessage());
        }
    }

    private function generarResumenSiHaceFalta(): bool
    {
        $dia = BusinessDay::previous(new \DateTimeImmutable());

        if ($this->resumenRepository->existe($dia->fecha)) {
            return false;
        }

        $liberacion = $this->liberacionRepository->contarResueltasEnVentana($dia->desde, $dia->hasta);
        $timbrado = $this->timbradoRepository->contarResueltasEnVentana($dia->desde, $dia->hasta);

        $resumen = [
            'guias_creadas' => $this->guiaBoardRepository->contarGeneradasEnVentana($dia->desde, $dia->hasta),
            'timbrado_aprobadas' => $timbrado['aprobadas'],
            'timbrado_rechazadas' => $timbrado['rechazadas'],
            'liberacion_aprobadas' => $liberacion['aprobadas'],
            'liberacion_rechazadas' => $liberacion['rechazadas'],
        ];

        $this->resumenRepository->guardar($dia->fecha, $resumen);

        $this->eventPublisher->publish('dashboard.reset_diario', [
            'fecha' => $dia->fecha,
            'resumen' => $resumen,
        ]);

        return true;
    }
}
