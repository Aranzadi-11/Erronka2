<?php
session_start();
include 'dbKonexioa.php'; 
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
      <?php
      if(empty($_SESSION['saskia'])){
          echo "<p>Zure saskia hutsik dago.</p>";
      } else {
          $productosAgrupados = [];
          foreach($_SESSION['saskia'] as $item){
              $clave = $item['izena'];
              if(!isset($productosAgrupados[$clave])){
                  $productosAgrupados[$clave] = $item;
                  $productosAgrupados[$clave]['cantidad'] = 1;
              } else {
                  $productosAgrupados[$clave]['cantidad']++;
              }
          }
          $totalGeneral = 0;
          ?>
          <table>
            <thead>
              <tr>
                <th>Argazkia</th>
                <th>Izena</th>
                <th>Kopurua</th>
                <th>Prezioa (kopurua × prezioa)</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach($productosAgrupados as $producto):
                      $subtotal = floatval($producto['prezioa']) * $producto['cantidad'];
                      $totalGeneral += $subtotal;
              ?>
                <tr>
                  <td>
                    <?php if(isset($producto['Argazkia_URL'])): ?>
                      <img src="<?php echo htmlspecialchars($producto['Argazkia_URL']); ?>" alt="<?php echo htmlspecialchars($producto['izena']); ?>">
                    <?php else: ?>
                      <p>Argazkia ez dago</p>
                    <?php endif; ?>
                  </td>
                  <td><?php echo htmlspecialchars($producto['izena']); ?></td>
                  <td><?php echo htmlspecialchars($producto['cantidad']); ?></td>
                  <td><?php echo number_format($subtotal,2,',','.'); ?>€</td>
                </tr>
              <?php endforeach; ?>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="3" style="text-align:right;">Guztira:</td>
                <td><?php echo number_format($totalGeneral,2,',','.'); ?>€</td>
              </tr>
            </tfoot>
          </table>
          <?php
      }
      ?>
      <form method="POST">
        <button class="garbitu-btn" type="submit" name="garbitu">Saskia Garbitu</button>
        <button class="erosi-btn" type="submit" name="erosi">Erosi</button>
      </form>
    </section>
  </main>
  <?php
  if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['garbitu'])){
      $_SESSION['saskia'] = [];
      echo "<script>window.location.href = 'zesta.php';</script>";
  }

  // Logika erosketarako
  if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['erosi'])){
      if(!empty($_SESSION['saskia'])){
          $erabiltzailea = $_SESSION['erabiltzailea'];
          $queryErabiltzaile = "SELECT ID FROM erabiltzaileak WHERE Erabiltzailea = ?";
          $stmt = $conn->prepare($queryErabiltzaile);
          $stmt->bind_param("s", $erabiltzailea);
          $stmt->execute();
          $result = $stmt->get_result();
          $row = $result->fetch_assoc();
          $idErabiltzailea = $row['ID'];

          foreach($productosAgrupados as $producto){
              $izena = $producto['izena'];
              $queryProduktua = "SELECT ID FROM stock WHERE Izena = ?";
              $stmt = $conn->prepare($queryProduktua);
              $stmt->bind_param("s", $izena);
              $stmt->execute();
              $result = $stmt->get_result();
              $row = $result->fetch_assoc();
              $idProduktua = $row['ID'];

              $kantitatea = $producto['cantidad'];
              $prezioa = floatval($producto['prezioa']) * $kantitatea;
              $data = date('Y-m-d');

              $queryInsert = "INSERT INTO eskaerak (ID_Erabiltzailea, ID_Produktua, Eskaera_Data, Kantitatea, Prezioa) VALUES (?, ?, ?, ?, ?)";
              $stmt = $conn->prepare($queryInsert);
              $stmt->bind_param("iisid", $idErabiltzailea, $idProduktua, $data, $kantitatea, $prezioa);
              $stmt->execute();
          }

          $_SESSION['saskia'] = [];
          echo "<script>alert('Erosketa arrakastatsua izan da!'); window.location.href = 'zesta.php';</script>";
      }
  }
  ?>
  <footer>
    <p>&copy; 2025 Denda Informatikoa - Eskubide guztiak erreserbatuta</p>
  </footer>
</body>
</html>
