
package labraharava.pelikentta;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import labraharava.komponentit.Pelipaneeli;
import labraharava.komponentit.Nappi;
import labraharava.komponentit.Ylapaneeli;
import labraharava.miina.Logiikka;

public class Alustus implements Runnable {
    
    private JFrame frame;
    private Ylapaneeli ylapaneeli;
    private Pelipaneeli pelipaneeli;
    private Nappi[][] napit;
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 650));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.ylapaneeli = new Ylapaneeli(this);
        
        luoPeli();
    }
    
    public void luoPeli() {
        this.ylapaneeli.getTekstikentta().setText("");
        this.ylapaneeli.getMiinatekstikentta().setText("13/13");
        
        pelipaneeli = new Pelipaneeli(this);
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
