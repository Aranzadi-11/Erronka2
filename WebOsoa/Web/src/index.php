<?php
session_start(); // Asegúrate de iniciar la sesión

include 'dbKonexioa.php';

// Comprobar si ya existe la cesta en la sesión, si no, inicializarla
if (!isset($_SESSION['saskia'])) {
    $_SESSION['saskia'] = [];
}

// Filtrado por nombre y precio
$bilatu = isset($_GET['bilatu']) ? $_GET['bilatu'] : '';
$filtratu = isset($_GET['filtratu']) ? $_GET['filtratu'] : '';

// Construir la consulta SQL según los filtros seleccionados
$sql = "SELECT * FROM stock WHERE Izena LIKE ?";
$params = ["%$bilatu%"];

if ($filtratu == 'asc') {
    $sql .= " ORDER BY Prezioa ASC";
} elseif ($filtratu == 'desc') {
    $sql .= " ORDER BY Prezioa DESC";
}

// Preparar y ejecutar la consulta
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $params[0]);
$stmt->execute();
$emaitza = $stmt->get_result();
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABE TECHNOLOGY</title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <header>
        <h1>ABE TECHNOLOGY</h1>
        <nav>
            <ul>
                <li class="dropdown">
                    <a href="#" class="dropbtn">Menu</a>
                    <div class="dropdown-content">
                        <a href="kontaktua.php">Kontaktua</a>
                    </div>
                </li>
                
                <li>
                    <a href="saioa-hasi.php"><img src="../public/login_icon.jpg" id="login-ikonoa" alt="Saioa Hasi" width="50" height="50"></a>
                </li>
                
                <li>
                    <a href="zesta.php"> <img src="../public/carrito.jpg" id="saskia-ikonoa" alt="Saskia" width="50" height="50"></a>
                    <span id="saskia-kopurua"><?php echo count($_SESSION['saskia']); ?></span>
                </li>
            </ul>
        </nav>
    </header>
    
    <main>
        <section>
            <h2>Denda Informatikoa</h2>
            <form method="GET" action="index.php">
                <label for="bilatu">Bilatu izenaren arabera:</label>
                <input type="text" id="bilatu" name="bilatu" placeholder="Produktuaren izena" value="<?php echo htmlspecialchars($bilatu); ?>">

                <label for="filtratu">Filtratu prezioaren arabera:</label>
                <select id="filtratu" name="filtratu">
                    <option value="">Aukeratu</option>
                    <option value="asc" <?php if ($filtratu == 'asc') echo 'selected'; ?>>Prezioa: Txikienetik handienera</option>
                    <option value="desc" <?php if ($filtratu == 'desc') echo 'selected'; ?>>Prezioa: Handienetik txikienera</option>
                </select>

                <button type="submit">Bilatu</button>
            </form>
            
            <div id="produktuak">
                <?php
                // Mostrar los productos filtrados
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
                    echo "<p>Ez dago produkturik zure irizpideekin.</p>";
                }
                ?>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; ABE TECHNOLOGY - Eskubide gustiak erreserbatuta</p>
    </footer>
</body>
</html>

<?php
$conn->close(); // Cerrar la conexión
?>
