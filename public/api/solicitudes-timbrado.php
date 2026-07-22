<?php

declare(strict_types=1);

require __DIR__ . '/../../vendor/autoload.php';

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\GuiaLookupRepository;
use App\Liberacion\JsonResponse;
use App\Sync\SocketEventPublisher;
use App\Sync\SyncLogger;
use App\Timbrado\SolicitudTimbradoDetalleRepository;
use App\Timbrado\SolicitudTimbradoHistorialRepository;
use App\Timbrado\SolicitudTimbradoPayload;
use App\Timbrado\SolicitudTimbradoRepository;
use App\Timbrado\SolicitudTimbradoService;
use App\Timbrado\SolicitudTimbradoValidationException;
use App\Notifications\Dispatcher\NotificationDispatcher;
use App\Notifications\Consumers\Mattermost\MattermostConsumer;
use App\Notifications\Consumers\Mattermost\MattermostRouter;
use App\Notifications\Consumers\Mattermost\MattermostClient;
use App\Notifications\Consumers\Mattermost\Templates\GuideCreatedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\TimbradoRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRequestedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionApprovedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\LiberacionRejectedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampedTemplate;
use App\Notifications\Consumers\Mattermost\Templates\GuideStampFailedTemplate;

header('Content-Type: application/json');

$config = new Config();

$connection = (new ConnectionFactory())->make([
    'host' => $config->get('ATLAS_DB_HOST'),
    'port' => $config->get('ATLAS_DB_PORT'),
    'database' => $config->get('ATLAS_DB_DATABASE'),
    'username' => $config->get('ATLAS_DB_USERNAME'),
    'password' => $config->get('ATLAS_DB_PASSWORD'),
]);

$logger = new SyncLogger(__DIR__ . '/../../storage/logs/api.log');

$eventPublisher = new SocketEventPublisher(
    $config->get('WEBSOCKET_INTERNAL_HOST', 'websocket'),
    (int) $config->get('WEBSOCKET_PUBLISH_PORT', '8099'),
    $logger,
);

$mattermostClient = new class implements MattermostClient {
    public function sendMessage(string $channel, string $message): void {
        error_log("Mattermost [{$channel}]: \n{$message}");
    }
};

$router = new MattermostRouter();
$mattermostConsumer = new MattermostConsumer($router, $mattermostClient);
$mattermostConsumer->registerTemplate(new GuideCreatedTemplate());
$mattermostConsumer->registerTemplate(new TimbradoRequestedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionRequestedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionApprovedTemplate());
$mattermostConsumer->registerTemplate(new LiberacionRejectedTemplate());
$mattermostConsumer->registerTemplate(new GuideStampedTemplate());
$mattermostConsumer->registerTemplate(new GuideStampFailedTemplate());

$dispatcher = new NotificationDispatcher();
$dispatcher->registerConsumer($mattermostConsumer);

$service = new SolicitudTimbradoService(
    $connection,
    new GuiaLookupRepository($connection),
    new SolicitudTimbradoRepository($connection),
    new SolicitudTimbradoDetalleRepository($connection),
    new SolicitudTimbradoHistorialRepository($connection),
    $eventPublisher,
    $logger,
    $dispatcher,
);

$method = $_SERVER['REQUEST_METHOD'] ?? 'GET';

try {
    if ($method === 'POST') {
        $data = json_decode((string) file_get_contents('php://input'), true, 512, JSON_THROW_ON_ERROR);

        if (!is_array($data)) {
            throw SolicitudTimbradoValidationException::payloadInvalido('El cuerpo debe ser un objeto JSON.');
        }

        $solicitud = $service->crear(SolicitudTimbradoPayload::fromArray($data));

        JsonResponse::ok(201, $solicitud);

        return;
    }

    if ($method === 'PATCH') {
        if (!isset($_GET['id']) || !ctype_digit((string) $_GET['id'])) {
            JsonResponse::error(400, 'id_invalido', 'El parámetro "id" debe ser numérico.');

            return;
        }

        $data = json_decode((string) file_get_contents('php://input'), true, 512, JSON_THROW_ON_ERROR);

        if (!is_array($data)) {
            throw SolicitudTimbradoValidationException::payloadInvalido('El cuerpo debe ser un objeto JSON.');
        }

        $id = (int) $_GET['id'];
        $accion = is_string($data['accion'] ?? null) ? $data['accion'] : '';
        $actor = is_string($data['actor'] ?? null) && trim($data['actor']) !== '' ? trim($data['actor']) : null;

        if ($accion === 'aprobar') {
            JsonResponse::ok(200, $service->aprobar($id, $actor));

            return;
        }

        if ($accion === 'rechazar') {
            $motivo = is_string($data['motivo'] ?? null) ? $data['motivo'] : '';

            JsonResponse::ok(200, $service->rechazar($id, $actor, $motivo));

            return;
        }

        throw SolicitudTimbradoValidationException::accionInvalida($accion);
    }

    if ($method === 'GET') {
        if (isset($_GET['id'])) {
            if (!ctype_digit((string) $_GET['id'])) {
                JsonResponse::error(400, 'id_invalido', 'El parámetro "id" debe ser numérico.');

                return;
            }

            $solicitud = $service->obtener((int) $_GET['id']);

            if ($solicitud === null) {
                JsonResponse::error(404, 'solicitud_no_encontrada', 'No existe una solicitud con ese id.');

                return;
            }

            JsonResponse::ok(200, $solicitud);

            return;
        }

        $filtros = [
            'estado' => $_GET['estado'] ?? null,
            'desde' => $_GET['desde'] ?? null,
            'hasta' => $_GET['hasta'] ?? null,
        ];

        $page = isset($_GET['page']) ? max(1, (int) $_GET['page']) : 1;
        $perPage = isset($_GET['perPage']) ? max(1, (int) $_GET['perPage']) : 25;

        JsonResponse::ok(200, $service->listar($filtros, $page, $perPage));

        return;
    }

    JsonResponse::error(405, 'metodo_no_permitido', 'Método HTTP no soportado.');
} catch (\JsonException) {
    JsonResponse::error(400, 'payload_invalido', 'El cuerpo de la petición no es JSON válido.');
} catch (SolicitudTimbradoValidationException $e) {
    JsonResponse::error($e->httpStatus, $e->errorCode, $e->getMessage(), $e->context);
} catch (\Throwable $e) {
    $logger->error('Error inesperado en solicitudes-timbrado.php', ['error' => $e->getMessage()]);
    JsonResponse::error(500, 'error_interno', 'Ocurrió un error interno.');
}
