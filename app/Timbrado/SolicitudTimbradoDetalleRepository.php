<?php

declare(strict_types=1);

namespace App\Timbrado;

use App\Liberacion\GuiaEstadoTableroRepository;
use PDO;

final class SolicitudTimbradoDetalleRepository
{
    public function __construct(private readonly PDO $connection)
    {
    }

    /** @param array<int, array{guia_id: int, num_guia: string}> $guias */
    public function insertarLote(int $solicitudId, array $guias): void
    {
        $stmt = $this->connection->prepare(
            'INSERT INTO solicitud_timbrado_detalle (solicitud_id, guia_id, num_guia)
             VALUES (:solicitud_id, :guia_id, :num_guia)'
        );

        foreach ($guias as $guia) {
            $stmt->execute([
                'solicitud_id' => $solicitudId,
                'guia_id' => $guia['guia_id'],
                'num_guia' => $guia['num_guia'],
            ]);
        }
    }

    /** @return array<int, array<string, mixed>> */
    public function porSolicitud(int $solicitudId): array
    {
        $stmt = $this->connection->prepare(
            'SELECT guia_id, num_guia
             FROM solicitud_timbrado_detalle
             WHERE solicitud_id = :solicitud_id
             ORDER BY num_guia ASC'
        );
        $stmt->execute(['solicitud_id' => $solicitudId]);

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * App\Monitoring\Timbrado\TimbradoConfirmationWatcher: persiste el
     * `factImpresa` de SICRET que ya trae la evidencia confirmada — única
     * escritura de esta columna, ver el porqué en database/schema.sql junto
     * a la definición de la tabla.
     *
     * @param array<int, array{guia_id: int, factura_impresa: string}> $guias
     */
    public function marcarFacturaImpresa(int $solicitudId, array $guias): void
    {
        $stmt = $this->connection->prepare(
            'UPDATE solicitud_timbrado_detalle
                SET factura_impresa = :factura_impresa
              WHERE solicitud_id = :solicitud_id AND guia_id = :guia_id'
        );

        foreach ($guias as $guia) {
            $stmt->execute([
                'factura_impresa' => $guia['factura_impresa'],
                'solicitud_id' => $solicitudId,
                'guia_id' => $guia['guia_id'],
            ]);
        }
    }

    /**
     * public/api/timbrado-carta-porte.php: resuelve el `factura_impresa`
     * de la solicitud TIMBRADO más reciente de un folio — nunca confía en
     * un valor mandado por el cliente para construir la ruta del archivo
     * (ver knowledge/modules/solicitudes-liberacion/security.md, mismo
     * principio de no confiar en el llamador para datos sensibles a rutas).
     * Null si el folio no existe o todavía no tiene un timbrado confirmado.
     */
    public function facturaImpresaConfirmadaPorNumGuia(string $numGuia): ?string
    {
        $stmt = $this->connection->prepare(
            'SELECT d.factura_impresa
             FROM solicitud_timbrado_detalle d
             JOIN solicitud_timbrado st ON st.id = d.solicitud_id
             WHERE d.num_guia = :num_guia
               AND st.estado IN (:estado_timbrado, :estado_concluida)
               AND d.factura_impresa IS NOT NULL
             ORDER BY d.solicitud_id DESC
             LIMIT 1'
        );

        $stmt->execute([
            'num_guia' => $numGuia,
            'estado_timbrado' => SolicitudTimbradoRepository::ESTADO_TIMBRADO,
            'estado_concluida' => SolicitudTimbradoRepository::ESTADO_CONCLUIDA,
        ]);

        $value = $stmt->fetchColumn();

        return $value === false ? null : (string) $value;
    }

    /**
     * Candidatas para App\Monitoring\Timbrado\DirectStampingWatcher: guías
     * recientes que Facturación pudo haber timbrado directo en SICRET sin
     * que Tráfico levantara una Solicitud de Timbrado — nunca aparecieron
     * en esta tabla (`NOT EXISTS`, cualquier estado, no solo pendiente) y
     * todavía no están confirmadas como TIMBRADO en el tablero. Acotado por
     * fecha (nunca un escaneo completo de `guias`, mismo principio que el
     * resto de los Watchers de App\Monitoring) — pasado ese número de días
     * se asume que si no se detectó, ya no es un caso vigente a vigilar.
     *
     * @return array<int, array{guia_id: int, num_guia: string, source: string}>
     */
    public function pendientesTimbradoDirecto(int $diasHaciaAtras): array
    {
        $stmt = $this->connection->prepare(
            'SELECT g.id AS guia_id, g.num_guia, g.source
             FROM guias g
             LEFT JOIN guia_estado_tablero get ON get.guia_id = g.id AND get.estado = :estado_timbrado
             WHERE g.fecha >= DATE_SUB(NOW(), INTERVAL :dias DAY)
               AND get.guia_id IS NULL
               AND NOT EXISTS (
                   SELECT 1 FROM solicitud_timbrado_detalle d WHERE d.guia_id = g.id
               )
             ORDER BY g.fecha ASC'
        );

        $stmt->bindValue(':estado_timbrado', GuiaEstadoTableroRepository::ESTADO_TIMBRADO);
        $stmt->bindValue(':dias', $diasHaciaAtras, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
