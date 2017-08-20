package labraharava.komponentit;

import java.util.Random;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;

/**
  * Pelin ruudukko mikä sisältää ruutuja.
 */
public class Ruudukko {
    
    private Ruutu[][] ruudut;
    private Pelipaneeli pelipaneeli;
    private Logiikka logiikka;
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
        this.logiikka = new Logiikka(pelipaneeli, this, ruudut, alustus, miinat);
        this.pelipaneeli.setLogiikka(logiikka);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        
        alustaRuudut();
    }
    
    /**
     * Metodi alustaa ruudukon asettamalla ruudukkoon ruutuja leveyden ja korkeuden verran.
     */
    private void alustaRuudut() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                ruudut[x][y] = new Ruutu(logiikka, x, y);
                pelipaneeli.add(ruudut[x][y]);
            }
        }
        asetaRuuduilleMiinat();
    }
    
    /**
     * Metodi asettaa ruudukon ruutuihin miinoja annetun määrän.
     * Jos metodi arpoo miinan ruutuun missä on jo miina se arpoo uuden miinan
     * koordinaatin.
     */
    private void asetaRuuduilleMiinat() {
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
