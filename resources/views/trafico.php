<!doctype html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ATLAS — Dashboard de Tráfico</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
<link href="/assets/css/trafico.css" rel="stylesheet">
</head>
<body>
<header class="ops-header">
    <div class="ops-header__brand">
        <span class="ops-header__logo"><i class="bi bi-diagram-3-fill"></i></span>
        <div class="ops-header__titles">
            <span class="ops-header__title">ATLAS</span>
            <span class="ops-header__subtitle">Dashboard de Tráfico</span>
        </div>
        <nav class="ops-header__nav">
            <a href="/facturacion.php"><i class="bi bi-receipt-cutoff"></i> Tablero de Facturación</a>
        </nav>
    </div>

    <div class="ops-header__clock">
        <span id="clock-date" class="ops-header__date"></span>
        <span id="clock-time" class="ops-header__time"></span>
    </div>

    <div class="ops-header__status">
        <span id="ws-status" class="status-pill status-pill--pending">
            <i class="bi bi-wifi"></i> Conectando…
        </span>
        <span id="engine-status" class="status-pill status-pill--pending">
            <i class="bi bi-cpu"></i> Motor: verificando…
        </span>
        <span class="status-pill status-pill--disabled" title="CFDI Watcher aún no implementado">
            <i class="bi bi-file-earmark-check"></i> CFDI Watcher: Próximamente
        </span>
    </div>
</header>

<section class="kpi-bar">
    <div class="kpi-card kpi-card--generada">
        <i class="bi bi-file-earmark-plus-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-generadas" class="kpi-card__value">0</span>
            <span class="kpi-card__label">Guías Generadas</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--liberacion">
        <i class="bi bi-send-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-liberacion" class="kpi-card__value">0</span>
            <span class="kpi-card__label">Solicitadas a Liberación</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--exito">
        <i class="bi bi-check-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-exito" class="kpi-card__value">0</span>
            <span class="kpi-card__label">Timbradas Correctamente</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--error">
        <i class="bi bi-exclamation-triangle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-error" class="kpi-card__value">0</span>
            <span class="kpi-card__label">Timbradas con Error</span>
        </div>
    </div>
</section>

<main class="board">
    <section class="board-column board-column--generada">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-file-earmark-plus-fill"></i> Guías Generadas</span>
            <span id="count-generadas" class="board-column__count">0</span>
        </header>
        <div id="panel-generadas" class="board-column__body">
            <div class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>Sin guías en este momento</p>
            </div>
            <div class="board-column__cards"></div>
        </div>
    </section>

    <section class="board-column board-column--solicitudes-timbrado">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-file-earmark-check-fill"></i> Solicitudes de Timbrado</span>
            <span id="count-solicitudes-timbrado" class="board-column__count">0</span>
        </header>
        <div id="panel-solicitudes-timbrado" class="board-column__body">
            <div class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>Sin guías en este momento</p>
            </div>
            <div class="board-column__cards"></div>
        </div>
    </section>

    <section class="board-column board-column--liberacion">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-send-fill"></i> Solicitadas a Liberación</span>
            <span id="count-liberacion" class="board-column__count">0</span>
        </header>
        <div id="panel-liberacion" class="board-column__body">
            <div class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>Sin guías en este momento</p>
            </div>
            <div class="board-column__cards"></div>
        </div>
    </section>

    <section class="board-column board-column--timbrado">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-receipt"></i> Resultado del Timbrado</span>
            <span id="count-timbrado" class="board-column__count">0</span>
        </header>
        <div id="panel-timbrado" class="board-column__body">
            <div class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>Sin guías en este momento</p>
            </div>
            <div class="board-column__cards"></div>
        </div>
    </section>

    <aside class="activity-panel">
        <header class="activity-panel__header">
            <span class="activity-panel__title"><i class="bi bi-activity"></i> Actividad Reciente</span>
        </header>
        <div id="activity-log" class="activity-panel__body">
            <div class="activity-panel__empty">
                <i class="bi bi-clock-history"></i>
                <p>Sin actividad todavía</p>
            </div>
            <div class="activity-panel__entries"></div>
        </div>
    </aside>
</main>

<script id="initial-guias" type="application/json"><?= json_encode($boardState['generadas'], JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-solicitudes-timbrado" type="application/json"><?= json_encode($boardState['solicitudes_timbrado'], JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-liberacion" type="application/json"><?= json_encode($boardState['liberacion'], JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-timbrado" type="application/json"><?= json_encode($boardState['timbrado'], JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script>
    const WS_PORT = <?= $websocketPort ?>;
</script>
<script src="/assets/js/trafico.js" type="module"></script>
</body>
</html>
