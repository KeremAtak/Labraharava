
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

public class Pelipaneeli extends JPanel {
    
    private Nappi[][] napit;
    private Logiikka logiikka;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    public Pelipaneeli(Alustus alustus, int leveys, int korkeus, int miinat) {
        this.napit = new Nappi[leveys][korkeus];
        this.logiikka = new Logiikka(this, napit, alustus, miinat);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        
        this.setLayout(new GridLayout(leveys, korkeus));
        this.setSize(new Dimension(900, 900));
        alustaNapit();
    }
    
    private void alustaNapit() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                napit[x][y] = new Nappi(logiikka, x, y);
                this.add(napit[x][y]);
            }
        }
        asetaNapeilleMiinat();
    }
    
    private void asetaNapeilleMiinat() {
        Random random = new Random();
        int x = 0;
        int y = 0;
        for (int i = 0; i < miinat; i++) {
            while (true) {
                x = random.nextInt(leveys);
                y = random.nextInt(korkeus);
                if (!napit[x][y].getMiina()) {
                    napit[x][y].setMiina(true);
                    break;
                }
            }
        }
    }
    
    public Nappi[][] getNapit() {
        return napit;
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public int getMiinat() {
        return miinat;
    }
}
