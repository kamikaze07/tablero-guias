<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\FacturacionResumenKpis;
use App\Database\ConnectionFactory;
use App\Liberacion\ClienteLookup;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\JsonResponse;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Liberacion\SolicitudLiberacionService;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;

use App\Timbrado\RutaLookup;
use App\Timbrado\SolicitudTimbradoRepository;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoService;

header('Content-Type: application/json');

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$logger = new SyncLogger(__DIR__ . '/../../storage/logs/api.log');

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

try {
    $eventPublisher = new SocketEventPublisher(
        $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
        (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
        $logger,
    );

    $sourceRegistry = new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../../config/sources.php');
    $contenedorLookup = new ContenedorLookup($sourceRegistry, $logger);
    $rutaLookup = new RutaLookup($sourceRegistry, $logger);
    $clienteLookup = new ClienteLookup($sourceRegistry, $logger);

    $liberacionService = new SolicitudLiberacionService(
        $connection,
        new GuiaLookupRepository($connection),
        $contenedorLookup,
        $rutaLookup,
        $clienteLookup,
        new GuiaEstadoTableroRepository($connection),
        new SolicitudLiberacionRepository($connection),
        new SolicitudLiberacionDetalleRepository($connection),
        new SolicitudLiberacionHistorialRepository($connection),
        $eventPublisher,
        $logger,
    );

    $timbradoService = new SolicitudTimbradoService(
        $connection,
        new GuiaLookupRepository($connection),
        $rutaLookup,
        $contenedorLookup,
        $clienteLookup,
        new SolicitudTimbradoRepository($connection),
        new SolicitudTimbradoDetalleRepository($connection),
        new SolicitudTimbradoHistorialRepository($connection),
        $eventPublisher,
        $logger,
    );
    
    $kpisLiberacion = $liberacionService->kpis();
    $kpisTimbrado = $timbradoService->kpis();

    JsonResponse::ok(200, [
        'liberacion' => $kpisLiberacion,
        'timbrado' => $kpisTimbrado,
        'guias_por_timbrar' => $kpisLiberacion['guias_por_timbrar'] ?? 0,
        'resumen' => FacturacionResumenKpis::combinar($kpisLiberacion, $kpisTimbrado),
    ]);
} catch (\Throwable $e) {
    $logger->error('Error inesperado en facturacion-kpis.php', ['error' => $e->getMessage()]);
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
