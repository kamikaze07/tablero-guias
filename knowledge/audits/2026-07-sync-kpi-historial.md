# Auditoría — Sincronización, KPIs e Historial (jul 2026)

> Sprint: "Auditoría y corrección del motor de sincronización y KPIs".
> Síntoma reportado: solicitudes de timbrado aprobadas y de liberación
> rechazadas el día anterior dejaban de reflejarse en el panel de
> Facturación al día siguiente.

## 1. Resumen ejecutivo

El histórico **nunca se perdió en base de datos**. Se verificó con datos
reales (ver §4) que toda solicitud de Liberación/Timbrado resuelta el
23/jul sigue siendo 100% consultable el 24/jul vía API. La causa raíz del
síntoma reportado era de **presentación**, no de datos:

- La barra de KPIs del tablero de Tráfico (`trafico.js`) contaba tarjetas
  visibles en el DOM del navegador en ese momento, no una consulta al
  servidor. Cualquier recarga de página, o el simple paso del corte de
  jornada, ponía esos contadores en cero — el dato seguía en la base,
  pero la tarjeta ya no lo mostraba.
- Varias consultas de KPI (`kpis()` en `SolicitudLiberacionRepository` /
  `SolicitudTimbradoRepository`, y el conteo de "Guías Generadas" del
  tablero de Tráfico) usaban el corte de **medianoche del sistema** en
  vez de la jornada operativa real de la empresa, que empieza a las
  07:00. Una aprobación ocurrida a las 06:30 quedaba fuera de "hoy"
  aunque operativamente perteneciera al turno que apenas estaba por
  cerrar.

Al momento de esta auditoría, **ambos problemas ya estaban corregidos**
en el working tree (sin commitear) mediante `App\Dashboard\BusinessDay` +
`App\Dashboard\DailyCutoverEngine` + endpoints de KPI recalculados en
servidor. Esta auditoría **verificó esa corrección contra datos reales**
(§4, §5) y no encontró pérdida de información en ningún otro punto del
flujo FORSIS → Sync → BD → Runtime → Paneles → KPIs.

## 2. Metodología

- Lectura completa del flujo FORSIS → Sync → BD → Runtime → Paneles →
  KPIs (repositorios, servicios, endpoints, vistas, JS).
- Grep dirigido a filtros de fecha implícitos: `CURDATE()`, `NOW()`,
  `TODAY()`, `'today'`, `date('Y-m-d')`, `LIMIT`/`OFFSET` sin paginación
  explícita.
- Verificación contra el entorno Docker real (`atlas-db`, `atlas-sync-engine`,
  `atlas-daily-cutover`, etc., ya corriendo), incluyendo consultas SQL
  directas y llamadas HTTP a los endpoints reales.
- Cruce contra memoria de decisiones previas del proyecto antes de tocar
  cualquier código señalado por el checklist del sprint (ver §3).

## 3. Punto revisado y mantenido sin cambios: primer arranque de `GuideWatcher`

`app/Sync/GuideWatcher.php::runFetchBatch()` agrega `AND fecha >= :today`
únicamente cuando el checkpoint de una fuente está en 0 (fuente nueva, o
reiniciada manualmente). A primera vista esto choca con el criterio
explícito del sprint ("no procesar únicamente registros del día"), y se
evaluó revertirlo.

Sin embargo, es una **decisión de arquitectura aprobada explícitamente el
2026-07-16** ("el primer arranque debe cargar primero todas las guías
del día actual como carga inicial"), verificada end-to-end en su momento
(`v0.2.0-sync-engine`). Se confirmó con el equipo que se mantiene así:

- Solo se ejecuta una vez por fuente, en su primerísimo ciclo de vida
  (`checkpoint === 0`). No es un comportamiento recurrente ni relacionado
  con el síntoma reportado (que es sobre solicitudes ya existentes,
  resueltas y luego "desaparecidas" — un problema completamente distinto,
  ver §1).
- Las dos fuentes activas (`sicrePR`, `sicreGero`) ya superaron ese primer
  ciclo hace tiempo (checkpoints en `226107` y `220167` respectivamente al
  momento de esta auditoría) — no hay ningún efecto práctico hoy.
- Se documenta aquí para que quede explícito que **se revisó a propósito
  y se decidió mantener**, no que se pasó por alto.

Si en el futuro se agrega una fuente nueva y se quiere que su primera
carga traiga histórico completo en vez de solo el día de alta, ese sería
un cambio de este mismo archivo (`runFetchBatch()`), a decidir puntualmente
cuando ocurra, no como parte de esta auditoría.

## 4. Evidencia — el histórico de solicitudes SÍ está completo

Consultas en vivo contra `atlas-db` (24/jul, ~09:06 hora de México):

```
sync_checkpoints:
  sicreGero  220167  2026-07-23 18:15:10
  sicrePR    226107  2026-07-23 21:35:39

guias: MIN(fecha)=2010-08-02, MAX(fecha)=2026-07-23 21:35:38, 5875 filas
```

Llamadas reales a los endpoints públicos, sin filtro de fecha, el día
después de la actividad:

```
GET /api/solicitudes-timbrado.php?estado=ESPERANDO_TIMBRADO
  -> 5 solicitudes, todas creadas el 2026-07-23 (12:05–13:58)

GET /api/solicitudes-timbrado.php?estado=RECHAZADA
  -> 3 solicitudes: 2 del 2026-07-23, 1 del 2026-07-21

GET /api/solicitudes-liberacion.php?estado=COMPLETADA
  -> 3 solicitudes, todas del 2026-07-23 (18:54–18:57)

GET /api/solicitudes-liberacion.php?estado=RECHAZADA
  -> 2 solicitudes, ambas del 2026-07-23 (18:40–18:43)
```

Ninguna de estas requirió pasar `desde`/`hasta` — el histórico completo
sigue ahí. El panel de Facturación solo necesita que el usuario elija el
estado correcto (o "Todos los estados") en el filtro; el default de
carga inicial (`estado=PENDIENTE`) es una decisión de UX documentada en
`public/facturacion.php`, no una pérdida de datos.

## 5. Evidencia — el resumen diario cruza exactamente con el detalle por guía

`resumen_diario_tablero` (escrito una sola vez por `DailyCutoverEngine`
al cruzar las 07:00) para el 2026-07-23:

```
timbrado_aprobadas=17  timbrado_rechazadas=4
liberacion_aprobadas=5 liberacion_rechazadas=5
```

Verificado contra la suma de `total_guias` de cada solicitud individual
del mismo día (§4): `ESPERANDO_TIMBRADO` (1+8+1+1+6=17), `RECHAZADA` de
timbrado con `resolved_at` del 23/jul (2 solicitudes × 2 guías = 4),
`COMPLETADA` de liberación (2+1+2=5), `RECHAZADA` de liberación
(4+1=5). Coincide exactamente — el resumen diario no arrastra ni pierde
guías respecto al detalle real.

**Caveat conocido:** la fila del 2026-07-22 en `resumen_diario_tablero`
quedó en cero para timbrado/liberación (`guias_creadas=45`, el resto en
0). Corresponde al primer ciclo del motor tras su despliegue
(`generado_at 2026-07-23 10:09`), antes de que `solicitud_timbrado`
tuviera las columnas `resolved_at`/`resolved_by` (agregadas en este mismo
cambio). No es un bug recurrente — es una fila histórica con datos
incompletos por el momento del despliegue, y no se puede recalcular
retroactivamente sin esas columnas para fechas previas a su creación.

## 6. Otros puntos del checklist auditados sin hallazgos

- **Filtros de fecha implícitos** (`CURDATE`, `NOW()`, `TODAY()`,
  `created_at >= hoy`): el único `NOW()` real está en cálculos de tiempo
  de espera (`TIMESTAMPDIFF(MINUTE, created_at, NOW())`), no en filtros
  de inclusión/exclusión de filas.
- **Zona horaria**: `date.timezone => America/Mexico_City` confirmado en
  `php.ini` dentro del contenedor — `BusinessDay` calcula el corte de las
  07:00 en hora local correcta, no UTC.
- **`LIMIT`/`OFFSET`**: todos los usos son paginación explícita
  (`page`/`perPage` desde el cliente), ninguno trunca resultados por
  defecto de forma oculta.
- **`guia-historial.php`** (historial por folio): sin restricción de
  fecha, trae todos los eventos de Timbrado/Liberación del folio sin
  importar la antigüedad.
- **`GuiaEstadoTableroRepository`** (panel "Por Timbrar" de Facturación):
  sin filtro de fecha — depende únicamente del estado (`POR_TIMBRAR`),
  correcto para un panel de trabajo pendiente.
- **Sync no reinicia estados**: `GuiaRepository::insert()` es
  INSERT-only (duplicados se ignoran por índice único), nunca hace
  `UPDATE`/reinicio de una guía ya existente.

## 7. Correcciones implementadas (resumen)

1. `App\Dashboard\BusinessDay` + `App\Dashboard\DailyCutoverEngine` +
   `resumen_diario_tablero` — corte de jornada real (07:00) en vez de
   medianoche, ya en el working tree antes de esta auditoría, verificado
   aquí contra datos reales (§4, §5).
2. KPIs del tablero de Tráfico movidos de conteo client-side (DOM) a
   `GET /api/trafico-kpis.php`, recalculado en servidor por ventana de
   jornada — ya en el working tree, verificado en vivo (§1).
3. Primer arranque de `GuideWatcher` (§3): revisado, sin cambios —
   decisión previa reafirmada, no relacionada con el síntoma reportado.

Ninguna corrección requirió filtrar u ocultar información para
"resolver" el síntoma — la corrección expone más datos (el histórico
completo por jornada real), nunca menos.
