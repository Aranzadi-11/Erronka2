<?php
session_start(); 
include 'dbKonexioa.php'; 

if (!defined('APP_DIR')) {
    define('APP_DIR', __DIR__);  
  }
  

  require_once APP_DIR . '/itzulpenak/translations.php';
  

  if (isset($_POST['selectedLang'])) {
 
    $valid_languages = ['eus', 'en'];
    $lang = in_array($_POST['selectedLang'], $valid_languages) ? $_POST['selectedLang'] : 'eus'; 
    $_SESSION["_LANGUAGE"] = $lang; 
  } else {
 
    $lang = $_SESSION["_LANGUAGE"] ?? 'eus';
  }
  

  $translations = require __DIR__ . "/itzulpenak/" . $lang . ".php"; 

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $enpresaIzena = $_POST['enpresaIzena'];
    $produktua = $_POST['produktua'];
    $produktuarenDeskripzioa = $_POST['produktuarenDeskripzioa'];
    $dohaintzarenEguna = $_POST['dohaintzarenEguna'];

    if (empty($enpresaIzena) || empty($produktua) || empty($produktuarenDeskripzioa) || empty($dohaintzarenEguna)) {
        $error = $translations['Datu guztiak beharrezkoak dira.'];
    } else {
        $sql = "INSERT INTO hornitzaileak (Enpresa_Izena, Produktua, Produktuaren_Deskripzioa, Dohaintzaren_Eguna) 
                VALUES (:Enpresa_Izena, :Produktua, :Produktuaren_Deskripzioa, :Dohaintzaren_Eguna)";
        $stmt = $pdo->prepare($sql);
        $stmt->execute([
            'Enpresa_Izena' => $enpresaIzena,
            'Produktua' => $produktua,
            'Produktuaren_Deskripzioa' => $produktuarenDeskripzioa,
            'Dohaintzaren_Eguna' => $dohaintzarenEguna
        ]);
        
        header("Location: index.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $translations['Hornitzaileak Kudeatu']; ?></title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <header>
        <h1><?php echo $translations['Hornitzaileak']; ?></h1>
        <nav>
            <ul>
                <li><a href="index.php"><?php echo $translations['Hasiera']; ?></a></li>
                <li><a href="produktoak.php"><?php echo $translations['Produktuak']; ?></a></li>
                <li><a href="logout.php"><?php echo $translations['Log Out']; ?></a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h2><?php echo $translations['Hornitzailea Gehitu']; ?></h2>
        <?php if (isset($error)) { echo "<p style='color:red;'>$error</p>"; } ?>
        <form method="POST" action="hornitzailea.php">
            <label for="enpresaIzena"><?php echo $translations['Enpresa Izena']; ?>:</label>
            <input type="text" name="enpresaIzena" required>
            <label for="produktua"><?php echo $translations['Produktua']; ?>:</label>
            <input type="text" name="produktua" required>
            <label for="produktuarenDeskripzioa"><?php echo $translations['Produktuaren Deskripzioa']; ?>:</label>
            <input type="text" name="produktuarenDeskripzioa" required>
            <label for="dohaintzarenEguna"><?php echo $translations['Dohaintzaren Eguna']; ?>:</label>
            <input type="date" name="dohaintzarenEguna" required>
            <button type="submit"><?php echo $translations['Gehitu']; ?></button>
        </form>
    </main>
</body>
</html>
