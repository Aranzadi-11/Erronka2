<?php
session_start(); // Iniciar sesión al principio

if (!isset($_SESSION['saskia'])) {
    $_SESSION['saskia'] = [];
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $izena = $_POST['izena'] ?? '';
    $argazkia = $_POST['argazkia'] ?? '';
    $prezioa = $_POST['prezioa'] ?? '';

    if (!empty($izena) && !empty($prezioa)) {
        // Añadir el producto a la cesta
        $_SESSION['saskia'][] = [
            'Izena' => $izena,
            'Argazkia_URL' => $argazkia,
            'Prezioa' => $prezioa
        ];
        echo "Produktua saskira gehitu da!";
    } else {
        echo "Errorea: datuak falta dira!";
    }
}

// Esto es solo para depuración, puede eliminarse después
echo "<pre>";
print_r($_SESSION);
echo "</pre>";
?>
