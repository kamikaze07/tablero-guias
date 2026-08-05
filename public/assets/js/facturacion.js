import SoundManager from './sound-manager.js';

const soundManager = new SoundManager();

const tablaSolicitudesEl = document.getElementById('tabla-solicitudes');
const solicitudesEmptyEl = document.getElementById('solicitudes-empty');
const countSolicitudesEl = document.getElementById('count-solicitudes');

const tablaSolicitudesTimbradoEl = document.getElementById('tabla-solicitudes-timbrado');
const solicitudesTimbradoEmptyEl = document.getElementById('solicitudes-timbrado-empty');
const countSolicitudesTimbradoEl = document.getElementById('count-solicitudes-timbrado');

const wsStatusEl = document.getElementById('ws-status');
const engineStatusEl = document.getElementById('engine-status');

// Menos filas por página a propósito (antes 50): con filas más altas y
// fuente más grande (ver facturacion.css), 50 obligaba a scroll constante
// para ver las solicitudes activas de Timbrado/Liberación.
const PANEL_SOLICITUDES_PER_PAGE = 15;

// Alerta de solicitudes desatendidas (letrero + sonido) — mismo umbral
// para las dos etapas: "pendiente sin aceptar" (created_at) y "aceptada
// sin atender" (resolved_at, mientras el estado siga en progreso). Se
// revisa cada ALERTA_INTERVALO_MS, y mientras haya algo que alertar sonará
// en cada tick (repetición a propósito, no solo una vez).
const ALERTA_UMBRAL_MINUTOS = 7;
const ALERTA_INTERVALO_MS = 10000;

// Estados "aceptada pero todavía en progreso" por flujo — nunca se alerta
// sobre algo ya resuelto (RECHAZADA/COMPLETADA/TIMBRADO), mismo criterio
// que ya usa App\Dashboard\GuiaBoardRepository::boardState() en el backend.
const ESTADOS_ACEPTADA_LIBERACION = ['APROBADA', 'EJECUTANDO'];
const ESTADOS_ACEPTADA_TIMBRADO = ['ESPERANDO_TIMBRADO'];

// Última respuesta cruda de cada panel de "Solicitudes" — el timer de la
// alerta necesita re-evaluar el tiempo transcurrido cada 10s aunque no
// haya llegado ningún evento nuevo por WebSocket, así que no puede
// depender del DOM ya renderizado (los badges no cargan created_at/
// resolved_at) ni esperar a refreshAll().
let datosSolicitudesLiberacion = [];
let datosSolicitudesTimbrado = [];

const ESTADO_LABELS = {
    PENDIENTE: { label: 'Pendiente', clase: 'badge text-bg-warning' },
    POR_TIMBRAR: { label: 'Por timbrar', clase: 'badge text-bg-primary' },
    APROBADA: { label: 'Aprobada', clase: 'badge text-bg-info' },
    RECHAZADA: { label: 'Rechazada', clase: 'badge text-bg-secondary' },
    EJECUTANDO: { label: 'Ejecutando', clase: 'badge text-bg-primary' },
    COMPLETADA: { label: 'Completada', clase: 'badge text-bg-success' },
    ERROR: { label: 'Error', clase: 'badge text-bg-danger' },
    ESPERANDO_TIMBRADO: { label: 'Esperando timbrado', clase: 'badge text-bg-primary' },
    TIMBRADO: { label: 'Timbrado', clase: 'badge text-bg-success' },
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

// Celda de contenedor compartida por ambos paneles de solicitudes — no
// toda guía trae uno (ver App\Liberacion\ContenedorLookup).
function celdaContenedor(contenedor) {
    return contenedor
        ? `<strong>${escapeHtml(contenedor)}</strong>`
        : '<span class="text-muted">—</span>';
}

// Celda de operador con el solicitante como sub-línea pequeña — antes
// "Autorizó" tenía su propia columna ancha; el PR y el Contenedor son más
// relevantes para decidir, así que el solicitante se compacta aquí.
function celdaOperadorConSolicitante(operador, autorizo) {
    const title = `${operador || '—'} (Solicitó: ${autorizo || '—'})`;
    return `<div class="operador-col" title="${escapeHtml(title)}">`
         + `<div class="operador-nombre">${escapeHtml(operador)}</div>`
         + `<div class="text-muted small operador-solicito">Solicitó: ${escapeHtml(autorizo)}</div>`
         + `</div>`;
}

// Celda de Cliente compartida por ambos paneles de solicitudes — no toda
// guía lo resuelve (ver App\Liberacion\ClienteLookup).
function celdaCliente(cliente) {
    return cliente
        ? `<span class="ruta-cliente-col" title="${escapeHtml(cliente)}">${escapeHtml(cliente)}</span>`
        : '<span class="text-muted">—</span>';
}

// Celda de Ruta (Origen → Destino, ya con localidad incluida — ver
// App\Timbrado\RutaLookup) compartida por ambos paneles de solicitudes.
function celdaRuta(origen, destino) {
    if (!origen && !destino) {
        return '<span class="text-muted">—</span>';
    }

    const texto = `${origen || 'N/A'} → ${destino || 'N/A'}`;

    return `<span class="ruta-cliente-col" title="${escapeHtml(texto)}">${escapeHtml(texto)}</span>`;
}

function renderSolicitudes(payload) {
    const filas = payload.data ?? [];
    datosSolicitudesLiberacion = filas;

    tablaSolicitudesEl.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        tr.className = claseEspera(fila.tiempo_espera_minutos);
        tr.dataset.solicitudId = fila.solicitud_id;

        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };
        const detalleHtml = fila.error_reason
            ? `<span class="text-danger small" title="${escapeHtml(fila.error_reason)}"><i class="bi bi-info-circle"></i> ver error</span>`
            : '—';

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong><div class="text-muted small">Lote #${fila.solicitud_id}</div></td>
            <td>${celdaContenedor(fila.contenedor)}</td>
            <td>${celdaCliente(fila.cliente)}</td>
            <td>${celdaRuta(fila.ruta_origen, fila.ruta_destino)}</td>
            <td>${celdaOperadorConSolicitante(fila.operador, fila.autorizo)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.fecha)}</td>
            <td class="motivo-col" title="${escapeHtml(fila.motivo)}">${escapeHtml(fila.motivo)}</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td>${formatEspera(fila.tiempo_espera_minutos)}</td>
            <td>${detalleHtml}</td>
        `;

        tablaSolicitudesEl.appendChild(tr);
    });

    setTextWithBump(countSolicitudesEl, filas.length);
    solicitudesEmptyEl.classList.toggle('is-visible', filas.length === 0);
}

// Vista por guía (antes era por lote: #id/Solicitante/Fecha/Guías/Estado,
// sin mostrar el PR ni poder mostrar el Contenedor) — mismo endpoint
// aplanado que ya usa Liberación (App\Timbrado\SolicitudTimbradoService::
// listarConDetalleGuia()), para que el PR y el Contenedor de cada guía
// del lote sean lo primero que se ve.
function renderSolicitudesTimbrado(payload) {
    const filas = payload.data ?? [];
    datosSolicitudesTimbrado = filas;

    tablaSolicitudesTimbradoEl.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        tr.className = claseEspera(fila.tiempo_espera_minutos);
        tr.dataset.solicitudId = fila.solicitud_id;

        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong><div class="text-muted small">Lote #${fila.solicitud_id}</div></td>
            <td>${celdaContenedor(fila.contenedor)}</td>
            <td>${celdaCliente(fila.cliente)}</td>
            <td>${celdaRuta(fila.ruta_origen, fila.ruta_destino)}</td>
            <td>${celdaOperadorConSolicitante(fila.operador, fila.autorizo)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.fecha)}</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td>${formatEspera(fila.tiempo_espera_minutos)}</td>
        `;

        tablaSolicitudesTimbradoEl.appendChild(tr);
    });

    setTextWithBump(countSolicitudesTimbradoEl, filas.length);
    solicitudesTimbradoEmptyEl.classList.toggle('is-visible', filas.length === 0);
}

function renderKpis(kpis) {
    // Las 4 tarjetas genéricas ("Solicitudes pendientes", "Aprobadas hoy",
    // "Rechazadas hoy", "Min. promedio de espera") representan el tablero
    // completo de Facturación (Liberación + Timbrado), no solo Liberación —
    // ver App\Dashboard\FacturacionResumenKpis::combinar().
    const resumen = kpis.resumen ?? {};
    setTextWithBump(document.getElementById('kpi-pendientes'), resumen.pendientes ?? 0);
    setTextWithBump(document.getElementById('kpi-aprobadas'), resumen.aprobadas_hoy ?? 0);
    setTextWithBump(document.getElementById('kpi-rechazadas'), resumen.rechazadas_hoy ?? 0);
    setTextWithBump(document.getElementById('kpi-por-timbrar'), kpis.guias_por_timbrar ?? 0);
    setTextWithBump(document.getElementById('kpi-tiempo-espera'), resumen.tiempo_promedio_espera_minutos ?? 0);
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
        perPage: PANEL_SOLICITUDES_PER_PAGE,
    });

    const response = await fetch(`/api/facturacion-solicitudes.php?${query}`, { cache: 'no-store' });
    renderSolicitudes(await response.json());
}

async function fetchKpis() {
    const response = await fetch('/api/facturacion-kpis.php', { cache: 'no-store' });
    renderKpis(await response.json());
}

// --- Historial completo (pestaña separada del trabajo pendiente) ---

let currentView = 'pendiente';
let histPage = 1;
const HIST_PER_PAGE = 25;
let histTotalTimbrado = 0;
let histTotalLiberacion = 0;

function getHistFiltros() {
    return {
        estado: document.getElementById('hist-filtro-estado').value,
        empresa: document.getElementById('hist-filtro-empresa').value,
        operador: document.getElementById('hist-filtro-operador').value.trim(),
        num_guia: document.getElementById('hist-filtro-num-guia').value.trim(),
        desde: document.getElementById('hist-filtro-desde').value,
        hasta: document.getElementById('hist-filtro-hasta').value,
    };
}

async function descargarCartaPorte(numGuia, btn) {
    const textoOriginal = btn.innerHTML;
    btn.disabled = true;
    btn.innerHTML = '<i class="bi bi-hourglass-split"></i> Descargando…';

    try {
        const response = await fetch(`/api/timbrado-carta-porte.php?guia=${encodeURIComponent(numGuia)}`, { cache: 'no-store' });

        if (!response.ok) {
            const error = await response.json().catch(() => ({}));
            alert(error.mensaje ?? 'No se pudo descargar el Complemento Carta Porte.');

            return;
        }

        const blob = await response.blob();
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = `${numGuia}-carta-porte.pdf`;
        document.body.appendChild(a);
        a.click();
        a.remove();
        URL.revokeObjectURL(url);
    } finally {
        btn.disabled = false;
        btn.innerHTML = textoOriginal;
    }
}

function renderHistorialTimbrado(payload) {
    const filas = payload.data ?? [];
    histTotalTimbrado = payload.total ?? filas.length;

    const tabla = document.getElementById('tabla-historial-timbrado');
    tabla.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };

        const cartaPorteHtml = fila.factura_impresa
            ? `<button class="btn btn-sm btn-outline-info btn-descargar-cfdi" data-guia="${escapeHtml(fila.num_guia)}">
                   <i class="bi bi-file-earmark-pdf"></i> Descargar
               </button>`
            : '—';

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong></td>
            <td>${escapeHtml(fila.autorizo)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.created_at)}</td>
            <td>${formatFecha(fila.resolved_at)}</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td>${cartaPorteHtml}</td>
        `;

        tabla.appendChild(tr);
    });

    setTextWithBump(document.getElementById('count-historial-timbrado'), histTotalTimbrado);
    document.getElementById('historial-timbrado-empty').classList.toggle('is-visible', filas.length === 0);

    tabla.querySelectorAll('.btn-descargar-cfdi').forEach((btn) => {
        btn.addEventListener('click', () => descargarCartaPorte(btn.dataset.guia, btn));
    });
}

function renderHistorialLiberacion(payload) {
    const filas = payload.data ?? [];
    histTotalLiberacion = payload.total ?? filas.length;

    const tabla = document.getElementById('tabla-historial-liberacion');
    tabla.innerHTML = '';

    filas.forEach((fila) => {
        const tr = document.createElement('tr');
        const estadoInfo = ESTADO_LABELS[fila.estado] ?? { label: fila.estado, clase: 'badge text-bg-secondary' };
        const motivo = fila.motivo || fila.error_reason || '—';

        tr.innerHTML = `
            <td><strong>${escapeHtml(fila.num_guia)}</strong></td>
            <td>${escapeHtml(fila.autorizo)}</td>
            <td>${empresaLabel(fila.source)}</td>
            <td>${formatFecha(fila.created_at)}</td>
            <td>${formatFecha(fila.resolved_at)}</td>
            <td>${escapeHtml(fila.resolved_by ?? '—')}</td>
            <td><span class="${estadoInfo.clase}">${estadoInfo.label}</span></td>
            <td class="motivo-col" title="${escapeHtml(motivo)}">${escapeHtml(motivo)}</td>
        `;

        tabla.appendChild(tr);
    });

    setTextWithBump(document.getElementById('count-historial-liberacion'), histTotalLiberacion);
    document.getElementById('historial-liberacion-empty').classList.toggle('is-visible', filas.length === 0);
}

async function fetchHistorialTimbrado() {
    const filtros = getHistFiltros();
    const query = buildQuery({ ...filtros, page: histPage, perPage: HIST_PER_PAGE });

    const response = await fetch(`/api/facturacion-solicitudes-timbrado.php?${query}`, { cache: 'no-store' });
    renderHistorialTimbrado(await response.json());
}

async function fetchHistorialLiberacion() {
    const filtros = getHistFiltros();
    const query = buildQuery({ ...filtros, page: histPage, perPage: HIST_PER_PAGE });

    const response = await fetch(`/api/facturacion-solicitudes.php?${query}`, { cache: 'no-store' });
    renderHistorialLiberacion(await response.json());
}

function updateHistPagerLabel() {
    const totalPaginas = Math.max(1, Math.ceil(Math.max(histTotalTimbrado, histTotalLiberacion) / HIST_PER_PAGE));
    document.getElementById('hist-pager-label').textContent = `Página ${histPage} de ${totalPaginas}`;
    document.getElementById('hist-pager-prev').disabled = histPage <= 1;
    document.getElementById('hist-pager-next').disabled = histPage >= totalPaginas;
}

async function refreshHistorial() {
    await Promise.all([fetchHistorialTimbrado(), fetchHistorialLiberacion()]);
    updateHistPagerLabel();
}

function switchView(view) {
    currentView = view;

    document.getElementById('view-pendiente').style.display = view === 'pendiente' ? '' : 'none';
    document.getElementById('view-historial').style.display = view === 'historial' ? '' : 'none';

    document.getElementById('tab-pendiente').className = view === 'pendiente' ? 'btn btn-sm btn-primary' : 'btn btn-sm btn-outline-secondary';
    document.getElementById('tab-historial').className = view === 'historial' ? 'btn btn-sm btn-primary' : 'btn btn-sm btn-outline-secondary';

    if (view === 'historial') {
        refreshHistorial();
    }
}

async function fetchSolicitudesTimbrado() {
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
        perPage: PANEL_SOLICITUDES_PER_PAGE,
    });

    const response = await fetch(`/api/facturacion-solicitudes-timbrado.php?${query}`, { cache: 'no-store' });
    renderSolicitudesTimbrado(await response.json());
}

function refreshAll() {
    fetchSolicitudes();
    fetchSolicitudesTimbrado();
    fetchKpis();

    if (currentView === 'historial') {
        refreshHistorial();
    }
}

/**
 * "Ahora" en la misma hora de pared que usa el servidor para
 * created_at/resolved_at (America/Mexico_City — ver App\Config\Config),
 * pero etiquetado como si fuera UTC. Nunca lo es, pero como
 * minutosTranscurridos() hace la misma "mentira" en los dos extremos de
 * la resta, la DURACIÓN sigue siendo correcta sin importar en qué huso
 * horario esté configurado el navegador de quien mira el tablero — antes
 * `new Date("Y-m-d H:i:s")` se interpretaba como hora LOCAL del navegador,
 * dando minutos negativos o inflados si esa hora no era Mexico_City.
 */
function ahoraServidorComoInstante() {
    const partes = new Intl.DateTimeFormat('sv-SE', {
        timeZone: 'America/Mexico_City',
        year: 'numeric', month: '2-digit', day: '2-digit',
        hour: '2-digit', minute: '2-digit', second: '2-digit',
        hour12: false,
    }).format(new Date());

    return new Date(partes.replace(' ', 'T') + 'Z');
}

/**
 * Minutos transcurridos desde una fecha "Y-m-d H:i:s" (hora del servidor)
 * hasta ahora. null si la fecha no llegó (nunca debería pasar para
 * created_at, sí es normal para resolved_at de una solicitud que sigue
 * PENDIENTE).
 */
function minutosTranscurridos(fechaSql) {
    if (!fechaSql) {
        return null;
    }

    const fecha = new Date(String(fechaSql).replace(' ', 'T') + 'Z');

    if (Number.isNaN(fecha.getTime())) {
        return null;
    }

    return (ahoraServidorComoInstante().getTime() - fecha.getTime()) / 60000;
}

/**
 * Cuenta, dentro de un panel de "Solicitudes" (Timbrado o Liberación),
 * cuántas llevan más de ALERTA_UMBRAL_MINUTOS en cada una de las dos
 * etapas que pidió Facturación: pendientes sin aceptar (desde created_at)
 * y ya aceptadas pero sin atender (desde resolved_at, solo mientras el
 * estado siga en progreso — nunca sobre algo ya resuelto).
 */
function contarVencidas(filas, estadosAceptada) {
    let pendientes = 0;
    let aceptadas = 0;

    filas.forEach((fila) => {
        if (fila.estado === 'PENDIENTE') {
            const minutos = minutosTranscurridos(fila.created_at);

            if (minutos !== null && minutos >= ALERTA_UMBRAL_MINUTOS) {
                pendientes += 1;
            }
        } else if (estadosAceptada.includes(fila.estado)) {
            const minutos = minutosTranscurridos(fila.resolved_at);

            if (minutos !== null && minutos >= ALERTA_UMBRAL_MINUTOS) {
                aceptadas += 1;
            }
        }
    });

    return { pendientes, aceptadas };
}

/**
 * Revisa ambos paneles y muestra/oculta el letrero de alerta. A propósito
 * se llama cada ALERTA_INTERVALO_MS (10s) sin importar si hubo un evento
 * nuevo — el paso del tiempo por sí solo puede hacer que una solicitud
 * cruce el umbral, y antes de esto nada recalculaba tiempo_espera sin un
 * evento de WebSocket de por medio. Mientras haya algo que alertar, el
 * sonido se repite en cada tick (a propósito, para que sea difícil de
 * ignorar) — deja de sonar solo cuando ya no hay nada vencido.
 */
function evaluarAlertaDesatendidas() {
    const liberacion = contarVencidas(datosSolicitudesLiberacion, ESTADOS_ACEPTADA_LIBERACION);
    const timbrado = contarVencidas(datosSolicitudesTimbrado, ESTADOS_ACEPTADA_TIMBRADO);

    const totalPendientes = liberacion.pendientes + timbrado.pendientes;
    const totalAceptadas = liberacion.aceptadas + timbrado.aceptadas;

    const banner = document.getElementById('alerta-desatendidas');
    const texto = document.getElementById('alerta-desatendidas-texto');

    if (totalPendientes + totalAceptadas === 0) {
        banner.classList.add('is-hidden');
        return;
    }

    const partes = [];

    if (totalPendientes > 0) {
        partes.push(`${totalPendientes} sin aceptar`);
    }

    if (totalAceptadas > 0) {
        partes.push(`${totalAceptadas} aceptada(s) sin atender`);
    }

    texto.textContent = `${partes.join(' · ')} — llevan más de ${ALERTA_UMBRAL_MINUTOS} min`;
    banner.classList.remove('is-hidden');
    soundManager.playStampError();
}

function handleMessage(event) {
    const message = JSON.parse(event.data);

    switch (message.event) {
        case 'guia.liberacion_solicitada':
            soundManager.playReleaseRequested();
            refreshAll();
            break;
        case 'solicitud_liberacion.aprobada':
            soundManager.playStampSuccess();
            refreshAll();
            break;
        case 'solicitud_liberacion.rechazada':
            soundManager.playStampError();
            refreshAll();
            break;
        case 'guia.liberacion_ejecutando':
            refreshAll();
            break;
        case 'guia.liberacion_completada':
            soundManager.playStampSuccess();
            refreshAll();
            break;
        case 'guia.liberacion_error':
            soundManager.playStampError();
            refreshAll();
            break;
        case 'guia.timbrado_solicitado':
            soundManager.playReleaseRequested();
            refreshAll();
            break;
        case 'solicitud_timbrado.aprobada':
            soundManager.playStampSuccess();
            refreshAll();
            break;
        case 'solicitud_timbrado.rechazada':
            soundManager.playStampError();
            refreshAll();
            break;
        case 'guia.timbrado_completado':
            soundManager.playStampSuccess();
            refreshAll();
            break;
        case 'guia.timbrado_concluido':
            // Confirmación definitiva vía App\Monitoring\Timbrado\
            // TimbradoConclusionWatcher — una solicitud puede llegar a
            // CONCLUIDA sin pasar nunca por TIMBRADO (ver docblock de
            // TimbradoConclusionEvidenceSource::buscar()), así que este
            // evento es, para esos casos, la única señal de que ya
            // terminó. Sin este case el tablero se quedaba mostrando el
            // estado anterior indefinidamente.
            soundManager.playStampSuccess();
            refreshAll();
            break;
        case 'dashboard.reset_diario':
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

document.getElementById('tab-pendiente').addEventListener('click', () => switchView('pendiente'));
document.getElementById('tab-historial').addEventListener('click', () => switchView('historial'));

['hist-filtro-estado', 'hist-filtro-empresa', 'hist-filtro-operador', 'hist-filtro-num-guia', 'hist-filtro-desde', 'hist-filtro-hasta'].forEach((id) => {
    document.getElementById(id).addEventListener('change', () => {
        histPage = 1;
        refreshHistorial();
    });
});

document.getElementById('hist-filtro-num-guia').addEventListener('keyup', (evt) => {
    if (evt.key === 'Enter') {
        histPage = 1;
        refreshHistorial();
    }
});

document.getElementById('hist-pager-prev').addEventListener('click', () => {
    if (histPage > 1) {
        histPage -= 1;
        refreshHistorial();
    }
});

document.getElementById('hist-pager-next').addEventListener('click', () => {
    histPage += 1;
    refreshHistorial();
});

renderSolicitudes(JSON.parse(document.getElementById('initial-solicitudes').textContent || '{"data":[]}'));
renderSolicitudesTimbrado(JSON.parse(document.getElementById('initial-solicitudes-timbrado').textContent || '{"data":[]}'));
renderKpis(JSON.parse(document.getElementById('initial-kpis').textContent || '{}'));

tickClock();
setInterval(tickClock, 1000);

refreshEngineStatus();
setInterval(refreshEngineStatus, 5000);

evaluarAlertaDesatendidas();
setInterval(evaluarAlertaDesatendidas, ALERTA_INTERVALO_MS);

connect();
