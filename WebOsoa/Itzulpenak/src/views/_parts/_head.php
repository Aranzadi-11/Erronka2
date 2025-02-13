<?php
define('APP_DIR', value: $_SERVER['DOCUMENT_ROOT'] . '/ML/Itzulpenak'); //Aplikazioaren karpeta edozein lekutatik atzitzeko.
define('HREF_VIEWS_DIR', '/ML/Itzulpenak/src/views'); //Aplikazioaren views karpeta edozein lekutatik deitzeko

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- TODO: BEGIRATU APP_DIR EDO HREF_VIEWS_DIR -->
    <link rel="stylesheet" href="<?php echo APP_DIR; ?>/public/css/main.css">
    <!-- APP_DIR erabilita main.css atzitu dugu -->
</head>

<body>

    <?php
    require_once(APP_DIR . "/src/translations/translations.php"); //APP_DIR erabilita itzulpenen dokumentua atzitu dugu.
    ?>

    <div class="grid">
        <div class="grid-elem">
            <a href="<?= HREF_VIEWS_DIR . '/indexPage.php' ?>">Index</a>
            <a href="<?= HREF_VIEWS_DIR . '/mainPage.php' ?>">MainPage</a>
        </div>