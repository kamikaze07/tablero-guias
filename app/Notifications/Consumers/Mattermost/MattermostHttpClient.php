<?php
namespace App\Notifications\Consumers\Mattermost;

class MattermostHttpClient implements MattermostClient
{
    private string $webhookUrl;
    private string $botUsername;
    private string $baseUrl;
    private string $token;
    private string $team;

    public function __construct(
        string $webhookUrl,
        string $botUsername = 'AtlasBot',
        string $baseUrl = '',
        string $token = '',
        string $team = ''
    ) {
        $this->webhookUrl = rtrim($webhookUrl, '/');
        $this->botUsername = $botUsername;
        $this->baseUrl = rtrim($baseUrl, '/');
        $this->token = $token;
        $this->team = $team;
    }

    public function sendMessage(string $channel, string $message): void
    {
        try {
            if (!empty($this->token) && !empty($this->baseUrl)) {
                $this->sendViaRestApi($channel, $message);
            } else {
                $this->sendViaWebhook($channel, $message);
            }
        } catch (\Exception $e) {
            error_log(sprintf("Error enviando notificación al canal '%s': %s", $channel, $e->getMessage()));
        }
    }

    private function sendViaRestApi(string $channel, string $message): void
    {
        // 1. Obtener el ID del canal (la API requiere IDs, no nombres)
        $channelId = $this->resolveChannelId($channel);

        // 2. Enviar el mensaje
        $payload = [
            'channel_id' => $channelId,
            'message'    => $message,
        ];

        $this->makeHttpRequest('POST', $this->baseUrl . '/api/v4/posts', $payload, [
            'Authorization: Bearer ' . $this->token
        ]);
    }

    private function resolveChannelId(string $channelName): string
    {
        // Si ya es un ID de 26 caracteres (Mattermost Channel ID estándar), lo usamos directo.
        if (preg_match('/^[a-z0-9]{26}$/', $channelName)) {
            return $channelName;
        }

        if (empty($this->team)) {
            throw new \RuntimeException('Mattermost Team must be configured to resolve channel IDs.');
        }

        // Remover '#' si el usuario lo incluyó
        $channelName = ltrim($channelName, '#');
        $url = sprintf('%s/api/v4/teams/name/%s/channels/name/%s', $this->baseUrl, $this->team, $channelName);
        
        $response = $this->makeHttpRequest('GET', $url, null, [
            'Authorization: Bearer ' . $this->token
        ]);

        $data = json_decode($response, true);
        if (!isset($data['id'])) {
            throw new \RuntimeException("Could not resolve channel ID for channel: {$channelName}");
        }

        return $data['id'];
    }

    private function sendViaWebhook(string $channel, string $message): void
    {
        if (empty($this->webhookUrl)) {
            throw new \RuntimeException('Mattermost webhook URL or Bot Token is not configured.');
        }

        $payload = [
            'channel' => $channel,
            'text'    => $message,
            'username'=> $this->botUsername,
        ];

        $this->makeHttpRequest('POST', $this->webhookUrl, $payload);
    }

    private function makeHttpRequest(string $method, string $url, ?array $payload = null, array $headers = []): string
    {
        $ch = curl_init($url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);

        $headers[] = 'Content-Type: application/json';

        if ($payload !== null) {
            $jsonPayload = json_encode($payload, JSON_THROW_ON_ERROR);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonPayload);
            $headers[] = 'Content-Length: ' . strlen($jsonPayload);
        }

        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        
        $response = curl_exec($ch);
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);

        if ($response === false) {
            throw new \RuntimeException(sprintf('Error communicating with Mattermost: %s', $error));
        }

        if ($httpCode >= 400) {
            throw new \RuntimeException(sprintf('Mattermost API returned error code %d: %s', $httpCode, $response));
        }

        return $response;
    }
}
