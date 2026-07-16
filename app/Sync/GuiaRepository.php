<?php

declare(strict_types=1);

namespace App\Sync;

use PDO;
use PDOException;

final class GuiaRepository
{
    private const DUPLICATE_ENTRY_ERROR_CODE = 1062;

    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * Inserta la guía en ATLAS. Devuelve false sin lanzar error si el
     * registro ya existía (misma fuente + mismo num de origen), como
     * salvaguarda de duplicados independiente del checkpoint.
     */
    public function insert(GuiaRecord $record): bool
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO guias (
                source, source_num, num_guia, folio_imp, fecha, fecha_c, fecha_d,
                num_llama, estado, nombre, tipo, num_vale, diesel, servicio,
                rem1, placas1, rem2, placas2, estatus, pedido, comen_pre,
                factura, manifiesto, ticket1, tons1, ticket2, tons2, operador,
                prefactura, factimpresa, linea, km, claveproducto_sat, claveunidad_sat,
                do_field, lid_field, actualizacion
            ) VALUES (
                :source, :source_num, :num_guia, :folio_imp, :fecha, :fecha_c, :fecha_d,
                :num_llama, :estado, :nombre, :tipo, :num_vale, :diesel, :servicio,
                :rem1, :placas1, :rem2, :placas2, :estatus, :pedido, :comen_pre,
                :factura, :manifiesto, :ticket1, :tons1, :ticket2, :tons2, :operador,
                :prefactura, :factimpresa, :linea, :km, :claveproducto_sat, :claveunidad_sat,
                :do_field, :lid_field, :actualizacion
            )'
        );

        try {
            $stmt->execute([
                'source' => $record->source,
                'source_num' => $record->sourceNum,
                'num_guia' => $record->numGuia,
                'folio_imp' => $record->folioImp,
                'fecha' => $record->fecha->format('Y-m-d H:i:s'),
                'fecha_c' => $record->fechaC->format('Y-m-d H:i:s'),
                'fecha_d' => $record->fechaD->format('Y-m-d H:i:s'),
                'num_llama' => $record->numLlama,
                'estado' => $record->estado,
                'nombre' => $record->nombre,
                'tipo' => $record->tipo,
                'num_vale' => $record->numVale,
                'diesel' => $record->diesel,
                'servicio' => $record->servicio,
                'rem1' => $record->rem1,
                'placas1' => $record->placas1,
                'rem2' => $record->rem2,
                'placas2' => $record->placas2,
                'estatus' => $record->estatus,
                'pedido' => $record->pedido,
                'comen_pre' => $record->comenPre,
                'factura' => $record->factura,
                'manifiesto' => $record->manifiesto,
                'ticket1' => $record->ticket1,
                'tons1' => $record->tons1,
                'ticket2' => $record->ticket2,
                'tons2' => $record->tons2,
                'operador' => $record->operador,
                'prefactura' => $record->prefactura,
                'factimpresa' => $record->factimpresa,
                'linea' => $record->linea,
                'km' => $record->km,
                'claveproducto_sat' => $record->claveProductoSat,
                'claveunidad_sat' => $record->claveUnidadSat,
                'do_field' => $record->doField,
                'lid_field' => $record->lidField,
                'actualizacion' => $record->actualizacion,
            ]);
        } catch (PDOException $e) {
            if ((int) $e->errorInfo[1] === self::DUPLICATE_ENTRY_ERROR_CODE) {
                return false;
            }

            throw $e;
        }

        return true;
    }
}
