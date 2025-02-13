<?php
// Esta función debería estar en el archivo 'translations.php'
function trans($indexPhrase)
{
    // Itzulpen array-a sortzen da
    static $tranlationsArray = array();

    // Verificamos si el archivo de traducción existe
    if (file_exists(APP_DIR . '/itzulpenak/' . $_SESSION["_LANGUAGE"] . '.php')) {
        $url = APP_DIR . '/itzulpenak/';
        // Cargamos las traducciones
        $tranlationsArray = include($url . $_SESSION["_LANGUAGE"] . '.php');
    }

    // Verificamos si la traducción está disponible
    if (!array_key_exists($indexPhrase, $tranlationsArray)) {
        return $indexPhrase; // Si no existe, devolvemos la clave por defecto
    } else {
        return $tranlationsArray[$indexPhrase]; // Retornamos la traducción
    }
}
?>
