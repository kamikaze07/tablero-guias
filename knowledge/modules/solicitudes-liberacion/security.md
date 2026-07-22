# Solicitudes de Liberación — Auditoría y Seguridad

---

## 1. Auditoría

### 1.1 Qué acciones quedan registradas
Solo una en este sprint: **la creación de una solicitud**. Cada creación
exitosa produce exactamente una fila en `solicitud_liberacion_historial`
con `evento = CREADA` (ver `database-design.md §4`). Las transiciones
futuras (`EN_REVISION`, `APROBADA`, `RECHAZADA`) quedan reservadas en el
mismo esquema para que Facturación las registre en la misma tabla sin
necesitar una migración adicional — pero **este sprint no las escribe**.

### 1.2 Qué usuario
**Ninguno, en el sentido de identidad humana** — ni ATLAS ni trafico-system
tienen sesiones, login, ni tabla de usuarios (confirmado en
`knowledge/architecture.md` de ambos proyectos). El campo `actor` de
`solicitud_liberacion_historial` guarda, por ahora, el mismo valor que
`origen` (`trafico-system`) — es decir, **se audita el sistema que llamó,
no la persona que operó ese sistema**. Esto es una limitación real, no una
omisión de este diseño: no puede resolverse sin introducir autenticación en
al menos uno de los dos proyectos, lo cual está fuera de este sprint.

### 1.3 Qué fecha
`solicitud_liberacion_historial.created_at` (por evento) y
`solicitud_liberacion.created_at` (momento de creación de la cabecera,
redundante con el primer evento del historial pero mantenido en la cabecera
para no obligar un `JOIN` en cada lectura simple, igual patrón que
`num_guia` duplicado en `solicitud_liberacion_detalle`, ver
`database-design.md §3`).

### 1.4 Qué cambios
`estado_anterior` → `estado_nuevo` en cada fila de historial, más `detalle`
en texto libre (en el evento `CREADA`, una copia del `motivo`). El
historial es **append-only**: ninguna fila se actualiza ni se borra una vez
escrita — es la garantía de que la auditoría no puede reescribirse
retroactivamente, ni siquiera por un bug en una versión futura del código
(un `INSERT` nuevo es la única operación que este módulo hace sobre esa
tabla, nunca `UPDATE`/`DELETE`).

---

## 2. Qué validará la API (y qué NO debe confiar de trafico-system)

### 2.1 Validaciones que sí se hacen server-side

| Validación | Motivo |
|---|---|
| El cuerpo es JSON válido y `guias` es un array no vacío | Rechazar temprano, antes de tocar la base de datos |
| Cada `num_guia` existe en la tabla `guias` de ATLAS | Si trafico-system manda un folio que el Synchronization Engine todavía no ha detectado (o nunca detectará, p. ej. typo), no puede crearse una solicitud "colgada" sin guía real detrás |
| Cada `num_guia` resuelve a **un único** `source` | Ver §2.2 — la ambigüedad se rechaza, nunca se adivina |
| Cada guía está actualmente en estado `GENERADA` (`guia_estado_tablero`) | Es la regla de negocio central: "solo pueden seleccionarse guías en estado Generada" (`docs/03-ui/02-mesa-operativa-trafico.md §13.2`) |
| El lote no está vacío tras la resolución | Redundante con el primer punto, pero se revalida después de resolver ids, no solo antes |

### 2.2 El problema de la ambigüedad de `num_guia` (hallazgo ya anticipado)

`knowledge/integrations/trafico-system.md §6` ya señaló que el payload de
trafico-system **no incluye `source`**, y que la vista de origen
(`guias.php`) hoy solo consulta `sicrePR` (FORSIS) — por lo que, en la
práctica actual, toda solicitud vendrá de esa fuente. Pero el esquema de
ATLAS sí replica **dos** fuentes (`sicrePR` y `sicreGero`,
`config/sources.php`), y `num_guia` **no es globalmente único entre
fuentes** (es un folio por base, no un identificador universal).

**Regla de diseño**: la API nunca asume `sicrePR` por defecto. Si un
`num_guia` resuelve a más de una fila en `guias` (una por `source`), la API
rechaza con `409 guia_ambigua` (ver `api-design.md §2`) en vez de adivinar.
Esto es deliberadamente más estricto de lo que el volumen actual de tráfico
justificaría (hoy la ambigüedad es teórica, no observada) — se prefiere así
porque **adivinar mal aquí significa liberar la guía equivocada**, un error
de negocio serio, no cosmético.

### 2.3 Qué NO se confía del payload de trafico-system

| Campo recibido | Por qué no se confía |
|---|---|
| `fecha`, `tipo`, `servicio`, `operador`, `estatus`, `km` (por guía) | ATLAS ya tiene su propia copia de estos campos, sincronizada directamente desde SICRET por el Synchronization Engine — más autorizada que lo que el navegador de un operador tenga en memoria en el momento de seleccionar. Se **ignoran** al validar/persistir; solo `num_guia` se usa, y únicamente para resolver el `guia_id` interno. |
| `total` (a nivel de lote) | Puramente derivable (`count(guias)`); nunca se usa para decidir nada, se recalcula server-side si hace falta mostrarlo. |
| Que el frontend haya validado "motivo no vacío" | trafico-system ya lo valida client-side (botón `disabled` hasta que el textarea tenga contenido), pero eso es UX, no seguridad — un cliente HTTP directo (curl, Postman, o un origen malicioso) puede saltarse esa validación trivialmente. La API debe repetir la misma validación server-side, sin asumir que "si llegó, es porque pasó la validación del formulario". |
| Que el estado de la guía sea el que trafico-system cree que es | La UI de trafico-system no consulta a ATLAS antes de mostrar el checkbox (confirmado — no hace ningún `fetch` hacia ATLAS hoy). Su noción de "esta guía se puede seleccionar" es puramente local y puede estar desactualizada frente a otra sesión que ya la solicitó. La API es la única que puede confirmar el estado real. |

---

## 3. Reglas que deben cumplirse antes de aceptar una solicitud

1. Todas las guías del lote existen y son inequívocas (§2.1, §2.2).
2. Todas las guías del lote están en `GENERADA` **en el momento de la
   transacción** — no en el momento en que trafico-system las mostró.
3. **Todo o nada**: si cualquiera de las guías del lote falla cualquiera de
   las validaciones anteriores, **ninguna** guía del lote se procesa, y no
   se crea ninguna fila en ninguna de las cuatro tablas. Se prefiere sobre
   la aceptación parcial por dos razones: (a) es el comportamiento más
   fácil de razonar para quien integra (una respuesta, un resultado, sin
   casos mixtos que reportar de vuelta a trafico-system, que hoy ni
   siquiera tiene UI para mostrar "3 de 5 se solicitaron"); (b) es
   consistente con el patrón transaccional ya usado por
   `GuardarGuiaService` en trafico-system, que tampoco hace escrituras
   parciales.
4. La transición de cada guía (`GENERADA → SOLICITADA_LIBERACION`) se
   ejecuta como una operación **compare-and-swap** (`UPDATE ... WHERE
   estado = 'GENERADA'`, verificando `affected rows`), no como
   lectura-luego-escritura separada — esto es lo que realmente impide la
   condición de carrera entre dos solicitudes concurrentes sobre la misma
   guía (ver `database-design.md §1` y `future-considerations.md §7` para
   el análisis de concurrencia completo). Si el `UPDATE` afecta 0 filas
   para alguna guía del lote, toda la transacción se revierte con el error
   `409 guia_no_disponible` — sin importar que la validación previa (fuera
   de la transacción) haya pasado, porque otra solicitud pudo haberse
   colado entre la validación y el `COMMIT`.

---

## 4. Autenticación y superficie de exposición (gap real, decisión pendiente)

**Ninguno de los dos proyectos tiene autenticación hoy.** Exponer
`POST /api/solicitudes-liberacion.php` sin ningún control adicional
significa que **cualquiera con acceso de red al host de ATLAS** podría
crear solicitudes falsas — mismo nivel de exposición que ya tiene todo lo
demás en ambos sistemas (`knowledge/architecture.md` de ambos, sección
explícita sobre ausencia de autenticación).

Este diseño **no resuelve este problema** —agregar autenticación es una
decisión de producto/infraestructura más amplia que este módulo por sí
solo—, pero lo señala explícitamente como algo que debe decidirse antes de
exponer el endpoint fuera de la red interna:

- Opción mínima consistente con el resto del proyecto (sin bases de datos
  de usuarios, sin sesiones): un token compartido fijo, enviado en un
  header (`Authorization: Bearer ...` o similar), verificado con una
  comparación simple contra una variable de entorno — mismo nivel de
  esfuerzo que el resto de la configuración de ATLAS (`Config`/`.env`).
- Opción más simple todavía: restringir por IP/red a nivel de `nginx`
  (`docker/nginx/nginx.conf`) — no requiere ningún cambio de código PHP.
- Ambas opciones son mutuamente compatibles (defensa en profundidad) y
  ninguna requiere introducir un sistema de usuarios.

Se marca como **decisión pendiente de aprobación** en el resumen final —
no se elige una opción por decisión unilateral de este diseño porque
depende de contexto de red/infraestructura que no está documentado en
ninguno de los dos repositorios.

## 5. Qué este módulo explícitamente no intenta resolver

- Rate limiting / protección contra reintentos duplicados a nivel HTTP
  (p. ej. un doble clic en trafico-system que dispare dos `POST`
  idénticos) — mitigado *parcialmente* por la regla de "todo o nada" +ª
  compare-and-swap (la segunda llamada fallaría con `409` porque las guías
  ya no estarían en `GENERADA`), pero no hay una protección de
  idempotencia explícita (p. ej. un `Idempotency-Key`). Se documenta como
  aceptable para este sprint porque el efecto de un duplicado ya es
  "rechazado", no "duplicado silencioso" — el peor caso es un error visible,
  no un dato corrupto.
- Validación de que el `motivo` tenga contenido significativo más allá de
  "no vacío" (longitud mínima, formato, etc.) — no hay ningún requisito de
  negocio documentado más allá de "obligatorio" en la UI de trafico-system.
