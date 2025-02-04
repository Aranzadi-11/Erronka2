package erronka;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame {

    private JPanel contentPane;   // Panel printzipala
    private JPanel menuPanel;     // Menu laterala, bertan APP-tik irteteko eta tauletatik mugitzeko botoiak
    private JPanel tablePanel;    // Panel zentrala, bertan taulak eta taulak kudeatzeko botoiak daude
    private String mota;          // Langile_Mota, Login klasetik jasota
    private JTable currentTable;  // Bistaratzen ari den taula

    public App(String mota) {
        this.mota = mota;
        setTitle("Datu-base kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 850, 500);

        // panel printzipalaren konfigurazioa
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Tauletatik mugitzeko botoien menuaren kokapena
        menuPanel = new JPanel(new GridLayout(8, 1, 10, 10));

        // Langile_Mota "Administratzailea" bada, langileen taula kudeatzeko baimena eman
        if (mota.equals("Administratzailea")) {
            JButton btnLangileak = new JButton("Langileak");
            btnLangileak.addActionListener(e -> taulaKargatu("langileak"));
            menuPanel.add(btnLangileak);
        }

         // Stock-aren taula kargatzeko botoia 
        JButton btnStock = new JButton("Stock-a");
        btnStock.addActionListener(e -> taulaKargatu("stock"));
        menuPanel.add(btnStock);

     // Emaileen taula kargatzeko botoia
        JButton btnEmailea = new JButton("Emailea");
        btnEmailea.addActionListener(e -> taulaKargatu("hornitzaileak"));
        menuPanel.add(btnEmailea);

         // Erabiltzaileen taula kargatzeko botoia
        JButton btnErabiltzaileak = new JButton("Erabiltzaileak");
        btnErabiltzaileak.addActionListener(e -> taulaKargatu("erabiltzaileak"));
        menuPanel.add(btnErabiltzaileak);

        // Eskaeraren taula kargatzeko botoia
        JButton btnEskaerak = new JButton("Eskaerak");
        btnEskaerak.addActionListener(e -> taulaKargatu("eskaerak"));
        menuPanel.add(btnEskaerak);

        // APP-tik irteteko botoia
        JButton btnIrten = new JButton("Irten");
        btnIrten.addActionListener(e -> System.exit(0));
        menuPanel.add(btnIrten);

        // Panel printzipalean tauletatik mugitzeko aukera eman
        contentPane.add(menuPanel, BorderLayout.WEST);

        //Panel zentrala (Gehitu, Ezabatu eta Eguneratu botoiak + taula)
        tablePanel = new JPanel(new BorderLayout());
        contentPane.add(tablePanel, BorderLayout.CENTER);

    }

    //Aukeratutako taula kargatzeko metodoa
    private void taulaKargatu(String tableName) {
        // Aukeratutako taula bistaratu dituen datuekin eta taularen konfigurazioa inprimatu JFrame berri batean
        currentTable = Kontsulta.getTaulenDatuak(tableName);
        
        // Panel zentrala garbitu eta datu baseko taulan Scroll egiteko aukera ezarri
        tablePanel.removeAll();
        tablePanel.add(new JScrollPane(currentTable), BorderLayout.CENTER);

        // Gehitu, Ezabatu eta Eguneratu botoientzat panelaren konfigurazioa
        JPanel operationsPanel = new JPanel(new FlowLayout());

        //Taula bakoitzan egin ahal diren akzioak konfiguratu taldeka
        switch (tableName) {
            case "erabiltzaileak":
            case "hornitzaileak":
                // Datuak eguneratzeko eta ezabatzeko aukera
                JButton btnEguneratu = new JButton("Erregistroa Eguneratu");
                btnEguneratu.addActionListener(e -> erregistroaEguneratu(tableName));
                operationsPanel.add(btnEguneratu);

                JButton btnEzabatu = new JButton("Erregistroa Ezabatu");
                btnEzabatu.addActionListener(e -> erregistroaEzabatu(tableName));
                operationsPanel.add(btnEzabatu);
                break;
            case "eskaerak":
                // Datuak ikusteko aukera bakarrik
                break;
            case "langileak":
            case "stock":
                // Datuak gehitzeko, eguneratzeko eta ezabatzeko aukera
                JButton btnGehitu = new JButton("Erregistroa Gehitu");
                btnGehitu.addActionListener(e -> erregistroaGehitu(tableName));
                operationsPanel.add(btnGehitu);

                JButton btnEguneratu2 = new JButton("Erregistroa Eguneratu");
                btnEguneratu2.addActionListener(e -> erregistroaEguneratu(tableName));
                operationsPanel.add(btnEguneratu2);

                JButton btnEzabatu2 = new JButton("Erregistroa Ezabatu");
                btnEzabatu2.addActionListener(e -> erregistroaEzabatu(tableName));
                operationsPanel.add(btnEzabatu2);
                break;
            default:
                break;
        }

        if (operationsPanel.getComponentCount() > 0) {
            tablePanel.add(operationsPanel, BorderLayout.SOUTH);
        }

        tablePanel.revalidate();
        tablePanel.repaint();
    }

    //Aukeratutako taulan erregitro bat gehitzeko metodoa
    private void erregistroaGehitu(String tableName) {
        try (Connection conn = DBKonexioa.getConnection()) {
            // Aukeratutako taularen errenkada karagatu
            DefaultTableModel model = (DefaultTableModel) currentTable.getModel();
            int columnCount = model.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = currentTable.getColumnName(i);
            }

            // Errenakada bakoitzeko taula textu bat sortu
            JPanel inputPanel = new JPanel(new GridLayout(columnCount, 2, 5, 5));
            JTextField[] fields = new JTextField[columnCount];
            for (int i = 0; i < columnCount; i++) {
                inputPanel.add(new JLabel(columnNames[i] + ":"));
                fields[i] = new JTextField();
                inputPanel.add(fields[i]);
            }

            int result = JOptionPane.showConfirmDialog(this, inputPanel, 
                    "Erregistroa  gehitu '" + tableName + "'", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // INSERT kontsulta sortu
                StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
                StringBuilder placeholders = new StringBuilder();
                for (int i = 0; i < columnCount; i++) {
                    sql.append(columnNames[i]);
                    placeholders.append("?");
                    if (i < columnCount - 1) {
                        sql.append(", ");
                        placeholders.append(", ");
                    }
                }
                sql.append(") VALUES (").append(placeholders).append(")");

                try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                    for (int i = 0; i < columnCount; i++) {
                        pstmt.setString(i + 1, fields[i].getText().trim());
                    }
                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Erregistroa gehituta.");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Akats bat gertatu da erregistroa gehitzeko saiakeran: " + ex.getMessage());
        }
        // Taula eguneratu
        taulaKargatu(tableName);
    }

    //Datuak eguuneratzeko kontsulta
    private void erregistroaEguneratu(String tableName) {
        int selectedRow = currentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aukeratu ezazu eguneratu nahi duzun erregistroa, mesedez.", 
                    "Erregistro eguneratu", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = DBKonexioa.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) currentTable.getModel();
            int columnCount = model.getColumnCount();
            String primaryKeyColumn = currentTable.getColumnName(0);
            Object primaryKeyValue = currentTable.getValueAt(selectedRow, 0);

            // Panel bat sortu errenkada bakoitzarentzat gelaxkekin
            JPanel inputPanel = new JPanel(new GridLayout(columnCount - 1, 2, 5, 5));
            JTextField[] fields = new JTextField[columnCount - 1];
            for (int i = 1; i < columnCount; i++) {
                String colName = currentTable.getColumnName(i);
                Object currentValue = currentTable.getValueAt(selectedRow, i);
                inputPanel.add(new JLabel(colName + ":"));
                fields[i - 1] = new JTextField(currentValue != null ? currentValue.toString() : "");
                inputPanel.add(fields[i - 1]);
            }

            int result = JOptionPane.showConfirmDialog(this, inputPanel, 
                    "Modificar registro (clave " + primaryKeyValue + ")", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // UPDATE kontsulta sortu
                StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
                for (int i = 1; i < columnCount; i++) {
                    sql.append(currentTable.getColumnName(i)).append(" = ?");
                    if (i < columnCount - 1) {
                        sql.append(", ");
                    }
                }
                sql.append(" WHERE ").append(primaryKeyColumn).append(" = ?");

                try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                    for (int i = 1; i < columnCount; i++) {
                        pstmt.setString(i, fields[i - 1].getText().trim());
                    }
                    pstmt.setString(columnCount, primaryKeyValue.toString());
                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Erregistroa eguneratuta.");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Akats bat gertatu da erregistroa eguneratzekoo saiakeran: " + ex.getMessage());
        }
        // Taula eguneratu
        taulaKargatu(tableName);
    }

    //Erregistroak ezabatzeko metodo bat sortu
    private void erregistroaEzabatu(String tableName) {
        int selectedRow = currentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aukeratu ezazu ezabatu nahi duzun erregistroa, mesedez.", 
                    "EZABATU", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String primaryKeyColumn = currentTable.getColumnName(0);
        Object primaryKeyValue = currentTable.getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(this, // Ezabatu aurretik beste aukera bat eman nahi gabe egin bada
                  primaryKeyColumn + "  " + primaryKeyValue + " PrimaryKey duen erregistro ezabatu nahi duzula seguru zaude?",
                "ZIURTAGARRI MEZUA", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try (Connection conn = DBKonexioa.getConnection()) { //Erregistroa ezabatzeko kontsulta
            String sql = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumn + " = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, primaryKeyValue.toString());
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Erregistroa ezabatuta.");
                }
            }
        } catch (Exception ex) { //Akats bat gertzen bada, hurrengo mezua agertuko da
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Akats bat gertatu da erregistroa ezabatzerako saiakeran: " + ex.getMessage());
        }
        // Taula eguneratu
        taulaKargatu(tableName);
    }
}
