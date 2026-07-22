# Solicitudes de Timbrado — Visión General (as-built)

> A diferencia de `knowledge/modules/solicitudes-liberacion/`, este
> documento describe código **ya implementado**, no un diseño previo. El
> módulo (`App\Timbrado`) nació deliberadamente mínimo — sin `Executor`, sin
> máquina de estados de la guía, sin panel en el Dashboard de Facturación —
> por encargo explícito de trafico-system al pedir esta integración. Ver
> `knowledge/integrations/trafico-system.md` para el contexto original de la
> integración con trafico-system (ese documento sigue describiendo
> Liberación; este es su equivalente para Timbrado).

## 1. Qué es una Solicitud de Timbrado

Es el registro, propio de ATLAS, de que trafico-system pidió que Facturación
timbre una o varias guías que siguen en su estatus de nacimiento
(`Por Timbrar` en SICRET). A diferencia de una Solicitud de Liberación:

- **No mueve ninguna máquina de estados de la guía.** `guia_estado_tablero`
  (exclusiva de `App\Liberacion`) no aplica aquí — no hay
  `intentarMarcarSolicitada()` ni riesgo de que dos solicitudes "reclamen" la
  misma guía, porque nada se reclama.
- **No tiene motivo.** El contrato de negocio que definió trafico-system
  para este proceso no contempla ese campo (a diferencia de Liberación,
  donde sí es obligatorio).
- Sí lleva, de forma opcional, `solicitante`: el nombre del usuario de
  trafico-system que la generó (`CurrentUser`, propio de ese sistema — ATLAS
  no tiene usuarios). Es el único de los dos módulos que persiste este dato;
  `solicitud_liberacion` no tiene columna equivalente.

## 2. Quién la crea

Igual que Liberación: siempre `trafico-system` (`origen`), nunca una persona
identificada del lado de ATLAS.

## 3. Quién la atiende

**Nadie todavía.** `solicitud_timbrado.estado` solo alcanza `PENDIENTE` en
este sprint — igual que le pasó a `solicitud_liberacion` en el suyo. No
existe `PATCH` de aprobar/rechazar, no hay panel en `facturacion.php`, y no
hay ningún `Executor` que escriba contra SICRET. Cuando exista ese futuro
sprint de Facturación para Timbrado, debería mirar
`App\Liberacion\SolicitudLiberacionService::aprobar()/rechazar()` como
referencia de patrón (compare-and-swap sobre `estado`, bitácora
append-only), pero **no debe tocar `App\Liberacion` ni `SicretGateway`**
para construirlo — este documento es el punto de partida.

## 4. Componentes (`app/Timbrado/`)

| Clase | Rol |
|---|---|
| `SolicitudTimbradoPayload` | Valida forma del payload (`guias[]` no vacío, sin duplicados; `solicitante` opcional). Sin `motivo`. |
| `SolicitudTimbradoValidationException` | Errores tipados con `errorCode`/`httpStatus`, mismo patrón que `SolicitudLiberacionValidationException`. |
| `SolicitudTimbradoRepository` | Cabecera (`solicitud_timbrado`): insertar, encontrarPorId, listar/contar con filtros. |
| `SolicitudTimbradoDetalleRepository` | Relación N a N solicitud↔guía (`solicitud_timbrado_detalle`). |
| `SolicitudTimbradoHistorialRepository` | Bitácora append-only (`solicitud_timbrado_historial`) — solo evento `CREADA` en este sprint. |
| `SolicitudTimbradoService` | Orquestador: resuelve folios (reutiliza `App\Liberacion\GuiaLookupRepository` tal cual — es genérica, no específica de Liberación), transacción, publica evento, notifica. |

`public/api/solicitudes-timbrado.php` es el punto de entrada HTTP —
reutiliza `App\Liberacion\JsonResponse` (también genérica) para no duplicar
esa clase. Soporta `POST` (crear), `GET` (listar / `?id=`). **No** soporta
`PATCH` — no hay acción de Facturación que ejecutar todavía (ver §3).

## 5. Qué recibe este endpoint

```
POST /api/solicitudes-timbrado.php
{
  "guias": [{ "num_guia": "PR012345" }],
  "solicitante": "Nombre del usuario de trafico-system (opcional)"
}
```

Respuesta `201`:

```json
{
  "id": 1,
  "origen": "trafico-system",
  "solicitante": "...",
  "estado": "PENDIENTE",
  "created_at": "...",
  "guias": [{ "guia_id": 2, "num_guia": "PR012345" }]
}
```

Errores (`400/404/409`, mismo formato que Liberación): `guias_requeridas`,
`payload_invalido`, `guias_duplicadas`, `guia_no_encontrada`, `guia_ambigua`.

Publica el evento `guia.timbrado_solicitado` por el mismo canal WebSocket
interno que ya usa Liberación (`SocketEventPublisher`, puerto 8099) — hoy
sin ningún listener en el Dashboard (no se tocó `facturacion.php`), así que
no tiene efecto visible todavía; queda ahí para cuando se construya el panel
de Facturación.

## 6. Base de datos

Tres tablas nuevas en `database/schema.sql`, mismo diseño que sus
equivalentes de Liberación pero sin las columnas de máquina de estados que
no aplican aquí (`resolved_at`, `resolved_by`, `executed_at`, `confirmed_at`,
`error_reason`, `estado_anterior`/`estado_nuevo`):

- `solicitud_timbrado` (id, origen, solicitante, estado, created_at)
- `solicitud_timbrado_detalle` (solicitud_id, guia_id, num_guia)
- `solicitud_timbrado_historial` (id, solicitud_id, evento, actor, detalle, created_at)

Aplicadas con `bin/migrate.php` (idempotente, `CREATE TABLE IF NOT EXISTS`).

## 7. Qué NO hace este módulo (a propósito)

- No escribe en SICRET ni invoca `SicretGateway`.
- No mueve `guia_estado_tablero`.
- No tiene `Executor` ni Watcher registrado en `bin/monitoring-engine.php`.
- No agrega ninguna columna ni panel a `facturacion.php` / `resources/views/facturacion.php`.
- No expone `PATCH` (aprobar/rechazar).

Estas cinco restricciones fueron un requisito explícito del sprint que
integró Timbrado desde trafico-system, no un olvido — cualquier ampliación
futura de este módulo debe tratarlas como decisiones a revisar
conscientemente, no como omisiones a "completar".
