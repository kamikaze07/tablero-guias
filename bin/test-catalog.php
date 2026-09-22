<?php
declare(strict_types=1);

require __DIR__ . '/../vendor/autoload.php';

use App\Config\Config;
use App\Notifications\Dispatcher\NotificationDispatcher;use App\Notifications\Consumers\Trafico\TraficoWebhookConsumer;
use App\Notifications\Consumers\Mattermost\MattermostConsumer;
use App\Notifications\Consumers\Mattermost\MattermostRouter;
use App\Notifications\Consumers\Mattermost\MattermostHttpClient;
use App\Notifications\Consumers\Mattermost\Templates\GuideCreatedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoRejectedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRejectedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampedTemplate;
use App\Domain\Events\GuideCreated;
use App\Domain\Events\TimbradoRequested;
use App\Domain\Events\LiberacionRequested;
use App\Domain\Events\TimbradoRejected;
use App\Domain\Events\LiberacionRejected;
use App\Domain\Events\GuideStamped;

$config = new Config();

$webhookUrl = $config->get('MATTERMOST_WEBHOOK', '');
$botUsername = $config->get('MATTERMOST_BOT_USERNAME', 'ATLAS');
$baseUrl = $config->get('MATTERMOST_URL', '');
$token = $config->get('MATTERMOST_TOKEN', '');
$team = $config->get('MATTERMOST_TEAM', '');

$chAnuncios = $config->get('MATTERMOST_CHANNEL_ANUNCIOS', 'anuncios');
$chTrafico = $config->get('MATTERMOST_CHANNEL_TRAFICO', 'trafico');
$chFacturacion = $config->get('MATTERMOST_CHANNEL_FACTURACION', 'facturacion');
$chTimbresFiscales = $config->get('MATTERMOST_CHANNEL_TIMBRES_FISCALES', 'timbres-fiscales');

if (empty($webhookUrl) && empty($token)) {
    echo "ERROR: Debe configurar MATTERMOST_WEBHOOK o MATTERMOST_TOKEN en el entorno.\n";
    exit(1);
}

try {
    $client = new MattermostHttpClient($webhookUrl, $botUsername, $baseUrl, $token, $team);
    $router = new MattermostRouter($chAnuncios, $chTrafico, $chFacturacion, $chTimbresFiscales);
    $consumer = new MattermostConsumer($router, $client);
    
    $consumer->registerTemplate(new GuideCreatedTemplate());
    $consumer->registerTemplate(new TimbradoRequestedTemplate());
    $consumer->registerTemplate(new LiberacionRequestedTemplate());
    $consumer->registerTemplate(new TimbradoRejectedTemplate());
    $consumer->registerTemplate(new LiberacionRejectedTemplate());
    $consumer->registerTemplate(new GuideStampedTemplate());

    $dispatcher = new NotificationDispatcher();
    $dispatcher->registerConsumer($consumer);
    $dispatcher->registerConsumer(new TraficoWebhookConsumer($config->get('TRAFICO_EVENTS_URL'), $config->get('TRAFICO_EVENTS_SECRET')));

    echo "Enviando catálogo de notificaciones a Mattermost...\n";

    // Data simulada
    $dataMock = [
        'empresa' => 'FORSIS',
        'usuario' => 'Juan Pérez',
        'motivo'  => 'El XML adjunto no cumple con la estructura requerida.'
    ];

    // 1. GUÍA CREADA
    $dispatcher->dispatch(new GuideCreated('PR-1001', $dataMock));
    echo "1. Guía Creada (OK)\n";
    sleep(1);

    // 2. SOLICITUD DE TIMBRADO
    $dispatcher->dispatch(new TimbradoRequested('PR-1002', $dataMock));
    echo "2. Solicitud de Timbrado (OK)\n";
    sleep(1);

    // 3. SOLICITUD DE LIBERACIÓN
    $dispatcher->dispatch(new LiberacionRequested('PR-1003', $dataMock));
    echo "3. Solicitud de Liberación (OK)\n";
    sleep(1);

    // 4. TIMBRADO RECHAZADO
    $dispatcher->dispatch(new TimbradoRejected('PR-1004', $dataMock));
    echo "4. Timbrado Rechazado (OK)\n";
    sleep(1);

    // 5. LIBERACIÓN RECHAZADA
    $dispatcher->dispatch(new LiberacionRejected('PR-1005', $dataMock));
    echo "5. Liberación Rechazada (OK)\n";
    sleep(1);

    // 6. PR TIMBRADO
    $dispatcher->dispatch(new GuideStamped('PR-1006', $dataMock));
    echo "6. PR Timbrado (OK)\n";

    echo "Prueba de catálogo finalizada con éxito.\n";

} catch (\Exception $e) {
    echo "Fallo en la prueba: " . $e->getMessage() . "\n";
    exit(1);
}
