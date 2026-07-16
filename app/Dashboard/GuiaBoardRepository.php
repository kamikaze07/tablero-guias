<?php

declare(strict_types=1);

namespace App\Dashboard;

use PDO;

final class GuiaBoardRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Guías del día en curso para el panel "Guías Generadas", de la más
     * reciente a la más antigua según el orden de detección en ATLAS.
     *
     * @return array<int, array<string, mixed>>
     */
    public function findToday(): array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado, operador
             FROM guias
             WHERE fecha >= :today
             ORDER BY id DESC'
        );

        $stmt->execute([
            'today' => (new \DateTimeImmutable('today'))->format('Y-m-d H:i:s'),
        ]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
