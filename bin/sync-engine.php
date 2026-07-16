<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Sync\CheckpointStore;
use App\Sync\GuiaRepository;
use App\Sync\GuideWatcher;
use App\Sync\HeartbeatStore;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Sync\SynchronizationEngine;

$config = new Config();
$connectionFactory = new ConnectionFactory();

$atlasConnection = $connectionFactory->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$sourceRegistry = new SourceRegistry(
    $config,
    $connectionFactory,
    __DIR__ . '/../config/sources.php',
);

$logger = new SyncLogger(__DIR__ . '/../storage/logs/sync-engine.log');

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

$guideWatcher = new GuideWatcher(
    $sourceRegistry,
    new CheckpointStore($atlasConnection),
    new GuiaRepository($atlasConnection),
    $eventPublisher,
    $logger,
);

$pollingIntervalSeconds = (int) $config->get('SYNC_POLLING_INTERVAL_SECONDS', '2');

$engine = new SynchronizationEngine(
    [$guideWatcher],
    new HeartbeatStore($atlasConnection),
    $logger,
    $pollingIntervalSeconds,
);

$engine->start();
