# Backend — Inventario de Clases PHP

Todas las clases usan `declare(strict_types=1)`, tipado estricto en
propiedades/parámetros/retornos, y son `final` (cerradas a herencia) salvo
las interfaces. Namespace raíz `App\`, PSR-4 desde `app/`.

## `App\Config`

### `Config`
Única responsabilidad: leer variables de entorno (`getenv()`) con un
default opcional. No cachea, no valida, no lanza si falta una variable
(devuelve `null`/el default). Es el único punto de acceso a `.env` en todo
el proyecto — nada lee `$_ENV`/`getenv()` directamente fuera de esta clase.

## `App\Database`

### `ConnectionFactory`
Construye un `PDO` MySQL a partir de un array `['host','port','database',
'username','password']`. Fuerza `PDO::ERRMODE_EXCEPTION` y **fija la zona
horaria de la sesión MySQL a `-06:00`** vía
`PDO::MYSQL_ATTR_INIT_COMMAND` — detalle relevante porque las guías vienen
de SICRET con sus propias fechas; ATLAS normaliza la zona horaria en cada
conexión que abre (tanto hacia `atlas` como hacia cualquier fuente SICRET).
Es la **única** forma de abrir una conexión en todo el proyecto — se usa
tanto para la base propia como para las 4 fuentes SICRET (a diferencia del
Sistema de Guías, que tiene una clase `*Database` distinta por cada base).

## `App\Sync` — el Synchronization Engine

Namespace con más responsabilidad del proyecto. Componentes:

### `SynchronizationEngine`
Orquestador de nivel superior. Recibe un array de `Watcher[]` (hoy solo
uno: `GuideWatcher`), un `HeartbeatStore` y el intervalo de polling.
`start()` es un bucle infinito (`while (true) { runCycle(); sleep(N); }`)
— es el propio proceso de larga vida, no hay un cron externo. Cada ciclo
está envuelto en `try/catch(\Throwable)`: un error en un watcher nunca
tumba el proceso, se registra en el heartbeat como `status = 'error'` y el
bucle continúa en la siguiente iteración.

### `Watcher` (interfaz)
Contrato mínimo: `run(): int` (devuelve cuántos registros nuevos se
confirmaron). Permite que `SynchronizationEngine` sea agnóstico a qué
vigila cada watcher — **hoy solo hay una implementación** (`GuideWatcher`),
pero el diseño ya admite agregar otros (p. ej. un futuro `CFDIWatcher` de
sistema de archivos, mencionado en la documentación de diseño pero sin
ninguna clase creada todavía).

### `GuideWatcher implements Watcher`
El único watcher real. Por cada `Source` registrada (ver `SourceRegistry`):
1. Lee el checkpoint actual (`CheckpointStore::get()`).
2. Trae hasta 500 filas de la tabla `guias` de esa fuente con
   `num > checkpoint` (y, si es la primera ejecución contra esa fuente,
   además `fecha >= hoy`).
3. Por cada fila: construye un `GuiaRecord`, la inserta en ATLAS
   (`GuiaRepository::insert()`), avanza el checkpoint, y si la inserción
   fue nueva (no duplicada) publica el evento `guia.detectada`.
4. Repite en lotes de 500 hasta que un lote venga incompleto.

### `GuiaRecord`
Value object inmutable (`readonly`) con los ~35 campos de una guía tal
como los expone SICRET (`num`, `num_guia`, `folio_imp`, `fecha`, `estado`,
`nombre`, `tipo`, `servicio`, `operador`, `factura`, `prefactura`, etc.).
`fromSourceRow()` es la única forma de construirlo, mapeando explícitamente
cada columna de la fila cruda de SICRET (con casts a `int`/`float`/
`string`/`DateTimeImmutable`) — no hay mapeo automático ni reflection.

### `GuiaRepository`
Encapsula el único `INSERT` de todo el módulo. Devuelve `null` (sin lanzar
excepción) si el `INSERT` colisiona con la clave única `(source,
source_num)` — salvaguarda de duplicados independiente del checkpoint (por
si el checkpoint se desincroniza o el proceso se reinicia a mitad de un
lote). Cualquier otro error de PDO sí se relanza.

### `CheckpointStore`
Lee/escribe `sync_checkpoints`. `update()` usa
`ON DUPLICATE KEY UPDATE last_num = GREATEST(last_num, VALUES(last_num))`
— **el checkpoint nunca retrocede**, incluso si se invoca fuera de orden
(protección explícita contra condiciones de carrera o reintentos).

### `HeartbeatStore`
Registra cada ciclo del engine en `sync_heartbeat` (upsert): estado
(`idle`/`error`), timestamp del ciclo, timestamp del último éxito (solo
avanza si no hubo error), último mensaje de error, contador acumulado de
ciclos y de registros sincronizados. Es la fuente de datos de
`HeartbeatRepository`/`/api/heartbeat.php`/el indicador "Motor activo" del
Dashboard.

### `Source` / `SourceRegistry`
`Source` envuelve una conexión PDO **perezosa** (`??=`, se conecta solo la
primera vez que se pide `connection()`) hacia una fuente SICRET.
`SourceRegistry` lee `config/sources.php` y arma un `Source` por cada
entrada, resolviendo sus credenciales desde variables de entorno según el
`env_prefix` declarado. **Solo hay 2 entradas activas hoy**
(`sicrePR`→`FORSIS_DB`, `sicreGero`→`GERO_DB`) — `sicre2PR` y `sicre2Gero`
tienen credenciales en `.env`/`.env.example` pero **no están registradas
en `config/sources.php`**, por lo que el `GuideWatcher` no las consulta
todavía (ver `improvement_notes.md`).

### `EventPublisher` (interfaz) / `SocketEventPublisher`
`EventPublisher::publish(string $event, array $payload): void` es el
contrato; `SocketEventPublisher` es la única implementación, y publica
abriendo un socket TCP crudo (`stream_socket_client`) hacia el WebSocket
server (host/puerto configurables, timeout de 2s) y escribiendo una línea
JSON. Ver `websocket.md` para el protocolo exacto.

### `SyncLogger`
Logger de archivo plano, sin niveles configurables más allá de
`info()`/`error()`, escribe en `storage/logs/sync-engine.log` con
`file_put_contents(..., FILE_APPEND)`. No hay rotación de logs.

## `App\Dashboard`

### `GuiaBoardRepository`
`findToday()`: única consulta de lectura para el panel "Guías Generadas" —
trae `id, source, num_guia, fecha, nombre, tipo, servicio, placas1, estado,
operador` de la tabla `guias` de ATLAS donde `fecha >= hoy`, ordenado por
`id DESC` (más reciente primero). Es la fuente del estado inicial que
`trafico.php` embebe en el HTML (`<script id="initial-guias">`).

**No existe ningún repositorio equivalente para "Solicitadas a Liberación"
ni "Resultado del Timbrado"** — consistente con que esos paneles no tengan
datos reales todavía.

### `HeartbeatRepository`
`latest(string $engineName)`: trae la fila más reciente de
`sync_heartbeat` para un motor dado. Usada por `heartbeat.php` para
calcular si el motor está "activo" (última corrida hace ≤10 segundos).

## `App\WebSocket`

### `TrafficDashboard implements MessageComponentInterface`
Implementación mínima del contrato de Ratchet: mantiene un
`SplObjectStorage` de conexiones abiertas (`onOpen`/`onClose`), ignora
cualquier mensaje entrante de un navegador (`onMessage` está vacío, con un
comentario explícito de que el dashboard es solo receptor), cierra la
conexión en error, y expone `broadcast(string $payload)` para reenviar un
mensaje ya armado a **todos** los clientes conectados. No hay salas/canales
— es un único broadcast global (coherente con "todas las sesiones ven el
mismo tablero", regla explícita de `docs/03-ui/01-dashboard-trafico.md`).

## Scripts `bin/` (entry points, no autoloaded por PSR-4 pero parte del backend)

| Script | Rol |
|---|---|
| `sync-engine.php` | Arma el árbol de dependencias del Synchronization Engine a mano y llama `$engine->start()` — proceso de larga vida |
| `websocket-server.php` | Arma el servidor Ratchet (puerto público + puerto interno) sobre el loop de eventos de ReactPHP — proceso de larga vida |
| `migrate.php` | Ejecuta `database/schema.sql` completo contra la BD de ATLAS (`$connection->exec($schema)`) — no hay versionado de migraciones, es un script idempotente por los `CREATE TABLE IF NOT EXISTS` |
| `check-connections.php` | Diagnóstico manual: intenta conectar a las 5 bases (ATLAS + FORSIS + FORSIS_2 + GERO + GERO_2) e imprime OK/FALLO por cada una — incluye ya las 4 fuentes SICRET aunque `sources.php` solo registre 2 para el watcher |

## Scripts `public/` (entry points HTTP)

| Script | Rol |
|---|---|
| `public/index.php` | Placeholder — solo `echo` de un string fijo, no arma nada. Nginx sirve esto como fallback de `/` |
| `public/trafico.php` | Entry point real del Dashboard: conecta a ATLAS, llama `GuiaBoardRepository::findToday()`, calcula el puerto de WebSocket desde config, y hace `require` de la vista |
| `public/api/heartbeat.php` | Único endpoint de datos JSON del proyecto — ver `api.md` |
