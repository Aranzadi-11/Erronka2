package erronka;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App extends JFrame {

    private JPanel contentPane;  // Panel Nagusia
    private JPanel menuPanel;    // Menuko botoiak gordetzen dituen panela
    private JPanel tablePanel;   // Taula bistaratzen den panela
    private String mota;         // Erabiltzaile mota (Login klasetik ekarrita langile motaren arabera)
    
    public App(String mota) {
        this.mota = mota;
        setTitle("Datu-base kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 850, 500);
        
        // Panel nagusia bistaratu
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        
        // Menu panela ezkerrean agertu
        menuPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        
        // "Administratzailea" bada, gehitu menuan "langileak" botoia
        if (mota.equals("Administratzailea")) {
            JButton btnLangileak = new JButton("Langileak");
            btnLangileak.addActionListener(e -> loadTable("langileak"));
            menuPanel.add(btnLangileak);
        }
        
        // Beste taulen botoiak beti bestaratu
        JButton btnStock = new JButton("Stock-a");
        btnStock.addActionListener(e -> loadTable("stock"));
        menuPanel.add(btnStock);
        
        JButton btnEmailea = new JButton("Emailea");
        btnEmailea.addActionListener(e -> loadTable("emailea"));
        menuPanel.add(btnEmailea);
        
        JButton btnErabiltzaileak = new JButton("Erabiltzaileak");
        btnErabiltzaileak.addActionListener(e -> loadTable("erabiltzaileak"));
        menuPanel.add(btnErabiltzaileak);
        
        JButton btnEskaerak = new JButton("Eskaerak");
        btnEskaerak.addActionListener(e -> loadTable("eskaerak"));
        menuPanel.add(btnEskaerak);
        
        // Gehitu "Irten" botoia, aplikazioa amaitzeko
        JButton btnIrten = new JButton("Irten");
        btnIrten.addActionListener(e -> System.exit(0));
        menuPanel.add(btnIrten);
        
        // Menu panela ezkerrean gehitu
        contentPane.add(menuPanel, BorderLayout.WEST);
        
        // Taula panela sortu erdialdean
        tablePanel = new JPanel(new BorderLayout());
        contentPane.add(tablePanel, BorderLayout.CENTER);
        
        // Lehenik eta behin, kargatu "Stock-a" taula bezala default
        loadTable("stock");
    }

    private void loadTable(String tableName) {
        JTable table = Kontsulta.getTaulenDatuak(tableName);
        tablePanel.removeAll();  // Lehenengo, kendu aurreko eduki guztiak
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);  // Gehitu taula berria scroll-panearekin
        tablePanel.revalidate();  // Eguneratu panela
        tablePanel.repaint();     // Berriz margotu panela
    }
}

