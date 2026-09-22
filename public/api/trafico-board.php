<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\GuiaBoardRepository;
use App\Database\ConnectionFactory;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\JsonResponse;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;

header('Content-Type: application/json');

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$contenedorLookup = new ContenedorLookup(
    new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../../config/sources.php'),
    new SyncLogger(__DIR__ . '/../../storage/logs/api.log'),
);

try {
    $boardState = (new GuiaBoardRepository($connection, $contenedorLookup))->boardState();

    JsonResponse::ok(200, $boardState);
} catch (\Throwable $e) {
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
