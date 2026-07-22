<?php

declare(strict_types=1);

namespace App\Timbrado;

use PDO;

/**
 * Bitácora append-only (mismo principio que
 * App\Liberacion\SolicitudLiberacionHistorialRepository): esta clase
 * únicamente inserta y lee, nunca actualiza ni borra una fila ya escrita.
 * No tiene columnas de estado_anterior/estado_nuevo porque, a diferencia de
 * Liberación, Solicitar Timbrado no mueve ninguna máquina de estados en
 * este sprint — solo registra que la solicitud fue creada.
 */
final class SolicitudTimbradoHistorialRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    public function registrar(
        int $solicitudId,
        string $evento,
        ?string $actor,
        ?string $detalle,
    ): void {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_timbrado_historial (solicitud_id, evento, actor, detalle)
             VALUES (:solicitud_id, :evento, :actor, :detalle)'
        );

        $stmt->execute([
            'solicitud_id' => $solicitudId,
            'evento' => $evento,
            'actor' => $actor,
            'detalle' => $detalle,
        ]);
    }

    /** @return array<int, array<string, mixed>> */
    public function porSolicitud(int $solicitudId): array
    {
        $stmt = $this->connection->prepare(
            'SELECT evento, actor, detalle, created_at
             FROM solicitud_timbrado_historial
             WHERE solicitud_id = :solicitud_id
             ORDER BY created_at ASC, id ASC'
        );
        $stmt->execute(['solicitud_id' => $solicitudId]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
