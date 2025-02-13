<form method="post">
    <select name="selectedLang">
        <option value="en" <?php
        if (isset($_POST["selectedLang"]) && $_POST["selectedLang"] == "en") {
            echo "selected";
        } else {
            if (isset($_SESSION["_LANGUAGE"]) &&$_SESSION["_LANGUAGE"] == "en") {
                    echo "selected";
            }
        }
        ?>>EN
        </option>

        <!-- PHPko logika honekin formularioan zein hizkuntza agertzen den aukeratuta erabakiko dugu -->
        <option value="eus" <?php
        //formulariotik aukeratutako hizkuntza euskara bada
        if (isset($_POST["selectedLang"]) && $_POST["selectedLang"] == "eus") {
            echo "selected";
        }
        //formulariotik ez bada hizkuntzarik aukeratu eta sesioan euskara badago
        else if (!isset($_POST["selectedLang"]) && isset($_SESSION["_LANGUAGE"]) && $_SESSION["_LANGUAGE"] == "eus") {
            echo "selected";
        }
        ?>> EUS</option>
        <option value="es" <?php
        //formulariotik aukeratutako hizkuntza gaztelera bada
        if (isset($_POST["selectedLang"]) && $_POST["selectedLang"] == "es") {
            echo "selected";
        }
        //formulariotik ez bada hizkuntzarik aukeratu eta sesioan gaztelera badago
        else if (!isset($_POST["selectedLang"]) && isset($_SESSION["_LANGUAGE"]) && $_SESSION["_LANGUAGE"] == "es") {
            echo "selected";
        }
        ?>> ES</option>
    </select>
    <button>Aldatu</button>
</form>