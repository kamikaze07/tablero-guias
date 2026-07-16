<?php

declare(strict_types=1);

namespace App\Sync;

final class SynchronizationEngine
{
    private const ENGINE_NAME = 'synchronization-engine';

    /** @param Watcher[] $watchers */
    public function __construct(
        private readonly array $watchers,
        private readonly HeartbeatStore $heartbeatStore,
        private readonly SyncLogger $logger,
        private readonly int $pollingIntervalSeconds,
    ) {
    }

    public function start(): void
    {
        $this->logger->info('SynchronizationEngine iniciado', [
            'polling_interval_seconds' => $this->pollingIntervalSeconds,
            'watchers' => count($this->watchers),
        ]);

        while (true) {
            $this->runCycle();
            sleep($this->pollingIntervalSeconds);
        }
    }

    private function runCycle(): void
    {
        try {
            $synced = 0;

            foreach ($this->watchers as $watcher) {
                $synced += $watcher->run();
            }

            $this->heartbeatStore->recordCycle(self::ENGINE_NAME, 'idle', $synced);

            if ($synced > 0) {
                $this->logger->info('Ciclo de sincronización completado', ['registros_sincronizados' => $synced]);
            }
        } catch (\Throwable $e) {
            $this->logger->error('Error en el ciclo de sincronización', ['error' => $e->getMessage()]);
            $this->heartbeatStore->recordCycle(self::ENGINE_NAME, 'error', 0, $e->getMessage());
        }
    }
}
