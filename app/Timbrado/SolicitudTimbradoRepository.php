<?php

declare(strict_types=1);

namespace App\Timbrado;

use PDO;

final class SolicitudTimbradoRepository
{
    /**
     * `estado` transita PENDIENTE -> ESPERANDO_TIMBRADO -> TIMBRADO, o
     * PENDIENTE -> RECHAZADA (terminal). ESPERANDO_TIMBRADO/TIMBRADO los
     * escribe App\Monitoring\Timbrado\TimbradoConfirmationWatcher (puente
     * temporal con el timbrado manual de SICRET, ver ese archivo) — a
     * diferencia de Liberación, aquí no hay estado "APROBADA" intermedio:
     * el propio acto de aprobar ya deja la solicitud esperando la
     * confirmación de SICRET, nunca hay nada que ATLAS deba "ejecutar".
     */
    public const ESTADO_PENDIENTE = 'PENDIENTE';
    public const ESTADO_ESPERANDO_TIMBRADO = 'ESPERANDO_TIMBRADO';
    public const ESTADO_TIMBRADO = 'TIMBRADO';
    public const ESTADO_RECHAZADA = 'RECHAZADA';

    public function __construct(private readonly PDO $connection)
    {
    }

    public function insertar(string $origen, ?string $solicitante): int
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_timbrado (origen, solicitante, estado)
             VALUES (:origen, :solicitante, :estado)'
        );

        $stmt->execute([
            'origen' => $origen,
            'solicitante' => $solicitante,
            'estado' => self::ESTADO_PENDIENTE,
        ]);

        return (int) $this->connection->lastInsertId();
    }

    /** @return array<string, mixed>|null */
    public function encontrarPorId(int $id): ?array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, origen, solicitante, estado, created_at
             FROM solicitud_timbrado
             WHERE id = :id'
        );
        $stmt->execute(['id' => $id]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        return $row === false ? null : $row;
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
            "SELECT st.id, st.origen, st.solicitante, st.estado, st.created_at,
                    COUNT(d.guia_id) AS total_guias
             FROM solicitud_timbrado st
             LEFT JOIN solicitud_timbrado_detalle d ON d.solicitud_id = st.id
             {$where}
             GROUP BY st.id
             ORDER BY st.created_at DESC, st.id DESC
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
            "SELECT COUNT(*) FROM solicitud_timbrado st {$where}"
        );
        $stmt->execute($params);

        return (int) $stmt->fetchColumn();
    }

    /**
     * Indicadores del panel de Facturación.
     *
     * @return array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float}
     */
    public function kpis(): array
    {
        $stmt = $this->connection->query(
            "SELECT
                SUM(estado = 'PENDIENTE') AS pendientes,
                SUM(estado IN ('APROBADA', 'COMPLETADA', 'ERROR') AND DATE(resolved_at) = CURDATE()) AS aprobadas_hoy,
                SUM(estado = 'RECHAZADA' AND DATE(resolved_at) = CURDATE()) AS rechazadas_hoy,
                (SELECT AVG(TIMESTAMPDIFF(MINUTE, created_at, NOW()))
                   FROM solicitud_timbrado WHERE estado = 'PENDIENTE') AS tiempo_promedio_espera_minutos
             FROM solicitud_timbrado"
        );

        $row = $stmt->fetch(PDO::FETCH_ASSOC) ?: [];

        return [
            'pendientes' => (int) ($row['pendientes'] ?? 0),
            'aprobadas_hoy' => (int) ($row['aprobadas_hoy'] ?? 0),
            'rechazadas_hoy' => (int) ($row['rechazadas_hoy'] ?? 0),
            'tiempo_promedio_espera_minutos' => round((float) ($row['tiempo_promedio_espera_minutos'] ?? 0), 1),
        ];
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
            $clauses[] = 'st.estado = :estado';
            $params['estado'] = $filtros['estado'];
        }

        if (!empty($filtros['desde'])) {
            $clauses[] = 'st.created_at >= :desde';
            $params['desde'] = $filtros['desde'] . ' 00:00:00';
        }

        if (!empty($filtros['hasta'])) {
            $clauses[] = 'st.created_at <= :hasta';
            $params['hasta'] = $filtros['hasta'] . ' 23:59:59';
        }

        $where = $clauses === [] ? '' : 'WHERE ' . implode(' AND ', $clauses);

        return [$where, $params];
    }

    public function marcarAprobada(int $id, string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado
             WHERE id = :id AND estado = :estado_actual'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_ESPERANDO_TIMBRADO,
            'estado_actual' => self::ESTADO_PENDIENTE,
        ]);

        return $stmt->rowCount() > 0;
    }

    /**
     * App\Monitoring\Timbrado\TimbradoConfirmationWatcher: encontró
     * evidencia (factura_impresa + XML en la carpeta OUT) de que el
     * timbrado manual en SICRET concluyó para todas las guías del lote.
     */
    public function marcarTimbrado(int $id): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado
             WHERE id = :id AND estado = :estado_actual'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_TIMBRADO,
            'estado_actual' => self::ESTADO_ESPERANDO_TIMBRADO,
        ]);

        return $stmt->rowCount() > 0;
    }

    /**
     * Solicitudes en un estado dado, de la más antigua a la más reciente —
     * mismo propósito que
     * App\Liberacion\SolicitudLiberacionRepository::listarPorEstado(),
     * usado por App\Monitoring\Timbrado\TimbradoConfirmationWatcher (busca
     * ESTADO_ESPERANDO_TIMBRADO).
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarPorEstado(string $estado): array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, origen, solicitante, estado, created_at
             FROM solicitud_timbrado
             WHERE estado = :estado
             ORDER BY created_at ASC, id ASC'
        );
        $stmt->execute(['estado' => $estado]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function marcarRechazada(int $id, string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado
             WHERE id = :id AND estado = :estado_actual'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_RECHAZADA,
            'estado_actual' => self::ESTADO_PENDIENTE,
        ]);

        return $stmt->rowCount() > 0;
    }

    private const SORT_COLUMNS = [
        'fecha' => 'g.fecha',
        'tiempo_espera' => 'st.created_at',
        'empresa' => 'g.source',
        'autorizo' => 'g.nombre',
        'num_guia' => 'd.num_guia',
    ];

    /**
     * Vista aplanada por guía — mismo propósito y misma forma que
     * App\Liberacion\SolicitudLiberacionRepository::listarConDetalleGuia():
     * una fila por guía dentro de cada lote, para que un consumidor de
     * solo lectura (p. ej. trafico-system) pueda resolver el estado real de
     * Timbrado por folio sin tener que conocer el id interno de la
     * solicitud ni hacer N llamadas (una por folio).
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
            "SELECT st.id AS solicitud_id, st.origen, st.solicitante, st.estado, st.created_at,
                    TIMESTAMPDIFF(MINUTE, st.created_at, NOW()) AS tiempo_espera_minutos,
                    d.guia_id, d.num_guia,
                    g.source, g.nombre AS autorizo, g.operador, g.fecha, g.tipo, g.servicio
             FROM solicitud_timbrado st
             JOIN solicitud_timbrado_detalle d ON d.solicitud_id = st.id
             JOIN guias g ON g.id = d.guia_id
             {$where}
             ORDER BY {$orderBy} {$orderDir}, st.id DESC
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
             FROM solicitud_timbrado st
             JOIN solicitud_timbrado_detalle d ON d.solicitud_id = st.id
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
            $clauses[] = 'st.estado = :estado';
            $params['estado'] = $filtros['estado'];
        }

        if (!empty($filtros['desde'])) {
            $clauses[] = 'st.created_at >= :desde';
            $params['desde'] = $filtros['desde'] . ' 00:00:00';
        }

        if (!empty($filtros['hasta'])) {
            $clauses[] = 'st.created_at <= :hasta';
            $params['hasta'] = $filtros['hasta'] . ' 23:59:59';
        }

        if (!empty($filtros['num_guia'])) {
            $clauses[] = 'd.num_guia LIKE :num_guia';
            $params['num_guia'] = '%' . $filtros['num_guia'] . '%';
        }

        // Ver el mismo filtro en
        // App\Liberacion\SolicitudLiberacionRepository::condicionesDetalle().
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
}
