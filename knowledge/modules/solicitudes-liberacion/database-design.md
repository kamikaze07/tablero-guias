# Solicitudes de Liberación — Diseño de Base de Datos

> Diseño únicamente. No se modifica `database/schema.sql` en este sprint —
> este documento es lo que el siguiente sprint deberá traducir a SQL y
> agregar a ese archivo (siguiendo el mismo estilo `CREATE TABLE IF NOT
> EXISTS`, sin motor de migraciones incremental, ver
> `knowledge/architecture.md §6`).

Cuatro tablas nuevas, todas `ENGINE=InnoDB DEFAULT CHARSET=utf8mb4` (mismo
estándar que las 3 tablas existentes), todas con un repositorio dedicado en
`App\Liberacion` (un archivo = una tabla = una responsabilidad, igual que
`App\Sync`).

---

## 1. `guia_estado_tablero`

### Propósito
Representar el estado operativo del tablero para cada guía — la pieza que
`docs/03-ui/02-mesa-operativa-trafico.md §14` señala como inexistente.
Deliberadamente **separada** de la tabla `guias` (no una columna nueva ahí)
para preservar la responsabilidad única de esa tabla: `guias` es y seguirá
siendo un espejo 1:1 de lo que `GuideWatcher` trae de SICRET, con un único
escritor (`GuiaRepository::insert()`, solo `INSERT`, nunca `UPDATE`). Mezclar
una columna que otro componente sí actualiza rompería esa garantía y
obligaría a auditar dos escritores distintos sobre la misma tabla.

### Columnas

| Columna | Tipo | Nulo | Propósito |
|---|---|---|---|
| `guia_id` | `BIGINT UNSIGNED` | No | **Clave primaria** (no hay `id` autoincremental propio — es una relación 1:1 real con `guias.id`, no 1:N). |
| `estado` | `VARCHAR(30)` | No | `GENERADA` \| `SOLICITADA_LIBERACION` \| `TIMBRADO_EXITOSO` (reservado) \| `TIMBRADO_ERROR` (reservado). Ver `workflow.md §2` para justificación de cada valor. |
| `updated_at` | `DATETIME` | No, `DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP` | Cuándo cambió por última vez — mismo patrón que `sync_checkpoints.updated_at`. |

### Relaciones
- `guia_id` → `guias.id` (FK lógica; ver nota sobre FK físicas al final de
  este documento).

### Índices
- `PRIMARY KEY (guia_id)`.
- `KEY idx_guia_estado_tablero_estado (estado)` — necesario para la
  consulta "todas las guías en estado GENERADA de hoy" (join con
  `guias.fecha`), que es la lectura que reemplaza/complementa a
  `GuiaBoardRepository::findToday()` si en el futuro se necesita filtrar
  por estado del tablero en vez de solo por fecha.

### Decisión de diseño: creación perezosa (lazy), no eager
**No se crea una fila por cada guía nueva que detecta el Synchronization
Engine.** La ausencia de fila se interpreta como `GENERADA` (el estado por
defecto). La fila solo se crea la primera vez que la guía transiciona.

Justificación: esto significa que `GuideWatcher`/`GuiaRepository` **no se
tocan en absoluto** para este módulo — ninguna clase existente de
`App\Sync` cambia. Es la opción más consistente con "no inventar una
arquitectura distinta" y con el propio patrón de `Watcher` (cada capacidad
nueva se agrega sin modificar las que ya funcionan). El costo es que la
consulta de lectura debe hacer `LEFT JOIN ... COALESCE(estado, 'GENERADA')`
en vez de un `WHERE estado = 'GENERADA'` directo — costo aceptable dado el
volumen esperado (ver `future-considerations.md §7`).

### Decisión de diseño: actualización con compare-and-swap, no lectura+escritura separada
La transición `GENERADA → SOLICITADA_LIBERACION` debe escribirse como un
`UPDATE ... WHERE guia_id = ? AND estado = 'GENERADA'` (o el `INSERT`
equivalente si la fila no existe) y **verificar `affected rows == 1`**, no
como un `SELECT` de verificación seguido de un `UPDATE` separado. Esto
cierra la condición de carrera entre dos solicitudes simultáneas sobre la
misma guía sin necesitar `SELECT ... FOR UPDATE` explícito. Ver
`security.md §3` para el detalle completo — es, a propósito, una mejora
sobre el patrón `MAX(num)+1` de `GuardarGuiaService` en trafico-system, que
la propia documentación de ese proyecto señala como una condición de
carrera teórica no resuelta (`knowledge` de trafico-system, `guias.md §6`).

---

## 2. `solicitud_liberacion`

### Propósito
Cabecera de cada lote — una fila por cada vez que se confirma "Solicitar
Liberación", sin importar cuántas guías incluya.

### Columnas

| Columna | Tipo | Nulo | Propósito |
|---|---|---|---|
| `id` | `BIGINT UNSIGNED AUTO_INCREMENT` | No | PK propia de ATLAS, mismo estilo que `guias.id`. |
| `origen` | `VARCHAR(50)` | No | Sistema que originó la solicitud (`trafico-system` hoy). No hardcodeado a un único valor posible — ver `future-considerations.md §3`. |
| `motivo` | `TEXT` | Sí (ver nota) | Texto libre capturado por el operador en trafico-system. Nulidad intencional: ver nota de decisión pendiente abajo. |
| `estado` | `VARCHAR(20)` | No, `DEFAULT 'PENDIENTE'` | `PENDIENTE` (único valor que este sprint escribe) \| `EN_REVISION` \| `APROBADA` \| `RECHAZADA` (los tres reservados, ver `workflow.md §3`). |
| `created_at` | `DATETIME` | No, `DEFAULT CURRENT_TIMESTAMP` | Cuándo se registró en ATLAS. |

**Nota de decisión pendiente — nulidad de `motivo`**: `knowledge/integrations/trafico-system.md
§7` ya documentó que el campo `motivo` en el payload de trafico-system es
obligatorio en su UI, pero que el diseño de Facturación
(`docs/03-ui/02-mesa-operativa-trafico.md §17-18`) asumía que ningún campo
de motivo existiría en esta fase. Este diseño **incluye la columna** (para
no bloquear el payload real que trafico-system ya envía) pero dos preguntas
quedan abiertas para aprobación (ver el resumen final de esta entrega): (a)
¿debe ser `NOT NULL` (ATLAS también lo exige) o `NULL` (ATLAS lo acepta
pero no lo exige, tolerando otros orígenes futuros que no lo manden)?; (b)
¿se persiste tal cual o se trata como dato sensible/informal? Se propone
`NULL` por defecto —más permisivo, no bloquea integraciones futuras que no
tengan este concepto— pero es una decisión de producto, no técnica.

**Nota de decisión diferida — `resolved_at`/`resolved_by`**: deliberadamente
**no se agregan en este sprint**. Pertenecen al momento en que Facturación
resuelve una solicitud, funcionalidad que no se implementa aquí. Agregarlas
ahora sería diseñar para un módulo ajeno sin necesidad inmediata — se deja
anotado en `future-considerations.md §2` para que el sprint de Facturación
las agregue vía su propia migración, sin que esto bloquee a ese equipo.

**Nota — sin columna `total_guias`**: se descarta a propósito por ser
puramente derivable (`COUNT(*)` sobre `solicitud_liberacion_detalle`); el
propio payload de trafico-system la incluye (`total`) pero es redundante
incluso ahí (ver `security.md §2`, "qué no confiar del payload").

### Relaciones
- Referenciada por `solicitud_liberacion_detalle.solicitud_id` (1 a N).
- Referenciada por `solicitud_liberacion_historial.solicitud_id` (1 a N).

### Índices
- `PRIMARY KEY (id)`.
- `KEY idx_solicitud_liberacion_estado (estado)` — lectura futura de
  Facturación ("dame las PENDIENTE").
- `KEY idx_solicitud_liberacion_created_at (created_at)` — listados
  ordenados/paginados (ver `api-design.md`).

---

## 3. `solicitud_liberacion_detalle`

### Propósito
Relación N a N materializada entre una solicitud y las guías que incluye —
"qué guías pertenecen a este lote".

### Columnas

| Columna | Tipo | Nulo | Propósito |
|---|---|---|---|
| `solicitud_id` | `BIGINT UNSIGNED` | No | Parte de la PK compuesta. |
| `guia_id` | `BIGINT UNSIGNED` | No | Parte de la PK compuesta. Apunta a `guias.id` (**no** a `num_guia` — ya resuelto a la clave interna de ATLAS antes de insertar, ver `api-design.md` sobre la resolución de `num_guia`). |
| `num_guia` | `VARCHAR(15)` | No | Copia de conveniencia del folio, **solo para legibilidad** en consultas manuales/soporte (evita un `JOIN` obligatorio para ver qué folio es cada fila) — no es la fuente de verdad, que sigue siendo `guias.num_guia` vía `guia_id`. |

Deliberadamente **no** se agrega un `id` autoincremental propio (la PK
compuesta ya es natural y suficiente) ni columnas de snapshot adicionales
(`fecha`, `operador`, `estatus`, etc.) — esos datos ya viven en `guias` y
duplicarlos violaría el principio de "no duplicar código/datos" de
`CLAUDE.md` sin un beneficio claro (ver `security.md §2` sobre por qué no
se confía en los valores que manda trafico-system para estos campos de
todas formas).

### Relaciones
- `solicitud_id` → `solicitud_liberacion.id`.
- `guia_id` → `guias.id`.

### Índices
- `PRIMARY KEY (solicitud_id, guia_id)` — impide, por construcción, que la
  misma guía aparezca dos veces en el mismo lote.
- `KEY idx_solicitud_liberacion_detalle_guia (guia_id)` — necesario para la
  pregunta inversa ("historial de solicitudes de esta guía"), y para el
  `UPDATE ... WHERE guia_id = ?` de `guia_estado_tablero` que ocurre en la
  misma transacción.

**Nota sobre qué NO impide esta tabla**: la unicidad *dentro de un lote* no
impide que la *misma guía* aparezca en dos lotes *distintos* — esa regla
(una guía no puede tener dos solicitudes abiertas a la vez) la garantiza
`guia_estado_tablero` (§1), no esta tabla. Son dos restricciones
complementarias, cada una en el nivel que le corresponde.

---

## 4. `solicitud_liberacion_historial`

### Propósito
Bitácora append-only de eventos sobre una solicitud — auditoría (ver
`security.md §1`). Nunca se actualiza ni se borra una fila ya escrita.

### Columnas

| Columna | Tipo | Nulo | Propósito |
|---|---|---|---|
| `id` | `BIGINT UNSIGNED AUTO_INCREMENT` | No | PK. |
| `solicitud_id` | `BIGINT UNSIGNED` | No | A qué solicitud pertenece el evento. |
| `evento` | `VARCHAR(30)` | No | `CREADA` (único que este sprint escribe) \| `EN_REVISION` \| `APROBADA` \| `RECHAZADA` (reservados para Facturación). |
| `estado_anterior` | `VARCHAR(20)` | Sí | `NULL` en el evento `CREADA` (no había estado previo). |
| `estado_nuevo` | `VARCHAR(20)` | No | Estado de `solicitud_liberacion.estado` resultante tras este evento. |
| `actor` | `VARCHAR(50)` | Sí | Quién/qué disparó el evento. Hoy siempre el valor de `origen` (`trafico-system`) o `NULL`, porque no existe identidad de usuario en ningún sistema (ver `security.md §4`). Se reserva para cuando exista un concepto de usuario. |
| `detalle` | `TEXT` | Sí | Contexto libre — en el evento `CREADA`, se guarda una copia del `motivo` (para que el historial sea legible sin necesitar `JOIN` a la cabecera, igual que `num_guia` en el detalle). |
| `created_at` | `DATETIME` | No, `DEFAULT CURRENT_TIMESTAMP` | Cuándo ocurrió. |

### Relaciones
- `solicitud_id` → `solicitud_liberacion.id`.

### Índices
- `PRIMARY KEY (id)`.
- `KEY idx_solicitud_liberacion_historial_solicitud (solicitud_id, created_at)`
  — leer el historial completo de una solicitud, en orden.

---

## 5. Sobre claves foráneas físicas (`FOREIGN KEY` de MySQL)

El esquema actual de ATLAS **no usa ninguna `FOREIGN KEY` física** (las
tres tablas existentes no tienen ninguna, incluida la relación implícita
entre `guias` y `sync_checkpoints`/`sync_heartbeat` por `source`). Este
diseño mantiene esa misma convención por consistencia — todas las
relaciones descritas arriba son lógicas (documentadas y validadas en
código, no en el motor de base de datos). Se señala como una decisión que
**el siguiente sprint debe confirmar explícitamente** en vez de asumir por
inercia (ver resumen final, "decisiones que requieren aprobación") — usar
`FOREIGN KEY` reales daría integridad referencial gratuita a costa de
introducir un patrón nuevo que el resto del proyecto no usa.

## 6. Mapeo tabla → repositorio (namespace `App\Liberacion`)

| Tabla | Repositorio propuesto | Responsabilidad |
|---|---|---|
| `guia_estado_tablero` | `GuiaEstadoTableroRepository` | Leer estado actual (una guía o un lote), transición CAS |
| `solicitud_liberacion` | `SolicitudLiberacionRepository` | Insertar cabecera, buscar por id, listar/filtrar |
| `solicitud_liberacion_detalle` | `SolicitudLiberacionDetalleRepository` | Insertar filas del lote, buscar por solicitud o por guía |
| `solicitud_liberacion_historial` | `SolicitudLiberacionHistorialRepository` | Insertar evento, listar historial de una solicitud |

Los cuatro repositorios son invocados y coordinados por
`SolicitudLiberacionService` (ver `overview.md §7` y `api-design.md`), que
es quien abre/cierra la transacción — ningún repositorio individual
gestiona su propia transacción, igual que en `GuardarGuiaService` de
trafico-system (el patrón transaccional de referencia que
`knowledge/integrations/trafico-system.md §6` ya identificó como el modelo
a seguir).
