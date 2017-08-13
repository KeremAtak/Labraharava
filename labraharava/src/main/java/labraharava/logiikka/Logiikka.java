package labraharava.logiikka;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import labraharava.komponentit.*;
import labraharava.paakansio.Alustus;

public class Logiikka {
    
    private int miinat;
    private int miinojaJaljella;
    private Ruutu[][] ruudut;
    private Alustus alustus;
    private Pelipaneeli pelipaneeli;
    private Ruudukko ruudukko;
    private List<Numeropari> parit;
    
    public Logiikka(Pelipaneeli paneeli, Ruudukko ruudukko, Ruutu[][] ruudut, Alustus alustus, int miinat) {
        this.pelipaneeli = paneeli;
        this.ruudukko = ruudukko;
        this.ruudut = ruudut;
        this.alustus = alustus;
        this.miinat = miinat;
        this.miinojaJaljella = miinat;
    }
    
    public void painaVasenta(int x, int y) {
        Ruutu ruutu = ruudut[x][y];
        if (ruutu.isEnabled()) {
            if (ruutu.getText() != "L") {
                if (ruutu.getMiina()) {
                    paataPeli("Hävisit pelin!", java.awt.Color.red);
                } else {
                    tarkistaRuutu(new Numeropari(x, y));
                }
            }
        }
    }
    
    public void painaOikeaa(int x, int y) {
        Ruutu ruutu = ruudut[x][y];
        if (ruutu.isEnabled()) {
            if (ruutu.getText() != "L") {
                if (miinojaJaljella != 0) {
                    miinojaJaljella--;
                    ruutu.setText("L");
                    alustus.getYlapaneeli().getMiinatekstikentta().setText(miinojaJaljella + "/" + miinat);
                }
            } else {
                miinojaJaljella++;
                ruutu.setText("");
                alustus.getYlapaneeli().getMiinatekstikentta().setText(miinojaJaljella + "/" + miinat);
            }
        }
    }
    
    private void tarkistaRuutu(Numeropari numeropari) {
        int x = numeropari.getX();
        int y = numeropari.getY();
        Ruutu nappi = ruudut[x][y];
        parit = new ArrayList<>();
        
        tarkistaNapinPaikka(x, y);
                
        int ymparysMiinat = laskeMiinat(parit);
        if (ymparysMiinat != 0 && !nappi.getMiina()) {
            nappi.setText(Integer.toString(ymparysMiinat));
        }
        nappi.setEnabled(false);
        
        if (ymparysMiinat == 0) {
            for (Numeropari pari : parit) {
                if (ruudut[pari.getX()][pari.getY()].isEnabled()) {
                    tarkistaRuutu(pari);
                }
            }
        }
        
        if (loppuuko()) {
            paataPeli("Voitit pelin!", java.awt.Color.BLUE);
        }
    }
    //Tässä on vikaa
    public void tarkistaNapinPaikka(int x, int y) {
        if (x == 0 && y == 0) {
            System.out.println("vasen yläkulma");
            vasenYlakulma(x, y);
        } else if (x == ruudukko.getLeveys() - 1 && y == 0) {
            System.out.println("oikea yläkulma");
            oikeaYlakulma(x, y);
        } else if (x == ruudukko.getLeveys() - 1 && y == ruudukko.getKorkeus() - 1) {
            System.out.println("oikea alakulma");
            oikeaAlakulma(x, y);
        } else if (x == 0 && y == ruudukko.getKorkeus() - 1) {
            System.out.println("vasen alakulma");
            vasenAlakulma(x, y);
        } else if (x == 0) {
            System.out.println("vasen laita");
            parit.add(new Numeropari(x, y - 1));
            parit.add(new Numeropari(x + 1, y - 1));
            vasenYlakulma(x, y);
        } else if (y == 0) {
            System.out.println("ylälaita");
            vasenYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y + 1));
            parit.add(new Numeropari(x - 1, y));
        } else if (x == ruudukko.getLeveys() - 1) {
            System.out.println("oikealaita");
            oikeaYlakulma(x, y);
            parit.add(new Numeropari(x - 1, y - 1));
            parit.add(new Numeropari(x, y - 1));
        } else if (y == ruudukko.getKorkeus() - 1) {
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
            if (ruudut[pari.getX()][pari.getY()].getMiina()) {
                palautus++;
            }
        }
        return palautus;
    }
    
    private boolean onkoMiina(Numeropari pari) {
        if (ruudut[pari.getX()][pari.getY()].getMiina()) {
            return true;
        }
        return false;
    }
    
    private void paataPeli(String teksti, Color c) {
        lukitseNapitJaNaytaMiinat(c);
        alustus.getYlapaneeli().asetaTekstitUuttaPeliaVarten(teksti, ruudukko.getLeveys(), ruudukko.getKorkeus(), ruudukko.getMiinat());
    }
    
    private void lukitseNapitJaNaytaMiinat(Color c) {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                ruudut[x][y].setEnabled(false);
                if (ruudut[x][y].getMiina()) {
                    ruudut[x][y].setText("X");
                    ruudut[x][y].setBackground(c);
                }
            }
        }
    }
    //tässä ehkä vikaa
    private boolean loppuuko() {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                if (ruudut[x][y].isEnabled()) {
                    if (!ruudut[x][y].getMiina()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}