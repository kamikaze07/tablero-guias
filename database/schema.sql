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
