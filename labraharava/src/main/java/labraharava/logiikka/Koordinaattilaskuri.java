package labraharava.logiikka;

import java.util.ArrayList;
import java.util.List;
import labraharava.komponentit.Ruudukko;

/**
 * Koordinaattilaskuri laskee ruudun ympäröivät miinat ruudukossa.
 */

public class Koordinaattilaskuri {
    
    private Ruudukko ruudukko;
    private List<Numeropari> parit;
    
    /**
     * Koordinaattilaskurin konstruktorin. Asettaa ilmentymämuuttujaksi pelin ruudukon.
     * @param ruudukko pelin ruudukko
     */
    public Koordinaattilaskuri(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }
    
    /**
     * Metodi tutkii missä ruutu sijaitsee. Se asettaa viereisien ruutujen
     * sijainnit numeropareina listaan.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @return ruudun ympärillä olevat ruudut
     */
    public List<Numeropari> tarkistaRuudunPaikka(int x, int y) {
        parit = new ArrayList<>();
        if (x == 0 && y == 0) {
            vasenYlakulma(x, y);
        } else if (x == ruudukko.getLeveys() - 1 && y == 0) {
            oikeaYlakulma(x, y);
        } else if (x == ruudukko.getLeveys() - 1 && y == ruudukko.getKorkeus() - 1) {
            oikeaAlakulma(x, y);
        } else if (x == 0 && y == ruudukko.getKorkeus() - 1) {
            vasenAlakulma(x, y);
        } else if (x == 0) {
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            vasenYlakulma(x, y);
        } else if (y == 0) {
            vasenYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
        } else if (x == ruudukko.getLeveys() - 1) {
            oikeaYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
        } else if (y == ruudukko.getKorkeus() - 1) {
            oikeaAlakulma(x, y);
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x + 1, y));
        } else {
            vasenYlakulma(x, y);
            oikeaAlakulma(x, y);
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x + 1, y - 1));
        }
        return parit;
    }
    /**
     * Metodi asettaa haluttuja numeropareja listaan.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    private void vasenYlakulma(int x, int y) {
        parit.add(new Numeropari(x + 1, y));
        parit.add(new Numeropari(x + 1, y + 1));
        parit.add(new Numeropari(x, y + 1));
    }
    /**
     * Metodi asettaa haluttuja numeropareja listaan.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    private void oikeaYlakulma(int x, int y) {
        parit.add(new Numeropari(x, y + 1));
        parit.add(new Numeropari(x - 1, y + 1));
        parit.add(new Numeropari(x - 1, y));
    }
    /**
     * Metodi asettaa haluttuja numeropareja listaan.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    private void oikeaAlakulma(int x, int y) {
        parit.add(new Numeropari(x - 1, y));
        parit.add(new Numeropari(x - 1, y - 1));
        parit.add(new Numeropari(x, y - 1));
    }
    /**
     * Metodi asettaa haluttuja numeropareja listaan.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    private void vasenAlakulma(int x, int y) {
        parit.add(new Numeropari(x, y - 1));
        parit.add(new Numeropari(x + 1, y - 1));
        parit.add(new Numeropari(x + 1, y));
    }
}
