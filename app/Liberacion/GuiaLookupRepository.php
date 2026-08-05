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

    /**
     * Fila completa de `guias` (mismas columnas que
     * App\Dashboard\GuiaBoardRepository usa para pintar una tarjeta) a
     * partir de un lote de ids. Usado por los eventos de WebSocket de
     * Liberación y Timbrado (`guia.*_solicitada`, `solicitud_*.aprobada`,
     * `solicitud_*.rechazada`): sin estos campos, el tablero de Tráfico no
     * puede crear la tarjeta cuando la guía es de una jornada anterior y
     * no estaba ya en pantalla al momento del evento (solo podía moverla,
     * ver public/assets/js/trafico.js:moveCards()).
     *
     * @param int[] $guiaIds
     * @return array<int, array{id: int, source: string, num_guia: string, fecha: string, nombre: string, tipo: string, servicio: string, placas1: string, estado: string, operador: ?string}>
     */
    public function buscarCompletoPorId(array $guiaIds): array
    {
        if ($guiaIds === []) {
            return [];
        }

        $placeholders = implode(',', array_fill(0, count($guiaIds), '?'));

        $stmt = $this->connection->prepare(
            "SELECT id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado, operador
             FROM guias WHERE id IN ({$placeholders})"
        );
        $stmt->execute(array_values($guiaIds));

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
