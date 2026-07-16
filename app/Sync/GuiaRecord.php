<?php

declare(strict_types=1);

namespace App\Sync;

final class GuiaRecord
{
    public function __construct(
        public readonly string $source,
        public readonly int $sourceNum,
        public readonly string $numGuia,
        public readonly string $folioImp,
        public readonly \DateTimeImmutable $fecha,
        public readonly \DateTimeImmutable $fechaC,
        public readonly \DateTimeImmutable $fechaD,
        public readonly int $numLlama,
        public readonly string $estado,
        public readonly string $nombre,
        public readonly string $tipo,
        public readonly string $numVale,
        public readonly string $diesel,
        public readonly string $servicio,
        public readonly string $rem1,
        public readonly string $placas1,
        public readonly string $rem2,
        public readonly string $placas2,
        public readonly string $estatus,
        public readonly string $pedido,
        public readonly string $comenPre,
        public readonly int $factura,
        public readonly string $manifiesto,
        public readonly string $ticket1,
        public readonly float $tons1,
        public readonly string $ticket2,
        public readonly float $tons2,
        public readonly string $operador,
        public readonly int $prefactura,
        public readonly string $factimpresa,
        public readonly string $linea,
        public readonly float $km,
        public readonly string $claveProductoSat,
        public readonly string $claveUnidadSat,
        public readonly ?string $doField,
        public readonly ?string $lidField,
        public readonly ?string $actualizacion,
    ) {
    }

    /** @param array<string, mixed> $row */
    public static function fromSourceRow(string $source, array $row): self
    {
        return new self(
            source: $source,
            sourceNum: (int) $row['num'],
            numGuia: (string) $row['num_guia'],
            folioImp: (string) $row['folio_imp'],
            fecha: new \DateTimeImmutable((string) $row['fecha']),
            fechaC: new \DateTimeImmutable((string) $row['fecha_c']),
            fechaD: new \DateTimeImmutable((string) $row['fecha_d']),
            numLlama: (int) $row['num_llama'],
            estado: (string) $row['estado'],
            nombre: (string) $row['nombre'],
            tipo: (string) $row['tipo'],
            numVale: (string) $row['num_vale'],
            diesel: (string) $row['diesel'],
            servicio: (string) $row['servicio'],
            rem1: (string) $row['rem1'],
            placas1: (string) $row['placas1'],
            rem2: (string) $row['rem2'],
            placas2: (string) $row['placas2'],
            estatus: (string) $row['estatus'],
            pedido: (string) $row['pedido'],
            comenPre: (string) $row['comen_pre'],
            factura: (int) $row['factura'],
            manifiesto: (string) $row['manifiesto'],
            ticket1: (string) $row['ticket1'],
            tons1: (float) $row['tons1'],
            ticket2: (string) $row['ticket2'],
            tons2: (float) $row['tons2'],
            operador: (string) $row['operador'],
            prefactura: (int) $row['prefactura'],
            factimpresa: (string) $row['factimpresa'],
            linea: (string) $row['linea'],
            km: (float) $row['km'],
            claveProductoSat: (string) $row['claveproductoSat'],
            claveUnidadSat: (string) $row['claveUnidadSat'],
            doField: $row['do'] !== null ? (string) $row['do'] : null,
            lidField: $row['lid'] !== null ? (string) $row['lid'] : null,
            actualizacion: $row['actualizacion'] !== null ? (string) $row['actualizacion'] : null,
        );
    }
}
