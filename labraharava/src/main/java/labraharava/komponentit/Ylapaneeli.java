/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import labraharava.pelikentta.Alustus;


public class Ylapaneeli extends JPanel {
    
    private Alustus alustus;
    private JTextField tekstikentta;
    private JTextField miinatekstikentta;
    
    public Ylapaneeli(Alustus alustus) {
        this.alustus = alustus;
        this.setSize(new Dimension(600, 50));
        
        JButton uusiPeliNappi = new JButton("Uusi peli");
        uusiPeliNappi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                alustus.getFrame().getContentPane().remove(alustus.getPelipaneeli());
                alustus.luoPeli();
            }
        });
        this.tekstikentta = new JTextField();
        this.tekstikentta.setPreferredSize(new Dimension(100, 20));
        this.tekstikentta.setEditable(false);
        
        this.miinatekstikentta = new JTextField();
        this.miinatekstikentta.setPreferredSize(new Dimension(60, 20));
        this.miinatekstikentta.setEditable(false);
        
        
        this.add(uusiPeliNappi);
        this.add(tekstikentta);
        this.add(miinatekstikentta);
        
        alustus.getFrame().add(this);
    }
    
    public JTextField getTekstikentta() {
        return tekstikentta;
    }
    
    public JTextField getMiinatekstikentta() {
        return miinatekstikentta;
    }
}
