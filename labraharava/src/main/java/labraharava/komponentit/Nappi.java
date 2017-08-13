
package labraharava.komponentit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import labraharava.logiikka.Logiikka;

public class Nappi {
    
    private Logiikka logiikka;
    private int x;
    private int y;
    private MouseAdapter napinKuuntelija;
    
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
    
    public void painaVasenta() {
        logiikka.painaVasenta(x, y);
    }
    
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
