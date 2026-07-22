# Especificación Funcional — Proceso de Liberación en SICRET (legado)

> **Naturaleza de este documento**: ingeniería inversa exhaustiva del código
> fuente legado de SICRET (`knowledge/legacy/sicret/`, aplicación de
> escritorio Java Swing, NO web — no hay HTML/JS/AJAX en este flujo). No es
> un documento de diseño de ATLAS: describe **exactamente** lo que el
> código legado hace hoy, línea por línea, sin proponer cambios ni mejoras.
> Es el contrato funcional de referencia para implementar, en su momento,
> `App\Infrastructure\Sicret\SicretGateway::liberar()`,
> `App\Liberacion\Execution\LiberacionExecutor` y
> `App\Monitoring\Liberacion\LiberationConfirmationWatcher` — sin alterar
> el comportamiento del sistema legado.
>
> Complementa (no sustituye) los documentos de diseño de ATLAS ya
> existentes en esta carpeta (`overview.md`, `workflow.md`,
> `database-design.md`, etc.) y en `knowledge/liberacion.md`, que describen
> el lado ATLAS (aún no construido) de la integración.

## 0. Hallazgo previo — alcance real de "Liberación" en SICRET

Se buscó la palabra "liberar/liberación" (insensible a mayúsculas) en los
**5,470 archivos `.java`** de todo el dump de SICRET
(`grep -rlI -i "liberar\|liberacion" .`). El resultado es **un único
archivo**: `ModificarGuias.java`. No existe ningún otro botón, menú,
clase, procedimiento almacenado ni trigger relacionado con "liberación" en
todo el sistema legado.

Esto significa que, en SICRET, "Liberar una guía" **no es un flujo de
aprobación multi-etapa** (a diferencia de lo que ATLAS está construyendo
con `solicitud_liberacion`). Es una **única operación reversora**: toma una
guía que ya tiene una factura/CFDI asociada (`guias.factImpresa` no vacío,
`guias.estatus` en algún estado de facturación) y la regresa al estado
`<Por Timbrar>`, quitándole la referencia de factura. Es, en esencia, un
"deshacer facturación", no un "autorizar guía".

También se confirmó, mediante `Consultas.java` (la única clase de acceso a
datos usada por este flujo), que **SICRET no usa transacciones, ni
procedimientos almacenados, ni triggers, ni genera eventos** — cada
sentencia SQL abre su propia conexión JDBC cruda (`DriverManager.getConnection`),
la ejecuta y la cierra. Esto es consistente con la restricción ya conocida
de ATLAS: *"SICRET no genera eventos"* y *"toda confirmación... deberá
realizarse mediante monitoreo de la base de datos"* (`CLAUDE.md`).

---

## ENTREGA 1 — Punto exacto donde comienza el proceso

El proceso tiene **dos puntos de entrada a la pantalla** contenedora y
**un único disparador real** de la operación de liberar (más una vía
secundaria no obvia, ver §2.4).

### 1.1 Acceso a la pantalla "Consultar Guías"

| Elemento | Archivo | Detalle |
|---|---|---|
| Menú "Guías" | `Principal.java:6287` | `this.jMenuItem3.setText("Guías")`, listener en `Principal.java:6819` (`jMenuItem3ActionPerformed`) → llama `modificarGuias()` |
| Ícono de escritorio | `Principal.java:5447-5450` | `jLabel49`, ícono `/entrada/Imagenes/guia.png`, tooltip **"Gestionar las guías"**, listener `jLabel49MouseClicked` (`Principal.java:7815`) → si `jLabel49.isEnabled()`, llama `modificarGuias()` |
| Método que abre la pantalla | `Principal.java:10339` (`public void modificarGuias()`) | Si `existenDatos()` es verdadero: crea (primera vez) o reutiliza `this.guiasM = new ModificarGuias(...)` y agrega la pestaña `"Consultar Guías"` a `jTabbedPane2` |

Ambos accesos (menú e ícono) están controlados por
`Principal.privilegios(String depa)` (`Principal.java:11268`), que
habilita/deshabilita `jMenuItem3` y `jLabel49` según el departamento del
usuario autenticado — es una capa de control de acceso al **módulo**, no
al botón de liberar en sí.

### 1.2 Disparador real: botón "Liberar"

| Elemento | Archivo:línea | Detalle |
|---|---|---|
| Botón físico | `ModificarGuias.java:3551-3554` | `jButton26`, ícono `/entrada/Imagenes/botones/exchange.png`, texto **"Liberar"**, mnemonic `'L'`, tooltip **"Liberar (Alt+L)"** |
| Listener | `ModificarGuias.java:3555-3557` | `ActionListener` anónimo → `jButton26ActionPerformed(evt)` |
| Handler | `ModificarGuias.java:6928-6936` (`jButton26ActionPerformed`) | Verifica que haya una fila seleccionada en la tabla (`rSTableMetro1.getSelectedRow() >= 0`); si sí, llama a `liberarGuia()`; si no, `JOptionPane.showMessageDialog(..., "Selecciona una guía para poder LIBERAR los datos", "Selecciona una Guía", ...)` |
| Método de negocio | `ModificarGuias.java:7033-7050` (`public void liberarGuia()`) | **Aquí está toda la lógica real del proceso** (ver Entrega 2 y 3) |

No existe formulario HTML, AJAX, ni endpoint HTTP — el "clic" es un
`ActionEvent` de Swing sobre un `JButton` dentro de una aplicación de
escritorio con conexión JDBC directa al MySQL/MariaDB de SICRET.

---

## ENTREGA 2 — Árbol completo del flujo de ejecución

```
Usuario (operador con sesión en SICRET)
 │
 ├─ Menú "Guías" (jMenuItem3)  ── o ──  Ícono "Gestionar las guías" (jLabel49)
 │        Principal.java:6819              Principal.java:7815
 │
 ▼
Principal.modificarGuias()                         Principal.java:10339
 │  (valida existenDatos(); abre/reutiliza panel)
 ▼
new ModificarGuias(...) → pestaña "Consultar Guías" Principal.java:10345
 │  Constructor ModificarGuias(...)                 ModificarGuias.java:186
 │   ├─ privilegios()  [DEPARTAMENTO aún vacío ""]   ModificarGuias.java:345,7707
 │   ├─ sacarDepa()    [carga DEPARTAMENTO real]     ModificarGuias.java:346,7418
 │   └─ consultar()    [SELECT inicial → tabla]      ModificarGuias.java:374,8249
 ▼
Usuario hace clic en una fila de rSTableMetro1
 │  rSTableMetro1MouseClicked(evt)                   ModificarGuias.java:5153
 │   ├─ privilegios()  [re-evalúa con DEPARTAMENTO ya cargado]
 │   └─ si jComboBox8.selectedIndex==0 ("ACTIVA") y
 │      DEPARTAMENTO ∈ {SUPER USUARIO, JEFE DE TRÁFICO, TRÁFICO,
 │      GERENTE DE OPERACIONES, LIQUIDACIONES}
 │        → jButton26 ("Liberar") queda habilitado    ModificarGuias.java:5165-5196
 ▼
Usuario hace clic en botón "Liberar" (Alt+L)
 │  jButton26ActionPerformed(evt)                    ModificarGuias.java:6928
 │   └─ reg = fila seleccionada
 │        si reg < 0 → JOptionPane aviso, FIN
 │        si reg >= 0 → liberarGuia()
 ▼
liberarGuia()                                        ModificarGuias.java:7033
 │
 ├─ JOptionPane.showConfirmDialog(...)  "¡¡¡ADVERTENCIA!!!..." (Sí/No)
 │       res = respuesta del usuario
 │
 ├─ si res != 0 (No / cerrar el diálogo) → FIN, sin cambios
 │
 └─ si res == 0 (Sí):
       │
       ├─ fact = "CFDI ANTERIOR: " + valor columna [colCount-3] ("Factura" = guias.factImpresa)
       ├─ descripcion = valor columna [colCount-5] ("Rep Interno" = guias.factura)
       │
       ├─ UPDATE #1  Consultas.inserSinMsj(...)      ModificarGuias.java:7046
       │     update llamadas_historicas
       │        set descrip = '<descripcion> \n\n <fact>'
       │      where num_guia = '<folio de la guía>'
       │     (abre conexión JDBC nueva, ejecuta, cierra — sin transacción)
       │
       ├─ UPDATE #2  Consultas.inserSinMsj(...)      ModificarGuias.java:7047
       │     update guias
       │        set estatus = '<Por Timbrar>', factImpresa = ''
       │      where num_guia = '<folio de la guía>'
       │     (conexión JDBC independiente de la anterior — sin transacción,
       │      sin rollback si esta falla después de que la anterior tuvo éxito)
       │
       └─ consultar()                                ModificarGuias.java:7048,8249
             → vuelve a ejecutar el SELECT general (ver Entrega 4, SQL-1)
             → refresca rSTableMetro1 con el estado ya actualizado
             FIN
```

**No hay** llamadas a `bitacora()`, a envío de correo (`EnviarCorreo`), a
generación de PDF (`CrearPDF`), a impresión, ni a ningún procedimiento
almacenado (`CALL`) en ningún punto de esta rama. `Consultas.java` no
implementa transacciones (`Connection.setAutoCommit` nunca se toca — el
driver JDBC trabaja en autocommit por defecto), así que cada `UPDATE` es
atómico **por sí mismo**, pero el par de `UPDATE`s **no lo es como
conjunto**.

---

## ENTREGA 3 — Explicación paso a paso

### Paso 1 — `jButton26ActionPerformed` (`ModificarGuias.java:6928-6936`)

- **Qué hace**: valida que exista una fila seleccionada en la tabla de
  guías (`rSTableMetro1`).
- **Por qué existe**: es la guarda mínima de UI — no tiene sentido invocar
  `liberarGuia()` sin saber sobre qué guía operar.
- **Parámetros**: `ActionEvent evt` (no usado más que para disparar el
  método; no se lee ningún dato del evento).
- **Devuelve**: `void`.
- **Condición que valida**: `this.rSTableMetro1.getSelectedRow() >= 0`.
- **Decisión**: si no hay selección, muestra
  `JOptionPane.showMessageDialog(this.padre, "Selecciona una guía para poder LIBERAR los datos", "Selecciona una Guía", 0, this.ADVER)`
  y no llama a nada más. Si hay selección, llama a `liberarGuia()`.

### Paso 2 — `liberarGuia()` (`ModificarGuias.java:7033-7050`)

- **Qué hace**: es el método de negocio completo. Muestra una advertencia,
  y si el usuario confirma, revierte el estatus de facturación de la guía
  seleccionada y dispara una nueva consulta para refrescar la tabla.
- **Por qué existe**: es la única forma, en todo SICRET, de deshacer una
  facturación ya aplicada a una guía y devolverla al flujo normal (`<Por
  Timbrar>`), preservando un rastro textual de la factura anterior dentro
  de la bitácora libre de la llamada (`llamadas_historicas.descrip`).
- **Parámetros**: ninguno explícito — opera sobre el estado interno del
  objeto (`this.rSTableMetro1`, fila actualmente seleccionada,
  `this.con`).
- **Devuelve**: `void`.
- **Condiciones que valida**: únicamente la respuesta del usuario al
  diálogo de confirmación (`res == 0` ⇒ botón "Sí"). **No valida el
  estatus actual de la guía** antes de proceder — no verifica que la guía
  tenga efectivamente una factura asociada, ni que su estatus actual sea
  compatible con "liberar". Cualquier fila seleccionada, en cualquier
  estatus, puede ser "liberada".
- **Decisiones que toma**:
  - Si el usuario confirma (`res == 0`): ejecuta las dos actualizaciones
    (ver Paso 3 y 4) y refresca la tabla.
  - Si el usuario cancela o cierra el diálogo (`res != 0`): no hace
    absolutamente nada — ni una sola sentencia SQL se ejecuta.
- **Texto exacto del diálogo de confirmación** (HTML embebido en el
  `JOptionPane`):

  > *"¡¡¡ A D V E R T E N C I A !!! — Al **LIBERAR** la guía; se le
  > quitará la factura y el estatus volverá al original **POR
  > TIMBRAR**, los datos originales quedarán registrados en las
  > observaciones. ¿Deseas seguir con la modificación?"*
  >
  > Título del diálogo: *"Liberando la guia..."* — tipo `YES_NO_OPTION`
  > (`optionType=0`), ícono personalizado `ADVER` (`Warning.png`).

- **Llamadas posteriores**: `Consultas.inserSinMsj()` (×2) y
  `consultar()` (×1). Ninguna otra.

### Paso 3 — Construcción de los valores a escribir

- **`fact`** (`ModificarGuias.java:7044`): se arma como el literal
  `"CFDI ANTERIOR: "` concatenado con el valor de la celda en la columna
  `rSTableMetro1.getColumnCount() - 3` de la fila seleccionada. Según el
  orden exacto de columnas devuelto por el `SELECT` de `consultar()`
  (ver Entrega 4, SQL-1 — 27 columnas, índices 0 a 26), esa columna es la
  etiquetada **"Factura"**, respaldada por `guias.factImpresa` — es decir,
  el folio/CFDI de la factura que se está a punto de quitar.

- **`descripcion`** (`ModificarGuias.java:7045`): se toma del valor de la
  celda en la columna `rSTableMetro1.getColumnCount() - 5`. Con el mismo
  mapeo de columnas, ese índice corresponde a la columna etiquetada **"Rep
  Interno"**, respaldada por `guias.factura` (**no** por
  `llamadas_historicas.descrip`, que es la columna "Descripción o
  Comentario", dos posiciones antes en el mismo arreglo).

  > ⚠️ **Detalle no obvio, verificado por conteo exacto de columnas**: la
  > variable local se llama `descripcion`, pero su contenido real es el
  > valor del campo **"Rep Interno" (`guias.factura`)**, no el de la
  > columna "Descripción o Comentario" (`llamadas_historicas.descrip`,
  > índice `colCount-7`). Este dato se documenta tal cual el código lo
  > hace — ver Entrega 6 para el efecto que esto produce sobre
  > `llamadas_historicas.descrip`.

### Paso 4 — `UPDATE` 1: histórico de la llamada (`ModificarGuias.java:7046`)

```sql
update llamadas_historicas
   set descrip = '<descripcion> \n\n <fact>'
 where num_guia = '<folio de la guía seleccionada>'
```

- **Qué hace**: sobrescribe por completo el campo `descrip` de
  `llamadas_historicas` (identificado por `num_guia`, una columna
  denormalizada de esa tabla — el join normal en `consultar()` usa
  `num_llama`, pero este `UPDATE` filtra directamente por `num_guia`).
- **Por qué existe**: es el mecanismo que el mensaje de confirmación
  promete ("los datos originales quedarán registrados en las
  observaciones") — deja constancia de qué factura tenía la guía antes de
  liberarla.
- **Efecto real** (ver ⚠️ del Paso 3): el contenido anterior de `descrip`
  se **pierde** — no se concatena al texto previo, se reemplaza
  íntegramente por `"<valor de guias.factura> \n\n CFDI ANTERIOR: <valor
  anterior de guias.factImpresa>"`.

### Paso 5 — `UPDATE` 2: reversión del estatus de la guía (`ModificarGuias.java:7047`)

```sql
update guias
   set estatus = '<Por Timbrar>', factImpresa = ''
 where num_guia = '<folio de la guía seleccionada>'
```

- **Qué hace**: fija el estatus de la guía al literal exacto
  `<Por Timbrar>` (con los signos `<` `>` incluidos — así se almacenan
  todos los estatus en SICRET, ver Entrega 5) y vacía `factImpresa`.
- **Por qué existe**: es el efecto central de "liberar" — la guía deja de
  estar asociada a ninguna factura y vuelve a estar disponible para ser
  facturada/timbrada de nuevo desde cero.
- **No toca**: `guias.factura` ("Rep Interno"), `guias.prefactura`,
  `guias.DO`, `guias.LID`, ni ninguna otra columna de `guias` — solo
  `estatus` y `factImpresa`.

### Paso 6 — Refresco de pantalla (`ModificarGuias.java:7048` → `consultar()` en `8249`)

- **Qué hace**: vuelve a ejecutar el `SELECT` general de la pantalla (ver
  Entrega 4, SQL-1) y repuebla `rSTableMetro1`.
- **Por qué existe**: es la única manera en que el operador ve reflejado
  el cambio — SICRET no tiene actualización reactiva ni eventos, todo el
  refresco de UI es "volver a consultar".
- **Efecto secundario relevante**: como `consultar()` es un método pesado
  (`ModificarGuias.java:8249-8420+`) que también reconstruye filtros,
  reordena, etc., cualquier selección de fila se pierde tras liberar — el
  operador debe volver a hacer clic en una fila para que `jButton26` vuelva
  a habilitarse (ver Entrega 5, regla de habilitación de UI).

---

## ENTREGA 4 — Catálogo de consultas SQL involucradas

| # | Archivo:línea | Tipo | Tablas | Columnas / condición | Propósito | Impacto |
|---|---|---|---|---|---|---|
| SQL-1 | `ModificarGuias.java:8408` (`consultar()`) | `SELECT` | `tracto, remolque, guias, llamadas_historicas, emp_generadora, emp_destinataria, vales` (join múltiple) | 27 columnas (`guias.num_guia`…`LID`, ver Entrega 3 Paso 3); `WHERE` con múltiples `LIKE '%...%'` sobre filtros de UI (folio, residuo, origen, destino, estado, tipo, operador, tractor, remolques, ciudad, fechas, servicio, `estatus`, cliente, `DO`, `LID`) y `ORDER BY guias.num desc` | Poblar la tabla `rSTableMetro1` (listado de guías) al abrir la pantalla y tras cada refresco | Solo lectura — define qué columna cae en qué índice, crítico para interpretar `liberarGuia()` (Entrega 3) |
| SQL-2 | `ModificarGuias.java:7046` | `UPDATE` | `llamadas_historicas` | `SET descrip = '<...>' WHERE num_guia = '<folio>'` | Registrar (sobrescribiendo) un rastro textual de la factura que se está quitando | Escritura — ver Paso 4 y advertencia sobre pérdida del `descrip` anterior |
| SQL-3 | `ModificarGuias.java:7047` | `UPDATE` | `guias` | `SET estatus = '<Por Timbrar>', factImpresa = '' WHERE num_guia = '<folio>'` | Revertir el estatus/factura de la guía | Escritura — efecto central de la operación de liberar |
| SQL-4 | `ModificarGuias.java:7419` (`sacarDepa()`) | `SELECT` | `usuarios` | `priv WHERE nombre_usu = '<USUARIO>'` | Determinar el departamento del usuario en sesión (`DEPARTAMENTO`) | Solo lectura — controla si `jButton26` puede llegar a habilitarse (capa de UI, no de datos) |
| SQL-5 | `ModificarGuias.java:5208-5209` (`rSTableMetro1KeyReleased`) | `SELECT` | `usuarios` | `priv WHERE nombre_usu = '<USUARIO>'` (duplicado de SQL-4, ejecutado de nuevo al navegar la tabla con teclado) | Igual que SQL-4 | Solo lectura |

No se encontró ningún `INSERT`, `DELETE`, `CALL` (procedimiento
almacenado) ni `SHOW` asociado a este flujo. `Consultas.bitacora(...)`
existe como método genérico en la capa de datos (usado en otras pantallas,
p. ej. `Principal.java:7796` para "Salió del Sistema"), pero **no se
invoca en ningún punto de `liberarGuia()`** — confirmado por inspección
completa del cuerpo del método.

No fue posible inspeccionar procedimientos almacenados o triggers a nivel
de motor de base de datos (no hay dump de esquema de SICRET en este
repositorio, solo código Java) — pero dado que `Consultas.java` abre la
conexión JDBC de forma cruda y ejecuta SQL literal sin ningún `CALL`, y
que `CLAUDE.md` ya establece que *"SICRET no genera eventos"*, es
consistente asumir que no existen triggers relevantes a este flujo del
lado del motor.

---

## ENTREGA 5 — Reglas de negocio

1. **Selección obligatoria**: no se puede liberar sin una fila
   seleccionada en la tabla de guías (`ModificarGuias.java:6929-6935`).
   Mensaje: *"Selecciona una guía para poder LIBERAR los datos"*.

2. **Confirmación explícita obligatoria**: la operación solo procede si el
   usuario responde "Sí" al diálogo de advertencia
   (`ModificarGuias.java:7043`). No hay forma de liberar sin ver antes el
   texto de advertencia completo.

3. **No hay validación de estatus previo**: el código **no verifica** que
   la guía seleccionada tenga efectivamente una factura asociada, ni que
   su `estatus` actual sea uno de los esperables (p. ej.
   `<Facturada ...>`). Se puede ejecutar "Liberar" sobre una guía que ya
   está en `<Por Timbrar>` — el resultado sería un `UPDATE` inocuo sobre
   `guias` (mismos valores) pero **igual sobrescribe** `descrip` en
   `llamadas_historicas` con `"<valor de factura> \n\n CFDI ANTERIOR: "`
   (cadena vacía después del prefijo, si `factImpresa` ya estaba vacío).

4. **No hay control de permisos a nivel de datos**: el único control de
   "quién puede liberar" es un **estado de habilitación de un botón de
   interfaz** (`jButton26.setEnabled(...)`), gobernado por:
   - el departamento del usuario en sesión (`DEPARTAMENTO`, resuelto vía
     SQL-4/SQL-5 contra `usuarios.priv`), que debe ser uno de:
     `SUPER USUARIO`, `JEFE DE TRÁFICO`, `TRÁFICO`,
     `GERENTE DE OPERACIONES`, `LIQUIDACIONES`
     (`ModificarGuias.java:5165`); y
   - que el filtro `jComboBox8` esté en el índice `0` ("ACTIVA", de
     `{"ACTIVA","CANCELADA","TODOS"}`, `ModificarGuias.java:3753`).

   El propio método `liberarGuia()` **no repite ninguna de estas
   validaciones** — si algún otro punto del código (ver regla 6) lo
   invoca sin pasar por el botón, no hay ninguna comprobación de
   departamento ni de usuario en el camino. La única barrera real es la
   confirmación del diálogo (regla 2).

5. **Sin control de concurrencia ni idempotencia**: nada impide invocar
   "Liberar" dos veces seguidas sobre la misma guía (cada clic reabre el
   diálogo de confirmación); tampoco hay verificación de que otro usuario
   no haya modificado la guía entre que se cargó la tabla y que se
   confirma la liberación (no hay bloqueo optimista ni número de versión).

6. **Vía secundaria de disparo (comportamiento observado, no evidentemente
   intencional)** — `ModificarGuias.java:4278-4301`
   (`jButton2ActionPerformed`, botón "Modificar" guía, distinto del botón
   "Liberar"): cuando el usuario en sesión **no** es `SUPER USUARIO` y
   selecciona una guía cuyo `estatus` **no** es `<Por Timbrar>` ni
   `<Asignada Al Operador>`, el código:
   1. Muestra el mensaje de error *"La guía que seleccionaste ya no se
      puede modificar porque se encuentra en otro estatus: `<estatus>`"*.
   2. Inmediatamente después, **sin ninguna otra condición**, llama a
      `liberarGuia()` (línea `4299`) y hace `return`.

   Es decir: intentar *modificar* (no liberar) una guía ya facturada,
   pagada, o en cualquier estatus fuera de esas dos excepciones, dispara
   el mismo flujo de liberación descrito arriba — con su propia
   confirmación Sí/No independiente. Este camino **no pasa por el chequeo
   de habilitación de `jButton26`** ni por el filtro de departamento de la
   regla 4; el único freno que conserva es la confirmación del paso 2 de
   `liberarGuia()` (regla 2). Se documenta tal cual aparece en el código,
   sin asumir si es un comportamiento deliberado o un defecto de
   copy-paste del desarrollador original.

7. **Literales de estatus**: SICRET almacena `estatus` como cadenas con
   signos de mayor/menor incluidos, p. ej. `<Por Timbrar>`,
   `<Facturada FOLIO: fecha>`, `<Pagada Al Operador>`,
   `<En Prefactura Interna>`, `<Cancelada: usuario fecha>`. El literal que
   escribe `liberarGuia()` es exactamente `<Por Timbrar>` — debe
   respetarse el formato exacto (con ambos signos) para que el resto de
   SICRET siga reconociendo la guía como "por timbrar" en sus propios
   filtros (`ModificarGuias.java:8363-8364` y equivalentes en otras
   pantallas).

---

## ENTREGA 6 — Efectos secundarios completos

| Efecto | Tabla.Columna | Valor anterior | Valor nuevo | Alcance |
|---|---|---|---|---|
| Reversión de estatus | `guias.estatus` | cualquiera (típicamente `<Facturada ...>`) | literal `<Por Timbrar>` | Escritura directa, sin trigger |
| Borrado de referencia de factura | `guias.factImpresa` | folio/CFDI de la factura | `''` (cadena vacía) | Escritura directa |
| Sobrescritura de bitácora libre de la llamada | `llamadas_historicas.descrip` | texto libre previo (lo que sea que tuviera) | `"<valor de guias.factura> \n\n CFDI ANTERIOR: <valor anterior de guias.factImpresa>"` | **Se pierde el contenido anterior** — no es un `APPEND`, es un `SET` que reemplaza |
| Refresco de la tabla en pantalla | (ninguna tabla — solo `SELECT`) | — | — | Repuebla `rSTableMetro1`; la fila seleccionada se pierde |

**No ocurre ninguno de los siguientes efectos** (verificado por ausencia
de llamadas dentro de `liberarGuia()` y sus únicas dos dependencias,
`Consultas.inserSinMsj` y `consultar()`):

- No se inserta ningún registro de bitácora/auditoría (`Consultas.bitacora`
  no se invoca).
- No se envía correo electrónico (`EnviarCorreo`, clase interna presente
  en `ModificarGuias.java`, no se referencia desde `liberarGuia()`).
- No se genera ni regenera ningún PDF (`CrearPDF`, `ImprimirGuias`,
  `ImprimirFacturas`, `ImprimirRSP`, `ImprimirViajes` — ninguna se llama).
- No se modifica ninguna otra tabla (`facturas33`, `prefacturacliente`,
  `tarjeta_contenido_cliente`, etc. — estas sí se tocan en flujos
  *distintos* y no relacionados, como la cancelación de una factura desde
  `Facturas33.java`, ver nota de contexto abajo).
- No se dispara ningún evento ni notificación — no hay socket, no hay
  mecanismo pub/sub en SICRET.
- No cambian `guias.factura` ("Rep Interno"), `guias.prefactura`,
  `guias.DO`, `guias.LID`, ni ninguna otra columna de `guias`.

> **Nota de contexto (fuera de alcance de "Liberar", solo para no generar
> confusión)**: existe un mecanismo *distinto y no relacionado* en
> `Facturas33.java` (líneas ~11064-11090 y ~15604-15639) que también
> revierte `guias.estatus`/`guias.factImpresa` de forma similar
> (`'<En Prefactura Interna>'`, `'<Por Timbrar>'` o
> `'<Pagada Al Operador>'`, según el caso), pero se dispara al **cancelar
> una factura** desde el módulo de Facturación, identificando las guías
> por `factImpresa = '<num de factura>'` en vez de por `num_guia`, y con
> su propia UI y confirmaciones. No es invocado por, ni invoca a,
> `ModificarGuias.liberarGuia()`. Se documenta solo para evitar que se
> confunda con el proceso aquí especificado.

---

## ENTREGA 7 — Tabla cronológica completa

| Paso | Componente | Acción | Base de Datos | Resultado |
|---|---|---|---|---|
| 1 | Usuario | Clic en menú "Guías" o ícono "Gestionar las guías" | — | Se abre/reutiliza la pestaña "Consultar Guías" |
| 2 | `Principal.modificarGuias()` | Verifica `existenDatos()`, instancia o reutiliza `ModificarGuias` | — | Panel `ModificarGuias` visible |
| 3 | `ModificarGuias` (constructor) | `privilegios()` (con `DEPARTAMENTO=""`) → `sacarDepa()` (SQL-4) → `consultar()` (SQL-1) | `SELECT priv FROM usuarios`; `SELECT ... FROM guias JOIN ...` | Tabla de guías poblada; botones de escritura deshabilitados por defecto |
| 4 | Usuario | Clic en una fila de la tabla de guías | — | `rSTableMetro1MouseClicked` |
| 5 | `ModificarGuias` | `privilegios()` re-evaluado; si departamento habilitado y filtro "ACTIVA" | — | `jButton26` ("Liberar") queda habilitado |
| 6 | Usuario | Clic en botón "Liberar" (o Alt+L) | — | `jButton26ActionPerformed` |
| 7 | `ModificarGuias` | Verifica fila seleccionada | — | Continúa a `liberarGuia()` |
| 8 | `ModificarGuias.liberarGuia()` | Muestra diálogo de advertencia (Sí/No) | — | Espera respuesta del usuario |
| 9a | Usuario | Responde "No" o cierra el diálogo | — | **FIN — sin cambios en base de datos** |
| 9b | Usuario | Responde "Sí" | — | Continúa |
| 10 | `ModificarGuias.liberarGuia()` | Lee de la fila seleccionada: columna "Factura" (`factImpresa`) y columna "Rep Interno" (`factura`) | — | Arma `fact` y `descripcion` en memoria |
| 11 | `Consultas.inserSinMsj` (SQL-2) | `UPDATE llamadas_historicas SET descrip=... WHERE num_guia=...` | Escritura | `descrip` de la llamada queda sobrescrito con el rastro de la factura anterior |
| 12 | `Consultas.inserSinMsj` (SQL-3) | `UPDATE guias SET estatus='<Por Timbrar>', factImpresa='' WHERE num_guia=...` | Escritura | La guía queda revertida a estatus "Por Timbrar", sin factura asociada |
| 13 | `ModificarGuias.consultar()` (SQL-1, repetido) | Vuelve a ejecutar el `SELECT` general | Lectura | Tabla en pantalla refrescada con el nuevo estatus visible |
| 14 | — | — | — | **FIN — proceso completo** |

---

## ENTREGA 8 — Puntos críticos para replicar este proceso en ATLAS

Estos son los comportamientos que `SicretGateway::liberar()` (y el par
`LiberacionExecutor` / `LiberationConfirmationWatcher`) deberán reproducir
o decidir conscientemente **no** reproducir, para que el contrato
funcional con SICRET sea fiel:

1. **Dos escrituras independientes, no transaccionales**. SICRET ejecuta
   el `UPDATE` sobre `llamadas_historicas` y el `UPDATE` sobre `guias` en
   dos conexiones JDBC separadas, sin transacción ni rollback conjunto. Si
   `SicretGateway::liberar()` va a escribir directamente en SICRET (única
   excepción autorizada por `CLAUDE.md`), debe decidir explícitamente si
   replica esta falta de atomicidad (fidelidad total al legado) o la
   corrige con una transacción (lo cual cambiaría el comportamiento ante
   fallos parciales respecto al sistema original — un fallo entre el
   `UPDATE` 1 y el 2 en SICRET deja `llamadas_historicas` actualizado pero
   `guias` no).

2. **Orden exacto de las dos escrituras**: primero `llamadas_historicas`
   (bitácora textual), después `guias` (estatus/factura). Este orden
   importa si se decide replicar el comportamiento parcial ante fallos.

3. **Valor literal exacto del nuevo estatus**: `<Por Timbrar>`, con ambos
   signos de mayor/menor, sin espacios adicionales. Cualquier variación
   (mayúsculas, espacios, falta de un signo) rompería la compatibilidad
   con el resto de las pantallas de SICRET que filtran por este literal.

4. **El campo que se lee para "Rep Interno" no es el que su nombre
   sugiere**: la cadena que termina en `llamadas_historicas.descrip` se
   arma con `guias.factura` (no con el `descrip` anterior). Si se
   replica el efecto textual con fidelidad, debe leerse `guias.factura` en
   el momento de la liberación, no derivarse de otra columna. Si se decide
   **no** replicar este comportamiento (por ejemplo, por parecer un
   defecto del sistema original), debe ser una decisión explícita y
   documentada del equipo de ATLAS — este documento no la toma por
   instrucción expresa.

5. **`descrip` se sobrescribe, no se acumula**: cualquier información
   previa en `llamadas_historicas.descrip` se pierde en cada liberación.
   Si ATLAS necesita preservar historial legible, deberá decidir si lo
   hace en su propio lado (p. ej. `solicitud_liberacion_historial`, que ya
   existe en `database/schema.sql`) en vez de depender de que SICRET lo
   preserve — porque SICRET, tal como está, no lo hace.

6. **Ninguna validación de precondición de negocio existe en SICRET para
   este paso**: no verifica que la guía tenga efectivamente una factura
   antes de "liberarla". Si ATLAS quiere ser más estricto que SICRET
   (p. ej., solo permitir liberar guías que su propio Synchronization
   Engine detectó como facturadas), esa validación tendría que vivir
   enteramente en ATLAS antes de invocar `SicretGateway::liberar()` — no
   hay ninguna garantía equivalente del lado de SICRET.

7. **No hay bitácora de auditoría nativa de SICRET para esta operación**.
   Si se requiere trazabilidad de "quién liberó qué y cuándo" del lado de
   SICRET, no existe tal registro hoy — el único rastro es el texto libre
   sobrescrito en `llamadas_historicas.descrip` (ver punto 5), que ni
   siquiera incluye el usuario ni la fecha (a diferencia de otros flujos
   de SICRET, como la cancelación de guía en la misma clase,
   `ModificarGuias.java:7448`, que sí concatena usuario y fecha dentro del
   propio estatus). Toda la auditoría "quién/cuándo solicitó/ejecutó la
   liberación" deberá construirse en ATLAS (`solicitud_liberacion_historial`),
   no asumirse heredada de SICRET.

8. **La confirmación del usuario es parte del contrato funcional que
   SICRET protege, pero ATLAS ya la reubica**: en SICRET, la única
   barrera real antes de escribir es el diálogo de confirmación
   Sí/No dentro de `liberarGuia()` — no hay control de permisos real a
   nivel de datos (ver Entrega 5, regla 4). Dado que `CLAUDE.md` establece
   que `SicretGateway::liberar()` solo replica *"operaciones de negocio ya
   aprobadas por Facturación"*, la responsabilidad de exigir esa
   aprobación recae enteramente en ATLAS antes de invocar el gateway — no
   se debe asumir que SICRET aportará ninguna verificación adicional del
   lado de escritura.

9. **Identificador usado para las dos escrituras**: `num_guia` (el folio,
   p. ej. `PR000000`), no la clave primaria interna `num` (autoincremental,
   ver memoria de proyecto sobre la tabla `guias`). Ambos `UPDATE`s de
   SICRET filtran por `num_guia`, y `llamadas_historicas` lo tiene como
   columna propia (denormalizada) además de su llave de unión real
   `num_llama` — hay que usar `num_guia` tal cual, no intentar resolver
   `num_llama` para este paso.

10. **`LiberationConfirmationWatcher` no tiene ninguna señal explícita que
    monitorear más allá del propio cambio de estado**: como SICRET no
    genera eventos ni bitácora dedicada, la única forma de confirmar que
    la liberación *realmente* ocurrió (en línea con la restricción de
    `CLAUDE.md` de *"nunca asumir que una operación concluyó solo porque
    se solicitó"*) es releer `guias.estatus` y `guias.factImpresa` después
    de invocar `SicretGateway::liberar()` y verificar que efectivamente
    quedaron en `<Por Timbrar>` / `''` — exactamente el mismo patrón de
    monitoreo por polling que ya usa `GuideWatcher` para detectar guías
    nuevas.

11. **No replicar la vía secundaria de disparo** (Entrega 5, regla 6): el
    hecho de que `jButton2ActionPerformed` invoque `liberarGuia()` como
    efecto colateral de un intento de "modificar" una guía en estatus no
    editable parece, por el contexto, un comportamiento no deliberado del
    sistema original y no una regla de negocio a preservar. Se señala
    aquí explícitamente para que el equipo de ATLAS decida con
    conocimiento de causa, no para recomendar su replicación.
