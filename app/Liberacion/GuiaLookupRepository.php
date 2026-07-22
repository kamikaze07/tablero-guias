<?php

declare(strict_types=1);

namespace App\Liberacion;

use PDO;

/**
 * Lectura de la tabla `guias` (propiedad del Synchronization Engine, ver
 * App\Sync\GuiaRepository) desde la perspectiva de este módulo: resolver
 * folios recibidos de un sistema externo a las filas reales de ATLAS.
 */
final class GuiaLookupRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Puede devolver más de una fila para el mismo num_guia si el folio
     * existe en más de una fuente (source) — la ambigüedad se resuelve en
     * la capa de servicio, no aquí.
     *
     * @param string[] $numGuias
     * @return array<int, array{id: int, source: string, num_guia: string}>
     */
    public function buscarPorNumGuia(array $numGuias): array
    {
        if ($numGuias === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($numGuias), '?'));

        $stmt = $this->connection->prepare(
            "SELECT id, source, num_guia FROM guias WHERE num_guia IN ({$placeholders})"
        );
        $stmt->execute(array_values($numGuias));

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Resuelve `source` y `num_guia` a partir de un lote de `guias.id` de
     * ATLAS. Usado por App\Liberacion\Execution\LiberacionExecutor, que
     * conoce guia_id (vía solicitud_liberacion_detalle) pero necesita
     * `source` para invocar SicretGateway, sin duplicar esa columna en la
     * tabla de detalle.
     *
     * @param int[] $guiaIds
     * @return array<int, array{id: int, source: string, num_guia: string}>
     */
    public function buscarPorId(array $guiaIds): array
    {
        if ($guiaIds === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT id, source, num_guia FROM guias WHERE id IN ({$placeholders})"
        );
        $stmt->execute(array_values($guiaIds));

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
