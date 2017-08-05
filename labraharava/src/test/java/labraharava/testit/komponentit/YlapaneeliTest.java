package labraharava.testit.komponentit;

import labraharava.komponentit.Ylapaneeli;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class YlapaneeliTest {
    
    private Alustus alustus;
    private Ylapaneeli ylapaneeli;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
        ylapaneeli = alustus.getYlapaneeli();
    }
    
    @Test
    public void ylapaneelinKomponentitLuotu() {
        assertNotNull("Tekstikenttää ei ole luotu", ylapaneeli.getTekstikentta());
        assertNotNull("Miinatekstikenttää ei ole luotu", ylapaneeli.getMiinatekstikentta());
        assertNotNull("Leveyskenttää ei ole luotu", ylapaneeli.getLeveyskentta());
        assertNotNull("Korkeuskenttää ei ole luotu", ylapaneeli.getKorkeuskentta());
        assertNotNull("Miinakenttää ei ole luotu", ylapaneeli.getMiinakentta());
    }
    
    @Test
    public void ylapaneelinKomponenteissaOikeatTekstit() {
        assertEquals("Tekstikenttä pitäisi olla tyhjä", ylapaneeli.getTekstikentta().getText(), "");
        assertEquals("Miinatekstikentän teksti pitäisi olla muotoa 15/15", ylapaneeli.getMiinatekstikentta().getText(), "15/15");
        assertEquals("Leveyskentässä pitäisi näkyä kentän leveys", ylapaneeli.getLeveyskentta().getText(), "10");
        assertEquals("Korkeuskentässä pitäisi näkyä kentän leveys", ylapaneeli.getKorkeuskentta().getText(), "10");
        assertEquals("Miinakentässä pitäisi näkyä miinojen kokonaismäärä", ylapaneeli.getMiinakentta().getText(), "15");
    }
    
    @Test
    public void ylapaneelinKomponenttienMuokkausoikeudetKunnossa() {
        assertEquals("Tekstikenttä ei saa olla muokattavissa", ylapaneeli.getTekstikentta().isEditable(), false);
        assertEquals("Miinatekstikenttä ei saa olla muokattavissa", ylapaneeli.getMiinatekstikentta().isEditable(), false);
        assertEquals("Leveyskenttä pitää olla muokattavissa", ylapaneeli.getLeveyskentta().isEditable(), true);
        assertEquals("Korkeuskenttä pitää olla muokattavissa", ylapaneeli.getKorkeuskentta().isEditable(), true);
        assertEquals("Miinakenttä pitää olla muokattavissa", ylapaneeli.getMiinakentta().isEditable(), true);
    }
    
    @Test
    public void uudenPelinVoiLuodaKomponenteilla() {
        ylapaneeli.getLeveyskentta().setText("8");
        ylapaneeli.getKorkeuskentta().setText("8");
        ylapaneeli.getMiinakentta().setText("10");
        ylapaneeli.getUusiPeliNappi().doClick();
        assertEquals("Luodun pelin leveys ei ollut oikein", ylapaneeli.getLeveyskentta().getText(), "8");
        assertEquals("Luodun pelin korkeus ei ollut oikein", ylapaneeli.getKorkeuskentta().getText(), "8");
        assertEquals("Luodun pelin miinojen määrä ei ollut oikein", ylapaneeli.getMiinakentta().getText(), "10");
    }
    
    @Test
    public void uuttaPeliaEiLuodaVirheellisellaSyotteella() {
        ylapaneeli.getLeveyskentta().setText("8s");
        ylapaneeli.getKorkeuskentta().setText("dsa8");
        ylapaneeli.getMiinakentta().setText("10");
        ylapaneeli.getUusiPeliNappi().doClick();
    }
    
}
