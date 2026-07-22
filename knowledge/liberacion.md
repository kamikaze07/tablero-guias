# Flujo de Liberación de Guías — Estado Actual en ATLAS

> Documento central para planear la integración Sistema de Guías ↔ ATLAS.
> **Nota de vigencia**: este documento describía el estado del proyecto
> *antes* de los sprints "Solicitudes de Liberación" y "Tablero de
> Facturación". Buena parte de la §1 (tabla de qué existe/no existe) ya
> **no** refleja el código actual — se conserva sin reescribir a fondo
> porque el razonamiento de las secciones §2 en adelante (qué define el
> diseño, reglas de negocio) sigue siendo válido y es la referencia
> original de esas decisiones. Para el estado real y actualizado, ver
> `knowledge/modules/solicitudes-liberacion/*.md` (diseño +
> implementación de recepción y de Facturación) y
> `knowledge/modules/solicitudes-liberacion/sicret-legacy-liberacion-spec.md`
> (comportamiento exacto de "Liberar" en el SICRET legado). Resumen de lo
> que cambió desde que se escribió este documento:
> - El flujo de **recepción** de solicitudes (crear/listar/detalle) **sí
>   está implementado**: `App\Liberacion\SolicitudLiberacionService`,
>   `public/api/solicitudes-liberacion.php`.
> - El **Tablero de Facturación** (revisar/aprobar/rechazar) **sí
>   existe**: `public/facturacion.php`, `App\Liberacion\SolicitudLiberacionService::aprobar()`/`rechazar()`.
> - La **ejecución/confirmación** contra SICRET también existe como
>   Runtime completo (`App\Liberacion\Execution\LiberacionExecutor`,
>   `App\Monitoring\Liberacion\LiberationConfirmationWatcher`), aunque
>   `App\Infrastructure\Sicret\PdoSicretGateway::liberar()` sigue siendo
>   un placeholder deliberado — toda solicitud aprobada termina hoy en
>   `ERROR`, no en éxito real contra SICRET. Completar esa pieza sigue
>   pendiente de un sprint futuro.

## 1. ¿Existe hoy el flujo de liberación?

**No, no como funcionalidad operable.** Lo que existe:

| Pieza | Estado |
|---|---|
| Documento de diseño del Dashboard (`docs/03-ui/01-dashboard-trafico.md`) | Completo — describe el panel "Solicitadas a Liberación" y sus reglas |
| Documento de diseño de la Mesa Operativa (`docs/03-ui/02-mesa-operativa-trafico.md`) | Completo — describe la herramienta que dispararía la solicitud |
| Tabla en base de datos para solicitudes de liberación | **No existe** |
| Columna de estado operativo del tablero en `guias` | **No existe** (el `estado` actual es un valor crudo de SICRET, no del flujo) |
| Endpoint HTTP para solicitar liberación | **No existe** (el único endpoint HTTP de todo ATLAS es `/api/heartbeat.php`) |
| Evento `guia.liberacion_solicitada` disparado por algún componente | **No existe** — está *nombrado* en el diseño pero ningún código lo publica |
| Vista/HTML/JS de la Mesa Operativa | **No existe** — ni un archivo |
| Manejo del evento en el frontend del Dashboard | **No existe** — `trafico.js` solo tiene un `if` para `'guia.detectada'` |
| Columna "panel-liberacion" en el Dashboard | Existe visualmente (HTML + CSS + contador), permanece vacía siempre (0) |
| Sonido de "liberación solicitada" | Existe el archivo y el método `SoundManager.playReleaseRequested()`, nunca invocado |

## 2. Qué SÍ define el diseño (aunque no esté implementado)

### 2.1 Entidades que participan (según diseño)

- **Guía** — la entidad ya existente (tabla `guias` de ATLAS), replicada
  desde SICRET por el Synchronization Engine.
- **Solicitud de liberación** — entidad **todavía no modelada**. El
  diseño solo compromete que debe quedar "registrada en ATLAS de forma
  consultable (qué guía, cuándo se solicitó)" — sin definir aún si es una
  tabla propia, una columna de estado + timestamp en `guias`, o algo distinto.
- **Operador de Tráfico** — quien solicita la liberación desde la Mesa
  Operativa. El diseño **explícitamente pospone** usuarios/roles/permisos
  a un sprint futuro (`docs/03-ui/02-mesa-operativa-trafico.md §18`), así
  que hoy no hay ninguna noción de "quién" solicitó nada.
- **Facturación** — el módulo consumidor futuro de las solicitudes
  (revisar/aceptar/rechazar/liberar realmente). **No existe ningún
  código, vista, ni tabla de este módulo.**
- **CFDIWatcher** — un futuro `Watcher` (siguiendo la misma interfaz
  `App\Sync\Watcher` que ya usa `GuideWatcher`) que monitorearía el
  sistema de archivos en busca de XML/PDF (éxito) o YAML (error) de
  timbrado. **No existe ninguna clase `CFDIWatcher` en el código.**

### 2.2 Tablas que intervendrían (hoy) vs. las que faltan

**Hoy interviene únicamente**: `guias` (de ATLAS) — es de donde saldría
cualquier guía candidata a liberación, y donde (según se decida) se
marcaría su nuevo estado.

**Haría falta crear** (sin que el diseño haya decidido la forma exacta,
citando textualmente el propio documento de diseño): una representación
del estado operativo del tablero, y un registro de la solicitud en sí. Dos
formas posibles que el propio documento deja abiertas (no elegidas, se
listan aquí solo como lectura de las opciones que el código actual no
descarta ni confirma):
- Una columna de estado propio en `guias` (p. ej. `board_status`) más
  columnas de auditoría (`requested_at`, y cuando exista el concepto,
  `requested_by`).
- Una tabla separada `liberacion_solicitudes` (o similar) con FK a
  `guias.id`, para soportar de forma más natural un histórico o una
  relación 1-a-muchos si en el futuro una guía pudiera tener más de un
  evento de este tipo.

Ninguna de las dos existe en `database/schema.sql` hoy.

### 2.3 Endpoints que existen vs. los que se necesitarían

**Existen hoy**: ninguno relacionado a liberación. El único endpoint HTTP
de datos de todo ATLAS es `GET /api/heartbeat.php` (ver `api.md`).

**Se necesitarían** (inferido del diseño, no implementado, nombres no
comprometidos por ningún documento):
- Un endpoint de lectura para que la Mesa Operativa liste/filtre/busque
  las guías del día en estado "Generada" (el diseño aclara que **no** debe
  duplicar la definición de "guía del día" que ya usa
  `GuiaBoardRepository::findToday()`, sino construirse sobre la misma
  noción, posiblemente con su propio repositorio de lectura).
- Un endpoint de escritura para registrar la solicitud de liberación sobre
  una o varias guías (operación por lote, según §11-13 del diseño de Mesa
  Operativa) — sería, según el propio documento, "la primera escritura de
  estado propio de ATLAS que no proviene de SICRET ni del filesystem, sino
  de una acción de un operador".

### 2.4 Qué información necesitaría una solicitud de liberación (según diseño)

El diseño no especifica un payload exacto, pero de los documentos se
puede derivar el mínimo necesario:
- Uno o varios identificadores de guía (`guias.id` de ATLAS, o
  equivalentemente `source` + `num_guia`) — la operación es siempre por
  lote, nunca de a una sola guía obligatoriamente.
- Confirmación explícita del operador (el modal de confirmación de la Mesa
  Operativa es parte del flujo, no opcional — "la acción es irreversible
  desde este módulo", §12 del diseño de Mesa Operativa).
- Ningún campo de "motivo" ni "comentario" está contemplado en esta fase
  (se pospone explícitamente a Facturación, §17-18).

### 2.5 Qué información devolvería el sistema (según diseño)

Tampoco especificada como contrato de API, pero se infiere:
- Confirmación de qué guías quedaron marcadas como "Solicitada a
  Liberación" (para que la Mesa Operativa las retire de lo seleccionable,
  §11 del diseño).
- El evento `guia.liberacion_solicitada` publicado por WebSocket (mismo
  mecanismo que `guia.detectada`, reutilizando `SocketEventPublisher` →
  puerto 8099 → `TrafficDashboard::broadcast()` → puerto 8098) para que
  **todas** las sesiones (tanto Dashboard como Mesa Operativa) reflejen el
  cambio sin recargar.

### 2.6 Qué eventos se generarían y cómo se notificarían (diseño)

| Evento | Quién lo dispararía | Efecto esperado (según diseño) |
|---|---|---|
| `guia.liberacion_solicitada` | La futura Mesa Operativa, tras persistir la solicitud en ATLAS | Dashboard: mueve la(s) tarjeta(s) de "Guías Generadas" a "Solicitadas a Liberación". Mesa Operativa (todas las sesiones): retira la guía de lo seleccionable/accionable |
| `timbrado.exitoso` | Futuro `CFDIWatcher` (no implementado) | Dashboard: mueve la tarjeta a "Resultado del Timbrado" con indicador 🟢 |
| `timbrado.error` | Futuro `CFDIWatcher` (no implementado) | Dashboard: mueve la tarjeta a "Resultado del Timbrado" con indicador 🔴 |

El mecanismo de notificación sería **el mismo que ya funciona hoy** para
`guia.detectada`: persistir primero en la base de datos de ATLAS, luego
publicar por el socket interno (8099), que Ratchet retransmite (8098) a
todos los navegadores conectados. No haría falta un canal nuevo — el
diseño lo dice explícitamente: "reutilizando el mismo publicador interno
... sin inventar un canal nuevo" (§15 del diseño de Mesa Operativa).

## 3. Reglas de negocio ya decididas por el diseño (aunque no codificadas)

Estas reglas están documentadas con bastante precisión y son las que
cualquier implementación futura (incluida la integración con el Sistema de
Guías) debería respetar:

1. El paso de "Generada" a "Solicitada a Liberación" es **irreversible**
   desde ATLAS — no hay mecanismo de deshacer ni de regresar la tarjeta.
2. La solicitud puede aplicarse a **una o varias guías a la vez** (por
   lote) — coincide exactamente con lo que el Sistema de Guías necesita
   poder disparar.
3. El backend siempre persiste antes de notificar — ninguna UI (Dashboard,
   Mesa Operativa, o un futuro cliente externo como el Sistema de Guías)
   debe asumir el cambio de forma optimista.
4. Solo se puede solicitar liberación sobre guías en estado "Generada" —
   una guía ya solicitada por otra sesión/usuario debe rechazarse o
   ignorarse, nunca duplicarse.
5. ATLAS **nunca** escribe en SICRET como parte de este flujo — "liberar"
   en el sentido de negocio ocurre, en algún punto futuro, en el módulo de
   Facturación (aún no diseñado en detalle) o eventualmente en SICRET
   mismo; ATLAS solo registra y distribuye el *estado de la solicitud*.
6. El tablero (y por lo tanto cualquier lectura de "guías disponibles para
   liberar") solo contempla el **día en curso** — una integración externa
   que quiera saber qué guías son liberables debe tener en cuenta este
   corte diario.

## 4. Implicación directa para la integración con el Sistema de Guías

El objetivo final declarado por el usuario es que, desde el Sistema de
Guías, se pueda **solicitar** la liberación de una o varias guías,
"manteniendo la lógica de negocio dentro de ATLAS". A la luz de todo lo
anterior:

- **Esa lógica de negocio, hoy, no existe dentro de ATLAS** — habría que
  construirla ahí (tabla/columna de estado, endpoint de escritura, emisión
  del evento) antes o como parte de la integración, no asumir que ya está
  disponible para consumirse.
- El punto de entrada más natural, seguido a la letra del diseño existente,
  sería un **endpoint HTTP nuevo en ATLAS** (p. ej. bajo `public/api/`,
  seguido del mismo patrón simple que `heartbeat.php`, o una clase
  dedicada en un futuro namespace `App\Liberacion`/similar) que el Sistema
  de Guías invoque para registrar la solicitud — en vez de que el Sistema
  de Guías escriba directamente en la base de datos `atlas` (lo cual
  rompería la separación de responsabilidades que ambos proyectos
  declaran explícitamente en sus respectivos `CLAUDE.md`).
- El identificador común entre ambos sistemas sería `num_guia` (formato
  `PR000000`, ya usado igual en el Sistema de Guías) junto con `source`
  (`sicrePR`/`sicreGero`) para desambiguar entre empresas — ambos
  proyectos ya comparten ese vocabulario porque leen de las mismas bases
  SICRET.
- Ninguna de las dos partes (Sistema de Guías, ATLAS) tiene hoy usuarios ni
  autenticación — si la integración requiere saber "quién" solicitó la
  liberación, esa pieza no existe en ninguno de los dos sistemas y tendría
  que decidirse como parte del trabajo de integración, no asumirse.

## 5. Fuera de alcance (explícitamente, según el propio diseño de ATLAS)

Confirmado en `docs/03-ui/02-mesa-operativa-trafico.md §18`: timbrado,
CFDIWatcher, Mattermost, usuarios, roles, permisos, historial, auditoría,
rechazos, comentarios — nada de esto debe inferirse ni darse por hecho al
planear la integración; son decisiones de producto todavía no tomadas por
el equipo de ATLAS.
