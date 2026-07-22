# Integración con trafico-system (Sistema de Guías) — Referencia Oficial

> **⚠️ PARCIALMENTE OBSOLETO.** Este documento describe un momento en el que
> Solicitar Liberación en trafico-system solo hacía `console.log()` (§3, §5,
> §7) y Solicitar Timbrado no existía. Ambos ya están implementados de punta
> a punta (endpoint real en trafico-system + receptor real en ATLAS). Para
> el estado actual ver `knowledge/solicitudes-guias.md` de trafico-system
> (los 5 puntos: qué hace cada proceso, qué recibe ATLAS, qué falta del lado
> de Facturación) y `knowledge/modules/solicitudes-timbrado/overview.md` de
> este repo. El resto de este documento (arquitectura de trafico-system,
> ausencia de autenticación, formato de `num_guia`, etc.) sigue vigente.
>
> Generado a partir de `knowledge/` de `trafico-system` (carpeta hermana en
> el servidor, `/home/servidor/trafico-system`) y de lectura directa de su
> código fuente, específicamente `app/views/guias.php`. **trafico-system se
> trató en todo momento como solo lectura** — no se modificó ningún archivo
> de ese repositorio. Este documento es la referencia que ATLAS debe usar
> para implementar la recepción de solicitudes de liberación sin volver a
> explorar trafico-system, hasta que este documento se quede obsoleto y
> deba regenerarse.

---

## 1. Propósito del Sistema de Guías (trafico-system)

Es el panel web interno de **Forsis** que sirve de interfaz alterna al
sistema legacy de escritorio **SICRET** — no lo reemplaza, lee y **escribe**
directamente sobre las mismas tablas MySQL/MariaDB que usa el cliente Java
original. Su módulo central es **Guías** (`/guias`): listar, dar de alta,
copiar e imprimir guías de transporte (cartas porte).

Es, en esencia, la aplicación donde **nace** cada guía (vía `GuardarGuiaService`,
la única puerta de `INSERT` hacia `sicrePR`) — la misma fuente que
`GuideWatcher` de ATLAS detecta por polling. ATLAS y trafico-system son hoy
**consumidores independientes de las mismas bases SICRET**, sin conexión
directa entre ambos todavía.

## 2. Responsabilidades (y dónde termina cada sistema)

| | trafico-system | ATLAS |
|---|---|---|
| Alta / edición / copia de guías en SICRET | Sí (única puerta de escritura real hacia `sicrePR`) | Nunca — solo lectura de SICRET |
| Detección de guías nuevas | No (no hay polling ni watcher) | Sí — `SynchronizationEngine` + `GuideWatcher`, cada 2s |
| Selección de guías + intención de "solicitar liberación" | Sí — ya construido en `guias.php` (ver §5) | No existe hoy ningún receptor |
| Registrar la solicitud de liberación como estado consultable | No — hoy solo hace `console.log()`, no persiste nada | Debe construirse (no existe ninguna tabla/columna hoy, ver `knowledge/liberacion.md`) |
| Notificar el cambio en tiempo real a otras pantallas | No aplica (no hay backend de esto en trafico-system) | Sí, vía el mismo canal interno que ya usa `SocketEventPublisher` → `TrafficDashboard::broadcast()` (puerto 8098) |
| "Liberar" la guía en el sentido de negocio final | No | Tampoco — queda para el futuro módulo de Facturación; ATLAS solo registra y distribuye el *estado de la solicitud* |

## 3. Flujo funcional (extremo a extremo, incluyendo la parte que falta)

```
SICRET / trafico-system genera una guía (tabla `guias` en sicrePR)
        │
        ▼
GuideWatcher (ATLAS) la detecta por polling y la replica en `atlas.guias`
        │
        ▼
Operador de Tráfico abre /guias en trafico-system
        │
        │  marca uno o varios checkboxes de la tabla (chk-guia)
        ▼
Aparece la barra de acciones de selección ("N guía(s) seleccionada(s)")
        │
        │  click "Solicitar Liberación"
        ▼
Se abre el modal "Solicitar Liberación": lista los folios seleccionados,
exige un campo de texto "Motivo" (obligatorio, no vacío)
        │
        │  click "Solicitar Liberación" (botón del modal, habilitado
        │  solo cuando el motivo no está vacío)
        ▼
confirmarSolicitudLiberacion() arma el objeto `solicitud` (ver §7)
        │
        ▼
HOY: console.log(solicitud) — el comentario en el propio código dice
"Punto de integración para un sprint posterior (ATLAS)". No se envía
nada por red, no hay fetch/POST, no se persiste en ningún lado.
        │
        ▼
FUTURO (a implementar): POST hacia un endpoint HTTP nuevo en ATLAS
        │
        ▼
ATLAS registra la solicitud (persistencia primero, según su propia regla
"backend = fuente de verdad") y publica el evento `guia.liberacion_solicitada`
por el canal interno existente (puerto 8099 → Ratchet → 8098)
        │
        ▼
Dashboard de ATLAS mueve la(s) tarjeta(s) a "Solicitadas a Liberación"
(el panel ya existe visualmente, solo espera a que algo lo alimente)
```

## 4. Arquitectura relevante de trafico-system (solo lo que toca esta integración)

- **Sin framework, sin build step**: PHP puro + JS vanilla embebido por
  vista, Tailwind por CDN. No hay `package.json`, no hay bundler — cualquier
  cambio futuro para hacer el `fetch()` real hacia ATLAS se editaría
  directamente en el `<script>` de `app/views/guias.php`.
- **Sin autenticación en ningún punto** (ni trafico-system ni ATLAS tienen
  usuarios/roles hoy) — si la integración necesita saber "quién" solicitó la
  liberación, esa pieza no existe en ninguno de los dos sistemas.
- **El listado de `/guias` solo consulta `SicretDatabase` (BD `sicrePR`,
  empresa FORSIS)**. `GuiasModel::listarGuias()` no toca `SicretGeroDatabase`
  (GERO) — confirmado leyendo `app/modules/guias/models/GuiasModel.php` vía
  `knowledge/guias.md` y `knowledge/database.md` de trafico-system. **Esto
  implica que, tal como está construida la UI hoy, la funcionalidad de
  "Solicitar Liberación" solo puede originarse desde guías de la empresa
  FORSIS (`sicrePR`)** — no hay ruta para seleccionar guías GERO desde este
  módulo todavía, aunque ATLAS sí sincroniza ambas fuentes.
- **`num_guia` es el identificador natural compartido** entre ambos
  sistemas (formato `PRxxxxxx`), porque ambos leen/escriben sobre la misma
  tabla `guias` de SICRET.
- El propio código de trafico-system ya asume la integración: el comentario
  inline en `guias.php` dice textualmente que la sección es "Únicamente
  experiencia de usuario en el frontend: no se envía ninguna información a
  ningún backend ni a ATLAS" — es decir, **el equipo de trafico-system ya
  construyó la UI a la espera explícita de que ATLAS exponga un endpoint**.

## 5. UI ya construida en trafico-system (`app/views/guias.php`)

Verificado directamente en el código (la documentación en
`trafico-system/knowledge/guias.md` está **desactualizada** en este punto:
afirma que "no existe selección múltiple", lo cual ya no es cierto):

- **Columna de checkbox** por fila (`class="chk-guia"`) + checkbox
  "seleccionar todas" en el encabezado (`#chk-seleccionar-todas`, con estado
  `indeterminate` cuando la selección es parcial).
- **Estado de selección en memoria**: `const guiasSeleccionadas = new Map()`
  (clave = `num_guia`, valor = el objeto completo de la fila, tomado de
  `data-guia` que a su vez es `JSON.stringify(guia)` de la respuesta de
  `/api/guias`). La selección se conserva al repaginar
  (`restaurarSeleccionEnTabla()`), pero **no persiste entre búsquedas que
  reemplazan el DOM más allá de lo que ya esté en el Map** ni entre recargas
  de página (no hay `localStorage` para esto).
- **Barra de acciones contextual** (`#barra-acciones-liberacion`): oculta
  hasta que `guiasSeleccionadas.size > 0`; muestra contador y dos botones
  ("Limpiar selección" → `limpiarSeleccionGuias()`, "Solicitar Liberación" →
  `abrirModalLiberacion()`).
- **Modal "Solicitar Liberación"** (`#modal-liberacion`): lista los folios +
  operador de cada guía seleccionada, un `<textarea>` obligatorio de
  "Motivo" (el botón de confirmar permanece `disabled` hasta que el motivo
  no esté vacío, vía `validarFormularioLiberacion()`), y botón de confirmar
  que invoca `confirmarSolicitudLiberacion()`.
- Al confirmar: arma el objeto, hace `console.log()`, cierra el modal y
  limpia la selección — **no hay manejo de error, loading state, ni
  respuesta esperada de ningún servidor**, porque hoy no se llama a ninguno.

## 6. Datos disponibles por guía (estructura exacta)

Cada guía seleccionable en la tabla proviene tal cual de `GET /api/guias`
(`GuiasModel::listarGuias()`), sin transformación adicional antes de
guardarse en el `Map` de selección. Columnas presentes en cada objeto:

| Campo | Tipo / formato | Nota |
|---|---|---|
| `num_guia` | string, `"PR012345"` | Folio, identificador natural compartido con ATLAS |
| `fecha` | string, `"YYYY-MM-DD HH:MM:SS"` | Fecha de la guía en SICRET |
| `tipo` | string | Tipo de guía tal como lo captura SICRET |
| `servicio` | string | p. ej. `"FLETE"` |
| `operador` | string | Nombre del operador/chofer |
| `estatus` | string | Valor crudo de SICRET, p. ej. `"<Por Timbrar>"` (incluye símbolos `<`/`>` literales) |
| `km` | string/numérico | Kilometraje |

**No incluye** `source`/empresa explícito en el objeto — se puede asumir
`sicrePR` (FORSIS) siempre, dado que es la única fuente que consulta esta
vista (ver §4), pero **no viene declarado en el payload**; si en el futuro
se habilita selección de guías GERO desde esta misma UI, este supuesto deja
de sostenerse y habría que agregarlo explícitamente.

**Correspondencia con `atlas.guias`** (ver `database/schema.sql` de ATLAS):
los siete campos de arriba mapean 1:1 por nombre a columnas ya existentes en
la tabla `guias` de ATLAS (`num_guia`, `fecha`, `tipo`, `servicio`,
`operador`, `estatus`, `km`) — no hace falta traducir nombres de campo al
recibir el payload, solo resolver la fila de ATLAS por `num_guia` (y
`source`, una vez que se decida cómo desambiguarlo).

## 7. Payload esperado (forma exacta del objeto que hoy solo se loguea)

`confirmarSolicitudLiberacion()` en `guias.php` construye y hace
`console.log()` de este objeto — es, textualmente, el contrato que ATLAS
debería aceptar en su futuro endpoint:

```json
{
  "guias": [
    {
      "num_guia": "PR012345",
      "fecha": "2026-07-15 10:30:00",
      "tipo": "...",
      "servicio": "FLETE",
      "operador": "JUAN PEREZ",
      "estatus": "<Por Timbrar>",
      "km": "120.50"
    }
  ],
  "motivo": "texto libre capturado por el operador, no vacío",
  "total": 1
}
```

Notas importantes:

- `guias` es siempre un arreglo (batch), incluso con una sola guía
  seleccionada — coincide con la regla de negocio ya documentada en
  `knowledge/liberacion.md` de ATLAS ("la operación es siempre por lote").
- `total` es puramente redundante (`guias.length`) — no aporta información
  nueva, pero está presente en el objeto tal cual se genera hoy.
- **`motivo` es un hallazgo que contradice el diseño interno de ATLAS**: los
  documentos `docs/03-ui/01-dashboard-trafico.md` y
  `docs/03-ui/02-mesa-operativa-trafico.md` (§17-18) asumen explícitamente
  que "ningún campo de motivo/comentario está contemplado en esta fase" y lo
  posponen a Facturación. trafico-system, sin embargo, **ya construyó el
  campo como obligatorio** en su modal. Esta discrepancia debe resolverse
  como decisión de producto antes de implementar el endpoint receptor: o
  ATLAS acepta y persiste `motivo` desde ya, o se le pide a trafico-system
  que deje de exigirlo. No se puede asumir ninguna de las dos por lectura de
  código — es una decisión pendiente del usuario.
- No hay ningún campo de "quién" solicita (no hay usuarios en ninguno de los
  dos sistemas).
- No hay `source`/empresa en el payload (ver §6).

## 8. Restricciones de integración

1. **ATLAS nunca debe escribir en SICRET** como parte de este flujo (regla
   ya vigente en `CLAUDE.md` de ATLAS) — trafico-system seguirá siendo el
   único sistema con permiso de escritura sobre `sicrePR`. El endpoint
   receptor de ATLAS solo debe escribir en la base de datos propia de ATLAS.
2. **No hay autenticación en ninguno de los dos sistemas** — el endpoint de
   ATLAS, si se expone en la misma red sin control de acceso, hereda el
   mismo riesgo que ya tiene trafico-system (cualquiera con acceso de red
   puede invocarlo). Debe decidirse si esto es aceptable para una primera
   versión o si se requiere algún control mínimo (IP allowlist, token
   compartido) antes de exponerlo.
3. **El identificador de guía no es garantizado único entre empresas** sin
   `source` — mientras trafico-system no lo incluya en el payload (§6),
   ATLAS debe decidir explícitamente cómo resolver la guía (asumir
   `sicrePR` siempre, o exigir que trafico-system lo agregue al payload
   antes de integrar).
4. **trafico-system es de solo lectura para este proyecto** — cualquier
   cambio necesario del lado de trafico-system (p. ej. reemplazar el
   `console.log()` por un `fetch()` real hacia el endpoint de ATLAS, o
   agregar `source` al payload) es trabajo de otro repositorio/equipo, no
   algo que ATLAS pueda o deba tocar.
5. **El campo `motivo` es un contrato no confirmado** (ver §7) — no debe
   asumirse como parte definitiva del payload hasta resolver la
   discrepancia con el diseño de Facturación.
6. **Solo cubre guías FORSIS (`sicrePR`) hoy** — no existe todavía un
   camino para solicitar liberación de guías GERO desde trafico-system.
7. La documentación (`knowledge/`) de trafico-system puede quedar
   desactualizada respecto al código real, como ya ocurrió con la selección
   múltiple (ver §5) — cualquier decisión de integración de alto riesgo
   debería reverificarse contra el código fuente vigente en el momento de
   implementar, no solo contra esa documentación.

## 9. Futuras ampliaciones (fuera de alcance de este documento, mencionadas por completitud)

- Reemplazar el `console.log()` de trafico-system por un `fetch()` real
  hacia el endpoint que ATLAS exponga (cambio en trafico-system, no en
  ATLAS).
- Incluir `source` en el payload para soportar guías GERO.
- Resolver si `motivo` se persiste desde esta fase o se descarta hasta
  Facturación.
- Endpoint de **lectura** en ATLAS (mencionado en el diseño de Mesa
  Operativa, `docs/03-ui/02-mesa-operativa-trafico.md §15`) para listar
  guías del día en estado "Generada" — necesario si en el futuro se decide
  construir una Mesa Operativa dentro de ATLAS en vez de (o además de)
  recibir solicitudes desde trafico-system.
- Mecanismo de concurrencia: si dos operadores seleccionan la misma guía
  desde dos pestañas de trafico-system a la vez, no hay hoy ningún bloqueo
  ni verificación — el diseño de Mesa Operativa (§11) ya contempla esta
  regla para su propio front, pero trafico-system no la implementa porque
  no tiene forma de saber el estado operativo de ATLAS (no lee de ATLAS en
  ningún punto).
- Notificación de vuelta hacia trafico-system (p. ej. que el listado
  refleje que una guía ya fue solicitada) — hoy no existe ningún mecanismo
  en sentido ATLAS → trafico-system; el único canal en tiempo real
  (WebSocket puerto 8098) es interno de ATLAS y no lo consume
  trafico-system.
