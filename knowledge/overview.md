# Overview — ATLAS (Tablero de Liberación y Timbrado de Guías)

## Qué es ATLAS

ATLAS (`forsis/atlas`, nombre de proyecto en `composer.json`; el repositorio
local se llama `tablero-guias`) es una plataforma web **independiente de
SICRET** cuyo objetivo declarado (`CLAUDE.md`) es:

> "Desarrollar una plataforma web independiente de SICRET para administrar
> en tiempo real las solicitudes de liberación y timbrado de guías. SICRET
> seguirá siendo el sistema principal. Este proyecto únicamente consume
> información de SICRET."

Es decir: ATLAS nace explícitamente como el sistema que va a **formalizar y
gestionar** el proceso de negocio de "liberación y timbrado" que hoy vive
implícitamente repartido entre SICRET y sus operadores humanos — y lo hace
sin nunca escribir sobre las bases de datos de SICRET.

## Estado real del proyecto (muy temprano)

Confirmado por código, `git log` (6 commits) y los propios documentos de
diseño internos (`docs/`): **ATLAS está en una fase muy inicial**. Lo que
existe hoy, funcionando:

1. Un **Synchronization Engine** que detecta guías nuevas en dos de las
   cuatro bases de SICRET configuradas (`sicrePR`, `sicreGero`) y las
   replica (solo lectura desde SICRET, solo inserción en ATLAS) en su
   propia base de datos.
2. Un **servidor WebSocket** (Ratchet) que retransmite esos eventos de
   detección a cualquier navegador conectado.
3. Un **Dashboard de Tráfico** (`/trafico.php`) de solo observación, con 3
   columnas visuales (Guías Generadas / Solicitadas a Liberación /
   Resultado del Timbrado) — pero **solo la primera columna tiene datos
   reales**; las otras dos existen visualmente (HTML, CSS, sonidos,
   contadores) pero nunca reciben contenido porque nada en el sistema
   dispara todavía los eventos que las alimentarían.

Lo que **no existe aún como código** (solo como documento de diseño,
`docs/03-ui/02-mesa-operativa-trafico.md`, explícitamente marcado como
diseño de un sprint futuro):

- La **Mesa Operativa de Tráfico**: la herramienta donde un operador
  seleccionaría una o varias guías y solicitaría su liberación. No hay
  ninguna vista, endpoint, tabla ni evento de esto implementado.
- Cualquier tabla o campo en la base de datos de ATLAS que represente una
  "solicitud de liberación".
- El **CFDIWatcher** (monitoreo de sistema de archivos para detectar
  resultados de timbrado) — mencionado en la UI como "Próximamente".
- El módulo de **Facturación** (revisar/aceptar/rechazar/liberar
  realmente la guía) — mencionado solo como consumidor futuro.
- Cualquier forma de autenticación, usuarios, roles o permisos.

**Esto es central para el objetivo final del usuario** (integrar el
Sistema de Guías con ATLAS para solicitar liberación desde allá,
"manteniendo la lógica de negocio dentro de ATLAS"): **esa lógica de
negocio todavía no existe dentro de ATLAS** — hoy solo existe como
especificación funcional detallada. Ver `liberacion.md` para el desglose
completo de la brecha entre lo diseñado y lo implementado.

## Relación con SICRET y con el Sistema de Guías (trafico-system)

- ATLAS lee (nunca escribe) de las mismas 4 bases MySQL de SICRET que ya
  documentamos para el Sistema de Guías (`sicrePR`, `sicre2PR`,
  `sicreGero`, `sicre2Gero` — esta última no existía en la documentación
  del Sistema de Guías, ver `database.md`).
- El Sistema de Guías (`trafico-system`) **sí escribe** directamente en
  `sicrePR`/`sicre2PR` (vía `GuardarGuiaService`). ATLAS, por diseño,
  **nunca** escribiría ahí — cualquier acción de negocio (como liberar una
  guía) tendría que materializarse como escritura en la propia base de
  ATLAS, nunca en SICRET.
- Ambos proyectos son consumidores independientes de la misma familia de
  bases de datos legacy, pero no se conocen entre sí ni comparten código,
  infraestructura ni base de datos hoy.

## Tecnologías (declaradas en `CLAUDE.md` y confirmadas en código)

| Capa | Tecnología |
|---|---|
| Backend | PHP 8.3, orientado a objetos, PSR-4 vía Composer (**a diferencia del Sistema de Guías, que no usa Composer**) |
| Tiempo real | Ratchet (WebSockets sobre ReactPHP) |
| Frontend | HTML5, CSS3, JavaScript ES6 (módulos nativos `type="module"`, sin bundler), Bootstrap 5 + Bootstrap Icons por CDN |
| Base de datos | MariaDB (propia, `atlas`) |
| Infraestructura | Docker, Nginx, PHP-FPM |

## Principios de diseño explícitos (`CLAUDE.md`)

- Código limpio, PHP orientado a objetos, PSR-4, sin mezclar HTML con
  lógica de negocio, sin variables globales, sin archivos gigantes.
- Reutilizar componentes existentes antes de crear código nuevo.
- Código en inglés; comentarios, documentación e interfaz en español.

Esto contrasta fuertemente con el Sistema de Guías (`trafico-system`), que
no sigue ninguno de estos principios (sin Composer, SQL embebido en
controllers, JS y HTML mezclados). **ATLAS es, en su forma, un proyecto
mucho más disciplinado**, aunque mucho menos completo en alcance funcional
todavía.

## Cómo se relacionan los documentos de esta carpeta

- `architecture.md` — componentes del sistema y ciclo de vida completo de
  un evento (SICRET → Synchronization Engine → ATLAS DB → WebSocket → UI).
- `backend.md` — inventario de clases PHP por namespace (`App\Sync`,
  `App\Dashboard`, `App\WebSocket`, `App\Database`, `App\Config`).
- `frontend.md` — el Dashboard de Tráfico, su JS y su CSS.
- `database.md` — el esquema real de `atlas` y las 4 bases de SICRET que
  consume (documentadas, aunque su contenido interno sigue "pendiente" según
  los propios docs de ATLAS).
- `liberacion.md` — documento central pedido por el usuario: qué existe
  hoy del flujo de liberación (nada implementado, mucho diseñado) y qué
  falta para que el Sistema de Guías pueda integrarse.
- `integrations.md` — SICRET (las 4 bases) como única integración externa
  real; ausencia de Mattermost/CFDIWatcher/Facturación.
- `websocket.md` — protocolo interno (puerto 8099) y público (puerto 8098)
  de Ratchet.
- `api.md` — inventario de endpoints HTTP (hoy: solo `heartbeat.php`).
- `ui_patterns.md` — patrones visuales del Dashboard (tablero de tarjetas,
  KPIs, indicadores de estado, sonidos).
- `improvement_notes.md` — brechas, riesgos y pendientes detectados,
  incluidos los que los propios documentos de ATLAS ya se auto-señalan.

## Qué NO se pudo determinar solo leyendo el código

- El esquema interno de las tablas de `sicrePR`, `sicre2PR`, `sicreGero`,
  `sicre2Gero` **no está confirmado dentro de este repositorio** — el
  propio documento `docs/02-architecture/01-Datasources.md` lo marca
  explícitamente como "PENDIENTE". (Nota: para las bases `sicrePR` y
  `sicreGero`, sí pudimos inferir la forma de la tabla `guias` a partir del
  código de `GuideWatcher`/`GuiaRecord`, que sí las consulta activamente;
  ver `database.md`.)
- La relación entre `sicrePR`/`sicre2PR` y entre `sicreGero`/`sicre2Gero` —
  marcado como pendiente en la propia documentación de ATLAS.
- Cualquier decisión de producto sobre qué significa "liberar" una guía a
  nivel de datos, quién puede solicitarlo, y cómo se relaciona con el
  Sistema de Guías — no existe ninguna definición de esto en el código ni
  en los documentos de diseño más allá de "Tráfico solicita, Facturación
  decide" (sin detalle de esa segunda parte).
