# Historial completo de Facturación y descarga del Complemento Carta Porte (jul 2026)

> Sprint: "Historial completo de Facturación y descarga del Complemento
> Carta Porte". Continuación del sprint anterior
> (`2026-07-sync-kpi-historial.md`).

## 1. Resumen ejecutivo

Dos entregables:

1. **Historial completo del panel de Facturación** — pestaña nueva
   ("Historial completo") que muestra todo lo resuelto (aprobado,
   rechazado, timbrado) sin límite de fecha, separada del trabajo
   pendiente en vivo.
2. **Descarga del Complemento Carta Porte** — el usuario aclaró en este
   sprint que el archivo a descargar es el **PDF**, no el XML (el texto
   original del sprint decía XML; se confirmó con el usuario y se
   construyó para PDF).

> **Corrección de ubicación (misma sesión, después del punto 6):** el
> botón visible para el usuario final se pidió en el módulo de Guías de
> **trafico-system** (`/home/servidor/trafico-system`), un repositorio y
> despliegue completamente distintos, no en el panel de Facturación de
> ATLAS. El endpoint `public/api/timbrado-carta-porte.php` descrito abajo
> sigue siendo la pieza real que sirve el archivo — trafico-system lo
> consume vía un `AtlasClient::descargarCartaPorte()` nuevo, mismo patrón
> que ya usa esa integración para todo lo demás. El botón agregado en la
> pestaña "Historial completo" de ATLAS (§6) también quedó, es útil para
> quien trabaje directamente en ATLAS, pero **no** es el que el usuario
> pidió resolver. Detalle completo en
> `/home/servidor/trafico-system/knowledge/descarga-carta-porte-guias.md`
> (no se duplica aquí por vivir en otro repositorio).

Durante la investigación se encontraron y corrigieron dos problemas de
infraestructura, no solo de UI, que bloqueaban ambos entregables:

- La carpeta OUT real de SICRET (`/home/servidor/mercurio/data/out`,
  mismo servidor que ATLAS) **nunca estuvo montada** en producción — el
  `.env` real no tenía `SICRET_TIMBRADO_OUT_HOST_PATH`, así que
  `App\Monitoring\Timbrado\StampingEvidenceSource` miraba una carpeta
  local vacía. Esto significa que **ninguna solicitud de Timbrado se
  había confirmado nunca** en producción — se quedaban atascadas en
  `ESPERANDO_TIMBRADO` para siempre, aunque el timbrado ya hubiera
  ocurrido realmente en SICRET.
- `guias.factimpresa` de ATLAS (columna local, sincronizada por
  `App\Sync\GuiaRepository::insert()`, que es INSERT-only) queda vacía
  para casi cualquier guía que pase por el flujo normal de ATLAS, porque
  la guía se sincroniza ANTES de timbrarse — su copia local nunca se
  actualiza después. Usar esa columna para decidir si mostrar el botón de
  descarga habría escondido el botón en prácticamente todos los casos
  reales.

## 2. Corrección: carpeta OUT real conectada

- `.env`: se agregó `SICRET_TIMBRADO_OUT_HOST_PATH=/home/servidor/mercurio/data/out`
  (antes ausente → `docker-compose.yml` caía a su default,
  `./storage/timbrado-out`, una carpeta local vacía).
- `docker-compose.yml`: el mismo bind-mount de solo lectura que ya tenía
  `monitoring` se agregó también a `php` (necesario para que el nuevo
  endpoint de descarga, que corre bajo php-fpm, pueda leer los PDF).
- Verificado en vivo: al reiniciar `monitoring` con la ruta correcta,
  **las 5 solicitudes de Timbrado que llevaban atascadas en
  `ESPERANDO_TIMBRADO` confirmaron inmediatamente** (log:
  `TimbradoConfirmationWatcher: solicitud timbrada`, 2026-07-24 10:21).
  Antes: 0 solicitudes en estado `TIMBRADO` en toda la base. Después: 5
  (17 guías).

**Nota operativa:** este cambio recreó los contenedores `php` y
`monitoring`, lo que dejó a `nginx` apuntando brevemente (~4 min) a una
IP de contenedor obsoleta — causó una interrupción real (502) mientras
había tráfico de producción activo (`192.168.1.209` consultando
`/trafico.php` en vivo). Se corrigió reiniciando `nginx` para que
resolviera de nuevo el hostname `php`. **Lección para el futuro**: tras
recrear cualquier contenedor detrás de `nginx` en este proyecto, reiniciar
`nginx` inmediatamente después — no asumir que el DNS interno de Docker
se refresca solo.

## 3. Corrección: `factura_impresa` persistido por guía, no leído de la copia local

- `database/schema.sql` / ALTER en vivo: `solicitud_timbrado_detalle` gana
  la columna `factura_impresa VARCHAR(20) NULL`.
- `App\Timbrado\SolicitudTimbradoDetalleRepository::marcarFacturaImpresa()`
  (nuevo): persiste el valor por guía.
- `App\Monitoring\Timbrado\TimbradoConfirmationWatcher::alConfirmar()`:
  ahora llama a `marcarFacturaImpresa()` con el mismo dato que la
  evidencia ya trajo de SICRET (`StampingEvidenceSource`) — sin
  consultas adicionales.
- Backfill manual de las 5 solicitudes que confirmaron *antes* de que
  existiera la columna (consultado en vivo contra SICRET, verificado
  contra el archivo real en disco antes de escribir cada valor — ver
  §5 para la evidencia).
- `App\Timbrado\SolicitudTimbradoRepository::listarConDetalleGuia()`
  ahora expone `factura_impresa` — así el historial ya sabe, sin
  consultas adicionales, si debe mostrar el botón de descarga.

## 4. Endpoint de descarga

`public/api/timbrado-carta-porte.php` (`GET ?guia=<num_guia>`):

1. Resuelve `factura_impresa` **en el servidor**, nunca confía en un
   valor mandado por el cliente (`SolicitudTimbradoDetalleRepository::facturaImpresaConfirmadaPorNumGuia()`,
   toma la solicitud `TIMBRADO` más reciente del folio).
2. Si no hay timbrado confirmado → 404 `sin_carta_porte`, "La guía aún no
   cuenta con un Complemento Carta Porte timbrado."
3. Valida que `factura_impresa` sea alfanumérico antes de construir la
   ruta (defensa en profundidad, aunque el valor viene de la BD).
4. Si el PDF no existe en la carpeta OUT → 404 `archivo_no_encontrado`.
5. Si existe → lo transmite con `Content-Type: application/pdf` y
   `Content-Disposition: attachment`.

## 5. Evidencia — descarga real desde el navegador

Prueba automatizada con Playwright (clic real en el botón "Descargar" de
la pestaña Historial, no una llamada directa al endpoint):

```
Guía: PR-220163 → factura_impresa: PR04526
Archivo descargado por el navegador: PR-220163-carta-porte.pdf
cmp contra /home/servidor/mercurio/data/out/PR04526.pdf → IDÉNTICO byte a byte
```

Mismo resultado por curl directo contra el endpoint para PR-220156
(factura_impresa `PR04519`, 313708 bytes) — idéntico byte a byte al
archivo real. Casos de error verificados contra datos reales:

- Folio sin timbrado confirmado (`PR-225965`, solicitud pendiente real)
  → `{"error":"sin_carta_porte", ...}`.
- Folio inexistente / parámetro vacío → mensajes de error correspondientes.

## 6. Evidencia — historial completo visible en el panel

Capturas de pantalla (Playwright) de `/facturacion.php`:

- Pestaña "Trabajo pendiente": sin cambios de comportamiento respecto al
  sprint anterior.
- Pestaña "Historial completo": tabla de Timbrado (23 filas, sin filtro
  de fecha) y de Liberación (10 filas) mostrando datos del **21, 22 y 23
  de julio** simultáneamente — incluye timbrados, rechazos y liberaciones
  completadas de distintos días, cada fila con su botón "Descargar"
  cuando corresponde y "—" cuando no hay Complemento Carta Porte
  confirmado (p. ej. solicitudes rechazadas).

Endpoints detrás de la pestaña (`facturacion-solicitudes.php`,
`facturacion-solicitudes-timbrado.php`) no tienen ningún filtro de fecha
implícito — el default de la pestaña es `estado=""` (todos los estados),
a diferencia de "Trabajo pendiente" que sigue defaulteando a `PENDIENTE`
por diseño (esa es la cola de trabajo en vivo, no el historial).

## 7. Alcance no cubierto en este sprint

- El backfill de `factura_impresa` para las 5 solicitudes ya confirmadas
  antes del fix fue manual (consulta en vivo puntual). Cualquier
  solicitud `TIMBRADO` futura ya queda cubierta automáticamente por
  `TimbradoConfirmationWatcher`.
- Guías timbradas hace mucho tiempo, fuera de `solicitud_timbrado`
  (nunca pasaron por el flujo de ATLAS), no tienen forma de resolver su
  `factura_impresa` con este mecanismo — quedan fuera del botón de
  descarga. No se pidió en este sprint; si se necesita, requeriría un
  camino de resolución adicional (probablemente consulta en vivo a
  SICRET, con el costo de performance que eso implica para listas
  grandes).
