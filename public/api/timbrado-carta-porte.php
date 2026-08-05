<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\JsonResponse;
use App\Timbrado\SolicitudTimbradoDetalleRepository;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    header('Content-Type: application/json');
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');

    return;
}

$numGuia = is_string($_GET['guia'] ?? null) ? trim($_GET['guia']) : '';

if ($numGuia === '') {
    header('Content-Type: application/json');
    JsonResponse::error(400, 'guia_requerida', 'El parámetro guia es requerido.');

    return;
}

// 1. Leer facturaimpresa — nunca desde un parámetro del cliente, siempre
// resuelto en el servidor (ver docblock de facturaImpresaConfirmadaPorNumGuia()).
// Dos fuentes posibles: la Solicitud de Timbrado normal (Tráfico levantó la
// solicitud), o guia_estado_tablero cuando Facturación timbró directo en
// SICRET sin solicitud previa (ver App\Monitoring\Timbrado\DirectStampingWatcher).
$detalleRepository = new SolicitudTimbradoDetalleRepository($connection);
$facturaImpresa = $detalleRepository->facturaImpresaConfirmadaPorNumGuia($numGuia);

if ($facturaImpresa === null) {
    $guiaEstadoTableroRepository = new GuiaEstadoTableroRepository($connection);
    $facturaImpresa = $guiaEstadoTableroRepository->facturaImpresaConfirmadaPorNumGuia($numGuia);
}

if ($facturaImpresa === null) {
    header('Content-Type: application/json');
    JsonResponse::error(
        404,
        'sin_carta_porte',
        'La guía aún no cuenta con un Complemento Carta Porte timbrado.',
    );

    return;
}

// Defensa en profundidad: aunque el valor viene de la BD (no del cliente),
// nunca se usa para construir una ruta de archivo sin validar su forma —
// SICRET solo genera folios alfanuméricos (p. ej. "PR04519").
if (!preg_match('/^[A-Za-z0-9]+$/', $facturaImpresa)) {
    header('Content-Type: application/json');
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');

    return;
}

// 2. Localizar el PDF dentro de la carpeta OUT (mismo puente temporal que
// App\Monitoring\Timbrado\StampingEvidenceSource — ver ese archivo para el
// porqué de esta carpeta y su mapeo real en docker-compose.yml).
$outPath = (string) $config->get('SICRET_TIMBRADO_OUT_PATH', '');
$rutaPdf = rtrim($outPath, '/') . '/' . $facturaImpresa . '.pdf';

// 3. Verificar que exista.
if ($outPath === '' || !is_file($rutaPdf)) {
    header('Content-Type: application/json');
    JsonResponse::error(404, 'archivo_no_encontrado', 'El Complemento Carta Porte no fue encontrado.');

    return;
}

// 4. Descargar.
header('Content-Type: application/pdf');
header('Content-Disposition: attachment; filename="' . $facturaImpresa . '.pdf"');
header('Content-Length: ' . (string) filesize($rutaPdf));
header('X-Content-Type-Options: nosniff');

readfile($rutaPdf);
