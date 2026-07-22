# Integraciones Externas — ATLAS

## 1. SICRET (la única integración externa real)

La razón de ser de ATLAS. Cuatro bases de datos MySQL/MariaDB, todas
alojadas en el mismo host físico (`192.168.1.209`, confirmado en `.env`) —
el mismo servidor que ya usa el Sistema de Guías para `SicretDatabase`/
`Sicret2Database`/`SicretGeroDatabase`/`TraficoDatabase`.

| Base | Prefijo de entorno | Registrada en `config/sources.php` | Consumida activamente hoy |
|---|---|---|---|
| `sicrePR` | `FORSIS_DB` | Sí | Sí — tabla `guias`, vía `GuideWatcher` |
| `sicre2PR` | `FORSIS_2_DB` | No | No |
| `sicreGero` | `GERO_DB` | Sí | Sí — tabla `guias`, vía `GuideWatcher` |
| `sicre2Gero` | `GERO_2_DB` | No | No |

Reglas de integración, explícitas en `CLAUDE.md` y reforzadas en
`docs/02-architecture/01-Datasources.md`:
- **Solo lectura, siempre.** ATLAS nunca ejecuta `INSERT`/`UPDATE`/`DELETE`
  contra ninguna base de SICRET — confirmado por inspección de todo el
  código (`GuideWatcher::fetchBatch()` es la única consulta contra estas
  bases, y es un `SELECT`).
- **SICRET no genera eventos.** No hay triggers, no hay colas, no hay
  CDC (Change Data Capture) del lado de SICRET — toda detección de
  cambios es **polling activo** desde ATLAS (`SynchronizationEngine`,
  cada `SYNC_POLLING_INTERVAL_SECONDS`, default 2s).
- **Único punto de acceso**: el `Synchronization Engine`
  (`App\Sync\*`) — ninguna otra parte de ATLAS (Dashboard, futura Mesa
  Operativa) se conecta directamente a una base SICRET; todas leen de la
  réplica local en `atlas.guias`.
- El **monitoreo de sistema de archivos** que menciona `CLAUDE.md`
  ("Toda detección de cambios deberá realizarse mediante monitoreo de la
  base de datos y del sistema de archivos") está pensado para el futuro
  `CFDIWatcher` (detectar XML/PDF/YAML de resultados de timbrado en
  carpetas del sistema de archivos) — **no implementado**, ninguna ruta de
  archivos está siquiera configurada todavía.

## 2. Mattermost

**No existe ninguna integración con Mattermost en ATLAS**, a diferencia
del Sistema de Guías (que sí tiene `MattermostNotifier` en el módulo
Operación). El diseño de la Mesa Operativa lo menciona explícitamente como
"fuera de alcance de este sprint" (`docs/03-ui/02-mesa-operativa-trafico.md
§18`) — es decir, se contempló y se decidió expresamente no incluirlo
todavía, no es un olvido.

## 3. CFDIWatcher (diseñado, no implementado)

Mencionado en múltiples documentos de diseño y en la propia UI (píldora
"CFDI Watcher: Próximamente" en el Dashboard) como el componente que
monitorearía el sistema de archivos para detectar el resultado del proceso
de timbrado (XML + PDF = éxito; YAML en carpeta de error = error). **No
hay ninguna clase, ruta de archivo configurada, ni siquiera un stub** —
sería, cuando se implemente, un segundo `Watcher` (misma interfaz que
`GuideWatcher`) inyectado en el array de watchers de
`SynchronizationEngine`.

## 4. Módulo de Facturación (mencionado, no implementado)

Consumidor futuro de las solicitudes de liberación (revisar, aceptar,
rechazar, liberar realmente la guía). Sin ningún código, vista, ni
integración concreta — solo referenciado como "fuera de este documento" en
ambos documentos de diseño de `docs/03-ui/`.

## 5. Bootstrap CDN (Bootstrap 5, Bootstrap Icons)

Cargados vía `<link>` a `cdn.jsdelivr.net` en `resources/views/trafico.php`
— única dependencia de frontend de terceros, sin gestor de paquetes JS
(no hay `package.json`). Análogo a la dependencia de Tailwind CDN del
Sistema de Guías, aunque aquí el CSS propio (`trafico.css`) hace la mayor
parte del trabajo visual (tema oscuro tipo centro de operaciones,
Bootstrap aporta principalmente los íconos y utilidades base).

## 6. Resumen para la integración con el Sistema de Guías

| Pregunta | Respuesta |
|---|---|
| ¿ATLAS expone hoy algún endpoint que el Sistema de Guías pueda consumir? | No, solo `GET /api/heartbeat.php` (estado del motor, sin relación con guías individuales) |
| ¿ATLAS podría, en el futuro, exponer un endpoint de "solicitar liberación"? | Sí — es, de hecho, la pieza que falta construir según el propio diseño interno de ATLAS (ver `liberacion.md §4`) |
| ¿El Sistema de Guías podría escribir directamente en la base `atlas`? | Técnicamente posible (misma familia de red, MariaDB expuesta en el puerto host `3311`), pero **contradice el principio de responsabilidad única que ambos proyectos declaran** — lo consistente con la arquitectura de ambos es una integración vía API HTTP, no acceso directo a base de datos cruzada |
| ¿Existe ya un vocabulario común entre ambos sistemas? | Sí — `num_guia` (formato `PRxxxxxx`) y `source`/empresa (`sicrePR`≈FORSIS, `sicreGero`≈GERO) son conceptos idénticos en ambos proyectos, porque ambos leen de las mismas bases SICRET |
