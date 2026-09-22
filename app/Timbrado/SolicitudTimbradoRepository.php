<?php

declare(strict_types=1);

namespace App\Timbrado;

use App\Dashboard\BusinessDay;
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
    public const ESTADO_CONCLUIDA = 'CONCLUIDA';

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
        $stmt = $this->connection->prepare("SELECT COUNT(id) FROM solicitud_timbrado {$where}");

        foreach ($params as $key => $value) {
            $stmt->bindValue(':' . $key, $value);
        }

        $stmt->execute();

        return (int) $stmt->fetchColumn();
    }

    /**
     * Resumen ligero de contadores por estado y tiempo en espera de las
     * solicitudes activas — mismo patrón que en Liberación.
     *
     * @return array{pendientes: int, en_espera: int, mas_antigua_minutos: int, del_dia: int}
     */
    public function metricasResumen(): array
    {
        $stmt = $this->connection->prepare(
            "SELECT
                SUM(CASE WHEN estado = :pendiente THEN 1 ELSE 0 END) AS pendientes,
                SUM(CASE WHEN estado = :esperando THEN 1 ELSE 0 END) AS en_espera,
                SUM(CASE WHEN DATE(created_at) = CURDATE() THEN 1 ELSE 0 END) AS del_dia,
                MIN(CASE WHEN estado IN (:pend_ant, :esp_ant) THEN created_at ELSE NULL END) AS mas_antigua
             FROM solicitud_timbrado"
        );

        $stmt->execute([
            'pendiente' => self::ESTADO_PENDIENTE,
            'esperando' => self::ESTADO_ESPERANDO_TIMBRADO,
            'pend_ant' => self::ESTADO_PENDIENTE,
            'esp_ant' => self::ESTADO_ESPERANDO_TIMBRADO,
        ]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC) ?: [];
        $pendientes = (int) ($row['pendientes'] ?? 0);
        $enEspera = (int) ($row['en_espera'] ?? 0);
        $delDia = (int) ($row['del_dia'] ?? 0);
        $masAntigua = $row['mas_antigua'] ?? null;

        $minutos = 0;

        if ($masAntigua && ($pendientes > 0 || $enEspera > 0)) {
            $diff = (new \DateTimeImmutable($masAntigua))->diff(new \DateTimeImmutable());
            $minutos = ($diff->days * 1440) + ($diff->h * 60) + $diff->i;
        }

        return [
            'pendientes' => $pendientes,
            'en_espera' => $enEspera,
            'mas_antigua_minutos' => $minutos,
            'del_dia' => $delDia,
        ];
    }

    /**
     * Panel operativo principal del tablero de Timbrado — un renglón por guía,
     * no por solicitud. Lista las guías que hoy esperan acción humana en
     * Tráfico o en Facturación: estado PENDIENTE o ESPERANDO_TIMBRADO del lado
     * de ATLAS, cruzado contra `guias` e ignorando a propósito las que Tráfico
     * y Facturación acuerdan dejar atrás en los cortes del día — ver
     * BusinessDay.
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarParaTablero(string $sort = 'fecha', string $direction = 'desc'): array
    {
        $columnaOrden = self::SORT_COLUMNS[$sort] ?? 'g.fecha';
        $dir = strtolower($direction) === 'asc' ? 'ASC' : 'DESC';

        $stmt = $this->connection->prepare(
            "SELECT st.id AS solicitud_id, st.origen AS sucursal, st.solicitante,
                    st.estado, st.created_at,
                    d.num_guia,
                    g.id AS guia_id, g.source, g.fecha AS fecha_guia, g.cliente, g.nombre AS autorizo
             FROM solicitud_timbrado st
             JOIN solicitud_timbrado_detalle d ON d.solicitud_id = st.id
             LEFT JOIN guias g ON g.id = d.guia_id
             WHERE st.estado IN (:pendiente, :esperando_timbrado)
               AND g.fecha >= :desde
             ORDER BY {$columnaOrden} {$dir}, d.num_guia ASC"
        );

        $stmt->execute([
            'pendiente' => self::ESTADO_PENDIENTE,
            'esperando_timbrado' => self::ESTADO_ESPERANDO_TIMBRADO,
            'desde' => BusinessDay::limiteHaciaAtras()->format('Y-m-d H:i:s'),
        ]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Indicadores del panel de Facturación.
     *
     * @return array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float}
     */
    public function kpis(): array
    {
        $dia = BusinessDay::containing(new \DateTimeImmutable());

        $stmt = $this->connection->prepare(
            "SELECT
                SUM(estado = 'PENDIENTE') AS pendientes,
                SUM(estado IN ('ESPERANDO_TIMBRADO', 'TIMBRADO') AND resolved_at >= :desde_aprob AND resolved_at < :hasta_aprob) AS aprobadas_hoy,
                SUM(estado = 'RECHAZADA' AND resolved_at >= :desde_rech AND resolved_at < :hasta_rech) AS rechazadas_hoy,
                (SELECT AVG(TIMESTAMPDIFF(MINUTE, created_at, NOW()))
                   FROM solicitud_timbrado WHERE estado = 'PENDIENTE') AS tiempo_promedio_espera_minutos
             FROM solicitud_timbrado"
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
     * Guías resueltas por Timbrado dentro de una ventana [desde, hasta) —
     * usado por el resumen diario (App\Dashboard\DailyCutoverEngine) y por
     * el KPI en vivo del tablero de Tráfico. Cuenta guías, no solicitudes:
     * una solicitud puede cubrir varias guías a la vez (por lote), y cada
     * una cuenta como un resultado individual — de ahí el JOIN contra
     * solicitud_timbrado_detalle en vez de un COUNT(*) sobre la cabecera.
     *
     * @return array{aprobadas: int, rechazadas: int}
     */
    public function contarResueltasEnVentana(string $desde, string $hasta): array
    {
        $stmt = $this->connection->prepare(
            "SELECT
                SUM(st.estado IN ('ESPERANDO_TIMBRADO', 'TIMBRADO') AND st.resolved_at >= :desde_aprob AND st.resolved_at < :hasta_aprob) AS aprobadas,
                SUM(st.estado = 'RECHAZADA' AND st.resolved_at >= :desde_rech AND st.resolved_at < :hasta_rech) AS rechazadas
             FROM solicitud_timbrado_detalle d
             JOIN solicitud_timbrado st ON st.id = d.solicitud_id"
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

    /**
     * @param array{estado?: ?string, desde?: ?string, hasta?: ?string} $filtros
     * @return array{0: string, 1: array<string, mixed>}
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

        $where = empty($clauses) ? '' : 'WHERE ' . implode(' AND ', $clauses);

        return [$where, $params];
    }

    public function marcarAprobada(int $id, string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado, resolved_at = :resolved_at, resolved_by = :resolved_by
             WHERE id = :id AND estado = :estado_actual'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_ESPERANDO_TIMBRADO,
            'resolved_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'resolved_by' => $actor,
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
     * App\Monitoring\Timbrado\TimbradoConclusionWatcher: confirmó
     * que todas las guías en SICRET tienen folioFiscal <> '' e idccp <> ''.
     *
     * Bug real corregido (mismo que listarPendientesConclusion()): el WHERE
     * también excluía ESTADO_TIMBRADO, así que esta UPDATE nunca podía
     * escribir CONCLUIDA sobre una solicitud que ya estaba en TIMBRADO — que
     * es precisamente el estado de reposo normal antes de calificar. Solo
     * RECHAZADA y CONCLUIDA son terminales de verdad para este compare-and-set.
     */
    public function marcarConcluida(int $id): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado, resolved_at = COALESCE(resolved_at, :resolved_at)
             WHERE id = :id AND estado NOT IN (:rechazada, :concluida)'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_CONCLUIDA,
            'resolved_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'rechazada' => self::ESTADO_RECHAZADA,
            'concluida' => self::ESTADO_CONCLUIDA,
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

    /**
     * Solicitudes en cualquier estado no terminal para ser inspeccionadas por
     * App\Monitoring\Timbrado\TimbradoConclusionWatcher.
     *
     * Bug real corregido: la versión anterior también excluía ESTADO_TIMBRADO
     * de esta lista — pero TIMBRADO es precisamente el estado de reposo en el
     * que cae la mayoría de las solicitudes reales antes de calificar para
     * CONCLUIDA (alcanzado hoy por TimbradoConfirmationWatcher con evidencia
     * débil — solo existencia de XML, sin validar folioFiscal/idccp). Excluirlo
     * significaba que TimbradoConclusionWatcher nunca las consideraba, y
     * ninguna solicitud llegaba jamás a CONCLUIDA en la práctica (confirmado:
     * solicitud real 138, en TIMBRADO con folioFiscal/idccp ya completos en
     * ambas guías, nunca transicionaba). Solo RECHAZADA y CONCLUIDA son
     * verdaderamente terminales para este watcher.
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarPendientesConclusion(): array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, origen, solicitante, estado, created_at
             FROM solicitud_timbrado
             WHERE estado NOT IN (:rechazada, :concluida)
             ORDER BY created_at ASC, id ASC'
        );
        $stmt->execute([
            'rechazada' => self::ESTADO_RECHAZADA,
            'concluida' => self::ESTADO_CONCLUIDA,
        ]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function marcarRechazada(int $id, string $actor): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado
             SET estado = :estado, resolved_at = :resolved_at, resolved_by = :resolved_by
             WHERE id = :id AND estado = :estado_actual'
        );

        $stmt->execute([
            'id' => $id,
            'estado' => self::ESTADO_RECHAZADA,
            'resolved_at' => (new \DateTimeImmutable())->format('Y-m-d H:i:s'),
            'resolved_by' => $actor,
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
                    st.resolved_at, st.resolved_by,
                    TIMESTAMPDIFF(MINUTE, st.created_at, NOW()) AS tiempo_espera_minutos,
                    d.guia_id, d.num_guia, d.factura_impresa,
                    g.source, g.nombre AS autorizo, g.operador, g.fecha, g.tipo, g.servicio
             FROM solicitud_timbrado st
             JOIN solicitud_timbrado_detalle d ON d.solicitud_id = st.id
             JOIN guias g ON g.id = d.guia_id
             {$where}
             ORDER BY (st.estado IN ('" . self::ESTADO_PENDIENTE . "', '" . self::ESTADO_ESPERANDO_TIMBRADO . "')) DESC,
                      {$orderBy} {$orderDir}, st.id DESC
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
