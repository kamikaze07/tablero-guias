<?php

declare(strict_types=1);

namespace App\Monitoring\Evidence;

/**
 * Estrategia de "dónde busco evidencia" — una implementación por origen
 * real (SicretStateEvidenceSource, FilesystemEvidenceSource; API/mensaje
 * cuando exista un caso de uso real, ver App\Monitoring\EvidenceWatcher).
 * El propio EvidenceWatcher nunca conoce cuál implementación usa.
 */
interface EvidenceSource
{
    public function buscar(mixed $item): Evidence;
}
