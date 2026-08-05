<?php

declare(strict_types=1);

namespace App\Dashboard;

/**
 * Combina los KPIs de Liberación y Timbrado en un solo resumen — usado por
 * las tarjetas genéricas de la barra superior del panel de Facturación
 * ("Solicitudes pendientes", "Aprobadas hoy", "Rechazadas hoy", "Min.
 * promedio de espera"), que representan el tablero completo y no un solo
 * módulo. Compartido por public/facturacion.php (primer pintado) y
 * public/api/facturacion-kpis.php (refrescos) para que ambos coincidan.
 */
final class FacturacionResumenKpis
{
    /**
     * @param array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float} $liberacion
     * @param array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float} $timbrado
     * @return array{pendientes: int, aprobadas_hoy: int, rechazadas_hoy: int, tiempo_promedio_espera_minutos: float}
     */
    public static function combinar(array $liberacion, array $timbrado): array
    {
        $pendientesLiberacion = $liberacion['pendientes'] ?? 0;
        $pendientesTimbrado = $timbrado['pendientes'] ?? 0;
        $totalPendientes = $pendientesLiberacion + $pendientesTimbrado;

        // Promedio ponderado por el número de solicitudes pendientes de cada
        // módulo — un promedio simple de los dos promedios distorsionaría el
        // resultado si un módulo tiene muchas más solicitudes en espera que
        // el otro.
        $tiempoPromedio = $totalPendientes > 0
            ? (
                ($liberacion['tiempo_promedio_espera_minutos'] ?? 0.0) * $pendientesLiberacion
                + ($timbrado['tiempo_promedio_espera_minutos'] ?? 0.0) * $pendientesTimbrado
            ) / $totalPendientes
            : 0.0;

        return [
            'pendientes' => $totalPendientes,
            'aprobadas_hoy' => ($liberacion['aprobadas_hoy'] ?? 0) + ($timbrado['aprobadas_hoy'] ?? 0),
            'rechazadas_hoy' => ($liberacion['rechazadas_hoy'] ?? 0) + ($timbrado['rechazadas_hoy'] ?? 0),
            'tiempo_promedio_espera_minutos' => round($tiempoPromedio, 1),
        ];
    }
}
