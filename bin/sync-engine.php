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
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Notifications\Consumers\Mattermost\MattermostConsumer;
use App\Notifications\Consumers\Mattermost\MattermostRouter;
use App\Notifications\Consumers\Mattermost\MattermostClient;
use App\Notifications\Consumers\Mattermost\Templates\GuideCreatedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionApprovedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRejectedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampFailedTemplate;

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

$mattermostClient = new class implements MattermostClient {
    public function sendMessage(string $channel, string $message): void {
        error_log("Mattermost [{$channel}]: \n{$message}");
    }
};

$router = new MattermostRouter();
$mattermostConsumer = new MattermostConsumer($router, $mattermostClient);
$mattermostConsumer->registerTemplate(new GuideCreatedTemplate());
$mattermostConsumer->registerTemplate(new TimbradoRequestedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionRequestedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionApprovedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionRejectedTemplate());
$mattermostConsumer->registerTemplate(new GuideStampedTemplate());
$mattermostConsumer->registerTemplate(new GuideStampFailedTemplate());

$dispatcher = new NotificationDispatcher();
$dispatcher->registerConsumer($mattermostConsumer);

$guideWatcher = new GuideWatcher(
    $sourceRegistry,
    new CheckpointStore($atlasConnection),
    new GuiaRepository($atlasConnection),
    $eventPublisher,
    $logger,
    $dispatcher,
);

$pollingIntervalSeconds = (int) $config->get('SYNC_POLLING_INTERVAL_SECONDS', '2');

$engine = new SynchronizationEngine(
    [$guideWatcher],
    new HeartbeatStore($atlasConnection),
    $logger,
    $pollingIntervalSeconds,
);

$engine->start();
