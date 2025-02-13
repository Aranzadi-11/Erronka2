<?php
session_set_cookie_params(0); 
session_start();
include 'dbKonexioa.php';

// Definir APP_DIR y la sesión de idioma, si no lo has hecho ya
define('APP_DIR', __DIR__); // Esto define la raíz del proyecto

// Incluir la función de traducción
require_once APP_DIR . '/itzulpenak/translations.php';

// Verificar si el idioma fue enviado desde el formulario
if (isset($_POST['selectedLang'])) {
    // Validar que el idioma seleccionado es uno válido
    $valid_languages = ['eus', 'en'];
    $lang = in_array($_POST['selectedLang'], $valid_languages) ? $_POST['selectedLang'] : 'eus'; // Por defecto 'eus' si no es válido
    $_SESSION["_LANGUAGE"] = $lang;  // Guardamos el idioma seleccionado en la sesión
} else {
    // Si no se ha enviado ningún idioma desde el formulario, usamos el que está en la sesión
    $lang = $_SESSION["_LANGUAGE"] ?? 'eus';  // Valor por defecto es 'eus'
}

// Cargar traducciones
$translations = require __DIR__ . "/itzulpenak/" . $lang . ".php";  // Cargar el archivo de traducción según el idioma

// Verificar si el usuario está logueado
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

$bilatu = isset($_GET['bilatu']) ? $_GET['bilatu'] : '';
$filtratu = isset($_GET['filtratu']) ? $_GET['filtratu'] : '';

$sql = "SELECT * FROM stock WHERE Izena LIKE ?";
$params = ["%$bilatu%"];

if ($filtratu == 'asc') {
    $sql .= " ORDER BY Prezioa ASC";
} elseif ($filtratu == 'desc') {
    $sql .= " ORDER BY Prezioa DESC";
}

$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $params[0]);
$stmt->execute();
$emaitza = $stmt->get_result();
?>

<!DOCTYPE html>
<html lang="<?php echo $lang; ?>">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo trans('ABE TECHNOLOGY'); ?></title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <header>
        <h1><?php echo trans('ABE TECHNOLOGY'); ?></h1>
        <nav>
            <ul>
                <li class="dropdown">
                    <a href="#" class="dropbtn"><?php echo trans('Menu'); ?></a>
                    <div class="dropdown-content">
                        <a href="kontaktua.php"><?php echo trans('Contact'); ?></a>
                    </div>
                </li>

                <!-- Mostrar solo el botón correspondiente al idioma actual -->
                <li>
                    <form method="post">
                        <?php if ($lang == 'eus'): ?>
                            <!-- Si el idioma es Euskera, mostramos el botón para cambiar al inglés -->
                            <button type="submit" name="selectedLang" value="en">
                                <div class="language-flag">
                                    <img src="../public/uk_flag.png" alt="English" width="50" height="50">
                                </div>
                            </button>
                        <?php else: ?>
                            <!-- Si el idioma es inglés, mostramos el botón para cambiar al euskera -->
                            <button type="submit" name="selectedLang" value="eus">
                                <div class="language-flag">
                                    <img src="../public/ikurrina.png" alt="Euskera" width="50" height="50">
                                </div>
                            </button>
                        <?php endif; ?>
                    </form>
                </li>

                <li>
                    <a href="saioa-hasi.php">
                        <img src="../public/login_icon.jpg" id="login-ikonoa" alt="Saioa Hasi" width="50" height="50">
                    </a>
                </li>

                <li>
                    <a href="zesta.php">
                        <img src="../public/carrito.jpg" id="saskia-ikonoa" alt="Saskia" width="50" height="50">
                    </a>
                    <span id="saskia-kopurua"><?php echo count($_SESSION['saskia']); ?></span>
                </li>
            </ul>
        </nav>
    </header>
    
    <main>
        <section>
            <h2><?php echo trans('Denda Informatikoa'); ?></h2>
            <form method="GET" action="index.php">
                <label for="bilatu"><?php echo trans('Bilatu izenaren arabera'); ?>:</label>
                <input type="text" id="bilatu" name="bilatu" placeholder="<?php echo trans('Produktuaren izena'); ?>" value="<?php echo htmlspecialchars($bilatu); ?>">

                <label for="filtratu"><?php echo trans('Filtratu prezioaren arabera'); ?>:</label>
                <select id="filtratu" name="filtratu">
                    <option value=""><?php echo trans('Aukeratu'); ?></option>
                    <option value="asc" <?php if ($filtratu == 'asc') echo 'selected'; ?>><?php echo trans('Prezioa: Txikienetik handienera'); ?></option>
                    <option value="desc" <?php if ($filtratu == 'desc') echo 'selected'; ?>><?php echo trans('Prezioa: Handienetik txikienera'); ?></option>
                </select>

                <button type="submit"><?php echo trans('Bilatu'); ?></button>
            </form>
            
            <div id="produktuak">
                <?php
                if ($emaitza->num_rows > 0) {
                    while ($row = $emaitza->fetch_assoc()) {
                        echo "<div class='produktua'>";
                        echo "<h3>" . htmlspecialchars($row['Izena']) . "</h3>";
                        echo "<img src='" . htmlspecialchars($row['Argazkia_URL']) . "' alt='" . htmlspecialchars($row['Izena']) . "' width='200' height='200'>";
                        echo "<p>" . trans('Prezioa') . ": " . htmlspecialchars($row['Prezioa']) . "€</p>";
                        
                        echo "<form method='POST' action='index.php'>
                                <input type='hidden' name='izena' value='" . htmlspecialchars($row['Izena']) . "'>
                                <input type='hidden' name='prezioa' value='" . htmlspecialchars($row['Prezioa']) . "'>
                                <input type='hidden' name='Argazkia_URL' value='" . htmlspecialchars($row['Argazkia_URL']) . "'>
                                <button type='submit' name='gehitu'>" . trans('Gehitu Saskira') . "</button>
                              </form>";
                        echo "</div>";
                    }
                } else {
                    echo "<p>" . trans('Ez dago produkturik zure irizpideekin.') . "</p>";
                }
                ?>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; ABE TECHNOLOGY - <?php echo trans('Eskubide gustiak erreserbatuta'); ?></p>
    </footer>
</body>
</html>

<?php
$conn->close();
?>
