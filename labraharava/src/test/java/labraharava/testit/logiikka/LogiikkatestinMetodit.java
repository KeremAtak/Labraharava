/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labraharava.testit.logiikka;

import java.util.ArrayList;
import java.util.List;
import labraharava.komponentit.Ruudukko;
import labraharava.komponentit.Ruutu;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;
import org.junit.Before;

/**
 *
 * @author kerem
 */
public abstract class LogiikkatestinMetodit {
    
    protected Alustus alustus;
    protected Ruudukko ruudukko;
    protected Ruutu[][] ruudut;
    protected Logiikka logiikka;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ruudukko = alustus.getPelipaneeli().getRuudukko();
        logiikka = ruudukko.getLogiikka();
        ruudut = ruudukko.getRuudut();
    }
    
    
    protected List<Ruutu> ymparoivatRuudut() {
        List<Ruutu> palautus = new ArrayList<>();
        palautus.add(ruudut[1][1]);
        palautus.add(ruudut[1][2]);
        palautus.add(ruudut[1][3]);
        palautus.add(ruudut[2][3]);
        palautus.add(ruudut[3][3]);
        palautus.add(ruudut[3][2]);
        palautus.add(ruudut[3][1]);
        palautus.add(ruudut[2][1]);
        
        return palautus;
    }
    
    protected void asetaKaksiRuutua() {
        logiikka.setAvattu(true);
        ruudut[2][2].setMiina(true);
        ruudut[3][2].setMiina(true);
    }
    
    protected void asetaKulmaanRuutuja() {
        logiikka.setAvattu(true);
        ruudut[1][2].setMiina(true);
        ruudut[2][1].setMiina(true);
    }
    
    protected void poistaMiinat() {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                if (ruudut[x][y].getMiina()) {
                    ruudut[x][y].setMiina(false);
                }
            }
        }
    }
    
}
