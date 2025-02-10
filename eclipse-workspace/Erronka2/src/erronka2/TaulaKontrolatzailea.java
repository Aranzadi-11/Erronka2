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

    //Sortzailea
    public TaulaKontrolatzailea() {
        Ekintzak = new DBEkintzak();
    }

    //Aukeratutako taula kargatu eta taula horretan ezarritako botoiak kargatu
    public void kargatuTaula(String taulaIzena, TaulaPanela taulaPanela) {
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);
        taulaPanela.ezarriTaula(taula);

        JPanel operazioPanela = new JPanel(new FlowLayout());

        switch (taulaIzena) {
            case "erabiltzaileak":
            case "hornitzaileak":
            	//Erregistroak eguneratzeko eta ezabatzeko botoiak sortu
                JButton btnEguneratu = new JButton("Erregistroa Eguneratu");
                btnEguneratu.addActionListener(e -> eguneratuErregistroa(taulaIzena));
                operazioPanela.add(btnEguneratu);

                JButton btnEzabatu = new JButton("Erregistroa Ezabatu");
                btnEzabatu.addActionListener(e -> ezabatuErregistroa(taulaIzena));
                operazioPanela.add(btnEzabatu);
                break;
            case "eskaerak":
                //PDF-a sortzeko botoia jarri
                JButton btnDescargarPDF = new JButton("Descargar PDF");
                btnDescargarPDF.addActionListener(e -> descargarPDF());
                operazioPanela.add(btnDescargarPDF);
                break;
            case "langileak":
            case "stock":
            	//Erregistroak gehitzeko, eguneratzeko eta ezabatzeko botoiak sortu
                JButton btnGehitu = new JButton("Erregistroa Gehitu");
                btnGehitu.addActionListener(e -> gehituErregistroa(taulaIzena));
                operazioPanela.add(btnGehitu);

                JButton btnEguneratu2 = new JButton("Erregistroa Eguneratu");
                btnEguneratu2.addActionListener(e -> eguneratuErregistroa(taulaIzena));
                operazioPanela.add(btnEguneratu2);

                JButton btnEzabatu2 = new JButton("Erregistroa Ezabatu");
                btnEzabatu2.addActionListener(e -> ezabatuErregistroa(taulaIzena));
                operazioPanela.add(btnEzabatu2);
                break;
            default:
                break;
        }

        if (operazioPanela.getComponentCount() > 0) {
            taulaPanela.gehituOperazioPanela(operazioPanela);
        }
    }

    // PDF sortzeko metodoa ezarri erabiltzaileak aukeratzen duen egun eta erabiltzailea kontuan hartuz
    private void descargarPDF() {
        // Aukeraketa egiteko erabiliko den panelaren konfigurazioa
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel lblUser = new JLabel("ID_Erabiltzailea:");
        JComboBox<String> cmbUser = new JComboBox<>();
        JLabel lblDate = new JLabel("Eskaera_Data:");
        JComboBox<String> cmbDate = new JComboBox<>();

        // ID_Erabiltzailea errepikatu gabe aukeraketa egiteko zerrenfa sortu
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

        //Erabiltzailea bat aukeratzerakoan, erabiltzaile horren eskaera datak kargatzen dira bakarrik
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
        // Erabiltzaile bat aukeratuta badago Eskaera_Data kargatzea behartzen da
        if (cmbUser.getItemCount() > 0) {
            cmbUser.setSelectedIndex(0);
        }

        panel.add(lblUser);
        panel.add(cmbUser);
        panel.add(lblDate);
        panel.add(cmbDate);

        int option = JOptionPane.showConfirmDialog(null, panel, "Eskaera aukeraketa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String selectedUser = (String) cmbUser.getSelectedItem();
            String selectedDate = (String) cmbDate.getSelectedItem();
            if (selectedUser == null || selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Erabiltzaile eta Eskaera_Data bat aukeratau behar dezu!!!");
                return;
            }
            //PDF-a gordetzeko helbidea eskatzen zaio erabiltzaileari
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Faktura Sortu");
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                // .pdf extensioa gehitzen zaio
                if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }
                // Llamamos a la clase PDFGenerator para crear el PDF
                boolean success = PdfSortzailea.generatePDF(selectedUser, selectedDate, fileToSave);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Faktura PDF formatuan gorde da: " + fileToSave.getAbsolutePath() + "helbidean.");
                } else {
                    JOptionPane.showMessageDialog(null, "Faktua sortzen akatsa!!!");
                }
            }
        }
    }

    //Erregitroa gehitzeko funtzioa
   
    private void gehituErregistroa(String taulaIzena) {
        DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();
        int kop = modeloa.getColumnCount();
        String[] zutabeIzenak = new String[kop];
        for (int i = 0; i < kop; i++) {
            zutabeIzenak[i] = taula.getColumnName(i);
        }

        JPanel sarreraPanela = new JPanel(new GridLayout(kop, 2, 5, 5));
        JTextField[] eremua = new JTextField[kop];
        for (int i = 0; i < kop; i++) {
            sarreraPanela.add(new JLabel(zutabeIzenak[i] + ":"));
            eremua[i] = new JTextField();
            sarreraPanela.add(eremua[i]);
        }

        int emaitza = JOptionPane.showConfirmDialog(null, sarreraPanela,
                "Erregistroa gehitu '" + taulaIzena + "'", JOptionPane.OK_CANCEL_OPTION);
        if (emaitza == JOptionPane.OK_OPTION) {
            String[] balioak = new String[kop];
            for (int i = 0; i < kop; i++) {
                balioak[i] = eremua[i].getText().trim();
            }
            boolean arrakastatsua = Ekintzak.erregistroaGehitu(taulaIzena, zutabeIzenak, balioak);
            JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa gehituta." : "Akatsa erregistroa gehitzean.");
            berriroKargatuTaula(taulaIzena);
        }
    }
    //Erregistroa eguneratzeko funtzioa
    private void eguneratuErregistroa(String taulaIzena) {
        int aukeratutakoErrenkada = taula.getSelectedRow();
        if (aukeratutakoErrenkada == -1) {
            JOptionPane.showMessageDialog(null, "Aukeratu erregistroa eguneratzeko, mesedez.",
                    "Erregistroa eguneratu", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();
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
                    eguneratuZutabeak.toArray(new String[0]), eguneratuBalioak.toArray(new String[0]));
            JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa eguneratuta." : "Akatsa erregistroa eguneratzean.");
            berriroKargatuTaula(taulaIzena);
        }
    }
    // erregistroa ezabatzeko funtzioa
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
        berriroKargatuTaula(taulaIzena);
    }
    //Taula kargatzeko funtzioa
    private void berriroKargatuTaula(String taulaIzena) {
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);
    }
}
