# Base de Datos — ATLAS

## 1. Bases de datos involucradas

| Base | Motor | Propiedad | Acceso de ATLAS | Registrada en `config/sources.php` |
|---|---|---|---|---|
| `atlas` | MariaDB 11 (contenedor propio `atlas-db`) | ATLAS | Lectura/escritura | N/A (es la propia) |
| `sicrePR` | MySQL/MariaDB (host `192.168.1.209`) | SICRET | Solo lectura | Sí (`FORSIS_DB`) |
| `sicre2PR` | ídem | SICRET | Solo lectura (por diseño) | **No** — configurada en `.env` pero sin entrada en `sources.php` |
| `sicreGero` | ídem | SICRET | Solo lectura | Sí (`GERO_DB`) |
| `sicre2Gero` | ídem | SICRET | Solo lectura (por diseño) | **No** — configurada en `.env` pero sin entrada en `sources.php` |

Confirmado: el propio `docs/02-architecture/01-Datasources.md` de ATLAS
marca como **pendiente de documentar** el propósito y el esquema interno de
las 4 bases SICRET — esta documentación de conocimiento respeta eso y no
inventa nombres de tabla no confirmados por el código o por la
documentación del Sistema de Guías.

**Dato cruzado con el Sistema de Guías** (`trafico-system/knowledge/database.md`):
ese proyecto sí documenta `sicrePR` y `sicre2PR` con tablas concretas
(`guias`, `llamadas_historicas`, `tras_origenes`, `tras_productos`, etc.) y
`sicreGero` como base "hermana" de la misma empresa GERO. **`sicre2Gero` no
aparece documentada en ningún lugar del Sistema de Guías** — parece ser
una base que ATLAS anticipa (simétrica a `sicre2PR`) pero que el otro
proyecto no consume ni menciona. No se pudo confirmar su existencia real
más allá de que tiene variables de entorno reservadas en ambos `.env`.

## 2. Esquema propio de ATLAS (`database/schema.sql`)

Aplicado íntegro (sin migraciones incrementales) por `bin/migrate.php`, que
simplemente ejecuta el archivo completo (`CREATE TABLE IF NOT EXISTS`, por
lo que es seguro re-ejecutarlo). Solo 3 tablas, **todas con foco exclusivo
en el Synchronization Engine** — el propio comentario de encabezado del
archivo dice explícitamente que el "modelo de paneles del Dashboard" está
fuera de alcance de este sprint.

### `guias`

Réplica local (solo columnas relevantes ya traídas por `GuideWatcher`) de
la tabla `guias` de SICRET, con dos columnas propias de ATLAS agregadas al
final:

- `id` — PK propio de ATLAS (`BIGINT UNSIGNED AUTO_INCREMENT`), **distinto**
  del `num`/`id` interno de SICRET.
- `source` + `source_num` — identifican de forma única el registro de
  origen (`UNIQUE KEY uq_guias_source_num`), porque `num` es un
  auto-incremento **independiente por cada base de SICRET** (dos guías con
  el mismo `num` pero de `sicrePR` y `sicreGero` son registros distintos).
- El resto de columnas (`num_guia`, `folio_imp`, `fecha`, `fecha_c`,
  `fecha_d`, `num_llama`, `estado`, `nombre`, `tipo`, `num_vale`, `diesel`,
  `servicio`, `rem1`, `placas1`, `rem2`, `placas2`, `estatus`, `pedido`,
  `comen_pre`, `factura`, `manifiesto`, `ticket1`, `tons1`, `ticket2`,
  `tons2`, `operador`, `prefactura`, `factimpresa`, `linea`, `km`,
  `claveproducto_sat`, `claveunidad_sat`, `do_field`, `lid_field`,
  `actualizacion`) son un **espejo 1:1** de lo que expone `GuideWatcher`
  desde SICRET, con nombres de columna casi idénticos (`do`/`lid` de
  SICRET se renombran a `do_field`/`lid_field` en ATLAS porque `do` es
  palabra reservada en SQL).
- `detected_at` — timestamp propio de ATLAS (`DEFAULT CURRENT_TIMESTAMP`),
  momento en que el Synchronization Engine insertó el registro (distinto de
  `fecha`, que es la fecha de negocio de la guía en SICRET).
- Índices: `idx_guias_fecha` (usado por `GuiaBoardRepository::findToday()`
  y por el propio `GuideWatcher` en su primera corrida) e
  `idx_guias_num_guia`.

**No existe ninguna columna que represente el estado operativo del
tablero** (Generada / Solicitada a Liberación / Resultado del Timbrado).
El campo `estado` de esta tabla es, como advierte explícitamente
`docs/03-ui/02-mesa-operativa-trafico.md §14`, **un valor crudo replicado
de SICRET** — no debe confundirse con el estado del flujo de liberación.
Cualquier columna nueva para representar ese estado propio de ATLAS
**todavía no ha sido diseñada ni creada**.

### `sync_checkpoints`

Una fila por `source` (`sicrePR`, `sicreGero` hoy). `last_num` es el
último `num` de origen confirmado. `PRIMARY KEY (source)` — upsert vía
`ON DUPLICATE KEY UPDATE` con `GREATEST()` para nunca retroceder.

### `sync_heartbeat`

Una fila por `engine_name` (hoy solo `'synchronization-engine'`, constante
hardcodeada tanto en `SynchronizationEngine` como en
`public/api/heartbeat.php`). Guarda estado, timestamps de ciclo/último
éxito, último error, y contadores acumulados (`cycles_completed`,
`records_synced_total`).

## 3. Lo que falta en el esquema para soportar la liberación (según diseño, aún no implementado)

Ver `liberacion.md` para el detalle completo. En resumen, la propia
documentación de diseño de ATLAS (`docs/03-ui/02-mesa-operativa-trafico.md
§15`) reconoce que hace falta, como pieza nueva a diseñar en un sprint de
implementación:

- Una representación del estado operativo del tablero (Generada /
  Solicitada a Liberación / [futuro] resultado de timbrado) — no
  necesariamente una tabla nueva, podría ser una columna nueva en `guias`
  o una tabla de eventos/transiciones separada; **la decisión de esquema
  no está tomada**.
- Algún registro de la propia "solicitud de liberación" en sí (qué guía,
  cuándo, y — según qué se decida en el futuro módulo de Facturación —
  quién la solicitó), de forma consultable.

## 4. Patrón de acceso a datos

- 100% PDO preparado, sin ORM, igual que en el Sistema de Guías — pero
  aquí cada consulta vive en una clase de una sola responsabilidad
  (`GuiaRepository`, `CheckpointStore`, `HeartbeatStore`,
  `GuiaBoardRepository`, `HeartbeatRepository`), nunca embebida en un
  controlador o vista.
- Todas las conexiones (ATLAS y las 4 fuentes SICRET) pasan por la misma
  `ConnectionFactory` — no hay clases `*Database` por cada base como en el
  Sistema de Guías.
- Sin transacciones explícitas en ningún punto (cada operación es un
  `INSERT`/`UPDATE` de una sola sentencia; no hay todavía ninguna
  operación multi-tabla que las requiera, a diferencia del
  `GuardarGuiaService` del Sistema de Guías).
- `PDO::MYSQL_ATTR_INIT_COMMAND => "SET time_zone = '-06:00'"` se aplica en
  **toda** conexión abierta por `ConnectionFactory`, incluidas las
  conexiones de solo lectura hacia SICRET — es decir, ATLAS interpreta las
  fechas de SICRET ya normalizadas a esa zona horaria fija, sin depender de
  la zona horaria configurada en el servidor MySQL de origen.
