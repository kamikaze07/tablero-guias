# Fuentes de Datos

Este documento identifica y documenta las fuentes de datos que ATLAS consulta o consultará, así como las reglas de acceso y responsabilidad sobre cada una.

No incluye hosts, puertos ni credenciales de conexión: esa información pertenece a la infraestructura del proyecto (variables de entorno, `docker-compose.yml`), no a la arquitectura.

---

## 1. Inventario de bases de datos

| Base de datos | Motor | Propietario |
|---|---|---|
| `atlas` | MariaDB | ATLAS (propia) |
| `sicrePR` | — | SICRET |
| `sicre2PR` | — | SICRET |
| `sicreGero` | — | SICRET |
| `sicre2Gero` | — | SICRET |

> **PENDIENTE:** confirmar el motor de base de datos de las 4 bases de SICRET (se asume MariaDB/MySQL por el stack del proyecto, pero no está confirmado).

---

## 2. Propósito de cada base

- **`atlas`**: base de datos propia del tablero. Almacenará el estado de las solicitudes de liberación y timbrado, historial y demás información generada por ATLAS.
- **`sicrePR`**: > **PENDIENTE de documentar.**
- **`sicre2PR`**: > **PENDIENTE de documentar.**
- **`sicreGero`**: > **PENDIENTE de documentar.**
- **`sicre2Gero`**: > **PENDIENTE de documentar.**

---

## 3. Responsabilidad de la fuente de datos

| Base de datos | Sistema propietario | Sistema que puede escribir |
|---|---|---|
| `atlas` | ATLAS | ATLAS |
| `sicrePR` | SICRET | SICRET |
| `sicre2PR` | SICRET | SICRET |
| `sicreGero` | SICRET | SICRET |
| `sicre2Gero` | SICRET | SICRET |

ATLAS no es propietario ni tiene autoridad de escritura sobre ninguna base de SICRET. Toda modificación de esos datos ocurre exclusivamente dentro de SICRET.

---

## 4. Tipo de acceso (lectura/escritura)

| Base de datos | Acceso de ATLAS |
|---|---|
| `atlas` | Lectura / Escritura |
| `sicrePR` | Solo lectura |
| `sicre2PR` | Solo lectura |
| `sicreGero` | Solo lectura |
| `sicre2Gero` | Solo lectura |

Esta restricción es una regla del proyecto (ver `CLAUDE.md`): SICRET nunca debe ser modificado por ATLAS.

---

## 5. Tablas relevantes

- **`atlas`**: aún no tiene tablas definidas. El diseño del esquema propio corresponde a un sprint posterior.
- **`sicrePR`, `sicre2PR`, `sicreGero`, `sicre2Gero`**: > **PENDIENTE.** No se ha inspeccionado el esquema de ninguna de las 4 bases. No se documentan nombres de tablas hasta confirmarlos directamente contra cada base.

---

## 6. Relaciones entre bases

> **PENDIENTE de documentar.** No se conoce si existe relación, réplica o dependencia entre `sicrePR` y `sicre2PR`, ni entre `sicreGero` y `sicre2Gero`, ni entre el grupo "PR" y el grupo "Gero". No se asume ningún patrón a partir de los nombres.

---

## 7. Flujo de información

Según lo establecido en `CLAUDE.md`:

- SICRET no genera eventos.
- Toda detección de cambios en SICRET debe realizarse mediante monitoreo (de base de datos y de sistema de archivos).
- ATLAS consume esa información detectada y la distribuye en tiempo real a los clientes conectados vía WebSocket (Ratchet).

> **PENDIENTE:** detallar el flujo específico por cada una de las 4 bases (qué tablas se monitorean, con qué frecuencia, y qué archivos del sistema de archivos están involucrados).

---

## 8. Estrategia de integración

Toda comunicación con SICRET (las 4 bases: `sicrePR`, `sicre2PR`, `sicreGero`, `sicre2Gero`) se realizará **exclusivamente** a través de un componente dedicado: el **Synchronization Engine**.

- Ninguna otra parte de ATLAS —ni la interfaz, ni la lógica de negocio, ni ningún controlador— se conecta directamente a una base de SICRET.
- El Synchronization Engine es el único punto de acceso de lectura hacia SICRET, y el único responsable de traducir lo que detecta en esas bases hacia el modelo de datos propio de ATLAS.
- Este componente **no ha sido implementado todavía**; su diseño e implementación corresponden a un sprint posterior.

---

## 9. Información consumida por ATLAS

> **PENDIENTE.** Depende directamente de las tablas relevantes (sección 5), que aún no han sido identificadas.

---

## 10. Riesgos

- **Acoplamiento al esquema de SICRET**: sin una capa de acceso centralizada (Synchronization Engine), cualquier cambio en el esquema de las 4 bases podría romper múltiples puntos de ATLAS.
- **Carga sobre SICRET**: el monitoreo por polling se realizará contra 4 bases en lugar de 1, lo que multiplica la carga potencial sobre la infraestructura de SICRET si no se dimensiona correctamente.
- **Falta de documentación de esquema**: al no existir todavía un inventario de tablas, no es posible dimensionar el impacto real de las consultas de monitoreo ni estimar el esfuerzo de integración.
- **Ambigüedad entre bases similares**: la existencia de pares de bases con nombres similares (`sicrePR`/`sicre2PR`, `sicreGero`/`sicre2Gero`) sin relación documentada es un riesgo de que ATLAS consulte una fuente incorrecta o incompleta si no se aclara antes de implementar el Synchronization Engine.

---

## 11. Pendientes por investigar

- Propósito funcional de cada una de las 4 bases de SICRET (`sicrePR`, `sicre2PR`, `sicreGero`, `sicre2Gero`).
- Relación entre `sicrePR` y `sicre2PR`.
- Relación entre `sicreGero` y `sicre2Gero`.
- Relación (si existe) entre el grupo "PR" y el grupo "Gero".
- Motor de base de datos real de las 4 bases de SICRET.
- Esquema y tablas relevantes de cada base.
- Mecanismo exacto de monitoreo del sistema de archivos (qué archivos, en qué ruta, con qué formato).
- Frecuencia de polling segura que no impacte a SICRET en producción.
