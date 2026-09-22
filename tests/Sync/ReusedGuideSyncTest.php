<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Sync\CheckpointStore;
use App\Sync\GuiaRecord;
use App\Sync\GuiaRepository;
use App\Sync\SyncStatus;
use App\Sync\TestEnvironmentGuard;

echo "=== ATLAS — Synchronization & Event Semantics Test Suite (ISOLATED) ===" . PHP_EOL . PHP_EOL;

$passed = 0;
$failed = 0;

function assertTest(bool $condition, string $desc, int &$passed, int &$failed): void {
    if ($condition) {
        echo "[PASS] {$desc}" . PHP_EOL;
        $passed++;
    } else {
        echo "[FAIL] {$desc}" . PHP_EOL;
        $failed++;
    }
}

// --------------------------------------------------------------------------
// TEST 11 — Production Data Contamination Guard
// --------------------------------------------------------------------------
try {
    $config = new Config();
    $prodPdo = new PDO(
        'mysql:host=127.0.0.1;port=' . $config->get('ATLAS_DB_EXTERNAL_PORT', '3311') . ';dbname=atlas',
        $config->get('ATLAS_DB_USERNAME', 'atlas'),
        $config->get('ATLAS_DB_PASSWORD', 'a29a740d13e230e68e0033ca')
    );
    TestEnvironmentGuard::assertSafeTestEnvironment($prodPdo, 'atlas');
    assertTest(false, "Test 11: Guard de protección no bloqueó la base de producción 'atlas'", $passed, $failed);
} catch (\RuntimeException $e) {
    assertTest(str_contains($e->getMessage(), 'FATAL SECURITY GUARD'), "Test 11: Guard de protección bloquea técnicamente cualquier intento de ejecutar pruebas contra la BD de producción 'atlas'", $passed, $failed);
}

// Conectar ÚNICAMENTE a la base de datos aislada atlas_test
$testDbName = 'atlas_test';
$pdo = new PDO(
    'mysql:host=127.0.0.1;port=3311;dbname=' . $testDbName,
    'atlas',
    'a29a740d13e230e68e0033ca'
);

TestEnvironmentGuard::assertSafeTestEnvironment($pdo, $testDbName);

// Cargar esquema limpio para las pruebas
$schema = file_get_contents(__DIR__ . '/../../database/schema.sql');
$pdo->exec('DROP TABLE IF EXISTS guias, sync_checkpoints, sync_heartbeat, guia_estado_tablero, solicitud_liberacion, solicitud_liberacion_detalle, solicitud_liberacion_historial, sicret_write_log, solicitud_timbrado, solicitud_timbrado_detalle, solicitud_timbrado_historial, resumen_diario_tablero');
$pdo->exec($schema);

$guiaRepo = new GuiaRepository($pdo);
$checkpointStore = new CheckpointStore($pdo);

function makeRecord(string $source, int $num, string $numGuia, string $fechaCStr, string $nombre = 'CLIENTE TEST', string $operador = 'JUAN PEREZ'): GuiaRecord {
    return GuiaRecord::fromSourceRow($source, [
        'num' => $num,
        'num_guia' => $numGuia,
        'folio_imp' => 'F-1',
        'fecha' => '2026-08-28 10:00:00',
        'fecha_c' => $fechaCStr,
        'fecha_d' => '2026-08-28 10:00:00',
        'num_llama' => 0,
        'estado' => 'GENERADA',
        'nombre' => $nombre,
        'tipo' => 'FORANEA',
        'num_vale' => '',
        'diesel' => '',
        'servicio' => 'GENERAL',
        'rem1' => '',
        'placas1' => 'ABC-123',
        'rem2' => '',
        'placas2' => '',
        'estatus' => 'ACTIVA',
        'pedido' => 'PED-100',
        'comen_pre' => '',
        'factura' => 0,
        'manifiesto' => '',
        'ticket1' => '',
        'tons1' => 0.0,
        'ticket2' => '',
        'tons2' => 0.0,
        'operador' => $operador,
        'prefactura' => 0,
        'factimpresa' => '',
        'linea' => 'LINEA 1',
        'km' => 150.0,
        'claveproductoSat' => '',
        'claveUnidadSat' => '',
        'do' => '',
        'lid' => '',
        'actualizacion' => '',
    ]);
}

// --------------------------------------------------------------------------
// TEST 1 — Normal new guide (INSERTED)
// --------------------------------------------------------------------------
$rec101 = makeRecord('sicrePR', 101, 'PR-101', '2026-08-28 08:00:00');
$res101 = $guiaRepo->saveOrUpdate($rec101);
$checkpointStore->update('sicrePR', 101);

assertTest(
    $res101->isInserted() && $res101->atlasId !== null && $res101->atlasId > 0 && $checkpointStore->get('sicrePR') === 101,
    "Test 1: Nueva guía normal (num=101) se clasifica como INSERTED y avanza checkpoint a 101",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 2 — Existing identical guide (UNCHANGED)
// --------------------------------------------------------------------------
$res101ReRead = $guiaRepo->saveOrUpdate($rec101);
assertTest(
    $res101ReRead->isUnchanged() && $res101ReRead->atlasId === $res101->atlasId,
    "Test 2: Re-lectura de guía idéntica retorna UNCHANGED (no ejecuta UPDATE)",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 3 — Existing guide business data changed (UPDATED)
// --------------------------------------------------------------------------
$rec101Edited = makeRecord('sicrePR', 101, 'PR-101', '2026-08-28 08:00:00', 'NUEVO CLIENTE EDITADO', 'NUEVO OPERADOR');
$res101Edited = $guiaRepo->saveOrUpdate($rec101Edited);
$rowMirror101 = $guiaRepo->findBySourceAndNum('sicrePR', 101);

assertTest(
    $res101Edited->isUpdated() &&
    $res101Edited->atlasId === $res101->atlasId &&
    $rowMirror101['nombre'] === 'NUEVO CLIENTE EDITADO' &&
    $rowMirror101['operador'] === 'NUEVO OPERADOR',
    "Test 3: Edición de campos de negocio en la misma guía resulta en UPDATED conservando id={$res101->atlasId}",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 4 — Reused source number (REUSED_REPLACED)
// --------------------------------------------------------------------------
$rec101Reused = makeRecord('sicrePR', 101, 'PR-101-NEW', '2026-08-28 10:30:00', 'CLIENTE REUTILIZADO');
$res101Reused = $guiaRepo->saveOrUpdate($rec101Reused);
$rowReusedMirror = $guiaRepo->findBySourceAndNum('sicrePR', 101);

assertTest(
    $res101Reused->isReusedReplaced() &&
    $res101Reused->atlasId === $res101->atlasId &&
    $rowReusedMirror['num_guia'] === 'PR-101-NEW' &&
    $rowReusedMirror['fecha_c'] === '2026-08-28 10:30:00',
    "Test 4: Folio reutilizado (fecha_c posterior) resulta en REUSED_REPLACED conservando id={$res101->atlasId}",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 5 & 6 — Bounded reconciliation & Checkpoint Monotonicity
// --------------------------------------------------------------------------
$checkpointStore->update('sicrePR', 227350);
$cpBefore = $checkpointStore->get('sicrePR');

// Simular reconciliación de folio 227340 <= checkpoint 227350
$recHistoricalReused = makeRecord('sicrePR', 227340, 'PR-227340', '2026-08-28 11:00:00');
$resHistorical = $guiaRepo->saveOrUpdate($recHistoricalReused);

// Intentar actualizar checkpoint con folio <= 227350
$checkpointStore->update('sicrePR', 227340);
$cpAfter = $checkpointStore->get('sicrePR');

assertTest(
    $resHistorical->isInserted() && $cpBefore === 227350 && $cpAfter === 227350,
    "Test 5 & 6: Reconciliación procesa folios <= checkpoint manteniendo el checkpoint estrictamente monotónico (227350)",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 7 — FORSIS / GERO Isolation
// --------------------------------------------------------------------------
$recGero101 = makeRecord('sicreGero', 101, 'GR-101', '2026-08-28 09:00:00', 'CLIENTE GERO');
$resGero101 = $guiaRepo->saveOrUpdate($recGero101);

$rowForsis = $guiaRepo->findBySourceAndNum('sicrePR', 101);
$rowGero = $guiaRepo->findBySourceAndNum('sicreGero', 101);

assertTest(
    $resGero101->isInserted() && $rowForsis['num_guia'] === 'PR-101-NEW' && $rowGero['num_guia'] === 'GR-101',
    "Test 7: Aislamiento estricto entre fuentes (sicrePR vs sicreGero con mismo source_num=101)",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 8 — Zero Legacy Date (0000-00-00 00:00:00)
// --------------------------------------------------------------------------
$recZeroDate = makeRecord('sicrePR', 500, 'PR-500', '0000-00-00 00:00:00', 'CLIENTE FECHA CERO');
$resZero1 = $guiaRepo->saveOrUpdate($recZeroDate);
$resZero2 = $guiaRepo->saveOrUpdate($recZeroDate);

assertTest(
    $resZero1->isInserted() && $resZero2->isUnchanged(),
    "Test 8: Manejo seguro de fecha cero legada (0000-00-00) sin errores de DateTime ni bucles infinitos de UPDATE",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 9 — Frontend Event Semantics Classification
// --------------------------------------------------------------------------
assertTest(
    $res101->isNewIncarnation() === true &&
    $res101Reused->isNewIncarnation() === true &&
    $res101Edited->isUpdated() === true &&
    $res101ReRead->isUnchanged() === true,
    "Test 9: Clasificación semántica de eventos (INSERTED/REUSED -> guia.detectada, UPDATED -> guia.actualizada, UNCHANGED -> sin evento)",
    $passed, $failed
);

// --------------------------------------------------------------------------
// TEST 10 — Production Regression Scenario 227356
// --------------------------------------------------------------------------
$recTestIncident = makeRecord('sicrePR', 227356, 'PR-227356-TEST', '2026-08-28 09:18:38', 'GUIA PRUEBA BORRADA');
$resIncident1 = $guiaRepo->saveOrUpdate($recTestIncident);
$checkpointStore->update('sicrePR', 227356);

$recRealIncident = makeRecord('sicrePR', 227356, 'PR-227356', '2026-08-28 10:06:51', 'ALMA SARAI CERECEDO SALAZAR');
$resIncident2 = $guiaRepo->saveOrUpdate($recRealIncident);
$rowIncident = $guiaRepo->findBySourceAndNum('sicrePR', 227356);

assertTest(
    $resIncident2->isReusedReplaced() &&
    $resIncident2->atlasId === $resIncident1->atlasId &&
    $rowIncident['num_guia'] === 'PR-227356' &&
    $rowIncident['nombre'] === 'ALMA SARAI CERECEDO SALAZAR' &&
    $rowIncident['fecha_c'] === '2026-08-28 10:06:51',
    "Test 10 (REGRESIÓN 227356): Guía real PR-227356 (10:06:51) reemplaza in-situ a la guía de prueba (09:18:38) en id={$resIncident1->atlasId}",
    $passed, $failed
);

echo PHP_EOL . "==================================================" . PHP_EOL;
echo sprintf(" RESULTADOS: %d PASARON | %d FALLARON", $passed, $failed) . PHP_EOL;
echo "==================================================" . PHP_EOL . PHP_EOL;

if ($failed > 0) {
    exit(1);
}
exit(0);
