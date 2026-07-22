<?php
namespace App\Notifications\Consumers\Mattermost\Templates;

use App\Domain\Events\DomainEvent;

interface MattermostTemplate
{
    public function render(DomainEvent $event): string;
    public function supports(DomainEvent $event): bool;
}
