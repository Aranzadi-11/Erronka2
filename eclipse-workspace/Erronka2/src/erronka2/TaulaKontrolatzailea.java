package erronka2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaulaKontrolatzailea {

    private JTable taula;
    private DBEkintzak Ekintzak;
    private TaulaPanela taulaPanela;  
    // Operazio panela (botoiak) gordetzeko instantzia aldagaia
    private JPanel operazioPanela;

    // Sortzailea
    public TaulaKontrolatzailea() {
        Ekintzak = new DBEkintzak();
    }

    //Taula eguneratu eta operazio panela berriz gehitu.

    private void taulaEguneratu(String taulaIzena) {
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);
        taulaPanela.ezarriTaula(taula);
        // Operazio panela existitzen bada eta osagaiak baditu, berriz gehitu
        if (operazioPanela != null && operazioPanela.getComponentCount() > 0) {
            taulaPanela.gehituOperazioPanela(operazioPanela);
        }
    }

    //Taula kargatu eta taularen arabera ekintzak gehitzeko metodoa.

    public void kargatuTaula(String taulaIzena, TaulaPanela taulaPanela) {
        this.taulaPanela = taulaPanela;
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);
        taulaPanela.ezarriTaula(taula);

        // Operazio panela sortu 
        operazioPanela = new JPanel(new FlowLayout());

        // Taula-ren arabera botoiak sortu
        switch (taulaIzena) {
            // "erabiltzaileak" eta "hornitzaileak": eguneratu eta ezabatu
            case "erabiltzaileak":
            case "hornitzaileak":
                JButton btnEguneratu = new JButton("Erregistroa Eguneratu");
                btnEguneratu.setBackground(new Color(255, 200, 0));
                btnEguneratu.setForeground(Color.BLACK);
                btnEguneratu.addActionListener(e -> eguneratuErregistroa(taulaIzena));
                operazioPanela.add(btnEguneratu);

                JButton btnEzabatu = new JButton("Erregistroa Ezabatu");
                btnEzabatu.setBackground(new Color(255, 200, 0));
                btnEzabatu.setForeground(Color.BLACK);
                btnEzabatu.addActionListener(e -> ezabatuErregistroa(taulaIzena));
                operazioPanela.add(btnEzabatu);
                break;
            // "eskaerak": PDF deskargatzeko botoia
            case "eskaerak":
                JButton btnPDFDeskargatu = new JButton("PDF Deskargatu");
                btnPDFDeskargatu.setBackground(new Color(255, 200, 0));
                btnPDFDeskargatu.setForeground(Color.BLACK);
                btnPDFDeskargatu.addActionListener(e -> pdfDeskargatu());
                operazioPanela.add(btnPDFDeskargatu);
                break;
            // "langileak" eta "stock": gehitu, eguneratu eta ezabatu
            case "langileak":
            case "stock":
                JButton btnGehitu = new JButton("Erregistroa Gehitu");
                btnGehitu.setBackground(new Color(255, 200, 0));
                btnGehitu.setForeground(Color.BLACK);
                btnGehitu.addActionListener(e -> gehituErregistroa(taulaIzena));
                operazioPanela.add(btnGehitu);

                JButton btnEguneratu2 = new JButton("Erregistroa Eguneratu");
                btnEguneratu2.setBackground(new Color(255, 200, 0));
                btnEguneratu2.setForeground(Color.BLACK);
                btnEguneratu2.addActionListener(e -> eguneratuErregistroa(taulaIzena));
                operazioPanela.add(btnEguneratu2);

                JButton btnEzabatu2 = new JButton("Erregistroa Ezabatu");
                btnEzabatu2.setBackground(new Color(255, 200, 0));
                btnEzabatu2.setForeground(Color.BLACK);
                btnEzabatu2.addActionListener(e -> ezabatuErregistroa(taulaIzena));
                operazioPanela.add(btnEzabatu2);
                break;
            default:
                break;
        }

        // Operazio panela gehitu taulaPanela-ra, osagaiak badaude
        if (operazioPanela.getComponentCount() > 0) {
            taulaPanela.gehituOperazioPanela(operazioPanela);
        }
    }

    //PDF deskargatzeko metodoa, erabiltzaile eta Eskaera_Data aukeratu ondores

    private void pdfDeskargatu() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel lblUser = new JLabel("ID_Erabiltzailea:");
        JComboBox<String> cmbUser = new JComboBox<>();
        JLabel lblDate = new JLabel("Eskaera_Data:");
        JComboBox<String> cmbDate = new JComboBox<>();

        // Erabiltzaileak lortzeko SQL kontsulta
        try (Connection conn = DBKonexioa.lortuKonexioa();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DISTINCT ID_Erabiltzailea FROM eskaerak")) {
            while (rs.next()) {
                String userId = rs.getString("ID_Erabiltzailea");
                cmbUser.addItem(userId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erabiltzaileak kargatzerakoan hurrengo akatsa gertatu da: " + ex.getMessage());
            return;
        }

        cmbUser.addActionListener(e -> {
            cmbDate.removeAllItems();
            String selectedUser = (String) cmbUser.getSelectedItem();
            if (selectedUser != null) {
                try (Connection conn = DBKonexioa.lortuKonexioa();
                     PreparedStatement pstmt = conn.prepareStatement(
                             "SELECT DISTINCT Eskaera_Data FROM eskaerak WHERE ID_Erabiltzailea = ?")) {
                    pstmt.setString(1, selectedUser);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String date = rs.getString("Eskaera_Data");
                            cmbDate.addItem(date);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Eskaera_Data kargatzerakoan hurrengo akatsa gertatu da: " + ex.getMessage());
                }
            }
        });
        if (cmbUser.getItemCount() > 0) {
            cmbUser.setSelectedIndex(0);
        }

        panel.add(lblUser);
        panel.add(cmbUser);
        panel.add(lblDate);
        panel.add(cmbDate);

        int aukera = JOptionPane.showConfirmDialog(null, panel, "Eskaera aukeraketa", JOptionPane.OK_CANCEL_OPTION);
        if (aukera == JOptionPane.OK_OPTION) {
            String selectedUser = (String) cmbUser.getSelectedItem();
            String selectedDate = (String) cmbDate.getSelectedItem();
            if (selectedUser == null || selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Erabiltzaile eta Eskaera_Data bat aukeratu behar dituzu!!!");
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Faktura Sortu");
            int erabAukera = fileChooser.showSaveDialog(null);
            if (erabAukera == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                
                if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }
                boolean arrakastatsua = PdfSortzailea.generatePDF(selectedUser, selectedDate, fileToSave);
                if (arrakastatsua) {
                    JOptionPane.showMessageDialog(null, "Faktura PDF formatuan gorde da: " 
                            + fileToSave.getAbsolutePath() + " helbidean.");
                } else {
                    JOptionPane.showMessageDialog(null, "Faktua sortzen akatsa!!!");
                }
            }
        }
    }

    //Erregistroak gehitzeko metodoa.

    private void gehituErregistroa(String taulaIzena) {
        DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();
        String[] zutabeIzenak;
        if (taulaIzena.equals("langileak")) {
            zutabeIzenak = new String[]{"ID", "Izena", "Abizena", "Langile_Mota"};
        } else {
            int kop = modeloa.getColumnCount();
            zutabeIzenak = new String[kop];
            for (int i = 0; i < kop; i++) {
                zutabeIzenak[i] = taula.getColumnName(i);
            }
        }

        JPanel sarreraPanela = new JPanel(new GridLayout(zutabeIzenak.length, 2, 5, 5));
        JTextField[] eremuak = new JTextField[zutabeIzenak.length];
        for (int i = 0; i < zutabeIzenak.length; i++) {
            sarreraPanela.add(new JLabel(zutabeIzenak[i] + ":"));
            eremuak[i] = new JTextField();
            sarreraPanela.add(eremuak[i]);
        }

        int emaitza = JOptionPane.showConfirmDialog(null, sarreraPanela,
                "Erregistroa gehitu '" + taulaIzena + "'", JOptionPane.OK_CANCEL_OPTION);
        if (emaitza == JOptionPane.OK_OPTION) {
            String[] balioak = new String[zutabeIzenak.length];
            for (int i = 0; i < zutabeIzenak.length; i++) {
                balioak[i] = eremuak[i].getText().trim();
            }
            boolean arrakastatsua = Ekintzak.erregistroaGehitu(taulaIzena, zutabeIzenak, balioak);
            JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa gehituta." : "Akatsa erregistroa gehitzean.");
            // Taula eguneratu eta botoiak berriz gehitu
            taulaEguneratu(taulaIzena);
        }
    }

    //Erregistroak eguneratzeko metodoa.

    private void eguneratuErregistroa(String taulaIzena) {
        int aukeratutakoErrenkada = taula.getSelectedRow();
        if (aukeratutakoErrenkada == -1) {
            JOptionPane.showMessageDialog(null, "Aukeratu erregistroa eguneratzeko, mesedez.",
                    "Erregistroa eguneratu", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();

        if (taulaIzena.equals("langileak")) {
            String[] onartutakoZutabeak = {"ID", "Izena", "Abizena", "Langile_Mota"};
            int idZutabeIndex = modeloa.findColumn("ID");
            Object originalID = taula.getValueAt(aukeratutakoErrenkada, idZutabeIndex);

            JPanel sarreraPanela = new JPanel(new GridLayout(onartutakoZutabeak.length, 2, 5, 5));
            List<String> eguneratuZutabeak = new ArrayList<>();
            List<String> eguneratuBalioak = new ArrayList<>();

            for (String col : onartutakoZutabeak) {
                int colIndex = modeloa.findColumn(col);
                Object unekoBalioa = taula.getValueAt(aukeratutakoErrenkada, colIndex);
                sarreraPanela.add(new JLabel(col + ":"));
                JTextField eremu = new JTextField(unekoBalioa != null ? unekoBalioa.toString() : "");
                sarreraPanela.add(eremu);
                eguneratuZutabeak.add(col);
                eguneratuBalioak.add("");
            }

            int emaitza = JOptionPane.showConfirmDialog(null, sarreraPanela,
                    "Erregistroa eguneratu (giltza: " + originalID + ")", JOptionPane.OK_CANCEL_OPTION);
            if (emaitza == JOptionPane.OK_OPTION) {
                Component[] osagaiak = sarreraPanela.getComponents();
                eguneratuBalioak.clear();
                for (int i = 1; i < osagaiak.length; i += 2) {
                    if (osagaiak[i] instanceof JTextField) {
                        eguneratuBalioak.add(((JTextField) osagaiak[i]).getText().trim());
                    }
                }
                boolean arrakastatsua = Ekintzak.erregistroaEguneratu(taulaIzena, "ID", originalID.toString(),
                        eguneratuZutabeak.toArray(new String[0]),
                        eguneratuBalioak.toArray(new String[0]));
                JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa eguneratuta." : "Akatsa erregistroa eguneratzean.");
                // Taula eguneratu eta botoiak berriz gehitu
                taulaEguneratu(taulaIzena);
            }
        } else {
            int kop = modeloa.getColumnCount();
            String giltzaZutabe = taula.getColumnName(0);
            Object giltzaBalio = taula.getValueAt(aukeratutakoErrenkada, 0);

            JPanel sarreraPanela = new JPanel(new GridLayout(kop - 1, 2, 5, 5));
            List<String> eguneratuZutabeak = new ArrayList<>();
            List<String> eguneratuBalioak = new ArrayList<>();

            for (int i = 1; i < kop; i++) {
                String zutabeIzena = taula.getColumnName(i);
                Object unekoBalioa = taula.getValueAt(aukeratutakoErrenkada, i);
                sarreraPanela.add(new JLabel(zutabeIzena + ":"));
                JTextField eremu = new JTextField(unekoBalioa != null ? unekoBalioa.toString() : "");
                sarreraPanela.add(eremu);
                eguneratuZutabeak.add(zutabeIzena);
                eguneratuBalioak.add("");
            }

            int emaitza = JOptionPane.showConfirmDialog(null, sarreraPanela,
                    "Erregistroa eguneratu (giltza: " + giltzaBalio + ")", JOptionPane.OK_CANCEL_OPTION);
            if (emaitza == JOptionPane.OK_OPTION) {
                Component[] osagaiak = sarreraPanela.getComponents();
                eguneratuBalioak.clear();
                for (int i = 1; i < osagaiak.length; i += 2) {
                    if (osagaiak[i] instanceof JTextField) {
                        eguneratuBalioak.add(((JTextField) osagaiak[i]).getText().trim());
                    }
                }
                boolean arrakastatsua = Ekintzak.erregistroaEguneratu(taulaIzena, giltzaZutabe, giltzaBalio.toString(),
                        eguneratuZutabeak.toArray(new String[0]),
                        eguneratuBalioak.toArray(new String[0]));
                JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa eguneratuta." : "Akatsa erregistroa eguneratzean.");
                // Taula eguneratu eta botoiak berriz gehitu
                taulaEguneratu(taulaIzena);
            }
        }
    }

    //Erregistroak ezabatzeko metodoa.

    private void ezabatuErregistroa(String taulaIzena) {
        int aukeratutakoErrenkada = taula.getSelectedRow();
        if (aukeratutakoErrenkada == -1) {
            JOptionPane.showMessageDialog(null, "Aukeratu ezabatzeko erregistroa, mesedez.",
                    "Ezabatu", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String giltzaZutabe = taula.getColumnName(0);
        Object giltzaBalio = taula.getValueAt(aukeratutakoErrenkada, 0);

        int baieztapen = JOptionPane.showConfirmDialog(null,
                giltzaZutabe + " " + giltzaBalio + " duen erregistro ezabatu nahi duzula seguru zaude?",
                "Ziurtagarria", JOptionPane.YES_NO_OPTION);
        if (baieztapen != JOptionPane.YES_OPTION) {
            return;
        }

        boolean arrakastatsua = Ekintzak.erregistroaEzabatu(taulaIzena, giltzaZutabe, giltzaBalio.toString());
        JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa ezabatuta." : "Akatsa erregistroa ezabatzean.");
        // Taula eguneratu eta botoiak berriz gehitu
        taulaEguneratu(taulaIzena);
    }
}

