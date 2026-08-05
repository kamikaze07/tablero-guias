<?php

declare(strict_types=1);

/**
 * Prueba de compatibilidad hacia atrás para App\Liberacion\ClienteLookup
 * (Sprint 1, Grupo Inteligente). No toca SICRET — verifica, por
 * Reflection, que:
 *   1. porNumGuia()/consultarClientes() (usados por
 *      App\Liberacion\SolicitudLiberacionService y otros puntos del
 *      flujo de Timbrado no tocados en este sprint) siguen existiendo con
 *      la misma firma pública — nadie debió romperlos.
 *   2. El método nuevo conClaveGenePorNumGuia() existe, es público, y
 *      devuelve algo iterable por num_guia (contrato de forma, no de
 *      datos reales).
 *
 * Ejecutar: php tests/Liberacion/ClienteLookupCompatibilidadTest.php
 */

require __DIR__ . '/../../vendor/autoload.php';

use App\Liberacion\ClienteLookup;

$fallos = 0;
$total = 0;

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

$reflection = new ReflectionClass(ClienteLookup::class);

// --- porNumGuia() no debe haber cambiado de firma pública ---
$porNumGuia = $reflection->getMethod('porNumGuia');
assertTrue('porNumGuia() sigue siendo público', $porNumGuia->isPublic());
assertTrue('porNumGuia() sigue recibiendo exactamente 1 parámetro', $porNumGuia->getNumberOfParameters() === 1);
assertTrue(
    'porNumGuia() sigue declarando `array` como tipo de retorno',
    (string) $porNumGuia->getReturnType() === 'array',
);

// --- consultarClientes() (privado, usado internamente por porNumGuia()) intacto ---
assertTrue('consultarClientes() (privado) sigue existiendo', $reflection->hasMethod('consultarClientes'));
$consultarClientes = $reflection->getMethod('consultarClientes');
assertTrue('consultarClientes() sigue siendo privado', $consultarClientes->isPrivate());

// --- método nuevo: conClaveGenePorNumGuia() ---
assertTrue('conClaveGenePorNumGuia() existe', $reflection->hasMethod('conClaveGenePorNumGuia'));
$nuevo = $reflection->getMethod('conClaveGenePorNumGuia');
assertTrue('conClaveGenePorNumGuia() es público', $nuevo->isPublic());
assertTrue('conClaveGenePorNumGuia() recibe exactamente 1 parámetro', $nuevo->getNumberOfParameters() === 1);
assertTrue(
    'conClaveGenePorNumGuia() declara `array` como tipo de retorno',
    (string) $nuevo->getReturnType() === 'array',
);

// --- contrato de forma sobre datos sintéticos (sin BD): con $guias vacío,
// ambos métodos deben regresar un arreglo vacío sin lanzar excepción ni
// requerir SourceRegistry real ---
$instancia = $reflection->newInstanceWithoutConstructor();

try {
    $resultadoVacioViejo = $porNumGuia->invoke($instancia, []);
    assertTrue('porNumGuia([]) === [] sin tocar BD', $resultadoVacioViejo === []);
} catch (Throwable $e) {
    assertTrue('porNumGuia([]) === [] sin tocar BD', false, $e->getMessage());
}

try {
    $resultadoVacioNuevo = $nuevo->invoke($instancia, []);
    assertTrue('conClaveGenePorNumGuia([]) === [] sin tocar BD', $resultadoVacioNuevo === []);
} catch (Throwable $e) {
    assertTrue('conClaveGenePorNumGuia([]) === [] sin tocar BD', false, $e->getMessage());
}

echo "\n{$total} pruebas, " . ($total - $fallos) . " OK, {$fallos} fallidas.\n";

exit($fallos > 0 ? 1 : 0);
