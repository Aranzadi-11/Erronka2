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
    private int saiakerak = 0; // Saiakeren kontadorea

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                //Datu-basearekin konektatzen saiatu
                Connection conn = DBKonexioa.getConnection();
                if (conn != null) {
                    conn.close();
                    // konexioa egiten bada login-a agertu
                    Login frame = new Login();
                    frame.setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Datu-basearekin konektatzean akats bat gertatu da: " + e.getMessage(), 
                    "Akatsa", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });
    }

    public Login() {
        setTitle("SAIOA HASI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 400, 300); // leihoaren kokapena eta dimentsioak

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new java.awt.GridLayout(6, 5, 30, 10));
        setContentPane(contentPane);

        // Erabiltzaile izena sartzeo gelaxka
        contentPane.add(new JLabel("Erabiltzailea:"));
        txtErabiltzailea = new JTextField();
        contentPane.add(txtErabiltzailea);

        // Erabiltzailearen pasahitza sartzeko gelaxka
        contentPane.add(new JLabel("Pasahitza:"));
        txtPasahitza = new JPasswordField();
        contentPane.add(txtPasahitza);

        // Log-in egiteko botoia
        JButton btnLogin = new JButton("Login egin");
        contentPane.add(btnLogin);

        // Login botoiaren akzioen konfigurazioa
        btnLogin.addActionListener(e -> {
            String erabiltzailea = txtErabiltzailea.getText(); // Textu modukoa izateko formatua
            String pasahitza = new String(txtPasahitza.getPassword()); // Pasahitz moduan agertzeko formatua

            // "langileak" taulan SQL kontsulta eginez, lortu login egin duen langilearen beharrezko informazioa
            String[] erabiltzaileDatuak = egiaztatu(erabiltzailea, pasahitza);

            if (erabiltzaileDatuak != null) {
                String izena = erabiltzaileDatuak[0];
                String abizena = erabiltzaileDatuak[1];
                String mota = erabiltzaileDatuak[2];

                // Ongi etorri mezua erakutsi
                JOptionPane.showMessageDialog(this, 
                        "Ongi etorri, " + izena + " " + abizena + "! " + mota + " zara.", 
                        "Ongi Etorri", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();  // Login frame-a itxi

                // App frame-a ireki, eta parametro bezala "Langile_Mota" bidali
                appIreki(mota);
            } else {
                saiakerak++;
                if (saiakerak >= 3) {
                    JOptionPane.showMessageDialog(this, 
                        "3 saiakera okerrak egin dituzu. Programa itxi egingo da.", 
                        "Akatsa", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Erabiltzailea edo pasahitza okerrak. " + saiakerak + "/3", 
                        "Akatsa", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Langilearen informazioa lortzeko metodoa
    private String[] egiaztatu(String erabiltzailea, String pasahitza) { 
        String sql = "SELECT Izena, Abizena, Langile_Mota FROM langileak WHERE Erabiltzailea = ? AND Pasahitza = ?";
        try (Connection conn = DBKonexioa.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
        	//Gelaxkan sartutako datuak, taulan daudenekin alderatu
            pstmt.setString(1, erabiltzailea);
            pstmt.setString(2, pasahitza);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	//Datuak ondo badaude, langile horren datu gehiago lortu ondoren ongietorri mezuan agertzeko
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

    //App clasea ireki langile mota kontuan hartuz
    private void appIreki(String mota) {
        EventQueue.invokeLater(() -> {
            try {
                App frame = new App(mota);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

