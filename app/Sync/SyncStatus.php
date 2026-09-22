<?php

declare(strict_types=1);

namespace App\Sync;

enum SyncStatus: string
{
    case INSERTED = 'inserted';
    case REUSED_REPLACED = 'reused_replaced';
    case UPDATED = 'updated';
    case UNCHANGED = 'unchanged';
}
