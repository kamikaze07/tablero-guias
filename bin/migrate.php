<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;

$config = new Config();
$factory = new ConnectionFactory();

$connection = $factory->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$schema = file_get_contents(__DIR__ . '/../database/schema.sql');

$connection->exec($schema);

echo "[OK] Esquema de ATLAS aplicado.\n";
