package erronka2;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    private int saiakerak = 0; // Saiakeren kopurua hasieran

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Connection konexioa = DBKonexioa.lortuKonexioa();
                if (konexioa != null) {
                    konexioa.close();
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

    // Login-a egiteko agertuko den leihoaren konfigurazioa
    public Login() {
        setTitle("SAIOA HASI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 400, 300);

        JPanel edukia = new JPanel();
        edukia.setLayout(new java.awt.GridLayout(9, 5, 30, 10));
        setContentPane(edukia);

        edukia.add(new JLabel("Erabiltzailea:"));
        txtErabiltzailea = new JTextField();
        edukia.add(txtErabiltzailea);

        edukia.add(new JLabel("Pasahitza:"));
        txtPasahitza = new JPasswordField();
        edukia.add(txtPasahitza);

        JButton btnSaioaHasi = new JButton("Saioa hasi");
        edukia.add(btnSaioaHasi);

        btnSaioaHasi.addActionListener(e -> saioaHasi());
    }

    private void saioaHasi() {
        String erabiltzailea = txtErabiltzailea.getText();
        String pasahitza = new String(txtPasahitza.getPassword());

        String[] erabiltzaileDatuak = egiaztatu(erabiltzailea, pasahitza);

        if (erabiltzaileDatuak != null) {
            String izena = erabiltzaileDatuak[0];
            String abizena = erabiltzaileDatuak[1];
            String mota = erabiltzaileDatuak[2];

            JOptionPane.showMessageDialog(this, 
                "Ongi etorri, " + izena + " " + abizena + "! " + mota + " zara.", 
                "Ongi etorri", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();  

            // Aplikazioa ireki
            EventQueue.invokeLater(() -> new APP(mota).setVisible(true));
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
    }

    private String[] egiaztatu(String erabiltzailea, String pasahitza) { 
        String sql = "SELECT Izena, Abizena, Langile_Mota FROM langileak WHERE Erabiltzailea = ? AND Pasahitza = ?";
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql)) {
            pstmt.setString(1, erabiltzailea);
            pstmt.setString(2, pasahitza);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new String[]{rs.getString("Izena"), rs.getString("Abizena"), rs.getString("Langile_Mota")};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
