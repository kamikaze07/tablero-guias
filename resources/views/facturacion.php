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
        <span id="ws-status" class="status-pill status-pill--pending">
            <i class="bi bi-wifi"></i> Conectando…
        </span>
        <span id="engine-status" class="status-pill status-pill--pending">
            <i class="bi bi-cpu"></i> Motor de Liberación: verificando…
        </span>
    </div>
</header>

<section class="kpi-bar kpi-bar--facturacion">
    <div class="kpi-card kpi-card--pendiente">
        <i class="bi bi-hourglass-split kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-pendientes" class="kpi-card__value"><?= (int) $kpisIniciales['pendientes'] ?></span>
            <span class="kpi-card__label">Solicitudes pendientes</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--exito">
        <i class="bi bi-check-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-aprobadas" class="kpi-card__value"><?= (int) $kpisIniciales['aprobadas_hoy'] ?></span>
            <span class="kpi-card__label">Aprobadas hoy</span>
        </div>
    </div>
    <div class="kpi-card kpi-card--error">
        <i class="bi bi-x-circle-fill kpi-card__icon"></i>
        <div class="kpi-card__text">
            <span id="kpi-rechazadas" class="kpi-card__value"><?= (int) $kpisIniciales['rechazadas_hoy'] ?></span>
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
            <span id="kpi-tiempo-espera" class="kpi-card__value"><?= (float) $kpisIniciales['tiempo_promedio_espera_minutos'] ?></span>
            <span class="kpi-card__label">Min. promedio de espera</span>
        </div>
    </div>
</section>

<section class="filters-bar">
    <input id="filtro-actor" class="form-control form-control-sm" type="text" placeholder="Tu nombre (para aprobar/rechazar)" autocomplete="off">
    <select id="filtro-estado" class="form-select form-select-sm">
        <option value="PENDIENTE" selected>Pendientes</option>
        <option value="APROBADA">Aprobadas</option>
        <option value="RECHAZADA">Rechazadas</option>
        <option value="EJECUTANDO">Ejecutando</option>
        <option value="COMPLETADA">Completadas</option>
        <option value="ERROR">Con error</option>
        <option value="ESPERANDO_TIMBRADO">Esperando timbrado</option>
        <option value="TIMBRADO">Timbradas</option>
        <option value="">Todos los estados</option>
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
        <option value="fecha">Ordenar por fecha</option>
        <option value="tiempo_espera">Ordenar por tiempo esperando</option>
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
        <div class="board-column__body board-column__body--table">
            <table class="table table-sm table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Solicitante</th>
                        <th>Fecha</th>
                        <th>Guías</th>
                        <th>Estado</th>
                        <th>Acciones</th>
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
        <div class="board-column__body board-column__body--table">
            <table class="table table-sm table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Autorizó</th>
                        <th>Operador</th>
                        <th>Empresa</th>
                        <th>Fecha</th>
                        <th>Motivo</th>
                        <th>Estado</th>
                        <th>Esperando</th>
                        <th>Acciones</th>
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

    <section class="board-column board-column--por-timbrar">
        <header class="board-column__header">
            <span class="board-column__title"><i class="bi bi-receipt"></i> Por Timbrar</span>
            <span id="count-por-timbrar" class="board-column__count">0</span>
        </header>
        <div class="board-column__note">
            <i class="bi bi-info-circle"></i>
            Este panel muestra exclusivamente las guías que ya han concluido su proceso de liberación y están listas para facturación.
        </div>
        <div class="board-column__body board-column__body--table">
            <table class="table table-sm table-dark table-hover align-middle mb-0">
                <thead>
                    <tr>
                        <th>Guía</th>
                        <th>Autorizó</th>
                        <th>Operador</th>
                        <th>Empresa</th>
                        <th>Fecha</th>
                        <th>Esperando</th>
                        <th>CFDI anterior</th>
                        <th>Comentario</th>
                    </tr>
                </thead>
                <tbody id="tabla-por-timbrar"></tbody>
            </table>
            <div id="por-timbrar-empty" class="board-column__empty">
                <i class="bi bi-inbox"></i>
                <p>No hay guías pendientes de timbrar en este momento</p>
            </div>
        </div>
    </section>

    <aside class="activity-panel">
        <header class="activity-panel__header">
            <span class="activity-panel__title"><i class="bi bi-activity"></i> Actividad Reciente</span>
        </header>
        <div id="activity-log" class="activity-panel__body">
            <div class="activity-panel__empty">
                <i class="bi bi-clock-history"></i>
                <p>No hay actividad reciente</p>
            </div>
            <div class="activity-panel__entries"></div>
        </div>
    </aside>
</main>

<div class="modal fade" id="modal-rechazar" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"><i class="bi bi-x-circle"></i> Rechazar solicitud</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p class="mb-2">Folio(s): <strong id="modal-rechazar-guias"></strong></p>
                <label for="modal-rechazar-motivo" class="form-label">Motivo del rechazo (obligatorio)</label>
                <textarea id="modal-rechazar-motivo" class="form-control" rows="3" required></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" id="modal-rechazar-confirmar" class="btn btn-danger">Confirmar rechazo</button>
            </div>
        </div>
    </div>
</div>

<script id="initial-solicitudes" type="application/json"><?= json_encode($solicitudesIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-solicitudes-timbrado" type="application/json"><?= json_encode($timbradoIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-por-timbrar" type="application/json"><?= json_encode($porTimbrarInicial, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script id="initial-kpis" type="application/json"><?= json_encode($kpisIniciales, JSON_UNESCAPED_UNICODE | JSON_HEX_TAG) ?></script>
<script>
    const WS_PORT = <?= $websocketPort ?>;
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/assets/js/facturacion.js" type="module"></script>
</body>
</html>
