<?php

declare(strict_types=1);

namespace App\Config;

final class Config
{
    public function get(string $key, ?string $default = null): ?string
    {
        $value = getenv($key);

        if ($value === false) {
            return $default;
        }

        return $value;
    }
}
