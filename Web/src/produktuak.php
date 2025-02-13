<?php
include 'dbKonexioa.php';

// Consultar productos desde la base de datos
$sql = "SELECT * FROM stock";
$emaitza = $conn->query($sql);

if ($emaitza->num_rows > 0) {
    while ($row = $emaitza->fetch_assoc()) {
        echo "<div class='produktua'>";
        echo "<h3>" . htmlspecialchars($row['Izena']) . "</h3>";
        echo "<img src='" . htmlspecialchars($row['Argazkia_URL']) . "' alt='" . htmlspecialchars($row['Izena']) . "' width='200' height='200'>";
        echo "<p>Prezioa: " . htmlspecialchars($row['Prezioa']) . "€</p>";
        
        // Formulario para agregar el producto a la cesta
        echo "<form method='POST' action='index.php'>
                <input type='hidden' name='izena' value='" . htmlspecialchars($row['Izena']) . "'>
                <input type='hidden' name='prezioa' value='" . htmlspecialchars($row['Prezioa']) . "'>
                <input type='hidden' name='Argazkia_URL' value='" . htmlspecialchars($row['Argazkia_URL']) . "'>
                <button type='submit' name='gehitu'>Gehitu Saskira</button>
              </form>";
        echo "</div>";
    }
} else {
    echo "<p>Ez dago produkturik.</p>";
}

$conn->close();
?>