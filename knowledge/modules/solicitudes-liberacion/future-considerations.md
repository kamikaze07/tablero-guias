# Solicitudes de Liberación — Escalabilidad y Consideraciones Futuras

---

## 1. La pregunta que este sprint no resuelve: ¿Mesa Operativa dentro de ATLAS, o trafico-system como único origen?

`docs/03-ui/02-mesa-operativa-trafico.md` diseña una herramienta operativa
**dentro de ATLAS** para que Tráfico seleccione y solicite liberación
directamente ahí. Pero `knowledge/integrations/trafico-system.md` descubrió
que **trafico-system ya construyó esa misma experiencia** de forma
independiente (selección múltiple + barra de acciones + modal), sin saber
del diseño interno de ATLAS.

Este módulo se diseñó para ser agnóstico a esa pregunta: `POST
/api/solicitudes-liberacion.php` no le importa quién lo llama, siempre que
pueda resolver los `num_guia` que le manden. Si en el futuro se decide
construir la Mesa Operativa dentro de ATLAS de todas formas, esa UI
llamaría **exactamente al mismo endpoint** (con `origen = 'atlas-mesa-operativa'`
en vez de `'trafico-system'`) — no necesitaría su propio backend de
escritura. Esta pregunta sigue sin resolverse, pero este diseño no la
bloquea en ninguna dirección.

## 2. Decisiones reservadas para el sprint de Facturación

Documentadas aquí para que ese sprint no las descubra desde cero:

- ~~Qué pasa con `guia_estado_tablero` cuando Facturación rechaza una
  solicitud~~ — **resuelto en el sprint "Tablero de Facturación"**: vuelve
  a `GENERADA` (permite re-solicitar), no se agrega un estado terminal
  nuevo. Ver `workflow.md §2` para la justificación completa y
  `App\Liberacion\SolicitudLiberacionService::rechazar()` para la
  implementación.
- **Aprobación/rechazo parcial dentro de un mismo lote.** Este diseño deja
  la puerta abierta (la relación N a N vía `solicitud_liberacion_detalle`
  ya lo permite estructuralmente) pero no lo implementa — hoy la cabecera
  tiene un único `estado` para todo el lote. Si Facturación necesita
  resolver guía por guía, la extensión natural es agregar una columna
  `estado` a `solicitud_liberacion_detalle` (hoy no la tiene, ver
  `database-design.md §3`) — cambio aislado, no rompe lo ya construido.
- **`resolved_at`/`resolved_by` en `solicitud_liberacion`** — deliberadamente
  no incluidas en este sprint (`database-design.md §2`). Facturación
  necesitará su propia migración para agregarlas.
- **`CANCELADA` como estado de solicitud** — descartado en `workflow.md §3`
  por contradecir una regla de negocio ya fijada ("no existe reversión").
  Si el negocio cambia esa regla, es una decisión de producto explícita, no
  un ajuste técnico menor.

## 3. Otros orígenes además de trafico-system

El campo `origen` en `solicitud_liberacion` (`database-design.md §2`) ya
anticipa que, algún día, otro sistema (o la propia Mesa Operativa de ATLAS,
ver §1) llame al mismo endpoint. No hay ningún supuesto hardcodeado a
"trafico-system" en la lógica de validación o persistencia — solo en el
valor que se guarda como dato. El único ajuste necesario para soportar un
origen nuevo sería (si se decide requerir autenticación, `security.md §4`)
emitir credenciales distintas por origen para poder diferenciarlos en
auditoría — no un cambio de esquema ni de flujo.

## 4. Notificación de vuelta hacia trafico-system

Hoy no existe ningún mecanismo en sentido ATLAS → trafico-system —el
WebSocket (puerto 8098) es interno de ATLAS y trafico-system no lo consume
(confirmado en `knowledge/integrations/trafico-system.md §9`). Si en el
futuro se quiere que el listado de `/guias` en trafico-system refleje que
una guía ya fue solicitada (para no volver a mostrarla como seleccionable),
las opciones son: (a) que trafico-system empiece a consultar
`GET /api/guias-liberables.php` (`api-design.md §5`) antes de pintar cada
fila, o (b) que trafico-system se conecte también al WebSocket público de
ATLAS. Ninguna de las dos se decide aquí — dependen de trabajo en el
repositorio de trafico-system, fuera del control de este proyecto.

## 5. Por qué ninguna clase existente de ATLAS se modifica

Se repite aquí porque es una propiedad importante del diseño completo, no
solo de `events.md`: **cero cambios a `App\Sync`, `App\Dashboard`,
`App\WebSocket`, `App\Database`, `App\Config`, `bin/*.php`, o
`public/trafico.php`.** Todo el módulo vive en un namespace nuevo
(`App\Liberacion`) y un script de entrada nuevo
(`public/api/solicitudes-liberacion.php`). La única superficie compartida
son interfaces ya genéricas (`EventPublisher`) y clases ya reutilizables
sin modificación (`ConnectionFactory`, `Config`).

Esto no es solo prudencia — es una señal de que el diseño respeta el
principio de "Watcher" que ya rige `App\Sync` (agregar capacidades sin
tocar las existentes) aplicado a un componente que ni siquiera es un
`Watcher`. Si una futura revisión de este diseño necesitara modificar algo
fuera de `App\Liberacion`, sería una señal de que algo en el diseño no
encajó tan limpiamente como se pensó, y valdría la pena reabrir la
discusión antes de implementar.

**Actualización (sprint "Tablero de Facturación")**: la invariante se
mantuvo para `App\Sync`, `App\Dashboard` (namespace), `App\WebSocket`,
`App\Database` y `App\Config` — ninguna clase de esos namespaces cambió.
Dos excepciones puntuales, ambas aditivas y hacia atrás compatibles, no
"modificaciones de comportamiento existente":
- `public/api/heartbeat.php` ganó un parámetro opcional `?engine=`
  (default preserva el comportamiento previo) para que el nuevo tablero
  pudiera consultar el heartbeat de `monitoring-engine` sin duplicar el
  script.
- `resources/views/trafico.php` ganó un enlace de navegación cruzada hacia
  `/facturacion.php` (y su CSS en `trafico.css`, reutilizado por ambas
  páginas) — cambio puramente de navegación, cero lógica.
Ninguno de los dos altera el comportamiento que ya existía para quien no
usa la funcionalidad nueva.

## 6. Límite conocido no resuelto: sin envelope de versión en los eventos

Ya señalado en `knowledge/websocket.md §2` para `guia.detectada`, y
heredado sin cambios por `guia.liberacion_solicitada`: los mensajes no
llevan número de versión ni id único. Si en el futuro se necesita
idempotencia del lado del cliente (evitar procesar el mismo evento dos
veces tras una reconexión) o versionado del contrato del mensaje, será un
cambio transversal a `SocketEventPublisher`/`TrafficDashboard`, no algo que
este módulo por sí solo deba o pueda resolver.

## 7. Análisis de escalabilidad

### 7.1 Miles de solicitudes
Las cuatro tablas nuevas son estructuralmente comparables a `guias` (misma
familia de tamaño de fila, mismo motor `InnoDB`), y llevan índices sobre
las columnas que realmente se filtran (`estado`, `created_at`, `guia_id`).
A volúmenes de "miles por día" (varios órdenes de magnitud por debajo de lo
que ya maneja `guias`, que sincroniza lotes de 500 por ciclo cada 2
segundos, ver `knowledge/architecture.md §4`), no hay ningún indicio de que
esto requiera particionamiento, archivado, o caché — es el mismo patrón de
acceso (PDO preparado, sin ORM) que ya sostiene el resto de ATLAS.

### 7.2 Múltiples usuarios simultáneos
No hay concepto de "usuario" que gestionar (§4 de `security.md`), pero sí
hay **solicitudes concurrentes** que gestionar correctamente — resuelto por
el mecanismo de compare-and-swap sobre `guia_estado_tablero`
(`database-design.md §1`, `security.md §3`). A diferencia del cálculo de
folio de trafico-system (`MAX(num)+1`, condición de carrera teórica no
resuelta según la propia documentación de ese proyecto), este diseño cierra
esa ventana desde el principio, sin necesitar `SELECT ... FOR UPDATE`
explícito ni bloqueos de tabla.

### 7.3 Futuras integraciones / otros sistemas
Cubierto en §3 — el diseño no asume un único origen. La única suposición
que sí mantiene es que **todo origen resuelve guías por `num_guia` contra
la propia tabla `guias` de ATLAS** (no acepta datos de guía "de confianza"
enviados por el llamador, ver `security.md §2`) — esa restricción es
intencional y se mantendría igual sin importar cuántos orígenes se agreguen.

### 7.4 Qué SÍ podría convertirse en un cuello de botella (para vigilar, no para resolver ahora)
- La consulta `LEFT JOIN guia_estado_tablero` para listar "guías
  generadas" (`database-design.md §1`) crece linealmente con el volumen de
  `guias` sin filtro de estado — a volúmenes de miles de guías por día
  sigue siendo trivial para MariaDB con el índice `idx_guias_fecha` ya
  existente, pero si el histórico de `guias` creciera sin ningún corte (no
  hay archivado hoy en ningún lado de ATLAS), valdría la pena revisar en
  el futuro. No es un problema introducido por este módulo — ya existe
  igual para `GuiaBoardRepository::findToday()`.
