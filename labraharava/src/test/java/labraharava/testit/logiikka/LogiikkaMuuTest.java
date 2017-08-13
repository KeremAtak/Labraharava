package labraharava.testit.logiikka;

import labraharava.komponentit.Ruudukko;
import labraharava.komponentit.Ruutu;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LogiikkaMuuTest {
    
    private Alustus alustus;
    private Ruudukko ruudukko;
    private Ruutu[][] ruudut;
    private Logiikka logiikka;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ruudukko = alustus.getPelipaneeli().getRuudukko();
        logiikka = ruudukko.getLogiikka();
        ruudut = ruudukko.getRuudut();
    }
    
    @Test
    public void lippujaVoiAsettaaEnintaanMiinojenVerran() {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                ruudut[x][y].getNappi().painaOikeaa();
            }
        }
        int lippujenMaara = 0;
        
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                if (ruudut[x][y].getText().equals("L")) {
                    lippujenMaara++;
                }
            }
        }
        assertEquals("Lippuja ei voitu asettaa sen verran mitä miinoja oli!", lippujenMaara, 15);
    }
}
