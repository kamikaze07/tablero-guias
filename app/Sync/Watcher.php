<?php

declare(strict_types=1);

namespace App\Sync;

interface Watcher
{
    /**
     * Ejecuta una única pasada de sincronización y devuelve el número
     * de registros nuevos confirmados en ATLAS. El bucle de repetición
     * en el tiempo es responsabilidad exclusiva del SynchronizationEngine.
     */
    public function run(): int;
}
