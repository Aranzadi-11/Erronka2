package erronka2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Datu-baseko taulen datuak eskuratu eta JTable objektu bat osatu
public class Kontsulta {

    //Aukeratutako taularen datuak eskuratzen ditu eta JTable bidez erakusten ditu
    public static JTable lortuTaulenDatuak(String taulaIzena) {
        DefaultTableModel modeloa = new DefaultTableModel();
        JTable taula = new JTable(modeloa);

        //Konexioa ezarri ondoren aukeratutako taularen datuak eskuratzen ditu
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             Statement stmt = konexioa.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + taulaIzena)) {

            int zutabeKop = rs.getMetaData().getColumnCount();
            // Zutabe izenak gehitzen dira
            for (int i = 1; i <= zutabeKop; i++) {
                modeloa.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Errenkada bakoitza modeloari gehitu
            while (rs.next()) {
                Object[] errenkada = new Object[zutabeKop];
                for (int i = 0; i < zutabeKop; i++) {
                    errenkada[i] = rs.getObject(i + 1);
                }
                modeloa.addRow(errenkada);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return taula;
    }
}
