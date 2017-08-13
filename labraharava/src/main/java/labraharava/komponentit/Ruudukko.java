/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labraharava.komponentit;

import java.util.Random;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;

/**
 *
 * @author kerem
 */
public class Ruudukko {
    
    private Ruutu[][] ruudut;
    private Pelipaneeli pelipaneeli;
    private Logiikka logiikka;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    
    public Ruudukko(Pelipaneeli pelipaneeli, Alustus alustus, Ruutu[][] ruudut, int leveys, int korkeus, int miinat) {
        this.pelipaneeli = pelipaneeli;
        this.ruudut = ruudut;
        this.logiikka = new Logiikka(pelipaneeli, this, ruudut, alustus, miinat);
        this.pelipaneeli.setLogiikka(logiikka);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        
        alustaNapit();
    }
    
    private void alustaNapit() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                ruudut[x][y] = new Ruutu(logiikka, x, y);
                pelipaneeli.add(ruudut[x][y]);
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
                if (!ruudut[x][y].getMiina()) {
                    ruudut[x][y].setMiina(true);
                    break;
                }
            }
        }
    }
    
    public Logiikka getLogiikka() {
        return logiikka;
    }
    
    public Ruutu[][] getRuudut() {
        return ruudut;
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
