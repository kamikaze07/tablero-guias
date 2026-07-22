<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\JsonResponse;
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

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

try {
    $repository = new GuiaEstadoTableroRepository($connection);

    $page = isset($_GET['page']) ? max(1, (int) $_GET['page']) : 1;
    $perPage = isset($_GET['perPage']) ? max(1, (int) $_GET['perPage']) : 25;

    JsonResponse::ok(200, [
        'total' => $repository->contarPorTimbrar(),
        'page' => $page,
        'perPage' => $perPage,
        'data' => $repository->listarPorTimbrar($page, $perPage),
    ]);
} catch (\Throwable $e) {
    $logger->error('Error inesperado en guias-liberadas.php', ['error' => $e->getMessage()]);
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
