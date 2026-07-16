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
    timbrado: {
        cardsEl: document.querySelector('#panel-timbrado .board-column__cards'),
        bodyEl: document.getElementById('panel-timbrado'),
        countEl: document.getElementById('count-timbrado'),
    },
};

const wsStatusEl = document.getElementById('ws-status');
const engineStatusEl = document.getElementById('engine-status');

const activityLogEl = document.getElementById('activity-log');
const activityEntriesEl = activityLogEl.querySelector('.activity-panel__entries');

const NEW_CARD_HIGHLIGHT_MS = 5000;
const ACTIVITY_LOG_LIMIT = 20;

const ACTIVITY_TYPES = {
    new_guide: { icon: 'bi-file-earmark-plus-fill', label: 'Nueva guía' },
    release_request: { icon: 'bi-send-fill', label: 'Liberación solicitada' },
    success: { icon: 'bi-check-circle-fill', label: 'Timbrada' },
    error: { icon: 'bi-exclamation-triangle-fill', label: 'Error de timbrado' },
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
    const date = new Date(String(value).replace(' ', 'T'));

    if (Number.isNaN(date.getTime())) {
        return escapeHtml(value);
    }

    return escapeHtml(date.toLocaleString('es-MX', { dateStyle: 'short', timeStyle: 'short' }));
}

function logoForSource(source) {
    const value = String(source ?? '').toLowerCase();

    if (value.includes('gero')) {
        return { src: '/assets/gero-logo.svg', alt: 'GERO', modifier: 'gero' };
    }

    return { src: '/assets/forsis-logo.svg', alt: 'FORSIS', modifier: 'forsis' };
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

    card.innerHTML = `
        <img class="guia-card__logo guia-card__logo--${logo.modifier}" src="${logo.src}" alt="${logo.alt}" loading="lazy">

        <div class="guia-card__pr">${escapeHtml(guia.num_guia)}</div>
        <div class="guia-card__servicio">${escapeHtml(guia.servicio)}</div>
        <div class="guia-card__cliente" title="${clienteText}">${clienteText}</div>
        <div class="guia-card__meta">
            <span><i class="bi bi-clock-history"></i>${formatFecha(guia.fecha)}</span>
            <span><i class="bi bi-truck"></i>${escapeHtml(guia.placas1)}</span>
        </div>
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

    setTextWithBump(document.getElementById('kpi-generadas'), panels.generadas.cardsEl.children.length);
    setTextWithBump(document.getElementById('kpi-liberacion'), panels.liberacion.cardsEl.children.length);
    setTextWithBump(
        document.getElementById('kpi-exito'),
        panels.timbrado.cardsEl.querySelectorAll('[data-resultado="exito"]').length,
    );
    setTextWithBump(
        document.getElementById('kpi-error'),
        panels.timbrado.cardsEl.querySelectorAll('[data-resultado="error"]').length,
    );
}

function renderInitialGuias(guias) {
    // El repositorio ya entrega los datos de la más reciente a la más
    // antigua; se agregan en ese mismo orden para no invertirlo.
    guias.forEach((guia) => panels.generadas.cardsEl.appendChild(buildCard(guia, 'generada')));
    updateCounts();
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

    soundBoard.play('new-guide');
    addActivityEntry({ type: 'new_guide', prNumber: guia.num_guia });
}

function addActivityEntry({ type, prNumber }) {
    const meta = ACTIVITY_TYPES[type] ?? ACTIVITY_TYPES.new_guide;
    const entry = document.createElement('div');
    entry.className = `activity-entry activity-entry--${type}`;

    const time = new Date().toLocaleTimeString('es-MX', { hour12: false });

    entry.innerHTML = `
        <i class="bi ${meta.icon} activity-entry__icon"></i>
        <div class="activity-entry__body">
            <span class="activity-entry__time">${escapeHtml(time)}</span>
            <span class="activity-entry__label">${escapeHtml(meta.label)}</span>
            <span class="activity-entry__pr">${escapeHtml(prNumber)}</span>
        </div>
    `;

    activityEntriesEl.prepend(entry);

    while (activityEntriesEl.children.length > ACTIVITY_LOG_LIMIT) {
        activityEntriesEl.lastElementChild.remove();
    }

    activityLogEl.classList.remove('is-empty');
}

function createSoundBoard() {
    const keys = ['new-guide', 'release-request', 'success', 'error'];
    const sounds = new Map();

    keys.forEach((key) => {
        const audio = document.createElement('audio');
        audio.preload = 'none';

        [
            { ext: 'ogg', type: 'audio/ogg' },
            { ext: 'wav', type: 'audio/wav' },
        ].forEach(({ ext, type }) => {
            const source = document.createElement('source');
            source.src = `/assets/sounds/${key}.${ext}`;
            source.type = type;
            audio.appendChild(source);
        });

        // Si el archivo todavía no existe, el elemento simplemente no
        // reproduce nada — nunca debe generar un error de JavaScript.
        audio.addEventListener('error', () => {}, true);

        sounds.set(key, audio);
    });

    // Los navegadores bloquean el autoplay hasta la primera interacción
    // del usuario con la página.
    let unlocked = false;
    const unlock = () => { unlocked = true; };
    document.addEventListener('click', unlock, { once: true });
    document.addEventListener('keydown', unlock, { once: true });

    return {
        play(key) {
            if (!unlocked) {
                return;
            }

            const audio = sounds.get(key);

            if (!audio) {
                return;
            }

            audio.currentTime = 0;
            audio.play().catch(() => {});
        },
    };
}

function handleMessage(event) {
    const message = JSON.parse(event.data);

    if (message.event === 'guia.detectada') {
        addNewGuia(message.payload);
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

const soundBoard = createSoundBoard();

activityLogEl.classList.add('is-empty');

const initialGuias = JSON.parse(document.getElementById('initial-guias').textContent || '[]');
renderInitialGuias(initialGuias);

tickClock();
setInterval(tickClock, 1000);

refreshEngineStatus();
setInterval(refreshEngineStatus, 5000);

connect();
