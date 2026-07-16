# Dashboard de Tráfico — Diseño Funcional

## 1. Alcance

Este documento define exclusivamente el **Dashboard de Tráfico**. Es el primer módulo funcional de ATLAS.

El Dashboard de Facturación es un módulo independiente, con su propio flujo operativo y su propia distribución de paneles — no forma parte de este documento. Ambos módulos comparten el mismo Synchronization Engine y la misma base de datos de ATLAS, pero no comparten pantalla, ni paneles, ni reglas de negocio.

---

## 2. Naturaleza de la aplicación

Es una **aplicación web interactiva**, no una pantalla pasiva tipo televisión.

- Cada usuario de Tráfico la abre desde su propia computadora.
- Todas las sesiones abiertas ven exactamente el mismo tablero, sincronizado en tiempo real vía WebSockets (Ratchet).
- Si un usuario provoca un movimiento de tarjeta (por ejemplo, solicitar liberación), ese cambio se refleja de inmediato en todas las demás sesiones conectadas — no solo en la sesión que lo originó.

---

## 3. Distribución de la pantalla

Tablero de 3 columnas fijas, visibles simultáneamente sin scroll horizontal:

```
┌─────────────────────┬─────────────────────┬─────────────────────┐
│  GUÍAS GENERADAS     │ SOLICITADAS A        │ RESULTADO DEL         │
│                      │ LIBERACIÓN           │ TIMBRADO               │
│  [tarjeta] (nueva)   │  [tarjeta]           │  [tarjeta] 🟢          │
│  [tarjeta]           │  [tarjeta]           │  [tarjeta] 🔴          │
│  [tarjeta]           │                      │  [tarjeta] 🟢          │
│  ...                 │  ...                 │  ...                   │
└─────────────────────┴─────────────────────┴─────────────────────┘
```

Cada columna se desplaza verticalmente de forma independiente si el número de tarjetas excede el alto de pantalla. El encabezado de cada columna muestra el nombre del panel y un contador de tarjetas activas.

---

## 4. Orden y animación de tarjetas

- Las tarjetas se muestran con **la más reciente arriba**.
- Cuando llega una guía nueva, se inserta **al inicio** del panel correspondiente con una animación suave que llame la atención del operador.
- El resto de las tarjetas del panel **no se reordena** al insertar una nueva — cada tarjeta conserva su posición relativa una vez insertada.

---

## 5. Comportamiento de cada panel

### 5.1 Guías Generadas
- Alimentado exclusivamente por la detección automática de guías nuevas en la tabla `guias` (vía el Synchronization Engine).
- Panel de solo llegada: las tarjetas aparecen aquí y salen únicamente cuando el usuario las selecciona y solicita liberación.
- No existe ninguna otra forma de que una tarjeta salga de este panel.

### 5.2 Solicitadas a Liberación
- Alimentado únicamente por la acción del usuario: seleccionar una o varias tarjetas del panel 1 y confirmar la solicitud de liberación (operación por lote).
- Panel de estado intermedio/tránsito: las tarjetas permanecen aquí mientras se espera el resultado del timbrado.
- Salen automáticamente cuando el CFDIWatcher reporta un resultado.
- No existe mecanismo para regresar manualmente una tarjeta de este panel al panel anterior (ver sección 8).

### 5.3 Resultado del Timbrado
- Panel único — no se divide en éxito y error como paneles separados.
- Alimentado únicamente por eventos del CFDIWatcher (monitoreo de sistema de archivos), nunca por acción directa del usuario.
- Cada tarjeta indica visualmente su resultado:
  - 🟢 **Timbrado correcto** — CFDIWatcher detectó XML y PDF generados correctamente.
  - 🔴 **Error de timbrado** — CFDIWatcher detectó un YAML en la carpeta de error.
- Es el panel terminal del flujo dentro de este dashboard: no se definen movimientos de salida hacia otro panel del mismo tablero.
- Los errores mostrados aquí son **únicamente informativos**. No existe botón de reintentar — el reintento pertenece al proceso de Facturación y/o al propio SICRET, fuera del alcance de este dashboard.

---

## 6. Flujo de movimiento de las tarjetas (ciclo de vida)

```
[Detección en tabla "guias"]
          │
          ▼
   GUÍAS GENERADAS
          │  (usuario selecciona 1+ tarjetas y solicita liberación)
          ▼
 SOLICITADAS A LIBERACIÓN                 ← sin retorno posible
          │  (CFDIWatcher detecta resultado en sistema de archivos)
          ▼
  RESULTADO DEL TIMBRADO
          │
          ├── 🟢 Timbrado correcto
          └── 🔴 Error de timbrado
```

Una tarjeta pertenece a exactamente un panel a la vez. El movimiento es una transición de estado, no una copia: la tarjeta desaparece de su panel de origen en el mismo instante en que aparece en el destino.

---

## 7. Eventos que producen los movimientos

| Evento | Origen | Efecto |
|---|---|---|
| `guia.detectada` | Monitoreo de la tabla `guias` (Synchronization Engine) | Inserta la tarjeta al inicio de **Guías Generadas** |
| `guia.liberacion_solicitada` | Acción del usuario en el dashboard (selección + confirmación) | Mueve la(s) tarjeta(s) de **Guías Generadas** → **Solicitadas a Liberación** |
| `timbrado.exitoso` | CFDIWatcher detecta XML + PDF en carpeta de éxito | Mueve la tarjeta de **Solicitadas a Liberación** → **Resultado del Timbrado** (🟢) |
| `timbrado.error` | CFDIWatcher detecta YAML en carpeta de error | Mueve la tarjeta de **Solicitadas a Liberación** → **Resultado del Timbrado** (🔴) |

Todos los eventos se distribuyen a las sesiones conectadas vía WebSocket en cuanto se detectan — ningún movimiento depende de que el usuario recargue o consulte manualmente.

---

## 8. Reversión

No existe regreso manual entre paneles.

Una vez que Tráfico solicita la liberación de una guía, su tarjeta no puede regresar al panel de Guías Generadas.

Si en el futuro se requiere un flujo de cancelación, será un flujo de negocio distinto y explícito — nunca una reversión implícita del movimiento del tablero.

---

## 9. Persistencia y fuente de verdad

- Las tarjetas **no viven únicamente en memoria** del backend ni del navegador.
- Cada movimiento de una tarjeta entre paneles se registra en la base de datos propia de ATLAS.
- Los WebSockets **únicamente notifican** el cambio a las sesiones conectadas; no son el lugar donde el cambio "ocurre".
- La fuente de verdad del estado del tablero es siempre la base de datos de ATLAS. Si una sesión se reconecta o se abre de nuevo, su estado inicial debe reconstruirse a partir de esa base de datos, no de eventos pasados de WebSocket.

---

## 10. Sincronización — responsabilidad backend/frontend

- El frontend **no toma decisiones**. Es exclusivamente una representación visual del estado.
- Toda transición entre paneles se origina siempre por un evento confirmado por el backend (es decir, ya persistido en la base de datos de ATLAS antes de notificarse).
- El frontend nunca mueve una tarjeta de forma optimista ni infiere transiciones por sí mismo; solo reacciona a lo que el backend confirma.

Resumen: **Frontend = representación. Backend = estado del tablero.**

---

## 11. Cambio de día

El tablero siempre representa la operación del día en curso.

- Al cambiar la fecha, las tarjetas del día anterior desaparecen automáticamente del tablero operativo, sin importar en qué panel estuvieran o su estatus.
- Esas tarjetas **no se eliminan del sistema** — simplemente dejan de formar parte del tablero del día.
- La consulta de guías de días anteriores corresponde a un módulo de histórico completamente independiente, fuera del alcance de este dashboard.

---

## 12. Reglas de negocio del Dashboard

1. El tablero solo muestra guías del día en curso.
2. Ninguna actualización requiere recarga de página (F5) — toda sincronización ocurre por WebSocket.
3. La información se representa siempre como tarjetas (cards); ninguna vista usa tablas HTML.
4. Cada tarjeta muestra únicamente los campos indispensables para Tráfico (los campos concretos se definen en un documento posterior).
5. La solicitud de liberación puede aplicarse a una o varias tarjetas seleccionadas a la vez.
6. No existe reversión manual de una transición ya ocurrida.
7. Los errores de timbrado son informativos; el reintento no pertenece a este dashboard.
8. Una tarjeta nunca aparece simultáneamente en dos paneles.
9. Tráfico solo puede accionar la transición panel 1 → panel 2; las transiciones hacia el panel 3 son exclusivamente automáticas.
10. El backend es la única autoridad sobre el estado del tablero; el frontend únicamente representa lo que el backend confirma.
11. Todo movimiento de tarjeta se persiste en la base de datos de ATLAS antes de notificarse por WebSocket.
12. Todas las sesiones de usuarios de Tráfico ven el mismo tablero sincronizado — no hay vistas individuales divergentes.

---

## 13. Relación con módulos futuros

Este Dashboard pertenece exclusivamente al módulo de **Tráfico**.

El **Dashboard de Facturación** será un módulo independiente, con otro flujo operativo y otra distribución de paneles. Ambos módulos compartirán el mismo Synchronization Engine y la misma base de datos de ATLAS, pero no comparten paneles, tarjetas, ni reglas de negocio entre sí.
