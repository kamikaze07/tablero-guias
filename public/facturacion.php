<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Liberacion\SolicitudLiberacionService;
use App\Sync\SocketEventPublisher;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoRepository;
use App\Timbrado\SolicitudTimbradoService;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$logger = new SyncLogger(__DIR__ . '/../storage/logs/api.log');

$guiaEstadoTableroRepository = new GuiaEstadoTableroRepository($connection);

$service = new SolicitudLiberacionService(
    $connection,
    new GuiaLookupRepository($connection),
    $guiaEstadoTableroRepository,
    new SolicitudLiberacionRepository($connection),
    new SolicitudLiberacionDetalleRepository($connection),
    new SolicitudLiberacionHistorialRepository($connection),
    new SocketEventPublisher(
        $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
        (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
        $logger,
    ),
    $logger,
);

$timbradoService = new SolicitudTimbradoService(
    $connection,
    new GuiaLookupRepository($connection),
    new SolicitudTimbradoRepository($connection),
    new SolicitudTimbradoDetalleRepository($connection),
    new SolicitudTimbradoHistorialRepository($connection),
    new SocketEventPublisher(
        $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
        (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
        $logger,
    ),
    $logger,
);

// Primer pintado sin flash de carga — mismo patrón que public/trafico.php
// (server-render del estado inicial, WebSocket solo para cambios
// posteriores).
$solicitudesIniciales = $service->listarConDetalleGuia(['estado' => 'PENDIENTE'], 'fecha', 'DESC', 1, 25);
$timbradoIniciales = $timbradoService->listar(['estado' => 'PENDIENTE'], 1, 25);
$porTimbrarInicial = [
    'total' => $guiaEstadoTableroRepository->contarPorTimbrar(),
    'page' => 1,
    'perPage' => 25,
    'data' => $guiaEstadoTableroRepository->listarPorTimbrar(1, 25),
];
$kpisIniciales = $service->kpis();

$websocketPort = (int) $config->get('WEBSOCKET_PORT', '8098');

require __DIR__ . '/../resources/views/facturacion.php';
