package labraharava.miina;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import labraharava.komponentit.Nappi;

public class Logiikka {
    
    private Nappi[][] napit;
    
    public Logiikka(Nappi[][] napit) {
        this.napit = napit;
    }
    
    public void painaVasenta(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.getText() != "L") {
            if (nappi.getMiina()) {
               JFrame frame = new JFrame("Hävisit pelin!");
               frame.setVisible(true);
               frame.setPreferredSize(new Dimension(100, 100));
            } else {
                tarkistaNappi(new Numeropari(x, y));
            }
        }
    }
    
    public void painaOikeaa(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.isEnabled()) {
            if (nappi.getText() != "L") {
                nappi.setText("L");
            } else {
                nappi.setText("");
            }
        }
    }
    
    private void tarkistaNappi(Numeropari numeropari) {
        int x = numeropari.getX();
        int y = numeropari.getY();
        Nappi nappi = napit[x][y];
        List<Numeropari> parit = new ArrayList<>();
        
        //vasen yläkulma
        if (x == 0 && y == 0) {
            parit.add(new Numeropari(x + 1, y));
            parit.add(new Numeropari(x + 1, y + 1));
            parit.add(new Numeropari(x, y + 1));
        //oikea yläkulma
        } else if (x == napit[0].length - 1 && y == 0) {
            parit.add(new Numeropari(x, y + 1));
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
        //oikea alakulma
        } else if (x == napit[0].length - 1 && y == napit[1].length - 1) {
            parit.add(new Numeropari(x - 1, y));
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
        //vasen alakulma
        } else if (x == 0 && y == napit[1].length - 1) {
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x + 1, y));
        //vasen laita
        } else if (x == 0) {
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x + 1, y));
            parit.add(new Numeropari(x + 1, y + 1));
            parit.add(new Numeropari(x, y + 1));
        //ylälaita
        } else if (y == 0) {
            parit.add(new Numeropari(x + 1, y));
            parit.add(new Numeropari(x + 1, y + 1));
            parit.add(new Numeropari(x, y + 1));
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
        //oikea laita
        } else if (x == napit[0].length - 1) {
            parit.add(new Numeropari(x, y + 1));
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
        //alalaita
        } else if (y == napit[1].length - 1) {
            parit.add(new Numeropari(x - 1, y));
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x + 1, y));
        } else {
            parit.add(new Numeropari(x - 1, y));
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x, y + 1));
            parit.add(new Numeropari(x + 1, y + 1));
            parit.add(new Numeropari(x + 1, y));
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x - 1, y - 1));
        }
        int miinat = laskeMiinat(parit);
        //miinat != 0 && !nappi.getMiina()
        if (miinat != 0 && !nappi.getMiina()) {
            nappi.setText(Integer.toString(miinat));
        }
        nappi.setEnabled(false);
        
        if (miinat == 0) {
            for (Numeropari pari : parit) {
                if (napit[pari.getX()][pari.getY()].isEnabled())
                tarkistaNappi(pari);
            }
        }
    }
    
    
    private int laskeMiinat(List<Numeropari> numeroparit) {
        int palautus = 0;
        for (Numeropari pari : numeroparit) {
            if (napit[pari.getX()][pari.getY()].getMiina()) {
                palautus++;
            }
        }
        return palautus;
    }
    
    private boolean onkoMiina(Numeropari pari) {
        if (napit[pari.getX()][pari.getY()].getMiina()) {
            return true;
        }
        return false;
    }
}
