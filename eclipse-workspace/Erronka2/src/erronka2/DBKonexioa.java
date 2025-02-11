package erronka2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Datu basearekin konexioaren konfigurazioa

public class DBKonexioa {
    private static final String URL = "jdbc:mysql://localhost:3306/erronka2"; //Datu basearen IP eta izena
    private static final String ERABILTZAILEA = "root"; // Datu basearen erabiltzailea
    private static final String PASAHITZA = ""; // Datu basearen pasahitza

    public static Connection lortuKonexioa() throws SQLException {
        return DriverManager.getConnection(URL, ERABILTZAILEA, PASAHITZA); // Datu basearekin konexioa
    }
}