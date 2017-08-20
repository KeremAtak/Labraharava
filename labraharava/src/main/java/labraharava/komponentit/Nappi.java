
package labraharava.komponentit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import labraharava.logiikka.Logiikka;

/**
  * Ruudun nappi mitä painattaessa pelataan peliä.
  */

public class Nappi {
    
    private Logiikka logiikka;
    private int x;
    private int y;
    private MouseAdapter napinKuuntelija;
    
    /**
     * Napin konstruktori. Luo napinkuuntelijan napille ja asettaa
     * vasemmalle ja hiiren oikealle näppäimelle toiminnallisuutta.
     * @param logiikka pelin logiikka
     * @param x napin x-koordinaatti
     * @param y napin y-koordinaatti
     */
    
    public Nappi(Logiikka logiikka, int x, int y) {
        this.logiikka = logiikka;
        this.x = x;
        this.y = y;
        this.napinKuuntelija = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    painaVasenta();
                }
                if (e.getButton() == 3) {
                    painaOikeaa();
                }
            }
        };
    }
    
    /**
     * Metodia kutsutaan kun vasenta hiiren nappia painetaan.
     * Se kutsuu logiikan painaVasenta-metodia napin koordinaateilla.
     */
    
    public void painaVasenta() {
        logiikka.painaVasenta(x, y);
    }
    
    /**
     * Metodia kutsutaan kun oikeaa hiiren nappia painetaan.
     * Se kutsuu logiikan painaOikeaa-metodia napin koordinaateilla.
     */
    
    public void painaOikeaa() {
        logiikka.painaOikeaa(x, y);
    }
    
    public MouseAdapter getNapinKuuntelija() {
        return napinKuuntelija;
    }
    
    public void setNapinKuuntelija(MouseAdapter napinKuuntelija) {
        this.napinKuuntelija = napinKuuntelija;
    }
}
