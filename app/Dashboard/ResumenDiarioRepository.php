<?php

declare(strict_types=1);

namespace App\Dashboard;

use PDO;

final class ResumenDiarioRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    public function existe(string $fecha): bool
    {
        $stmt = $this->connection->prepare('SELECT 1 FROM resumen_diario_tablero WHERE fecha = :fecha');
        $stmt->execute(['fecha' => $fecha]);

        return $stmt->fetchColumn() !== false;
    }

    /**
     * @param array{guias_creadas: int, timbrado_aprobadas: int, timbrado_rechazadas: int, liberacion_aprobadas: int, liberacion_rechazadas: int} $resumen
     */
    public function guardar(string $fecha, array $resumen): void
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO resumen_diario_tablero
                (fecha, guias_creadas, timbrado_aprobadas, timbrado_rechazadas, liberacion_aprobadas, liberacion_rechazadas)
             VALUES
                (:fecha, :guias_creadas, :timbrado_aprobadas, :timbrado_rechazadas, :liberacion_aprobadas, :liberacion_rechazadas)
             ON DUPLICATE KEY UPDATE
                guias_creadas = VALUES(guias_creadas),
                timbrado_aprobadas = VALUES(timbrado_aprobadas),
                timbrado_rechazadas = VALUES(timbrado_rechazadas),
                liberacion_aprobadas = VALUES(liberacion_aprobadas),
                liberacion_rechazadas = VALUES(liberacion_rechazadas)'
        );

        $stmt->execute([
            'fecha' => $fecha,
            'guias_creadas' => $resumen['guias_creadas'],
            'timbrado_aprobadas' => $resumen['timbrado_aprobadas'],
            'timbrado_rechazadas' => $resumen['timbrado_rechazadas'],
            'liberacion_aprobadas' => $resumen['liberacion_aprobadas'],
            'liberacion_rechazadas' => $resumen['liberacion_rechazadas'],
        ]);
    }
}
