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
      </form>
    </section>
  </main>
  <?php
  if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['garbitu'])){
      $_SESSION['saskia'] = [];
      echo "<script>window.location.href = 'zesta.php';</script>";
  }
  ?>
  <footer>
    <p>&copy; 2025 Denda Informatikoa - Eskubide guztiak erreserbatuta</p>
  </footer>
</body>
</html>