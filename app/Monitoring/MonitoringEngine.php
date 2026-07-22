<?php

declare(strict_types=1);

namespace App\Monitoring;

use App\Sync\HeartbeatStore;
use App\Sync\SyncLogger;
use App\Sync\Watcher;

/**
 * Orquestador genérico del Motor de Monitoreo — mismo rol y misma forma
 * que App\Sync\SynchronizationEngine, deliberadamente: un bucle que no
 * sabe nada de guías, liberaciones ni timbrados, solo ejecuta Watcher[]
 * y registra heartbeat. Toda la lógica de negocio vive en cada Watcher.
 *
 * Proceso independiente (bin/monitoring-engine.php, contenedor
 * atlas-monitoring) — nunca comparte ciclo de vida con
 * SynchronizationEngine/bin/sync-engine.php ni con sus watchers.
 *
 * A diferencia de SynchronizationEngine (hoy con un único Watcher), este
 * motor está pensado para correr varios Watcher simultáneos (Liberación,
 * y en el futuro Timbrado, Cancelaciones, etc.) — por eso cada uno
 * registra su propio heartbeat (`sync_heartbeat.engine_name` = nombre del
 * watcher) además del heartbeat agregado del proceso, y el fallo de un
 * Watcher nunca impide que los demás corran en el mismo ciclo.
 */
final class MonitoringEngine
{
    private const ENGINE_NAME = 'monitoring-engine';

    /** @param array<string, Watcher> $watchers nombre de watcher => Watcher, para heartbeat individual */
    public function __construct(
        private readonly array $watchers,
        private readonly HeartbeatStore $heartbeatStore,
        private readonly SyncLogger $logger,
        private readonly int $pollingIntervalSeconds,
    ) {
    }

    public function start(): void
    {
        $this->logger->info('MonitoringEngine iniciado', [
            'polling_interval_seconds' => $this->pollingIntervalSeconds,
            'watchers' => array_keys($this->watchers),
        ]);

        while (true) {
            $this->runCycle();
            sleep($this->pollingIntervalSeconds);
        }
    }

    private function runCycle(): void
    {
        $confirmadosTotal = 0;
        $huboError = false;

        foreach ($this->watchers as $nombre => $watcher) {
            try {
                $confirmados = $watcher->run();
                $confirmadosTotal += $confirmados;

                $this->heartbeatStore->recordCycle($nombre, 'idle', $confirmados);
            } catch (\Throwable $e) {
                $huboError = true;

                $this->logger->error('Error en watcher del Motor de Monitoreo', [
                    'watcher' => $nombre,
                    'error' => $e->getMessage(),
                ]);

                $this->heartbeatStore->recordCycle($nombre, 'error', 0, $e->getMessage());
            }
        }

        $this->heartbeatStore->recordCycle(self::ENGINE_NAME, $huboError ? 'error' : 'idle', $confirmadosTotal);

        if ($confirmadosTotal > 0) {
            $this->logger->info('Ciclo del Motor de Monitoreo completado', ['confirmados' => $confirmadosTotal]);
        }
    }
}
