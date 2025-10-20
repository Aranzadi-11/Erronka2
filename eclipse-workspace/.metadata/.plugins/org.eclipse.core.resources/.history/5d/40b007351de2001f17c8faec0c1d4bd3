package erronka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Kontsulta {

    public static JTable getTaulenDatuak (String tableName) {
        DefaultTableModel model = new DefaultTableModel(); // Taularen eredua sortu
        JTable table = new JTable(model); // JTable objektua sortu ereduarekin

        try (Connection conn = DBKonexioa.getConnection(); // Datu-basearekin konexioa ezarri
             Statement stmt = conn.createStatement(); // SQL kontsultak egiteko objektua sortu
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) { // Taulako datuak eskuratu

            int columnCount = rs.getMetaData().getColumnCount(); // Zutabe kopurua lortu
            
            // Zutabe izenak gehitu taularen ereduari
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Datuak errenkadatan gehitu
            while (rs.next()) {
                Object[] row = new Object[columnCount]; // Errenkada berria sortu
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1); // Zutabeko balioa lortu eta errenkadan gehitu
                }
                model.addRow(row); // Errenkada taularen ereduari gehitu
            }

        } catch (Exception e) {
            e.printStackTrace(); // Erroreak terminalean inprimatu
        }

        return table; // JTable objektua itzuli
    }
}
