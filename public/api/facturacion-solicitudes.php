<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\JsonResponse;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Liberacion\SolicitudLiberacionService;
use App\Sync\SocketEventPublisher;
use App\Sync\SyncLogger;

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

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

$service = new SolicitudLiberacionService(
    $connection,
    new GuiaLookupRepository($connection),
    new GuiaEstadoTableroRepository($connection),
    new SolicitudLiberacionRepository($connection),
    new SolicitudLiberacionDetalleRepository($connection),
    new SolicitudLiberacionHistorialRepository($connection),
    $eventPublisher,
    $logger,
);

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

const SORT_PERMITIDOS = ['fecha', 'tiempo_espera', 'empresa', 'autorizo', 'num_guia'];

try {
    $numGuias = $_GET['num_guias'] ?? null;

    $filtros = [
        'estado' => $_GET['estado'] ?? null,
        'desde' => $_GET['desde'] ?? null,
        'hasta' => $_GET['hasta'] ?? null,
        'num_guia' => $_GET['num_guia'] ?? null,
        'num_guias' => is_array($numGuias) ? array_values(array_map('strval', $numGuias)) : null,
        'operador' => $_GET['operador'] ?? null,
        'source' => $_GET['empresa'] ?? null,
    ];

    $sortSolicitado = is_string($_GET['sort'] ?? null) ? $_GET['sort'] : 'fecha';
    $sort = in_array($sortSolicitado, SORT_PERMITIDOS, true) ? $sortSolicitado : 'fecha';
    $dir = strtoupper((string) ($_GET['dir'] ?? 'DESC')) === 'ASC' ? 'ASC' : 'DESC';
    $page = isset($_GET['page']) ? max(1, (int) $_GET['page']) : 1;
    $perPage = isset($_GET['perPage']) ? max(1, (int) $_GET['perPage']) : 25;

    JsonResponse::ok(200, $service->listarConDetalleGuia($filtros, $sort, $dir, $page, $perPage));
} catch (\Throwable $e) {
    $logger->error('Error inesperado en facturacion-solicitudes.php', ['error' => $e->getMessage()]);
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
