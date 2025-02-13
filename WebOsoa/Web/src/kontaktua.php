<?php
session_start(); 
include 'dbKonexioa.php'; 

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $enpresaIzena = $_POST['enpresaIzena'];
    $produktua = $_POST['produktua'];
    $produktuarenDeskripzioa = $_POST['produktuarenDeskripzioa'];
    $dohaintzarenEguna = $_POST['dohaintzarenEguna'];

    if (empty($enpresaIzena) || empty($produktua) || empty($produktuarenDeskripzioa) || empty($dohaintzarenEguna)) {
        $error = "Datu guztiak beharrezkoak dira.";
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
    <title>Hornitzaileak Kudeatu</title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <header>
        <h1>Hornitzaileak</h1>
        <nav>
            <ul>
                <li><a href="index.php">Hasiera</a></li>
                <li><a href="produktoak.php">Produktuak</a></li>
                <li><a href="logout.php">Log Out</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h2>Hornitzailea Gehitu</h2>
        <?php if (isset($error)) { echo "<p style='color:red;'>$error</p>"; } ?>
        <form method="POST" action="hornitzailea.php">
            <label for="enpresaIzena">Enpresa Izena:</label>
            <input type="text" name="enpresaIzena" required>
            <label for="produktua">Produktua:</label>
            <input type="text" name="produktua" required>
            <label for="produktuarenDeskripzioa">Produktuaren Deskripzioa:</label>
            <input type="text" name="produktuarenDeskripzioa" required>
            <label for="dohaintzarenEguna">Dohaintzaren Eguna:</label>
            <input type="date" name="dohaintzarenEguna" required>
            <button type="submit">Gehitu</button>
        </form>
    </main>
</body>
</html>
