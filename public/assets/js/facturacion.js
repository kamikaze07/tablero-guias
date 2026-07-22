const tablaSolicitudesEl = document.getElementById('tabla-solicitudes');
const solicitudesEmptyEl = document.getElementById('solicitudes-empty');
const countSolicitudesEl = document.getElementById('count-solicitudes');

const tablaSolicitudesTimbradoEl = document.getElementById('tabla-solicitudes-timbrado');
const solicitudesTimbradoEmptyEl = document.getElementById('solicitudes-timbrado-empty');
const countSolicitudesTimbradoEl = document.getElementById('count-solicitudes-timbrado');

const tablaPorTimbrarEl = document.getElementById('tabla-por-timbrar');
const porTimbrarEmptyEl = document.getElementById('por-timbrar-empty');
const countPorTimbrarEl = document.getElementById('count-por-timbrar');

const wsStatusEl = document.getElementById('ws-status');
const engineStatusEl = document.getElementById('engine-status');

const activityLogEl = document.getElementById('activity-log');
const activityEntriesEl = activityLogEl.querySelector('.activity-panel__entries');

const ACTIVITY_LOG_LIMIT = 20;
const ACTOR_STORAGE_KEY = 'atlas.facturacion.actor';

const ESTADO_LABELS = {
    PENDIENTE: { label: 'Pendiente', clase: 'badge text-bg-warning' },
    APROBADA: { label: 'Aprobada', clase: 'badge text-bg-info' },
    RECHAZADA: { label: 'Rechazada', clase: 'badge text-bg-secondary' },
    EJECUTANDO: { label: 'Ejecutando', clase: 'badge text-bg-primary' },
    COMPLETADA: { label: 'Completada', clase: 'badge text-bg-success' },
    ERROR: { label: 'Error', clase: 'badge text-bg-danger' },
    ESPERANDO_TIMBRADO: { label: 'Esperando timbrado', clase: 'badge text-bg-primary' },
    TIMBRADO: { label: 'Timbrado', clase: 'badge text-bg-success' },
};

const ACTIVITY_TYPES = {
    solicitada: { icon: 'bi-inbox-fill', label: 'Solicitud recibida' },
    aprobada: { icon: 'bi-check-circle-fill', label: 'Solicitud aprobada' },
    rechazada: { icon: 'bi-x-circle-fill', label: 'Solicitud rechazada' },
    ejecutando: { icon: 'bi-gear-fill', label: 'Ejecutando en SICRET' },
    completada: { icon: 'bi-receipt', label: 'Liberación confirmada' },
    error: { icon: 'bi-exclamation-triangle-fill', label: 'Error en liberación' },
    timbrado_solicitado: { icon: 'bi-envelope-paper-fill', label: 'Timbrado solicitado' },
    timbrado_aprobado: { icon: 'bi-check-all', label: 'Timbrado aprobado' },
    timbrado_rechazado: { icon: 'bi-x-square-fill', label: 'Timbrado rechazado' },
    timbrado_completado: { icon: 'bi-receipt', label: 'Timbrado confirmado en SICRET' },
};

function escapeHtml(value) {
    return String(value ?? '').replace(/[&<>"']/g, (ch) => ({
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#39;',
    }[ch]));
}

function formatFecha(value) {
    if (!value) {
        return '—';
    }

    const date = new Date(String(value).replace(' ', 'T'));

    if (Number.isNaN(date.getTime())) {
        return escapeHtml(value);
    }

    return escapeHtml(date.toLocaleString('es-MX', { dateStyle: 'short', timeStyle: 'short' }));
}

function formatEspera(minutos) {
    if (minutos === null || minutos === undefined) {
        return '—';
    }

    if (minutos < 60) {
        return `${minutos} min`;
    }

    const horas = Math.floor(minutos / 60);
    const resto = minutos % 60;

    return `${horas} h ${resto} min`;
}

function claseEspera(minutos) {
    if (minutos === null || minutos === undefined) {
        return '';
    }

    if (minutos >= 60) {
        return 'espera-critica';
    }

    if (minutos >= 30) {
        return 'espera-atencion';
    }

    return '';
}

function empresaLabel(source) {
    const value = String(source ?? '').toLowerCase();

    return value.includes('gero') ? 'GERO' : 'FORSIS';
}

function setTextWithBump(el, value) {
    const newText = String(value);

    if (el.textContent === newText) {
        return;
    }

    el.textContent = newText;
    el.classList.remove('bump');
    void el.offsetWidth;
    el.classList.add('bump');
}

function getActor() {
    return document.getElementById('filtro-actor').value.trim() || null;
}

function getFiltros() {
    return {
        estado: document.getElementById('filtro-estado').value,
        empresa: document.getElementById('filtro-empresa').value,
        operador: document.getElementById('filtro-operador').value.trim(),
        num_guia: document.getElementById('filtro-num-guia').value.trim(),
        desde: document.getElementById('filtro-desde').value,
        hasta: document.getElementById('filtro-hasta').value,
        sort: document.getElementById('ordenar-por').value,
        dir: document.getElementById('ordenar-dir').dataset.dir,
    };
}

function buildQuery(params) {
    const query = new URLSearchParams();

    Object.entries(params).forEach(([key, value]) => {
        if (value !== null && value !== undefined && value !== '') {
            query.set(key, value);
        }
    });

    return query.toString();
}

function renderSolicitudes(payload) {
    const filas = payload.data ?? [];

    tablaSolicitudesEl.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        tr.className = claseEspera(fila.tiempo_espera_minutos);
        tr.dataset.solicitudId = fila.solicitud_id;

        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };
        const esPendiente = fila.estado === 'PENDIENTE';

        const accionesHtml = esPendiente
            ? `
                <button class="btn btn-sm btn-success btn-aprobar" data-id="${fila.solicitud_id}" data-guia="${escapeHtml(fila.num_guia)}">
                    <i class="bi bi-check-lg"></i> Aceptar
                </button>
                <button class="btn btn-sm btn-outline-danger btn-rechazar" data-id="${fila.solicitud_id}" data-guia="${escapeHtml(fila.num_guia)}">
                    <i class="bi bi-x-lg"></i> Rechazar
                </button>
            `
            : (fila.error_reason ? `<span class="text-danger small" title="${escapeHtml(fila.error_reason)}"><i class="bi bi-info-circle"></i> ver error</span>` : '—');

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong><div class="text-muted small">Lote #${fila.solicitud_id}</div></td>
            <td>${escapeHtml(fila.autorizo)}</td>
            <td>${escapeHtml(fila.operador)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.fecha)}</td>
            <td class="motivo-col" title="${escapeHtml(fila.motivo)}">${escapeHtml(fila.motivo)}</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td>${formatEspera(fila.tiempo_espera_minutos)}</td>
            <td class="acciones-col">${accionesHtml}</td>
        `;

        tablaSolicitudesEl.appendChild(tr);
    });

    setTextWithBump(countSolicitudesEl, filas.length);
    solicitudesEmptyEl.classList.toggle('is-visible', filas.length === 0);

    tablaSolicitudesEl.querySelectorAll('.btn-aprobar').forEach((btn) => {
        btn.addEventListener('click', () => aprobar(Number(btn.dataset.id)));
    });

    tablaSolicitudesEl.querySelectorAll('.btn-rechazar').forEach((btn) => {
        btn.addEventListener('click', () => abrirModalRechazar(Number(btn.dataset.id), btn.dataset.guia, 'liberacion'));
    });
}

function renderSolicitudesTimbrado(payload) {
    const filas = payload.data ?? [];

    tablaSolicitudesTimbradoEl.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        tr.dataset.solicitudId = fila.id;

        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };
        const esPendiente = fila.estado === 'PENDIENTE';

        const guiasCount = fila.total_guias || 0;

        const accionesHtml = esPendiente
            ? `
                <button class="btn btn-sm btn-success btn-aprobar-timbrado" data-id="${fila.id}" data-guia="Lote #${fila.id}">
                    <i class="bi bi-check-lg"></i> Aceptar
                </button>
                <button class="btn btn-sm btn-outline-danger btn-rechazar-timbrado" data-id="${fila.id}" data-guia="Lote #${fila.id}">
                    <i class="bi bi-x-lg"></i> Rechazar
                </button>
            ` : '—';

        tr.innerHTML = `
            <td><strong>#${fila.id}</strong></td>
            <td>${escapeHtml(fila.solicitante)}</td>
            <td>${formatFecha(fila.created_at)}</td>
            <td>${guiasCount} guía(s)</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td class="acciones-col">${accionesHtml}</td>
        `;

        tablaSolicitudesTimbradoEl.appendChild(tr);
    });

    setTextWithBump(countSolicitudesTimbradoEl, filas.length);
    solicitudesTimbradoEmptyEl.classList.toggle('is-visible', filas.length === 0);

    tablaSolicitudesTimbradoEl.querySelectorAll('.btn-aprobar-timbrado').forEach((btn) => {
        btn.addEventListener('click', () => aprobarTimbrado(Number(btn.dataset.id)));
    });

    tablaSolicitudesTimbradoEl.querySelectorAll('.btn-rechazar-timbrado').forEach((btn) => {
        btn.addEventListener('click', () => abrirModalRechazar(Number(btn.dataset.id), btn.dataset.guia, 'timbrado'));
    });
}

function renderPorTimbrar(payload) {
    const filas = payload.data ?? [];

    tablaPorTimbrarEl.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        const cfdiAnterior = fila.factimpresa ? escapeHtml(fila.factimpresa) : '—';
        const comentario = fila.comen_pre ? escapeHtml(fila.comen_pre) : '—';

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong></td>
            <td>${escapeHtml(fila.autorizo)}</td>
            <td>${escapeHtml(fila.operador)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.fecha)}</td>
            <td>${formatEspera(fila.tiempo_espera_minutos)}</td>
            <td>${cfdiAnterior}</td>
            <td>${comentario}</td>
        `;

        tablaPorTimbrarEl.appendChild(tr);
    });

    setTextWithBump(countPorTimbrarEl, filas.length);
    porTimbrarEmptyEl.classList.toggle('is-visible', filas.length === 0);
}

function renderKpis(kpis) {
    setTextWithBump(document.getElementById('kpi-pendientes'), kpis.pendientes);
    setTextWithBump(document.getElementById('kpi-aprobadas'), kpis.aprobadas_hoy);
    setTextWithBump(document.getElementById('kpi-rechazadas'), kpis.rechazadas_hoy);
    setTextWithBump(document.getElementById('kpi-por-timbrar'), kpis.guias_por_timbrar);
    setTextWithBump(document.getElementById('kpi-tiempo-espera'), kpis.tiempo_promedio_espera_minutos);
}

async function fetchSolicitudes() {
    const filtros = getFiltros();
    const query = buildQuery({
        estado: filtros.estado,
        empresa: filtros.empresa,
        operador: filtros.operador,
        num_guia: filtros.num_guia,
        desde: filtros.desde,
        hasta: filtros.hasta,
        sort: filtros.sort,
        dir: filtros.dir,
        perPage: 50,
    });

    const response = await fetch(`/api/facturacion-solicitudes.php?${query}`, { cache: 'no-store' });
    renderSolicitudes(await response.json());
}

async function fetchPorTimbrar() {
    const response = await fetch('/api/guias-liberadas.php?perPage=50', { cache: 'no-store' });
    renderPorTimbrar(await response.json());
}

async function fetchKpis() {
    const response = await fetch('/api/facturacion-kpis.php', { cache: 'no-store' });
    renderKpis(await response.json());
}

async function fetchSolicitudesTimbrado() {
    const filtros = getFiltros();
    const query = buildQuery({
        estado: filtros.estado,
        desde: filtros.desde,
        hasta: filtros.hasta,
        perPage: 50,
    });

    const response = await fetch(`/api/solicitudes-timbrado.php?${query}`, { cache: 'no-store' });
    renderSolicitudesTimbrado(await response.json());
}

function refreshAll() {
    fetchSolicitudes();
    fetchSolicitudesTimbrado();
    fetchPorTimbrar();
    fetchKpis();
}

async function aprobar(id) {
    const response = await fetch(`/api/solicitudes-liberacion.php?id=${id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ accion: 'aprobar', actor: getActor() }),
    });

    if (!response.ok) {
        const error = await response.json().catch(() => ({}));
        alert(`No se pudo aprobar: ${error.mensaje ?? response.statusText}`);

        return;
    }

    fetchSolicitudes();
    fetchKpis();
}

async function aprobarTimbrado(id) {
    const response = await fetch(`/api/solicitudes-timbrado.php?id=${id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ accion: 'aprobar', actor: getActor() }),
    });

    if (!response.ok) {
        const error = await response.json().catch(() => ({}));
        alert(`No se pudo aprobar: ${error.mensaje ?? response.statusText}`);
        return;
    }

    fetchSolicitudesTimbrado();
    fetchKpis();
}

let rechazarContexto = null;

function abrirModalRechazar(id, numGuia, tipo = 'liberacion') {
    rechazarContexto = { id, tipo };
    document.getElementById('modal-rechazar-guias').textContent = numGuia;
    document.getElementById('modal-rechazar-motivo').value = '';

    const modalEl = document.getElementById('modal-rechazar');
    bootstrap.Modal.getOrCreateInstance(modalEl).show();
}

async function confirmarRechazo() {
    if (!rechazarContexto) {
        return;
    }

    const motivo = document.getElementById('modal-rechazar-motivo').value.trim();

    if (motivo === '') {
        document.getElementById('modal-rechazar-motivo').classList.add('is-invalid');

        return;
    }

    const isTimbrado = rechazarContexto.tipo === 'timbrado';
    const endpoint = isTimbrado ? '/api/solicitudes-timbrado.php' : '/api/solicitudes-liberacion.php';

    const response = await fetch(`${endpoint}?id=${rechazarContexto.id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ accion: 'rechazar', actor: getActor(), motivo }),
    });

    if (!response.ok) {
        const error = await response.json().catch(() => ({}));
        alert(`No se pudo rechazar: ${error.mensaje ?? response.statusText}`);

        return;
    }

    bootstrap.Modal.getInstance(document.getElementById('modal-rechazar'))?.hide();
    rechazarContexto = null;

    if (isTimbrado) {
        fetchSolicitudesTimbrado();
    } else {
        fetchSolicitudes();
    }
    fetchKpis();
}

function addActivityEntry(type, detalle) {
    const meta = ACTIVITY_TYPES[type] ?? ACTIVITY_TYPES.solicitada;
    const entry = document.createElement('div');
    entry.className = `activity-entry activity-entry--${type}`;

    const time = new Date().toLocaleTimeString('es-MX', { hour12: false });

    entry.innerHTML = `
        <i class="bi ${meta.icon} activity-entry__icon"></i>
        <div class="activity-entry__body">
            <span class="activity-entry__time">${escapeHtml(time)}</span>
            <span class="activity-entry__label">${escapeHtml(meta.label)}</span>
            <span class="activity-entry__pr">${escapeHtml(detalle)}</span>
        </div>
    `;

    activityEntriesEl.prepend(entry);

    while (activityEntriesEl.children.length > ACTIVITY_LOG_LIMIT) {
        activityEntriesEl.lastElementChild.remove();
    }

    activityLogEl.classList.remove('is-empty');
}

function resumenGuias(guias) {
    return (guias ?? []).map((g) => g.num_guia).join(', ') || `solicitud`;
}

function handleMessage(event) {
    const message = JSON.parse(event.data);

    switch (message.event) {
        case 'guia.liberacion_solicitada':
            addActivityEntry('solicitada', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'solicitud_liberacion.aprobada':
            addActivityEntry('aprobada', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'solicitud_liberacion.rechazada':
            addActivityEntry('rechazada', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'guia.liberacion_ejecutando':
            addActivityEntry('ejecutando', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'guia.liberacion_completada':
            addActivityEntry('completada', `solicitud #${message.payload.solicitud_id}`);
            refreshAll();
            break;
        case 'guia.liberacion_error':
            addActivityEntry('error', message.payload.motivo ?? `solicitud #${message.payload.solicitud_id}`);
            refreshAll();
            break;
        case 'guia.timbrado_solicitado':
            addActivityEntry('timbrado_solicitado', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'solicitud_timbrado.aprobada':
            addActivityEntry('timbrado_aprobado', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'solicitud_timbrado.rechazada':
            addActivityEntry('timbrado_rechazado', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        case 'guia.timbrado_completado':
            addActivityEntry('timbrado_completado', resumenGuias(message.payload.guias));
            refreshAll();
            break;
        default:
            // Eventos de otros tableros (p. ej. guia.detectada) — se ignoran aquí.
            break;
    }
}

function setWsStatus(state) {
    if (state === 'ok') {
        wsStatusEl.className = 'status-pill status-pill--ok';
        wsStatusEl.innerHTML = '<i class="bi bi-wifi"></i> En vivo';
    } else if (state === 'down') {
        wsStatusEl.className = 'status-pill status-pill--down';
        wsStatusEl.innerHTML = '<i class="bi bi-wifi-off"></i> Desconectado — reintentando…';
    } else {
        wsStatusEl.className = 'status-pill status-pill--pending';
        wsStatusEl.innerHTML = '<i class="bi bi-wifi"></i> Conectando…';
    }
}

function connect() {
    setWsStatus('pending');

    const socket = new WebSocket(`ws://${window.location.hostname}:${WS_PORT}`);

    socket.addEventListener('open', () => setWsStatus('ok'));
    socket.addEventListener('message', handleMessage);

    socket.addEventListener('close', () => {
        setWsStatus('down');
        setTimeout(connect, 2000);
    });

    socket.addEventListener('error', () => socket.close());
}

function setEngineStatus(active) {
    if (active) {
        engineStatusEl.className = 'status-pill status-pill--ok';
        engineStatusEl.innerHTML = '<i class="bi bi-cpu-fill"></i> Motor de Liberación activo';
    } else {
        engineStatusEl.className = 'status-pill status-pill--down';
        engineStatusEl.innerHTML = '<i class="bi bi-cpu"></i> Motor de Liberación inactivo';
    }
}

async function refreshEngineStatus() {
    try {
        const response = await fetch('/api/heartbeat.php?engine=monitoring-engine', { cache: 'no-store' });
        const data = await response.json();
        setEngineStatus(Boolean(data.active));
    } catch {
        setEngineStatus(false);
    }
}

function tickClock() {
    const now = new Date();

    document.getElementById('clock-date').textContent = now.toLocaleDateString('es-MX', {
        weekday: 'long',
        day: 'numeric',
        month: 'long',
        year: 'numeric',
    });

    document.getElementById('clock-time').textContent = now.toLocaleTimeString('es-MX', { hour12: false });
}

// --- Inicialización ---

const actorGuardado = localStorage.getItem(ACTOR_STORAGE_KEY);

if (actorGuardado) {
    document.getElementById('filtro-actor').value = actorGuardado;
}

document.getElementById('filtro-actor').addEventListener('change', (evt) => {
    localStorage.setItem(ACTOR_STORAGE_KEY, evt.target.value.trim());
});

// filtro-estado y filtro-desde/hasta son compartidos por las tablas de
// Liberación y de Timbrado (ver getFiltros()) — deben refrescar ambas, o
// la tabla de Timbrado se queda mostrando los resultados del filtro
// anterior (encontrado al validar el filtro "Timbradas" de punta a punta).
['filtro-estado', 'filtro-empresa', 'filtro-operador', 'filtro-num-guia', 'filtro-desde', 'filtro-hasta', 'ordenar-por'].forEach((id) => {
    document.getElementById(id).addEventListener('change', () => {
        fetchSolicitudes();
        fetchSolicitudesTimbrado();
    });
});

document.getElementById('filtro-num-guia').addEventListener('keyup', (evt) => {
    if (evt.key === 'Enter') {
        fetchSolicitudes();
        fetchSolicitudesTimbrado();
    }
});

document.getElementById('ordenar-dir').addEventListener('click', (evt) => {
    const btn = evt.currentTarget;
    const nuevaDir = btn.dataset.dir === 'ASC' ? 'DESC' : 'ASC';
    btn.dataset.dir = nuevaDir;
    btn.querySelector('i').className = nuevaDir === 'ASC' ? 'bi bi-sort-up' : 'bi bi-sort-down';
    fetchSolicitudes();
    fetchSolicitudesTimbrado();
});

document.getElementById('modal-rechazar-confirmar').addEventListener('click', confirmarRechazo);
document.getElementById('modal-rechazar-motivo').addEventListener('input', (evt) => {
    evt.target.classList.remove('is-invalid');
});

activityLogEl.classList.add('is-empty');

renderSolicitudes(JSON.parse(document.getElementById('initial-solicitudes').textContent || '{"data":[]}'));
renderSolicitudesTimbrado(JSON.parse(document.getElementById('initial-solicitudes-timbrado').textContent || '{"data":[]}'));
renderPorTimbrar(JSON.parse(document.getElementById('initial-por-timbrar').textContent || '{"data":[]}'));
renderKpis(JSON.parse(document.getElementById('initial-kpis').textContent || '{}'));

tickClock();
setInterval(tickClock, 1000);

refreshEngineStatus();
setInterval(refreshEngineStatus, 5000);

connect();
