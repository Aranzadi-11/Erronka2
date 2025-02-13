<?php
session_start();
include 'dbKonexioa.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirmPassword = $_POST['confirmPassword'];
    $name = $_POST['name']; 
    $lastname = $_POST['lastname']; 
    $birthdate = $_POST['birthdate']; 
    $address = $_POST['address']; 

    
    if (empty($name) || empty($lastname) || empty($birthdate) || empty($address)) {
        $error = "Datu guztiak beharrezkoak dira.";
    } elseif ($password !== $confirmPassword) {
        $error = "Pasahitzak ez dira bat etorri.";
    } else {
        $sql = "SELECT * FROM erabiltzaileak WHERE Erabiltzailea = :Erabiltzailea";
        $stmt = $pdo->prepare($sql);
        $stmt->execute(['Erabiltzailea' => $username]);
        $user = $stmt->fetch();

        if ($user) {
            $error = "Izen hau erabiltzen hari da.";
        } else {
            $hashedPassword = password_hash($password, PASSWORD_DEFAULT); 

            
            $sql = "INSERT INTO erabiltzaileak (Erabiltzailea, Pasahitza, Izena, Abizena, Jaiotze_Eguna, Helbidea) 
                    VALUES (:Erabiltzailea, :Pasahitza, :Izena, :Abizena, :Jaiotze_Eguna, :Helbidea)";
            $stmt = $pdo->prepare($sql);
            $stmt->execute([
                'Erabiltzailea' => $username, 
                'Pasahitza' => $hashedPassword,
                'Izena' => $name,  
                'Abizena' => $lastname,  
                'Jaiotze_Eguna' => $birthdate, 
                'Helbidea' => $address,  
            ]);

            $_SESSION['erabiltzailea'] = $username; 
            header("Location: index.php"); 
            exit();
        }
    }
}
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erregistroa</title>
    <link rel="stylesheet" href="../public/styles.css">
</head>
<body>
    <h2>Erregistratu</h2>
    <?php if (isset($error)) { echo "<p style='color: red;'>$error</p>"; } ?>
    <form action="erregistroa.php" method="POST">
    <label for="name">Izena:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="lastname">Abizena:</label>
    <input type="text" id="lastname" name="lastname" required><br>

    <label for="birthdate">Jaiotze Eguna:</label>
    <input type="date" id="birthdate" name="birthdate" required><br>

    <label for="address">Helbidea:</label>
    <input type="text" id="address" name="address" required><br>

    <label for="username">Erabiltzaile izena:</label>
    <input type="text" id="username" name="username" required><br>
    
    <label for="password">Pasahitza:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="confirmPassword">Berriro sartu pasahitza:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br>
    
    <button type="submit">Erregistratu</button>
</form>
    <p>Kontua ahal daukezu? <a href="saioa-hasi.php">Hemen login egin</a></p>
    <p><a href="index.php">Itzuli hasierako orrira</a></p>
</body>
</html>



