<?php
namespace App\Notifications\Consumers\Mattermost;

use App\Domain\Events\DomainEvent;
use App\Domain\Events\GuideCreated;
use App\Domain\Events\GuideStamped;
use App\Domain\Events\GuideStampFailed;
use App\Domain\Events\LiberacionApproved;
use App\Domain\Events\TimbradoApproved;
use App\Domain\Events\TimbradoConcluded;
use App\Domain\Events\TimbradoRejected;
use App\Domain\Events\LiberacionRejected;
use App\Domain\Events\LiberacionRequested;
use App\Domain\Events\TimbradoRequested;
use App\Domain\Events\TestNotificationEvent;

class MattermostRouter
{
    private string $channelAnuncios;
    private string $channelTrafico;
    private string $channelFacturacion;
    private string $channelTimbresFiscales;

    public function __construct(
        string $channelAnuncios = 'anuncios',
        string $channelTrafico = 'trafico',
        string $channelFacturacion = 'facturacion',
        string $channelTimbresFiscales = 'timbres-fiscales'
    ) {
        $this->channelAnuncios = $channelAnuncios;
        $this->channelTrafico = $channelTrafico;
        $this->channelFacturacion = $channelFacturacion;
        $this->channelTimbresFiscales = $channelTimbresFiscales;
    }

    public function getChannelsForEvent(DomainEvent $event): array
    {
        return match (true) {
            $event instanceof TestNotificationEvent => [$this->channelAnuncios],
            $event instanceof GuideCreated => [$this->channelTrafico],
            $event instanceof TimbradoRequested => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof LiberacionRequested => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof TimbradoApproved => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof TimbradoConcluded => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof TimbradoRejected => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof LiberacionRejected => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof LiberacionApproved => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof GuideStamped => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            $event instanceof GuideStampFailed => [$this->channelTrafico, $this->channelFacturacion, $this->channelTimbresFiscales],
            default => [],
        };
    }
}
