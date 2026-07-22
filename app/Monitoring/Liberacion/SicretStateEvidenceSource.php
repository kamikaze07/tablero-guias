<?php

declare(strict_types=1);

namespace App\Monitoring\Liberacion;

use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;

/**
 * Busca, en la propia SICRET (solo lectura — misma SourceRegistry que ya
 * usa App\Sync, nunca la de escritura de PdoSicretGateway), evidencia de
 * que una guía realmente cambió de estatus tras haberse ejecutado su
 * liberación.
 *
 * A diferencia de App\Sync\GuideWatcher (que solo detecta filas NUEVAS
 * por checkpoint), esta clase hace lectura DIRIGIDA: una consulta puntual
 * por num_guia sobre el conjunto acotado de guías con una solicitud
 * EJECUTANDO pendiente de confirmar — nunca un escaneo masivo.
 *
 * IMPORTANTE — mismo hallazgo documentado en
 * App\Infrastructure\Sicret\PdoSicretGateway: no existe, en ningún
 * repositorio accesible, una definición confirmada de qué valor de
 * `estatus` representa "guía liberada". Por eso ese valor se recibe por
 * configuración ($estatusConfirmacion, variable de entorno
 * SICRET_LIBERACION_ESTATUS_CONFIRMACION) en vez de hardcodearse — si no
 * está configurado, esta clase nunca confirma nada (siempre devuelve
 * evidencia pendiente), para no arriesgar una falsa confirmación basada
 * en una suposición no verificada.
 */
final class SicretStateEvidenceSource implements EvidenceSource
{
    // Ver App\Infrastructure\Sicret\PdoSicretGateway::CONNECTION_LOST_ERROR_CODES
    // — misma causa: esta conexión de lectura vive tanto como el proceso de
    // bin/monitoring-engine.php y puede quedar ociosa hasta que exista una
    // solicitud EJECUTANDO que confirmar.
    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

    private bool $avisoConfiguracionRegistrado = false;

    public function __construct(
        private readonly SourceRegistry $readSourceRegistry,
        private readonly SyncLogger $logger,
        private readonly ?string $estatusConfirmacion,
    ) {
    }

    /** @param array{solicitud_id: int, guia_id: int, num_guia: string, source: ?string} $item */
    public function buscar(mixed $item): Evidence
    {
        if ($this->estatusConfirmacion === null) {
            if (!$this->avisoConfiguracionRegistrado) {
                $this->logger->error(
                    'SicretStateEvidenceSource sin configurar: falta SICRET_LIBERACION_ESTATUS_CONFIRMACION. '
                    . 'Ninguna solicitud EJECUTANDO podrá confirmarse todavía.',
                );

                $this->avisoConfiguracionRegistrado = true;
            }

            return Evidence::pendiente();
        }

        if ($item['source'] === null) {
            return Evidence::fallida("No se pudo resolver \"source\" para guia_id {$item['guia_id']}.");
        }

        $source = $this->buscarFuente($item['source']);

        if ($source === null) {
            return Evidence::fallida("Fuente SICRET desconocida: {$item['source']}.");
        }

        try {
            $estatus = $this->consultarEstatus($source, $item['num_guia']);
        } catch (\PDOException $e) {
            if (!$this->isConnectionLost($e)) {
                throw $e;
            }

            $this->logger->error('Conexión de lectura perdida con SICRET, reconectando', [
                'source' => $item['source'],
                'error' => $e->getMessage(),
            ]);

            $source->reconnect();

            $estatus = $this->consultarEstatus($source, $item['num_guia']);
        }

        if ($estatus === false) {
            return Evidence::fallida("La guía {$item['num_guia']} ya no existe en {$item['source']}.");
        }

        $normalizado = strtoupper(trim((string) $estatus, " \t\n\r\0\x0B<>"));
        $esperado = strtoupper(trim((string) $this->estatusConfirmacion, " \t\n\r\0\x0B<>"));

        if ($normalizado === $esperado) {
            return Evidence::confirmada(['estatus' => $estatus]);
        }

        return Evidence::pendiente();
    }

    private function consultarEstatus(\App\Sync\Source $source, string $numGuia): string|false
    {
        $stmt = $source->connection()->prepare('SELECT estatus FROM guias WHERE num_guia = :num_guia LIMIT 1');
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
