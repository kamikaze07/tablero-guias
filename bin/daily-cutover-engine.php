<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\DailyCutoverEngine;
use App\Dashboard\GuiaBoardRepository;
use App\Dashboard\ResumenDiarioRepository;
use App\Database\ConnectionFactory;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Sync\HeartbeatStore;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoRepository;

$config = new Config();
$connectionFactory = new ConnectionFactory();

$atlasConnection = $connectionFactory->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$logger = new SyncLogger(__DIR__ . '/../storage/logs/daily-cutover-engine.log');

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

$pollingIntervalSeconds = (int) $config->get('DAILY_CUTOVER_POLLING_INTERVAL_SECONDS', '60');

$contenedorLookup = new ContenedorLookup(
    new SourceRegistry($config, $connectionFactory, __DIR__ . '/../config/sources.php'),
    $logger,
);

$engine = new DailyCutoverEngine(
    new GuiaBoardRepository($atlasConnection, $contenedorLookup),
    new SolicitudLiberacionRepository($atlasConnection),
    new SolicitudTimbradoRepository($atlasConnection),
    new ResumenDiarioRepository($atlasConnection),
    $eventPublisher,
    new HeartbeatStore($atlasConnection),
    $logger,
    $pollingIntervalSeconds,
);

$engine->start();
