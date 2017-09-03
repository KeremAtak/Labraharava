package labraharava.testit.komponentit;

import labraharava.komponentit.Ruudukko;
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
}
