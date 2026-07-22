<?php

declare(strict_types=1);

// Fuentes de ESCRITURA hacia SICRET, exclusivas de
// App\Infrastructure\Sicret\PdoSicretGateway. Nunca deben confundirse ni
// compartirse con config/sources.php (solo lectura, usado por App\Sync) —
// mismo nombre de fuente, credenciales distintas, propósito distinto.
//
// Requiere credenciales con permiso de escritura sobre sicrePR/sicreGero,
// todavía no aprovisionadas (ver PdoSicretGateway sobre por qué la
// escritura real sigue sin implementarse).
//
// `env_prefix` debe corresponder a variables <PREFIX>_HOST, <PREFIX>_PORT,
// <PREFIX>_DATABASE, <PREFIX>_USERNAME y <PREFIX>_PASSWORD definidas en .env.

return [
    [
        'name' => 'sicrePR',
        'env_prefix' => 'FORSIS_DB_WRITE',
    ],
    [
        'name' => 'sicreGero',
        'env_prefix' => 'GERO_DB_WRITE',
    ],
];
