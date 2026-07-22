# Mesa Operativa de Tráfico — Diseño Funcional

## 1. Alcance

Este documento define exclusivamente la **Mesa Operativa de Tráfico**: la herramienta de trabajo que usan los operadores de Tráfico para solicitar la liberación de guías.

No es el Dashboard de Tráfico. El [Dashboard](01-dashboard-trafico.md) sigue siendo, sin cambios, una pantalla de monitoreo pasivo (ver §11 de este documento). La Mesa Operativa es un módulo aparte, con su propia pantalla y su propio propósito, que comparte con el Dashboard la misma base de datos de ATLAS y el mismo Synchronization Engine.

El módulo de Facturación (revisar / aceptar / rechazar / liberar) queda fuera de este documento — se menciona únicamente como consumidor futuro de lo que aquí se produce (§12).

---

## 2. Objetivo del módulo

Darle a Tráfico un lugar de trabajo — no de observación — donde pueda:

1. Encontrar rápidamente las guías que le interesan (búsqueda y filtros).
2. Confirmar que la información es correcta.
3. Solicitar su liberación hacia Facturación, individualmente o por lote.

El módulo formaliza el cambio de proceso de negocio: Tráfico deja de tener el botón de "liberar" (eso ya no existe en ningún punto de ATLAS) y pasa a tener el botón de "solicitar liberación".

---

## 3. Naturaleza de la aplicación

Es una **aplicación operativa**, no un tablero de monitoreo. La diferencia debe notarse en el diseño visual, no solo en la función:

| | Dashboard de Tráfico | Mesa Operativa de Tráfico |
|---|---|---|
| Propósito | Observar el proceso | Trabajar sobre el proceso |
| Formato de datos | Tarjetas (cards) | Listado/tabla densa |
| Interacción | Ninguna (solo lectura) | Buscar, filtrar, seleccionar, accionar |
| Ritmo visual | Pausado, tipo centro de operaciones | Denso, tipo herramienta administrativa |
| Usuario típico | Pantalla compartida / de fondo | Un operador trabajando activamente en su propia sesión |

Ambos módulos leen y escriben sobre la misma fuente de verdad (la base de datos de ATLAS), así que lo que ocurre en uno se refleja en el otro en tiempo real — pero nunca comparten pantalla, ni layout, ni componentes visuales.

---

## 4. Flujo operativo

```
SICRET genera una guía (Tráfico)
          │
          ▼
Synchronization Engine detecta la guía nueva
          │
          ▼
ATLAS inserta la guía (estado operativo: GENERADA)
          │
          ├──────────────────────────────┐
          ▼                              ▼
Dashboard de Tráfico                Mesa Operativa de Tráfico
(la muestra en "Guías Generadas")   (la muestra en el listado, seleccionable)
                                          │
                                          │  operador busca / filtra
                                          │  operador selecciona 1 o varias guías
                                          │  operador confirma "Solicitar liberación"
                                          ▼
                              ATLAS registra la solicitud de liberación
                              (estado operativo: SOLICITADA_LIBERACION)
                                          │
                              ┌───────────┴───────────┐
                              ▼                       ▼
                  Dashboard de Tráfico          Mesa Operativa de Tráfico
                  mueve la tarjeta a            retira la guía del listado
                  "Solicitadas a Liberación"    accionable (ya no seleccionable)
                                          │
                                          ▼
                          (futuro) Facturación revisa la solicitud
                          desde su propio módulo — fuera de este documento
```

Puntos clave:

- La Mesa Operativa **no genera** la guía ni **la libera**: únicamente crea la solicitud.
- El paso de "generada" a "solicitada" ocurre una sola vez y es responsabilidad exclusiva de este módulo (el Dashboard nunca lo dispara, solo lo refleja).
- La acción es igual de válida sobre una guía o sobre un lote de guías seleccionadas.

---

## 5. Distribución de la pantalla

Layout de una sola columna, denso, sin scroll horizontal:

```
┌──────────────────────────────────────────────────────────────────────┐
│  MESA OPERATIVA DE TRÁFICO      🟢 Motor activo      142 disponibles │  ← Barra superior
├──────────────────────────────────────────────────────────────────────┤
│  Empresa ▾   Servicio ▾   Estado ▾        🔍 Buscar folio, cliente…  │  ← Filtros + búsqueda
├──────────────────────────────────────────────────────────────────────┤
│ ☐ │ PR       │ Cliente        │ Servicio │ Unidad  │ Fecha  │ Estado │
│ ☐ │ 100234   │ Cliente A      │ ...      │ ABC-123 │ 09:12  │ Generada│
│ ☑ │ 100233   │ Cliente B      │ ...      │ XYZ-987 │ 09:10  │ Generada│
│ ☑ │ 100231   │ Cliente C      │ ...      │ QWE-456 │ 09:05  │ Generada│
│   │ 100229   │ Cliente D      │ ...      │ RTY-321 │ 08:58  │ Solicitada (no seleccionable)│
│ …                                                                     │  ← Listado (tabla)
├──────────────────────────────────────────────────────────────────────┤
│  2 guías seleccionadas                    [Limpiar]  [Solicitar liberación] │  ← Barra de acciones (contextual)
└──────────────────────────────────────────────────────────────────────┘
```

La barra de acciones solo aparece cuando hay al menos una guía seleccionada; el resto del tiempo la tabla ocupa ese espacio.

---

## 6. Componentes principales

1. Barra superior.
2. Barra de filtros + búsqueda.
3. Listado (tabla) de guías.
4. Barra de acciones contextual.
5. Modal de confirmación de solicitud de liberación.

---

## 7. Barra superior

Contiene únicamente información de contexto, sin acciones:

- Nombre del módulo.
- Indicador "Motor activo" (mismo concepto de heartbeat ya usado en el Dashboard — ver `HeartbeatRepository`), para que el operador sepa si la detección de guías nuevas está funcionando antes de confiar en que el listado está completo.
- Contador de guías disponibles para acción (estado "Generada") en el listado actual.

No incluye selector de fecha: igual que el Dashboard, la Mesa Operativa opera únicamente sobre el día en curso (ver §13, regla 1).

---

## 8. Filtros

Filtros estructurados, combinables entre sí, aplicados sobre las guías del día:

| Filtro | Base | Nota |
|---|---|---|
| Empresa | `source` (`sicrePR` / `sicreGero`) | Mismo mapeo visual que el Dashboard (logo por empresa) |
| Servicio | `servicio` | Valores tal como llegan de SICRET |
| Estado | Generada / Solicitada a Liberación | Ver §11 — por defecto solo "Generada" |

No se agregan filtros por cliente, unidad o fecha específica en esta primera versión: la búsqueda de texto libre (§9) ya cubre cliente/unidad/folio, y la fecha no aplica porque el alcance es siempre "hoy".

---

## 9. Búsqueda

Campo de texto libre, una sola caja, sin sintaxis especial. Busca coincidencia parcial sobre:

- Folio / PR (`num_guia`)
- Cliente (`nombre`)
- Unidad (`placas1`)

La búsqueda y los filtros operan sobre el conjunto de guías del día ya cargado por el módulo (ver §14) — no requieren ida y vuelta al servidor por cada tecleo, dado que el volumen de un día es acotado. El origen de esos datos sigue siendo siempre la base de datos de ATLAS, nunca un caché propio del navegador entre sesiones.

---

## 10. Listado (tabla) de guías

Es una tabla, no tarjetas — a propósito, para maximizar la cantidad de guías visibles sin scroll y facilitar el barrido visual rápido.

Columnas (mismos campos ya validados para el Dashboard, ver `GuiaBoardRepository::findToday()`):

`☐ selección │ PR (num_guia) │ Cliente (nombre) │ Servicio │ Unidad (placas1) │ Fecha │ Empresa (source) │ Estado`

Reglas de presentación:

- Orden por defecto: más reciente primero (igual que el Dashboard, mismo criterio de consistencia).
- Cada fila indica su estado operativo con una etiqueta de texto, no con animaciones ni sonidos — este módulo prioriza lectura rápida sobre efecto visual (a diferencia del Dashboard).
- Las filas en estado "Solicitada a Liberación" se muestran atenuadas (visualmente secundarias) y sin casilla de selección — quedan visibles solo para que el operador confirme que su solicitud ya quedó registrada, sin necesidad de cambiar de pantalla.

---

## 11. Selección múltiple

- Solo las guías en estado **Generada** tienen casilla de selección habilitada.
- La selección es acumulativa entre operaciones de búsqueda/filtro: si el operador filtra, selecciona, y luego cambia el filtro, la selección previa se conserva mientras las guías sigan visibles en algún estado del listado (no se pierde por navegar entre filtros).
- No hay límite artificial de cuántas guías se pueden seleccionar a la vez.
- Si otra sesión solicita la liberación de una guía que el operador actual tiene seleccionada (concurrencia entre operadores), esa guía se retira automáticamente de la selección y de las accionables, con un aviso visible — nunca se envía una solicitud sobre una guía que ya fue solicitada por alguien más.

---

## 12. Barra de acciones

Aparece únicamente cuando hay 1 o más guías seleccionadas. Contiene:

- Contador: "N guías seleccionadas".
- Botón secundario: "Limpiar selección".
- Botón primario: "Solicitar liberación".

Al presionar "Solicitar liberación" se abre un modal de confirmación que lista los folios seleccionados antes de enviar — dado que la acción es irreversible desde este módulo (§13, regla 6), no se envía nada sin ese paso explícito.

---

## 13. Reglas de negocio

1. El módulo solo muestra guías del día en curso — misma regla que el Dashboard.
2. Solo pueden seleccionarse guías en estado **Generada**.
3. La solicitud de liberación puede aplicarse a una o varias guías a la vez (operación por lote).
4. Toda solicitud requiere confirmación explícita del operador antes de enviarse.
5. Al confirmarse, el backend registra la solicitud en ATLAS **antes** de notificar a cualquier sesión conectada (misma regla "backend = fuente de verdad" del Dashboard).
6. Una vez solicitada la liberación, la guía deja de ser accionable desde este módulo. No existe botón ni mecanismo para deshacer la solicitud aquí.
7. La Mesa Operativa nunca libera guías ni modifica ningún campo de la guía — su única escritura posible es "solicitar liberación".
8. Todas las sesiones de Mesa Operativa abiertas ven el mismo conjunto de guías disponibles; una guía solicitada por un operador deja de ser accionable para todos los demás de inmediato.
9. El módulo no permite editar, corregir ni completar información de la guía — si algo está mal, la corrección ocurre en SICRET, no aquí.
10. La responsabilidad de Tráfico termina al solicitar la liberación; cualquier decisión posterior (aceptar/rechazar) es exclusiva del futuro módulo de Facturación.

---

## 14. Estados que maneja el módulo

Este módulo reconoce únicamente dos estados operativos (los mismos ya definidos por el Dashboard, ver `docs/03-ui/01-dashboard-trafico.md`):

| Estado | ¿Accionable aquí? | Origen del cambio |
|---|---|---|
| Generada | Sí — seleccionable, sujeta a solicitud de liberación | Synchronization Engine (detección en `guias`) |
| Solicitada a Liberación | No — solo informativa | Acción del operador en este módulo |

No maneja el estado "Resultado del Timbrado" — ese estado es exclusivo del flujo Facturación/CFDIWatcher, fuera del alcance de este módulo y de este sprint.

Nota de arquitectura: el campo `estado` que hoy existe en la tabla `guias` de ATLAS es un valor crudo replicado de SICRET, no representa el estado operativo del tablero. Los dos estados de esta tabla son un concepto propio de ATLAS (igual que ya lo son, implícitamente, los tres paneles del Dashboard) y necesitarán su propia representación en la base de datos al momento de implementar — esa decisión de esquema no se toma en este documento de diseño.

---

## 15. Arquitectura funcional propuesta

Reutiliza sin cambios:

- La misma base de datos de ATLAS (tabla `guias`) — sin fuente de datos nueva ni duplicación.
- El mismo Synchronization Engine — la Mesa Operativa no detecta guías por sí misma, solo lee lo que el Engine ya insertó.
- El mismo canal WebSocket público (puerto 8098) usado por el Dashboard, para que el listado se mantenga sincronizado sin recarga: nuevas guías aparecen solas, y guías solicitadas por otras sesiones se retiran solas de lo accionable (§11).

Requiere, como pieza nueva (a diseñar en el sprint de implementación, no en este documento):

- Una capa de lectura para listar/filtrar/buscar guías del día, distinta de `GuiaBoardRepository` (que hoy solo alimenta las tarjetas del Dashboard) pero construida sobre la misma tabla — sin duplicar la definición de "guía del día".
- Un mecanismo de **escritura** para registrar la solicitud de liberación. Es la primera escritura de estado propio de ATLAS que no proviene de SICRET ni del filesystem, sino de una acción de un operador — hasta ahora ATLAS solo ha insertado lo que detecta, nunca ha registrado una decisión humana.
- El evento `guia.liberacion_solicitada`, ya nombrado en el diseño del Dashboard (`docs/03-ui/01-dashboard-trafico.md`, §7) pero nunca disparado en código real — la Mesa Operativa es quien lo emite por primera vez, reutilizando el mismo publicador interno (`SocketEventPublisher` → canal 8099 → `TrafficDashboard::broadcast()`) que ya usa el Synchronization Engine, sin inventar un canal nuevo.

El frontend de la Mesa Operativa sigue el mismo principio ya establecido para el Dashboard: no retira una fila del listado ni la marca como "solicitada" de forma optimista — espera la confirmación del backend antes de representar el cambio.

---

## 16. Interacción con el Dashboard de Tráfico

- No hay comunicación directa entre los dos módulos: ambos son clientes independientes de la misma base de datos de ATLAS y del mismo canal WebSocket.
- La acción "Solicitar liberación" en la Mesa Operativa es, en los hechos, la implementación real del evento `guia.liberacion_solicitada` que el Dashboard ya esperaba (por eso su panel "Solicitadas a Liberación" era, hasta ahora, un placeholder estático — no tenía quién le disparara ese evento).
- A partir de este módulo, el panel "Solicitadas a Liberación" del Dashboard pasa a ser funcional, sin requerir ningún cambio en el propio Dashboard.

---

## 17. Interacción futura con el módulo de Facturación

- El futuro módulo de Facturación será el consumidor de las solicitudes que aquí se generan: revisar, aceptar, rechazar y liberar realmente la guía.
- Lo único que este documento compromete hacia ese módulo es que la solicitud de liberación quede registrada en ATLAS de forma que sea consultable (qué guía, cuándo se solicitó) — el resto (usuarios, roles, permisos, rechazos, comentarios, historial, auditoría) se diseña en su propio sprint, según lo indicado explícitamente para esta fase.
- La Mesa Operativa no necesita saber nada del funcionamiento interno de Facturación ni esperar respuesta alguna de ese módulo: su responsabilidad termina en el registro de la solicitud.

---

## 18. Fuera de alcance de este documento

Confirmado explícitamente por el usuario como no incluido en este sprint de diseño:

Timbrado, CFDIWatcher, Mattermost, usuarios, roles, permisos, historial, auditoría, rechazos, comentarios. Ninguno de estos conceptos debe inferirse ni anticiparse en la implementación derivada de este documento.
