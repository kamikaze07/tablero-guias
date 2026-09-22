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
        <!-- Los navegadores bloquean todo audio hasta la primera
             interacción del usuario con la página (click/tecla/touch) —
             ver App\...\sound-manager.js::unlock(). Este aviso es la señal
             de que aún falta esa interacción; desaparece solo en cuanto
             ocurre, vía SoundManager::onUnlock(). Mismo patrón que ya
             tiene facturacion.php. -->
        <span id="sonido-bloqueado" class="status-pill status-pill--sonido-bloqueado" title="Haz clic en cualquier parte de la página para activar las alertas de sonido">
            <i class="bi bi-volume-mute-fill"></i> Sonido bloqueado — haz clic aquí
        </span>
        <span id="ws-status" class="status-pill status-pill--pending">
            <i class="bi bi-wifi"></i> Conectando…
        </span>
        <span id="engine-status" class="status-pill status-pill--pending">
            <i class="bi bi-cpu"></i> Motor: verificando…
        </span>
        <span id="cfdi-status" class="status-pill status-pill--pending">
            <i class="bi bi-file-earmark-check"></i> CFDI Watcher: verificando…
        </span>
    </div>
</header>

<section class="kpi-bar">
    <div class="kpi-card kpi-card--generada">
        <i class="bi bi-file-earmark-plus-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-guias-creadas" class="kpi-card__value"><?= (int) $kpisIniciales['guias_creadas'] ?></span>
            <span class="kpi-card__label">Guías Creadas</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--exito">
        <i class="bi bi-check-all kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-timbrado-aprobadas" class="kpi-card__value"><?= (int) $kpisIniciales['timbrado_aprobadas'] ?></span>
            <span class="kpi-card__label">Aprobadas para Timbrar</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--error">
        <i class="bi bi-x-square-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-timbrado-rechazadas" class="kpi-card__value"><?= (int) $kpisIniciales['timbrado_rechazadas'] ?></span>
            <span class="kpi-card__label">Rechazadas para Timbrar</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--exito">
        <i class="bi bi-check-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-liberacion-aprobadas" class="kpi-card__value"><?= (int) $kpisIniciales['liberacion_aprobadas'] ?></span>
            <span class="kpi-card__label">Aprobadas para Liberación</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--error">
        <i class="bi bi-x-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-liberacion-rechazadas" class="kpi-card__value"><?= (int) $kpisIniciales['liberacion_rechazadas'] ?></span>
            <span class="kpi-card__label">Rechazadas para Liberación</span>
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
            <span class="board-column__title"><i class="bi bi-receipt"></i> Respuesta de Solicitudes</span>
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
