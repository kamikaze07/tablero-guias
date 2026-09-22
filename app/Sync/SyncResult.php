<?php

declare(strict_types=1);

namespace App\Sync;

final class SyncResult
{
    public function __construct(
        public readonly SyncStatus $status,
        public readonly ?int $atlasId,
    ) {
    }

    public function isInserted(): bool
    {
        return $this->status === SyncStatus::INSERTED;
    }

    public function isReusedReplaced(): bool
    {
        return $this->status === SyncStatus::REUSED_REPLACED;
    }

    public function isUpdated(): bool
    {
        return $this->status === SyncStatus::UPDATED;
    }

    public function isUnchanged(): bool
    {
        return $this->status === SyncStatus::UNCHANGED;
    }

    public function isNewIncarnation(): bool
    {
        return $this->isInserted() || $this->isReusedReplaced();
    }
}
