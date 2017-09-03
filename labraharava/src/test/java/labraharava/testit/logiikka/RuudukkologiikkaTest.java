package labraharava.testit.logiikka;

import java.util.ArrayList;
import java.util.List;
import labraharava.komponentit.Ruudukko;
import labraharava.logiikka.Numeropari;
import labraharava.logiikka.Ruudukkologiikka;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RuudukkologiikkaTest {
    
    private Alustus alustus;
    private Ruudukkologiikka ruudukkologiikka;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ruudukkologiikka = alustus.getPelipaneeli().getRuudukko().getRuudukkologiikka();
    }
    
    @Test
    public void miinatAseteltuOikeinPelikenttaan() {
        for (int i = 0; i < 10; i++) {
           assertEquals("Kenttään ei ole asetettu oikea määrä miinoja!", ruudukkologiikka.getRuudukko().getMiinat(), 15); 
        }
    }
    
    @Test
    public void miinojenAsettelijaAsettaaMiinatOikein1() {
        List<Numeropari> kielletytParit = new ArrayList<>();
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                kielletytParit.add(new Numeropari(x, y));
            }
        }
        ruudukkologiikka.asetaRuuduilleMiinat(kielletytParit);
        assertEquals("Kielletyissä kenteissä oli miinoja", eiMiinojaKielletyissaPareissa(kielletytParit), true);
    }
    
    @Test
    public void miinojenAsettelijaAsettaaMiinatOikein2() {
        alustus.luoPeli(14, 11, 20);
        ruudukkologiikka = alustus.getPelipaneeli().getRuudukko().getRuudukkologiikka();
        
        List<Numeropari> kielletytParit = new ArrayList<>();
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                kielletytParit.add(new Numeropari(x, y));
            }
        }
        ruudukkologiikka.asetaRuuduilleMiinat(kielletytParit);
        assertEquals("Kielletyissä kenteissä oli miinoja", eiMiinojaKielletyissaPareissa(kielletytParit), true);
    }
    
    public boolean eiMiinojaKielletyissaPareissa(List<Numeropari> parit) {
        for (Numeropari pari : parit) {
            if (ruudukkologiikka.getRuutu(pari.getX(), pari.getY()).getMiina()) {
                return false;
            }
        }
        return true;
    }
}
