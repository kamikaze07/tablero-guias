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

function buildCard(guia, accent) {
    const card = document.createElement('article');
    card.className = `guia-card guia-card--${accent}`;
    card.dataset.guiaId = guia.id;

    const operadorHtml = guia.operador
        ? `<div class="guia-card__operador"><i class="bi bi-person-badge"></i>${escapeHtml(guia.operador)}</div>`
        : '';

    card.innerHTML = `
        <div class="guia-card__pr">${escapeHtml(guia.num_guia)}</div>
        <div class="guia-card__servicio">${escapeHtml(guia.servicio)}</div>
        <div class="guia-card__cliente">${escapeHtml(guia.nombre)}</div>
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
        panel.countEl.textContent = String(count);
        panel.bodyEl.classList.toggle('is-empty', count === 0);
    });

    document.getElementById('kpi-generadas').textContent = panels.generadas.cardsEl.children.length;
    document.getElementById('kpi-liberacion').textContent = panels.liberacion.cardsEl.children.length;
    document.getElementById('kpi-exito').textContent = panels.timbrado.cardsEl.querySelectorAll('[data-resultado="exito"]').length;
    document.getElementById('kpi-error').textContent = panels.timbrado.cardsEl.querySelectorAll('[data-resultado="error"]').length;
}

function renderInitialGuias(guias) {
    // El repositorio ya entrega los datos de la más reciente a la más
    // antigua; se agregan en ese mismo orden para no invertirlo.
    guias.forEach((guia) => panels.generadas.cardsEl.appendChild(buildCard(guia, 'generada')));
    updateCounts();
}

function addNewGuia(guia) {
    const card = buildCard(guia, 'generada');
    card.classList.add('guia-card--enter', 'guia-card--highlight');
    card.addEventListener('animationend', () => card.classList.remove('guia-card--enter'), { once: true });
    setTimeout(() => card.classList.remove('guia-card--highlight'), 4000);

    panels.generadas.cardsEl.prepend(card);
    updateCounts();
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

const initialGuias = JSON.parse(document.getElementById('initial-guias').textContent || '[]');
renderInitialGuias(initialGuias);

tickClock();
setInterval(tickClock, 1000);

refreshEngineStatus();
setInterval(refreshEngineStatus, 5000);

connect();
