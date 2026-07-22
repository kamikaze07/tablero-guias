<?php
namespace App\Notifications\Consumers\Mattermost;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideCreated;
use App\Domain\Events\GuideStamped;
use App\Domain\Events\GuideStampFailed;
use App\Domain\Events\LiberacionApproved;
use App\Domain\Events\LiberacionRejected;
use App\Domain\Events\LiberacionRequested;
use App\Domain\Events\TimbradoRequested;

class MattermostRouter
{
    public const CHANNEL_TRAFICO = 'trafico';
    public const CHANNEL_FACTURACION = 'facturacion';

    public function getChannelsForEvent(DomainEvent $event): array
    {
        return match (true) {
            $event instanceof GuideCreated => [self::CHANNEL_TRAFICO],
            $event instanceof TimbradoRequested => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            $event instanceof LiberacionRequested => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            $event instanceof LiberacionApproved => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            $event instanceof LiberacionRejected => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            $event instanceof GuideStamped => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            $event instanceof GuideStampFailed => [self::CHANNEL_TRAFICO, self::CHANNEL_FACTURACION],
            default => [],
        };
    }
}
