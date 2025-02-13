<?php
session_start(); // Saioa bat hasten du
include 'dbKonexioa.php'; // Datu-basearekin konexioa egiten du

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Formularioaren datuak jasotzen ditu
    $enpresaIzena = $_POST['enpresaIzena'];
    $produktua = $_POST['produktua'];
    $produktuarenDeskripzioa = $_POST['produktuarenDeskripzioa'];
    $dohaintzarenEguna = $_POST['dohaintzarenEguna'];

    // Hutsik ez daudela balidatzen dugu
    if (empty($enpresaIzena) || empty($produktua) || empty($produktuarenDeskripzioa) || empty($dohaintzarenEguna)) {
        $error = "Datu guztiak beharrezkoak dira.";
    } else {
        // Datuak datu-basean txertatzen ditugu
        $sql = "INSERT INTO hornitzaileak (Enpresa_Izena, Produktua, Produktuaren_Deskripzioa, Dohaintzaren_Eguna) 
                VALUES (:Enpresa_Izena, :Produktua, :Produktuaren_Deskripzioa, :Dohaintzaren_Eguna)";
        $stmt = $pdo->prepare($sql);
        $stmt->execute([
            'Enpresa_Izena' => $enpresaIzena,
            'Produktua' => $produktua,
            'Produktuaren_Deskripzioa' => $produktuarenDeskripzioa,
            'Dohaintzaren_Eguna' => $dohaintzarenEguna
        ]);

        // Txertaketaren ondoren beste orri batera eraman
        header("Location: index.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8"> <!-- Karaktere multzoa definitzen du -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Pantaila tamainara egokitzen da -->
    <title>Hornitzaileak</title> <!-- Orrialdearen izenburua -->
    <link rel="stylesheet" href="../public/styles.css"> <!-- Estilo fitxategia lotzen du -->
</head>
<body>
    <header>
        <h1>Hornitzaileak</h1> <!-- Orrialdearen izenburua -->
        <nav>
            <ul>
                <li><a href="index.php">Hasiera</a></li> <!-- Hasiera orrira lotura -->
                <li><a href="zesta.php">Saskia</a></li> <!-- Saskia orrira lotura -->
            </ul>
        </nav>
    </header>
    
    <main>
        <section>
            <h2>Hornitzailearen Informazioa</h2> <!-- Atalaren izenburua -->
        </section>
        
        <section>
            <h2>Formularioa</h2> <!-- Atalaren izenburua -->
            <?php if (isset($error)) { echo "<p style='color: red;'>$error</p>"; } ?> <!-- Errorea badago, erakutsi -->
            <form action="kontaktua.php" method="post"> <!-- Formularioa -->
                <label for="enpresaIzena">Enpresa Izena:</label>
                <input type="text" id="enpresaIzena" name="enpresaIzena" required> <!-- Enpresa izena sarrera -->
                
                <label for="produktua">Produktua:</label>
                <input type="text" id="produktua" name="produktua" required> <!-- Produktua sarrera -->
                
                <label for="produktuarenDeskripzioa">Produktuaren Deskripzioa:</label>
                <textarea id="produktuarenDeskripzioa" name="produktuarenDeskripzioa" required></textarea> <!-- Produktuaren deskripzioa sarrera -->
                
                <label for="dohaintzarenEguna">Dohaintzaren Eguna:</label>
                <input type="date" id="dohaintzarenEguna" name="dohaintzarenEguna" required> <!-- Dohaintzaren eguna sarrera -->
                
                <button type="submit">Bidali</button> <!-- Bidali botoia -->
            </form>
        </section>
    </main>
</body>
</html>