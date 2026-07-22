<?php
namespace App\Domain\Events;

class GuideStamped extends BaseDomainEvent
{
    public function __construct(public readonly string $guiaId, public readonly array $data = []) { parent::__construct(); }
    public function getPayload(): array { return ['guiaId' => $this->guiaId, 'data' => $this->data]; }
}
