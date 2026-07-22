<?php
namespace App\Notifications\Dispatcher;

use App\Domain\Events\DomainEvent;
use App\Notifications\Contracts\EventConsumer;

class NotificationDispatcher
{
    /** @var EventConsumer[] */
    private array $consumers = [];

    public function registerConsumer(EventConsumer $consumer): void
    {
        $this->consumers[] = $consumer;
    }

    public function dispatch(DomainEvent $event): void
    {
        foreach ($this->consumers as $consumer) {
            if ($consumer->supports($event)) {
                $consumer->handle($event);
            }
        }
    }
}
