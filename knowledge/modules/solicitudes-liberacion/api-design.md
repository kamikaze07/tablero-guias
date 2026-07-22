# Solicitudes de Liberación — Diseño de API

> Diseño únicamente — ningún script se crea en este sprint. Sigue la única
> convención de API que ATLAS ya tiene: **sin router, sin framework**, un
> script PHP autocontenido por recurso bajo `public/api/`, exactamente como
> `public/api/heartbeat.php` (ver `knowledge/api.md`). No se introduce un
> patrón de rutas con parámetros (`/api/solicitudes/{id}`) porque nada en
> el proyecto lo soporta hoy (`Router` no existe en ATLAS, a diferencia de
> trafico-system) — la identificación de recursos se hace por querystring,
> igual que el resto del proyecto.

---

## 1. Convenciones adoptadas (para que ambos endpoints se sientan como "un mismo módulo")

- Un único archivo físico por recurso: `public/api/solicitudes-liberacion.php`,
  que **branchea por `$_SERVER['REQUEST_METHOD']`** (`POST` = crear, `GET` =
  leer). Es el primer script de ATLAS que maneja más de un método — se
  documenta explícitamente como precedente nuevo (ver resumen final).
- Respuestas siempre `Content-Type: application/json`, siempre un objeto
  JSON en la raíz (nunca un array suelto), consistente con
  `heartbeat.php`.
- Los errores **sí** se envuelven en JSON estructurado
  (`{"error": "...", "detalle": "..."}`) — a diferencia de varios
  endpoints de trafico-system que devuelven el mensaje crudo de la
  excepción (`GuiasController::listar()`, ver
  `knowledge/integrations/trafico-system.md`, defecto ya identificado ahí
  como algo a **no** repetir en ATLAS).
- Sin autenticación en este sprint (igual que el resto de ATLAS) — ver
  `security.md §4` para la recomendación pendiente de aprobación.

---

## 2. `POST /api/solicitudes-liberacion.php` — crear una solicitud

### Propósito
Endpoint de integración principal: el que trafico-system invocará (hoy
solo hace `console.log()`, ver `knowledge/integrations/trafico-system.md`)
en cuanto reemplace ese placeholder por un `fetch()` real.

### Request

```json
{
  "guias": [
    { "num_guia": "PR012345" },
    { "num_guia": "PR012346" }
  ],
  "motivo": "Cliente confirmó pago anticipado"
}
```

Nota deliberada: el diseño **solo exige `num_guia`** dentro de cada objeto
de `guias`, aunque el payload real de trafico-system hoy manda también
`fecha`, `tipo`, `servicio`, `operador`, `estatus`, `km` y el campo `total`
a nivel raíz. Esos campos adicionales se **ignoran silenciosamente** (no es
un error recibirlos) — ver `security.md §2` sobre por qué no se usan ni se
validan campo por campo.

### Response — éxito (`201 Created`)

```json
{
  "id": 481,
  "origen": "trafico-system",
  "estado": "PENDIENTE",
  "motivo": "Cliente confirmó pago anticipado",
  "created_at": "2026-07-17 11:32:04",
  "guias": [
    { "guia_id": 9001, "num_guia": "PR012345" },
    { "guia_id": 9002, "num_guia": "PR012346" }
  ]
}
```

### Errores posibles

| Código | Situación | Cuerpo (forma) |
|---|---|---|
| `400` | JSON malformado, o `guias` ausente/vacío | `{"error": "payload_invalido", "detalle": "..."}` |
| `400` | `motivo` vacío (si la decisión pendiente en `database-design.md §2` resuelve exigirlo) | `{"error": "motivo_requerido"}` |
| `404` | Uno o más `num_guia` no existen en `guias` de ATLAS (aún no sincronizados, o typo) | `{"error": "guia_no_encontrada", "detalle": {"num_guia": ["PR099999"]}}` |
| `409` | Ambigüedad: un `num_guia` corresponde a más de un `source` (ver `security.md §2`) | `{"error": "guia_ambigua", "detalle": {"num_guia": "PR012345", "sources": ["sicrePR","sicreGero"]}}` |
| `409` | Una o más guías ya están en un estado distinto de `GENERADA` (ya solicitadas por otra sesión, condición de carrera perdida, etc.) | `{"error": "guia_no_disponible", "detalle": {"num_guia": ["PR012346"], "estado_actual": "SOLICITADA_LIBERACION"}}` |
| `500` | Fallo de base de datos u otro error no anticipado durante la transacción | `{"error": "error_interno"}` (sin exponer el mensaje crudo de la excepción — a diferencia de `GuiasController::detalle()` en trafico-system, que hace `var_dump($e); exit;`, defecto explícitamente señalado para no repetir) |

Nota de diseño: **el lote se acepta o se rechaza completo** (todo o nada) —
no hay aceptación parcial en este sprint. Si dos de tres guías son válidas
y una no, las tres se rechazan y no se crea ninguna fila. Justificación en
`security.md §3`.

---

## 3. `GET /api/solicitudes-liberacion.php` — listar solicitudes

### Propósito
Lectura general — soporta tanto una futura pantalla de Facturación (aún no
diseñada) como verificación manual/soporte. No es, hoy, consumida por
ningún cliente concreto — se diseña porque toda escritura nueva en este
proyecto ha tenido históricamente su lectura equivalente (`GuiaBoardRepository`
junto a `GuiaRepository`), y porque `docs/03-ui/02-mesa-operativa-trafico.md §15`
ya anticipa la necesidad de una capa de lectura de este tipo.

### Request
Querystring, todos los parámetros opcionales:

| Parámetro | Tipo | Efecto |
|---|---|---|
| `estado` | string | Filtra por `solicitud_liberacion.estado` (p. ej. `?estado=PENDIENTE`) |
| `desde` / `hasta` | `YYYY-MM-DD` | Filtra por `created_at` |
| `page` / `perPage` | int | Paginación (`perPage` default 25, mismo default que `GuiasModel::listarGuias()` de trafico-system, por familiaridad) |

### Response — éxito (`200 OK`)

```json
{
  "total": 3,
  "page": 1,
  "perPage": 25,
  "data": [
    {
      "id": 481,
      "origen": "trafico-system",
      "estado": "PENDIENTE",
      "motivo": "Cliente confirmó pago anticipado",
      "created_at": "2026-07-17 11:32:04",
      "total_guias": 2
    }
  ]
}
```

Nota: el listado **no** expande el detalle de guías por fila (evita N+1 /
payloads grandes) — para eso existe el endpoint de detalle (§4).

### Errores posibles

| Código | Situación |
|---|---|
| `400` | `estado` con un valor fuera del enum conocido, `desde`/`hasta` con formato inválido |
| `500` | Error interno |

---

## 4. `GET /api/solicitudes-liberacion.php?id=` — detalle de una solicitud

### Propósito
Consultar una solicitud puntual con su lote completo de guías y su
historial — útil tanto para soporte/depuración como, eventualmente, para
que trafico-system (u otro origen) verifique el estado de una solicitud que
ya envió.

### Request
`GET /api/solicitudes-liberacion.php?id=481`

### Response — éxito (`200 OK`)

```json
{
  "id": 481,
  "origen": "trafico-system",
  "estado": "PENDIENTE",
  "motivo": "Cliente confirmó pago anticipado",
  "created_at": "2026-07-17 11:32:04",
  "guias": [
    { "guia_id": 9001, "num_guia": "PR012345" },
    { "guia_id": 9002, "num_guia": "PR012346" }
  ],
  "historial": [
    {
      "evento": "CREADA",
      "estado_anterior": null,
      "estado_nuevo": "PENDIENTE",
      "actor": "trafico-system",
      "created_at": "2026-07-17 11:32:04"
    }
  ]
}
```

### Errores posibles

| Código | Situación |
|---|---|
| `400` | `id` no numérico |
| `404` | No existe una solicitud con ese `id` |
| `500` | Error interno |

---

## 5. Endpoint de apoyo (prioridad media, no bloqueante): `GET /api/guias-liberables.php`

### Propósito
Listar las guías del día en estado `GENERADA` — la "capa de lectura
distinta de `GuiaBoardRepository`" que `docs/03-ui/02-mesa-operativa-trafico.md
§15` ya anticipa como necesaria. **No es requisito para que trafico-system
pueda enviar su primera solicitud** (ese flujo no necesita leer nada de
ATLAS primero) — se incluye en el diseño porque es la pieza natural para:
(a) una futura Mesa Operativa dentro de ATLAS, o (b) que trafico-system
eventualmente pre-filtre su propio listado contra el estado real de ATLAS
antes de mostrar el checkbox de selección (hoy no lo hace — ver
`knowledge/integrations/trafico-system.md §8.3`).

### Request
`GET /api/guias-liberables.php` (sin parámetros en esta primera versión;
siempre "hoy", igual regla que `GuiaBoardRepository::findToday()`).

### Response — éxito (`200 OK`)

```json
{
  "data": [
    { "guia_id": 9010, "source": "sicrePR", "num_guia": "PR012350", "fecha": "...", "nombre": "...", "operador": "..." }
  ]
}
```

### Errores posibles
| Código | Situación |
|---|---|
| `500` | Error interno |

**Se marca explícitamente como prioridad media** en la lista de tareas del
siguiente sprint (ver resumen final) — puede implementarse después del
endpoint de creación sin bloquear la integración con trafico-system.

---

## 6. Fuera de alcance de este documento (pertenecen a Facturación, no se diseñan aquí)

- Cualquier endpoint de aprobación/rechazo (`PATCH`/`POST` sobre una
  solicitud existente para cambiar su `estado`).
- Cualquier endpoint que liste solicitudes con filtros específicos de
  Facturación (por revisor, por prioridad, etc.).
- Cualquier noción de "quién" aprueba — depende de que exista un sistema de
  usuarios, que no existe hoy en ningún proyecto (ver `security.md §4`).

Estos se documentan solo como referencia en `future-considerations.md`,
sin comprometer nombres de ruta ni forma de payload — esa es una decisión
que le corresponde al sprint de diseño de Facturación.
