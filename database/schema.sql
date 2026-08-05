-- Esquema inicial de la base de datos propia de ATLAS.
-- Alcance: soporte al núcleo del Synchronization Engine (detección de guías,
-- checkpoints y heartbeat). No incluye el modelo de paneles del Dashboard
-- de Tráfico (fuera de alcance de este sprint).

-- Guías detectadas desde SICRET (sicrePR y sicreGero).
-- `source` + `source_num` identifican de forma única el registro de origen,
-- porque `num` es un AUTO_INCREMENT independiente por cada base de SICRET.
CREATE TABLE IF NOT EXISTS guias (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    source VARCHAR(20) NOT NULL,
    source_num INT UNSIGNED NOT NULL,
    num_guia VARCHAR(15) NOT NULL,
    folio_imp VARCHAR(20) NOT NULL,
    fecha DATETIME NOT NULL,
    fecha_c DATETIME NOT NULL,
    fecha_d DATETIME NOT NULL,
    num_llama INT NOT NULL,
    estado VARCHAR(200) NOT NULL,
    nombre VARCHAR(90) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    num_vale VARCHAR(50) NOT NULL,
    diesel VARCHAR(50) NOT NULL,
    servicio VARCHAR(20) NOT NULL,
    rem1 VARCHAR(15) NOT NULL,
    placas1 VARCHAR(15) NOT NULL,
    rem2 VARCHAR(15) NOT NULL,
    placas2 VARCHAR(15) NOT NULL,
    estatus VARCHAR(250) NOT NULL,
    pedido VARCHAR(250) NOT NULL,
    comen_pre VARCHAR(999) NOT NULL,
    factura INT NOT NULL,
    manifiesto VARCHAR(50) NOT NULL,
    ticket1 VARCHAR(100) NOT NULL,
    tons1 FLOAT NOT NULL,
    ticket2 VARCHAR(100) NOT NULL,
    tons2 FLOAT NOT NULL,
    operador VARCHAR(60) NOT NULL,
    prefactura INT NOT NULL,
    factimpresa VARCHAR(20) NOT NULL,
    linea VARCHAR(100) NOT NULL,
    km FLOAT NOT NULL,
    claveproducto_sat VARCHAR(999) NOT NULL,
    claveunidad_sat VARCHAR(999) NOT NULL,
    do_field TEXT NULL,
    lid_field TEXT NULL,
    actualizacion TEXT NULL,
    detected_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uq_guias_source_num (source, source_num),
    KEY idx_guias_fecha (fecha),
    KEY idx_guias_num_guia (num_guia)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Checkpoint por fuente: siempre representa el último `num` de origen
-- confirmado e insertado exitosamente en ATLAS (nunca el último leído).
CREATE TABLE IF NOT EXISTS sync_checkpoints (
    source VARCHAR(20) NOT NULL,
    last_num INT UNSIGNED NOT NULL DEFAULT 0,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (source)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Estado (Heartbeat) del Synchronization Engine, para un futuro panel
-- de administración.
CREATE TABLE IF NOT EXISTS sync_heartbeat (
    engine_name VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    last_cycle_at DATETIME NULL,
    last_success_at DATETIME NULL,
    last_error TEXT NULL,
    cycles_completed BIGINT UNSIGNED NOT NULL DEFAULT 0,
    records_synced_total BIGINT UNSIGNED NOT NULL DEFAULT 0,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (engine_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Solicitudes de Liberación: módulo receptor de trafico-system.
-- Diseño completo en knowledge/modules/solicitudes-liberacion/. Sin
-- FOREIGN KEY físicas, igual convención que las tablas anteriores — las
-- relaciones se validan en código, no en el motor de base de datos.

-- Estado operativo del tablero por guía (Generada / Solicitada a
-- Liberación / [futuro] resultado de timbrado), distinto del campo crudo
-- `guias.estado` replicado de SICRET. Creación perezosa: una guía sin fila
-- aquí se interpreta como GENERADA (su estado por defecto), la fila solo
-- se materializa en su primera transición.
-- `factura_impresa`: únicamente para guías confirmadas por
-- App\Monitoring\Timbrado\DirectStampingWatcher (timbrado directo en SICRET
-- sin Solicitud de Timbrado previa) — ahí no existe ningún `solicitud_id`
-- donde guardar el valor (a diferencia de
-- solicitud_timbrado_detalle.factura_impresa, que sí cuelga de una
-- Solicitud real). public/api/timbrado-carta-porte.php cae aquí como
-- segunda fuente cuando la guía no tiene fila en solicitud_timbrado_detalle.
CREATE TABLE IF NOT EXISTS guia_estado_tablero (
    guia_id BIGINT UNSIGNED NOT NULL,
    estado VARCHAR(30) NOT NULL,
    factura_impresa VARCHAR(20) NULL,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (guia_id),
    KEY idx_guia_estado_tablero_estado (estado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Cabecera de una Solicitud de Liberación: una fila por cada lote de
-- guías que un sistema origen (hoy únicamente trafico-system) pide
-- liberar. `estado` solo alcanza PENDIENTE en este sprint; EN_REVISION/
-- APROBADA/RECHAZADA quedan reservados para el futuro módulo de
-- Facturación.
-- `estado` transita PENDIENTE -> APROBADA -> EJECUTANDO -> COMPLETADA,
-- o PENDIENTE -> RECHAZADA (terminal), o EJECUTANDO -> ERROR (terminal).
-- APROBADA/RECHAZADA los escribirá el futuro Panel de Trabajo de
-- Facturación (fuera de alcance de este sprint); EJECUTANDO/COMPLETADA/
-- ERROR los escriben App\Liberacion\Execution\LiberacionExecutor y
-- App\Monitoring\Liberacion\LiberationConfirmationWatcher. Ver
-- App\Liberacion\GuiaEstadoTableroRepository para el estado espejo a
-- nivel de guía individual.
CREATE TABLE IF NOT EXISTS solicitud_liberacion (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    origen VARCHAR(50) NOT NULL,
    motivo TEXT NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    resolved_at DATETIME NULL,
    resolved_by VARCHAR(50) NULL,
    executed_at DATETIME NULL,
    confirmed_at DATETIME NULL,
    error_reason TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_solicitud_liberacion_estado (estado),
    KEY idx_solicitud_liberacion_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Guías que pertenecen a cada Solicitud de Liberación (relación N a N
-- materializada). `num_guia` se duplica únicamente por legibilidad en
-- consultas manuales; la fuente de verdad sigue siendo `guias` vía
-- guia_id.
--
-- `cfdi_nuevo_folio`/`folio_fiscal_nuevo`: caché write-once del CFDI que
-- refactura esta guía tras liberarse, para el reporte "Guías Liberadas"
-- (App\Reportes\GuiasLiberadasReportRepository). Antes se resolvían en cada
-- carga del reporte correlacionando con `sicret_write_log` (y, si eso
-- fallaba, contra `facturas33` en vivo vía RefacturacionSicretLookup) —
-- ambos caminos son consultas repetidas para un dato que, una vez que un
-- CFDI existe y tiene folio fiscal, ya no cambia nunca. Se llenan aquí la
-- primera vez que se resuelven por cualquiera de esos dos caminos y nunca
-- se vuelven a pisar (mismo criterio de "nunca sobrescribir un valor ya
-- capturado" que `PdoSicretGateway::completarDatosFiscales()` usa en
-- `facturas33` misma).
CREATE TABLE IF NOT EXISTS solicitud_liberacion_detalle (
    solicitud_id BIGINT UNSIGNED NOT NULL,
    guia_id BIGINT UNSIGNED NOT NULL,
    num_guia VARCHAR(15) NOT NULL,
    cfdi_nuevo_folio VARCHAR(20) NULL,
    folio_fiscal_nuevo VARCHAR(40) NULL,
    PRIMARY KEY (solicitud_id, guia_id),
    KEY idx_solicitud_liberacion_detalle_guia (guia_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Bitácora append-only de eventos sobre una Solicitud de Liberación
-- (auditoría). Ninguna fila ya escrita se actualiza ni se borra.
CREATE TABLE IF NOT EXISTS solicitud_liberacion_historial (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    solicitud_id BIGINT UNSIGNED NOT NULL,
    evento VARCHAR(30) NOT NULL,
    estado_anterior VARCHAR(20) NULL,
    estado_nuevo VARCHAR(20) NOT NULL,
    actor VARCHAR(50) NULL,
    detalle TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_solicitud_liberacion_historial_solicitud (solicitud_id, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Bitácora append-only de toda escritura que ATLAS realiza hacia SICRET,
-- sin importar qué proceso de negocio la origina (Liberación, y en el
-- futuro Timbrado/Cancelaciones/etc.). Único punto de auditoría de
-- App\Infrastructure\Sicret\SicretGateway — cada intento de escritura se
-- registra aquí, tanto si tuvo éxito como si falló o fue rechazado por no
-- estar su semántica todavía confirmada.
CREATE TABLE IF NOT EXISTS sicret_write_log (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    operacion VARCHAR(50) NOT NULL,
    source VARCHAR(20) NOT NULL,
    num_guia VARCHAR(15) NOT NULL,
    -- VARCHAR(30), no 20: 'rechazado_no_configurado' (24) ya no cabía en
    -- 20 y el INSERT fallaba en silencio (el propio intento de auditar un
    -- rechazo quedaba sin registrar). Encontrado al validar de punta a
    -- punta el flujo Aceptar -> LiberacionExecutor -> SicretGateway en el
    -- sprint "Tablero de Facturación".
    resultado VARCHAR(30) NOT NULL,
    detalle TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_sicret_write_log_num_guia (num_guia),
    KEY idx_sicret_write_log_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Cabecera de una Solicitud de Timbrado: una fila por cada lote de guías
-- que trafico-system pide timbrar. Proceso independiente de Liberación
-- (ver App\Timbrado\SolicitudTimbradoService) — no comparte
-- guia_estado_tablero porque no mueve ninguna máquina de estados de la
-- guía, solo registra la intención para que Facturación la atienda.
-- `estado` solo alcanza PENDIENTE en este sprint, igual que
-- solicitud_liberacion en su primer sprint.
CREATE TABLE IF NOT EXISTS solicitud_timbrado (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    origen VARCHAR(50) NOT NULL,
    solicitante VARCHAR(100) NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    resolved_at DATETIME NULL,
    resolved_by VARCHAR(50) NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_solicitud_timbrado_estado (estado),
    KEY idx_solicitud_timbrado_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Guías que pertenecen a cada Solicitud de Timbrado (relación N a N
-- materializada) — mismo diseño que solicitud_liberacion_detalle.
--
-- `factura_impresa`: valor de SICRET `guias.factImpresa` en el momento en
-- que App\Monitoring\Timbrado\TimbradoConfirmationWatcher confirma el
-- timbrado (ver StampingEvidenceSource) — se persiste aquí porque
-- `guias.factimpresa` de ATLAS (App\Sync\GuiaRepository, INSERT-only) casi
-- siempre queda vacío para este caso: la guía se sincroniza ANTES de
-- timbrarse, así que su copia local nunca se actualiza después. Sin esta
-- columna, sería imposible ubicar el Complemento Carta Porte de una guía
-- ya timbrada sin volver a consultar SICRET en vivo.
CREATE TABLE IF NOT EXISTS solicitud_timbrado_detalle (
    solicitud_id BIGINT UNSIGNED NOT NULL,
    guia_id BIGINT UNSIGNED NOT NULL,
    num_guia VARCHAR(15) NOT NULL,
    factura_impresa VARCHAR(20) NULL,
    PRIMARY KEY (solicitud_id, guia_id),
    KEY idx_solicitud_timbrado_detalle_guia (guia_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Bitácora append-only de eventos sobre una Solicitud de Timbrado
-- (auditoría). Sin columnas de estado_anterior/estado_nuevo: a diferencia
-- de solicitud_liberacion_historial, este sprint de Timbrado no tiene
-- transiciones de estado que registrar, solo el evento CREADA.
CREATE TABLE IF NOT EXISTS solicitud_timbrado_historial (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    solicitud_id BIGINT UNSIGNED NOT NULL,
    evento VARCHAR(30) NOT NULL,
    actor VARCHAR(50) NULL,
    detalle TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_solicitud_timbrado_historial_solicitud (solicitud_id, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Resumen diario de los tableros de Tráfico y Facturación: una fila por
-- "día de negocio" (jornada 07:00 -> 06:59:59 del día siguiente, ver
-- App\Dashboard\BusinessDay), escrita una sola vez por
-- App\Dashboard\DailyCutoverEngine al cruzar el corte de las 07:00.
-- `fecha` es la fecha calendario en la que arrancó la jornada resumida.
CREATE TABLE IF NOT EXISTS resumen_diario_tablero (
    fecha DATE NOT NULL,
    guias_creadas INT UNSIGNED NOT NULL DEFAULT 0,
    timbrado_aprobadas INT UNSIGNED NOT NULL DEFAULT 0,
    timbrado_rechazadas INT UNSIGNED NOT NULL DEFAULT 0,
    liberacion_aprobadas INT UNSIGNED NOT NULL DEFAULT 0,
    liberacion_rechazadas INT UNSIGNED NOT NULL DEFAULT 0,
    generado_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (fecha)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
