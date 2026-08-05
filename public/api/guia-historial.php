<?php
declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\JsonResponse;

header('Content-Type: application/json');

$config = new Config();
$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');
    return;
}

$numGuia = $_GET['guia'] ?? '';
if ($numGuia === '') {
    JsonResponse::error(400, 'guia_requerida', 'El parámetro guia es requerido.');
    return;
}

try {
    $historial = [];

    // 1. Obtener información de la guía desde la tabla guias local
    // `fecha` ya es un DATETIME completo (fecha+hora) — no existe una
    // columna `hora` separada en esta tabla (la había en versiones previas
    // de este archivo, causaba que toda petición fallara con 500).
    $stmtGuia = $connection->prepare("SELECT id, fecha, operador, source as empresa FROM guias WHERE num_guia = :guia LIMIT 1");
    $stmtGuia->execute(['guia' => $numGuia]);
    $guiaBase = $stmtGuia->fetch(PDO::FETCH_ASSOC);

    if ($guiaBase) {
        $fechaCreacion = trim($guiaBase['fecha']);

        $historial[] = [
            'fecha' => $fechaCreacion,
            'actor' => 'SICRET',
            'empresa' => $guiaBase['empresa'] ?? '',
            'tipo' => 'Guía creada',
            'resultado' => 'OK',
            'observaciones' => '',
            'motivo' => ''
        ];
        
        if (!empty(trim($guiaBase['operador']))) {
            $historial[] = [
                'fecha' => $fechaCreacion,
                'actor' => 'SICRET',
                'empresa' => $guiaBase['empresa'] ?? '',
                'tipo' => 'Asignada al operador',
                'resultado' => 'OK',
                'observaciones' => trim($guiaBase['operador']),
                'motivo' => ''
            ];
        }
    }

    // 2. Historial de Timbrado
    $stmtTimbrado = $connection->prepare("
        SELECT h.solicitud_id, h.created_at, h.evento, h.actor, h.detalle
        FROM solicitud_timbrado_historial h
        JOIN solicitud_timbrado_detalle d ON d.solicitud_id = h.solicitud_id
        WHERE d.num_guia = :guia
        ORDER BY h.solicitud_id ASC, h.created_at ASC, h.id ASC
    ");
    $stmtTimbrado->execute(['guia' => $numGuia]);
    $eventosTimbrado = $stmtTimbrado->fetchAll(PDO::FETCH_ASSOC);

    $creacionTimbrado = [];
    foreach ($eventosTimbrado as $ev) {
        $solId = $ev['solicitud_id'];
        if ($ev['evento'] === 'CREADA') {
            $creacionTimbrado[$solId] = $ev['created_at'];
        }

        $tipo = 'Solicitud de Timbrado';
        $resultado = 'PENDIENTE';
        $duracion = '';

        if ($ev['evento'] === 'APROBADA') {
            $tipo = 'Timbrado aprobado';
            $resultado = 'OK';
            if (isset($creacionTimbrado[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionTimbrado[$solId]));
            }
        } elseif ($ev['evento'] === 'RECHAZADA') {
            $tipo = 'Timbrado rechazado';
            $resultado = 'ERROR';
            if (isset($creacionTimbrado[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionTimbrado[$solId]));
            }
        } elseif ($ev['evento'] === 'TIMBRADO') {
            // App\Monitoring\Timbrado\TimbradoConfirmationWatcher::alConfirmar()
            // registra este evento cuando confirma el timbrado real contra SICRET
            // (ver ese archivo) — sin esta rama caía en los valores por defecto
            // de arriba ('Solicitud de Timbrado' / PENDIENTE), dejando el
            // historial operativo estancado en un estado "pendiente" fantasma
            // aunque la guía ya estuviera timbrada.
            $tipo = 'Guía timbrada';
            $resultado = 'OK';
            if (isset($creacionTimbrado[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionTimbrado[$solId]));
            }
        } elseif ($ev['evento'] === 'CREADA') {
            $tipo = 'Solicitud de Timbrado';
            $resultado = 'CREADA';
        }
        
        $historial[] = [
            'fecha' => $ev['created_at'],
            'actor' => $ev['actor'] ?? 'Sistema',
            'empresa' => $guiaBase['empresa'] ?? '', // ATLAS no guarda empresa por evento, la heredamos
            'tipo' => $tipo,
            'resultado' => $resultado,
            'observaciones' => $ev['detalle'] ?? '',
            'motivo' => ($ev['evento'] === 'RECHAZADA') ? ($ev['detalle'] ?? '') : '',
            'duracion' => $duracion
        ];
    }

    // 2b. Timbrado directo en SICRET, sin Solicitud de Timbrado previa (ver
    // App\Monitoring\Timbrado\DirectStampingWatcher) — esta guía nunca pasa
    // por solicitud_timbrado_historial, así que el bloque de arriba no
    // aporta ningún evento para ella; sin esto, el historial quedaba mudo
    // después de "Asignada al operador" pese a que la guía sí se timbró.
    // Solo aplica si el bloque de arriba no encontró ya un evento TIMBRADO
    // (flujo normal) para no duplicar la misma confirmación.
    $yaTieneTimbradoConfirmado = in_array('TIMBRADO', array_column($eventosTimbrado, 'evento'), true);

    if (!$yaTieneTimbradoConfirmado && $guiaBase && isset($guiaBase['id'])) {
        $stmtDirecto = $connection->prepare("
            SELECT factura_impresa, updated_at
            FROM guia_estado_tablero
            WHERE guia_id = :guia_id AND estado = 'TIMBRADO' AND factura_impresa IS NOT NULL
            LIMIT 1
        ");
        $stmtDirecto->execute(['guia_id' => $guiaBase['id']]);
        $directo = $stmtDirecto->fetch(PDO::FETCH_ASSOC);

        if ($directo) {
            $historial[] = [
                'fecha' => $directo['updated_at'],
                'actor' => 'direct-stamping-watcher',
                'empresa' => $guiaBase['empresa'] ?? '',
                'tipo' => 'Guía timbrada',
                'resultado' => 'OK',
                'observaciones' => 'Timbrado directo en SICRET, sin Solicitud de Timbrado previa.',
                'motivo' => '',
                'duracion' => ''
            ];
        }
    }

    // 3. Historial de Liberación
    $stmtLiberacion = $connection->prepare("
        SELECT h.solicitud_id, h.created_at, h.evento, h.actor, h.detalle, h.estado_nuevo
        FROM solicitud_liberacion_historial h
        JOIN solicitud_liberacion_detalle d ON d.solicitud_id = h.solicitud_id
        WHERE d.num_guia = :guia
        ORDER BY h.solicitud_id ASC, h.created_at ASC, h.id ASC
    ");
    $stmtLiberacion->execute(['guia' => $numGuia]);
    $eventosLiberacion = $stmtLiberacion->fetchAll(PDO::FETCH_ASSOC);

    $creacionLiberacion = [];
    foreach ($eventosLiberacion as $ev) {
        $solId = $ev['solicitud_id'];
        if ($ev['evento'] === 'CREADA') {
            $creacionLiberacion[$solId] = $ev['created_at'];
        }

        $tipo = 'Solicitud de Liberación';
        $resultado = $ev['estado_nuevo'] ?? 'PENDIENTE';
        $duracion = '';

        if ($ev['evento'] === 'APROBADA') {
            $tipo = 'Liberación aprobada';
            $resultado = 'OK';
            if (isset($creacionLiberacion[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionLiberacion[$solId]));
            }
        } elseif ($ev['evento'] === 'RECHAZADA') {
            $tipo = 'Liberación rechazada';
            $resultado = 'ERROR';
            if (isset($creacionLiberacion[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionLiberacion[$solId]));
            }
        } elseif ($ev['evento'] === 'CREADA') {
            $tipo = 'Solicitud de Liberación';
            $resultado = 'CREADA';
        }
        
        $historial[] = [
            'fecha' => $ev['created_at'],
            'actor' => $ev['actor'] ?? 'Sistema',
            'empresa' => $guiaBase['empresa'] ?? '',
            'tipo' => $tipo,
            'resultado' => $resultado,
            'observaciones' => $ev['detalle'] ?? '',
            'motivo' => ($ev['evento'] === 'RECHAZADA') ? ($ev['detalle'] ?? '') : '',
            'duracion' => $duracion
        ];
    }

    // Sort historial by fecha
    usort($historial, function ($a, $b) {
        return strtotime($a['fecha']) <=> strtotime($b['fecha']);
    });

    JsonResponse::ok(200, $historial);
} catch (\Throwable $e) {
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error al obtener el historial.');
}
