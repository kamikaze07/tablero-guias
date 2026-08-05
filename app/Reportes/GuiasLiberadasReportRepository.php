<?php

declare(strict_types=1);

namespace App\Reportes;

use PDO;

/**
 * Reporte "Guías Liberadas" — una fila por liberación exitosa
 * (`solicitud_liberacion.estado = COMPLETADA`), con el folio del CFDI que
 * la guía tenía antes de liberarse y, si ya se refacturó, el folio/folio
 * fiscal del CFDI nuevo. Primer reporte del submódulo de Reportes de
 * Facturación en trafico-system (ver AtlasClient::reporteGuiasLiberadas()
 * en ese repo) — no expone estado interno de ATLAS, solo esta vista plana.
 *
 * El folio/folio fiscal del CFDI *nuevo* se leen, en orden de prioridad:
 * 1. `solicitud_liberacion_detalle.cfdi_nuevo_folio`/`folio_fiscal_nuevo` —
 *    caché write-once (ver schema.sql), la fuente rápida una vez resuelta.
 * 2. Si aún no está cacheado: `sicret_write_log.detalle` (texto libre que
 *    ya escribe App\Infrastructure\Sicret\PdoSicretGateway::liberar()/
 *    completarDatosFiscales() para auditoría), correlacionado por
 *    num_guia y por tiempo respecto a `confirmed_at` de esta liberación
 *    específica — una guía puede liberarse más de una vez en su historia,
 *    así que no basta con "la última fila de sicret_write_log para ese
 *    num_guia". Si tampoco hay nada ahí, el endpoint
 *    (public/api/reportes/guias-liberadas.php) cae a
 *    App\Reportes\RefacturacionSicretLookup (consulta en vivo a
 *    `facturas33`) y persiste el resultado en la caché de arriba para no
 *    tener que repetir ninguno de los dos caminos otra vez.
 *
 * El folio fiscal (UUID) del CFDI anterior NO está en este texto (liberar()
 * solo guardó el folio corto) — se resuelve aparte con
 * App\Reportes\CfdiFolioFiscalLookup contra `facturas33` en SICRET, igual
 * que hace el endpoint (public/api/reportes/guias-liberadas.php).
 */
final class GuiasLiberadasReportRepository
{
    private const SORT_COLUMNS = [
        "fecha" => "sl.confirmed_at",
        "num_guia" => "d.num_guia",
        "empresa" => "g.source",
    ];

    public function __construct(private readonly PDO $connection)
    {
    }

    /**
     * @param array{desde?: ?string, hasta?: ?string, source?: ?string, num_guia?: ?string} $filtros
     * @return array<int, array<string, mixed>>
     */
    public function listar(array $filtros, string $sort, string $dir, int $page, int $perPage): array
    {
        [$where, $params] = $this->condiciones($filtros);
        $orderBy = self::SORT_COLUMNS[$sort] ?? self::SORT_COLUMNS["fecha"];
        $orderDir = strtoupper($dir) === "ASC" ? "ASC" : "DESC";
        $offset = ($page - 1) * $perPage;

        $stmt = $this->connection->prepare(
            "SELECT
                sl.id AS solicitud_id,
                sl.motivo,
                sl.confirmed_at AS fecha_liberacion,
                sl.resolved_by AS liberado_por,
                d.guia_id,
                d.num_guia,
                d.cfdi_nuevo_folio AS cfdi_nuevo_folio_persistido,
                d.folio_fiscal_nuevo AS folio_fiscal_nuevo_persistido,
                g.source,
                (SELECT detalle FROM sicret_write_log
                  WHERE operacion = 'liberar' AND resultado = 'exito' AND num_guia = d.num_guia
                    AND created_at <= sl.confirmed_at
                  ORDER BY created_at DESC LIMIT 1) AS detalle_liberacion,
                (SELECT detalle FROM sicret_write_log
                  WHERE operacion = 'completar_datos_fiscales' AND resultado = 'exito' AND num_guia = d.num_guia
                    AND created_at > sl.confirmed_at
                  ORDER BY created_at ASC LIMIT 1) AS detalle_refacturacion
             FROM solicitud_liberacion sl
             JOIN solicitud_liberacion_detalle d ON d.solicitud_id = sl.id
             JOIN guias g ON g.id = d.guia_id
             {$where}
             ORDER BY {$orderBy} {$orderDir}, sl.id DESC
             LIMIT :limit OFFSET :offset"
        );

        foreach ($params as $key => $value) {
            $stmt->bindValue(":" . $key, $value);
        }

        $stmt->bindValue(":limit", $perPage, PDO::PARAM_INT);
        $stmt->bindValue(":offset", $offset, PDO::PARAM_INT);
        $stmt->execute();

        return array_map([$this, "formatear"], $stmt->fetchAll(PDO::FETCH_ASSOC));
    }

    /** @param array{desde?: ?string, hasta?: ?string, source?: ?string, num_guia?: ?string} $filtros */
    public function contar(array $filtros): int
    {
        [$where, $params] = $this->condiciones($filtros);

        $stmt = $this->connection->prepare(
            "SELECT COUNT(*)
             FROM solicitud_liberacion sl
             JOIN solicitud_liberacion_detalle d ON d.solicitud_id = sl.id
             JOIN guias g ON g.id = d.guia_id
             {$where}"
        );
        $stmt->execute($params);

        return (int) $stmt->fetchColumn();
    }

    /**
     * Guarda, una sola vez, el CFDI/folio fiscal nuevo ya resuelto para
     * esta guía dentro de esta Solicitud de Liberación (ver comentario en
     * schema.sql). El guard `cfdi_nuevo_folio IS NULL` es a propósito:
     * nunca pisa un valor ya capturado, mismo criterio que
     * PdoSicretGateway::completarDatosFiscales() usa en `facturas33`.
     */
    public function persistirRefacturacion(int $solicitudId, int $guiaId, string $folio, ?string $folioFiscal): void
    {
        $stmt = $this->connection->prepare(
            "UPDATE solicitud_liberacion_detalle
             SET cfdi_nuevo_folio = :folio, folio_fiscal_nuevo = :folio_fiscal
             WHERE solicitud_id = :solicitud_id AND guia_id = :guia_id
               AND cfdi_nuevo_folio IS NULL"
        );
        $stmt->execute([
            "folio" => $folio,
            "folio_fiscal" => $folioFiscal,
            "solicitud_id" => $solicitudId,
            "guia_id" => $guiaId,
        ]);
    }

    /** @return array<string, mixed> */
    private function formatear(array $row): array
    {
        $folioAnterior = null;

        if ($row["detalle_liberacion"] && preg_match("/CFDI anterior:\s*(\S+)/", (string) $row["detalle_liberacion"], $m)) {
            $folioAnterior = $m[1];
        }

        $folioNuevo = $row["cfdi_nuevo_folio_persistido"] ?: null;
        $folioFiscalNuevo = $row["folio_fiscal_nuevo_persistido"] ?: null;
        $nuevoYaPersistido = $folioNuevo !== null;

        if ($folioNuevo === null && $row["detalle_refacturacion"]) {
            $detalle = (string) $row["detalle_refacturacion"];

            if (preg_match("/folio=(\S+)/", $detalle, $m)) {
                $folioNuevo = $m[1];
            }

            if (preg_match("/folioFiscal=(\S+)/", $detalle, $m)) {
                $folioFiscalNuevo = $m[1];
            }
        }

        return [
            "solicitud_id" => (int) $row["solicitud_id"],
            "guia_id" => (int) $row["guia_id"],
            "num_guia" => $row["num_guia"],
            "source" => $row["source"],
            "motivo" => $row["motivo"],
            "fecha_liberacion" => $row["fecha_liberacion"],
            "liberado_por" => $row["liberado_por"],
            "cfdi_anterior_folio" => $folioAnterior,
            "cfdi_nuevo_folio" => $folioNuevo,
            "folio_fiscal_nuevo" => $folioFiscalNuevo,
            // Solo para uso interno del endpoint: si es false y
            // cfdi_nuevo_folio no es null, el valor vino del log o de
            // RefacturacionSicretLookup y todavía hay que persistirlo.
            "nuevo_ya_persistido" => $nuevoYaPersistido,
        ];
    }

    /**
     * @param array{desde?: ?string, hasta?: ?string, source?: ?string, num_guia?: ?string} $filtros
     * @return array{0: string, 1: array<string, string>}
     */
    private function condiciones(array $filtros): array
    {
        $clauses = ["sl.estado = 'COMPLETADA'"];
        $params = [];

        if (!empty($filtros["desde"])) {
            $clauses[] = "sl.confirmed_at >= :desde";
            $params["desde"] = $filtros["desde"] . " 00:00:00";
        }

        if (!empty($filtros["hasta"])) {
            $clauses[] = "sl.confirmed_at <= :hasta";
            $params["hasta"] = $filtros["hasta"] . " 23:59:59";
        }

        if (!empty($filtros["source"])) {
            $clauses[] = "g.source = :source";
            $params["source"] = $filtros["source"];
        }

        if (!empty($filtros["num_guia"])) {
            $clauses[] = "d.num_guia LIKE :num_guia";
            $params["num_guia"] = "%" . $filtros["num_guia"] . "%";
        }

        $where = "WHERE " . implode(" AND ", $clauses);

        return [$where, $params];
    }
}
