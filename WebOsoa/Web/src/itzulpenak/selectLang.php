<form method="post">
    <select name="selectedLang" onchange="this.form.submit()"> <!-- Añadimos el evento 'onchange' para enviar automáticamente el formulario al seleccionar un idioma -->
        <option value="en" <?php
            if (isset($_POST["selectedLang"]) && $_POST["selectedLang"] == "en") {
                echo "selected";
            } else if (isset($_SESSION["_LANGUAGE"]) && $_SESSION["_LANGUAGE"] == "en") {
                echo "selected";
            }
        ?>>EN</option>

        <option value="eus" <?php
            if (isset($_POST["selectedLang"]) && $_POST["selectedLang"] == "eus") {
                echo "selected";
            } else if (!isset($_POST["selectedLang"]) && isset($_SESSION["_LANGUAGE"]) && $_SESSION["_LANGUAGE"] == "eus") {
                echo "selected";
            }
        ?>>EUS</option>
    </select>
    <!-- Botón 'Aldatu' ya no es necesario porque el formulario se enviará automáticamente cuando el usuario cambie el idioma -->
</form>
