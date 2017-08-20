
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JTextField;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;

/**
  * Pelin pelipaneeli mikä sisältää pelin ruudukon. 
  * Peliä pelataan tässä paneelissa.
  */
public class Pelipaneeli extends JPanel {
    
    private Ruutu[][] napit;
    private Logiikka logiikka;
    private Ruudukko ruudukko;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    /**
     * Pelipaneelin konstruktori. Luo nappisäiliön, paneelin tyylin ja koon sekä
     * ruudukon.
     * @param alustus pelin alustus
     * @param leveys pelin leveys ruuduissa
     * @param korkeus pelin korkeus ruuduissa.
     * @param miinat pelin miinojen määrä.
     */
    
    public Pelipaneeli(Alustus alustus, int leveys, int korkeus, int miinat) {
        this.napit = new Ruutu[leveys][korkeus];
        
        this.setLayout(new GridLayout(leveys, korkeus));
        this.setSize(new Dimension(900, 900));
        
        this.ruudukko = new Ruudukko(this, alustus, napit, leveys, korkeus, miinat);
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    public void setLogiikka(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
}
