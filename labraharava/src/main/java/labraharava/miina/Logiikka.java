package labraharava.miina;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JFrame;
import labraharava.komponentit.Nappi;
import labraharava.komponentit.Ylapaneeli;
import labraharava.pelikentta.Alustus;

public class Logiikka {
    
    private int miinat = 16;
    private Nappi[][] napit;
    private Alustus alustus;
    
    public Logiikka(Nappi[][] napit, Alustus alustus) {
        this.napit = napit;
        this.alustus = alustus;
    }
    
    public void painaVasenta(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.getText() != "L") {
            if (nappi.getMiina()) {
               lukitseNapitJaNaytaMiinat(java.awt.Color.red);
               alustus.getYlapaneeli().getTekstikentta().setText("Hävisit pelin!");
            } else {
                tarkistaNappi(new Numeropari(x, y));
            }
        }
    }
    
    public void painaOikeaa(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.isEnabled()) {
            if (nappi.getText() != "L") {
                if (miinat != 0) {
                    miinat--;
                    nappi.setText("L");
                    alustus.getYlapaneeli().getMiinatekstikentta().setText(miinat + "/16");
                }
            } else {
                miinat++;
                nappi.setText("");
                alustus.getYlapaneeli().getMiinatekstikentta().setText(miinat + "/16");
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
        
        if (loppuuko()) {
            alustus.getYlapaneeli().getTekstikentta().setText("Voitit pelin!");
            lukitseNapitJaNaytaMiinat(java.awt.Color.blue);
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
    
    private void lukitseNapitJaNaytaMiinat(Color c) {
        for (int x = 0; x < napit[0].length; x++) {
            for (int y = 0; y < napit[1].length; y++) {
                napit[x][y].setEnabled(false);
                if(napit[x][y].getMiina()) {
                    napit[x][y].setText("X");
                    napit[x][y].setBackground(c);
                }
            }
        }
    }
    
    private boolean loppuuko() {
        for (int x = 0; x < napit[0].length; x++) {
            for (int y = 0; y < napit[1].length; y++) {
                System.out.println(x + " " + y);
                if (napit[x][y].isEnabled()) {
                    if(!napit[x][y].getMiina()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
