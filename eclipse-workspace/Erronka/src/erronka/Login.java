package erronka;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    private int saiakerak = 0; // Saiakeren kopurua hasieran

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // Datu-basearekin konektatzen saiatu
                Connection konexioa = DBKonexioa.lortuKonexioa();
                if (konexioa != null) {
                    konexioa.close();
                    // Konexioa egiten bada, saioa hasierako leihoa erakutsi
                    Login saioa = new Login();
                    saioa.setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Datu-basearekin konektatzean akats bat gertatu da: " + e.getMessage(), 
                    "Akatsa", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });
    }

    //Login-a egiteko agertuko den leihoaren konfigurazioa
    public Login() {
        setTitle("SAIOA HASI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 400, 300); // Leihoaren kokapena eta dimentsioak

        // Eduki panela sortu eta konfiguratu
        JPanel edukia = new JPanel();
        edukia.setLayout(new java.awt.GridLayout(9, 5, 30, 10));
        setContentPane(edukia);

        // Erabiltzaile izenaren sartzeko gelaxka
        edukia.add(new JLabel("Erabiltzailea:"));
        txtErabiltzailea = new JTextField();
        edukia.add(txtErabiltzailea);

        // Pasahitzaren sartzeko gelaxka
        edukia.add(new JLabel("Pasahitza:"));
        txtPasahitza = new JPasswordField();
        edukia.add(txtPasahitza);

        // Saioa hasteko botoia sortu
        JButton btnSaioaHasi = new JButton("Saioa hasi");
        edukia.add(btnSaioaHasi);

        // erabiltzailearen datuak egiaztatu eta saioa hasteko logika exekutatu
        btnSaioaHasi.addActionListener(e -> {
            String erabiltzailea = txtErabiltzailea.getText(); // Sartutako erabiltzaile izena
            String pasahitza = new String(txtPasahitza.getPassword()); // Sartutako pasahitza

            // "langileak" taulan, erregistratutako erabiltzailearen datuak lortu
            String[] erabiltzaileDatuak = egiaztatu(erabiltzailea, pasahitza);

            if (erabiltzaileDatuak != null) {
                String izena = erabiltzaileDatuak[0];
                String abizena = erabiltzaileDatuak[1];
                String mota = erabiltzaileDatuak[2];

                // Ongi etorri mezua erakutsi
                JOptionPane.showMessageDialog(this, 
                        "Ongi etorri, " + izena + " " + abizena + "! " + mota + " zara.", 
                        "Ongi etorri", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();  // Login leihoa itxi

                // Aplikazioa ireki, parametro bezala erabiltzaile mota bidali
                aplikazioaIreki(mota);
            } else { //Erabiltzailea edo pasahitza gaizki jarriz gero exekutatuko den kodea
                saiakerak++;
                if (saiakerak >= 3) { //Saiakerak 3 edo gehiago badira hurrengo mezua
                    JOptionPane.showMessageDialog(this, 
                        "3 saiakera okerrak egin dituzu. Programa itxi egingo da.", 
                        "Akatsa", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else { //Saiakerak 3 baino gutxiago badira, beste aukera bat eman erabiltzaileari, eta zenbat saiakera dijoan bestaratu
                    JOptionPane.showMessageDialog(this, 
                        "Erabiltzailea edo pasahitza okerrak. " + saiakerak + "/3", 
                        "Akatsa", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    //Erabiltzailearen datuak datu-basean egiaztatzen ditu
    private String[] egiaztatu(String erabiltzailea, String pasahitza) { 
        String sql = "SELECT Izena, Abizena, Langile_Mota FROM langileak WHERE Erabiltzailea = ? AND Pasahitza = ?";
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql)) {
            // Gelaxkan sartutako datuak, taulan daudenarekin alderatu
            pstmt.setString(1, erabiltzailea);
            pstmt.setString(2, pasahitza);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Datuak ondo badira, langilearen izena, abizena eta mota lortu
                String izena = rs.getString("Izena");
                String abizena = rs.getString("Abizena");
                String mota = rs.getString("Langile_Mota");
                return new String[]{izena, abizena, mota};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Aplikazioa irekitzen du, parametro bezala erabiltzaile mota jasota.
    //Erabiltzailearen mota erabiliko da aplikazioaren ikuspegia egokitzeko.
    private void aplikazioaIreki(String mota) {
        EventQueue.invokeLater(() -> {
            try {
                App aplikazioa = new App(mota);
                aplikazioa.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
