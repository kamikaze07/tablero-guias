<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\HeartbeatRepository;
use App\Database\ConnectionFactory;

const ENGINE_NAME = 'synchronization-engine';
const FRESHNESS_THRESHOLD_SECONDS = 10;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$heartbeat = (new HeartbeatRepository($connection))->latest(ENGINE_NAME);

$active = false;

if ($heartbeat !== null && $heartbeat['last_cycle_at'] !== null) {
    $lastCycle = new DateTimeImmutable((string) $heartbeat['last_cycle_at']);
    $secondsSinceLastCycle = (new DateTimeImmutable())->getTimestamp() - $lastCycle->getTimestamp();
    $active = $secondsSinceLastCycle <= FRESHNESS_THRESHOLD_SECONDS;
}

header('Content-Type: application/json');
echo json_encode([
    'active' => $active,
    'status' => $heartbeat['status'] ?? null,
    'last_cycle_at' => $heartbeat['last_cycle_at'] ?? null,
]);
