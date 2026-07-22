# CLAUDE.md

## Proyecto

Tablero de Liberación y Timbrado de Guías.

---

## Objetivo

Desarrollar una plataforma web independiente de SICRET para administrar en tiempo real las solicitudes de liberación y timbrado de guías.

SICRET seguirá siendo el sistema principal.

Este proyecto únicamente consume información de SICRET.

---

## Restricciones

- SICRET es de lectura para todo ATLAS, con una única excepción autorizada: `App\Infrastructure\Sicret\SicretGateway` — el único componente de todo el proyecto con permiso de escritura hacia SICRET, y solo para replicar operaciones de negocio ya aprobadas por Facturación (p. ej. liberar una guía). Ningún otro módulo escribe en SICRET directa ni indirectamente.
- SICRET no genera eventos.
- Toda detección de cambios (guías nuevas) y toda confirmación de operaciones ya ejecutadas (liberaciones, timbrados, etc.) deberá realizarse mediante monitoreo de la base de datos y del sistema de archivos — nunca asumiendo que una operación concluyó solo porque se solicitó.

---

## Tecnologías

Backend

- PHP 8.3 (PHP puro)

Frontend

- HTML5
- CSS3
- JavaScript ES6
- Bootstrap 5

Base de datos

- MariaDB

Tiempo real

- Ratchet WebSockets

Infraestructura

- Docker
- Nginx
- PHP-FPM

Desarrollo

- Visual Studio Code
- Claude Code
- Git

---

## Principios

- Código limpio.
- Separación de responsabilidades.
- PHP orientado a objetos.
- Composer.
- PSR-4.
- No mezclar HTML con lógica de negocio.
- No duplicar código.
- Mantener módulos pequeños y reutilizables.

---

## Arquitectura

Toda la lógica deberá organizarse por responsabilidades.

No crear archivos gigantes.

No escribir SQL dentro de las vistas.

No utilizar variables globales.

---

## Convenciones

Código:

Inglés

Comentarios:

Español

Documentación:

Español

Interfaz:

Español

---

## Regla principal

Antes de generar código nuevo, reutilizar componentes existentes siempre que sea posible.