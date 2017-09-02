package labraharava.komponentit;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import labraharava.logiikka.Koordinaattilaskuri;
import labraharava.logiikka.Logiikka;
import labraharava.logiikka.Numeropari;
import labraharava.logiikka.Ruudukkologiikka;
import labraharava.paakansio.Alustus;

/**
  * Pelin ruudukko mikä sisältää ruutuja.
 */
public class Ruudukko {
    
    private Ruutu[][] ruudut;
    private Pelipaneeli pelipaneeli;
    private Logiikka logiikka;
    private Koordinaattilaskuri koordinaattilaskuri;
    private Ruudukkologiikka ruudukkologiikka;
    private int leveys;
    private int korkeus;
    private int miinat;
    
    /**
     * Ruudukon konstruktori. Luo ruutusäiliön ja asettaa niille miinat.
     * @param pelipaneeli pelin pelipaneeli
     * @param ruudut pelin ruudut
     * @param leveys pelin leveys ruuduissa
     * @param korkeus pelin korkeus ruuduissa.
     * @param miinat pelin miinojen määrä.
     */
    public Ruudukko(Pelipaneeli pelipaneeli, Ruutu[][] ruudut, int leveys, int korkeus, int miinat) {
        this.pelipaneeli = pelipaneeli;
        this.ruudut = ruudut;
        this.miinat = miinat;
        this.logiikka = new Logiikka(this, pelipaneeli.getAlustus());
        this.pelipaneeli.setLogiikka(logiikka);
        this.koordinaattilaskuri = new Koordinaattilaskuri(this);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukkologiikka = new Ruudukkologiikka(this);
        alustaRuudut();
    }
    
    /**
     * Metodi alustaa ruudukon.
     */
    private void alustaRuudut() {
        ruudukkologiikka.alustaRuudut();
    }
    
    /**
     * Metodi lukitsee kaikki ruudut, näyttää miinat ja värittää
     * miinat joko sinisellä tai punaisella.
     * @param c väri millä miinat värjätään, punainen kun pelaaja häviää ja sininen kun voittaa
     */
    public void lukitseRuudut(Color c) {
        ruudukkologiikka.lukitseRuudut(c);
    }
    
    /**
     * Metodi asettaa ruudukon ruutuihin miinoja annetun määrän.
     * Jos metodi arpoo miinan ruutuun missä on jo miina tai miina asetetaan kielletyn napin viereen
     * se arpoo uuden miinan koordinaatin
     * @param parit koordinaatit numeropareina mihin ei saa asettaa miinoja
     */
    public void asetaRuuduilleMiinat(List<Numeropari> parit) {
        ruudukkologiikka.asetaRuuduilleMiinat(parit);
    }
    /**
     * Metodi tarkistaa onko kiellettyihin (painetun ruudun ja sen viereisiin) ruutuihin asetettu miina.
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @param parit kielletyt ruudut
     * @return totuusarvo onko kielletyssä ruudussa miina
     */
    public boolean miinaAsetettuKiellettyynRuutuun(int x, int y, List<Numeropari> parit) {
        return ruudukkologiikka.miinaAsetettuKiellettyynRuutuun(x, y, parit);
    }
    /**
     * Metodi palauttaa ruudukosta yksittäisen ruudun.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @return palautettava ruutu koordinaateissa
     */
    public Ruutu getRuutu(int x, int y) {
        return ruudukkologiikka.getRuutu(x, y);
    }
    
    public Koordinaattilaskuri getKoordinaattilaskuri() {
        return koordinaattilaskuri;
    }
    
    public Pelipaneeli getPelipaneeli() {
        return pelipaneeli;
    }
    
    public Ruudukkologiikka getRuudukkologiikka() {
        return ruudukkologiikka;
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
