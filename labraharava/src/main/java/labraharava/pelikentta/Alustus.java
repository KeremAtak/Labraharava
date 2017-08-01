
package labraharava.pelikentta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import labraharava.komponentit.Paneeli;
import labraharava.komponentit.Nappi;
import labraharava.miina.Logiikka;

public class Alustus implements Runnable {
    
    private JFrame frame;
    private Paneeli paneeli;
    private Nappi[][] napit;
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 600));
        paneeli = new Paneeli();
        frame.add(paneeli);
        this.napit = paneeli.getNapit();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
