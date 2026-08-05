<?php

declare(strict_types=1);

/**
 * Prueba unitaria del núcleo puro de agrupación (Sprint 1, Grupo
 * Inteligente — ver knowledge/sprint1_grupo_inteligente.md §11).
 *
 * Ejecuta App\Timbrado\RutaLookup::combinarEnGrupos() (privado) vía
 * Reflection, sobre datos de prueba fijos — sin tocar SICRET ni ninguna
 * base de datos. La instancia de RutaLookup se crea SIN constructor
 * (newInstanceWithoutConstructor) porque combinarEnGrupos() no usa
 * ninguna dependencia de la clase (SourceRegistry/SyncLogger), solo sus
 * propios parámetros — es, a propósito, un método puro.
 *
 * Ejecutar: php tests/Timbrado/GrupoInteligenteTest.php
 */

require __DIR__ . '/../../vendor/autoload.php';

use App\Timbrado\RutaLookup;

$fallos = 0;
$total = 0;

/**
 * Invoca el método privado RutaLookup::combinarEnGrupos() vía Reflection,
 * sobre una instancia creada sin constructor (el método es puro: no usa
 * $this->sourceRegistry ni $this->logger, solo sus propios parámetros).
 *
 * @param array<int, array{guia_id?: int, num_guia: string}> $guias
 * @param array<string, array{clave_gene: ?int, nombre: string}> $clientes
 * @param array<string, array{origen: string, destino: string}> $rutas
 * @return array<int, array{cliente: array{clave_gene: ?int, nombre: string}, origen: string, destino: string, guias: array<int, array{guia_id: ?int, num_guia: string}>}>
 */
function combinarEnGrupos(array $guias, array $clientes, array $rutas): array
{
    $reflection = new ReflectionClass(RutaLookup::class);
    $instancia = $reflection->newInstanceWithoutConstructor();
    $metodo = $reflection->getMethod('combinarEnGrupos');
    $metodo->setAccessible(true);

    return $metodo->invoke($instancia, $guias, $clientes, $rutas);
}

function assertGrupos(string $caso, array $grupos, array $tamanosEsperados): void
{
    global $fallos, $total;
    $total++;

    $tamanos = array_map(static fn (array $g): int => count($g['guias']), $grupos);

    if ($tamanos === $tamanosEsperados) {
        echo "[PASS] {$caso}\n";
    } else {
        $fallos++;
        echo "[FAIL] {$caso} — esperado " . json_encode($tamanosEsperados) . ', obtenido ' . json_encode($tamanos) . "\n";
    }
}

function assertTrue(string $caso, bool $condicion, string $detalle = ''): void
{
    global $fallos, $total;
    $total++;

    if ($condicion) {
        echo "[PASS] {$caso}\n";
    } else {
        $fallos++;
        echo "[FAIL] {$caso}" . ($detalle !== '' ? " — {$detalle}" : '') . "\n";
    }
}

// --- Caso 1: mismo cliente, misma ruta -> 1 grupo con 2 guías ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'],
    ['guia_id' => 2, 'num_guia' => 'PR002'],
];
$clientes = [
    'PR001' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR002' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
];
$rutas = [
    'PR001' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR002' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
];
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertGrupos('Mismo cliente + misma ruta => 1 grupo de 2', $grupos, [2]);

// --- Caso 2: mismo cliente, rutas distintas -> 2 grupos ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'],
    ['guia_id' => 2, 'num_guia' => 'PR002'],
];
$clientes = [
    'PR001' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR002' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
];
$rutas = [
    'PR001' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR002' => ['origen' => 'VERACRUZ', 'destino' => 'TAMPICO'],
];
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertGrupos('Mismo cliente + rutas distintas => 2 grupos', $grupos, [1, 1]);

// --- Caso 3 (el crítico): misma ruta, clientes distintos -> 2 grupos ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'],
    ['guia_id' => 2, 'num_guia' => 'PR002'],
];
$clientes = [
    'PR001' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR002' => ['clave_gene' => 200, 'nombre' => 'ACERO SA'],
];
$rutas = [
    'PR001' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR002' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
];
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertGrupos('Misma ruta + clientes distintos => 2 grupos (antes se fusionaban)', $grupos, [1, 1]);

// --- Caso 4: guía sin cliente resoluble -> grupo propio, no rompe el resto ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'],
    ['guia_id' => 2, 'num_guia' => 'PR002'],
    ['guia_id' => 3, 'num_guia' => 'PR003'],
];
$clientes = [
    'PR001' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR002' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    // PR003 sin entrada en $clientes -> cae a sinCliente
];
$rutas = [
    'PR001' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR002' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR003' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
];
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertGrupos('Guía sin cliente resoluble => grupo propio, resto intacto', $grupos, [2, 1]);
assertTrue(
    'Guía sin cliente resoluble => 3 guías totales repartidas',
    array_sum(array_map(static fn (array $g): int => count($g['guias']), $grupos)) === 3,
);

// --- Caso 5: guía sin ruta resoluble -> grupo "N/A"->"N/A" ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'],
];
$clientes = [
    'PR001' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
];
$rutas = []; // sin resolución para PR001
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertTrue(
    'Guía sin ruta resoluble => origen/destino N/A',
    count($grupos) === 1 && $grupos[0]['origen'] === 'N/A' && $grupos[0]['destino'] === 'N/A',
    'grupos=' . json_encode($grupos),
);

// --- Caso 6: orden de grupos por tamaño descendente, estable en empate ---
$guias = [
    ['guia_id' => 1, 'num_guia' => 'PR001'], // grupo B (1 guía)
    ['guia_id' => 2, 'num_guia' => 'PR002'], // grupo A (3 guías)
    ['guia_id' => 3, 'num_guia' => 'PR003'], // grupo A
    ['guia_id' => 4, 'num_guia' => 'PR004'], // grupo C (1 guía, después de B)
    ['guia_id' => 5, 'num_guia' => 'PR005'], // grupo A
];
$clientes = [
    'PR001' => ['clave_gene' => 200, 'nombre' => 'ACERO SA'],
    'PR002' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR003' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
    'PR004' => ['clave_gene' => 300, 'nombre' => 'GRUPO XYZ'],
    'PR005' => ['clave_gene' => 100, 'nombre' => 'CEMEX'],
];
$rutas = [
    'PR001' => ['origen' => 'VERACRUZ', 'destino' => 'TAMPICO'],
    'PR002' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR003' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
    'PR004' => ['origen' => 'VERACRUZ', 'destino' => 'PUEBLA'],
    'PR005' => ['origen' => 'VERACRUZ', 'destino' => 'MONTERREY'],
];
$grupos = combinarEnGrupos($guias, $clientes, $rutas);
assertGrupos('Orden por tamaño desc., empate por orden de aparición', $grupos, [3, 1, 1]);
assertTrue(
    'El grupo más grande es CEMEX/VERACRUZ->MONTERREY',
    $grupos[0]['cliente']['nombre'] === 'CEMEX' && $grupos[0]['destino'] === 'MONTERREY',
);
assertTrue(
    'Empate: ACERO SA (apareció primero) antes que GRUPO XYZ',
    $grupos[1]['cliente']['nombre'] === 'ACERO SA' && $grupos[2]['cliente']['nombre'] === 'GRUPO XYZ',
);

echo "\n{$total} pruebas, " . ($total - $fallos) . " OK, {$fallos} fallidas.\n";

exit($fallos > 0 ? 1 : 0);
