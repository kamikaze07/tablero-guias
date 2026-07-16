<?php

declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\WebSocket\TrafficDashboard;
use Ratchet\Http\HttpServer;
use Ratchet\Server\IoServer;
use Ratchet\WebSocket\WsServer;
use React\EventLoop\Loop;
use React\Socket\ConnectionInterface;
use React\Socket\SocketServer;

$config = new Config();
$loop = Loop::get();

$dashboard = new TrafficDashboard();

$wsPort = (int) $config->get('WEBSOCKET_PORT', '8098');
$publishPort = (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099');

// Servidor público: los navegadores del Dashboard se conectan aquí.
$wsSocket = new SocketServer("0.0.0.0:{$wsPort}", [], $loop);
new IoServer(new HttpServer(new WsServer($dashboard)), $wsSocket, $loop);

// Canal interno de publicación: solo el Synchronization Engine se conecta aquí
// (no se expone al host en docker-compose) para anunciar eventos ya persistidos
// en ATLAS. Protocolo: una línea de JSON por evento.
$publishSocket = new SocketServer("0.0.0.0:{$publishPort}", [], $loop);
$publishSocket->on('connection', function (ConnectionInterface $connection) use ($dashboard): void {
    $buffer = '';

    $connection->on('data', function (string $chunk) use (&$buffer, $dashboard): void {
        $buffer .= $chunk;

        while (($pos = strpos($buffer, "\n")) !== false) {
            $line = substr($buffer, 0, $pos);
            $buffer = substr($buffer, $pos + 1);

            if (trim($line) !== '') {
                $dashboard->broadcast($line);
            }
        }
    });
});

fwrite(STDOUT, sprintf(
    "[OK] WebSocket server — navegadores: %d, publicación interna: %d\n",
    $wsPort,
    $publishPort,
));

$loop->run();
