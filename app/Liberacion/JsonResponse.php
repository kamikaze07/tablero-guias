<?php

declare(strict_types=1);

namespace App\Liberacion;

/**
 * Forma de respuesta compartida por los distintos casos de
 * public/api/solicitudes-liberacion.php — evita repetir el mismo
 * http_response_code()+json_encode() en cada rama del script de entrada.
 */
final class JsonResponse
{
    /** @param array<string, mixed> $body */
    public static function ok(int $status, array $body): void
    {
        http_response_code($status);
        echo json_encode($body, JSON_UNESCAPED_UNICODE);
    }

    /** @param array<string, mixed> $context */
    public static function error(int $status, string $code, string $message, array $context = []): void
    {
        http_response_code($status);
        echo json_encode(['error' => $code, 'mensaje' => $message, ...$context], JSON_UNESCAPED_UNICODE);
    }
}
