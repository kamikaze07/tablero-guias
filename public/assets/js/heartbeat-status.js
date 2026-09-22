// Refleja el heartbeat de un motor/watcher (App\Dashboard\HeartbeatRepository,
// mismo endpoint que ya usa "Motor de Liberación activo") en un status-pill —
// compartido por el Dashboard de Tráfico y el Tablero de Facturación para no
// duplicar el fetch + polling en cada uno.
export function watchHeartbeat(el, { engine, icon, activeLabel, downLabel, errorLabel, intervalMs = 5000 }) {
    if (!el) {
        return;
    }

    function setState(state, label) {
        el.className = `status-pill status-pill--${state}`;
        el.innerHTML = `<i class="bi ${icon}"></i> ${label}`;
    }

    async function refresh() {
        try {
            const response = await fetch(`/api/heartbeat.php?engine=${encodeURIComponent(engine)}`, { cache: 'no-store' });
            const data = await response.json();

            if (!data.active) {
                setState('down', downLabel);
            } else if (data.status === 'error') {
                // Activo (el ciclo sigue corriendo) pero la última corrida
                // de este watcher específico tiró una excepción — distinto
                // de "inactivo": el proceso no murió, algo dentro de ese
                // ciclo falló (ver MonitoringEngine::runCycle()).
                setState('warning', errorLabel);
            } else {
                setState('ok', activeLabel);
            }
        } catch {
            setState('down', downLabel);
        }
    }

    refresh();
    setInterval(refresh, intervalMs);
}
