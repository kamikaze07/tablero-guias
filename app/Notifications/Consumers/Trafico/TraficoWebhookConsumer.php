<?php

declare(strict_types=1);

namespace App\Notifications\Consumers\Trafico;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideCreated;
use App\Domain\Events\GuideStamped;
use App\Domain\Events\GuideStampFailed;
use App\Domain\Events\LiberacionApproved;
use App\Domain\Events\LiberacionRejected;
use App\Domain\Events\LiberacionRequested;
use App\Domain\Events\TestNotificationEvent;
use App\Domain\Events\TimbradoApproved;
use App\Domain\Events\TimbradoConcluded;
use App\Domain\Events\TimbradoRejected;
use App\Domain\Events\TimbradoRequested;
use App\Notifications\Consumers\Mattermost\Templates\EmpresaLabel;
use App\Notifications\Contracts\EventConsumer;

/**
 * Empuja los eventos de dominio de ATLAS al webhook de trafico-system
 * (Fase E.3 — Avisos en tiempo real), autenticado por HMAC-SHA256 con la
 * cabecera X-Atlas-Signature.
 *
 * Reglas de aislamiento, críticas:
 *
 *  - Si TRAFICO_EVENTS_URL o TRAFICO_EVENTS_SECRET están vacíos,
 *    supports() siempre devuelve false. El consumer queda inerte y la
 *    lógica de negocio del proceso (Mattermost, sync, etc.) NO se
 *    entera de su existencia. Se eligió esto en lugar de un try/catch
 *    global para que la ausencia de configuración no genere ruido en
 *    logs ni errores en el dispatcher.
 *
 *  - handle() está envuelto en un try/catch (\Throwable) — un timeout
 *    o un 5xx del trafico-nginx NUNCA debe abortar el consumer de
 *    Mattermost ni el flujo que disparó el evento. El aviso silencioso
 *    (sin exception) es la decisión correcta: el polling de 8s del
 *    frontend de Facturación lo recogerá como fallback.
 *
 *  - Timeouts estrictos: 1s connect_timeout, 2s total. No usamos
 *    streams síncronos (file_get_contents) porque no respetan timeouts
 *    por debajo del cierre TCP y pueden colgar el motor. cURL es la
 *    única herramienta en este repo que nos da control fino.
 *
 *  - El nombre del evento enviado al webhook es el FQCN de la clase
 *    (GuideCreated, TimbradoRequested, etc.) — coincide con el
 *    `event` que `event.startsWith('guia.')` y la lista
 *    EVENTOS_ATLAS_FACTURACION de app/views/facturacion/index.php
 *    esperan. La traducción de "source" crudo de SICRET a etiqueta de
 *    negocio (FORSIS/GERO) se delega a EmpresaLabel::desde() para
 *    no divergir con los templates de Mattermost.
 */
final class TraficoWebhookConsumer implements EventConsumer
{
    private const CONNECT_TIMEOUT_SECONDS = 1;
    private const TIMEOUT_SECONDS = 2;

    /** @var array<class-string<DomainEvent>, string> Mapa FQCN → nombre de evento. */
    private const EVENT_MAP = [
        TestNotificationEvent::class => 'TestNotificationEvent',
        GuideCreated::class => 'GuideCreated',
        TimbradoRequested::class => 'TimbradoRequested',
        LiberacionRequested::class => 'LiberacionRequested',
        TimbradoApproved::class => 'TimbradoApproved',
        TimbradoConcluded::class => 'TimbradoConcluded',
        TimbradoRejected::class => 'TimbradoRejected',
        LiberacionRejected::class => 'LiberacionRejected',
        LiberacionApproved::class => 'LiberacionApproved',
        GuideStamped::class => 'GuideStamped',
        GuideStampFailed::class => 'GuideStampFailed',
    ];

    private ?string $url;
    private string $secret;
    private bool $enabled;

    public function __construct(?string $url, ?string $secret)
    {
        $this->url = ($url !== null && trim($url) !== '') ? trim($url) : null;
        $this->secret = (string) ($secret ?? '');
        $this->enabled = $this->url !== null && $this->secret !== '';
    }

    public function supports(DomainEvent $event): bool
    {
        if (!$this->enabled) {
            return false;
        }

        return isset(self::EVENT_MAP[$event::class]);
    }

    public function handle(DomainEvent $event): void
    {
        if (!$this->enabled) {
            return;
        }

        $eventName = self::EVENT_MAP[$event::class] ?? null;
        if ($eventName === null) {
            return;
        }

        $payload = $event->getPayload();
        $data = is_array($payload['data'] ?? null) ? $payload['data'] : [];
        $guiaId = (string) ($payload['guiaId'] ?? '');

        $source = is_string($data['source'] ?? null) ? $data['source'] : null;
        $empresa = EmpresaLabel::desde($source);

        $body = json_encode(
            [
                'event' => $eventName,
                'data' => array_merge(
                    $data,
                    [
                        'empresa' => $empresa,
                        'guiaId' => $guiaId,
                        'occurredOn' => $event->getOccurredOn()->format(\DateTimeInterface::ATOM),
                    ]
                ),
            ],
            JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES
        );

        if ($body === false) {
            return;
        }

        $this->entregar($body);
    }

    private function entregar(string $body): void
    {
        try {
            $firma = 'sha256=' . hash_hmac('sha256', $body, $this->secret);

            $ch = curl_init($this->url);
            if ($ch === false) {
                return;
            }

            curl_setopt_array($ch, [
                CURLOPT_POST => true,
                CURLOPT_POSTFIELDS => $body,
                CURLOPT_HTTPHEADER => [
                    'Content-Type: application/json; charset=utf-8',
                    'X-Atlas-Signature: ' . $firma,
                    'X-Atlas-Source: tablero-guias',
                ],
                CURLOPT_RETURNTRANSFER => true,
                CURLOPT_CONNECTTIMEOUT => self::CONNECT_TIMEOUT_SECONDS,
                CURLOPT_TIMEOUT => self::TIMEOUT_SECONDS,
                CURLOPT_NOSIGNAL => 1,
                CURLOPT_SSL_VERIFYPEER => true,
                CURLOPT_SSL_VERIFYHOST => 2,
            ]);

            curl_exec($ch);
            // Cerramos siempre; el código de estado solo se usa para
            // depuración a nivel de trafico-nginx (logs NGINX_ACCESS_LOG).
            curl_close($ch);
        } catch (\Throwable $e) {
            // Cualquier excepción (curl, JSON, timeouts extendidos, etc.)
            // se descarta silenciosamente. Por contrato, este consumer
            // NUNCA debe propagar errores a Mattermost ni al flujo que
            // disparó el evento.
        }
    }
}
