package erronka;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TaulaKontrolatzailea {

    private JTable taula;
    private DBEkintzak Ekintzak;

    //sortzailea
    public TaulaKontrolatzailea() {
    	Ekintzak = new DBEkintzak();
    }

    //Eskatutako taularen datuak erakusten ditu
    //Taula bakoitzean ekintza ezberdinak egin ahal dira, botoien bidez egingo direnak
    public void kargatuTaula(String taulaIzena, TaulaPanela taulaPanela) {
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);
        taulaPanela.ezarriTaula(taula);

        JPanel operazioPanela = new JPanel(new FlowLayout());

        switch (taulaIzena) {
            case "erabiltzaileak":
            case "hornitzaileak":
                JButton btnEguneratu = new JButton("Erregistroa Eguneratu");
                btnEguneratu.addActionListener(e -> eguneratuErregistroa(taulaIzena));
                operazioPanela.add(btnEguneratu);

                JButton btnEzabatu = new JButton("Erregistroa Ezabatu");
                btnEzabatu.addActionListener(e -> ezabatuErregistroa(taulaIzena));
                operazioPanela.add(btnEzabatu);
                break;
            case "eskaerak":
                break;
            case "langileak":
            case "stock":
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

    //Erregistroa gehitzeko funtzioa (datuak sartzeko agertuko den panela)
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
            JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa gehituta." : "Errorea erregistroa gehitzean.");
            berriroKargatuTaula(taulaIzena);
        }
    }

   // Erregistroak eguneratzeko funtzioa (datuak eguneratzeko agertuko den panelaren konfigurazioa)
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

        // Giltza nagusia erabili gabe (lehenengo zutabea) beste zutabeak eguneratzeko formularioa sortu
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
            // Dialogoan sartutako balio berriak eskuratu
            Component[] osagaiak = sarreraPanela.getComponents();
            eguneratuBalioak.clear();
            for (int i = 1; i < osagaiak.length; i += 2) {
                if (osagaiak[i] instanceof JTextField) {
                    eguneratuBalioak.add(((JTextField) osagaiak[i]).getText().trim());
                }
            }
            boolean arrakastatsua = Ekintzak.erregistroaEguneratu(taulaIzena, giltzaZutabe, giltzaBalio.toString(),
                    eguneratuZutabeak.toArray(new String[0]), eguneratuBalioak.toArray(new String[0]));
            JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa eguneratuta." : "Errorea erregistroa eguneratzean.");
            berriroKargatuTaula(taulaIzena);
        }
    }

    //Erregistroak ezabatzeko funtzioa (datuak ezabatzeko agertuko den formularioa)
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
        JOptionPane.showMessageDialog(null, arrakastatsua ? "Erregistroa ezabatuta." : "Errorea erregistroa ezabatzean.");
        berriroKargatuTaula(taulaIzena);
    }

    //Aukeratutako taula berriro kargatzen du eta ikuspegia eguneratzen du.

    private void berriroKargatuTaula(String taulaIzena) {
        taula = Kontsulta.lortuTaulenDatuak(taulaIzena);

    }
}
