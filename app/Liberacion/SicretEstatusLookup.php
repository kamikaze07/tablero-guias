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
     * Normaliza igual que trafico-system
     * (App\modules\guias\services\GuiaBloqueoService::normalizar(), mismo
     * repositorio): SICRET envuelve el valor en '<' '>' (p. ej. "<Asignada
     * Al Operador>") — se retiran antes de comparar como texto de negocio
     * exacto, no coincidencia parcial.
     */
    public function esAsignadaAlOperador(?string $estatus): bool
    {
        if ($estatus === null) {
            return false;
        }

        $valor = trim($estatus);
        $valor = trim($valor, '<>');
        $valor = mb_strtoupper(trim($valor), 'UTF-8');

        return $valor === 'ASIGNADA AL OPERADOR';
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
