package labraharava.komponentit;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import labraharava.logiikka.Koordinaattilaskuri;
import labraharava.logiikka.Logiikka;
import labraharava.logiikka.Numeropari;
import labraharava.paakansio.Alustus;

/**
  * Pelin ruudukko mikä sisältää ruutuja.
 */
public class Ruudukko {
    
    private Ruutu[][] ruudut;
    private Pelipaneeli pelipaneeli;
    private Logiikka logiikka;
    private Koordinaattilaskuri koordinaattilaskuri;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    /**
     * Ruudukon konstruktori. Luo ruutusäiliön ja asettaa niille miinat.
     * @param pelipaneeli pelin pelipaneeli
     * @param alustus pelin alustaja
     * @param ruudut pelin ruudut
     * @param leveys pelin leveys ruuduissa
     * @param korkeus pelin korkeus ruuduissa.
     * @param miinat pelin miinojen määrä.
     */
    public Ruudukko(Pelipaneeli pelipaneeli, Alustus alustus, Ruutu[][] ruudut, int leveys, int korkeus, int miinat) {
        this.pelipaneeli = pelipaneeli;
        this.ruudut = ruudut;
        this.miinat = miinat;
        this.logiikka = new Logiikka(pelipaneeli, this, alustus);
        this.pelipaneeli.setLogiikka(logiikka);
        this.koordinaattilaskuri = new Koordinaattilaskuri(this);
        this.leveys = leveys;
        this.korkeus = korkeus;
        
        alustaRuudut();
    }
    
    /**
     * Metodi alustaa ruudukon.
     */
    private void alustaRuudut() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                ruudut[x][y] = new Ruutu(logiikka, x, y);
                pelipaneeli.add(ruudut[x][y]);
            }
        }
    }
    
    /**
     * Metodi lukitsee kaikki ruudut, näyttää miinat ja värittää
     * miinat joko sinisellä tai punaisella.
     * @param c väri millä miinat värjätään, punainen kun pelaaja häviää ja sininen kun voittaa
     */
    public void lukitseRuudut(Color c) {
        for (int x = 0; x < leveys; x++) {
            for (int y = 0; y < korkeus; y++) {
                ruudut[x][y].setEnabled(false);
                if (ruudut[x][y].getMiina()) {
                    ruudut[x][y].setText("X");
                    ruudut[x][y].setBackground(c);
                }
            }
        }
    }
    
    /**
     * Metodi asettaa ruudukon ruutuihin miinoja annetun määrän.
     * Jos metodi arpoo miinan ruutuun missä on jo miina tai miina asetetaan kielletyn napin viereen
     * se arpoo uuden miinan koordinaatin
     * @param parit koordinaatit numeropareina mihin ei saa asettaa miinoja
     */
    public void asetaRuuduilleMiinat(List<Numeropari> parit) {
        Random random = new Random();
        int x = 0;
        int y = 0;
        for (Numeropari pari : parit) {
            System.out.println(pari.getX() + " " + pari.getY());
        }
        for (int i = 0; i < miinat; i++) {
            while (true) {
                x = random.nextInt(leveys);
                y = random.nextInt(korkeus);
                
                if (!ruudut[x][y].getMiina() && !miinaAsetettuKiellettyynRuutuun(x, y, parit)) {
                    ruudut[x][y].setMiina(true);
                    break;
                }
            }
        }
    }
    /**
     * Metodi tarkistaa onko kiellettyihin (painetun ruudun ja sen viereisiin) ruutuihin asetettu miina.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @param parit kielletyt ruudut
     * @return totuusarvo onko kielletyssä ruudussa miina
     */
    public boolean miinaAsetettuKiellettyynRuutuun(int x, int y, List<Numeropari> parit) {
        for (Numeropari pari : parit) {
            if (pari.getX() == x && pari.getY() == y) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodi palauttaa ruudukosta yksittäisen ruudun.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @return palautettava ruutu koordinaateissa
     */
    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }
    
    public Koordinaattilaskuri getKoordinaattilaskuri() {
        return koordinaattilaskuri;
    }
    
    public Pelipaneeli getPelipaneeli() {
        return pelipaneeli;
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
