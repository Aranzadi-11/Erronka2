package erronka2;

import javax.swing.*;
import java.awt.*;

public class APP extends JFrame {

    private TaulaPanela taulaPanela;
    private TaulaKontrolatzailea kontrolatzailea;
    private String mota; // Loginetik jasotako erabiltzaile mota

    public APP(String mota) {
        this.mota = mota;
        setTitle("Datu-base kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLocationRelativeTo(null); //Pantaila erdialdean agertzeko konfigurazioa

        //Panel printzipala sortu
        JPanel edukia = new JPanel(new BorderLayout());
        setContentPane(edukia);

        // Taula kontrolatzailea sortu
        kontrolatzailea = new TaulaKontrolatzailea();

        // Menu laterala sortu eta koloreak ezarri
        MenuPanela menuPanela = new MenuPanela(mota, taulaIzena -> kontrolatzailea.kargatuTaula(taulaIzena, taulaPanela));
        menuPanela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        edukia.add(menuPanela, BorderLayout.WEST);

        // Menu zentrala sortu taulak bistaratzeko eta beraiekin egin ahal diren akzioak
        taulaPanela = new TaulaPanela();
        edukia.add(taulaPanela, BorderLayout.CENTER);
    }
}
