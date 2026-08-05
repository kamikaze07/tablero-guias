<?php

declare(strict_types=1);

namespace App\Monitoring\Timbrado;

use App\Monitoring\Evidence\Evidence;
use App\Monitoring\Evidence\EvidenceSource;
use App\Sync\SyncLogger;
use DOMDocument;
use DOMXPath;

/**
 * Evidencia para completar `facturas33.folioFiscal`/`idccp` — ver
 * App\Monitoring\Timbrado\FiscalDataWatcher. Ambos valores se leen del
 * mismo XML del CFDI que ya vigilan StampingEvidenceSource/
 * DirectStampingEvidenceSource (misma carpeta OUT), pero a diferencia de
 * esas dos clases (que solo comprueban que el XML EXISTA, sin leerlo, por
 * decisión deliberada de un sprint anterior — ver sus docblocks), aquí sí
 * se necesita el contenido: el UUID del Timbre Fiscal Digital y el IdCCP
 * del Complemento Carta Porte son atributos XML simples, no requieren
 * parsear nada más del comprobante.
 *
 * Namespace-agnóstico a propósito (XPath por `local-name()`): la versión
 * del Complemento Carta Porte varía (cartaporte30/cartaporte31/futuras) y
 * no vale la pena acoplarse a un prefijo concreto para leer un solo
 * atributo.
 */
final class FiscalDataEvidenceSource implements EvidenceSource
{
    private bool $avisoConfiguracionRegistrado = false;

    public function __construct(
        private readonly SyncLogger $logger,
        private readonly string $outPath,
    ) {
    }

    /** @param array{source: string, num_guia: string, folio: string} $item */
    public function buscar(mixed $item): Evidence
    {
        if ($this->outPath === '') {
            if (!$this->avisoConfiguracionRegistrado) {
                $this->logger->error(
                    'FiscalDataEvidenceSource sin configurar: falta SICRET_TIMBRADO_OUT_PATH. '
                    . 'Ningún folioFiscal/idccp podrá completarse todavía.',
                );

                $this->avisoConfiguracionRegistrado = true;
            }

            return Evidence::pendiente();
        }

        $rutaXml = rtrim($this->outPath, '/') . '/' . $item['folio'] . '.xml';
        clearstatcache(true, $rutaXml);

        if (!is_file($rutaXml)) {
            return Evidence::pendiente();
        }

        $datos = $this->leerDatosFiscales($rutaXml);

        if ($datos === null) {
            return Evidence::fallida("El XML {$item['folio']}.xml existe pero no trae UUID de Timbre Fiscal Digital.");
        }

        return Evidence::confirmada($datos);
    }

    /** @return array{folioFiscal: string, idccp: ?string}|null */
    private function leerDatosFiscales(string $rutaXml): ?array
    {
        $usoPrevio = libxml_use_internal_errors(true);

        try {
            $dom = new DOMDocument();

            if (!$dom->load($rutaXml)) {
                return null;
            }

            $xpath = new DOMXPath($dom);

            $uuid = $this->primerAtributo($xpath, "//*[local-name()='TimbreFiscalDigital']/@UUID");

            if ($uuid === null || $uuid === '') {
                return null;
            }

            // Opcional: no todo CFDI trae Complemento Carta Porte.
            $idCcp = $this->primerAtributo($xpath, "//*[local-name()='CartaPorte']/@IdCCP");

            return [
                'folioFiscal' => $uuid,
                'idccp' => $idCcp === '' ? null : $idCcp,
            ];
        } finally {
            libxml_clear_errors();
            libxml_use_internal_errors($usoPrevio);
        }
    }

    private function primerAtributo(DOMXPath $xpath, string $expresion): ?string
    {
        $nodos = $xpath->query($expresion);

        if ($nodos === false || $nodos->length === 0) {
            return null;
        }

        return trim((string) $nodos->item(0)?->nodeValue);
    }
}
