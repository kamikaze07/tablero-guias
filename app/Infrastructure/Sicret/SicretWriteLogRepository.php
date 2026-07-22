<?php

declare(strict_types=1);

namespace App\Infrastructure\Sicret;

use PDO;

/**
 * Bitácora append-only de todo intento de escritura de ATLAS hacia
 * SICRET, sin importar qué proceso de negocio lo origina. Única clase
 * que escribe en `sicret_write_log` — cada operación de PdoSicretGateway
 * registra aquí tanto éxitos como fallos como rechazos por semántica no
 * confirmada.
 */
final class SicretWriteLogRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    public function registrar(
        string $operacion,
        string $source,
        string $numGuia,
        string $resultado,
        ?string $detalle = null,
    ): void {
        $stmt = $this->connection->prepare(
            'INSERT INTO sicret_write_log (operacion, source, num_guia, resultado, detalle)
             VALUES (:operacion, :source, :num_guia, :resultado, :detalle)'
        );

        $stmt->execute([
            'operacion' => $operacion,
            'source' => $source,
            'num_guia' => $numGuia,
            'resultado' => $resultado,
            'detalle' => $detalle,
        ]);
    }
}
