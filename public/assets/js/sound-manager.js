// Responsabilidad única: administrar la reproducción de los sonidos
// de notificación del Dashboard de Tráfico.

const SOUND_VOLUME = 0.45;
const POOL_SIZE = 3;

const SOUND_FILES = {
    newGuide: '/assets/sounds/new_guide.ogg',
    releaseRequested: '/assets/sounds/release-request.ogg',
    stampSuccess: '/assets/sounds/stamp-success.ogg',
    stampError: '/assets/sounds/stamp-error.ogg',
};

class SoundManager {
    constructor() {
        this.pools = new Map();
        this.unlocked = false;
        this.unlockHandler = this.unlock.bind(this);

        this.preload();
        this.setupUnlock();
    }

    preload() {
        Object.entries(SOUND_FILES).forEach(([key, src]) => {
            try {
                const base = new Audio(src);
                base.preload = 'auto';
                base.volume = SOUND_VOLUME;

                // Se detectan fallos de carga sin interrumpir el Dashboard.
                base.addEventListener('error', () => {
                    console.warn(`SoundManager: no se pudo cargar el sonido "${key}" (${src}).`);
                }, { once: true });

                this.pools.set(key, { src, instances: [base], next: 0 });
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
            clone.volume = SOUND_VOLUME;
            pool.instances.push(clone);
        }

        const instance = pool.instances[pool.next];
        pool.next = (pool.next + 1) % pool.instances.length;

        return instance;
    }

    play(key) {
        if (!this.unlocked) {
            return;
        }

        try {
            const instance = this.acquireInstance(key);

            if (!instance) {
                return;
            }

            instance.currentTime = 0;
            instance.play().catch(() => {});
        } catch (error) {
            console.warn(`SoundManager: no se pudo reproducir el sonido "${key}".`, error);
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
}

export default SoundManager;
