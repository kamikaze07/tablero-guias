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
    $stmtGuia = $connection->prepare("SELECT fecha, hora, operador, source as empresa FROM guias WHERE num_guia = :guia LIMIT 1");
    $stmtGuia->execute(['guia' => $numGuia]);
    $guiaBase = $stmtGuia->fetch(PDO::FETCH_ASSOC);

    if ($guiaBase) {
        $fechaCreacion = trim($guiaBase['fecha']);
        if (!empty($guiaBase['hora']) && $guiaBase['hora'] !== '00:00:00' && $guiaBase['hora'] !== '00:00:00.0000000') {
            $fechaCreacion .= ' ' . substr($guiaBase['hora'], 0, 8);
        } else {
            $fechaCreacion .= ' 00:00:00';
        }
        
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
