# Patrones de UI — ATLAS

> A diferencia del Sistema de Guías (múltiples vistas con patrones
> repetidos entre archivos), ATLAS hoy tiene **una sola pantalla real**
> (el Dashboard de Tráfico). Los "patrones" aquí documentados son, en su
> mayoría, convenciones dentro de ese único archivo — útiles sobre todo
> como referencia de estilo a seguir cuando se implemente la Mesa
> Operativa u otras pantallas nuevas, para mantener consistencia visual.

## 1. Tema oscuro tipo "centro de operaciones"

Paleta definida por variables CSS en `:root` (`trafico.css`): fondo casi
negro (`--bg: #0b0f17`), paneles ligeramente más claros (`--panel-bg:
#131a24`), y **un color de acento por tipo de estado de negocio**:

| Variable | Color | Uso |
|---|---|---|
| `--c-generada` | Azul (`#2f81f7`) | Panel/KPI/columna "Guías Generadas" |
| `--c-liberacion` | Naranja (`#fd7e14`) | Panel/KPI/columna "Solicitadas a Liberación" |
| `--c-exito` | Verde (`#22c55e`) | Panel "Resultado del Timbrado" (éxito) |
| `--c-error` | Rojo (`#ef4444`) | Timbrado con error / estado "down" de conexión |

Este mapeo color↔concepto de negocio es consistente entre el borde
izquierdo de las tarjetas KPI, el borde superior de las columnas del
tablero, y el color de los íconos — es el patrón a seguir si se agrega un
cuarto concepto de negocio (p. ej. un color propio para "Facturación").

## 2. Tarjetas (cards), nunca tablas — por decisión explícita de diseño

`docs/03-ui/01-dashboard-trafico.md §12` regla 3: "La información se
representa siempre como tarjetas (cards); ninguna vista usa tablas HTML."
Esto es deliberado y **contrasta a propósito** con la futura Mesa
Operativa, que por diseño sí usará una tabla densa
(`docs/03-ui/02-mesa-operativa-trafico.md §3`, tabla comparativa
"Dashboard vs. Mesa Operativa"). Es decir: **el patrón de tarjeta no debe
reutilizarse sin más al construir la Mesa Operativa** — son dos lenguajes
visuales distintos a propósito, cada uno resuelto para su propio caso de
uso (observar vs. trabajar).

## 3. Patrón "tarjeta con entrada animada + insignia temporal"

`buildCard()` + `addNewGuia()` en `trafico.js`: construcción de HTML vía
`element.innerHTML` con **todos los valores dinámicos pasados por
`escapeHtml()`** — a diferencia del Sistema de Guías, aquí el patrón
correcto (escapar antes de interpolar) sí se aplica de forma consistente.
La tarjeta nueva entra con una clase de animación CSS
(`guia-card--enter`), muestra una insignia "NUEVA" que se remueve
automáticamente a los 5 segundos, y se inserta siempre al **inicio** del
contenedor (`prepend`), nunca reordenando lo demás.

## 4. Patrón "contador con `bump`"

`setTextWithBump(el, value)`: cada vez que cambia un número visible (KPIs,
contadores de columna), se reinicia una animación CSS (`bump` +
`@keyframes kpi-bump`) forzando un reflow (`void el.offsetWidth`) para que
la animación se repita aunque el valor cambie al mismo número dos veces
seguidas. Patrón reutilizable para cualquier contador nuevo que se agregue
(p. ej. un futuro contador de solicitudes pendientes).

## 5. Patrón "píldora de estado" (`status-pill`)

Usado para "Motor" y "WebSocket" en el encabezado: 3-4 variantes de color
(`--ok`, `--down`, `--pending`, `--disabled`) sobre la misma estructura
base (ícono + texto). Es el patrón a reutilizar si se agrega un indicador
de estado nuevo (p. ej. "CFDI Watcher" cuando deje de ser un placeholder
`--disabled` y empiece a reportar salud real).

## 6. Patrón "panel vacío / con contenido" (`is-empty`)

Cada columna del tablero tiene un estado "vacío" (ícono + texto tipo
"Sin guías en este momento") que se oculta automáticamente
(`classList.toggle('is-empty', count === 0)`) en cuanto el panel tiene al
menos una tarjeta — administrado centralizadamente por `updateCounts()`,
no por cada punto de inserción individual.

## 7. Patrón de sonido + registro de actividad emparejados

Cada acción visible relevante **debería** (según el propio código ya
preparado, aunque hoy solo ocurre para una) disparar dos cosas juntas: un
sonido corto (`SoundManager.playX()`) y una entrada en el log de
actividad (`addActivityEntry({type, prNumber})`). Hoy solo
`addNewGuia()` hace ambas cosas para `type: 'new_guide'`. Los tipos
`release_request`, `success`, `error` ya están definidos en
`ACTIVITY_TYPES` (con su ícono y etiqueta) esperando a que algo los
dispare — es, en sí mismo, el patrón a replicar exactamente cuando se
implementen los eventos de liberación/timbrado.

## 8. Reloj en vivo

`tickClock()` + `setInterval(tickClock, 1000)`: patrón simple de reloj de
pared en el encabezado, sin relación con lógica de negocio — puramente
ambiental, reforzando la naturaleza de "centro de operaciones" del
Dashboard.

## 9. Convenciones de nombres CSS

BEM-like consistente: bloque (`board-column`, `kpi-card`, `guia-card`,
`status-pill`), elemento (`__header`, `__icon`, `__value`), modificador
(`--generada`, `--liberacion`, `--ok`, `--down`). Vale la pena mantener
esta convención si se agregan componentes nuevos (p. ej. `mesa-operativa__`
o `guia-row__` para la futura tabla densa).
