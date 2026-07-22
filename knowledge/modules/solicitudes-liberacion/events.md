# Solicitudes de Liberación — Eventos y WebSocket

> Diseño únicamente. No se modifica `bin/websocket-server.php`,
> `App\WebSocket\TrafficDashboard`, ni `App\Sync\SocketEventPublisher` —
> el diseño completo de este módulo **reutiliza esa infraestructura tal
> cual está**, sin ningún cambio de código en ella. Ver §4.

---

## 1. Qué evento(s) emite este módulo

### 1.1 Decisión de nombre: `guia.liberacion_solicitada` (no `liberacion.solicitada`)

El enunciado del sprint sugiere, como ejemplo, nombres con prefijo
`liberacion.*` (`liberacion.solicitada`, `liberacion.aprobada`,
`liberacion.rechazada`). Este diseño **no adopta ese prefijo** para el
evento que sí se implementa ahora, por una razón concreta: el nombre
`guia.liberacion_solicitada` **ya existe** en la documentación de diseño
vigente de ATLAS —

- `docs/03-ui/01-dashboard-trafico.md §7`, tabla de eventos.
- `docs/03-ui/02-mesa-operativa-trafico.md §15`.
- `knowledge/websocket.md §5` (ejemplo explícito de cómo se agregaría).
- El propio frontend `trafico.js` ya reserva mentalmente ese nombre (no lo
  maneja todavía, pero es el que se espera, según `knowledge/websocket.md §4`).

Cambiarlo a `liberacion.solicitada` obligaría a re-decidir un nombre que
tres documentos previos ya fijaron, sin ningún beneficio — sería
inconsistencia por preferencia estética, no por necesidad. Se mantiene el
prefijo `guia.*` (a la par de `guia.detectada`, el único evento que existe
hoy) porque, semánticamente, **es la guía la que cambia de panel** — el
evento describe qué le pasó a la guía, no qué le pasó a la solicitud.

### 1.2 Único evento que este sprint emite

| Evento | Cuándo se publica | Quién lo publica |
|---|---|---|
| `guia.liberacion_solicitada` | Inmediatamente después del `COMMIT` de una `SolicitudLiberacion` creada exitosamente | `SolicitudLiberacionService`, vía `App\Sync\EventPublisher` (interfaz ya existente, sin cambios) |

### 1.3 Forma del payload

Se emite **un solo evento por solicitud** (no uno por guía dentro del
lote) — decisión explícita de diseño:

```json
{
  "event": "guia.liberacion_solicitada",
  "payload": {
    "solicitud_id": 481,
    "guias": [
      { "id": 9001, "num_guia": "PR012345" },
      { "id": 9002, "num_guia": "PR012346" }
    ]
  }
}
```

**Por qué un evento batched y no N eventos individuales** (como si se
llamara `guia.detectada` N veces): la regla de negocio ya fijada dice que
la solicitud "puede aplicarse a una o varias guías a la vez" y que el
Dashboard debe poder "mover la(s) tarjeta(s)" como una sola operación
visual (`docs/03-ui/01-dashboard-trafico.md §7`, nota "la(s)"). Publicar N
eventos separados funcionaría, pero obligaría al frontend a re-agrupar
visualmente N mensajes de WebSocket que en realidad describen una sola
acción del operador — más trabajo del lado del cliente sin necesidad. Un
evento con un array es más fiel a lo que realmente ocurrió.

### 1.4 Eventos agregados por el sprint "Tablero de Facturación"

| Evento | Quién lo publica | Cuándo |
|---|---|---|
| `solicitud_liberacion.aprobada` | `SolicitudLiberacionService::aprobar()` | Tras `UPDATE estado=APROBADA` (CAS) + historial `APROBADA`, tablero de Facturación (`PATCH /api/solicitudes-liberacion.php`, `accion=aprobar`) |
| `solicitud_liberacion.rechazada` | `SolicitudLiberacionService::rechazar()` | Tras la transacción que marca `RECHAZADA` + revierte cada guía del lote a `GENERADA` en `guia_estado_tablero` + historial `RECHAZADA` |

Los nombres se mantuvieron exactamente como este documento los sugirió
(prefijo `solicitud_liberacion.*`, no `guia.*`, por la misma razón ya
dada: son acciones sobre la solicitud como entidad). Mismo mecanismo de
publicación que `guia.liberacion_solicitada` — sin cambios a
`SocketEventPublisher`/`TrafficDashboard` (§4).

Además, este sprint conecta por primera vez del lado del **frontend**
(`public/assets/js/facturacion.js`) los eventos que
`App\Liberacion\Execution\LiberacionExecutor` y
`App\Monitoring\Liberacion\LiberationConfirmationWatcher` ya publicaban
desde su propio sprint sin que ningún cliente los escuchara:
`guia.liberacion_ejecutando`, `guia.liberacion_completada`,
`guia.liberacion_error`.

### 1.5 Eventos aún reservados, no emitidos por ningún sprint

| Evento | Quién lo emitiría (futuro) | Nota |
|---|---|---|
| `timbrado.exitoso` / `timbrado.error` | CFDIWatcher | Nombres **ya fijados** por `docs/03-ui/01-dashboard-trafico.md §7` — no se renombran aquí, solo se listan por completitud. |

---

## 2. Formato de mensaje — sin cambios al protocolo existente

Se reutiliza el formato exacto ya definido por `SocketEventPublisher::publish()`
y documentado en `knowledge/websocket.md §2`: `json_encode(['event' =>
..., 'payload' => ...], JSON_UNESCAPED_UNICODE)`, una línea terminada en
`\n`, sin envelope de versión ni id de mensaje (misma limitación ya
señalada para `guia.detectada` — no se resuelve aquí, ver
`future-considerations.md §6`).

---

## 3. Cómo se notificará el Dashboard (diseño, no implementación)

### 3.1 Lado backend — sin cambios de infraestructura
`SolicitudLiberacionService`, tras el `COMMIT`, construye una instancia de
`SocketEventPublisher` **exactamente igual** a como lo hace
`bin/sync-engine.php` hoy (mismo host/puerto, `WEBSOCKET_INTERNAL_HOST` /
`WEBSOCKET_PUBLISH_PORT`, leídos vía `Config`) y llama
`publish('guia.liberacion_solicitada', $payload)`. No hace falta ninguna
clase nueva en `App\WebSocket` ni en `App\Sync` — el contrato
`EventPublisher::publish(string, array): void` ya es suficientemente
genérico (confirmado en `knowledge/backend.md`, sección `EventPublisher`).

Detalle de robustez ya heredado gratis: si el socket TCP al puerto 8099
falla, `SocketEventPublisher` solo loguea y continúa (no lanza excepción) —
la creación de la solicitud **nunca falla por un problema de
notificación**, mismo comportamiento "best effort" que ya tiene
`guia.detectada` (ver `knowledge/architecture.md §4`, "puntos de diseño
importantes").

### 3.2 Lado servidor WebSocket — sin cambios
`TrafficDashboard::broadcast()` ya reenvía cualquier línea recibida por el
puerto 8099 a todas las conexiones del puerto 8098, sin inspeccionar su
contenido (confirmado en `knowledge/backend.md`, clase `TrafficDashboard`).
**No se toca `bin/websocket-server.php` para este módulo.**

### 3.3 Lado cliente (`trafico.js`) — fuera de este sprint, pero descrito para contexto
`handleMessage()` hoy solo tiene un caso (`guia.detectada`). Agregar el
manejo de `guia.liberacion_solicitada` requeriría (trabajo de un sprint de
frontend, no de este):
1. Por cada `guia` en `payload.guias`, ubicar su tarjeta en el panel
   "Guías Generadas" (por `id`) y moverla al panel "Solicitadas a
   Liberación" (`docs/03-ui/01-dashboard-trafico.md §6`).
2. Actualizar los contadores de ambos paneles.
3. Sin animación de "nueva tarjeta" (esa es exclusiva de `guia.detectada`)
   — la tarjeta ya existía, solo cambia de columna.

Este sprint **no implementa este punto** — se documenta para que el equipo
de frontend tenga el contrato exacto del evento cuando le toque.

### 3.4 Qué pasa si el evento se pierde (navegador desconectado, etc.)
Sin cambios respecto al comportamiento ya documentado: el estado real vive
en `guia_estado_tablero` (base de datos), no en el evento. Si una sesión se
reconecta después de perderse el evento, su estado inicial debe
reconstruirse leyendo la base de datos (mismo principio ya fijado en
`docs/03-ui/01-dashboard-trafico.md §9` para `guia.detectada`) — esto
implica que la consulta que alimenta el estado inicial del Dashboard
(hoy `GuiaBoardRepository::findToday()`, usada por `public/trafico.php`)
necesitará, en el sprint de implementación, empezar a leer también
`guia_estado_tablero` para saber en qué panel pintar cada tarjeta — cambio
menor, ya anticipado aquí para que no sea una sorpresa en ese sprint.

---

## 4. Resumen de qué NO cambia

Para que quede explícito, porque es el punto más importante de este
documento: **cero líneas de código existentes en `App\WebSocket`,
`App\Sync\SocketEventPublisher`, `App\Sync\EventPublisher`, o
`bin/websocket-server.php` cambian para soportar este módulo.** Toda la
capacidad nueva es aditiva (una llamada más a un método que ya existe,
desde una clase nueva). Esto es, en sí mismo, una validación de que el
protocolo interno de eventos de ATLAS ya estaba bien diseñado para
crecer — confirma lo que `knowledge/websocket.md §5` ya anticipaba.
