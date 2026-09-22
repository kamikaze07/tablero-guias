<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Dashboard\BusinessDay;
use PDO;

final class SolicitudLiberacionRepository
{
    public const ESTADO_PENDIENTE = 'PENDIENTE';
    public const ESTADO_APROBADA = 'APROBADA';
    public const ESTADO_EJECUTANDO = 'EJECUTANDO';
    public const ESTADO_COMPLETADA = 'COMPLETADA';
    public const ESTADO_RECHAZADA = 'RECHAZADA';
    public const ESTADO_ERROR = 'ERROR';

    public function __construct(private readonly PDO $connection)
    {
    }

    public function insertar(string $origen, string $motivo): int
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_liberacion (origen, motivo, estado)
             VALUES (:origen, :motivo, :estado)'
        );

        $stmt->execute([
            'origen' => $origen,
            'motivo' => $motivo,
            'estado' => self::ESTADO_PENDIENTE,
        ]);

        return (int) $this->connection->lastInsertId();
    }

    /** @return array<string, mixed>|null */
    public function encontrarPorId(int $id): ?array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, origen, motivo, estado, created_at,
                    resolved_at, resolved_by, error_reason
             FROM solicitud_liberacion
             WHERE id = :id'
        );
        $stmt->execute(['id' => $id]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        return $row === false ? null : $row;
    }

    /**
     * Panel de trabajo de Facturación: aprobar/rechazar (App\Liberacion\SolicitudLiberacionService::aprobar/rechazar)
     * como compare-and-swap — solo transiciona una solicitud que sigue en
     * PENDIENTE, mismo principio que
     * GuiaEstadoTableroRepository::intentarMarcarSolicitada (evita que dos
     * revisores resuelvan la misma solicitud dos veces).
     */
    public function marcarAprobada(int $id, ?string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_liberacion
                SET estado = :estado, resolved_at = :resolved_at, resolved_by = :resolved_by
              WHERE id = :id AND estado = :estado_pendiente'
        );

        $stmt->execute([
            'estado' => self::ESTADO_APROBADA,
            'resolved_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'resolved_by' => $actor,
            'id' => $id,
            'estado_pendiente' => self::ESTADO_PENDIENTE,
        ]);

        return $stmt->rowCount() === 1;
    }

    /** @see self::marcarAprobada() */
    public function marcarRechazada(int $id, ?string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_liberacion
                SET estado = :estado, resolved_at = :resolved_at, resolved_by = :resolved_by
              WHERE id = :id AND estado = :estado_pendiente'
        );

        $stmt->execute([
            'estado' => self::ESTADO_RECHAZADA,
            'resolved_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'resolved_by' => $actor,
            'id' => $id,
            'estado_pendiente' => self::ESTADO_PENDIENTE,
        ]);

        return $stmt->rowCount() === 1;
    }

    /**
     * Indicadores del panel de Facturación — una sola consulta para no
     * repetir escaneos de la tabla por cada tarjeta de KPI.
     *
     * @return array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float}
     */
    public function kpis(): array
    {
        $dia = BusinessDay::containing(new \DateTimeImmutable());

        $stmt = $this->connection->prepare(
            "SELECT
                SUM(estado = 'PENDIENTE') AS pendientes,
                SUM(estado IN ('APROBADA', 'EJECUTANDO', 'COMPLETADA', 'ERROR') AND resolved_at >= :desde_aprob AND resolved_at < :hasta_aprob) AS aprobadas_hoy,
                SUM(estado = 'RECHAZADA' AND resolved_at >= :desde_rech AND resolved_at < :hasta_rech) AS rechazadas_hoy,
                (SELECT AVG(TIMESTAMPDIFF(MINUTE, created_at, NOW()))
                   FROM solicitud_liberacion WHERE estado = 'PENDIENTE') AS tiempo_promedio_espera_minutos
             FROM solicitud_liberacion"
        );

        $stmt->execute([
            'desde_aprob' => $dia->desde,
            'hasta_aprob' => $dia->hasta,
            'desde_rech' => $dia->desde,
            'hasta_rech' => $dia->hasta,
        ]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC) ?: [];

        return [
            'pendientes' => (int) ($row['pendientes'] ?? 0),
            'aprobadas_hoy' => (int) ($row['aprobadas_hoy'] ?? 0),
            'rechazadas_hoy' => (int) ($row['rechazadas_hoy'] ?? 0),
            'tiempo_promedio_espera_minutos' => round((float) ($row['tiempo_promedio_espera_minutos'] ?? 0), 1),
        ];
    }

    /**
     * Guías resueltas por Liberación dentro de una ventana [desde, hasta) —
     * usado por el resumen diario (App\Dashboard\DailyCutoverEngine) y por
     * el KPI en vivo del tablero de Tráfico. Cuenta guías, no solicitudes:
     * una solicitud puede cubrir varias guías a la vez (por lote), y cada
     * una cuenta como un resultado individual — de ahí el JOIN contra
     * solicitud_liberacion_detalle en vez de un COUNT(*) sobre la cabecera.
     *
     * @return array{aprobadas: int, rechazadas: int}
     */
    public function contarResueltasEnVentana(string $desde, string $hasta): array
    {
        $stmt = $this->connection->prepare(
            "SELECT
                SUM(sl.estado IN ('APROBADA', 'EJECUTANDO', 'COMPLETADA', 'ERROR') AND sl.resolved_at >= :desde_aprob AND sl.resolved_at < :hasta_aprob) AS aprobadas,
                SUM(sl.estado = 'RECHAZADA' AND sl.resolved_at >= :desde_rech AND sl.resolved_at < :hasta_rech) AS rechazadas
             FROM solicitud_liberacion_detalle d
             JOIN solicitud_liberacion sl ON sl.id = d.solicitud_id"
        );

        $stmt->execute([
            'desde_aprob' => $desde,
            'hasta_aprob' => $hasta,
            'desde_rech' => $desde,
            'hasta_rech' => $hasta,
        ]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC) ?: [];

        return [
            'aprobadas' => (int) ($row['aprobadas'] ?? 0),
            'rechazadas' => (int) ($row['rechazadas'] ?? 0),
        ];
    }

    private const SORT_COLUMNS = [
        'fecha' => 'g.fecha',
        'tiempo_espera' => 'sl.created_at',
        'empresa' => 'g.source',
        'autorizo' => 'g.nombre',
        'num_guia' => 'd.num_guia',
    ];

    /**
     * Vista aplanada del panel de Facturación: una fila por guía dentro de
     * cada lote (no una fila por solicitud, ver
     * SolicitudLiberacionRepository::listar()) — es lo que permite
     * mostrar/filtrar/ordenar por columnas propias de la guía (autorizó,
     * operador, empresa, fecha) sin que el frontend tenga que resolverlas
     * por su cuenta.
     *
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string, num_guia?: ?string, num_guias?: ?string[], operador?: ?string, source?: ?string} $filtros
     * @return array<int, array<string, mixed>>
     */
    public function listarConDetalleGuia(array $filtros, string $sort, string $dir, int $page, int $perPage): array
    {
        [$where, $params] = $this->condicionesDetalle($filtros);
        $orderBy = self::SORT_COLUMNS[$sort] ?? self::SORT_COLUMNS['fecha'];
        $orderDir = strtoupper($dir) === 'ASC' ? 'ASC' : 'DESC';
        $offset = ($page - 1) * $perPage;

        $stmt = $this->connection->prepare(
            "SELECT sl.id AS solicitud_id, sl.origen, sl.motivo, sl.estado, sl.created_at,
                    (SELECT h.actor FROM solicitud_liberacion_historial h WHERE h.solicitud_id = sl.id AND h.evento = 'CREADA' ORDER BY h.id ASC LIMIT 1) AS solicitante,
                    sl.resolved_at, sl.resolved_by, sl.error_reason,
                    TIMESTAMPDIFF(MINUTE, sl.created_at, NOW()) AS tiempo_espera_minutos,
                    d.guia_id, d.num_guia,
                    g.source, g.nombre AS autorizo, g.operador, g.fecha, g.tipo, g.servicio
             FROM solicitud_liberacion sl
             JOIN solicitud_liberacion_detalle d ON d.solicitud_id = sl.id
             JOIN guias g ON g.id = d.guia_id
             {$where}
             ORDER BY (sl.estado IN ('" . self::ESTADO_PENDIENTE . "', '" . self::ESTADO_APROBADA . "', '" . self::ESTADO_EJECUTANDO . "')) DESC,
                      {$orderBy} {$orderDir}, sl.id DESC
             LIMIT :limit OFFSET :offset"
        );

        foreach ($params as $key => $value) {
            $stmt->bindValue(':' . $key, $value);
        }

        $stmt->bindValue(':limit', $perPage, PDO::PARAM_INT);
        $stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /** @param array{estado?: ?string, desde?: ?string, hasta?: ?string, num_guia?: ?string, num_guias?: ?string[], operador?: ?string, source?: ?string} $filtros */
    public function contarConDetalleGuia(array $filtros): int
    {
        [$where, $params] = $this->condicionesDetalle($filtros);

        $stmt = $this->connection->prepare(
            "SELECT COUNT(*)
             FROM solicitud_liberacion sl
             JOIN solicitud_liberacion_detalle d ON d.solicitud_id = sl.id
             JOIN guias g ON g.id = d.guia_id
             {$where}"
        );
        $stmt->execute($params);

        return (int) $stmt->fetchColumn();
    }

    /**
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string, num_guia?: ?string, num_guias?: ?string[], operador?: ?string, source?: ?string} $filtros
     * @return array{0: string, 1: array<string, string>}
     */
    private function condicionesDetalle(array $filtros): array
    {
        $clauses = [];
        $params = [];

        if (!empty($filtros['estado'])) {
            $clauses[] = 'sl.estado = :estado';
            $params['estado'] = $filtros['estado'];
        }

        if (!empty($filtros['desde'])) {
            $clauses[] = 'sl.created_at >= :desde';
            $params['desde'] = $filtros['desde'] . ' 00:00:00';
        }

        if (!empty($filtros['hasta'])) {
            $clauses[] = 'sl.created_at <= :hasta';
            $params['hasta'] = $filtros['hasta'] . ' 23:59:59';
        }

        if (!empty($filtros['num_guia'])) {
            $clauses[] = 'd.num_guia LIKE :num_guia';
            $params['num_guia'] = '%' . $filtros['num_guia'] . '%';
        }

        // Filtro por lote exacto de folios (a diferencia de num_guia, que es
        // un LIKE de un solo valor) — usado por consumidores que ya conocen
        // el conjunto exacto de folios a resolver (ver
        // trafico-system/app/modules/guias/services/AtlasEstadoService.php),
        // para no forzar N llamadas HTTP (una por folio visible en una
        // página del listado).
        if (!empty($filtros['num_guias']) && is_array($filtros['num_guias'])) {
            $placeholders = [];

            foreach (array_values($filtros['num_guias']) as $i => $numGuia) {
                $key = 'num_guia_in_' . $i;
                $placeholders[] = ':' . $key;
                $params[$key] = $numGuia;
            }

            if ($placeholders !== []) {
                $clauses[] = 'd.num_guia IN (' . implode(',', $placeholders) . ')';
            }
        }

        if (!empty($filtros['operador'])) {
            $clauses[] = 'g.operador LIKE :operador';
            $params['operador'] = '%' . $filtros['operador'] . '%';
        }

        if (!empty($filtros['source'])) {
            $clauses[] = 'g.source = :source';
            $params['source'] = $filtros['source'];
        }

        $where = $clauses === [] ? '' : 'WHERE ' . implode(' AND ', $clauses);

        return [$where, $params];
    }

    /**
     * Solicitudes en un estado dado, de la más antigua a la más reciente
     * (orden de atención). Usado por App\Liberacion\Execution\LiberacionExecutor
     * (busca ESTADO_APROBADA) y por
     * App\Monitoring\Liberacion\LiberationConfirmationWatcher (busca
     * ESTADO_EJECUTANDO) — ninguno de los dos consulta la tabla
     * directamente.
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarPorEstado(string $estado): array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, origen, motivo, estado, created_at
             FROM solicitud_liberacion
             WHERE estado = :estado
             ORDER BY created_at ASC, id ASC'
        );
        $stmt->execute(['estado' => $estado]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /** LiberacionExecutor: acaba de solicitar la escritura a SicretGateway para todas las guías del lote. */
    public function marcarEjecutando(int $id): void
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_liberacion SET estado = :estado, executed_at = :executed_at WHERE id = :id'
        );

        $stmt->execute([
            'estado' => self::ESTADO_EJECUTANDO,
            'executed_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'id' => $id,
        ]);
    }

    /** LiberationConfirmationWatcher: encontró evidencia objetiva de que la liberación concluyó en SICRET. */
    public function marcarCompletada(int $id): void
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_liberacion SET estado = :estado, confirmed_at = :confirmed_at WHERE id = :id'
        );

        $stmt->execute([
            'estado' => self::ESTADO_COMPLETADA,
            'confirmed_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'id' => $id,
        ]);
    }

    /** LiberacionExecutor o LiberationConfirmationWatcher: la ejecución o la confirmación fallaron, con motivo. */
    public function marcarError(int $id, string $motivo): void
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_liberacion SET estado = :estado, error_reason = :error_reason WHERE id = :id'
        );

        $stmt->execute([
            'estado' => self::ESTADO_ERROR,
            'error_reason' => $motivo,
            'id' => $id,
        ]);
    }

    /**
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string} $filtros
     * @return array<int, array<string, mixed>>
     */
    public function listar(array $filtros, int $page, int $perPage): array
    {
        [$where, $params] = $this->condiciones($filtros);
        $offset = ($page - 1) * $perPage;

        $stmt = $this->connection->prepare(
            "SELECT sl.id, sl.origen, sl.motivo, sl.estado, sl.created_at,
                    COUNT(d.guia_id) AS total_guias
             FROM solicitud_liberacion sl
             LEFT JOIN solicitud_liberacion_detalle d ON d.solicitud_id = sl.id
             {$where}
             GROUP BY sl.id
             ORDER BY sl.created_at DESC, sl.id DESC
             LIMIT :limit OFFSET :offset"
        );

        foreach ($params as $key => $value) {
            $stmt->bindValue(':' . $key, $value);
        }

        $stmt->bindValue(':limit', $perPage, PDO::PARAM_INT);
        $stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
        $stmt->execute();

        $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

        foreach ($rows as &$row) {
            $row['total_guias'] = (int) $row['total_guias'];
        }

        unset($row);

        return $rows;
    }

    /** @param array{estado?: ?string, desde?: ?string, hasta?: ?string} $filtros */
    public function contar(array $filtros): int
    {
        [$where, $params] = $this->condiciones($filtros);

        $stmt = $this->connection->prepare(
            "SELECT COUNT(*) FROM solicitud_liberacion sl {$where}"
        );
        $stmt->execute($params);

        return (int) $stmt->fetchColumn();
    }

    /**
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string} $filtros
     * @return array{0: string, 1: array<string, string>}
     */
    private function condiciones(array $filtros): array
    {
        $clauses = [];
        $params = [];

        if (!empty($filtros['estado'])) {
            $clauses[] = 'sl.estado = :estado';
            $params['estado'] = $filtros['estado'];
        }

        if (!empty($filtros['desde'])) {
            $clauses[] = 'sl.created_at >= :desde';
            $params['desde'] = $filtros['desde'] . ' 00:00:00';
        }

        if (!empty($filtros['hasta'])) {
            $clauses[] = 'sl.created_at <= :hasta';
            $params['hasta'] = $filtros['hasta'] . ' 23:59:59';
        }

        $where = $clauses === [] ? '' : 'WHERE ' . implode(' AND ', $clauses);

        return [$where, $params];
    }
}
