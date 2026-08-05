<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Dashboard\FacturacionResumenKpis;
use App\Database\ConnectionFactory;
use App\Liberacion\ClienteLookup;
use App\Liberacion\ContenedorLookup;
use App\Liberacion\GuiaEstadoTableroRepository;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\SicretEstatusLookup;
use App\Liberacion\SolicitudLiberacionDetalleRepository;
use App\Liberacion\SolicitudLiberacionHistorialRepository;
use App\Liberacion\SolicitudLiberacionRepository;
use App\Liberacion\SolicitudLiberacionService;
use App\Sync\SocketEventPublisher;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use App\Timbrado\RutaLookup;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoRepository;
use App\Timbrado\SolicitudTimbradoService;

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$logger = new SyncLogger(__DIR__ . '/../storage/logs/api.log');

$guiaEstadoTableroRepository = new GuiaEstadoTableroRepository($connection);

$sourceRegistry = new SourceRegistry($config, new ConnectionFactory(), __DIR__ . '/../config/sources.php');
$contenedorLookup = new ContenedorLookup($sourceRegistry, $logger);
$rutaLookup = new RutaLookup($sourceRegistry, $logger);
$clienteLookup = new ClienteLookup($sourceRegistry, $logger);
$sicretEstatusLookup = new SicretEstatusLookup($sourceRegistry, $logger);

$service = new SolicitudLiberacionService(
    $connection,
    new GuiaLookupRepository($connection),
    $contenedorLookup,
    $rutaLookup,
    $clienteLookup,
    $guiaEstadoTableroRepository,
    new SolicitudLiberacionRepository($connection),
    new SolicitudLiberacionDetalleRepository($connection),
    new SolicitudLiberacionHistorialRepository($connection),
    new SocketEventPublisher(
        $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
        (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
        $logger,
    ),
    $logger,
    sicretEstatusLookup: $sicretEstatusLookup,
);

$timbradoService = new SolicitudTimbradoService(
    $connection,
    new GuiaLookupRepository($connection),
    $rutaLookup,
    $contenedorLookup,
    $clienteLookup,
    new SolicitudTimbradoRepository($connection),
    new SolicitudTimbradoDetalleRepository($connection),
    new SolicitudTimbradoHistorialRepository($connection),
    new SocketEventPublisher(
        $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
        (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
        $logger,
    ),
    $logger,
);

// Primer pintado sin flash de carga — mismo patrón que public/trafico.php
// (server-render del estado inicial, WebSocket solo para cambios
// posteriores).
// Sin filtro de estado por defecto — el panel de "Trabajo pendiente" debe
// seguir mostrando una solicitud después de aprobarla/rechazarla (con su
// badge actualizado), no hacerla desaparecer; el límite de filas ya acota
// la vista a la actividad reciente. 15 filas (antes 25/50): filas más
// altas y fuente más grande en este panel (ver facturacion.css) hacían que
// 50 obligara a scroll constante.
//
// Orden por 'tiempo_espera' (created_at de la solicitud), NO por 'fecha'
// (g.fecha, fecha de creación de la GUÍA en SICRET) — bug reportado
// 28/jul: una solicitud de hoy sobre una guía de días atrás (frecuente:
// Facturación procesa guías viejas) ordenaba muy abajo por fecha de guía,
// quedando fuera de las primeras 15 filas y pareciendo que "no se había
// registrado". Mismo cambio reflejado en el <select id="ordenar-por"> de
// resources/views/facturacion.php para que un refresco posterior desde el
// JS no la vuelva a ordenar por fecha de guía.
$solicitudesIniciales = $service->listarConDetalleGuia(['estado' => null], 'tiempo_espera', 'DESC', 1, 15);
// Vista por guía (antes por lote, sin PR ni Contenedor — ver
// facturacion.js::renderSolicitudesTimbrado()), mismo método aplanado que
// ya usaba Liberación arriba.
$timbradoIniciales = $timbradoService->listarConDetalleGuia(['estado' => null], 'tiempo_espera', 'DESC', 1, 15);
// Misma forma anidada que devuelve /api/facturacion-kpis.php (liberacion/
// timbrado/guias_por_timbrar) — el primer pintado y los refrescos vía
// WebSocket deben coincidir en estructura o los contadores del tablero
// quedan en "undefined" tras cada aprobación/rechazo.
$kpisLiberacion = $service->kpis();
$kpisTimbrado = $timbradoService->kpis();
$kpisIniciales = [
    'liberacion' => $kpisLiberacion,
    'timbrado' => $kpisTimbrado,
    'guias_por_timbrar' => $kpisLiberacion['guias_por_timbrar'] ?? 0,
    'resumen' => FacturacionResumenKpis::combinar($kpisLiberacion, $kpisTimbrado),
];

$websocketPort = (int) $config->get('WEBSOCKET_PORT', '8098');

require __DIR__ . '/../resources/views/facturacion.php';
