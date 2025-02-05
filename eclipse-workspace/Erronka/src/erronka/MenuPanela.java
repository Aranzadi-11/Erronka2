package erronka;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;


public class MenuPanela extends JPanel {

    //Eraikitzailea.
    
    public MenuPanela(String mota, Consumer<String> taulaAukeratuCallback) {
        setLayout(new GridLayout(8, 1, 10, 10));

        // "Administratzailea" bada, "langileak" taula kudeatzeko aukera agertu
        if (mota.equals("Administratzailea")) {
            JButton btnLangileak = new JButton("Langileak");
            btnLangileak.addActionListener(e -> taulaAukeratuCallback.accept("langileak"));
            add(btnLangileak);
        }

      //Stock taulan sartzeko botoia
        JButton btnStock = new JButton("Stock-a");
        btnStock.addActionListener(e -> taulaAukeratuCallback.accept("stock"));
        add(btnStock);

      // Emaileen taulan sartzeko botoia
        JButton btnEmailea = new JButton("Emailea");
        btnEmailea.addActionListener(e -> taulaAukeratuCallback.accept("hornitzaileak"));
        add(btnEmailea);

      //Erabiltzaileak taulan sartzeko botoia
        JButton btnErabiltzaileak = new JButton("Erabiltzaileak");
        btnErabiltzaileak.addActionListener(e -> taulaAukeratuCallback.accept("erabiltzaileak"));
        add(btnErabiltzaileak);

        //Eskaera taulan sartzeko botoia
        JButton btnEskaerak = new JButton("Eskaerak");
        btnEskaerak.addActionListener(e -> taulaAukeratuCallback.accept("eskaerak"));
        add(btnEskaerak);
        
        //Irteteko botoia
        JButton btnIrten = new JButton("Irten");
        btnIrten.addActionListener(e -> System.exit(0));
        add(btnIrten);
    }
}
