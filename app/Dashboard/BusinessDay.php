<?php

declare(strict_types=1);

namespace App\Dashboard;

/**
 * Ventana [desde, hasta) de un "día de negocio" para los tableros de
 * Tráfico y Facturación: arranca a las 07:00 y termina a las 06:59:59 del
 * día calendario siguiente, en vez de medianoche-medianoche. Reemplaza el
 * corte de "hoy" que antes usaban GuiaBoardRepository::findToday() y los
 * kpis() de Liberación/Timbrado.
 */
final class BusinessDay
{
    private const CUTOVER_HOUR = 7;

    private function __construct(
        public readonly string $fecha,
        public readonly string $desde,
        public readonly string $hasta,
    ) {
    }

    /** Jornada vigente en $moment (la que el tablero debe mostrar como "hoy"). */
    public static function containing(\DateTimeImmutable $moment): self
    {
        $cutover = $moment->setTime(self::CUTOVER_HOUR, 0, 0);
        $desde = $moment < $cutover ? $cutover->modify('-1 day') : $cutover;

        return self::fromStart($desde);
    }

    /** Jornada que ya cerró justo antes de $moment — la que hay que resumir. */
    public static function previous(\DateTimeImmutable $moment): self
    {
        $actual = self::containing($moment);

        return self::fromStart((new \DateTimeImmutable($actual->desde))->modify('-1 day'));
    }

    private static function fromStart(\DateTimeImmutable $desde): self
    {
        $hasta = $desde->modify('+1 day');

        return new self($desde->format('Y-m-d'), $desde->format('Y-m-d H:i:s'), $hasta->format('Y-m-d H:i:s'));
    }
}
