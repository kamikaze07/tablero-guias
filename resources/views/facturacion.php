<!doctype html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ATLAS — Tablero de Facturación</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
<link href="/assets/css/trafico.css" rel="stylesheet">
<link href="/assets/css/facturacion.css" rel="stylesheet">
</head>
<body>
<header class="ops-header">
    <div class="ops-header__brand">
        <span class="ops-header__logo"><i class="bi bi-receipt-cutoff"></i></span>
        <div class="ops-header__titles">
            <span class="ops-header__title">ATLAS</span>
            <span class="ops-header__subtitle">Tablero de Facturación</span>
        </div>
        <nav class="ops-header__nav">
            <a href="/trafico.php"><i class="bi bi-arrow-left-right"></i> Dashboard de Tráfico</a>
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
             ocurre, vía SoundManager::onUnlock(). -->
        <span id="sonido-bloqueado" class="status-pill status-pill--sonido-bloqueado" title="Haz clic en cualquier parte de la página para activar las alertas de sonido">
            <i class="bi bi-volume-mute-fill"></i> Sonido bloqueado — haz clic aquí
        </span>
        <span id="ws-status" class="status-pill status-pill--pending">
            <i class="bi bi-wifi"></i> Conectando…
        </span>
        <span id="engine-status" class="status-pill status-pill--pending">
            <i class="bi bi-cpu"></i> Motor de Liberación: verificando…
        </span>
        <span id="cfdi-status" class="status-pill status-pill--pending">
            <i class="bi bi-file-earmark-check"></i> CFDI Watcher: verificando…
        </span>
        <!-- Cada intento de reproducción (éxito o fallo) queda en
             localStorage vía SoundManager (ver sound-manager.js) — permite
             revisar qué pasó con la alerta de solicitudes desatendidas sin
             haber tenido la consola abierta en el momento exacto. -->
        <button type="button" id="ver-registro-sonido" class="status-pill status-pill--pending status-pill--button">
            <i class="bi bi-clock-history"></i> Registro de sonido
        </button>
    </div>
</header>

<!-- Letrero de solicitudes desatendidas (más de 3 min sin aceptar, o
     aceptadas sin atender) — ver evaluarAlertaDesatendidas() en
     facturacion.js. Oculto por defecto, visible en las dos vistas
     (Trabajo pendiente / Historial) para que sea difícil de ignorar. -->
<div id="alerta-desatendidas" class="alerta-desatendidas is-hidden" role="alert">
    <i class="bi bi-exclamation-triangle-fill"></i>
    <span id="alerta-desatendidas-texto"></span>
    <span id="alerta-desatendidas-sonido" class="alerta-desatendidas__sonido"></span>
</div>

<section class="kpi-bar kpi-bar--facturacion">
    <div class="kpi-card kpi-card--pendiente">
        <i class="bi bi-hourglass-split kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-pendientes" class="kpi-card__value"><?= (int) $kpisIniciales['resumen']['pendientes'] ?></span>
            <span class="kpi-card__label">Solicitudes pendientes</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--exito">
        <i class="bi bi-check-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-aprobadas" class="kpi-card__value"><?= (int) $kpisIniciales['resumen']['aprobadas_hoy'] ?></span>
            <span class="kpi-card__label">Aprobadas hoy</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--error">
        <i class="bi bi-x-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-rechazadas" class="kpi-card__value"><?= (int) $kpisIniciales['resumen']['rechazadas_hoy'] ?></span>
            <span class="kpi-card__label">Rechazadas hoy</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--liberacion">
        <i class="bi bi-receipt kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-por-timbrar" class="kpi-card__value"><?= (int) $kpisIniciales['guias_por_timbrar'] ?></span>
            <span class="kpi-card__label">Guías Por Timbrar</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--tiempo">
        <i class="bi bi-clock-history kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-tiempo-espera" class="kpi-card__value"><?= (float) $kpisIniciales['resumen']['tiempo_promedio_espera_minutos'] ?></span>
            <span class="kpi-card__label">Min. promedio de espera</span>
        </div>
    </div>
</section>

<div class="view-tabs">
    <button id="tab-pendiente" class="btn btn-sm btn-primary" type="button" data-view="pendiente">
        <i class="bi bi-lightning-fill"></i> Trabajo pendiente
    </button>
    <button id="tab-historial" class="btn btn-sm btn-outline-secondary" type="button" data-view="historial">
        <i class="bi bi-clock-history"></i> Historial completo
    </button>
</div>

<section id="view-pendiente">

<section class="filters-bar">
    <select id="filtro-estado" class="form-select form-select-sm">
        <option value="" selected>Todos los estados</option>
        <option value="PENDIENTE">Pendientes</option>
        <option value="APROBADA">Aprobadas</option>
        <option value="RECHAZADA">Rechazadas</option>
        <option value="EJECUTANDO">Ejecutando</option>
        <option value="COMPLETADA">Completadas</option>
        <option value="ERROR">Con error</option>
        <option value="ESPERANDO_TIMBRADO">Esperando timbrado</option>
        <option value="TIMBRADO">Timbradas</option>
    </select>
    <select id="filtro-empresa" class="form-select form-select-sm">
        <option value="">Todas las empresas</option>
        <option value="sicrePR">FORSIS</option>
        <option value="sicreGero">GERO</option>
    </select>
    <input id="filtro-operador" class="form-control form-control-sm" type="text" placeholder="Operador">
    <input id="filtro-num-guia" class="form-control form-control-sm" type="text" placeholder="Buscar por folio">
    <input id="filtro-desde" class="form-control form-control-sm" type="date" title="Desde">
    <input id="filtro-hasta" class="form-control form-control-sm" type="date" title="Hasta">
    <select id="ordenar-por" class="form-select form-select-sm">
        <!-- Por defecto ordena por tiempo esperando (created_at de la
             solicitud), no por fecha de la guía: una solicitud de HOY
             sobre una guía de días atrás quedaba enterrada más allá de la
             primera página al ordenar por g.fecha, invisible en el panel
             de "Solicitudes" pese a estar recién creada (bug reportado
             28/jul). -->
        <option value="tiempo_espera" selected>Ordenar por tiempo esperando</option>
        <option value="fecha">Ordenar por fecha de la guía</option>
        <option value="empresa">Ordenar por empresa</option>
        <option value="autorizo">Ordenar por autorizó</option>
        <option value="num_guia">Ordenar por número de guía</option>
    </select>
    <button id="ordenar-dir" class="btn btn-sm btn-outline-secondary" type="button" data-dir="DESC" title="Cambiar dirección">
        <i class="bi bi-sort-down"></i>
    </button>
</section>

<main class="board board--facturacion">
    <section class="board-column board-column--solicitudes-timbrado">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-envelope-paper-fill"></i> Solicitudes de Timbrado</span>
            <span id="count-solicitudes-timbrado" class="board-column__count">0</span>
        </header>
        <div class="board-column__body board-column__body--table board-column__body--table-solicitudes">
            <table class="table table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Contenedor</th>
                        <th>Cliente</th>
                        <th>Ruta</th>
                        <th>Operador</th>
                        <th>Empresa</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody id="tabla-solicitudes-timbrado"></tbody>
            </table>
            <div id="solicitudes-timbrado-empty" class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>No se encontraron solicitudes de timbrado pendientes</p>
            </div>
        </div>
    </section>

    <section class="board-column board-column--solicitudes">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-inbox-fill"></i> Solicitudes de Liberación</span>
            <span id="count-solicitudes" class="board-column__count">0</span>
        </header>
        <div class="board-column__body board-column__body--table board-column__body--table-solicitudes">
            <table class="table table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Contenedor</th>
                        <th>Cliente</th>
                        <th>Ruta</th>
                        <th>Operador</th>
                        <th>Empresa</th>
                        <th>Fecha</th>
                        <th>Motivo</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody id="tabla-solicitudes"></tbody>
            </table>
            <div id="solicitudes-empty" class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>No se encontraron solicitudes con los filtros actuales</p>
            </div>
        </div>
    </section>

</main>

</section>

<section id="view-historial" style="display:none">

<section class="filters-bar">
    <select id="hist-filtro-estado" class="form-select form-select-sm">
        <option value="" selected>Todos los estados</option>
        <option value="APROBADA">Liberación: Aprobada</option>
        <option value="EJECUTANDO">Liberación: Ejecutando</option>
        <option value="COMPLETADA">Liberación: Completada</option>
        <option value="RECHAZADA">Rechazada</option>
        <option value="ERROR">Liberación: Error</option>
        <option value="ESPERANDO_TIMBRADO">Timbrado: Esperando confirmación</option>
        <option value="TIMBRADO">Timbrado: Timbrado</option>
    </select>
    <select id="hist-filtro-empresa" class="form-select form-select-sm">
        <option value="">Todas las empresas</option>
        <option value="sicrePR">FORSIS</option>
        <option value="sicreGero">GERO</option>
    </select>
    <input id="hist-filtro-operador" class="form-control form-control-sm" type="text" placeholder="Operador">
    <input id="hist-filtro-num-guia" class="form-control form-control-sm" type="text" placeholder="Buscar por folio">
    <input id="hist-filtro-desde" class="form-control form-control-sm" type="date" title="Desde">
    <input id="hist-filtro-hasta" class="form-control form-control-sm" type="date" title="Hasta">
    <div class="hist-pager">
        <button id="hist-pager-prev" class="btn btn-sm btn-outline-secondary" type="button"><i class="bi bi-chevron-left"></i></button>
        <span id="hist-pager-label">Página 1</span>
        <button id="hist-pager-next" class="btn btn-sm btn-outline-secondary" type="button"><i class="bi bi-chevron-right"></i></button>
    </div>
</section>

<main class="board board--historial">
    <section class="board-column board-column--historial-timbrado">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-envelope-paper-fill"></i> Historial de Timbrado</span>
            <span id="count-historial-timbrado" class="board-column__count">0</span>
        </header>
        <div class="board-column__body board-column__body--table">
            <table class="table table-sm table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Autorizó</th>
                        <th>Empresa</th>
                        <th>Solicitado</th>
                        <th>Resuelto</th>
                        <th>Estado</th>
                        <th>Complemento Carta Porte</th>
                    </tr>
                </thead>
                <tbody id="tabla-historial-timbrado"></tbody>
            </table>
            <div id="historial-timbrado-empty" class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>No hay historial de Timbrado con los filtros actuales</p>
            </div>
        </div>
    </section>

    <section class="board-column board-column--historial-liberacion">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-inbox-fill"></i> Historial de Liberación</span>
            <span id="count-historial-liberacion" class="board-column__count">0</span>
        </header>
        <div class="board-column__body board-column__body--table">
            <table class="table table-sm table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Autorizó</th>
                        <th>Empresa</th>
                        <th>Solicitado</th>
                        <th>Resuelto</th>
                        <th>Resolvió</th>
                        <th>Estado</th>
                        <th>Motivo</th>
                    </tr>
                </thead>
                <tbody id="tabla-historial-liberacion"></tbody>
            </table>
            <div id="historial-liberacion-empty" class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>No hay historial de Liberación con los filtros actuales</p>
            </div>
        </div>
    </section>
</main>

</section>

<script id="initial-solicitudes" type="application/json"><?= json_encode($solicitudesIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-solicitudes-timbrado" type="application/json"><?= json_encode($timbradoIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-kpis" type="application/json"><?= json_encode($kpisIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script>
    const WS_PORT = <?= $websocketPort ?>;
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/assets/js/facturacion.js" type="module"></script>
</body>
</html>
