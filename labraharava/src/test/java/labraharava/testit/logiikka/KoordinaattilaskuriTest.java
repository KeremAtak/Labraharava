
package labraharava.testit.logiikka;

import java.util.*;
import labraharava.komponentit.*;
import labraharava.logiikka.*;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class KoordinaattilaskuriTest {
    
    private Alustus alustus;
    private Ruudukko ruudukko;
    private Ruutu[][] ruudut;
    private Logiikka logiikka;
    private Koordinaattilaskuri koordinaattilaskuri;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ruudukko = alustus.getPelipaneeli().getRuudukko();
        logiikka = ruudukko.getLogiikka();
        ruudut = ruudukko.getRuudut();
        koordinaattilaskuri = ruudukko.getKoordinaattilaskuri();
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein1() {
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(ruudukko.getLeveys() - 1, 0);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(9, 1));
        verrattava.add(new Numeropari(8, 1));
        verrattava.add(new Numeropari(8, 0));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein2() {
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(0, ruudukko.getKorkeus() - 1);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(0, 8));
        verrattava.add(new Numeropari(1, 8));
        verrattava.add(new Numeropari(1, 9));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein3() {
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(2, 2);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(3, 2));
        verrattava.add(new Numeropari(3, 3));
        verrattava.add(new Numeropari(2, 3));
        verrattava.add(new Numeropari(1, 2));
        verrattava.add(new Numeropari(1, 1));
        verrattava.add(new Numeropari(2, 1));
        verrattava.add(new Numeropari(1, 3));
        verrattava.add(new Numeropari(3, 1));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein4() {
        luoEinelioruudukko();
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(ruudukko.getLeveys() - 1, 0);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(13, 1));
        verrattava.add(new Numeropari(12, 1));
        verrattava.add(new Numeropari(12, 0));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein5() {
        luoEinelioruudukko();
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(0, ruudukko.getKorkeus() - 1);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(0, 9));
        verrattava.add(new Numeropari(1, 9));
        verrattava.add(new Numeropari(1, 10));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    @Test
    public void koordinaattiLaskuriLaskeeViereisetOikein6() {
        luoEinelioruudukko();
        List<Numeropari> parit = koordinaattilaskuri.tarkistaRuudunPaikka(2, 2);
        List<Numeropari> verrattava = new ArrayList<>();
        verrattava.add(new Numeropari(3, 2));
        verrattava.add(new Numeropari(3, 3));
        verrattava.add(new Numeropari(2, 3));
        verrattava.add(new Numeropari(1, 2));
        verrattava.add(new Numeropari(1, 1));
        verrattava.add(new Numeropari(2, 1));
        verrattava.add(new Numeropari(1, 3));
        verrattava.add(new Numeropari(3, 1));
        
        assertEquals("Koordinaattilaskuri ei lisännyt oikein oikeita numeropareja", vertaaParit(parit, verrattava), true);
    }
    
    
    private boolean vertaaParit(List<Numeropari> parit, List<Numeropari> verrattava) {
        for (int i = 0; i < parit.size(); i++) {
            if (parit.get(i).getX() != verrattava.get(i).getX() || parit.get(i).getY() != verrattava.get(i).getY()) {
                return false;
            }
        }
        return true;
    }
    
    private void luoEinelioruudukko() {
        alustus.luoPeli(14, 11, 20);
        ruudukko = alustus.getPelipaneeli().getRuudukko();
        logiikka = ruudukko.getLogiikka();
        ruudut = ruudukko.getRuudut();
        koordinaattilaskuri = ruudukko.getKoordinaattilaskuri();
    }
}

