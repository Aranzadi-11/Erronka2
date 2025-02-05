package erronka;

import javax.swing.*;
import java.awt.*;


public class App extends JFrame {

    private TaulaPanela taulaPanela;
    private TaulaKontrolatzailea kontrolatzailea;
    private String mota; // Loginetik jasotako erabiltzaile mota

    //Aplikazioaren eraikitzailea.
    public App(String mota) {
        this.mota = mota;
        setTitle("Datu-base kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 850, 500);

        JPanel edukia = new JPanel(new BorderLayout());
        setContentPane(edukia);

        //Kontrolatzailea sortu
        kontrolatzailea = new TaulaKontrolatzailea();

        // Menu panela sortu eta taula aukeraketa ezarri
        MenuPanela menuPanela = new MenuPanela(mota, taulaIzena -> kontrolatzailea.kargatuTaula(taulaIzena, taulaPanela));
        edukia.add(menuPanela, BorderLayout.WEST);

        // Taula eta operazioak erakusteko panela sortu
        taulaPanela = new TaulaPanela();
        edukia.add(taulaPanela, BorderLayout.CENTER);
    }
}
