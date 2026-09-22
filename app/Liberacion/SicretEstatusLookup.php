<?php

declare(strict_types=1);

namespace App\Liberacion;

use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use Throwable;

/**
 * Estatus ACTUAL de una guía, resuelto en vivo contra SICRET (sicrePR/
 * sicreGero) — a diferencia de `guias.estatus`/`guia_estado_tablero` en
 * ATLAS, que son snapshots congelados (ver docblock de
 * App\Sync\GuiaRepository::insert(), solo-INSERT, y
 * SolicitudLiberacionService::verificarDisponibilidad()).
 *
 * Se creó porque `guia_estado_tablero.estado` puede avanzar a TIMBRADO (vía
 * App\Monitoring\Timbrado\DirectStampingWatcher/TimbradoConfirmationWatcher)
 * sin que eso signifique que la guía dejó de estar, en SICRET, en estatus
 * "Asignada Al Operador" — SICRET no transiciona ese campo al facturar
 * (confirmado en vivo, guía PR-220212/sicreGero: `factimpresa` con folio de
 * factura real y timbrada, `estatus` sigue en "<Asignada Al Operador>"). La
 * regla de negocio real es "Asignada Al Operador en SICRET, ahora mismo" —
 * no el estado derivado que ATLAS infirió y quedó desactualizado.
 *
 * Mismo patrón de acceso y misma tolerancia a fallos que ContenedorLookup:
 * solo lectura, nunca lanza — si SICRET no responde, el llamador debe
 * tratarlo como "no se pudo confirmar" (mantiene el bloqueo original), no
 * como "confirmado disponible".
 */
final class SicretEstatusLookup
{
    public function __construct(
        private readonly SourceRegistry $sourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /**
     * @return string|null el valor crudo de guias.estatus (con o sin '<' '>'),
     *                      o null si la fuente no existe, la guía no existe
     *                      en SICRET, o SICRET no respondió.
     */
    public function estatusActual(string $source, string $numGuia): ?string
    {
        $fuente = $this->buscarFuente($source);

        if ($fuente === null) {
            return null;
        }

        try {
            $stmt = $fuente->connection()->prepare(
                'SELECT estatus FROM guias WHERE num_guia = ? LIMIT 1'
            );
            $stmt->execute([$numGuia]);

            $estatus = $stmt->fetchColumn();

            return $estatus === false ? null : (string) $estatus;
        } catch (Throwable $e) {
            $this->logger->error('No se pudo resolver estatus en vivo contra SICRET', [
                'source' => $source,
                'num_guia' => $numGuia,
                'error' => $e->getMessage(),
            ]);

            return null;
        }
    }

    /**
     * Regla de negocio confirmada: una guía es elegible para Liberación
     * mientras su estatus REAL en SICRET no sea "Por Timbrar" (aún no tiene
     * CFDI, no aplica liberación todavía), ni "Cancelada" (folio anulado),
     * ni esté vacío/desconocido. Cualquier otro estatus —incluye "Asignada
     * Al Operador" y "Pagada Al Operador"— es elegible: la guía conserva su
     * elegibilidad para volver a solicitarse aunque ya haya sido liberada y
     * timbrada antes; el estatus posterior al nuevo timbrado dependerá de
     * cuál era el estatus de origen (Por Timbrar → Asignada; Pagada →
     * vuelve a Pagada), pero esa transición la gobierna SICRET, no esta
     * validación.
     *
     * Normaliza igual que trafico-system
     * (App\modules\guias\services\GuiaBloqueoService::normalizar(), mismo
     * repositorio): SICRET envuelve el valor en '<' '>' (p. ej. "<Asignada
     * Al Operador>") — se retiran antes de comparar como texto de negocio
     * exacto/prefijo, no coincidencia parcial arbitraria.
     */
    public function esDisponibleParaLiberacion(?string $estatus): bool
    {
        if ($estatus === null) {
            return false;
        }

        $valor = trim($estatus);
        $valor = trim($valor, '<>');
        $valor = mb_strtoupper(trim($valor), 'UTF-8');

        if ($valor === '') {
            return false;
        }

        if ($valor === 'POR TIMBRAR') {
            return false;
        }

        // "Cancelada: USUARIO DD/MM/AAAA" — coincidencia por prefijo, el
        // resto es metadata de auditoría, no forma parte del estatus.
        if (str_starts_with($valor, 'CANCELADA')) {
            return false;
        }

        return true;
    }

    private function buscarFuente(string $name): ?Source
    {
        foreach ($this->sourceRegistry->all() as $source) {
            if ($source->name() === $name) {
                return $source;
            }
        }

        return null;
    }
}
