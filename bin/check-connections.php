<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;

$config = new Config();
$factory = new ConnectionFactory();

$connections = [
    'ATLAS' => 'ATLAS_DB',
    'FORSIS' => 'FORSIS_DB',
    'FORSIS_2' => 'FORSIS_2_DB',
    'GERO' => 'GERO_DB',
    'GERO_2' => 'GERO_2_DB',
];

foreach ($connections as $name => $prefix) {
    $connectionConfig = [
        'host' => $config->get("{$prefix}_HOST"),
        'port' => $config->get("{$prefix}_PORT"),
        'database' => $config->get("{$prefix}_DATABASE"),
        'username' => $config->get("{$prefix}_USERNAME"),
        'password' => $config->get("{$prefix}_PASSWORD"),
    ];

    try {
        $factory->make($connectionConfig);
        echo "[OK] {$name}\n";
    } catch (PDOException $e) {
        echo "[FALLO] {$name}: {$e->getMessage()}\n";
    }
}
