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

    /**
     * Completa `facturas33.folioFiscal`/`idccp` de un folio ya timbrado a
     * partir de datos ya extraídos del XML del CFDI (ver
     * App\Monitoring\Timbrado\FiscalDataEvidenceSource) — a diferencia de
     * liberar(), esto no replica una decisión de negocio de Facturación,
     * es un backfill de datos que SICRET ya generó hacia su propia tabla
     * (cierra la ventana entre "ya se timbró" y "alguien copió el
     * UUID/IdCCP a mano"). `$idCcp` es opcional: no todo CFDI trae
     * Complemento Carta Porte.
     *
     * No sobrescribe una fila que ya tenga `folioFiscal` (evita pisar un
     * valor ya capturado por el proceso manual existente si corre en
     * paralelo). Devuelve true solo si de verdad actualizó una fila.
     */
    public function completarDatosFiscales(
        string $source,
        string $numGuia,
        string $folio,
        string $folioFiscal,
        ?string $idCcp,
    ): bool;
}
