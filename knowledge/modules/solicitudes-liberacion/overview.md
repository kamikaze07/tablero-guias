# Solicitudes de Liberación — Visión General y Modelo de Negocio

> Documento de **diseño**, previo a implementación. No describe código
> existente — describe lo que el siguiente sprint deberá construir. Basado
> en `knowledge/integrations/trafico-system.md`, `knowledge/liberacion.md`,
> `docs/03-ui/01-dashboard-trafico.md`, `docs/03-ui/02-mesa-operativa-trafico.md`
> y en la arquitectura real de ATLAS (`knowledge/architecture.md`,
> `backend.md`, `database.md`, `websocket.md`, `api.md`).

---

## 1. Qué es una Solicitud de Liberación

Es el registro, propio de ATLAS, de que un operador de Tráfico —hoy
exclusivamente desde **trafico-system**, cuyo módulo de Guías ya tiene
construida la UI de selección múltiple y el modal "Solicitar Liberación"
(ver `knowledge/integrations/trafico-system.md §5`)— pidió que una o varias
guías avancen del estado operativo **Generada** al estado
**Solicitada a Liberación**, para que en algún momento posterior el futuro
módulo de **Facturación** decida si esas guías se liberan realmente.

Una Solicitud de Liberación:

- Es siempre una operación **por lote** (una o varias guías a la vez) —
  regla ya fijada en `docs/03-ui/02-mesa-operativa-trafico.md §13.3` y
  confirmada por la forma exacta del payload de trafico-system (`guias: []`).
- Tiene un **motivo** de texto libre capturado por el operador (ver
  `knowledge/integrations/trafico-system.md §7` para la discrepancia
  pendiente de resolver sobre este campo).
- **No libera nada por sí misma.** Es una pieza de información —
  "alguien pidió que esto se libere"— no una acción de negocio terminal.
  La liberación real (en el sentido de SICRET/timbrado) ocurre, si acaso,
  en un módulo futuro que no se diseña aquí.
- Es la **primera escritura de estado propio de ATLAS que no proviene de
  SICRET ni del sistema de archivos**, sino de una acción externa — dato ya
  señalado como significativo en `knowledge/liberacion.md §2.2` y en
  `docs/03-ui/02-mesa-operativa-trafico.md §15`.

## 2. Quién la crea

**Un sistema externo, no un usuario identificado.** Ni ATLAS ni
trafico-system tienen autenticación o modelo de usuarios (confirmado en
ambos `knowledge/architecture.md`). Por lo tanto:

- El creador técnico de una Solicitud de Liberación es siempre una llamada
  HTTP hecha en nombre de un sistema origen (`origen`, ver §3 y
  `database-design.md`), hoy únicamente `trafico-system`.
- No existe hoy forma de saber *qué persona* pulsó el botón — esto es una
  limitación heredada de ambos proyectos, no algo que este módulo pueda
  resolver por sí solo (ver `security.md §4`).
- El diseño deja la puerta abierta a que otros sistemas origen llamen al
  mismo mecanismo en el futuro (campo `origen`, no hardcodeado a
  `trafico-system` — ver `future-considerations.md §3`), incluyendo una
  eventual Mesa Operativa construida dentro del propio ATLAS (ver
  `future-considerations.md §1`).

## 3. Quién la atiende

**Nadie, en este sprint.** El módulo que revisa/aprueba/rechaza solicitudes
es **Facturación**, explícitamente fuera de alcance:

- `docs/03-ui/02-mesa-operativa-trafico.md §17`: "el futuro módulo de
  Facturación... se diseña en su propio sprint".
- `knowledge/liberacion.md §2.1`: "Facturación... no existe ningún código,
  vista, ni tabla de este módulo".

Este sprint diseña (y el siguiente implementará) **solo el lado receptor**:
recibir la solicitud, validarla, persistirla, mover el estado operativo del
tablero, y notificar. El ciclo de vida completo de una solicitud —incluida
su resolución— se documenta en `workflow.md` para dar contexto, pero las
piezas de Facturación/Timbrado se marcan explícitamente como **fuera de
este sprint**.

## 4. Cuándo termina

Desde la perspectiva de **este módulo**, una Solicitud de Liberación
"termina" su participación activa en el momento en que queda registrada y
notificada — su ciclo de vida completo (aprobación/rechazo) pertenece a un
módulo que todavía no existe. Ver estados propuestos en `workflow.md §1`.

## 5. Ciclo de vida (resumen; detalle completo en `workflow.md`)

```
trafico-system: selección + motivo + confirmación
        │
        ▼
ATLAS: valida, persiste (transacción), mueve estado del tablero, notifica
        │
        ▼
[Solicitud en estado PENDIENTE — límite de este sprint]
        │
        ▼  (futuro, módulo Facturación)
EN_REVISION → APROBADA | RECHAZADA
        │
        ▼  (futuro, CFDIWatcher)
Resultado del Timbrado (🟢/🔴)
```

## 6. Entidades nuevas

Cuatro entidades, cada una con una única responsabilidad — consistente con
el patrón ya usado en `App\Sync` (un repositorio por tabla, orquestado por
una clase de más alto nivel). Ver `database-design.md` para el diseño físico
completo.

### 6.1 `SolicitudLiberacion` (cabecera del lote)

Representa **la solicitud en sí**: quién la originó, cuándo, con qué
motivo, y en qué estado está. Una fila por cada vez que trafico-system
confirma el modal "Solicitar Liberación" — sin importar si incluye 1 o 50
guías.

### 6.2 `SolicitudLiberacionDetalle` (membresía del lote)

Representa **qué guías** pertenecen a una solicitud dada. Una fila por
guía dentro del lote. Existe como entidad separada (no como columna
repetida en la cabecera) por la misma razón por la que `tras_cartaporte_ubic`
o `tras_cartaporte_mercancias` son tablas separadas en SICRET: una relación
1-a-N no cabe en una fila.

### 6.3 `GuiaEstadoTablero` (estado operativo por guía)

**La pieza que hoy no existe en ninguna parte de ATLAS** (confirmado en
`knowledge/database.md §3` y `docs/03-ui/02-mesa-operativa-trafico.md §14`):
una representación explícita de en qué panel del Dashboard vive cada guía
(`GENERADA` / `SOLICITADA_LIBERACION` / futuros estados de timbrado),
**distinta** del campo `guias.estado` (que es un valor crudo replicado de
SICRET, según advierte el propio diseño del Dashboard).

Esta entidad es, en la práctica, la pieza central del módulo: es la que
convierte "guardar una solicitud" en "mover una tarjeta del tablero", y la
que impide que dos solicitudes distintas reclamen la misma guía (ver
`security.md §3`).

### 6.4 `SolicitudLiberacionHistorial` (auditoría)

Registro append-only de cada evento relevante ocurrido sobre una solicitud
(creación, y en el futuro cada cambio de estado que aplique Facturación).
Separado de la cabecera porque la cabecera representa **el estado actual**
(mutable) y el historial representa **la secuencia de hechos** (inmutable) —
mismo principio que `sync_heartbeat` (estado actual) frente a
`storage/logs/sync-engine.log` (bitácora), solo que aquí sí necesita vivir
en base de datos porque debe ser consultable, no solo depurable.

## 7. Responsabilidades por capa (siguiendo el estilo ya existente)

ATLAS no tiene controladores ni router (confirmado en
`knowledge/architecture.md §1` y `api.md §1`) — cada script de `public/`
es autocontenido y arma sus dependencias a mano. Este módulo **no rompe
ese patrón**: no se introduce un framework de rutas ni una capa de
controladores nueva.

| Capa | Rol | Analogía con lo ya existente |
|---|---|---|
| Script de entrada (`public/api/solicitudes-liberacion.php`) | Arma dependencias a mano, delega, traduce el resultado a HTTP+JSON | Igual que `public/api/heartbeat.php` y `public/trafico.php` |
| Servicio orquestador (`App\Liberacion\SolicitudLiberacionService`) | Valida, ejecuta la transacción, coordina los 4 repositorios, publica el evento | Igual rol que `GuideWatcher` dentro de `App\Sync` |
| Repositorios (`App\Liberacion\*Repository`) | Una tabla, una responsabilidad, SQL preparado | Igual que `GuiaRepository`, `CheckpointStore`, `HeartbeatStore` |
| Value object de entrada (`SolicitudLiberacionPayload`) | Encapsula y valida la forma del JSON recibido | Igual rol que `GuiaRecord::fromSourceRow()` |
| Publicación de eventos | Reutiliza `App\Sync\EventPublisher`/`SocketEventPublisher` tal cual | Sin cambios — la interfaz ya es genérica |

Namespace nuevo propuesto: **`App\Liberacion`**, hermano de `App\Sync`,
`App\Dashboard`, `App\WebSocket` — mismo nivel, misma convención PSR-4
(`app/Liberacion/`). Ninguna clase existente se modifica para que esto
funcione (ver `future-considerations.md §5` sobre por qué esto fue una
decisión deliberada, no un descuido).
