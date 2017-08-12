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
    
    private Ruutu[][] napit;
    private Pelipaneeli pelipaneeli;
    private Logiikka logiikka;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    
    public Ruudukko(Pelipaneeli pelipaneeli, Alustus alustus, Ruutu[][] napit, int leveys, int korkeus, int miinat) {
        this.pelipaneeli = pelipaneeli;
        this.napit = napit;
        this.logiikka = new Logiikka(pelipaneeli, this, napit, alustus, miinat);
        this.pelipaneeli.setLogiikka(logiikka);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        
        alustaNapit();
    }
    
    private void alustaNapit() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                napit[x][y] = new Ruutu(logiikka, x, y);
                pelipaneeli.add(napit[x][y]);
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
    
    public Logiikka getLogiikka() {
        return logiikka;
    }
    
    public Ruutu[][] getNapit() {
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
