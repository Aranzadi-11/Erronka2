package erronka;

import javax.swing.*;
import java.awt.*;

public class TaulaPanela extends JPanel {

    public TaulaPanela() {
        setLayout(new BorderLayout());
    }

    //Emandako taula ezartzen du panelaren erdialdean.

    public void ezarriTaula(JTable taula) {
        removeAll();
        add(new JScrollPane(taula), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    //Operazioak kudeatzeko panel bat gehitzen da behealdean, non botoiak agertuko dira

    public void gehituOperazioPanela(JPanel operazioPanela) {
        add(operazioPanela, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}
