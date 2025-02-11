package erronka2;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    private int saiakerak = 0; //Saiakeren kontagailua

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

    // Login-aren konstruktorea
    public Login() {
        setTitle("SAIOA HASI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250); // Leihoaren tamaina
        setLocationRelativeTo(null); // Leihoaren kokapena

        // Hasierako panelaren konfigurazioa BorderLayout-rekin
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 165, 0)); // Naranja kolorea atzekalderako


        // Header-aren kolorea eta textua
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK); // Beltz kolorea ezarri
        JLabel headerLabel = new JLabel("ONGI ETORRI!"); //ONGI ETORRI mezua
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24)); //Letraren tamaina, estiloa eta negritaz
        headerLabel.setForeground(Color.WHITE); //Letraren kolorea
        headerPanel.add(headerLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Login-a betetzeko gelaxken kokapena
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Erabiltzailea sartzeko gelaxkaren eta ondoko textuaren konfigurazioa
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
        lblErabiltzailea.setFont(new Font("Arial", Font.PLAIN, 14));
        lblErabiltzailea.setForeground(Color.BLACK); // Textua beltza
        formPanel.add(lblErabiltzailea, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtErabiltzailea = new JTextField(15);
        formPanel.add(txtErabiltzailea, gbc);

     // Pasahitza sartzeko gelaxkaren eta ondoko textuaren konfigurazioa
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel lblPasahitza = new JLabel("Pasahitza:");
        lblPasahitza.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPasahitza.setForeground(Color.BLACK); // Textua beltza
        formPanel.add(lblPasahitza, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtPasahitza = new JPasswordField(15);
        formPanel.add(txtPasahitza, gbc);


        //Saioa hasteko botoiaren konfigurazioa
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSaioaHasi = new JButton("Saioa hasi");
        btnSaioaHasi.setBackground(Color.BLACK); // Atzeko kolorea beltza
        btnSaioaHasi.setForeground(Color.WHITE); // Letraren izena txuria
        btnSaioaHasi.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(btnSaioaHasi, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);

        btnSaioaHasi.addActionListener(e -> saioaHasi());
    }

    // Leihoa kargatzen duen bakoitzean erdialdean agertzeko setVisible sortu
    @Override
    public void setVisible(boolean b) {
        if (b) {
            setLocationRelativeTo(null);
        }
        super.setVisible(b);
    }

    private void saioaHasi() {
        String erabiltzailea = txtErabiltzailea.getText();
        String pasahitza = new String(txtPasahitza.getPassword());
        
        //Datuak ondo dauden jakiteko egiaztatu funtzioari deitzen dio
        String[] erabiltzaileDatuak = egiaztatu(erabiltzailea, pasahitza);

        if (erabiltzaileDatuak != null) {
            String izena = erabiltzaileDatuak[0];
            String abizena = erabiltzaileDatuak[1];
            String mota = erabiltzaileDatuak[2];
            
            //Datuak ondo badaude hurrengo mezua agertuko zaio eta aplikazioa irekiko zaio langile_motaren arabera
            JOptionPane.showMessageDialog(this, 
                "Ongi etorri, " + izena + " " + abizena + "! " + mota + " zara.", 
                "Ongi etorri", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();  

            // Aplikazio-a ireki Login-a ondo egiten bada
            EventQueue.invokeLater(() -> new APP(mota).setVisible(true));
        } else {
            saiakerak++;
            if (saiakerak >= 3) { //Saiakerak 3 edo 3 baino gehiago badira
                JOptionPane.showMessageDialog(this, 
                    "3 saiakera okerrak egin dituzu. Programa itxi egingo da.", 
                    "Akatsa", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else { //Saiakerak 3 baino gutxiago badira
                JOptionPane.showMessageDialog(this, 
                    "Erabiltzailea edo pasahitza okerrak. " + saiakerak + "/3", 
                    "Akatsa", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

  //Sartu duen erabiltzailea eta pasahitza ondo daudela ziurtatzen duen funtzioa 
    private String[] egiaztatu(String erabiltzailea, String pasahitza) {  
    	//Datu baseko "langileak" taulan erabiltzailea eta pashitza jarrita, horren Izena, Abizena eta Langile_Mota lortzen ditu
        String sql = "SELECT Izena, Abizena, Langile_Mota FROM langileak WHERE Erabiltzailea = ? AND Pasahitza = ?";
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql)) {
        	//Konexioa egiten saiatzen da eta dautak egiaztatzen ditu
            pstmt.setString(1, erabiltzailea);
            pstmt.setString(2, pasahitza);
            ResultSet rs = pstmt.executeQuery();
            //Datuak ondo badaude, horren izena, abizena eta langile_mota lortzen ditu ondoren erabiltzeko
            if (rs.next()) {
                return new String[]{rs.getString("Izena"), rs.getString("Abizena"), rs.getString("Langile_Mota")};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
