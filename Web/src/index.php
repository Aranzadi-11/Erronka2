<?php
session_start(); // Asegúrate de iniciar la sesión

include 'dbKonexioa.php';

// Comprobar si ya existe la cesta en la sesión, si no, inicializarla
if (!isset($_SESSION['saskia'])) {
    $_SESSION['saskia'] = [];
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['gehitu'])) {
    if (!isset($_SESSION['erabiltzailea'])) {
        header("Location: saioa-hasi.php");
        exit();
    }
    $izena = $_POST['izena'];
    $prezioa = $_POST['prezioa'];
    $argazkia = $_POST['Argazkia_URL'];
    $_SESSION['saskia'][] = ['izena' => $izena, 'prezioa' => $prezioa, 'Argazkia_URL' => $argazkia];
}

?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABE TECHNOLOGY</title>
    <link rel="stylesheet" href="../public/styles.css">
    <script src="script.js" defer></script>
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
            <label for="filtratu">Filtratu:</label>
            <select id="filtratu">
                <option value="izena">Izena</option>
                <option value="prezioa">Prezioa</option>
            </select>
            <div id="produktuak">
                <?php include 'produktuak.php'; ?>
            </div>
        </section>

        <div id="saskia-popup" class="saskia-gordea">
            <ul id="saskia-zerrenda">
                <?php
                // Mostrar los productos en la cesta
                foreach ($_SESSION['saskia'] as $item) {
                    echo "<li>{$item['izena']} - {$item['prezioa']}€</li>";
                }
                ?>
            </ul>
        </div>
    </main>

    <footer>
        <p>&copy; ABE TECHNOLOGY - Eskubide gustiak erreserbatuta</p>
    </footer>
</body>
</html>
