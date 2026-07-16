<?php

declare(strict_types=1);

namespace App\Sync;

final class SocketEventPublisher implements EventPublisher
{
    private const CONNECT_TIMEOUT_SECONDS = 2;

    public function __construct(
        private readonly string $host,
        private readonly int $port,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * Publica un evento ya confirmado en ATLAS hacia el servidor WebSocket.
     * Un fallo aquí nunca debe afectar la sincronización: ATLAS ya es la
     * fuente de verdad, el frontend recupera el estado al reconectar.
     */
    public function publish(string $event, array $payload): void
    {
        $message = json_encode(
            ['event' => $event, 'payload' => $payload],
            JSON_UNESCAPED_UNICODE
        );

        $connection = @stream_socket_client(
            "tcp://{$this->host}:{$this->port}",
            $errno,
            $errstr,
            self::CONNECT_TIMEOUT_SECONDS,
        );

        if ($connection === false) {
            $this->logger->error('No se pudo publicar evento al WebSocket server', [
                'event' => $event,
                'error' => $errstr,
            ]);

            return;
        }

        fwrite($connection, $message . "\n");
        fclose($connection);
    }
}
