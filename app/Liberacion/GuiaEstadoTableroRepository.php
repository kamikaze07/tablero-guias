<?php

declare(strict_types=1);

namespace App\Liberacion;

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
     * Transición GENERADA -> SOLICITADA_LIBERACION como compare-and-swap
     * atómico: primero intenta actualizar una fila existente en GENERADA;
     * si no hay fila (guía implícitamente GENERADA), intenta insertarla.
     * Devuelve false si ninguna de las dos operaciones tuvo efecto, es
     * decir, si otra solicitud ya reclamó la guía primero.
     */
    public function intentarMarcarSolicitada(int $guiaId): bool
    {
        $update = $this->connection->prepare(
            'UPDATE guia_estado_tablero
             SET estado = :nuevo_estado
             WHERE guia_id = :guia_id AND estado IN (:estado_generada, :estado_asignada)'
        );

        $update->execute([
            'nuevo_estado' => self::ESTADO_SOLICITADA_LIBERACION,
            'guia_id' => $guiaId,
            'estado_generada' => self::ESTADO_GENERADA,
            'estado_asignada' => self::ESTADO_ASIGNADA_AL_OPERADOR,
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
     * Panel "Por Timbrar" del tablero de Facturación: guías que ATLAS
     * mismo confirmó como liberadas (evidencia real de
     * App\Monitoring\Liberacion\LiberationConfirmationWatcher), no un
     * espejo de guias.estatus — ver
     * knowledge/modules/solicitudes-liberacion/future-considerations.md §2
     * sobre por qué guias.estatus no sirve para esto
     * (App\Sync\GuiaRepository::insert() es INSERT-only, ese campo queda
     * congelado al momento de detección). Estará vacío hasta que
     * App\Infrastructure\Sicret\PdoSicretGateway::liberar() deje de ser
     * un placeholder.
     *
     * @return array<int, array<string, mixed>>
     */
    public function listarPorTimbrar(int $page, int $perPage): array
    {
        $offset = ($page - 1) * $perPage;

        $stmt = $this->connection->prepare(
            'SELECT g.id, g.source, g.num_guia, g.fecha, g.nombre AS autorizo, g.operador,
                    g.tipo, g.servicio, g.factura, g.factimpresa, g.comen_pre,
                    get.updated_at AS liberada_en,
                    TIMESTAMPDIFF(MINUTE, get.updated_at, NOW()) AS tiempo_espera_minutos
             FROM guia_estado_tablero get
             JOIN guias g ON g.id = get.guia_id
             WHERE get.estado = :estado
             ORDER BY get.updated_at DESC
             LIMIT :limit OFFSET :offset'
        );

        $stmt->bindValue(':estado', self::ESTADO_POR_TIMBRAR);
        $stmt->bindValue(':limit', $perPage, PDO::PARAM_INT);
        $stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function contarPorTimbrar(): int
    {
        $stmt = $this->connection->prepare(
            'SELECT COUNT(*) FROM guia_estado_tablero WHERE estado = :estado'
        );
        $stmt->execute(['estado' => self::ESTADO_POR_TIMBRAR]);

        return (int) $stmt->fetchColumn();
    }
}
