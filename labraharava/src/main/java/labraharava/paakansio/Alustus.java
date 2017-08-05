
package labraharava.paakansio;

import java.awt.*;
import javax.swing.*;
import labraharava.komponentit.*;

public class Alustus implements Runnable {
    
    private JFrame frame;
    private Ylapaneeli ylapaneeli;
    private Pelipaneeli pelipaneeli;
    private Nappi[][] napit;
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(900, 950));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.ylapaneeli = new Ylapaneeli(this);
        
        luoPeli(10, 10, 15);
    }
    
    public void luoPeli(int leveys, int korkeus, int miinat) {
        ylapaneeli.asetaTekstitUuttaPeliaVarten("", leveys, korkeus, miinat);
        
        pelipaneeli = new Pelipaneeli(this, leveys, korkeus, miinat);
        frame.add(pelipaneeli);
        this.napit = pelipaneeli.getNapit();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Pelipaneeli getPelipaneeli() {
        return pelipaneeli;
    }
    
    public Ylapaneeli getYlapaneeli() {
        return ylapaneeli;
    }
}