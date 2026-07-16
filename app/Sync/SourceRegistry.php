<?php

declare(strict_types=1);

namespace App\Sync;

use App\Config\Config;
use App\Database\ConnectionFactory;

final class SourceRegistry
{
    /** @var Source[]|null */
    private ?array $sources = null;

    public function __construct(
        private readonly Config $config,
        private readonly ConnectionFactory $connectionFactory,
        private readonly string $sourcesConfigPath,
    ) {
    }

    /** @return Source[] */
    public function all(): array
    {
        if ($this->sources === null) {
            $this->sources = $this->load();
        }

        return $this->sources;
    }

    /** @return Source[] */
    private function load(): array
    {
        $definitions = require $this->sourcesConfigPath;

        $sources = [];

        foreach ($definitions as $definition) {
            $sources[] = new Source(
                $definition['name'],
                fn (): \PDO => $this->connectionFactory->make([
                    'host' => $this->config->get("{$definition['env_prefix']}_HOST"),
                    'port' => $this->config->get("{$definition['env_prefix']}_PORT"),
                    'database' => $this->config->get("{$definition['env_prefix']}_DATABASE"),
                    'username' => $this->config->get("{$definition['env_prefix']}_USERNAME"),
                    'password' => $this->config->get("{$definition['env_prefix']}_PASSWORD"),
                ]),
            );
        }

        return $sources;
    }
}
