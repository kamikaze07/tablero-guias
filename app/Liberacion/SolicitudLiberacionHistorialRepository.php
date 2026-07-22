<?php

declare(strict_types=1);

namespace App\Liberacion;

use PDO;

/**
 * Bitácora append-only (ver database-design.md §4): esta clase únicamente
 * inserta y lee, nunca actualiza ni borra una fila ya escrita.
 */
final class SolicitudLiberacionHistorialRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    public function registrar(
        int $solicitudId,
        string $evento,
        ?string $estadoAnterior,
        string $estadoNuevo,
        ?string $actor,
        ?string $detalle,
    ): void {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_liberacion_historial
                (solicitud_id, evento, estado_anterior, estado_nuevo, actor, detalle)
             VALUES
                (:solicitud_id, :evento, :estado_anterior, :estado_nuevo, :actor, :detalle)'
        );

        $stmt->execute([
            'solicitud_id' => $solicitudId,
            'evento' => $evento,
            'estado_anterior' => $estadoAnterior,
            'estado_nuevo' => $estadoNuevo,
            'actor' => $actor,
            'detalle' => $detalle,
        ]);
    }

    /** @return array<int, array<string, mixed>> */
    public function porSolicitud(int $solicitudId): array
    {
        $stmt = $this->connection->prepare(
            'SELECT evento, estado_anterior, estado_nuevo, actor, detalle, created_at
             FROM solicitud_liberacion_historial
             WHERE solicitud_id = :solicitud_id
             ORDER BY created_at ASC, id ASC'
        );
        $stmt->execute(['solicitud_id' => $solicitudId]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
