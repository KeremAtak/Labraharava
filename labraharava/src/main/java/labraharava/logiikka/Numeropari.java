package labraharava.logiikka;
/**
 * Numeropari on logiikan apuluokka. Sitä käytetään ruutujen koordinaattien etsimisessä.
 */
public class Numeropari {
    
    private int x;
    private int y;
    
    /**
    * Numeroparin konstruktori.
    * @param x y-koordinaatti
    * @param y numeroparin y-koordinaatti
    */
    public Numeropari(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
