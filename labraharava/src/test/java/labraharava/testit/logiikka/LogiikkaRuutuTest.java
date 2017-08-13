
package labraharava.testit.logiikka;

import labraharava.komponentit.Nappi;
import labraharava.komponentit.Ruudukko;
import labraharava.komponentit.Ruutu;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LogiikkaRuutuTest {
    
    
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
    public void miinanVierestaPainettuaVainPainettuRuutuAvautuu() {
        poistaMiinat();
        asetaKaksiRuutua();
        ruudut[3][1].getNappi().painaVasenta();
        
        assertEquals("Painettu nappi ei pitäisi olla painettavissa", ruudut[3][1].isEnabled(), false);
        assertEquals("Vain painettu napin pitäisi olla painattamattomissa", ruudut[3][2].isEnabled(), true);
        assertEquals("Painettu nappi ei pitäisi olla painettavissa", ruudut[6][5].isEnabled(), true);
    }
    
    @Test
    public void miinaaPainattessaNappejaEiVoiPainaa() {
        poistaMiinat();
        asetaKaksiRuutua();
        ruudut[3][2].getNappi().painaVasenta();
        
        assertEquals("Kaikki ruudut pitäisivät olla painattamattomissa", ruudut[3][1].isEnabled(), false);
        assertEquals("Kaikki ruudut pitäisivät olla painattamattomissa", ruudut[3][2].isEnabled(), false);
        assertEquals("Kaikki ruudut pitäisivät olla painattamattomissa", ruudut[6][5].isEnabled(), false);
    }
    
    @Test
    public void tyhjaaKenttaaPainettuaMuitaKenttiaAukeaa1() {
        poistaMiinat();
        asetaKaksiRuutua();
        ruudut[3][7].getNappi().painaVasenta();
        
        assertEquals("Ruutu oli painettavissa kun sen ei pitänyt olla", ruudut[3][1].isEnabled(), false);
        assertEquals("Ruutu oli painettavissa kun sen ei pitänyt olla", ruudut[3][2].isEnabled(), false);
        assertEquals("Ruutu oli painettavissa kun sen ei pitänyt olla", ruudut[6][5].isEnabled(), false);
    }
    
    @Test
    public void tyhjaaKenttaaPainettuaMuitaKenttiaAukeaa2() {
        poistaMiinat();
        asetaKulmaanRuutuja();
        ruudut[0][0].getNappi().painaVasenta();
        
        assertEquals("Ruutu oli painettavissa kun sen ei pitänyt olla", ruudut[1][1].isEnabled(), false);
        assertEquals("Ruutu ei ollut painettavissa kun sen piti olla", ruudut[2][1].isEnabled(), true);
        assertEquals("Ruutu ei ollut painettavissa kun sen piti olla", ruudut[6][5].isEnabled(), true);
    }
    
    @Test
    public void kentissaOikeatNumerot1() {
        poistaMiinat();
        asetaKaksiRuutua();
        ruudut[3][7].getNappi().painaVasenta();
        
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[3][1].getText(), "2");
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[4][1].getText(), "1");
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[6][5].getText(), "");
    }
    
    @Test
    public void kentissaOikeatNumerot2() {
        poistaMiinat();
        asetaKulmaanRuutuja();
        ruudut[0][0].getNappi().painaVasenta();
        
        assertEquals("Ruutu oli painettavissa kun sen ei pitänyt olla", ruudut[1][1].getText(), "2");
        assertEquals("Ruutu ei ollut painettavissa kun sen piti olla", ruudut[1][0].getText(), "1");
    }
    
    
    private void asetaKaksiRuutua() {
        ruudut[2][2].setMiina(true);
        ruudut[3][2].setMiina(true);
    }
    
    private void asetaKulmaanRuutuja() {
        ruudut[1][2].setMiina(true);
        ruudut[2][1].setMiina(true);
    }
    
    private void poistaMiinat() {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                if (ruudut[x][y].getMiina()) {
                    ruudut[x][y].setMiina(false);
                }
            }
        }
    }
}
