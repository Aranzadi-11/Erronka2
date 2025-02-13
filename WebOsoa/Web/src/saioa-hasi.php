<?php
session_start();
include 'dbKonexioa.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    
    $sql = "SELECT * FROM erabiltzaileak WHERE Erabiltzailea = :Erabiltzailea";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(['Erabiltzailea' => $username]);
    $user = $stmt->fetch();

    if ($user && password_verify($password, $user['Pasahitza'])) {
        $_SESSION['erabiltzailea'] = $user['Erabiltzailea'];
        $_SESSION['saskia'] = [];
        header("Location: index.php");
        exit();
    } else {
        $error = "Erabiltzaile izena edo pasahitza okerrak.";
    }
}
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Saioa Hasi</title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <h2>Saioa Hasi</h2>
    <?php if (isset($error)) { echo "<p style='color: black;'>$error</p>"; } ?>
    <form action="saioa-hasi.php" method="POST">
        <label for="username">Erabiltzaile izena:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Pasahitza:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Saioa Hasi</button>
    </form>
    <p>Ez daukazu konturik? <a href="erregistroa.php">Erregistratu hemen</a></p>
    <p><a href="index.php">Itzuli hasierako orrira</a></p>
</body>
</html>
