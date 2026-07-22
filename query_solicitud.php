<?php
require __DIR__ . '/vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;

$config = new Config();
$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$stmt = $connection->prepare("SELECT id FROM guias WHERE num_guia = 'PR-225897'");
$stmt->execute();
$guia_id = $stmt->fetchColumn();

if (!$guia_id) {
    echo "Guia PR-225897 not found in ATLAS\n";
    exit;
}

echo "Guia ID: $guia_id\n";

$stmt = $connection->prepare("SELECT * FROM solicitud_liberacion_detalle WHERE guia_id = ?");
$stmt->execute([$guia_id]);
$detalles = $stmt->fetchAll(PDO::FETCH_ASSOC);

print_r($detalles);

foreach ($detalles as $d) {
    $stmt = $connection->prepare("SELECT * FROM solicitud_liberacion WHERE id = ?");
    $stmt->execute([$d['solicitud_id']]);
    print_r($stmt->fetch(PDO::FETCH_ASSOC));

    $stmt = $connection->prepare("SELECT * FROM solicitud_liberacion_historial WHERE solicitud_id = ?");
    $stmt->execute([$d['solicitud_id']]);
    print_r($stmt->fetchAll(PDO::FETCH_ASSOC));
}

$stmt = $connection->prepare("SELECT * FROM guia_estado_tablero WHERE guia_id = ?");
$stmt->execute([$guia_id]);
print_r($stmt->fetchAll(PDO::FETCH_ASSOC));

