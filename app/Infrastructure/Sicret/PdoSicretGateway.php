<?php

declare(strict_types=1);

namespace App\Infrastructure\Sicret;

use App\Sync\Source;
use App\Sync\SourceRegistry;
use App\Sync\SyncLogger;
use PDOException;

/**
 * Implementación real de SicretGateway — deliberadamente incompleta en
 * liberar(). Antes de completarla, léase esto:
 *
 * ACTUALIZACIÓN: la semántica exacta de "Liberar" en SICRET ya está
 * completamente documentada — ver
 * `knowledge/modules/solicitudes-liberacion/sicret-legacy-liberacion-spec.md`,
 * ingeniería inversa exhaustiva del cliente de escritorio legacy
 * (`sicret.ModificarGuias::liberarGuia()`), con archivo:línea exactos de
 * cada sentencia SQL. Resume: dos `UPDATE` sin transacción (SICRET es
 * MyISAM) — `guias.estatus = '<Por Timbrar>'` +
 * `guias.factImpresa = ''`, y `llamadas_historicas.descrip` recibe el
 * CFDI anterior como texto libre. La afirmación previa de este docblock
 * (que no se había encontrado esa semántica) queda superada por ese
 * documento — se conserva el párrafo original abajo solo como registro
 * histórico de la investigación de solo lectura que sí se hizo contra la
 * base de datos real.
 *
 * A pesar de conocerse ya la sentencia exacta, `liberar()` sigue sin
 * cuerpo real en este sprint (Tablero de Facturación) — completarla es
 * explícitamente trabajo de un sprint futuro, no de este. Se deja
 * lanzando SicretWriteNotConfiguredException a propósito.
 *
 * Investigación original (2026-07-19, antes de la especificación
 * anterior): se revisó el código de trafico-system (único otro sistema
 * con permiso de escritura sobre sicrePR) y su propia base de
 * conocimiento (`knowledge/improvement_notes.md §7`, `knowledge/guias.md
 * §9`, ambos en /home/servidor/trafico-system): confirmaban textualmente
 * que "liberar" "no escribe nada en SICRET ni en trafico-system" — y una
 * inspección de solo lectura de sicrePR.guias (DESCRIBE + SELECT DISTINCT
 * estatus/estado, sin ninguna escritura) tampoco había encontrado un
 * valor tipo "Liberada"/"Liberado" ni una tabla de historial de
 * transiciones — solo confirmaba que `estatus` es texto libre que el
 * cliente legacy reescribe con total libertad, sin ningún registro de
 * quién ni cómo lo cambia. Esa inspección de solo lectura fue correcta;
 * lo que faltaba era leer el código fuente del cliente legacy, que el
 * documento arriba referenciado ya cubre por completo.
 *
 * Lo que SÍ queda resuelto por esta clase y no debe rehacerse al
 * completarla:
 * - La fuente de conexión de ESCRITURA (SourceRegistry propio, separado
 *   del de solo lectura que usa App\Sync — ver config/sources-write.php),
 *   para que nunca se reutilice por error la conexión de solo lectura.
 * - La auditoría de cada intento (SicretWriteLogRepository), éxito o no.
 * - El contrato hacia el dominio (SicretGateway) — App\Liberacion\Execution
 *   y cualquier futuro Executor ya pueden integrarse contra la interfaz
 *   sin esperar a este detalle.
 *
 * Para completar liberar(): confirmar con quien opera SICRET (o con el
 * código fuente del cliente de escritorio legacy, fuera de este
 * repositorio) la sentencia SQL exacta, envolverla en una transacción
 * sobre $this->writeSourceRegistry->all() filtrado por $source, y
 * reemplazar el throw por la ejecución real + registrar 'exito' en el
 * log en vez de 'rechazado_no_configurado'.
 */
final class PdoSicretGateway implements SicretGateway
{
    // Mismos códigos que App\Sync\GuideWatcher::CONNECTION_LOST_ERROR_CODES:
    // 2006 = server has gone away, 2013 = lost connection during query. La
    // conexión de escritura vive tanto como el proceso de
    // bin/monitoring-engine.php y puede permanecer ociosa horas hasta la
    // primera Solicitud APROBADA — encontrado al ejecutar el Runtime
    // completo de punta a punta: la primera liberación tras varias horas
    // sin actividad fallaba con "MySQL server has gone away" y quedaba en
    // ERROR sin reintentar, mismo síntoma que ya se había resuelto para la
    // conexión de solo lectura de App\Sync.
    private const CONNECTION_LOST_ERROR_CODES = [2006, 2013];

    public function __construct(
        private readonly SourceRegistry $writeSourceRegistry,
        private readonly SicretWriteLogRepository $writeLog,
        private readonly SyncLogger $logger,
    ) {
    }

    public function liberar(string $source, string $numGuia): void
    {
        $sourceObj = $this->buscarFuente($source);

        if ($sourceObj === null) {
            $exception = new \RuntimeException("Fuente de escritura no encontrada: {$source}");
            $this->logErrorYRechazo($source, $numGuia, $exception->getMessage());
            throw $exception;
        }

        try {
            $this->ejecutarLiberacion($sourceObj, $source, $numGuia);
        } catch (\PDOException $e) {
            if (!$this->isConnectionLost($e)) {
                throw $e;
            }

            $this->logger->error('Conexión de escritura perdida con SICRET, reconectando', [
                'source' => $source,
                'error' => $e->getMessage(),
            ]);

            $sourceObj->reconnect();

            $this->ejecutarLiberacion($sourceObj, $source, $numGuia);
        }
    }

    private function buscarFuente(string $source): ?Source
    {
        foreach ($this->writeSourceRegistry->all() as $s) {
            if ($s->name() === $source) {
                return $s;
            }
        }

        return null;
    }

    private function isConnectionLost(PDOException $e): bool
    {
        return in_array((int) ($e->errorInfo[1] ?? 0), self::CONNECTION_LOST_ERROR_CODES, true);
    }

    private function ejecutarLiberacion(Source $sourceObj, string $source, string $numGuia): void
    {
        $pdo = $sourceObj->connection();

        try {
            $pdo->beginTransaction();

            $stmt = $pdo->prepare('SELECT factura, factImpresa FROM guias WHERE num_guia = :num_guia');
            $stmt->execute(['num_guia' => $numGuia]);
            $guia = $stmt->fetch(\PDO::FETCH_ASSOC);

            if (!$guia) {
                throw new \RuntimeException("Guía no encontrada en SICRET: {$numGuia}");
            }

            $factura = (string) ($guia['factura'] ?? '');
            $factImpresa = (string) ($guia['factImpresa'] ?? '');
            $fact = $factImpresa !== '' ? "CFDI ANTERIOR: {$factImpresa}" : "CFDI ANTERIOR: ";

            $nuevaDescrip = "{$factura} \n\n {$fact}";

            $stmtHist = $pdo->prepare("UPDATE llamadas_historicas SET descrip = :descrip WHERE num_guia = :num_guia");
            $stmtHist->execute([
                'descrip' => $nuevaDescrip,
                'num_guia' => $numGuia,
            ]);

            $stmtGuia = $pdo->prepare("UPDATE guias SET estatus = '<Por Timbrar>', factImpresa = '' WHERE num_guia = :num_guia");
            $stmtGuia->execute(['num_guia' => $numGuia]);

            $pdo->commit();

            $this->writeLog->registrar(
                operacion: 'liberar',
                source: $source,
                numGuia: $numGuia,
                resultado: 'exito',
                detalle: "CFDI anterior: {$factImpresa}",
            );

            $this->logger->info('Liberación ejecutada correctamente en SICRET', [
                'operacion' => 'liberar',
                'source' => $source,
                'num_guia' => $numGuia,
                'cfdi_anterior' => $factImpresa,
            ]);
        } catch (\Throwable $e) {
            if ($pdo->inTransaction()) {
                $pdo->rollBack();
            }
            $this->logErrorYRechazo($source, $numGuia, $e->getMessage());
            throw $e;
        }
    }

    private function logErrorYRechazo(string $source, string $numGuia, string $error): void
    {
        $this->writeLog->registrar(
            operacion: 'liberar',
            source: $source,
            numGuia: $numGuia,
            resultado: 'error',
            detalle: $error,
        );

        $this->logger->error('Error al ejecutar liberación en SICRET', [
            'operacion' => 'liberar',
            'source' => $source,
            'num_guia' => $numGuia,
            'error' => $error,
        ]);
    }
}
