<?php
namespace App\Notifications\Consumers\Mattermost;

use App\Domain\Events\DomainEvent;
use App\Notifications\Contracts\EventConsumer;
use App\Notifications\Consumers\Mattermost\Templates\MattermostTemplate;

class MattermostConsumer implements EventConsumer
{
    /** @var MattermostTemplate[] */
    private array $templates = [];

    public function __construct(
        private MattermostRouter $router,
        private MattermostClient $client
    ) {}

    public function registerTemplate(MattermostTemplate $template): void
    {
        $this->templates[] = $template;
    }

    public function supports(DomainEvent $event): bool
    {
        // Se soportan eventos que tengan rutas definidas para canales
        $channels = $this->router->getChannelsForEvent($event);
        if (empty($channels)) {
            return false;
        }

        // Además, debe existir un template que soporte este evento
        foreach ($this->templates as $template) {
            if ($template->supports($event)) {
                return true;
            }
        }

        return false;
    }

    public function handle(DomainEvent $event): void
    {
        $channels = $this->router->getChannelsForEvent($event);
        if (empty($channels)) {
            return;
        }

        $message = $this->renderMessage($event);
        if ($message === null) {
            return; // No hay template soportado
        }

        foreach ($channels as $channel) {
            $this->client->sendMessage($channel, $message);
        }
    }

    private function renderMessage(DomainEvent $event): ?string
    {
        foreach ($this->templates as $template) {
            if ($template->supports($event)) {
                return $template->render($event);
            }
        }

        return null;
    }
}
