package labraharava.testit.komponentit;

import labraharava.komponentit.Nappi;
import labraharava.komponentit.Pelipaneeli;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PelipaneeliTest {
    
    private Alustus alustus;
    private Pelipaneeli pelipaneeli;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        pelipaneeli = alustus.getPelipaneeli();
    }
    
    @Test
    public void kenttiaOikeaMaaraAlussa() {
        assertEquals("Leveys ei ollut alussa 10", pelipaneeli.getLeveys(), 10);
        assertEquals("Korkeus ei ollut alussa 10", pelipaneeli.getKorkeus(), 10);
    }
    
    @Test
    public void miinojaOikeaMaaraAlussa() {
        assertEquals("Miinoja ei ollut alussa 15", pelipaneeli.getMiinat(), 15);
    }
    
    @Test
    public void miinatAseteltuOikeinPelikenttaan() {
        for (int i = 0; i < 10; i++) {
           assertEquals("Kenttään ei ole asetettu oikea määrä miinoja!", pelipaneeli.getMiinat(), 15); 
        }
    }
    
    private int laskeKentanMiinat() {
        int palautus = 0;
        Nappi[][] napit = pelipaneeli.getNapit();
        for (int x = 0; x < pelipaneeli.getLeveys(); x++) {
            for (int y = 0; y < pelipaneeli.getKorkeus(); y++) {
                if (napit[x][y].getMiina()) {
                    palautus++;
                }
            }
        }
        return palautus;
    }
}
