<?php
declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\JsonResponse;
use App\Notifications\Consumers\Mattermost\Templates\EmpresaLabel;

header('Content-Type: application/json');

$config = new Config();
$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

use App\Sync\SourceRegistry;

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') !== 'GET') {
    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');
    return;
}

// SourceRegistry: acceso lazy a las BDs SICRET (sicrePR / sicreGero)
// para resolver facturas33.usuario → nombre completo del facturador.
// Solo se abre la conexión SICRET si se necesita (Motor Automático,
// sin evento APROBADA en solicitud_timbrado_historial).
$sourceRegistry = new SourceRegistry($config, new \App\Database\ConnectionFactory(), __DIR__ . '/../../config/sources.php');

/**
 * Resuelve el alias de usuario SICRET (p. ej. "EUNICE01") al nombre
 * completo del facturador ("EUNICE GONZALEZ MARTINEZ") desde
 * facturas33 JOIN usuarios JOIN empleados, dado el num_guia y la
 * fuente SICRET de la guía. Devuelve null si no puede resolverse —
 * el caller decide el fallback.
 */
$resolverFacturador = function (string $numGuia, ?string $source, string $creadaEn) use ($sourceRegistry): ?string {
    if ($source === null) {
        return null;
    }

    $sicret = null;
    foreach ($sourceRegistry->all() as $s) {
        if ($s->name() === $source) {
            $sicret = $s;
            break;
        }
    }

    if ($sicret === null) {
        return null;
    }

    try {
        $stmt = $sicret->connection()->prepare(
            "SELECT TRIM(CONCAT(COALESCE(e.nombre, ''), ' ', COALESCE(e.ap_pat, ''), ' ', COALESCE(e.ap_mat, ''))) AS nombre,
                    f.usuario AS alias
             FROM facturas33 f
             JOIN guias g ON g.num_guia = f.cartaporte AND g.factImpresa = f.folio
             LEFT JOIN usuarios u ON u.nombre_usu = f.usuario
             LEFT JOIN empleados e ON e.clave_emp = u.num_emp
             WHERE f.cartaporte = :guia
               AND g.factImpresa IS NOT NULL AND g.factImpresa != ''
               AND f.folioFiscal IS NOT NULL AND f.folioFiscal != ''
               AND f.idccp IS NOT NULL AND f.idccp != ''
               AND f.fecha > :creada_en
             LIMIT 1"
        );
        $stmt->execute(['guia' => $numGuia, 'creada_en' => $creadaEn]);
        $row = $stmt->fetch(\PDO::FETCH_ASSOC);

        if ($row === false) {
            return null;
        }

        $nombre = trim((string) ($row['nombre'] ?? ''));
        $alias = trim((string) ($row['alias'] ?? ''));

        // Preferir nombre completo; si JOIN no lo resolvió pero sí hay alias,
        // devolver el alias (p. ej. "EUNICE01") antes que nada.
        return $nombre !== '' ? $nombre : ($alias !== '' ? $alias : null);
    } catch (\Throwable) {
        // Cualquier fallo de SICRET no debe romper el historial;
        // el caller lo etiqueta como desconocido.
        return null;
    }
};

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
    $stmtGuia = $connection->prepare("SELECT id, fecha, operador, source, source as empresa FROM guias WHERE num_guia = :guia LIMIT 1");
    $stmtGuia->execute(['guia' => $numGuia]);
    $guiaBase = $stmtGuia->fetch(PDO::FETCH_ASSOC);

    if ($guiaBase) {
        // `empresa` viene crudo de `guias.source` ('sicrePR'/'sicreGero') —
        // el drawer de trafico-system renderiza este campo en mayúsculas
        // (CSS uppercase), así que sin este mapeo el usuario veía
        // literalmente "SICREPR" en vez de "FORSIS". Se traduce una sola
        // vez aquí porque todo el resto del archivo lee $guiaBase['empresa'].
        // `source` (crudo) se conserva aparte para poder elegir la conexión
        // SICRET correcta al resolver facturas33.usuario → nombre completo.
        $guiaSource = $guiaBase['source'] ?? null; // 'sicrePR' | 'sicreGero' | null
        $guiaBase['empresa'] = EmpresaLabel::desde($guiaBase['empresa'] ?? null);
    }

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
    $timbradoConfirmadoPorSolicitud = [];
    // Quién solicitó y quién aprobó cada solicitud de timbrado (por
    // solicitud_id), para armar el mensaje "Timbrado mediante la solicitud
    // de timbrado: #N solicitada por: X y aprobada por: Y" en los eventos
    // TIMBRADO/CONCLUIDA de abajo, en vez de repetir el detalle crudo
    // (a menudo vacío) del evento.
    $solicitantePorSolicitud = [];
    $aprobadorPorSolicitud = [];
    foreach ($eventosTimbrado as $ev) {
        $solId = $ev['solicitud_id'];
        if ($ev['evento'] === 'CREADA') {
            $creacionTimbrado[$solId] = $ev['created_at'];
            $solicitantePorSolicitud[$solId] = $ev['actor'] ?? 'Sistema';
        }
        if ($ev['evento'] === 'APROBADA') {
            $aprobadorPorSolicitud[$solId] = $ev['actor'] ?? null;
        }

        $tipo = 'Solicitud de Timbrado';
        $resultado = 'PENDIENTE';
        $duracion = '';
        $observaciones = $ev['detalle'] ?? '';

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
            $timbradoConfirmadoPorSolicitud[$solId] = true;
            if (isset($creacionTimbrado[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionTimbrado[$solId]));
            }
            $solicitanteTxt = $solicitantePorSolicitud[$solId] ?? ($ev['actor'] ?? 'Solicitante no registrado');
            $aprobadorTxt = $aprobadorPorSolicitud[$solId]
                ?? $resolverFacturador($numGuia, $guiaSource ?? null, $creacionTimbrado[$solId] ?? '1970-01-01')
                ?? 'Facturación';
            $observaciones = "Timbrado mediante la solicitud de timbrado: #{$solId} solicitada por: {$solicitanteTxt} y aprobada por: {$aprobadorTxt}";
        } elseif ($ev['evento'] === 'CONCLUIDA') {
            // App\Monitoring\Timbrado\TimbradoConclusionWatcher::alConfirmar()
            // registra este evento al completar folioFiscal/idccp en SICRET.
            // Mismo bug que la rama TIMBRADO de arriba, pero para las
            // solicitudes del Motor de Timbrado Automático de
            // trafico-system: esas NUNCA emiten un evento TIMBRADO (saltan
            // directo de CREADA a CONCLUIDA, ver docblock de
            // TimbradoConclusionWatcher), así que sin esta rama caían en el
            // mismo "Solicitud de Timbrado / PENDIENTE" fantasma de siempre
            // pese a estar realmente timbradas y facturadas. Si la
            // solicitud SÍ tuvo un evento TIMBRADO previo (flujo manual
            // clásico), se etiqueta distinto para no duplicar la misma
            // confirmación dos veces en el timeline.
            $tipo = isset($timbradoConfirmadoPorSolicitud[$solId]) ? 'Folio fiscal confirmado' : 'Guía timbrada';
            $resultado = 'OK';
            if (isset($creacionTimbrado[$solId])) {
                $duracion = gmdate("H:i:s", strtotime($ev['created_at']) - strtotime($creacionTimbrado[$solId]));
            }
            if ($tipo === 'Guía timbrada') {
                // Motor de Timbrado Automático: nunca hubo evento TIMBRADO
                // previo, así que este CONCLUIDA es la primera confirmación
                // real de que la guía quedó timbrada — mismo mensaje
                // enriquecido que la rama TIMBRADO de arriba, resolviendo
                // el usuario real de facturas33 contra empleados en SICRET.
                $solicitanteTxt = $solicitantePorSolicitud[$solId] ?? ($ev['actor'] ?? 'Solicitante no registrado');
                $aprobadorTxt = $aprobadorPorSolicitud[$solId]
                    ?? $resolverFacturador($numGuia, $guiaSource ?? null, $creacionTimbrado[$solId] ?? '1970-01-01')
                    ?? 'Facturación';
                $observaciones = "Timbrado mediante la solicitud de timbrado: #{$solId} solicitada por: {$solicitanteTxt} y aprobada por: {$aprobadorTxt}";
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
            'observaciones' => $observaciones,
            'motivo' => ($ev['evento'] === 'RECHAZADA') ? ($ev['detalle'] ?? '') : '',
            'duracion' => $duracion
        ];
    }

    // 2b. Timbrado directo en SICRET, sin Solicitud de Timbrado previa (ver
    // App\Monitoring\Timbrado\DirectStampingWatcher) — esta guía nunca pasa
    // por solicitud_timbrado_historial, así que el bloque de arriba no
    // aporta ningún evento para ella; sin esto, el historial quedaba mudo
    // después de "Asignada al operador" pese a que la guía sí se timbró.
    // Solo aplica si esta guía NO tiene ninguna solicitud_timbrado propia.
    // Bug corregido: antes solo se descartaba este bloque cuando había un
    // evento TIMBRADO (flujo manual clásico), pero el Motor de Timbrado
    // Automático nunca emite TIMBRADO (va directo de CREADA a CONCLUIDA,
    // ver docblock de TimbradoConclusionWatcher) — así que este bloque
    // seguía disparando y añadía un evento fantasma de "timbrado directo"
    // encima de una solicitud de timbrado real ya reportada arriba.
    $yaTieneSolicitudTimbrado = !empty($eventosTimbrado);

    if (!$yaTieneSolicitudTimbrado && $guiaBase && isset($guiaBase['id'])) {
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
