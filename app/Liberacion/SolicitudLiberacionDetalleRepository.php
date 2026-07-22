<?php

declare(strict_types=1);

namespace App\Liberacion;

use PDO;

final class SolicitudLiberacionDetalleRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    public function insertarLote(int $solicitudId, array $guias): void
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_liberacion_detalle (solicitud_id, guia_id, num_guia)
             VALUES (:solicitud_id, :guia_id, :num_guia)'
        );

        foreach ($guias as $guia) {
            $stmt->execute([
                'solicitud_id' => $solicitudId,
                'guia_id' => $guia['guia_id'],
                'num_guia' => $guia['num_guia'],
            ]);
        }
    }

    /** @return array<int, array<string, mixed>> */
    public function porSolicitud(int $solicitudId): array
    {
        $stmt = $this->connection->prepare(
            'SELECT guia_id, num_guia
             FROM solicitud_liberacion_detalle
             WHERE solicitud_id = :solicitud_id
             ORDER BY num_guia ASC'
        );
        $stmt->execute(['solicitud_id' => $solicitudId]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
