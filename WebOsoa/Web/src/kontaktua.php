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
    <title>Hornitzaileak</title> 
    <link rel="stylesheet" href="../public/styles.css"> 
</head>
<body>
    <header>
        <h1>Hornitzaileak</h1> 
        <nav>
            <ul>
                <li><a href="index.php">Hasiera</a></li> 
                <a href="zesta.php"> <img src="../public/carrito.jpg" id="saskia-ikonoa" alt="Saskia" width="50" height="50"></a>
            </ul>
        </nav>
    </header>
    
    <main>
        <section>
            <h2>Hornitzailearen Informazioa</h2> 
        </section>
        
        <section>
            <h2>Formularioa</h2> 
            <?php if (isset($error)) { echo "<p style='color: red;'>$error</p>"; } ?> 
            <form action="kontaktua.php" method="post"> 
                <label for="enpresaIzena">Enpresa Izena:</label>
                <input type="text" id="enpresaIzena" name="enpresaIzena" required> 
                
                <label for="produktua">Produktua:</label>
                <input type="text" id="produktua" name="produktua" required> 
                
                <label for="produktuarenDeskripzioa">Produktuaren Deskripzioa:</label>
                <textarea id="produktuarenDeskripzioa" name="produktuarenDeskripzioa" required></textarea> 
                
                <label for="dohaintzarenEguna">Dohaintzaren Eguna:</label>
                <input type="date" id="dohaintzarenEguna" name="dohaintzarenEguna" required> 
                
                <button type="submit">Bidali</button> 
            </form>
        </section>
    </main>
</body>
</html>