<?php

declare(strict_types=1);

namespace App\Infrastructure\Sicret;

/**
 * Se lanza cuando se solicita una operación de SicretGateway cuya
 * semántica real (qué columna(s) de SICRET cambian y a qué valor) no
 * está confirmada todavía — ver el docblock de PdoSicretGateway. Existe
 * para que un llamador nunca reciba en silencio un "éxito" fabricado.
 */
final class SicretWriteNotConfiguredException extends \RuntimeException
{
    public static function paraOperacion(string $operacion): self
    {
        return new self(sprintf(
            'La operación "%s" hacia SICRET no puede ejecutarse: su semántica real '
            . '(qué columna(s) escribir y con qué valor) no está confirmada todavía. '
            . 'Ver App\Infrastructure\Sicret\PdoSicretGateway.',
            $operacion,
        ));
    }
}
