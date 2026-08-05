<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\ClienteLookup;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\JsonResponse;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\RutaLookup;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoRepository;
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

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

const SORT_PERMITIDOS = ['fecha', 'tiempo_espera', 'empresa', 'autorizo', 'num_guia'];

try {
    // El servicio completo se arma solo para reutilizar
    // SolicitudTimbradoService::listarConDetalleGuia() (evita duplicar el
    // JOIN/consulta ya definido ahí) — este endpoint no escribe nada, mismo
    // patrón que facturacion-solicitudes.php (Liberación).
    $sourceRegistry = new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../../config/sources.php');

    $service = new SolicitudTimbradoService(
        $connection,
        new GuiaLookupRepository($connection),
        new RutaLookup($sourceRegistry, $logger),
        new ContenedorLookup($sourceRegistry, $logger),
        new ClienteLookup($sourceRegistry, $logger),
        new SolicitudTimbradoRepository($connection),
        new SolicitudTimbradoDetalleRepository($connection),
        new SolicitudTimbradoHistorialRepository($connection),
        $eventPublisher,
        $logger,
    );

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
    $logger->error('Error inesperado en facturacion-solicitudes-timbrado.php', ['error' => $e->getMessage()]);
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
