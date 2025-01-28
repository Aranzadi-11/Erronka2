package erronka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Kontsulta {

    public static JTable getTableData(String tableName) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        try (Connection conn = DBKonexioa.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {

            int columnCount = rs.getMetaData().getColumnCount();

            // Añadir columnas al modelo
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Añadir filas al modelo
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }
}
