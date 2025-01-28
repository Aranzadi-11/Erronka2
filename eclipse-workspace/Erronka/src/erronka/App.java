package erronka;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App frame = new App();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public App() {
        setTitle("Base de Datos - Erronka2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnLangileak = new JButton("Mostrar Langileak");
        btnLangileak.setBounds(20, 20, 200, 30);
        contentPane.add(btnLangileak);

        JButton btnProduktuak = new JButton("Mostrar Produktuak");
        btnProduktuak.setBounds(20, 60, 200, 30);
        contentPane.add(btnProduktuak);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(20, 100, 200, 30);
        contentPane.add(btnCerrar);

        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(250, 20, 320, 300);
        contentPane.add(panelTabla);
        panelTabla.setLayout(new BorderLayout());

        btnLangileak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTable table = Kontsulta.getTableData("langileak");
                panelTabla.removeAll();
                panelTabla.add(new JScrollPane(table), BorderLayout.CENTER);
                panelTabla.revalidate();
                panelTabla.repaint();
            }
        });

        btnProduktuak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTable table = Kontsulta.getTableData("produktuak");
                panelTabla.removeAll();
                panelTabla.add(new JScrollPane(table), BorderLayout.CENTER);
                panelTabla.revalidate();
                panelTabla.repaint();
            }
        });

        btnCerrar.addActionListener(e -> System.exit(0));
    }
}
