<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;

/**
 * Puente temporal de solo lectura con el timbrado MANUAL de SICRET —
 * puede eliminarse el día que Forsis timbre directamente, sin afectar el
 * resto del Runtime (App\Monitoring\Timbrado\TimbradoConfirmationWatcher
 * solo conoce esta interfaz, nunca esta clase concreta).
 *
 * Dos condiciones, ambas deliberadamente ingenuas por diseño (ver
 * instrucciones del sprint: NO leer XML, NO parsear, NO indexar archivos):
 *
 * 1. `guias.factImpresa` (SICRET, solo lectura) no está vacío.
 * 2. Existe el archivo "{factImpresa}.xml" dentro de la carpeta OUT.
 *
 * La sola existencia del XML es evidencia suficiente — su contenido nunca
 * se lee. Una solicitud puede tener varias guías; se confirma como lote
 * completo (todo o nada, mismo principio que el resto de ATLAS) para no
 * necesitar una tabla/columna de estado por guía en
 * `solicitud_timbrado_detalle`.
 */
final class StampingEvidenceSource implements EvidenceSource
{
    // Mismos códigos que App\Monitoring\Liberacion\SicretStateEvidenceSource
    // — misma causa: conexión de lectura ociosa entre ciclos.
    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

    private bool $avisoConfiguracionRegistrado = false;

    public function __construct(
        private readonly SourceRegistry $readSourceRegistry,
        private readonly SyncLogger $logger,
        private readonly string $outPath,
    ) {
    }

    /** @param array{solicitud_id: int, guias: array<int, array{guia_id: int, num_guia: string, source: ?string}>} $item */
    public function buscar(mixed $item): Evidence
    {
        if ($this->outPath === '') {
            if (!$this->avisoConfiguracionRegistrado) {
                $this->logger->error(
                    'StampingEvidenceSource sin configurar: falta SICRET_TIMBRADO_OUT_PATH. '
                    . 'Ninguna solicitud ESPERANDO_TIMBRADO podrá confirmarse todavía.',
                );

                $this->avisoConfiguracionRegistrado = true;
            }

            return Evidence::pendiente();
        }

        $confirmadas = [];

        foreach ($item['guias'] as $guia) {
            if ($guia['source'] === null) {
                $this->logger->error('No se pudo resolver "source" para guia_id, se reintentará', [
                    'guia_id' => $guia['guia_id'],
                ]);

                return Evidence::pendiente();
            }

            $source = $this->buscarFuente($guia['source']);

            if ($source === null) {
                $this->logger->error('Fuente SICRET desconocida, se reintentará', ['source' => $guia['source']]);

                return Evidence::pendiente();
            }

            try {
                $facturaImpresa = $this->consultarFacturaImpresa($source, $guia['num_guia']);
            } catch (\PDOException $e) {
                if (!$this->isConnectionLost($e)) {
                    throw $e;
                }

                $this->logger->error('Conexión de lectura perdida con SICRET, reconectando', [
                    'source' => $guia['source'],
                    'error' => $e->getMessage(),
                ]);

                $source->reconnect();

                $facturaImpresa = $this->consultarFacturaImpresa($source, $guia['num_guia']);
            }

            // Condición 1: factImpresa vacío o guía no encontrada — no es un
            // error, la guía todavía no ha sido timbrada en SICRET.
            if ($facturaImpresa === false || $facturaImpresa === '') {
                return Evidence::pendiente();
            }

            // Condición 2: el XML todavía no existe. Posible condición de
            // carrera (SICRET escribe factImpresa antes que el XML) — nunca
            // se trata como fallo, solo se reintenta en el siguiente ciclo.
            $rutaXml = $this->rutaXml($facturaImpresa);
            clearstatcache(true, $rutaXml);
            if (!is_file($rutaXml)) {
                return Evidence::pendiente();
            }

            $usuario = $this->consultarUsuarioFactura($source, $facturaImpresa, $guia['num_guia']);

            $confirmadas[] = [
                'guia_id' => $guia['guia_id'],
                'num_guia' => $guia['num_guia'],
                'factura_impresa' => $facturaImpresa,
                'usuario' => $usuario,
            ];
        }

        return Evidence::confirmada(['guias' => $confirmadas]);
    }

    private function consultarUsuarioFactura(\App\Sync\Source $source, string $facturaImpresa, string $numGuia): ?string
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

    private function rutaXml(string $facturaImpresa): string
    {
        return rtrim($this->outPath, '/') . '/' . $facturaImpresa . '.xml';
    }

    private function consultarFacturaImpresa(\App\Sync\Source $source, string $numGuia): string|false
    {
        $stmt = $source->connection()->prepare('SELECT factImpresa FROM guias WHERE num_guia = :num_guia LIMIT 1');
        $stmt->execute(['num_guia' => $numGuia]);

        return $stmt->fetchColumn();
    }

    private function isConnectionLost(\PDOException $e): bool
    {
        return in_array((int) ($e->errorInfo[1] ?? 0), self::CONNECTION_LOST_ERROR_CODES, true);
    }

    private function buscarFuente(string $nombre): ?\App\Sync\Source
    {
        foreach ($this->readSourceRegistry->all() as $source) {
            if ($source->name() === $nombre) {
                return $source;
            }
        }

        return null;
    }
}
