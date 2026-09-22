// Responsabilidad única: administrar la reproducción de los sonidos
// de notificación — compartido por el Dashboard de Tráfico y el Tablero
// de Facturación.

// Volumen por defecto del elemento <audio> — subido de 0.45 a 0.75: medido
// el contenido real de los .wav, el pico de amplitud ya estaba lejos del
// máximo (p. ej. release-request.wav antes al 55%), así que 0.45 encima
// dejaba el volumen efectivo en ~25% de lo posible. Cada sonido puede
// pisar este valor vía SOUND_FILES[key].volume (ver releaseRequested y
// delayAlert más abajo, los dos señalados como "apenas perceptibles").
const DEFAULT_VOLUME = 0.75;
const POOL_SIZE = 3;

// Registro persistente de cada intento de reproducción (éxito o fallo) —
// sobrevive a recargas de página vía localStorage. Se agregó porque la
// alerta de solicitudes desatendidas (ver evaluarAlertaDesatendidas() en
// facturacion.js) reportó "no suena" sin que nadie tuviera la consola
// abierta en el momento exacto en que ocurrió — sin esto, diagnosticarlo
// requiere esperar a que vuelva a pasar con DevTools ya abierto.
const LOG_KEY = 'atlas-sound-log';
const LOG_MAX = 50;

const SOUND_FILES = {
    newGuide: { src: '/assets/sounds/new-guide.ogg' },
    // .wav, no .ogg como los demás: el .ogg original medía 0.043s (~1900
    // muestras), prácticamente un clic inaudible. El primer reemplazo
    // (chime de 0.44s) seguía "apenas perceptible" — medido, su pico de
    // amplitud llegaba solo al 55% del máximo. Regenerado a un ding-dong
    // de 0.46s con pico ~97% + volumen propio más alto.
    releaseRequested: { src: '/assets/sounds/release-request.wav', volume: 0.95 },
    stampSuccess: { src: '/assets/sounds/stamp-success.ogg' },
    stampError: { src: '/assets/sounds/stamp-error.ogg' },
    // Alarma DEDICADA para solicitudes desatendidas (ver
    // evaluarAlertaDesatendidas() en facturacion.js) — antes esa alerta
    // reutilizaba stampError (pensado para "rechazada", no para "llevas
    // rato sin atender"), un .ogg pequeño y débil. Sirena de ~1s a volumen
    // máximo: es la alerta más urgente del tablero, no debe competir en
    // volumen con las demás.
    delayAlert: { src: '/assets/sounds/delay-alert.wav', volume: 1 },
};

class SoundManager {
    constructor() {
        this.pools = new Map();
        this.unlocked = false;
        this.unlockHandler = this.unlock.bind(this);
        this.onUnlockCallbacks = [];
        this.onLogCallbacks = [];
        this.stats = { intentos: 0, ok: 0, fallidos: 0 };

        this.preload();
        this.setupUnlock();
    }

    /**
     * Se ejecuta después de cada intento de reproducción (éxito o fallo),
     * con las estadísticas de la sesión actual — permite que la UI muestre
     * un contador en vivo junto a la alerta que dispara el sonido.
     */
    onLog(callback) {
        this.onLogCallbacks.push(callback);
    }

    registrarIntento(entry) {
        this.stats.intentos += 1;
        this.stats[entry.ok ? 'ok' : 'fallidos'] += 1;

        try {
            const log = JSON.parse(localStorage.getItem(LOG_KEY) || '[]');
            log.push(entry);

            while (log.length > LOG_MAX) {
                log.shift();
            }

            localStorage.setItem(LOG_KEY, JSON.stringify(log));
        } catch (error) {
            // localStorage puede fallar (modo privado, cuota llena) — no
            // debe romper la reproducción de sonido por esto.
        }

        this.onLogCallbacks.forEach((callback) => callback(this.stats, entry));
    }

    static leerLog() {
        try {
            return JSON.parse(localStorage.getItem(LOG_KEY) || '[]');
        } catch (error) {
            return [];
        }
    }

    /**
     * Se ejecuta la primera vez que el usuario interactúa con la página
     * (click/tecla/touch) y se desbloquea el audio — permite que la UI
     * reaccione (p. ej. ocultar un aviso de "sonido bloqueado") sin tener
     * que sondear `unlocked` con un timer.
     */
    onUnlock(callback) {
        if (this.unlocked) {
            callback();

            return;
        }

        this.onUnlockCallbacks.push(callback);
    }

    preload() {
        Object.entries(SOUND_FILES).forEach(([key, { src, volume = DEFAULT_VOLUME }]) => {
            try {
                const base = new Audio(src);
                base.preload = 'auto';
                base.volume = volume;

                // Se detectan fallos de carga sin interrumpir el Dashboard.
                base.addEventListener('error', () => {
                    console.warn(`SoundManager: no se pudo cargar el sonido "${key}" (${src}).`);
                }, { once: true });

                this.pools.set(key, { src, volume, instances: [base], next: 0 });
            } catch (error) {
                console.warn(`SoundManager: error al inicializar el sonido "${key}".`, error);
            }
        });
    }

    setupUnlock() {
        document.addEventListener('click', this.unlockHandler);
        document.addEventListener('keydown', this.unlockHandler);
        document.addEventListener('touchstart', this.unlockHandler);
    }

    unlock() {
        if (this.unlocked) {
            return;
        }

        this.unlocked = true;

        document.removeEventListener('click', this.unlockHandler);
        document.removeEventListener('keydown', this.unlockHandler);
        document.removeEventListener('touchstart', this.unlockHandler);

        this.onUnlockCallbacks.forEach((callback) => callback());
        this.onUnlockCallbacks = [];
    }

    // Obtiene una instancia libre del pool (o crea una nueva vía cloneNode
    // hasta POOL_SIZE) para permitir reproducciones simultáneas sin bloqueos.
    acquireInstance(key) {
        const pool = this.pools.get(key);

        if (!pool) {
            return null;
        }

        if (pool.instances.length < POOL_SIZE) {
            const clone = pool.instances[0].cloneNode(true);
            clone.volume = pool.volume;
            pool.instances.push(clone);
        }

        const instance = pool.instances[pool.next];
        pool.next = (pool.next + 1) % pool.instances.length;

        return instance;
    }

    play(key) {
        const t = Date.now();

        if (!this.unlocked) {
            // Antes se ignoraba en silencio — política de autoplay del
            // navegador: hasta que no haya un click/tecla/touch en la
            // página, NINGÚN sonido puede sonar, sin importar qué tan bien
            // esté conectado el evento que lo dispara. Este aviso es la
            // única pista visible de por qué "no suena nada" sin abrir
            // el código.
            console.warn(`SoundManager: "${key}" no sonó — el audio sigue bloqueado (falta una interacción del usuario con la página).`);
            this.registrarIntento({ t, key, ok: false, motivo: 'bloqueado (sin interacción del usuario)' });

            return;
        }

        try {
            const instance = this.acquireInstance(key);

            if (!instance) {
                console.warn(`SoundManager: "${key}" no está registrado.`);
                this.registrarIntento({ t, key, ok: false, motivo: 'sonido no registrado' });

                return;
            }

            instance.currentTime = 0;
            instance.play().then(
                () => this.registrarIntento({ t, key, ok: true }),
                (error) => {
                    // p. ej. formato no soportado por el navegador (Safari
                    // no soporta Ogg Vorbis) — antes se tragaba sin dejar
                    // rastro.
                    console.warn(`SoundManager: "${key}" no se pudo reproducir.`, error);
                    this.registrarIntento({ t, key, ok: false, motivo: String(error) });
                },
            );
        } catch (error) {
            console.warn(`SoundManager: no se pudo reproducir el sonido "${key}".`, error);
            this.registrarIntento({ t, key, ok: false, motivo: String(error) });
        }
    }

    playNewGuide() {
        this.play('newGuide');
    }

    playReleaseRequested() {
        this.play('releaseRequested');
    }

    playStampSuccess() {
        this.play('stampSuccess');
    }

    playStampError() {
        this.play('stampError');
    }

    playDelayAlert() {
        this.play('delayAlert');
    }
}

export default SoundManager;
