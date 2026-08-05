<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDO;
use PDOException;

/**
 * Evidencia de que una guía se timbró SIN pasar por Solicitar Timbrado —
 * Facturación a veces timbra directo en SICRET porque ya sabe que debe
 * hacerlo, sin esperar a que Tráfico levante la solicitud en el tablero.
 * Tres condiciones, las tres sobre la propia SICRET (solo lectura, misma
 * SourceRegistry que ya usa App\Sync):
 *   1. `guias.estatus` ya es "Asignada Al Operador".
 *   2. `guias.factimpresa` tiene folio (CFDI generado) — `guias.factura`
 *      NO sirve para esto pese al nombre: se confirmó contra datos reales
 *      (PR-226174 a PR-226185, todas con `factura=0` y `factimpresa`
 *      poblado) que se queda en 0 aunque la guía ya esté timbrada; mismo
 *      campo que ya usa StampingEvidenceSource para esta misma señal.
 *   3. El XML de esa factura ya existe en la carpeta OUT (mismo criterio
 *      que StampingEvidenceSource, aquí acotado por guía individual en vez
 *      de por lote de una solicitud).
 *
 * Ver App\Monitoring\Timbrado\DirectStampingWatcher::pendientes() para qué
 * guías llegan a evaluarse aquí.
 */
final class DirectStampingEvidenceSource implements EvidenceSource
{
    // Mismos códigos que StampingEvidenceSource/SicretStateEvidenceSource —
    // misma causa: conexión de lectura ociosa entre ciclos.
    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

    private const ESTATUS_CONFIRMACION = 'ASIGNADA AL OPERADOR';

    private bool $avisoConfiguracionRegistrado = false;

    public function __construct(
        private readonly SourceRegistry $readSourceRegistry,
        private readonly SyncLogger $logger,
        private readonly string $outPath,
    ) {
    }

    /** @param array{guia_id: int, num_guia: string, source: string} $item */
    public function buscar(mixed $item): Evidence
    {
        if ($this->outPath === '') {
            if (!$this->avisoConfiguracionRegistrado) {
                $this->logger->error(
                    'DirectStampingEvidenceSource sin configurar: falta SICRET_TIMBRADO_OUT_PATH. '
                    . 'Ninguna guía podrá confirmarse como timbrada sin solicitud todavía.',
                );

                $this->avisoConfiguracionRegistrado = true;
            }

            return Evidence::pendiente();
        }

        $source = $this->buscarFuente($item['source']);

        if ($source === null) {
            return Evidence::fallida("Fuente SICRET desconocida: {$item['source']}.");
        }

        try {
            $fila = $this->consultarGuia($source, $item['num_guia']);
        } catch (PDOException $e) {
            if (!$this->isConnectionLost($e)) {
                throw $e;
            }

            $this->logger->error('Conexión de lectura perdida con SICRET, reconectando', [
                'source' => $item['source'],
                'error' => $e->getMessage(),
            ]);

            $source->reconnect();

            $fila = $this->consultarGuia($source, $item['num_guia']);
        }

        if ($fila === null) {
            return Evidence::fallida("La guía {$item['num_guia']} ya no existe en {$item['source']}.");
        }

        $estatus = strtoupper(trim((string) $fila['estatus'], " \t\n\r\0\x0B<>"));
        $facturaImpresa = trim((string) $fila['factimpresa']);

        if ($estatus !== self::ESTATUS_CONFIRMACION || $facturaImpresa === '') {
            return Evidence::pendiente();
        }

        $rutaXml = rtrim($this->outPath, '/') . '/' . $facturaImpresa . '.xml';
        clearstatcache(true, $rutaXml);

        if (!is_file($rutaXml)) {
            return Evidence::pendiente();
        }

        $usuario = $this->consultarUsuarioFactura($source, $facturaImpresa, $item['num_guia']);

        return Evidence::confirmada([
            'estatus' => $fila['estatus'],
            'factura_impresa' => $facturaImpresa,
            'usuario' => $usuario,
        ]);
    }

    private function consultarUsuarioFactura(Source $source, string $facturaImpresa, string $numGuia): ?string
    {
        $stmt = $source->connection()->prepare(
            'SELECT usuario FROM facturas33 WHERE folio = :folio LIMIT 1'
        );
        $stmt->execute(['folio' => $facturaImpresa]);
        $usuario = $stmt->fetchColumn();

        if ($usuario === false) {
            return null;
        }

        $usuario = trim((string) $usuario);

        return $usuario === '' ? null : $usuario;
    }

    /** @return array{estatus: string, factimpresa: string}|null */
    private function consultarGuia(Source $source, string $numGuia): ?array
    {
        $stmt = $source->connection()->prepare(
            'SELECT estatus, factimpresa FROM guias WHERE num_guia = :num_guia LIMIT 1'
        );
        $stmt->execute(['num_guia' => $numGuia]);

        $fila = $stmt->fetch(PDO::FETCH_ASSOC);

        return $fila === false ? null : $fila;
    }

    private function isConnectionLost(PDOException $e): bool
    {
        return in_array((int) ($e->errorInfo[1] ?? 0), self::CONNECTION_LOST_ERROR_CODES, true);
    }

    private function buscarFuente(string $nombre): ?Source
    {
        foreach ($this->readSourceRegistry->all() as $source) {
            if ($source->name() === $nombre) {
                return $source;
            }
        }

        return null;
    }
}
