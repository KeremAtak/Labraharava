package labraharava.testit.komponentit;

import java.util.ArrayList;
import java.util.List;
import labraharava.komponentit.Ruutu;
import labraharava.komponentit.Pelipaneeli;
import labraharava.komponentit.Ruudukko;
import labraharava.logiikka.Koordinaattilaskuri;
import labraharava.logiikka.Numeropari;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RuudukkoTest {
    
    private Alustus alustus;
    private Ruudukko ruudukko;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ruudukko = alustus.getPelipaneeli().getRuudukko();
    }
    
    @Test
    public void kenttiaOikeaMaaraAlussa() {
        assertEquals("Leveys ei ollut alussa 10", ruudukko.getLeveys(), 10);
        assertEquals("Korkeus ei ollut alussa 10", ruudukko.getKorkeus(), 10);
    }
    
    @Test
    public void miinojaOikeaMaaraAlussa() {
        assertEquals("Miinoja ei ollut alussa 15", ruudukko.getMiinat(), 15);
    }
    
    @Test
    public void miinatAseteltuOikeinPelikenttaan() {
        for (int i = 0; i < 10; i++) {
           assertEquals("Kenttään ei ole asetettu oikea määrä miinoja!", ruudukko.getMiinat(), 15); 
        }
    }
    
    @Test
    public void miinojenAsettelijaAsettaaMiinatOikein() {
        List<Numeropari> kielletytParit = new ArrayList<>();
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                kielletytParit.add(new Numeropari(x, y));
            }
        }
        ruudukko.asetaRuuduilleMiinat(kielletytParit);
        assertEquals("Kielletyissä kenteissä oli miinoja", eiMiinojaKielletyissaPareissa(kielletytParit), true);
    }
    
    public boolean eiMiinojaKielletyissaPareissa(List<Numeropari> parit) {
        for (Numeropari pari : parit) {
            if (ruudukko.getRuutu(pari.getX(), pari.getY()).getMiina()) {
                return false;
            }
        }
        return true;
    }
}
