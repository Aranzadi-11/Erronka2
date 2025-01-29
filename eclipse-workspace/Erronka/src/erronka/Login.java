package erronka;

import java.awt.EventQueue;
import java.awt.GridLayout;
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
                // Datu-basearekin konektatzen saiatzen gara
                Connection conn = DBKonexioa.getConnection();
                if (conn != null) {
                    conn.close(); // Konektatuta egon bada, itxi
                    Login frame = new Login();
                    frame.setVisible(true); // Login leihoa bistaratzen da
                }
            } catch (Exception e) {
                // Datu-basearekin konektatzean errore bat gertatzen bada
                JOptionPane.showMessageDialog(null, "Datu-basearekin konektatzen saiatzeko akats bat gertatu da: " + e.getMessage(), "Akatsa", JOptionPane.ERROR_MESSAGE);
                System.exit(1); // Programaren exekuzioa gelditzen da
            }
        });
    }

    public Login() {
        setTitle("SAIOA SARTU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 400, 300); // Leihoaren tamaina eta kokapena
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(6, 5, 30, 10)); // Layout-a definitzen dugu
        setContentPane(contentPane);

        contentPane.add(new JLabel("Erabiltzailea:"));
        txtErabiltzailea = new JTextField();
        contentPane.add(txtErabiltzailea); // Erabiltzailearen sarrera

        contentPane.add(new JLabel("Pasahitza:"));
        txtPasahitza = new JPasswordField();
        contentPane.add(txtPasahitza); // Pasahitzaren sarrera

        JButton btnLogin = new JButton("Sartu");
        contentPane.add(btnLogin); // Sartu botoia

        // Sartu botoian ekintza bat gehitzen dugu
        btnLogin.addActionListener(e -> {
            String erabiltzailea = txtErabiltzailea.getText();
            String pasahitza = new String(txtPasahitza.getPassword());

            // Egiaztatu erabiltzailea eta pasahitza
            if (egiaztatu(erabiltzailea, pasahitza)) {
                // Login arrakastatsua bada
                JOptionPane.showMessageDialog(this, "Saioa sartzea arrakastatsua", "Arrakasta", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Login leihoa itxi
                appIreki(); // Aplikazioa ireki
            } else {
                saiakerak++; // Saiakera bat gehiago egin da
                // Saiakera okerrak kontrolatzen ditugu
                if (saiakerak >= 3) {
                    JOptionPane.showMessageDialog(this, "3 saiakera okerrak egin dituzu. Programa itxi egingo da.", "Akatsa", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // 3 saiakera okerrak, programa itxi
                } else {
                    // Saiakera okerra izan bada, erabiltzaileari abisua ematen diogu
                    JOptionPane.showMessageDialog(this, "Erabiltzailea edo pasahitza okerrak. "+saiakerak+"/3", "Akatsa", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean egiaztatu(String erabiltzailea, String pasahitza) {
        String sql = "SELECT * FROM langileak WHERE Erabiltzailea = ? AND Pasahitza = ?";
        try (Connection conn = DBKonexioa.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, erabiltzailea); // Erabiltzailea prestatzen dugu
            pstmt.setString(2, pasahitza); // Pasahitza prestatzen dugu
            ResultSet rs = pstmt.executeQuery(); // Datu-basea kontsultatzea

            return rs.next(); // Saioa aurkitzen bada, true itzuli

        } catch (Exception e) {
            e.printStackTrace();
            return false; // Akats bat gertatzen bada, false itzuli
        }
    }

    private void appIreki() {
        EventQueue.invokeLater(() -> {
            try {
                // Aplikazioa irekitzen da
                App frame = new App();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
