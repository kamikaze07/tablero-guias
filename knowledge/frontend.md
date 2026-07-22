# Frontend — Dashboard de Tráfico

## 1. Modelo general

Una única página real (`resources/views/trafico.php`), servida por
`public/trafico.php`. HTML5 + Bootstrap 5/Bootstrap Icons por CDN + CSS
propio (`assets/css/trafico.css`, tema oscuro) + un único módulo JS ES6
nativo (`assets/js/trafico.js`, cargado con `type="module"`, sin
bundler/transpilador — igual de "sin build step" que el Sistema de Guías,
pero aquí sí se usa `import`/`export` de módulos nativos del navegador en
vez de todo en un solo `<script>`).

No hay SPA/router de frontend — es una sola pantalla persistente pensada
para quedar abierta todo el turno (pantalla de centro de operaciones), no
para navegar entre vistas.

## 2. Renderizado inicial vs. tiempo real

- **Estado inicial**: `public/trafico.php` consulta
  `GuiaBoardRepository::findToday()` en el servidor y lo embebe como JSON
  dentro de un `<script id="initial-guias" type="application/json">` en el
  HTML (evita una llamada AJAX extra al cargar). `trafico.js` lo lee y
  pinta las tarjetas de "Guías Generadas" antes de abrir el WebSocket.
- **Tiempo real**: inmediatamente después, `connect()` abre un
  `WebSocket` hacia `ws://<host>:<WEBSOCKET_PORT>` y, en cada mensaje,
  `handleMessage()` decide qué hacer según `message.event`. **Hoy el único
  caso manejado es `'guia.detectada'`** → `addNewGuia()`. Cualquier otro
  valor de `event` se recibiría pero no tendría efecto (no hay `default`
  ni manejo de `guia.liberacion_solicitada`/`timbrado.exitoso`/
  `timbrado.error`, que son los eventos que documenta
  `docs/03-ui/01-dashboard-trafico.md` pero que nadie emite todavía).

## 3. Componentes visuales de `trafico.php`/`trafico.js`

| Componente | Elemento | Alimentado por |
|---|---|---|
| Encabezado (`ops-header`) | Logo/título, reloj en vivo, píldoras de estado | `tickClock()` (cada 1s), `setWsStatus()` (eventos del WebSocket), `refreshEngineStatus()` (poll a `/api/heartbeat.php` cada 5s) |
| Barra de KPIs (`kpi-bar`) | 4 tarjetas: Generadas / Solicitadas a Liberación / Timbradas Correctamente / Timbradas con Error | `updateCounts()`, que cuenta hijos DOM de cada panel — **los 3 últimos KPI siempre muestran 0** porque nada llena esos paneles |
| Tablero de 3 columnas (`board`) | Paneles "Guías Generadas", "Solicitadas a Liberación", "Resultado del Timbrado" | Solo el primero recibe tarjetas reales (`buildCard()` + `addNewGuia()`/`renderInitialGuias()`) |
| Panel de actividad (`activity-panel`) | Log de últimas 20 acciones | `addActivityEntry()`, invocado hoy únicamente desde `addNewGuia()` (tipo `new_guide`); los tipos `release_request`, `success`, `error` están definidos en `ACTIVITY_TYPES` pero **nunca se disparan** |
| Píldora "CFDI Watcher" | Estática, `status-pill--disabled`, texto "Próximamente" | Ninguno — es un placeholder de UI, no reacciona a ningún dato |

## 4. `buildCard()` — la única "tarjeta" que realmente se construye

Genera un `<article class="guia-card guia-card--generada">` con: logo de
empresa (`logoForSource()`, mapea `source` conteniendo `"gero"` al logo
GERO, cualquier otro valor al logo FORSIS — **no hay un tercer logo ni
lógica para `sicre2PR`/`sicre2Gero`**), folio (`num_guia`), servicio,
cliente (`nombre`, con `title` para tooltip completo), fecha formateada a
`es-MX`, placas (`placas1`), y opcionalmente el operador. Usa
`escapeHtml()` en **todos** los campos interpolados — a diferencia del
Sistema de Guías, aquí **sí se escapa correctamente** el HTML dinámico
(mitiga XSS almacenado).

`addNewGuia()` añade además: clases de animación de entrada
(`guia-card--enter`/`guia-card--new`), una insignia "NUEVA" que se
autodesvanece a los 5s (`NEW_CARD_HIGHLIGHT_MS`), inserción al **inicio**
del panel (`prepend`, nunca se reordena el resto — coincide exactamente con
la regla de diseño de `docs/03-ui/01-dashboard-trafico.md §4`), reproduce
el sonido `newGuide`, y registra la entrada en el panel de actividad.

## 5. `SoundManager` (`assets/js/sound-manager.js`)

Clase con pool de instancias de `Audio` (hasta 3 por sonido, vía
`cloneNode`) para permitir reproducciones simultáneas sin cortar sonidos
en curso. Requiere "desbloqueo" por interacción del usuario
(`click`/`keydown`/`touchstart`) antes de reproducir cualquier sonido — es
el patrón estándar para sortear el bloqueo de autoplay de los navegadores.

Expone 4 métodos: `playNewGuide()`, `playReleaseRequested()`,
`playStampSuccess()`, `playStampError()`, con sus 4 archivos `.ogg`
correspondientes ya presentes en `public/assets/sounds/`
(`new_guide.ogg` — nota: el archivo real en disco es
`new-guide.ogg`, con guion, mientras que `SOUND_FILES` en el código pide
`new_guide.ogg`, con guion bajo; ver `improvement_notes.md` para esta
discrepancia — , `release-request.ogg`, `stamp-success.ogg`,
`stamp-error.ogg`). **Solo `playNewGuide()` se invoca hoy** desde
`trafico.js`; los otros 3 métodos están completos y listos, pero no tienen
ningún punto de llamada — confirma, una vez más, que el frontend ya
"sabe" cómo reaccionar a liberación/timbrado, pero nada en el backend se
lo dispara todavía.

## 6. Indicadores de estado en vivo

- **`ws-status`**: 3 estados (`pending`/`ok`/`down`) reflejando el propio
  `WebSocket` del navegador (`onopen`/`onclose`/`onerror`). Si se
  desconecta, reintenta automáticamente cada 2s (`setTimeout(connect,
  2000)` dentro del handler de `close`).
- **`engine-status`**: refleja el heartbeat del Synchronization Engine,
  vía polling HTTP a `/api/heartbeat.php` cada 5s (no vía WebSocket) — es
  decir, hay **dos mecanismos de "vida" distintos y no relacionados**: uno
  para el canal WebSocket en sí (¿está conectado el navegador?) y otro para
  el motor de sincronización (¿está corriendo y sincronizando?).

## 7. Qué NO existe todavía en el frontend (relevante para la integración futura)

- Ningún control interactivo: no hay checkboxes, no hay selección de
  tarjetas, no hay botones de acción. El Dashboard es **puramente
  observacional** hoy, consistente con su documento de diseño ("no es una
  pantalla pasiva tipo televisión" en el sentido de que es multi-sesión
  sincronizada, pero sí es de solo lectura para el usuario).
- No existe ningún archivo/vista para la **Mesa Operativa de Tráfico**
  (`docs/03-ui/02-mesa-operativa-trafico.md`) — el documento de diseño
  describe un layout de tabla densa con filtros, búsqueda, selección
  múltiple y un botón "Solicitar liberación", pero no hay ningún HTML,
  CSS, ni JS de esa herramienta en el repositorio todavía. Es, en su
  totalidad, trabajo de implementación pendiente.
- No hay manejo de los eventos `guia.liberacion_solicitada`,
  `timbrado.exitoso`, `timbrado.error` en `handleMessage()` — cuando se
  implementen esos eventos del lado del backend, el frontend actual
  necesitará agregarles casos explícitos (siguiendo el mismo patrón de
  `addNewGuia()`, pero moviendo/creando tarjetas en los otros paneles en
  vez de solo insertar en "Generadas").
