<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDOException;

final class TimbradoConclusionEvidenceSource implements EvidenceSource
{
    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

    public function __construct(
        private readonly SourceRegistry $readSourceRegistry,
        private readonly SyncLogger $logger,
    ) {
    }

    /** @param array{solicitud_id: int, creada_en: string, guias: array<int, array{guia_id: int, num_guia: string, source: ?string}>} $item */
    public function buscar(mixed $item): Evidence
    {
        if (!$this->solicitudCompleta($item['guias'], $item['creada_en'])) {
            return Evidence::pendiente();
        }

        // Resuelve el folio (facturas33.folio) por guía — necesario para que
        // TimbradoConclusionWatcher::alConfirmar() pueda dejar
        // `solicitud_timbrado_detalle.factura_impresa` poblado (ver bug real
        // encontrado en el piloto de Sprint 9.2: una solicitud podía llegar
        // a CONCLUIDA sin pasar nunca por TIMBRADO —
        // TimbradoConfirmationWatcher, el único que hasta ahora escribía ese
        // campo, nunca llegaba a ejecutarse — dejando `factura_impresa`
        // vacío y rompiendo la descarga de PDF/XML pese a que el CFDI ya
        // existía, correcto y completo, en SICRET).
        $guiasConFolio = [];
        foreach ($item['guias'] as $guia) {
            $source = $this->buscarFuente($guia['source']);
            $datos = $source === null ? null : $this->datosPorGuia($source, $guia['num_guia'], $item['creada_en']);

            if ($datos === null || $datos['factura_impresa'] === null) {
                // Condición de carrera improbable: solicitudCompleta() ya
                // confirmó folioFiscal/idccp no vacíos hace un instante,
                // pero la fila pudo desaparecer entretanto — se reintenta en
                // el siguiente ciclo en vez de concluir con datos a medias.
                return Evidence::pendiente();
            }

            $guiasConFolio[] = [
                'guia_id' => $guia['guia_id'],
                'num_guia' => $guia['num_guia'],
                'source' => $guia['source'],
                'factura_impresa' => $datos['factura_impresa'],
                'usuario' => $datos['usuario'],
            ];
        }

        return Evidence::confirmada(['solicitud_id' => $item['solicitud_id'], 'guias' => $guiasConFolio]);
    }

    /**
     * Condición solicitudCompleta(): confirmada SOLO si todas las guías de la
     * solicitud cumplen la condición al mismo tiempo — patrón idéntico y sin
     * simplificaciones al de LiberacionConfirmationWatcher::solicitudCompleta():
     * si en un lote de 3 guías 2 ya tienen datos y 1 no, la solicitud
     * completa queda en espera.
     *
     * @param array<int, array{guia_id: int, num_guia: string, source: ?string}> $guias
     */
    public function solicitudCompleta(array $guias, string $creadaEn): bool
    {
        if (empty($guias)) {
            return false;
        }

        foreach ($guias as $guia) {
            if ($guia['source'] === null) {
                $this->logger->error('TimbradoConclusionEvidenceSource: no se pudo resolver "source" para guia_id, se reintentará', [
                    'guia_id' => $guia['guia_id'],
                ]);
                return false;
            }

            $source = $this->buscarFuente($guia['source']);
            if ($source === null) {
                $this->logger->error('TimbradoConclusionEvidenceSource: Fuente SICRET desconocida, se reintentará', [
                    'source' => $guia['source'],
                ]);
                return false;
            }

            try {
                $tieneDatos = $this->tieneDatosFiscales($source, $guia['num_guia'], $creadaEn);
            } catch (PDOException $e) {
                if (!$this->isConnectionLost($e)) {
                    throw $e;
                }

                $this->logger->error('TimbradoConclusionEvidenceSource: conexión perdida con SICRET, reconectando', [
                    'source' => $guia['source'],
                    'error' => $e->getMessage(),
                ]);

                $source->reconnect();
                $tieneDatos = $this->tieneDatosFiscales($source, $guia['num_guia'], $creadaEn);
            }

            if (!$tieneDatos) {
                return false;
            }
        }

        return true;
    }

    /**
     * `AND f.fecha > :creada_en` es la corrección del bug real de
     * "timbrado fantasma tras liberación" (visto en producción con
     * PR-220277/PR-220278, GERO): sin esta condición, una fila de
     * `facturas33` de un timbrado ANTERIOR (previo a una Liberación que
     * limpió `guias.factImpresa`, ver `PdoSicretGateway::liberar()`)
     * podía volver a satisfacer una Solicitud de Timbrado NUEVA si
     * `factImpresa` volvía a apuntar al mismo folio viejo por cualquier
     * motivo ajeno a este código (confirmado: en ese caso real, la
     * solicitud se concluyó en 7 segundos con el mismo folio del timbrado
     * original de 2 días antes, sin que existiera ninguna fila nueva en
     * `facturas33`). Exigir que la evidencia sea POSTERIOR a la creación
     * de la solicitud actual es la única forma de distinguir "esta
     * solicitud ya se cumplió" de "esta solicitud ve evidencia de una
     * completamente distinta".
     */
    private function tieneDatosFiscales(\App\Sync\Source $source, string $numGuia, string $creadaEn): bool
    {
        $stmt = $source->connection()->prepare(
            "SELECT f.folioFiscal, f.idccp FROM facturas33 f
             JOIN guias g ON g.num_guia = f.cartaporte AND g.factImpresa = f.folio
             WHERE f.cartaporte = :num_guia
               AND g.factImpresa IS NOT NULL AND g.factImpresa != ''
               AND f.folioFiscal IS NOT NULL AND f.folioFiscal != ''
               AND f.idccp IS NOT NULL AND f.idccp != ''
               AND f.fecha > :creada_en
             LIMIT 1"
        );
        $stmt->execute(['num_guia' => $numGuia, 'creada_en' => $creadaEn]);

        $row = $stmt->fetch(\PDO::FETCH_ASSOC);
        if ($row === false) {
            return false;
        }

        return trim((string) ($row['folioFiscal'] ?? '')) !== ''
            && trim((string) ($row['idccp'] ?? '')) !== '';
    }

    /**
     * Mismo criterio y misma tabla que tieneDatosFiscales() (incluida la
     * condición de frescura `f.fecha > :creada_en`, ver su docblock) — el
     * folio real (`facturas33.folio`, p. ej. "PR65573") es el valor que
     * necesita `solicitud_timbrado_detalle.factura_impresa`, y se recupera
     * también el usuario de Facturación que realizó el timbrado en SICRET
     * (`facturas33.usuario`).
     *
     * @return array{factura_impresa: string, usuario: ?string}|null
     */
    private function datosPorGuia(\App\Sync\Source $source, string $numGuia, string $creadaEn): ?array
    {
        $stmt = $source->connection()->prepare(
            "SELECT f.folio, f.usuario FROM facturas33 f
             JOIN guias g ON g.num_guia = f.cartaporte AND g.factImpresa = f.folio
             WHERE f.cartaporte = :num_guia
               AND g.factImpresa IS NOT NULL AND g.factImpresa != ''
               AND f.folioFiscal IS NOT NULL AND f.folioFiscal != ''
               AND f.idccp IS NOT NULL AND f.idccp != ''
               AND f.fecha > :creada_en
             LIMIT 1"
        );
        $stmt->execute(['num_guia' => $numGuia, 'creada_en' => $creadaEn]);

        $row = $stmt->fetch(\PDO::FETCH_ASSOC);

        if ($row === false) {
            return null;
        }

        $folio = trim((string) ($row['folio'] ?? ''));
        $usuario = trim((string) ($row['usuario'] ?? ''));

        if ($folio === '') {
            return null;
        }

        return [
            'factura_impresa' => $folio,
            'usuario' => $usuario === '' ? null : $usuario,
        ];
    }

    private function isConnectionLost(PDOException $e): bool
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
