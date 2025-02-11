package erronka2;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MenuPanela extends JPanel {

    public MenuPanela(String mota, Consumer<String> taulaAukeratuCallback) {
        setLayout(new GridLayout(8, 1, 10, 10));
        setBackground(new Color(255, 165, 0)); //Atzealdeko kolorea naranja

        // Erregstratu den erabiltzailea "Administratzailea" bada "langileak" taula kudeatu ahal izango du
        if (mota.equals("Administratzailea")) {
            JButton btnLangileak = new JButton("Langileak");
            btnLangileak.setBackground(new Color(255, 200, 0));
            btnLangileak.setForeground(Color.BLACK);
            btnLangileak.addActionListener(e -> taulaAukeratuCallback.accept("langileak"));
            add(btnLangileak);
        }

     // "stock" taula kargatzen duen botoiaren konfigurazioa
        JButton btnStock = new JButton("Stock-a");
        btnStock.setBackground(new Color(255, 200, 0));
        btnStock.setForeground(Color.BLACK);
        btnStock.addActionListener(e -> taulaAukeratuCallback.accept("stock"));
        add(btnStock);

     // "hornitzaileak" taula kargatzen duen botoiaren konfigurazioa
        JButton btnEmailea = new JButton("Emailea");
        btnEmailea.setBackground(new Color(255, 200, 0));
        btnEmailea.setForeground(Color.BLACK);
        btnEmailea.addActionListener(e -> taulaAukeratuCallback.accept("hornitzaileak"));
        add(btnEmailea);

     // "erabiltzaileak" taula kargatzen duen botoiaren konfigurazioa
        JButton btnErabiltzaileak = new JButton("Erabiltzaileak");
        btnErabiltzaileak.setBackground(new Color(255, 200, 0));
        btnErabiltzaileak.setForeground(Color.BLACK);
        btnErabiltzaileak.addActionListener(e -> taulaAukeratuCallback.accept("erabiltzaileak"));
        add(btnErabiltzaileak);

        // "eskaerak" taula kargatzen duen botoiaren konfigurazioa
        JButton btnEskaerak = new JButton("Eskaerak");
        btnEskaerak.setBackground(new Color(255, 200, 0));
        btnEskaerak.setForeground(Color.BLACK);
        btnEskaerak.addActionListener(e -> taulaAukeratuCallback.accept("eskaerak"));
        add(btnEskaerak);

        // APP-a ixteko botoiaren konfigurazioa
        JButton btnIrten = new JButton("Irten");
        btnIrten.setBackground(Color.RED);
        btnIrten.setForeground(Color.BLACK);
        btnIrten.addActionListener(e -> System.exit(0));
        add(btnIrten);
    }
}
