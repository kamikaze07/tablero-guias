<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\BusinessDay;
use App\Dashboard\GuiaBoardRepository;
use App\Database\ConnectionFactory;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoRepository;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$contenedorLookup = new ContenedorLookup(
    new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../config/sources.php'),
    new SyncLogger(__DIR__ . '/../storage/logs/api.log'),
);

$guiaBoardRepository = new GuiaBoardRepository($connection, $contenedorLookup);
$boardState = $guiaBoardRepository->boardState();
$websocketPort = (int) $config->get('WEBSOCKET_PORT', '8098');

$dia = BusinessDay::containing(new \DateTimeImmutable());
$timbradoResueltas = (new SolicitudTimbradoRepository($connection))->contarResueltasEnVentana($dia->desde, $dia->hasta);
$liberacionResueltas = (new SolicitudLiberacionRepository($connection))->contarResueltasEnVentana($dia->desde, $dia->hasta);

$kpisIniciales = [
    'guias_creadas' => $guiaBoardRepository->contarGeneradasEnVentana($dia->desde, $dia->hasta),
    'timbrado_aprobadas' => $timbradoResueltas['aprobadas'],
    'timbrado_rechazadas' => $timbradoResueltas['rechazadas'],
    'liberacion_aprobadas' => $liberacionResueltas['aprobadas'],
    'liberacion_rechazadas' => $liberacionResueltas['rechazadas'],
];

require __DIR__ . '/../resources/views/trafico.php';
