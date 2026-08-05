<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Infrastructure\Sicret\PdoSicretGateway;
use App\Infrastructure\Sicret\SicretWriteLogRepository;
use App\Liberacion\Execution\LiberacionExecutor;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Monitoring\Liberacion\LiberationConfirmationWatcher;
use App\Monitoring\Liberacion\SicretStateEvidenceSource;
use App\Monitoring\MonitoringEngine;
use App\Monitoring\Timbrado\DirectStampingEvidenceSource;
use App\Monitoring\Timbrado\DirectStampingWatcher;
use App\Monitoring\Timbrado\FiscalDataEvidenceSource;
use App\Monitoring\Timbrado\FiscalDataWatcher;
use App\Monitoring\Timbrado\StampingEvidenceSource;
use App\Monitoring\Timbrado\TimbradoConclusionEvidenceSource;
use App\Monitoring\Timbrado\TimbradoConclusionWatcher;
use App\Monitoring\Timbrado\TimbradoConfirmationWatcher;
use App\Notifications\Consumers\Mattermost\MattermostConsumer;
use App\Notifications\Consumers\Mattermost\MattermostHttpClient;
use App\Notifications\Consumers\Mattermost\MattermostRouter;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoConcludedTemplate;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Sync\HeartbeatStore;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
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

$logger = new SyncLogger(__DIR__ . '/../storage/logs/monitoring-engine.log');

// Solo lectura hacia SICRET — misma fuente que usa App\Sync, reutilizada
// aquí para que LiberationConfirmationWatcher confirme evidencia sin abrir
// una conexión propia.
$readSourceRegistry = new SourceRegistry(
    $config,
    $connectionFactory,
    __DIR__ . '/../config/sources.php',
);

// Escritura hacia SICRET — exclusiva de PdoSicretGateway, nunca compartida
// con $readSourceRegistry. Ver App\Infrastructure\Sicret\PdoSicretGateway
// sobre por qué liberar() todavía no ejecuta ninguna escritura real.
$writeSourceRegistry = new SourceRegistry(
    $config,
    $connectionFactory,
    __DIR__ . '/../config/sources-write.php',
);

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

$solicitudRepository = new SolicitudLiberacionRepository($atlasConnection);
$detalleRepository = new SolicitudLiberacionDetalleRepository($atlasConnection);
$historialRepository = new SolicitudLiberacionHistorialRepository($atlasConnection);
$guiaEstadoTableroRepository = new GuiaEstadoTableroRepository($atlasConnection);
$guiaLookupRepository = new GuiaLookupRepository($atlasConnection);

$sicretGateway = new PdoSicretGateway(
    $writeSourceRegistry,
    new SicretWriteLogRepository($atlasConnection),
    $logger,
);

$liberacionExecutor = new LiberacionExecutor(
    $solicitudRepository,
    $detalleRepository,
    $guiaLookupRepository,
    $guiaEstadoTableroRepository,
    $historialRepository,
    $sicretGateway,
    $eventPublisher,
    $logger,
);

$liberationConfirmationWatcher = new LiberationConfirmationWatcher(
    $solicitudRepository,
    $detalleRepository,
    $guiaLookupRepository,
    $guiaEstadoTableroRepository,
    $historialRepository,
    new SicretStateEvidenceSource(
        $readSourceRegistry,
        $logger,
        $config->get('SICRET_LIBERACION_ESTATUS_CONFIRMACION'),
    ),
    $eventPublisher,
);

// Notificaciones (Mattermost) para eventos de dominio emitidos por
// watchers de este motor — mismo patrón que public/api/solicitudes-*.php,
// duplicado aquí porque este proceso (bin/monitoring-engine.php) corre
// aparte de php-fpm y no comparte estado con las peticiones HTTP.
$mattermostClient = new MattermostHttpClient(
    $config->get('MATTERMOST_WEBHOOK', ''),
    $config->get('MATTERMOST_BOT_USERNAME', 'ATLAS'),
    $config->get('MATTERMOST_URL', ''),
    $config->get('MATTERMOST_TOKEN', ''),
    $config->get('MATTERMOST_TEAM', ''),
);
$router = new MattermostRouter(
    $config->get('MATTERMOST_CHANNEL_ANUNCIOS', 'anuncios'),
    $config->get('MATTERMOST_CHANNEL_TRAFICO', 'trafico'),
    $config->get('MATTERMOST_CHANNEL_FACTURACION', 'facturacion'),
    $config->get('MATTERMOST_CHANNEL_TIMBRES_FISCALES', 'timbres-fiscales'),
);
$mattermostConsumer = new MattermostConsumer($router, $mattermostClient);
$mattermostConsumer->registerTemplate(new GuideStampedTemplate());
$mattermostConsumer->registerTemplate(new TimbradoConcludedTemplate());
$dispatcher = new NotificationDispatcher();
$dispatcher->registerConsumer($mattermostConsumer);

$solicitudTimbradoDetalleRepository = new SolicitudTimbradoDetalleRepository($atlasConnection);
$sicretTimbradoOutPath = (string) $config->get('SICRET_TIMBRADO_OUT_PATH', '');

// Puente TEMPORAL con el timbrado manual de SICRET — ver
// App\Monitoring\Timbrado\TimbradoConfirmationWatcher y
// App\Monitoring\Timbrado\StampingEvidenceSource. Se elimina el día que
// Forsis timbre directamente desde su propio sistema de Facturación, sin
// tocar el resto de este archivo.
$timbradoConfirmationWatcher = new TimbradoConfirmationWatcher(
    new SolicitudTimbradoRepository($atlasConnection),
    $solicitudTimbradoDetalleRepository,
    $guiaLookupRepository,
    $guiaEstadoTableroRepository,
    new SolicitudTimbradoHistorialRepository($atlasConnection),
    new StampingEvidenceSource(
        $readSourceRegistry,
        $logger,
        $sicretTimbradoOutPath,
    ),
    $eventPublisher,
    $logger,
    $dispatcher,
);

// Guías que Facturación timbra directo en SICRET sin que Tráfico levante
// una Solicitud de Timbrado — ver App\Monitoring\Timbrado\DirectStampingWatcher.
// Comparte $solicitudTimbradoDetalleRepository con el Watcher de arriba
// únicamente para leer (pendientesTimbradoDirecto()), nunca para escribir
// sobre la misma solicitud.
$directStampingWatcher = new DirectStampingWatcher(
    $solicitudTimbradoDetalleRepository,
    $guiaEstadoTableroRepository,
    new DirectStampingEvidenceSource(
        $readSourceRegistry,
        $logger,
        $sicretTimbradoOutPath,
    ),
    $eventPublisher,
    $logger,
    $dispatcher,
);

// Backfill de folioFiscal/idccp en facturas33 — ver
// App\Monitoring\Timbrado\FiscalDataWatcher. Independiente de los dos
// watchers de arriba a propósito: lee `facturas33` directo en SICRET, no
// necesita saber si la guía pasó por una Solicitud de Timbrado o se
// timbró directo.
$fiscalDataWatcher = new FiscalDataWatcher(
    $readSourceRegistry,
    new FiscalDataEvidenceSource($logger, $sicretTimbradoOutPath),
    $sicretGateway,
    $logger,
);

$timbradoConclusionWatcher = new TimbradoConclusionWatcher(
    new SolicitudTimbradoRepository($atlasConnection),
    $solicitudTimbradoDetalleRepository,
    $guiaLookupRepository,
    new SolicitudTimbradoHistorialRepository($atlasConnection),
    new TimbradoConclusionEvidenceSource($readSourceRegistry, $logger),
    $eventPublisher,
    $logger,
    $dispatcher,
);

// Un Watcher por proceso de negocio confirmable. Agregar uno nuevo es una
// clase nueva + una línea aquí — ver knowledge/ sobre por qué no hay un
// registro dinámico/config-driven todavía (no se justifica con pocos
// watchers).
$watchers = [
    'liberacion-executor' => $liberacionExecutor,
    'liberacion-confirmacion' => $liberationConfirmationWatcher,
    'timbrado-confirmacion' => $timbradoConfirmationWatcher,
    'timbrado-directo' => $directStampingWatcher,
    'timbrado-datos-fiscales' => $fiscalDataWatcher,
    'timbrado-conclusion' => $timbradoConclusionWatcher,
];

$pollingIntervalSeconds = (int) $config->get('MONITORING_POLLING_INTERVAL_SECONDS', '10');

$engine = new MonitoringEngine(
    $watchers,
    new HeartbeatStore($atlasConnection),
    $logger,
    $pollingIntervalSeconds,
);

$engine->start();
