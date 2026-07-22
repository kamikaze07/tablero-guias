<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\GuiaBoardRepository;
use App\Database\ConnectionFactory;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$boardState = (new GuiaBoardRepository($connection))->boardState();
$websocketPort = (int) $config->get('WEBSOCKET_PORT', '8098');

require __DIR__ . '/../resources/views/trafico.php';
