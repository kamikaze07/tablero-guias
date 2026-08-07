<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Domain\Events\TimbradoConcluded;
use App\Monitoring\Timbrado\TimbradoConclusionEvidenceSource;
use App\Monitoring\Timbrado\TimbradoConclusionWatcher;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoConcludedTemplate;
use App\Timbrado\SolicitudTimbradoRepository;

echo "=== Prueba de Componentes de TimbradoConclusionWatcher (Sprint 9.1) ===" . PHP_EOL;

$failed = 0;
$passed = 0;

function assertTest(bool $condicion, string $desc, int &$passed, int &$failed): void {
    if ($condicion) {
        echo "[PASS] {$desc}" . PHP_EOL;
        $passed++;
    } else {
        echo "[FAIL] {$desc}" . PHP_EOL;
        $failed++;
    }
}

// 1. Verificar constante ESTADO_CONCLUIDA
assertTest(
    SolicitudTimbradoRepository::ESTADO_CONCLUIDA === 'CONCLUIDA',
    "Constante SolicitudTimbradoRepository::ESTADO_CONCLUIDA es 'CONCLUIDA'",
    $passed, $failed
);

// 2. Verificar Evento de Dominio TimbradoConcluded
$evento = new TimbradoConcluded('GUIA-12345', ['empresa' => 'TRANSPORTE', 'usuario' => 'Juan']);
assertTest(
    $evento->guiaId === 'GUIA-12345' && $evento->getPayload()['guiaId'] === 'GUIA-12345',
    "Evento de Dominio TimbradoConcluded retiene guiaId y payload correctamente",
    $passed, $failed
);

// 3. Verificar Plantilla de Mattermost TimbradoConcludedTemplate
$plantilla = new TimbradoConcludedTemplate();
assertTest(
    $plantilla->supports($evento),
    "TimbradoConcludedTemplate reconoce (supports) TimbradoConcluded",
    $passed, $failed
);
$renderizado = $plantilla->render($evento);
assertTest(
    str_contains($renderizado, 'TIMBRADO CONCLUIDO') && str_contains($renderizado, 'Usuario que realizó el timbrado:'),
    "TimbradoConcludedTemplate renderiza formato Markdown oficial para Mattermost",
    $passed, $failed
);

// 4. Verificar estructura de TimbradoConclusionEvidenceSource y método solicitudCompleta
$evidenceReflector = new ReflectionClass(TimbradoConclusionEvidenceSource::class);
assertTest(
    $evidenceReflector->hasMethod('solicitudCompleta'),
    "TimbradoConclusionEvidenceSource implementa método solicitudCompleta() según contrato de lote",
    $passed, $failed
);
$evidenceInstance = $evidenceReflector->newInstanceWithoutConstructor();
assertTest(
    $evidenceInstance->solicitudCompleta([], '2026-01-01 00:00:00') === false,
    "solicitudCompleta([], creada_en) retorna false ante lote vacío",
    $passed, $failed
);

// 4b. Bug real corregido (guías GERO PR-220277/PR-220278): evidencia
// ANTERIOR a la creación de la solicitud (folio de un timbrado previo, ya
// invalidado por una Liberación) no debe poder concluirla — ver docblock
// de TimbradoConclusionEvidenceSource::tieneDatosFiscales().
assertTest(
    $evidenceReflector->hasMethod('tieneDatosFiscales')
        && $evidenceReflector->getMethod('tieneDatosFiscales')->getNumberOfParameters() === 3,
    "TimbradoConclusionEvidenceSource::tieneDatosFiscales() exige creadaEn (evita evidencia obsoleta de una solicitud anterior)",
    $passed, $failed
);
assertTest(
    $evidenceReflector->hasMethod('datosPorGuia')
        && $evidenceReflector->getMethod('datosPorGuia')->getNumberOfParameters() === 3,
    "TimbradoConclusionEvidenceSource::datosPorGuia() exige creadaEn (mismo criterio de frescura)",
    $passed, $failed
);

// 5. Verificar estructura y métodos de TimbradoConclusionWatcher
$watcherReflector = new ReflectionClass(TimbradoConclusionWatcher::class);
assertTest(
    $watcherReflector->hasMethod('pendientes') && $watcherReflector->hasMethod('buscarEvidencia') && $watcherReflector->hasMethod('alConfirmar'),
    "TimbradoConclusionWatcher implementa ciclo completo de EvidenceWatcher (pendientes, buscarEvidencia, alConfirmar)",
    $passed, $failed
);
assertTest(
    $watcherReflector->hasMethod('solicitudCompleta'),
    "TimbradoConclusionWatcher encapsula solicitudCompleta() para validación total o nada",
    $passed, $failed
);

echo PHP_EOL . "Total: " . ($passed + $failed) . " pruebas. OK: {$passed}, Fallidas: {$failed}." . PHP_EOL;
if ($failed > 0) {
    exit(1);
}
exit(0);
