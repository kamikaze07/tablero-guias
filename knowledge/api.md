# API HTTP — ATLAS

## 1. Inventario completo (hoy)

ATLAS **no tiene un router** ni un framework de API — cada endpoint es un
script PHP independiente bajo `public/`, servido directamente por nginx
(`try_files $uri $uri/ /index.php?$query_string` para todo lo demás, pero
los archivos `.php` existentes se sirven directo por su propia ruta física).

| Método | Ruta | Script | Qué hace |
|---|---|---|---|
| GET | `/` o `/index.php` | `public/index.php` | Placeholder — `echo` de un string fijo, sin lógica |
| GET | `/trafico.php` | `public/trafico.php` | Entry point del Dashboard — HTML completo, no JSON |
| GET | `/api/heartbeat.php` | `public/api/heartbeat.php` | **Único endpoint JSON real del proyecto** |

No existe ningún endpoint de escritura, ningún endpoint relacionado a
guías individuales, filtros, ni, por supuesto, nada de liberación o
timbrado (ver `liberacion.md`).

## 2. `GET /api/heartbeat.php`

### Propósito
Informar si el Synchronization Engine está "vivo" — usado por el indicador
"Motor activo"/"Motor inactivo" del Dashboard (`refreshEngineStatus()` en
`trafico.js`, poll cada 5 segundos).

### Lógica
1. Conecta a la base `atlas` (vía `ConnectionFactory`, credenciales de
   `.env`).
2. Lee la fila más reciente de `sync_heartbeat` para el motor
   `'synchronization-engine'` (`HeartbeatRepository::latest()`).
3. Calcula `active = (ahora - last_cycle_at) <= 10 segundos`
   (`FRESHNESS_THRESHOLD_SECONDS`) — es decir, no basta con que el motor
   haya corrido alguna vez: debe haber completado un ciclo reciente. Dado
   que el intervalo de polling configurado es de 2s
   (`SYNC_POLLING_INTERVAL_SECONDS`), un motor sano siempre debería estar
   muy por debajo de ese umbral de 10s.

### Respuesta

```json
{
  "active": true,
  "status": "idle",
  "last_cycle_at": "2026-07-16 18:37:36"
}
```

- `active` (`boolean`): true si el último ciclo fue reciente.
- `status` (`string|null`): el valor crudo de `sync_heartbeat.status`
  (`"idle"` en operación normal, `"error"` si el último ciclo lanzó una
  excepción) — `null` si nunca hubo un ciclo registrado.
- `last_cycle_at` (`string|null`): timestamp del último ciclo, formato
  `Y-m-d H:i:s`, o `null` si nunca corrió.

### Notas
- No requiere ningún parámetro de entrada — siempre reporta el mismo
  motor (`ENGINE_NAME` está hardcodeado como constante en el propio
  script, igual que en `SynchronizationEngine::ENGINE_NAME` — **son dos
  constantes idénticas definidas por separado en dos archivos**, no una
  única fuente compartida; ver `improvement_notes.md`).
- Sin autenticación, sin rate limiting, sin caché HTTP explícito (aunque
  el cliente sí pide `cache: 'no-store'` al hacer el `fetch`).
- No expone `last_error` (aunque `HeartbeatRepository::latest()` sí lo
  trae de la base de datos) — el script simplemente no lo incluye en el
  `json_encode()` de salida. Sería un cambio trivial si se necesitara ver
  el error real desde el frontend en vez de solo "inactivo".

## 3. Ausencia de API de dominio (guías, liberación, timbrado)

No hay ningún endpoint para:
- Listar/filtrar/buscar guías (la única lectura de "guías del día" hoy es
  el `GuiaBoardRepository::findToday()` embebido directamente en el HTML
  de `trafico.php`, no expuesto como JSON reusable).
- Consultar el detalle de una guía puntual.
- Solicitar liberación de una o varias guías.
- Consultar el estado de una solicitud de liberación.
- Nada relacionado a timbrado/CFDI/Facturación.

Esto es coherente con el resto de esta base de conocimiento: la única
superficie de API que existe hoy es de **observabilidad** (heartbeat), no
de negocio. Cualquier integración con el Sistema de Guías requeriría
diseñar y construir esta capa desde cero (ver recomendación concreta en
`liberacion.md §4`).
