<?php

declare(strict_types=1);

namespace App\Infrastructure\Sicret;

/**
 * Único punto de escritura hacia SICRET de todo ATLAS. Ningún módulo de
 * negocio (App\Liberacion, y en el futuro Timbrado/Cancelaciones/etc.)
 * abre una conexión de escritura hacia sicrePR/sicreGero por su cuenta —
 * todos solicitan una operación aquí, sin conocer conexión, transacción
 * ni auditoría.
 *
 * Un método nuevo por cada operación real que exista en SICRET, agregado
 * únicamente cuando un módulo de negocio lo necesite — no se anticipan
 * métodos sin un llamador real (ver PdoSicretGateway sobre por qué
 * liberar() todavía no tiene cuerpo).
 */
interface SicretGateway
{
    public function liberar(string $source, string $numGuia): void;
}
