<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\BusinessDay;
use App\Dashboard\GuiaBoardRepository;
use App\Database\ConnectionFactory;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\JsonResponse;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoRepository;

header('Content-Type: application/json');

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

try {
    JsonResponse::ok(200, kpisTrafico($connection));
} catch (\Throwable $e) {
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}

/** @return array{guias_creadas: int, timbrado_aprobadas: int, timbrado_rechazadas: int, liberacion_aprobadas: int, liberacion_rechazadas: int} */
function kpisTrafico(\PDO $connection): array
{
    $dia = BusinessDay::containing(new \DateTimeImmutable());

    $timbrado = (new SolicitudTimbradoRepository($connection))->contarResueltasEnVentana($dia->desde, $dia->hasta);
    $liberacion = (new SolicitudLiberacionRepository($connection))->contarResueltasEnVentana($dia->desde, $dia->hasta);

    $config = new Config();
    $contenedorLookup = new ContenedorLookup(
        new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../../config/sources.php'),
        new SyncLogger(__DIR__ . '/../../storage/logs/api.log'),
    );

    return [
        'guias_creadas' => (new GuiaBoardRepository($connection, $contenedorLookup))->contarGeneradasEnVentana($dia->desde, $dia->hasta),
        'timbrado_aprobadas' => $timbrado['aprobadas'],
        'timbrado_rechazadas' => $timbrado['rechazadas'],
        'liberacion_aprobadas' => $liberacion['aprobadas'],
        'liberacion_rechazadas' => $liberacion['rechazadas'],
    ];
}
