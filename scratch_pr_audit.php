<?php

declare(strict_types=1);

$sicrePrPdo = new PDO('mysql:host=192.168.1.209;dbname=sicrePR;charset=latin1', 'kofuz01', 'Xcape15948');
$traficoDbPdo = new PDO('mysql:host=localhost;dbname=traficodb;charset=utf8mb4', 'servidor', 'password'); // or let's check config for traficodb connection in /home/servidor/trafico-system

echo "=== INSPECCIÓN TABLAS CON 'PR' O 'SOLICITUD' EN sicrePR ===" . PHP_EOL;
$sqlPr = "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'sicrePR' AND (TABLE_NAME LIKE '%pr%' OR TABLE_NAME LIKE '%solic%')";
$stmtPr = $sicrePrPdo->query($sqlPr);
print_r($stmtPr->fetchAll(PDO::FETCH_COLUMN));

