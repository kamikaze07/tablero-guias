<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Dashboard\BusinessDay;
use PDO;
use PDOException;

final class GuiaEstadoTableroRepository
{
    private const DUPLICATE_ENTRY_ERROR_CODE = 1062;

    public const ESTADO_GENERADA = 'GENERADA';
    public const ESTADO_ASIGNADA_AL_OPERADOR = 'ASIGNADA_AL_OPERADOR';
    public const ESTADO_SOLICITADA_LIBERACION = 'SOLICITADA_LIBERACION';
    public const ESTADO_EJECUTANDO = 'EJECUTANDO';
    public const ESTADO_POR_TIMBRAR = 'POR_TIMBRAR';
    public const ESTADO_TIMBRADO = 'TIMBRADO';
    public const ESTADO_ERROR = 'ERROR';

    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Estado actual de cada guía consultada. Una guía ausente del
     * resultado nunca transicionó — su estado implícito es GENERADA (ver
     * knowledge/modules/solicitudes-liberacion/database-design.md §1).
     *
     * @param int[] $guiaIds
     * @return array<int, string> guia_id => estado
     */
    public function estadosActuales(array $guiaIds): array
    {
        if ($guiaIds === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT guia_id, estado FROM guia_estado_tablero WHERE guia_id IN ({$placeholders})"
        );
        $stmt->execute(array_values($guiaIds));

        $estados = [];

        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $row) {
            $estados[(int) $row['guia_id']] = (string) $row['estado'];
        }

        return $estados;
    }

    /**
     * Transición -> SOLICITADA_LIBERACION como compare-and-swap atómico:
     * primero intenta actualizar una fila existente; si no hay fila (guía
     * implícitamente GENERADA), intenta insertarla. Devuelve false si
     * ninguna de las dos operaciones tuvo efecto — es decir, si otra
     * solicitud de Liberación ya reclamó la guía primero (o está en
     * ejecución).
     *
     * El UPDATE acepta cualquier estado origen EXCEPTO uno de Liberación
     * activa (SOLICITADA_LIBERACION/EJECUTANDO) — antes solo aceptaba
     * GENERADA/ASIGNADA_AL_OPERADOR, lo que rechazaba (vía el INSERT
     * duplicado más abajo, no esta comprobación) guías que SICRET confirma
     * en vivo como "Asignada Al Operador" pero cuyo `guia_estado_tablero`
     * ya avanzó a TIMBRADO/POR_TIMBRAR/ERROR por una vía independiente
     * (p. ej. timbrado directo en SICRET). Ver
     * SolicitudLiberacionService::verificarDisponibilidad()/
     * descartarPorEstatusRealEnSicret(), la única autoridad real sobre
     * elegibilidad de negocio — esta comprobación solo debe impedir una
     * doble reclamación mientras una Liberación ya está en curso. No existe
     * un estado "LIBERADA" separado: al completarse con éxito,
     * LiberationConfirmationWatcher mueve la guía a ESTADO_POR_TIMBRAR.
     */
    public function intentarMarcarSolicitada(int $guiaId): bool
    {
        $update = $this->connection->prepare(
            'UPDATE guia_estado_tablero
             SET estado = :nuevo_estado
             WHERE guia_id = :guia_id AND estado NOT IN (:estado_solicitada, :estado_ejecutando)'
        );

        $update->execute([
            'nuevo_estado' => self::ESTADO_SOLICITADA_LIBERACION,
            'guia_id' => $guiaId,
            'estado_solicitada' => self::ESTADO_SOLICITADA_LIBERACION,
            'estado_ejecutando' => self::ESTADO_EJECUTANDO,
        ]);

        if ($update->rowCount() === 1) {
            return true;
        }

        try {
            $insert = $this->connection->prepare(
                'INSERT INTO guia_estado_tablero (guia_id, estado) VALUES (:guia_id, :estado)'
            );

            $insert->execute([
                'guia_id' => $guiaId,
                'estado' => self::ESTADO_SOLICITADA_LIBERACION,
            ]);

            return true;
        } catch (PDOException $e) {
            if ((int) $e->errorInfo[1] === self::DUPLICATE_ENTRY_ERROR_CODE) {
                return false;
            }

            throw $e;
        }
    }

    /**
     * Transición directa, usada exclusivamente por
     * App\Liberacion\Execution\LiberacionExecutor y
     * App\Monitoring\Liberacion\LiberationConfirmationWatcher para las
     * etapas posteriores a SOLICITADA_LIBERACION (EJECUTANDO, LIBERADA,
     * ERROR). A diferencia de intentarMarcarSolicitada(), no necesita
     * compare-and-swap: en estas etapas ya no compiten dos solicitudes por
     * la misma guía, solo el propio Executor/Watcher avanzando su flujo.
     */
    public function marcarEstado(int $guiaId, string $estado): void
    {
        $update = $this->connection->prepare(
            'UPDATE guia_estado_tablero SET estado = :estado WHERE guia_id = :guia_id'
        );
        $update->execute(['estado' => $estado, 'guia_id' => $guiaId]);

        if ($update->rowCount() > 0) {
            return;
        }

        $insert = $this->connection->prepare(
            'INSERT INTO guia_estado_tablero (guia_id, estado) VALUES (:guia_id, :estado)'
        );
        $insert->execute(['guia_id' => $guiaId, 'estado' => $estado]);
    }

    /**
     * Transición a TIMBRADO con `factura_impresa` en la misma escritura —
     * exclusiva de App\Monitoring\Timbrado\DirectStampingWatcher (timbrado
     * directo en SICRET sin Solicitud de Timbrado previa, ver docblock de
     * esa clase). A diferencia de marcarEstado(), unicamente vale para esta
     * transición puntual: no hay compare-and-swap porque, igual que en
     * marcarEstado(), nada más compite por la misma guía en esta etapa.
     */
    public function marcarTimbradoDirecto(int $guiaId, string $facturaImpresa): void
    {
        $update = $this->connection->prepare(
            'UPDATE guia_estado_tablero
                SET estado = :estado, factura_impresa = :factura_impresa
              WHERE guia_id = :guia_id'
        );
        $update->execute([
            'estado' => self::ESTADO_TIMBRADO,
            'factura_impresa' => $facturaImpresa,
            'guia_id' => $guiaId,
        ]);

        if ($update->rowCount() > 0) {
            return;
        }

        $insert = $this->connection->prepare(
            'INSERT INTO guia_estado_tablero (guia_id, estado, factura_impresa)
             VALUES (:guia_id, :estado, :factura_impresa)'
        );
        $insert->execute([
            'guia_id' => $guiaId,
            'estado' => self::ESTADO_TIMBRADO,
            'factura_impresa' => $facturaImpresa,
        ]);
    }

    /**
     * public/api/timbrado-carta-porte.php: segunda fuente de
     * `factura_impresa` cuando el folio no tiene fila en
     * solicitud_timbrado_detalle (caso de timbrado directo, ver
     * marcarTimbradoDirecto()). Mismo contrato que
     * SolicitudTimbradoDetalleRepository::facturaImpresaConfirmadaPorNumGuia():
     * null si el folio no existe o todavía no tiene un timbrado directo
     * confirmado.
     */
    public function facturaImpresaConfirmadaPorNumGuia(string $numGuia): ?string
    {
        $stmt = $this->connection->prepare(
            'SELECT get.factura_impresa
             FROM guia_estado_tablero get
             JOIN guias g ON g.id = get.guia_id
             WHERE g.num_guia = :num_guia
               AND get.estado = :estado
               AND get.factura_impresa IS NOT NULL
             LIMIT 1'
        );

        $stmt->execute([
            'num_guia' => $numGuia,
            'estado' => self::ESTADO_TIMBRADO,
        ]);

        $value = $stmt->fetchColumn();

        return $value === false ? null : (string) $value;
    }

    /**
     * Panel "Por Timbrar" del tablero de Facturación: guías que ATLAS
     * mismo confirmó como liberadas (evidencia real de
     * App\Monitoring\Liberacion\LiberationConfirmationWatcher), no un
     * espejo de guias.estatus — ver
     * knowledge/modules/solicitudes-liberacion/future-considerations.md §2
     * sobre por qué guias.estatus no sirve para esto
     * (App\Sync\GuiaRepository::insert() es INSERT-only, ese campo queda
     * congelado al momento de detección). Incluye tanto ESTADO_POR_TIMBRAR
     * como ESTADO_TIMBRADO a propósito — la guía no desaparece del panel
     * cuando App\Monitoring\Timbrado\TimbradoConfirmationWatcher confirma
     * el timbrado (evidencia real contra la carpeta OUT); se queda visible
     * con su nuevo estado. Lo efímero es la Solicitud (desaparece del
     * panel de solicitudes al resolverse, ver SolicitudTimbradoRepository /
     * SolicitudLiberacionRepository::condiciones()) — la guía, no.
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarPorTimbrar(int $page, int $perPage): array
    {
        $offset = ($page - 1) * $perPage;

        $stmt = $this->connection->prepare(
            'SELECT g.id, g.source, g.num_guia, g.fecha, g.nombre AS autorizo, g.operador,
                    g.tipo, g.servicio, g.factura, g.factimpresa, g.comen_pre,
                    get.estado AS estado_tablero,
                    get.updated_at AS liberada_en,
                    TIMESTAMPDIFF(MINUTE, get.updated_at, NOW()) AS tiempo_espera_minutos
             FROM guia_estado_tablero get
             JOIN guias g ON g.id = get.guia_id
             WHERE get.estado IN (:estado_por_timbrar, :estado_timbrado)
             ORDER BY get.updated_at DESC
             LIMIT :limit OFFSET :offset'
        );

        $stmt->bindValue(':estado_por_timbrar', self::ESTADO_POR_TIMBRAR);
        $stmt->bindValue(':estado_timbrado', self::ESTADO_TIMBRADO);
        $stmt->bindValue(':limit', $perPage, PDO::PARAM_INT);
        $stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function contarPorTimbrar(): int
    {
        $stmt = $this->connection->prepare(
            'SELECT COUNT(*) FROM guia_estado_tablero WHERE estado IN (:estado_por_timbrar, :estado_timbrado)'
        );
        $stmt->execute([
            'estado_por_timbrar' => self::ESTADO_POR_TIMBRAR,
            'estado_timbrado' => self::ESTADO_TIMBRADO,
        ]);

        return (int) $stmt->fetchColumn();
    }

    /**
     * KPI "Guías por timbrar" del tablero de Facturación — a diferencia de
     * contarPorTimbrar() (backlog histórico completo de
     * public/api/guias-liberadas.php, que a propósito nunca deja de contar
     * una guía solo porque ya se timbró), este KPI debe reflejar el trabajo
     * pendiente de HOY: guías que ya se liberaron y esperan timbrado
     * (ESTADO_POR_TIMBRAR) pero que AÚN no se timbran — ESTADO_TIMBRADO
     * queda fuera a propósito. "Hoy" es la jornada operativa de
     * App\Dashboard\BusinessDay (corte 07:00), no medianoche-medianoche.
     *
     * `updated_at` es la única marca de tiempo de esta tabla (una fila por
     * guía, no historial) — para una guía cuyo estado ACTUAL es
     * ESTADO_POR_TIMBRAR, ese valor es, por definición, el momento en que
     * transicionó a ese estado (la última escritura fue justo esa
     * transición), así que sirve tal cual para acotar la ventana de "hoy".
     */
    public function contarPorTimbrarHoy(): int
    {
        $dia = BusinessDay::containing(new \DateTimeImmutable());

        $stmt = $this->connection->prepare(
            'SELECT COUNT(*) FROM guia_estado_tablero
             WHERE estado = :estado_por_timbrar
               AND updated_at >= :desde
               AND updated_at < :hasta'
        );
        $stmt->execute([
            'estado_por_timbrar' => self::ESTADO_POR_TIMBRAR,
            'desde' => $dia->desde,
            'hasta' => $dia->hasta,
        ]);

        return (int) $stmt->fetchColumn();
    }
}
