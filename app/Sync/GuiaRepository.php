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
     * Busca la guía en ATLAS por fuente y número de origen.
     *
     * @return array<string, mixed>|null
     */
    public function findBySourceAndNum(string $source, int $sourceNum): ?array
    {
        $stmt = $this->connection->prepare(
            'SELECT id, source, source_num, num_guia, folio_imp, fecha, fecha_c, fecha_d,
                    num_llama, estado, nombre, tipo, num_vale, diesel, servicio,
                    rem1, placas1, rem2, placas2, estatus, pedido, comen_pre,
                    factura, manifiesto, ticket1, tons1, ticket2, tons2, operador,
                    prefactura, factimpresa, linea, km, claveproducto_sat, claveunidad_sat,
                    do_field, lid_field, actualizacion
             FROM guias WHERE source = :source AND source_num = :source_num LIMIT 1'
        );
        $stmt->execute([
            'source' => $source,
            'source_num' => $sourceNum,
        ]);

        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        return $row === false ? null : $row;
    }

    /**
     * Sincroniza el registro de origen en ATLAS de forma explícita.
     * Devuelve SyncResult clasificando el resultado en:
     * - INSERTED: nueva guía no existente previamente.
     * - REUSED_REPLACED: nuevo folio reutilizado (fecha_c posterior o num_guia distinto).
     * - UPDATED: misma guía pero con campos de negocio modificados en SICRET.
     * - UNCHANGED: datos idénticos en fuente y espejo.
     */
    public function saveOrUpdate(GuiaRecord $record): SyncResult
    {
        $existing = $this->findBySourceAndNum($record->source, $record->sourceNum);

        if ($existing === null) {
            $insertedId = $this->insert($record);

            if ($insertedId === null) {
                // En caso de condición de carrera, re-evaluar
                $existing = $this->findBySourceAndNum($record->source, $record->sourceNum);
                if ($existing === null) {
                    return new SyncResult(SyncStatus::UNCHANGED, null);
                }
            } else {
                return new SyncResult(SyncStatus::INSERTED, $insertedId);
            }
        }

        $existingId = (int) $existing['id'];

        // 1. Verificar si es una nueva encarnación de la guía (folio reutilizado)
        if ($this->isNewIncarnation($record, $existing)) {
            $this->update($record);

            return new SyncResult(SyncStatus::REUSED_REPLACED, $existingId);
        }

        // 2. Verificar si cambiaron campos de negocio en la misma guía
        if ($this->hasBusinessFieldChanges($record, $existing)) {
            $this->update($record);

            return new SyncResult(SyncStatus::UPDATED, $existingId);
        }

        return new SyncResult(SyncStatus::UNCHANGED, $existingId);
    }

    /**
     * Evalúa si el registro de origen representa una encarnación nueva (reutilización de folio).
     */
    private function isNewIncarnation(GuiaRecord $record, array $existing): bool
    {
        // Si el string num_guia cambió (ej. PR-101-TEST vs PR-227356), es un folio reutilizado
        if (trim($record->numGuia) !== trim((string) ($existing['num_guia'] ?? ''))) {
            return true;
        }

        $incomingTs = $record->fechaC->getTimestamp();
        $existingTs = $this->parseTimestamp((string) ($existing['fecha_c'] ?? ''));

        // Si la fecha_c existente en espejo es válida y la entrante es estrictamente posterior
        if ($existingTs !== null && $incomingTs > $existingTs) {
            return true;
        }

        return false;
    }

    /**
     * Parsea un timestamp de MySQL manejando valores cero legados (0000-00-00 00:00:00) de forma segura.
     */
    private function parseTimestamp(?string $val): ?int
    {
        if ($val === null || $val === '' || str_starts_with($val, '0000-00-00')) {
            return null;
        }

        $ts = strtotime($val);

        return $ts === false ? null : $ts;
    }

    /**
     * Compara exhaustivamente los campos de negocio replicados entre la fuente y el espejo en ATLAS.
     */
    private function hasBusinessFieldChanges(GuiaRecord $record, array $existing): bool
    {
        if (trim($record->folioImp) !== trim((string) ($existing['folio_imp'] ?? ''))) return true;
        if ($record->fecha->format('Y-m-d H:i:s') !== (string) ($existing['fecha'] ?? '')) return true;
        if ($record->fechaD->format('Y-m-d H:i:s') !== (string) ($existing['fecha_d'] ?? '')) return true;
        if ($record->numLlama !== (int) ($existing['num_llama'] ?? 0)) return true;
        if (trim($record->estado) !== trim((string) ($existing['estado'] ?? ''))) return true;
        if (trim($record->nombre) !== trim((string) ($existing['nombre'] ?? ''))) return true;
        if (trim($record->tipo) !== trim((string) ($existing['tipo'] ?? ''))) return true;
        if (trim($record->numVale) !== trim((string) ($existing['num_vale'] ?? ''))) return true;
        if (trim($record->diesel) !== trim((string) ($existing['diesel'] ?? ''))) return true;
        if (trim($record->servicio) !== trim((string) ($existing['servicio'] ?? ''))) return true;
        if (trim($record->rem1) !== trim((string) ($existing['rem1'] ?? ''))) return true;
        if (trim($record->placas1) !== trim((string) ($existing['placas1'] ?? ''))) return true;
        if (trim($record->rem2) !== trim((string) ($existing['rem2'] ?? ''))) return true;
        if (trim($record->placas2) !== trim((string) ($existing['placas2'] ?? ''))) return true;
        if (trim($record->estatus) !== trim((string) ($existing['estatus'] ?? ''))) return true;
        if (trim($record->pedido) !== trim((string) ($existing['pedido'] ?? ''))) return true;
        if (trim($record->comenPre) !== trim((string) ($existing['comen_pre'] ?? ''))) return true;
        if ($record->factura !== (int) ($existing['factura'] ?? 0)) return true;
        if (trim($record->manifiesto) !== trim((string) ($existing['manifiesto'] ?? ''))) return true;
        if (trim($record->ticket1) !== trim((string) ($existing['ticket1'] ?? ''))) return true;
        if (abs($record->tons1 - (float) ($existing['tons1'] ?? 0.0)) > 0.001) return true;
        if (trim($record->ticket2) !== trim((string) ($existing['ticket2'] ?? ''))) return true;
        if (abs($record->tons2 - (float) ($existing['tons2'] ?? 0.0)) > 0.001) return true;
        if (trim($record->operador) !== trim((string) ($existing['operador'] ?? ''))) return true;
        if ($record->prefactura !== (int) ($existing['prefactura'] ?? 0)) return true;
        if (trim($record->factimpresa) !== trim((string) ($existing['factimpresa'] ?? ''))) return true;
        if (trim($record->linea) !== trim((string) ($existing['linea'] ?? ''))) return true;
        if (abs($record->km - (float) ($existing['km'] ?? 0.0)) > 0.001) return true;
        if (trim($record->claveProductoSat) !== trim((string) ($existing['claveproducto_sat'] ?? ''))) return true;
        if (trim($record->claveUnidadSat) !== trim((string) ($existing['claveunidad_sat'] ?? ''))) return true;
        if (trim((string) $record->doField) !== trim((string) ($existing['do_field'] ?? ''))) return true;
        if (trim((string) $record->lidField) !== trim((string) ($existing['lid_field'] ?? ''))) return true;
        if (trim((string) $record->actualizacion) !== trim((string) ($existing['actualizacion'] ?? ''))) return true;

        return false;
    }

    /**
     * Inserta la guía en ATLAS y devuelve su id, o null en caso de duplicidad.
     */
    public function insert(GuiaRecord $record): ?int
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
                return null;
            }

            throw $e;
        }

        return (int) $this->connection->lastInsertId();
    }

    /**
     * Actualiza un registro existente en `atlas.guias` manteniendo su id de ATLAS.
     */
    public function update(GuiaRecord $record): bool
    {
        $stmt = $this->connection->prepare(
            'UPDATE guias SET
                num_guia = :num_guia,
                folio_imp = :folio_imp,
                fecha = :fecha,
                fecha_c = :fecha_c,
                fecha_d = :fecha_d,
                num_llama = :num_llama,
                estado = :estado,
                nombre = :nombre,
                tipo = :tipo,
                num_vale = :num_vale,
                diesel = :diesel,
                servicio = :servicio,
                rem1 = :rem1,
                placas1 = :placas1,
                rem2 = :rem2,
                placas2 = :placas2,
                estatus = :estatus,
                pedido = :pedido,
                comen_pre = :comen_pre,
                factura = :factura,
                manifiesto = :manifiesto,
                ticket1 = :ticket1,
                tons1 = :tons1,
                ticket2 = :ticket2,
                tons2 = :tons2,
                operador = :operador,
                prefactura = :prefactura,
                factimpresa = :factimpresa,
                linea = :linea,
                km = :km,
                claveproducto_sat = :claveproducto_sat,
                claveunidad_sat = :claveunidad_sat,
                do_field = :do_field,
                lid_field = :lid_field,
                actualizacion = :actualizacion,
                detected_at = CURRENT_TIMESTAMP
            WHERE source = :source AND source_num = :source_num'
        );

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

        return $stmt->rowCount() > 0;
    }
}
