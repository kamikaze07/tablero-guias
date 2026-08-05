<?php

declare(strict_types=1);

namespace App\Dashboard;

use App\Liberacion\ContenedorLookup;
use App\Liberacion\GuiaEstadoTableroRepository;
use PDO;

final class GuiaBoardRepository
{
    public function __construct(
        private readonly PDO $connection,
        private readonly ContenedorLookup $contenedorLookup,
    ) {
    }

    /**
     * Estado completo del tablero de Tráfico para la jornada en curso,
     * repartido en los mismos cuatro cubos que trafico.js mantiene en vivo
     * vía WebSocket (generadas / solicitudes_timbrado / liberacion /
     * timbrado-resultado). Existe porque el primer pintado (page load) usa
     * esta consulta server-side y, a diferencia del cliente, no tiene
     * memoria de los eventos ya recibidos — sin esto, cualquier recarga de
     * la página devolvía TODAS las guías de hoy a "Generadas" sin importar
     * si ya tenían una solicitud de Liberación o Timbrado en curso o
     * resuelta, desincronizando el tablero del estado real de ATLAS.
     *
     * El universo de guías no se limita a las creadas hoy
     * (`findToday()`): también incluye guías de jornadas anteriores con
     * actividad de Liberación/Timbrado HOY (ver
     * `idsConActividadEnJornada()`) — sin esto, una solicitud creada o
     * resuelta hoy sobre una guía de ayer era invisible en el tablero tras
     * cualquier recarga, aunque `App\Sync\EventPublisher` sí la hubiera
     * empujado por WebSocket a las pestañas que ya estaban abiertas.
     *
     * Regla de desempate cuando una guía tiene actividad tanto de
     * Liberación como de Timbrado: gana la más reciente (mismo criterio
     * que produce el cliente al aplicar eventos de WebSocket en orden).
     *
     * @return array{generadas: array<int, array<string, mixed>>, solicitudes_timbrado: array<int, array<string, mixed>>, liberacion: array<int, array<string, mixed>>, timbrado: array<int, array<string, mixed>>}
     */
    public function boardState(): array
    {
        $dia = BusinessDay::containing(new \DateTimeImmutable());

        $ids = array_unique(array_merge(
            array_column($this->findToday(), 'id'),
            $this->idsConActividadEnJornada($dia->desde, $dia->hasta),
        ));

        $buckets = ['generadas' => [], 'solicitudes_timbrado' => [], 'liberacion' => [], 'timbrado' => []];

        if ($ids === []) {
            return $buckets;
        }

        $guias = $this->conContenedor($this->porIds($ids));

        $estadoTablero = $this->estadoTableroPorGuia($ids);
        $liberacion = $this->ultimaLiberacionPorGuia($ids);
        $timbrado = $this->ultimoTimbradoPorGuia($ids);

        foreach ($guias as $guia) {
            $guiaId = (int) $guia['id'];

            $estadoLib = $estadoTablero[$guiaId] ?? null;
            $lib = $liberacion[$guiaId] ?? null;
            $tim = $timbrado[$guiaId] ?? null;

            // "En curso" de Liberación (SOLICITADA_LIBERACION/EJECUTANDO) o
            // ERROR de ejecución: lo dicta guia_estado_tablero directamente,
            // es la única fuente que distingue esas dos etapas.
            if ($estadoLib !== null && in_array($estadoLib['estado'], [
                GuiaEstadoTableroRepository::ESTADO_SOLICITADA_LIBERACION,
                GuiaEstadoTableroRepository::ESTADO_EJECUTANDO,
            ], true)) {
                $buckets['liberacion'][] = $guia;

                continue;
            }

            if ($estadoLib !== null && $estadoLib['estado'] === GuiaEstadoTableroRepository::ESTADO_ERROR) {
                $buckets['timbrado'][] = $this->conResolucion($guia, [
                    'tipo' => 'Liberación',
                    'resultado' => 'Error',
                    'color' => 'danger',
                    'usuario' => 'liberacion-executor',
                    'fecha' => $estadoLib['updated_at'],
                    'observaciones' => $lib['error_reason'] ?? null,
                ]);

                continue;
            }

            // Sin actividad "en curso": decide quién tiene el evento más
            // reciente entre Liberación (RECHAZADA es lo único que deja un
            // resultado visible sin mover guia_estado_tablero fuera de los
            // estados neutrales) y Timbrado (PENDIENTE/ESPERANDO_TIMBRADO/
            // TIMBRADO/RECHAZADA, que nunca toca guia_estado_tablero).
            // ESPERANDO_TIMBRADO y TIMBRADO comparten bucket porque ambos
            // significan "ya aprobado por Facturación" desde la perspectiva
            // del tablero — solo difieren en si
            // App\Monitoring\Timbrado\TimbradoConfirmationWatcher ya
            // confirmó el timbrado manual en SICRET (ver
            // App\Timbrado\SolicitudTimbradoRepository).
            $libTs = $lib !== null && $lib['estado'] === 'RECHAZADA' ? $lib['ts'] : null;
            $timTs = $tim['ts'] ?? null;

            if ($tim !== null && ($libTs === null || $timTs >= $libTs)) {
                if ($tim['estado'] === 'PENDIENTE') {
                    $buckets['solicitudes_timbrado'][] = $guia;

                    continue;
                }

                if (in_array($tim['estado'], ['ESPERANDO_TIMBRADO', 'TIMBRADO'], true)) {
                    $buckets['timbrado'][] = $this->conResolucion($guia, [
                        'tipo' => 'Timbrado',
                        'resultado' => 'Aprobado',
                        'color' => 'success',
                        'usuario' => $tim['actor'],
                        'fecha' => $tim['ts'],
                        'observaciones' => null,
                    ]);

                    continue;
                }

                // CONCLUIDA (ver App\Monitoring\Timbrado\TimbradoConclusionWatcher):
                // confirmación definitiva por folioFiscal/idccp en SICRET, que
                // puede llegar sin pasar nunca por TIMBRADO. Mismo texto que
                // pinta trafico.js al recibir el evento guia.timbrado_concluido
                // en vivo — sin esta rama, una recarga de página perdía estas
                // guías del bucket 'timbrado' (caían a 'generadas' más abajo).
                if ($tim['estado'] === 'CONCLUIDA') {
                    $buckets['timbrado'][] = $this->conResolucion($guia, [
                        'tipo' => 'Timbrado',
                        'resultado' => 'Confirmado en SICRET',
                        'color' => 'success',
                        'usuario' => $tim['actor'],
                        'fecha' => $tim['ts'],
                        'observaciones' => null,
                    ]);

                    continue;
                }

                if ($tim['estado'] === 'RECHAZADA') {
                    $buckets['timbrado'][] = $this->conResolucion($guia, [
                        'tipo' => 'Timbrado',
                        'resultado' => 'Rechazado',
                        'color' => 'danger',
                        'usuario' => $tim['actor'],
                        'fecha' => $tim['ts'],
                        'observaciones' => $tim['motivo'],
                    ]);

                    continue;
                }
            }

            if ($libTs !== null) {
                $buckets['timbrado'][] = $this->conResolucion($guia, [
                    'tipo' => 'Liberación',
                    'resultado' => 'Rechazada',
                    'color' => 'danger',
                    'usuario' => $lib['resolved_by'],
                    'fecha' => $lib['ts'],
                    'observaciones' => $lib['motivo'],
                ]);

                continue;
            }

            // GENERADA / ASIGNADA_AL_OPERADOR / POR_TIMBRAR (Case 10: una
            // guía confirmada liberada vuelve a "Guías Generadas") / sin
            // fila en guia_estado_tablero.
            $buckets['generadas'][] = $guia;
        }

        return $buckets;
    }

    /**
     * Guías de la jornada en curso (ver App\Dashboard\BusinessDay, corte a
     * las 07:00) para el panel "Guías Generadas", de la más reciente a la
     * más antigua según el orden de detección en ATLAS.
     *
     * @return array<int, array<string, mixed>>
     */
    public function findToday(): array
    {
        $dia = BusinessDay::containing(new \DateTimeImmutable());

        $stmt = $this->connection->prepare(
            'SELECT id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado, operador
             FROM guias
             WHERE fecha >= :desde AND fecha < :hasta
             ORDER BY id DESC'
        );

        $stmt->execute([
            'desde' => $dia->desde,
            'hasta' => $dia->hasta,
        ]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Ids de guías de CUALQUIER jornada con actividad de Liberación o
     * Timbrado (creada o resuelta) dentro de la ventana [desde, hasta), o
     * con `guia_estado_tablero` tocado en esa ventana — el complemento de
     * `findToday()` para `boardState()`: una guía de ayer con una solicitud
     * resuelta hoy debe seguir siendo visible en el tablero de hoy.
     *
     * @return int[]
     */
    private function idsConActividadEnJornada(string $desde, string $hasta): array
    {
        $stmt = $this->connection->prepare(
            "SELECT DISTINCT d.guia_id
             FROM solicitud_timbrado_detalle d
             JOIN solicitud_timbrado st ON st.id = d.solicitud_id
             WHERE (st.created_at >= :ts_desde_1 AND st.created_at < :ts_hasta_1)
                OR (st.resolved_at >= :ts_desde_2 AND st.resolved_at < :ts_hasta_2)

             UNION

             SELECT DISTINCT d.guia_id
             FROM solicitud_liberacion_detalle d
             JOIN solicitud_liberacion sl ON sl.id = d.solicitud_id
             WHERE (sl.created_at >= :sl_desde_1 AND sl.created_at < :sl_hasta_1)
                OR (sl.resolved_at >= :sl_desde_2 AND sl.resolved_at < :sl_hasta_2)

             UNION

             SELECT guia_id FROM guia_estado_tablero
             WHERE updated_at >= :get_desde AND updated_at < :get_hasta"
        );

        $stmt->execute([
            'ts_desde_1' => $desde, 'ts_hasta_1' => $hasta,
            'ts_desde_2' => $desde, 'ts_hasta_2' => $hasta,
            'sl_desde_1' => $desde, 'sl_hasta_1' => $hasta,
            'sl_desde_2' => $desde, 'sl_hasta_2' => $hasta,
            'get_desde' => $desde, 'get_hasta' => $hasta,
        ]);

        return array_map('intval', $stmt->fetchAll(PDO::FETCH_COLUMN));
    }

    /**
     * @param int[] $guiaIds
     * @return array<int, array<string, mixed>>
     */
    private function porIds(array $guiaIds): array
    {
        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado, operador
             FROM guias
             WHERE id IN ({$placeholders})
             ORDER BY id DESC"
        );
        $stmt->execute(array_values($guiaIds));

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Contenedor por guía (ver App\Liberacion\ContenedorLookup) — dato de
     * SICRET que ATLAS no sincroniza a `guias`, resuelto en vivo para cada
     * pintado del tablero.
     *
     * @param array<int, array<string, mixed>> $guias
     * @return array<int, array<string, mixed>>
     */
    private function conContenedor(array $guias): array
    {
        if ($guias === []) {
            return $guias;
        }

        $contenedores = $this->contenedorLookup->porNumGuia(array_map(
            static fn (array $g): array => ['num_guia' => $g['num_guia'], 'source' => $g['source']],
            $guias,
        ));

        return array_map(
            static fn (array $g): array => [...$g, 'contenedor' => $contenedores[$g['num_guia']] ?? ''],
            $guias,
        );
    }

    /** Guías creadas dentro de una ventana [desde, hasta) — usado por el resumen diario. */
    public function contarGeneradasEnVentana(string $desde, string $hasta): int
    {
        $stmt = $this->connection->prepare(
            'SELECT COUNT(*) FROM guias WHERE fecha >= :desde AND fecha < :hasta'
        );
        $stmt->execute(['desde' => $desde, 'hasta' => $hasta]);

        return (int) $stmt->fetchColumn();
    }

    /** @param array<int, mixed> $guia */
    private function conResolucion(array $guia, array $resolucion): array
    {
        $guia['resolucion'] = $resolucion;

        return $guia;
    }

    /**
     * @param int[] $guiaIds
     * @return array<int, array{estado: string, updated_at: string}>
     */
    private function estadoTableroPorGuia(array $guiaIds): array
    {
        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT guia_id, estado, updated_at FROM guia_estado_tablero WHERE guia_id IN ({$placeholders})"
        );
        $stmt->execute(array_values($guiaIds));

        $result = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $result[(int) $row['guia_id']] = ['estado' => (string) $row['estado'], 'updated_at' => (string) $row['updated_at']];
        }

        return $result;
    }

    /**
     * Última Solicitud de Liberación (por id, mayor = más reciente) de cada
     * guía, con el motivo de rechazo resuelto desde la bitácora cuando
     * aplica.
     *
     * @param int[] $guiaIds
     * @return array<int, array{estado: string, ts: string, resolved_by: ?string, error_reason: ?string, motivo: ?string}>
     */
    private function ultimaLiberacionPorGuia(array $guiaIds): array
    {
        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT d.guia_id, sl.id AS solicitud_id, sl.estado, sl.resolved_by, sl.resolved_at,
                    sl.error_reason, sl.created_at
             FROM solicitud_liberacion_detalle d
             JOIN solicitud_liberacion sl ON sl.id = d.solicitud_id
             JOIN (
                 SELECT guia_id, MAX(solicitud_id) AS max_solicitud_id
                 FROM solicitud_liberacion_detalle
                 WHERE guia_id IN ({$placeholders})
                 GROUP BY guia_id
             ) latest ON latest.guia_id = d.guia_id AND latest.max_solicitud_id = d.solicitud_id"
        );
        $stmt->execute(array_values($guiaIds));

        $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $solicitudIds = array_column($rows, 'solicitud_id');
        $motivos = $solicitudIds === [] ? [] : $this->motivoRechazoLiberacion($solicitudIds);

        $result = [];

        foreach ($rows as $row) {
            $solicitudId = (int) $row['solicitud_id'];
            $result[(int) $row['guia_id']] = [
                'estado' => (string) $row['estado'],
                'ts' => (string) ($row['resolved_at'] ?? $row['created_at']),
                'resolved_by' => $row['resolved_by'],
                'error_reason' => $row['error_reason'],
                'motivo' => $motivos[$solicitudId] ?? null,
            ];
        }

        return $result;
    }

    /**
     * @param int[] $solicitudIds
     * @return array<int, string> solicitud_id => motivo del rechazo
     */
    private function motivoRechazoLiberacion(array $solicitudIds): array
    {
        $placeholders = implode(',', array_fill(0, count($solicitudIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT solicitud_id, detalle FROM solicitud_liberacion_historial
             WHERE solicitud_id IN ({$placeholders}) AND evento = 'RECHAZADA'"
        );
        $stmt->execute(array_values($solicitudIds));

        $result = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $result[(int) $row['solicitud_id']] = (string) $row['detalle'];
        }

        return $result;
    }

    /**
     * Última Solicitud de Timbrado (por id, mayor = más reciente) de cada
     * guía, con actor/motivo de la resolución (APROBADA/RECHAZADA)
     * resueltos desde la bitácora cuando aplica.
     *
     * @param int[] $guiaIds
     * @return array<int, array{estado: string, ts: string, actor: ?string, motivo: ?string}>
     */
    private function ultimoTimbradoPorGuia(array $guiaIds): array
    {
        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT d.guia_id, st.id AS solicitud_id, st.estado, st.created_at
             FROM solicitud_timbrado_detalle d
             JOIN solicitud_timbrado st ON st.id = d.solicitud_id
             JOIN (
                 SELECT guia_id, MAX(solicitud_id) AS max_solicitud_id
                 FROM solicitud_timbrado_detalle
                 WHERE guia_id IN ({$placeholders})
                 GROUP BY guia_id
             ) latest ON latest.guia_id = d.guia_id AND latest.max_solicitud_id = d.solicitud_id"
        );
        $stmt->execute(array_values($guiaIds));

        $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $solicitudIds = array_column($rows, 'solicitud_id');
        $resoluciones = $solicitudIds === [] ? [] : $this->resolucionTimbrado($solicitudIds);

        $result = [];

        foreach ($rows as $row) {
            $solicitudId = (int) $row['solicitud_id'];
            $resolucion = $resoluciones[$solicitudId] ?? null;

            $result[(int) $row['guia_id']] = [
                'estado' => (string) $row['estado'],
                'ts' => $resolucion['created_at'] ?? (string) $row['created_at'],
                'actor' => $resolucion['actor'] ?? null,
                'motivo' => $resolucion['detalle'] ?? null,
            ];
        }

        return $result;
    }

    /**
     * @param int[] $solicitudIds
     * @return array<int, array{actor: ?string, detalle: ?string, created_at: string}>
     */
    private function resolucionTimbrado(array $solicitudIds): array
    {
        $placeholders = implode(',', array_fill(0, count($solicitudIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT solicitud_id, actor, detalle, created_at FROM solicitud_timbrado_historial
             WHERE solicitud_id IN ({$placeholders}) AND evento IN ('APROBADA', 'RECHAZADA')
             ORDER BY created_at DESC, id DESC"
        );
        $stmt->execute(array_values($solicitudIds));

        $result = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $solicitudId = (int) $row['solicitud_id'];

            if (isset($result[$solicitudId])) {
                continue;
            }

            $result[$solicitudId] = [
                'actor' => $row['actor'],
                'detalle' => $row['detalle'],
                'created_at' => (string) $row['created_at'],
            ];
        }

        return $result;
    }
}
