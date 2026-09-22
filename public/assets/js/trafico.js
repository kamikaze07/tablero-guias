import SoundManager from './sound-manager.js';
import { logoForSource } from './logo-source.js';
import { watchHeartbeat } from './heartbeat-status.js';

const panels = {
    generadas: {
        cardsEl: document.querySelector('#panel-generadas .board-column__cards'),
        bodyEl: document.getElementById('panel-generadas'),
        countEl: document.getElementById('count-generadas'),
    },
    liberacion: {
        cardsEl: document.querySelector('#panel-liberacion .board-column__cards'),
        bodyEl: document.getElementById('panel-liberacion'),
        countEl: document.getElementById('count-liberacion'),
    },
    solicitudes_timbrado: {
        cardsEl: document.querySelector('#panel-solicitudes-timbrado .board-column__cards'),
        bodyEl: document.getElementById('panel-solicitudes-timbrado'),
        countEl: document.getElementById('count-solicitudes-timbrado'),
    },
    timbrado: {
        cardsEl: document.querySelector('#panel-timbrado .board-column__cards'),
        bodyEl: document.getElementById('panel-timbrado'),
        countEl: document.getElementById('count-timbrado'),
    },
};

const wsStatusEl = document.getElementById('ws-status');
const engineStatusEl = document.getElementById('engine-status');

const NEW_CARD_HIGHLIGHT_MS = 5000;

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
    const date = new Date(String(value).replace(' ', 'T'));

    if (Number.isNaN(date.getTime())) {
        return escapeHtml(value);
    }

    return escapeHtml(date.toLocaleString('es-MX', { dateStyle: 'short', timeStyle: 'short' }));
}

function setTextWithBump(el, value) {
    const newText = String(value);

    if (el.textContent === newText) {
        return;
    }

    el.textContent = newText;
    el.classList.remove('bump');
    void el.offsetWidth; // reinicia la animación aunque se repita el mismo valor
    el.classList.add('bump');
}

function buildCard(guia, accent) {
    const card = document.createElement('article');
    card.className = `guia-card guia-card--${accent}`;
    card.dataset.guiaId = guia.id;

    const logo = logoForSource(guia.source);
    const clienteText = escapeHtml(guia.nombre);

    const operadorHtml = guia.operador
        ? `<div class="guia-card__operador" title="${escapeHtml(guia.operador)}"><i class="bi bi-person-badge"></i>${escapeHtml(guia.operador)}</div>`
        : '';

    // No toda guía trae contenedor (ver App\Liberacion\ContenedorLookup) —
    // se omite el renglón entero cuando no aplica en vez de mostrarlo vacío.
    const contenedorHtml = guia.contenedor
        ? `<div class="guia-card__contenedor" title="${escapeHtml(guia.contenedor)}"><i class="bi bi-box-seam"></i>${escapeHtml(guia.contenedor)}</div>`
        : '';

    card.innerHTML = `
        <img class="guia-card__logo guia-card__logo--${logo.modifier}" src="${logo.src}" alt="${logo.alt}" loading="lazy">

        <div class="guia-card__pr">${escapeHtml(guia.num_guia)}</div>
        <div class="guia-card__servicio">${escapeHtml(guia.servicio)}</div>
        <div class="guia-card__cliente" title="${clienteText}">${clienteText}</div>
        <div class="guia-card__meta">
            <span><i class="bi bi-clock-history"></i>${formatFecha(guia.fecha)}</span>
            <span><i class="bi bi-truck"></i>${escapeHtml(guia.placas1)}</span>
        </div>
        ${contenedorHtml}
        ${operadorHtml}
    `;

    return card;
}

function updateCounts() {
    Object.values(panels).forEach((panel) => {
        const count = panel.cardsEl.children.length;
        setTextWithBump(panel.countEl, count);
        panel.bodyEl.classList.toggle('is-empty', count === 0);
    });
}

// Los 5 KPIs de la barra superior (Guías Creadas / Aprobadas-Rechazadas
// para Timbrar / Aprobadas-Rechazadas para Liberación) NO se derivan de
// las tarjetas visibles en pantalla — son el mismo conteo por ventana de
// jornada (07:00, ver App\Dashboard\BusinessDay) que persiste el resumen
// diario, para que la barra y ese resumen siempre coincidan.
function renderKpis(kpis) {
    setTextWithBump(document.getElementById('kpi-guias-creadas'), kpis.guias_creadas ?? 0);
    setTextWithBump(document.getElementById('kpi-timbrado-aprobadas'), kpis.timbrado_aprobadas ?? 0);
    setTextWithBump(document.getElementById('kpi-timbrado-rechazadas'), kpis.timbrado_rechazadas ?? 0);
    setTextWithBump(document.getElementById('kpi-liberacion-aprobadas'), kpis.liberacion_aprobadas ?? 0);
    setTextWithBump(document.getElementById('kpi-liberacion-rechazadas'), kpis.liberacion_rechazadas ?? 0);
}

async function fetchKpis() {
    const response = await fetch('/api/trafico-kpis.php', { cache: 'no-store' });
    renderKpis(await response.json());
}

function renderInitialGuias(guias) {
    // El repositorio ya entrega los datos de la más reciente a la más
    // antigua; se agregan en ese mismo orden para no invertirlo.
    guias.forEach((guia) => panels.generadas.cardsEl.appendChild(buildCard(guia, 'generada')));
    updateCounts();
}

function renderInitialBucket(guias, targetPanel, stateClass) {
    guias.forEach((guia) => {
        const card = buildCard(guia, stateClass);

        if (guia.resolucion) {
            updateCardResult(card, {
                tipo: guia.resolucion.tipo,
                resultado: guia.resolucion.resultado,
                fecha: guia.resolucion.fecha,
                usuario: guia.resolucion.usuario,
                observaciones: guia.resolucion.observaciones,
                color: guia.resolucion.color,
            });
        }

        targetPanel.cardsEl.appendChild(card);
    });
    updateCounts();
}

/**
 * Repinta los 4 paneles desde App\Dashboard\GuiaBoardRepository::boardState()
 * (la misma fuente que usa la carga inicial de la página) — se llama al
 * reconectar el WebSocket.
 *
 * Bug real (2026-08-11): `connect()` reintenta la conexión tras un `close`
 * pero nunca vuelve a sincronizar el estado — cualquier evento publicado
 * mientras el socket estuvo caído (un `guia.timbrado_solicitado` o
 * `guia.timbrado_concluido` de por medio, por ejemplo) se perdía para
 * siempre en esa pestaña: la tarjeta se quedaba en el panel y con la
 * resolución que tenía justo antes del corte, sin forma de corregirse sin
 * un F5 manual. Un tablero de operación queda abierto horas o días, así
 * que un corte de WebSocket (deploy, red, laptop en suspensión) es
 * cuestión de tiempo, no un caso raro.
 */
async function reconcileBoard() {
    try {
        const response = await fetch('/api/trafico-board.php', { cache: 'no-store' });
        const boardState = await response.json();

        Object.values(panels).forEach((panel) => {
            panel.cardsEl.innerHTML = '';
        });

        renderInitialGuias(boardState.generadas ?? []);
        renderInitialBucket(boardState.solicitudes_timbrado ?? [], panels.solicitudes_timbrado, 'liberacion');
        renderInitialBucket(boardState.liberacion ?? [], panels.liberacion, 'liberacion');
        renderInitialBucket(boardState.timbrado ?? [], panels.timbrado, 'timbrado');
    } catch (e) {
        // Best-effort: si falla, el tablero se queda con lo que tenía en
        // memoria (mismo comportamiento que antes de este fix) en vez de
        // vaciarse a medias.
    }
}

function addNewGuia(guia) {
    const card = buildCard(guia, 'generada');
    card.classList.add('guia-card--enter', 'guia-card--new');

    const badge = document.createElement('span');
    badge.className = 'guia-card__badge';
    badge.textContent = 'NUEVA';
    card.appendChild(badge);

    card.addEventListener('animationend', () => card.classList.remove('guia-card--enter'), { once: true });

    setTimeout(() => {
        card.classList.remove('guia-card--new');
        badge.classList.add('is-fading');
        setTimeout(() => badge.remove(), 500);
    }, NEW_CARD_HIGHLIGHT_MS);

    panels.generadas.cardsEl.prepend(card);
    updateCounts();

    soundManager.playNewGuide();
}

function moveCards(guias, targetPanel, stateClass) {
    guias.forEach((guiaInfo) => {
        const id = guiaInfo.id || guiaInfo.guia_id;
        let card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);

        if (card) {
            // Update styling classes
            card.classList.remove('guia-card--generada', 'guia-card--liberacion', 'guia-card--timbrado');
            card.classList.add(`guia-card--${stateClass}`);
        } else if (guiaInfo.num_guia && guiaInfo.fecha) {
            // La guía no estaba en pantalla (jornada anterior sin actividad
            // al momento de cargar la página) — se crea aquí en vez de
            // perder el evento en silencio. Requiere que el payload traiga
            // la fila completa (ver
            // App\Liberacion\GuiaLookupRepository::buscarCompletoPorId());
            // si solo trae id/num_guia (payload viejo), no hay suficiente
            // información para pintar la tarjeta y el evento se ignora.
            card = buildCard(guiaInfo, stateClass);
        }

        if (card) {
            targetPanel.cardsEl.prepend(card);
        }
    });
    updateCounts();
}

function updateCardResult(card, { tipo, resultado, fecha, usuario, observaciones, color }) {
    let resolution = card.querySelector('.guia-card__resolution');
    if (!resolution) {
        resolution = document.createElement('div');
        resolution.className = 'guia-card__resolution mt-2 pt-2 border-top small';
        card.appendChild(resolution);
    }
    const icon = color === 'success' ? '🟢' : '🔴';
    resolution.innerHTML = `
        <div class="fw-bold text-${color}">${icon} ${escapeHtml(tipo)} ${escapeHtml(resultado)}</div>
        <div><strong>Usuario:</strong> ${escapeHtml(usuario)}</div>
        <div><strong>Fecha:</strong> ${formatFecha(fecha)}</div>
        ${observaciones ? `<div><strong>Obs:</strong> ${escapeHtml(observaciones)}</div>` : ''}
    `;
}

function updateCardData(card, guia) {
    if (!card || !guia) return;
    const accent = card.classList.contains('guia-card--liberacion') ? 'liberacion' : (card.classList.contains('guia-card--timbrado') ? 'timbrado' : 'generada');
    const fresh = buildCard(guia, accent);
    const resolution = card.querySelector('.guia-card__resolution');
    card.innerHTML = fresh.innerHTML;
    if (resolution) {
        card.appendChild(resolution);
    }
}

function handleMessage(event) {
    const message = JSON.parse(event.data);
    const evName = message.event;

    if (evName === 'guia.detectada') {
        const id = message.payload.id;
        const existingCard = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
        if (existingCard) {
            updateCardData(existingCard, message.payload);
        } else {
            addNewGuia(message.payload);
        }
        fetchKpis();
    } else if (evName === 'guia.actualizada') {
        const id = message.payload.id;
        const existingCard = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
        if (existingCard) {
            updateCardData(existingCard, message.payload);
        }
    } else if (evName === 'guia.timbrado_solicitado') {
        moveCards(message.payload.guias, panels.solicitudes_timbrado, 'liberacion'); // Use 'liberacion' as warning-color for pending
        soundManager.playReleaseRequested();
    } else if (evName === 'guia.liberacion_solicitada') {
        moveCards(message.payload.guias, panels.liberacion, 'liberacion');
        soundManager.playReleaseRequested();
    } else if (
        evName === 'solicitud_timbrado.aprobada' ||
        evName === 'solicitud_timbrado.rechazada' ||
        evName === 'solicitud_liberacion.aprobada' ||
        evName === 'solicitud_liberacion.rechazada'
    ) {
        const isAprobada = evName.includes('.aprobada');
        const isTimbrado = evName.includes('timbrado');
        const tipo = isTimbrado ? 'Timbrado' : 'Liberación';
        const resultado = isAprobada ? 'Aprobada' : 'Rechazada';
        const color = isAprobada ? 'success' : 'danger';

        moveCards(message.payload.guias, panels.timbrado, 'timbrado');

        message.payload.guias.forEach((g) => {
            const id = g.id || g.guia_id;
            const card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
            if (card) {
                updateCardResult(card, {
                    tipo,
                    resultado,
                    fecha: message.payload.fecha || new Date().toISOString(),
                    usuario: message.payload.actor || 'Facturación',
                    observaciones: message.payload.motivo || '',
                    color
                });
            }
        });

        // Cada resultado suena (aprobada = éxito, rechazada = error) — antes
        // ninguno de los 4 casos de este bloque emitía sonido.
        if (isAprobada) {
            soundManager.playStampSuccess();
        } else {
            soundManager.playStampError();
        }

        fetchKpis();
    } else if (evName === 'guia.timbrado_completado' || evName === 'guia.timbrado_concluido') {
        // Bug real (2026-08-11): este bloque asumía que la tarjeta YA
        // estaba en "Respuesta de Solicitudes" porque un
        // 'solicitud_timbrado.aprobada' anterior ya la habría movido con
        // moveCards() — cierto para el timbrado manual de SICRET (ver
        // App\Monitoring\Timbrado\TimbradoConfirmationWatcher), pero el
        // Motor de Timbrado Automático de trafico-system concluye la
        // solicitud sin ningún paso de aprobación humana (ver docblock de
        // App\Monitoring\Timbrado\TimbradoConclusionEvidenceSource::
        // buscar() — "una solicitud puede llegar a CONCLUIDA sin pasar
        // nunca por TIMBRADO"), así que ese evento nunca llega y la
        // tarjeta se quedaba en vivo en "Solicitudes de Timbrado" para
        // siempre — solo se corregía con un F5 (el render inicial sí
        // bucketiza por estado real). Se agrega el mismo moveCards() que
        // ya usa la rama de 'aprobada', antes de actualizar la resolución
        // — es seguro llamarlo aunque la tarjeta ya estuviera en el panel
        // correcto (moveCards() solo la reordena/reclasifica).
        moveCards(message.payload.guias, panels.timbrado, 'timbrado');

        message.payload.guias.forEach((g) => {
            const id = g.id || g.guia_id;
            const card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
            if (card) {
                updateCardResult(card, {
                    tipo: 'Timbrado',
                    resultado: 'Confirmado en SICRET',
                    fecha: new Date().toISOString(),
                    usuario: 'SICRET',
                    observaciones: g.factura_impresa ? `Factura: ${g.factura_impresa}` : '',
                    color: 'success',
                });
            }
        });
        soundManager.playStampSuccess();
    } else if (evName === 'guia.liberacion_ejecutando') {
        message.payload.guias.forEach((g) => {
            const id = g.id || g.guia_id;
            const card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
            if (card) {
                updateCardResult(card, {
                    tipo: 'Liberación',
                    resultado: 'Ejecutando en SICRET',
                    fecha: new Date().toISOString(),
                    usuario: 'ATLAS',
                    observaciones: '',
                    color: 'success',
                });
            }
        });
    } else if (evName === 'guia.liberacion_completada') {
        // Misma corrección defensiva que timbrado_completado/concluido:
        // hoy Liberación siempre pasa por 'solicitud_liberacion.aprobada'
        // (aprobación humana), así que este moveCards() es normalmente un
        // no-op sobre una tarjeta que ya está en el panel correcto — pero
        // asumirlo sin comprobarlo es la misma suposición frágil que ya
        // falló para Timbrado en cuanto apareció una vía sin aprobación
        // humana de por medio.
        moveCards(message.payload.guias, panels.timbrado, 'timbrado');

        message.payload.guias.forEach((g) => {
            const id = g.id || g.guia_id;
            const card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
            if (card) {
                updateCardResult(card, {
                    tipo: 'Liberación',
                    resultado: 'Confirmada en SICRET',
                    fecha: new Date().toISOString(),
                    usuario: 'SICRET',
                    observaciones: '',
                    color: 'success',
                });
            }
        });
        soundManager.playStampSuccess();
    } else if (evName === 'guia.liberacion_error') {
        // App\Liberacion\Execution\LiberacionExecutor::marcarError() publica
        // este mismo evento SIN 'guias' (solo solicitud_id/motivo) cuando el
        // fallo ocurre antes de tocar SICRET — a diferencia de
        // LiberationConfirmationWatcher::alFallar(), que sí la incluye. Sin
        // este guard, esos casos rompían handleMessage() con un TypeError.
        (message.payload.guias ?? []).forEach((g) => {
            const id = g.id || g.guia_id;
            const card = document.querySelector(`.guia-card[data-guia-id="${id}"]`);
            if (card) {
                updateCardResult(card, {
                    tipo: 'Liberación',
                    resultado: 'Error',
                    fecha: new Date().toISOString(),
                    usuario: 'SICRET',
                    observaciones: message.payload.motivo || '',
                    color: 'danger',
                });
            }
        });
        soundManager.playStampError();
    } else if (evName === 'dashboard.reset_diario') {
        // Corte de jornada (07:00): boardState() ya recalcula "hoy" contra
        // la nueva ventana en el servidor — recargar es lo más simple para
        // reflejarla sin duplicar la lógica de render de los paneles.
        window.location.reload();
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

let esReconexion = false;

function connect() {
    setWsStatus('pending');

    const socket = new WebSocket(`ws://${window.location.hostname}:${WS_PORT}`);

    socket.addEventListener('open', () => {
        setWsStatus('ok');

        if (esReconexion) {
            reconcileBoard();
        }

        esReconexion = true;
    });
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
        engineStatusEl.innerHTML = '<i class="bi bi-cpu-fill"></i> Motor activo';
    } else {
        engineStatusEl.className = 'status-pill status-pill--down';
        engineStatusEl.innerHTML = '<i class="bi bi-cpu"></i> Motor inactivo';
    }
}

async function refreshEngineStatus() {
    try {
        const response = await fetch('/api/heartbeat.php', { cache: 'no-store' });
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

const soundManager = new SoundManager();

const sonidoBloqueadoEl = document.getElementById('sonido-bloqueado');
soundManager.onUnlock(() => sonidoBloqueadoEl?.remove());

const initialGuias = JSON.parse(document.getElementById('initial-guias').textContent || '[]');
renderInitialGuias(initialGuias);

const initialSolicitudesTimbrado = JSON.parse(document.getElementById('initial-solicitudes-timbrado').textContent || '[]');
renderInitialBucket(initialSolicitudesTimbrado, panels.solicitudes_timbrado, 'liberacion');

const initialLiberacion = JSON.parse(document.getElementById('initial-liberacion').textContent || '[]');
renderInitialBucket(initialLiberacion, panels.liberacion, 'liberacion');

const initialTimbrado = JSON.parse(document.getElementById('initial-timbrado').textContent || '[]');
renderInitialBucket(initialTimbrado, panels.timbrado, 'timbrado');

tickClock();
setInterval(tickClock, 1000);

refreshEngineStatus();
setInterval(refreshEngineStatus, 5000);

// "timbrado-conclusion" (App\Monitoring\Timbrado\TimbradoConclusionWatcher,
// registrado en bin/monitoring-engine.php) es el watcher que confirma que
// el CFDI de una guía quedó completo (folioFiscal/idccp en facturas33) —
// antes la píldora "CFDI Watcher: Próximamente" estaba deshabilitada
// porque ese componente no existía; ya está implementado y corriendo.
watchHeartbeat(document.getElementById('cfdi-status'), {
    engine: 'timbrado-conclusion',
    icon: 'bi-file-earmark-check',
    activeLabel: 'CFDI Watcher: activo',
    downLabel: 'CFDI Watcher: inactivo',
    errorLabel: 'CFDI Watcher: con errores',
});

connect();
