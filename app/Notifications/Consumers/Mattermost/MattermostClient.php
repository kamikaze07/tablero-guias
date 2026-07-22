<?php
namespace App\Notifications\Consumers\Mattermost;

interface MattermostClient
{
    public function sendMessage(string $channel, string $message): void;
}
