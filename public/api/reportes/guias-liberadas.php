<?php

declare(strict_types=1);

require __DIR__ . "/../../../vendor/autoload.php";

use App\Config\Config;
use App\Database\ConnectionFactory;
use App\Liberacion\JsonResponse;
use App\Reportes\CfdiFolioFiscalLookup;
use App\Reportes\GuiasLiberadasReportRepository;
use App\Reportes\RefacturacionSicretLookup;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;

header("Content-Type: application/json");

$config = new Config();

$connection = (new ConnectionFactory())->make([
    "host" => $config->get("ATLAS_DB_HOST"),
    "port" => $config->get("ATLAS_DB_PORT"),
    "database" => $config->get("ATLAS_DB_DATABASE"),
    "username" => $config->get("ATLAS_DB_USERNAME"),
    "password" => $config->get("ATLAS_DB_PASSWORD"),
]);

$logger = new SyncLogger(__DIR__ . "/../../../storage/logs/api.log");

$repository = new GuiasLiberadasReportRepository($connection);

$sourceRegistry = new SourceRegistry($config, new ConnectionFactory(), __DIR__ . "/../../../config/sources.php");

$folioFiscalLookup = new CfdiFolioFiscalLookup($sourceRegistry, $logger);
$refacturacionLookup = new RefacturacionSicretLookup($sourceRegistry, $logger);

if (($_SERVER["REQUEST_METHOD"] ?? "GET") !== "GET") {
    JsonResponse::error(405, "metodo_no_permitido", "Método HTTP no soportado.");

    return;
}

const SORT_PERMITIDOS = ["fecha", "num_guia", "empresa"];

try {
    $filtros = [
        "desde" => $_GET["desde"] ?? null,
        "hasta" => $_GET["hasta"] ?? null,
        "source" => $_GET["empresa"] ?? null,
        "num_guia" => $_GET["num_guia"] ?? null,
    ];

    $sortSolicitado = is_string($_GET["sort"] ?? null) ? $_GET["sort"] : "fecha";
    $sort = in_array($sortSolicitado, SORT_PERMITIDOS, true) ? $sortSolicitado : "fecha";
    $dir = strtoupper((string) ($_GET["dir"] ?? "DESC")) === "ASC" ? "ASC" : "DESC";
    $page = isset($_GET["page"]) ? max(1, (int) $_GET["page"]) : 1;
    $perPage = isset($_GET["perPage"]) ? max(1, (int) $_GET["perPage"]) : 25;

    $data = $repository->listar($filtros, $sort, $dir, $page, $perPage);

    // Folio fiscal del CFDI anterior: no viene en sicret_write_log (ver
    // docblock de GuiasLiberadasReportRepository) — se resuelve aparte, en
    // lote, contra facturas33 en la fuente SICRET de cada fila.
    $folioFiscalPorFila = $folioFiscalLookup->porFolio(array_map(
        static fn (array $row): array => ["folio" => $row["cfdi_anterior_folio"], "source" => $row["source"]],
        $data,
    ));

    foreach ($data as &$row) {
        $row["folio_fiscal_anterior"] = $row["cfdi_anterior_folio"]
            ? ($folioFiscalPorFila[$row["source"] . "|" . $row["cfdi_anterior_folio"]] ?? null)
            : null;
    }
    unset($row);

    // CFDI/folio fiscal nuevos: el repositorio ya prioriza la caché
    // write-once en solicitud_liberacion_detalle (ver su docblock) y cae a
    // sicret_write_log si aún no está cacheado. Si tampoco hay nada ahí —
    // caso normal cuando la factura nueva ya nació con folioFiscal, sin
    // pasar nunca por FiscalDataWatcher — se resuelve en vivo contra
    // facturas33 (RefacturacionSicretLookup), solo para las filas que
    // siguen sin dato.
    $pendientes = array_values(array_filter(
        $data,
        static fn (array $row): bool => $row["cfdi_nuevo_folio"] === null,
    ));

    $refacturacionPorFila = $refacturacionLookup->porGuia(array_map(
        static fn (array $row): array => [
            "num_guia" => $row["num_guia"],
            "source" => $row["source"],
            "despues_de" => $row["fecha_liberacion"],
        ],
        $pendientes,
    ));

    foreach ($data as &$row) {
        if ($row["cfdi_nuevo_folio"] === null) {
            // Bug real corregido 2026-08-10 (ver docblock de
            // RefacturacionSicretLookup::clave()): la clave debe incluir
            // `fecha_liberacion` de ESTA fila — una guía liberada más de
            // una vez tiene una fila por solicitud, y sin la fecha en la
            // clave todas compartían (y sobreescribían) el mismo resultado
            // en $refacturacionPorFila.
            $dato = $refacturacionPorFila[RefacturacionSicretLookup::clave([
                "source" => $row["source"],
                "num_guia" => $row["num_guia"],
                "despues_de" => $row["fecha_liberacion"],
            ])] ?? null;

            if ($dato !== null) {
                $row["cfdi_nuevo_folio"] = $dato["folio"];
                $row["folio_fiscal_nuevo"] = $dato["folioFiscal"];
            }
        }

        // Se acaba de resolver (por log o por SICRET en vivo) y todavía no
        // vivía en la caché: se persiste una sola vez para que la próxima
        // carga del reporte ya no necesite ninguno de los dos caminos.
        if ($row["cfdi_nuevo_folio"] !== null && !$row["nuevo_ya_persistido"]) {
            $repository->persistirRefacturacion(
                $row["solicitud_id"],
                $row["guia_id"],
                $row["cfdi_nuevo_folio"],
                $row["folio_fiscal_nuevo"],
            );
        }

        unset($row["guia_id"], $row["nuevo_ya_persistido"]);
    }
    unset($row);

    JsonResponse::ok(200, [
        "total" => $repository->contar($filtros),
        "page" => $page,
        "perPage" => $perPage,
        "data" => $data,
    ]);
} catch (\Throwable $e) {
    $logger->error("Error inesperado en reportes/guias-liberadas.php", ["error" => $e->getMessage()]);
    JsonResponse::error(500, "error_interno", "Ocurrió un error interno.");
}
