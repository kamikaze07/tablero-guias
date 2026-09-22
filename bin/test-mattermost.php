<?php
declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Notifications\Dispatcher\NotificationDispatcher;use App\Notifications\Consumers\Trafico\TraficoWebhookConsumer;
use App\Notifications\Consumers\Mattermost\MattermostConsumer;
use App\Notifications\Consumers\Mattermost\MattermostRouter;
use App\Notifications\Consumers\Mattermost\MattermostHttpClient;
use App\Notifications\Consumers\Mattermost\Templates\TestNotificationTemplate;
use App\Domain\Events\TestNotificationEvent;

// 1. Cargar Configuración (usa getenv, así que cargamos manualmente .env para CLI si es necesario)
// Aunque en docker las variables ya están en entorno, para CLI standalone usamos Dotenv si está disponible o asumimos entorno
$config = new Config();

$webhookUrl = $config->get('MATTERMOST_WEBHOOK', '');
$channel = $config->get('MATTERMOST_CHANNEL_ANUNCIOS', 'anuncios');
$botUsername = $config->get('MATTERMOST_BOT_USERNAME', 'AtlasBot');
$baseUrl = $config->get('MATTERMOST_URL', '');
$token = $config->get('MATTERMOST_TOKEN', '');
$team = $config->get('MATTERMOST_TEAM', '');

if (empty($webhookUrl) && empty($token)) {
    echo "ERROR: Debe configurar MATTERMOST_WEBHOOK o MATTERMOST_TOKEN en el entorno.\n";
    exit(1);
}

try {
    // 2. Instanciar Cliente HTTP (soporta webhook o bot token API)
    $client = new MattermostHttpClient($webhookUrl, $botUsername, $baseUrl, $token, $team);

    // 3. Instanciar Router con el canal configurado
    $router = new MattermostRouter($channel);

    // 4. Instanciar Consumer
    $consumer = new MattermostConsumer($router, $client);
    
    // 5. Registrar la plantilla de prueba
    $consumer->registerTemplate(new TestNotificationTemplate());

    // 6. Configurar Dispatcher
    $dispatcher = new NotificationDispatcher();
    $dispatcher->registerConsumer($consumer);
    $dispatcher->registerConsumer(new TraficoWebhookConsumer($config->get('TRAFICO_EVENTS_URL'), $config->get('TRAFICO_EVENTS_SECRET')));

    // 7. Emitir Evento de Prueba
    echo "Enviando evento de prueba a Mattermost...\n";
    $event = new TestNotificationEvent();
    
    $dispatcher->dispatch($event);
    
    echo "Prueba exitosa. El mensaje debería aparecer en el canal '{$channel}'.\n";

} catch (\Exception $e) {
    echo "Fallo en la prueba: " . $e->getMessage() . "\n";
    exit(1);
}
