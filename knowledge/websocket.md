# WebSocket — Protocolo y Componentes

## 1. Dos sockets, dos propósitos, un solo proceso

`bin/websocket-server.php` levanta **un único proceso PHP** (bucle de
eventos de ReactPHP, `Loop::get()` + `$loop->run()`) que escucha en **dos
puertos distintos y con roles completamente distintos**:

| Puerto | Variable de entorno | Expuesto al host (`docker-compose.yml`) | Quién se conecta | Protocolo |
|---|---|---|---|---|
| `8098` | `WEBSOCKET_PORT` | Sí (`"${WEBSOCKET_PORT:-8098}:${WEBSOCKET_PORT:-8098}"`) | Navegadores (Dashboard, y en el futuro la Mesa Operativa) | WebSocket real (Ratchet: `IoServer` + `HttpServer` + `WsServer`) |
| `8099` | `WEBSOCKET_PUBLISH_PORT` | **No** — solo interno a la red Docker | Únicamente `SocketEventPublisher` (usado por `SynchronizationEngine`, y en el futuro por cualquier otro componente backend que necesite anunciar un evento) | TCP crudo, sin handshake WebSocket — una línea de texto JSON por evento, delimitada por `\n` |

Este diseño evita que el motor de sincronización necesite hablar el
protocolo WebSocket: simplemente abre un socket TCP normal
(`stream_socket_client`) y escribe una línea. El servidor Ratchet, del
otro lado, reenvía esa misma línea tal cual a todos los navegadores
conectados en el puerto público — es un **puente TCP→WebSocket**, no una
implementación de pub/sub con temas/canales.

## 2. Formato del mensaje

Definido por `SocketEventPublisher::publish()` y consumido tal cual (sin
transformación) por `TrafficDashboard::broadcast()`:

```json
{"event": "guia.detectada", "payload": {"id": 123, "source": "sicrePR", "num_guia": "PR225820", "fecha": "2026-07-16 18:37:36", "nombre": "CLIENTE X", "tipo": "...", "servicio": "FLETE", "placas1": "ABC-123", "estado": "..."}}
```

- Codificado con `json_encode(..., JSON_UNESCAPED_UNICODE)`.
- Una línea = un evento completo (el publicador termina cada mensaje con
  `"\n"`; el servidor lo bufferea y parte por `strpos($buffer, "\n")`,
  soportando mensajes que lleguen fragmentados o varios pegados en un
  mismo chunk TCP).
- **No hay envelope de versión, ni id de mensaje, ni timestamp de
  publicación** (solo el `fecha` de negocio dentro del payload) — si se
  agregan más tipos de evento, conviene decidir pronto si se necesita algo
  de eso para depuración/idempotencia en el cliente.

## 3. `TrafficDashboard` (servidor, puerto 8098)

Implementa `Ratchet\MessageComponentInterface`:
- `onOpen($conn)`: agrega la conexión a un `SplObjectStorage`.
- `onMessage($from, $msg)`: **vacío, a propósito** — el comentario en el
  código aclara que el dashboard "solo recibe eventos ya confirmados por
  el backend; no procesa mensajes entrantes de los navegadores". Es decir,
  hoy el canal público es **unidireccional** (servidor → navegador). Si en
  el futuro la Mesa Operativa necesitara enviar algo *por WebSocket* (en
  vez de por un endpoint HTTP), este método tendría que dejar de estar
  vacío — pero el diseño actual (ver `liberacion.md`) apunta a que la
  escritura de la solicitud de liberación sea vía HTTP, no vía este canal.
- `onClose($conn)`: quita la conexión del storage.
- `onError($conn, $e)`: cierra la conexión.
- `broadcast($payload)`: recorre **todas** las conexiones abiertas y les
  hace `send($payload)` — sin filtros, sin salas, sin autenticación de
  quién puede recibir qué. Todo cliente conectado ve todos los eventos.

## 4. Cliente (navegador, `trafico.js`)

```js
function connect() {
    const socket = new WebSocket(`ws://${window.location.hostname}:${WS_PORT}`);
    socket.addEventListener('open', () => setWsStatus('ok'));
    socket.addEventListener('message', handleMessage);
    socket.addEventListener('close', () => { setWsStatus('down'); setTimeout(connect, 2000); });
    socket.addEventListener('error', () => socket.close());
}
```

- Reconexión automática simple (2s fijos, sin backoff exponencial) tras
  cualquier cierre.
- `WS_PORT` se inyecta desde PHP como variable global JS
  (`const WS_PORT = <?= $websocketPort ?>;`) — el navegador siempre asume
  `ws://` (no `wss://`), consistente con que todo el proyecto corre hoy
  sin TLS.
- `handleMessage()` solo actúa sobre `message.event === 'guia.detectada'`
  — cualquier otro evento se recibiría pero no tendría manejador (ver
  `frontend.md §2` y `liberacion.md` para el detalle de qué falta).

## 5. Qué implica esto para agregar nuevos eventos (p. ej. `guia.liberacion_solicitada`)

Siguiendo el patrón ya existente, agregar un evento nuevo requeriría:
1. Del lado de quien lo dispare (hoy solo `GuideWatcher`; en el futuro,
   el componente de escritura de la Mesa Operativa/API de liberación):
   invocar `EventPublisher::publish('nombre.evento', $payload)` — la
   interfaz ya es genérica, no hay que tocar `SocketEventPublisher` ni el
   servidor Ratchet.
2. Del lado del servidor WebSocket: **ningún cambio** — `broadcast()` ya
   reenvía cualquier línea recibida sin inspeccionar su contenido.
3. Del lado del cliente (`trafico.js`): agregar un nuevo `case`/`if` en
   `handleMessage()` que reaccione al nuevo `event` (p. ej. moviendo una
   tarjeta del panel "generadas" al panel "liberacion" en vez de solo
   insertarla) — este es el único punto que sí requiere código nuevo hoy
   inexistente.

## 6. Seguridad del canal

- **Sin autenticación en ningún extremo.** Cualquiera que pueda alcanzar
  el puerto `8098` puede conectarse y recibir todos los eventos del
  Dashboard (que incluyen nombre de cliente, folio, operador, placas).
  Igual de abierto que el resto del sistema (ATLAS no tiene autenticación
  en ninguna capa, ver `improvement_notes.md`).
- El puerto interno `8099` **no está expuesto al host** en
  `docker-compose.yml` — solo alcanzable dentro de la red Docker del
  propio proyecto, lo cual mitiga (aunque no elimina del todo, si algo más
  comparte esa red Docker) que un tercero externo inyecte eventos falsos
  directamente al canal de publicación.
