// Logo por fuente SICRET (FORSIS/GERO) — compartido por el Dashboard de
// Tráfico y el Tablero de Facturación para no duplicar qué archivo y
// clase CSS le corresponde a cada source.
export function logoForSource(source) {
    const value = String(source ?? '').toLowerCase();

    if (value.includes('gero')) {
        return { src: '/assets/gero-logo.svg', alt: 'GERO', modifier: 'gero' };
    }

    return { src: '/assets/forsis-logo.svg', alt: 'FORSIS', modifier: 'forsis' };
}
