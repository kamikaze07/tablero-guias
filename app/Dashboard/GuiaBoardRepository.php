<?php

declare(strict_types=1);

namespace App\Dashboard;

use App\Liberacion\GuiaEstadoTableroRepository;
use PDO;

final class GuiaBoardRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Estado completo del tablero de Tráfico para las guías del día en
     * curso, repartido en los mismos cuatro cubos que trafico.js mantiene
     * en vivo vía WebSocket (generadas / solicitudes_timbrado / liberacion
     * / timbrado-resultado). Existe porque el primer pintado (page load)
     * usa esta consulta server-side y, a diferencia del cliente, no tiene
     * memoria de los eventos ya recibidos — sin esto, cualquier recarga de
     * la página devolvía TODAS las guías de hoy a "Generadas" sin importar
     * si ya tenían una solicitud de Liberación o Timbrado en curso o
     * resuelta, desincronizando el tablero del estado real de ATLAS.
     *
     * Regla de desempate cuando una guía tiene actividad tanto de
     * Liberación como de Timbrado: gana la más reciente (mismo criterio
     * que produce el cliente al aplicar eventos de WebSocket en orden).
     *
     * @return array{generadas: array<int, array<string, mixed>>, solicitudes_timbrado: array<int, array<string, mixed>>, liberacion: array<int, array<string, mixed>>, timbrado: array<int, array<string, mixed>>}
     */
    public function boardState(): array
    {
        $guias = $this->findToday();

        $buckets = ['generadas' => [], 'solicitudes_timbrado' => [], 'liberacion' => [], 'timbrado' => []];

        if ($guias === []) {
            return $buckets;
        }

        $ids = array_column($guias, 'id');

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
            // estados neutrales) y Timbrado (PENDIENTE/APROBADA/RECHAZADA,
            // que nunca toca guia_estado_tablero).
            $libTs = $lib !== null && $lib['estado'] === 'RECHAZADA' ? $lib['ts'] : null;
            $timTs = $tim['ts'] ?? null;

            if ($tim !== null && ($libTs === null || $timTs >= $libTs)) {
                if ($tim['estado'] === 'PENDIENTE') {
                    $buckets['solicitudes_timbrado'][] = $guia;

                    continue;
                }

                if ($tim['estado'] === 'APROBADA') {
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
     * Guías del día en curso para el panel "Guías Generadas", de la más
     * reciente a la más antigua según el orden de detección en ATLAS.
     *
     * @return array<int, array<string, mixed>>
     */
    public function findToday(): array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado, operador
             FROM guias
             WHERE fecha >= :today
             ORDER BY id DESC'
        );

        $stmt->execute([
            'today' => (new \DateTimeImmutable('today'))->format('Y-m-d H:i:s'),
        ]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
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
