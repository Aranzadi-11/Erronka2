package erronka2;

import javax.swing.*;
import java.awt.*;

public class APP extends JFrame {

    private TaulaPanela taulaPanela;
    private TaulaKontrolatzailea kontrolatzailea;
    private String mota; // Loginetik jasotako erabiltzaile mota

    //Eraikitzailea
    public APP(String mota) {
        this.mota = mota;
        setTitle("Datu-base kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 850, 500);

        JPanel edukia = new JPanel(new BorderLayout());
        setContentPane(edukia);

        //Kontrolatzaiea sortu
        kontrolatzailea = new TaulaKontrolatzailea();

        //Menu panel bat sortu eta taulen aukeraketa sortu
        MenuPanela menuPanela = new MenuPanela(mota, taulaIzena -> kontrolatzailea.kargatuTaula(taulaIzena, taulaPanela));
        edukia.add(menuPanela, BorderLayout.WEST);

        // Taula eta operazioak erakusteko panela sortu
        taulaPanela = new TaulaPanela();
        edukia.add(taulaPanela, BorderLayout.CENTER);
    }
}

