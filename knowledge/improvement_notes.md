# Notas de Mejora y Deuda Técnica — ATLAS

> Observaciones de solo lectura. No se aplicó ningún cambio. Incluye tanto
> hallazgos propios de esta exploración como brechas que el propio equipo
> de ATLAS ya se auto-documentó en `docs/`.

## 1. Brecha entre diseño y código (la más importante para el objetivo de integración)

El proyecto tiene documentación de diseño excelente y muy precisa
(`docs/03-ui/*.md`) para un flujo de liberación que **no tiene ninguna
línea de código todavía**. Antes de integrar el Sistema de Guías con
ATLAS, hace falta construir en ATLAS: la tabla/columna de estado del
tablero, el registro de la solicitud, el endpoint de escritura, y la
emisión real del evento `guia.liberacion_solicitada`. Ver `liberacion.md`
para el detalle completo — no se repite aquí para no duplicar contenido.

## 2. Bug confirmado: nombre de archivo de sonido no coincide

`public/assets/js/sound-manager.js` pide `new_guide.ogg` (con guion bajo)
en `SOUND_FILES.newGuide`, pero el archivo real en
`public/assets/sounds/` se llama `new-guide.ogg` (con guion). Esto
significa que **el sonido de "nueva guía" probablemente falla al cargar
silenciosamente** (el `<audio>` dispara su evento `error`, capturado por
un `console.warn`, pero no rompe nada visible) — mientras que los otros 3
sonidos (`release-request.ogg`, `stamp-success.ogg`, `stamp-error.ogg`) sí
coinciden con sus archivos reales. Vale la pena verificarlo en un
navegador real antes de asumir que el sonido de nueva guía funciona en
producción.

## 3. Solo 2 de 4 fuentes SICRET están activas

`config/sources.php` únicamente registra `sicrePR` (`FORSIS_DB`) y
`sicreGero` (`GERO_DB`). Las variables `FORSIS_2_DB_*` y `GERO_2_DB_*` ya
existen en `.env`/`.env.example` (y `bin/check-connections.php` ya las
prueba), pero **nadie agrega una entrada correspondiente en
`config/sources.php`**, así que `sicre2PR` y `sicre2Gero` nunca son
consultadas por el `GuideWatcher`. Puede ser intencional (quizás esas
bases no tienen guías, o su propósito es distinto — recordar que el propio
`docs/02-architecture/01-Datasources.md` marca como "pendiente" el
propósito de cada base) — pero es una discrepancia que vale la pena
confirmar con el equipo de ATLAS antes de asumir cobertura completa de
SICRET.

## 4. `ENGINE_NAME` duplicado como literal en dos archivos

`App\Sync\SynchronizationEngine::ENGINE_NAME` y la constante `ENGINE_NAME`
de `public/api/heartbeat.php` son el mismo string (`'synchronization-engine'`)
definido dos veces, sin una fuente única compartida. Si se renombrara el
motor en un archivo y no en el otro, el heartbeat dejaría de encontrar su
fila silenciosamente (`latest()` devolvería `null`, y el endpoint
reportaría `active: false` sin ningún error explícito).

## 5. `heartbeat.php` no expone `last_error`

`HeartbeatRepository::latest()` sí trae la columna `last_error` de
`sync_heartbeat`, pero `public/api/heartbeat.php` no la incluye en su
`json_encode()` de salida — el frontend solo puede saber que el motor está
"inactivo", nunca por qué. Sería una extensión simple si se necesita
depurar fallos del Synchronization Engine desde el propio Dashboard en vez
de entrar al contenedor a leer `storage/logs/sync-engine.log`.

## 6. Sin autenticación en ningún punto

Igual que el Sistema de Guías: sin login, sin sesiones, sin control de
acceso. El WebSocket público (8098) transmite datos de negocio (cliente,
folio, operador, placas) a cualquiera que se conecte. Antes de exponer
ATLAS fuera de una red confiable, esto necesitaría resolverse — y se
vuelve más urgente en cuanto exista una acción de **escritura** real
(como solicitar liberación), porque hoy no habría forma de saber ni
restringir quién la ejecuta.

## 7. Sin transacciones multi-tabla (todavía no las necesita, pero vigilar)

Hoy cada operación de escritura en ATLAS es una sola sentencia SQL
(`GuiaRepository::insert()`, `CheckpointStore::update()`,
`HeartbeatStore::recordCycle()`) — no hay necesidad de transacciones
porque nada escribe en más de una tabla a la vez. **Esto cambiará en
cuanto se implemente la solicitud de liberación**, si esa operación
necesita, por ejemplo, actualizar el estado de varias guías y registrar
una fila de auditoría en la misma operación por lote — conviene diseñar
esa escritura con una transacción explícita desde el principio (siguiendo,
por ejemplo, el patrón ya usado por `GuardarGuiaService` en el Sistema de
Guías, que si hace `beginTransaction()`/`commit()`/`rollBack()`).

## 8. Sin control de concurrencia entre operadores (mencionado en el diseño, no resuelto)

El diseño de la Mesa Operativa (`docs/03-ui/02-mesa-operativa-trafico.md
§11`) ya anticipa el caso de que dos operadores seleccionen la misma guía
al mismo tiempo, y exige que la segunda solicitud sea rechazada/ignorada.
Como el mecanismo de escritura no existe todavía, tampoco existe la
protección real (p. ej. una condición `WHERE estado = 'Generada'` en el
`UPDATE`, verificando `rowCount()`, similar en espíritu a como
`GuiaRepository::insert()` ya maneja duplicados por índice único) — es
una recomendación de diseño a seguir cuando se implemente, no un bug
actual.

## 9. Sin rotación de logs

`SyncLogger` escribe siempre en el mismo archivo
(`storage/logs/sync-engine.log`) con `FILE_APPEND`, sin límite de tamaño
ni rotación por fecha. En un proceso de larga vida como el
Synchronization Engine (corre indefinidamente), este archivo crecerá sin
límite. No es urgente al ritmo actual (pocas líneas por ciclo), pero vale
la pena vigilarlo.

## 10. Sin control de versiones de esquema de base de datos

`bin/migrate.php` ejecuta `database/schema.sql` completo cada vez
(`CREATE TABLE IF NOT EXISTS`, por lo que es seguro re-ejecutarlo, pero no
hay manera de aplicar un cambio incremental a una tabla ya existente sin
editar `schema.sql` y aplicar el `ALTER` a mano aparte). Cuando se diseñe
el esquema para soportar liberación, convendría decidir si se introduce
algún mecanismo de migraciones versionadas (aunque sea simple) antes de
que el esquema crezca más.

## 11. Placeholders visuales sin función (a tener en cuenta, no son bugs)

La píldora "CFDI Watcher: Próximamente" y las columnas/KPIs de
"Solicitadas a Liberación" y "Resultado del Timbrado" están **construidas
a propósito** por adelantado, antes de que exista su lógica — es una
decisión de diseño válida (preparar la UI para lo que viene), no un error.
Se documenta aquí únicamente para que quede explícito que su presencia
visual no implica que la funcionalidad subyacente exista.

## 12. `public/index.php` no hace nada útil

Es un placeholder (`echo` de un string fijo). Nginx lo serviría como
fallback de `/`, pero el Dashboard real vive en `/trafico.php`. Si el
proyecto crece y se agregan más módulos (Mesa Operativa, Facturación),
convendría decidir pronto qué debe mostrar realmente la raíz del sitio
(¿un menú? ¿redirigir al Dashboard?) en vez de dejarlo como placeholder
indefinidamente.
