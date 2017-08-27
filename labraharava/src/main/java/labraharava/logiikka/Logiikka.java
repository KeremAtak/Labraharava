package labraharava.logiikka;

import java.util.List;
import java.awt.Color;
import labraharava.komponentit.*;
import labraharava.paakansio.Alustus;

/**
 * Pelin logiikka. Logiikka laskee metodeillaan pelin toimintoja.
 */

public class Logiikka {
    
    private int miinat;
    private int miinojaJaljella;
    private Alustus alustus;
    private Pelipaneeli pelipaneeli;
    private Ruudukko ruudukko;
    private Koordinaattilaskuri koordinaattilaskuri;
    private boolean avattu;
    
    /**
     * Logiikan konstruktori.
     * 
     * @param paneeli pelin pelipaneeli
     * @param ruudukko pelin ruudukko
     * @param ruudut ruudukon ruudut
     * @param alustus pelin alustaja
     * @param miinat miinojen määrä
     */
    
    public Logiikka(Pelipaneeli paneeli, Ruudukko ruudukko, Alustus alustus) {
        this.pelipaneeli = paneeli;
        this.ruudukko = ruudukko;
        this.alustus = alustus;
        this.miinat = ruudukko.getMiinat();
        this.miinojaJaljella = miinat;
        this.koordinaattilaskuri = new Koordinaattilaskuri(ruudukko);
        this.avattu = false;
    }
    
    /**
     * Metodia kutsutaan kun pelin vasenta näppäintä painetaan.
     * Jos ruutu on painettavissa niin sitä painetaan, tarkistetaan
     * mitä ruudussa on ja kutsutaan vaadittuja metodeja.
     * @param x painetun ruudun x-koordinaatti
     * @param y painetun ruudun y-koordinaatti
     */
    public void painaVasenta(int x, int y) {
        Ruutu ruutu = ruudukko.getRuutu(x, y);
        if (ruutu.isEnabled()) {
            if (ruutu.getText() != "L") {
                if (!avattu) {
                    painaEnsimmaistaRuutua(x, y);
                }
                if (ruutu.getMiina()) {
                    paataPeli("Hävisit pelin!", java.awt.Color.red);
                } else {
                    tarkistaRuutu(new Numeropari(x, y));
                }
            }
        }
    }
    /**
     * Metodia kutsutaan kun pelin oikeaa näppäintä painetaan.
     * Lippu asetetaan jos asetettaveja lippuja vielä löytyy ja ruutu
     * on painettavissa.
     * @param x painetun ruudun x-koordinaatti
     * @param y painetun ruudun y-koordinaatti
     */
    public void painaOikeaa(int x, int y) {
        Ruutu ruutu = ruudukko.getRuutu(x, y);
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
    /**
     * Metodia kutsutaan jos painettavissa oleva ruutu ei ollut miina.
     * Se tarkistaa montako miinaa nappiin liittyvään ruudun ympärillä on, asettaa kyseisen määrän
     * ruudulle. Jos ruudun vieressä ei ollut ruutuja niin se rekursiolla kutsuu ympärillä olevia
     * ruutuja ja tarkistaa kyseiset ruudut.
     * @param numeropari apuluokka mitä käytetään logiikassa
     */
    private void tarkistaRuutu(Numeropari numeropari) {
        int x = numeropari.getX();
        int y = numeropari.getY();
        Ruutu ruutu = ruudukko.getRuutu(x, y);
        
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(x, y);
        int ymparysMiinat = laskeMiinat(parit);
        if (ymparysMiinat != 0 && !ruutu.getMiina()) {
            ruutu.setText(Integer.toString(ymparysMiinat));
        }
        ruutu.setEnabled(false);
        
        if (ymparysMiinat == 0) {
            for (Numeropari pari : parit) {
                if (ruudukko.getRuutu(pari.getX(), pari.getY()).isEnabled() && !ruudukko.getRuutu(pari.getX(), pari.getY()).getText().equals("L")) {
                    tarkistaRuutu(pari);
                }
            }
        }
        if (loppuuko()) {
            paataPeli("Voitit pelin!", java.awt.Color.BLUE);
        }
    }
    
    /**
     * Metodi laskee ruutua ympäröivät miinat hyödyntämällä
     * numeroparien koordinaatteja.
     * @return palautus miinojen määrä
     */
    public int laskeMiinat(List<Numeropari> numeroparit) {
        int palautus = 0;
        for (Numeropari pari : numeroparit) {
            if (ruudukko.getRuutu(pari.getX(), pari.getY()).getMiina()) {
                palautus++;
            }
        }
        return palautus;
    }
    
    /**
     * Metodi tarkistaa onko numeroparin koordinaateissa
     * miina.
     */
    public boolean onkoMiina(Numeropari pari) {
        if (ruudukko.getRuutu(pari.getX(), pari.getY()).getMiina()) {
            return true;
        }
        return false;
    }
    /**
     * Metodilla kutsutaan metodeja kun ensimmäistä ruutua painetaan.
     * Metodissa annetaan koordinaatit mitä ruutuja ei saa painaa
     * metodille mikä asettaa miinat ruudukkoon.
     */
    private void painaEnsimmaistaRuutua(int x, int y) {
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(x, y);
        parit.add(new Numeropari(x, y));
        ruudukko.asetaRuuduilleMiinat(parit);
        avattu = true;
    }
    /**
     * Metodilla päätetään peli. Se kutsuu metodia mikä lukitsee kaikki ruudut, näyttää miinat ja värittää
     * miinat joko sinisellä tai punaisella. Lisäksi alustaa yläpaneeliin tekstit uutta peliä varten.
     */
    private void paataPeli(String teksti, Color c) {
        ruudukko.lukitseRuudut(c);
        alustus.getYlapaneeli().asetaTekstitUuttaPeliaVarten(teksti, ruudukko.getLeveys(), ruudukko.getKorkeus(), ruudukko.getMiinat());
    }
    
    /**
     * Metodi tarkistaa päättyykö peli. Jos ruudukosta löytyy ainoastaan avaamattomia miinoja niin peli päättyy
     * ja pelaaja voittaa.
     */
    private boolean loppuuko() {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                if (ruudukko.getRuutu(x, y).isEnabled()) {
                    if (!ruudukko.getRuutu(x, y).getMiina()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void setAvattu(Boolean avattu) {
        this.avattu = avattu;
    }
    
    public Koordinaattilaskuri getKoordinaattilaskuri() {
        return koordinaattilaskuri;
    }
}