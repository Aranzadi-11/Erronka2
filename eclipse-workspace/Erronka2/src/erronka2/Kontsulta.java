package erronka2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Kontsulta {

    // Taulatik datuak lortzen eta JTable-a sortzen duen metodoa
    public static JTable lortuTaulenDatuak(String taulaIzena) {
        DefaultTableModel modeloa = new DefaultTableModel();
        JTable taula = new JTable(modeloa);

        //Taularen koloreen konfigurazioa
        taula.setBackground(new Color(255, 255, 100)); // Taularen atzekaldeko kolorea
        taula.setForeground(Color.BLACK); //Taularen letren kolorea
        taula.setSelectionBackground(new Color(255, 200, 0)); 
        taula.setSelectionForeground(Color.BLACK); 
        
        taula.getTableHeader().setBackground(new Color(255, 165, 0)); // Taularen errekaden tituloaren atzealdeko kolorea
        taula.getTableHeader().setForeground(Color.BLACK); //Taularen errekaden tituloaren letren kolorea 

        //Taularen aukeraketaren ondoren, taula horren errenkaden tituloen izenak lortu eta bistaratu
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             Statement stmt = konexioa.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + taulaIzena)) {

            int zutabeKop = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= zutabeKop; i++) {
                modeloa.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Aukeratutako taulari errenkadak gehitu
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
