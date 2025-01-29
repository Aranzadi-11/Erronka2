package erronka; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class DBKonexioa { 

    // Datu-basearekin konektatzeko beharrezko datuak definitzen ditugu
    private static final String URL = "jdbc:mysql://localhost:3306/erronka2"; // Datu-basearen helbidea eta izena
    private static final String USER = "root"; // Datu-basearen erabiltzailea
    private static final String PASSWORD = ""; // Datu-basearen pasahitza (hutsa kasu honetan)

    public static Connection getConnection() throws SQLException { 
        return DriverManager.getConnection(URL, USER, PASSWORD); // Datu-basearekin konexioa ezartzen du eta itzultzen du
    }
}
