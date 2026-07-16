<?php

declare(strict_types=1);

// Fuentes de datos que el GuideWatcher debe consultar.
// Agregar una fuente nueva es agregar una entrada aquí; no requiere
// modificar ninguna clase del Synchronization Engine.
//
// `env_prefix` debe corresponder a variables <PREFIX>_HOST, <PREFIX>_PORT,
// <PREFIX>_DATABASE, <PREFIX>_USERNAME y <PREFIX>_PASSWORD definidas en .env.

return [
    [
        'name' => 'sicrePR',
        'env_prefix' => 'FORSIS_DB',
    ],
    [
        'name' => 'sicreGero',
        'env_prefix' => 'GERO_DB',
    ],
];
