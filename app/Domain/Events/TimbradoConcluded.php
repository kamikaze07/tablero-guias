<?php

declare(strict_types=1);

namespace App\Domain\Events;

class TimbradoConcluded extends BaseDomainEvent
{
    public function __construct(public readonly string $guiaId, public readonly array $data = []) { parent::__construct(); }
    public function getPayload(): array { return ['guiaId' => $this->guiaId, 'data' => $this->data]; }
}
