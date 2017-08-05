package labraharava.logiikka;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JFrame;
import labraharava.komponentit.Nappi;
import labraharava.komponentit.Pelipaneeli;
import labraharava.komponentit.Ylapaneeli;
import labraharava.paakansio.Alustus;

public class Logiikka {
    
    private int miinat;
    private int miinojaJaljella;
    private Nappi[][] napit;
    private Alustus alustus;
    private Pelipaneeli pelipaneeli;
    private List<Numeropari> parit;
    
    public Logiikka(Pelipaneeli paneeli, Nappi[][] napit, Alustus alustus, int miinat) {
        this.pelipaneeli = paneeli;
        this.napit = napit;
        this.alustus = alustus;
        this.miinat = miinat;
        this.miinojaJaljella = miinat;
    }
    
    public void painaVasenta(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.isEnabled()) {
                if (nappi.getText() != "L") {
                    if (nappi.getMiina()) {
                        paataPeli("Hävisit pelin!", java.awt.Color.red);
                } else {
                    tarkistaNappi(new Numeropari(x, y));
                }
            }
        }
    }
    
    public void painaOikeaa(int x, int y) {
        Nappi nappi = napit[x][y];
        if (nappi.isEnabled()) {
            if (nappi.getText() != "L") {
                if (miinojaJaljella != 0) {
                    miinojaJaljella--;
                    nappi.setText("L");
                    alustus.getYlapaneeli().getMiinatekstikentta().setText(miinojaJaljella + "/" + miinat);
                }
            } else {
                miinojaJaljella++;
                nappi.setText("");
                alustus.getYlapaneeli().getMiinatekstikentta().setText(miinojaJaljella + "/" + miinat);
            }
        }
    }
    
    private void tarkistaNappi(Numeropari numeropari) {
        int x = numeropari.getX();
        int y = numeropari.getY();
        Nappi nappi = napit[x][y];
        parit = new ArrayList<>();
        
        //Tässä on vikaa
        //vasen yläkulma
        if (x == 0 && y == 0) {
            System.out.println("vasen yläkulma");
            vasenYlakulma(x, y);
        //oikea yläkulma
        } else if (x == pelipaneeli.getLeveys() - 1 && y == 0) {
            System.out.println("oikea yläkulma");
            oikeaYlakulma(x, y);
        //oikea alakulma
        } else if (x == pelipaneeli.getLeveys() - 1 && y == pelipaneeli.getKorkeus() - 1) {
            System.out.println("oikea alakulma");
            oikeaAlakulma(x, y);
        //vasen alakulma
        } else if (x == 0 && y == pelipaneeli.getKorkeus() - 1) {
            System.out.println("vasen alakulma");
            vasenAlakulma(x, y);
        //vasen laita
        } else if (x == 0) {
            System.out.println("vasen laita");
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            vasenYlakulma(x, y);
        //ylälaita
        } else if (y == 0) {
            System.out.println("ylälaita");
            vasenYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
        //oikea laita
        } else if (x == pelipaneeli.getLeveys() - 1) {
            System.out.println("oikealaita");
            oikeaYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
        //alalaita
        } else if (y == pelipaneeli.getKorkeus() - 1) {
            System.out.println("alalaita");
            oikeaAlakulma(x, y);
            parit.add(new Numeropari(x + 1, y - 1));
            parit.add(new Numeropari(x + 1, y));
        } else {
            vasenYlakulma(x, y);
            oikeaAlakulma(x, y);
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x + 1, y - 1));
        }
        int ymparysMiinat = laskeMiinat(parit);
        if (ymparysMiinat != 0 && !nappi.getMiina()) {
            nappi.setText(Integer.toString(ymparysMiinat));
        }
        nappi.setEnabled(false);
        
        if (ymparysMiinat == 0) {
            for (Numeropari pari : parit) {
                if (napit[pari.getX()][pari.getY()].isEnabled()) {
                    tarkistaNappi(pari);
                }
            }
        }
        
        if (loppuuko()) {
            paataPeli("Voitit pelin!", java.awt.Color.BLUE);
        }
    }
    
    private void vasenYlakulma(int x, int y) {
        parit.add(new Numeropari(x + 1, y));
        parit.add(new Numeropari(x + 1, y + 1));
        parit.add(new Numeropari(x, y + 1));
    }
    
    private void oikeaYlakulma(int x, int y) {
        parit.add(new Numeropari(x, y + 1));
        parit.add(new Numeropari(x - 1, y + 1));
        parit.add(new Numeropari(x - 1, y));
    }
    
    private void oikeaAlakulma(int x, int y) {
        parit.add(new Numeropari(x - 1, y));
        parit.add(new Numeropari(x - 1, y - 1));
        parit.add(new Numeropari(x, y - 1));
    }
    
    private void vasenAlakulma(int x, int y) {
        parit.add(new Numeropari(x, y - 1));
        parit.add(new Numeropari(x + 1, y - 1));
        parit.add(new Numeropari(x + 1, y));
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
    
    private void paataPeli(String teksti, Color c) {
        lukitseNapitJaNaytaMiinat(c);
        int leveys = pelipaneeli.getLeveys();
        int korkeus = pelipaneeli.getKorkeus();
        int miinat = pelipaneeli.getMiinat();
        alustus.getYlapaneeli().asetaTekstitUuttaPeliaVarten(teksti, leveys, korkeus, miinat);
    }
    
    private void lukitseNapitJaNaytaMiinat(Color c) {
        for (int x = 0; x < pelipaneeli.getLeveys(); x++) {
            for (int y = 0; y < pelipaneeli.getKorkeus(); y++) {
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
