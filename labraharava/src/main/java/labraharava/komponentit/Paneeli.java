
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import labraharava.miina.Logiikka;
import labraharava.miina.Numeropari;

public class Paneeli extends JPanel {
    
    private int rivit = 10;
    private int sarakkeet = 10;
    private Nappi[][] napit;
    private Logiikka logiikka;
    
    public Paneeli() {
        this.napit = new Nappi[10][10];
        this.logiikka = new Logiikka(napit);
        this.setLayout(new GridLayout(10, 10));
        this.setSize(new Dimension(600, 600));
        alustaNapit();
    }
    
    private void alustaNapit() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
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
        for (int i = 0; i < 16; i++) {
            while (true) {
                x = random.nextInt(10);
                y = random.nextInt(10);
                if (!napit[x][y].getMiina()) {
                    napit[x][y].setMiina(true);
                    napit[x][y].setText("M");
                }
                break;
            }
        }
    }
    
    
    public Nappi[][] getNapit() {
        return napit;
    }
}
