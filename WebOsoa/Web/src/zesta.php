<?php
session_start();
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zure Saskia</title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <header>
        <h1>Zure Saskia</h1>
        <nav>
            <ul>
                <li><a href="index.php">Hasiera</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
        <section>
            <h2>Saskian dauden produktuak</h2>
            <ul>
                <?php
                if (empty($_SESSION['saskia'])) {
                    echo "<p>Zure saskia hutsik dago.</p>";
                } else {
                    // Mostrar los productos en la cesta
                    foreach ($_SESSION['saskia'] as $item) {
                        echo "<div class='produktua'>";
                        echo "<h3>" . htmlspecialchars($item['izena']) . "</h3>";
                        if (isset($item['Argazkia_URL'])) {
                            echo "<img src='" . htmlspecialchars($item['Argazkia_URL']) . "' alt='" . htmlspecialchars($item['izena']) . "' width='200' height='200'>";
                        } else {
                            echo "<p>Argazkia ez dago eskuragarri.</p>";
                        }
                        echo "<p>Prezioa: " . htmlspecialchars($item['prezioa']) . "€</p>";
                        echo "</div>";
                    }
                }
                ?>
            </ul>
            <form method="POST">
                <button type="submit" name="garbitu">Saskia Garbitu</button>
            </form>
        </section>
    </main>

    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['garbitu'])) {
        // Vaciar la cesta
        $_SESSION['saskia'] = [];
        // Redirigir a la misma página para reflejar el cambio
        echo "<script>
                window.location.href = 'zesta.php';
            </script>"; 
    }
    ?>

    <footer>
        <p>&copy; 2025 Denda Informatikoa - Eskubide guztiak erreserbatuta</p>
    </footer>
</body>
</html>