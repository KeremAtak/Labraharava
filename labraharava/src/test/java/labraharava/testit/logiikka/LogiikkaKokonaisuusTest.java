
package labraharava.testit.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import labraharava.komponentit.Nappi;
import labraharava.komponentit.Ruudukko;
import labraharava.komponentit.Ruutu;
import labraharava.logiikka.Logiikka;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LogiikkaKokonaisuusTest extends LogiikkatestinMetodit {
    
    
    
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
    
    @Test
    public void kentissaOikeatNumerot3() {
        luoEinelioruudukko();
        poistaMiinat();
        asetaKaksiRuutua();
        ruudut[3][7].getNappi().painaVasenta();
        
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[3][1].getText(), "2");
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[4][1].getText(), "1");
        assertEquals("Ruutuun oli luotu väärä teksti", ruudut[6][5].getText(), "");
    }
    
    @Test
    public void lippujaVoiAsettaaEnintaanMiinojenVerran1() {
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
        assertEquals("Lippuja ei voitu asettaa sen verran mitä miinoja oli", lippujenMaara, 15);
    }
    
    @Test
    public void lippujaVoiAsettaaEnintaanMiinojenVerran2() {
        luoEinelioruudukko();
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
        assertEquals("Lippuja ei voitu asettaa sen verran mitä miinoja oli", lippujenMaara, 20);
    }
    
    @Test
    public void lippuHaviaaKunOikeallaPainetaanKahdesti() {
        logiikka.painaOikeaa(2, 2);
        logiikka.painaOikeaa(2, 2);
        assertEquals("Lipun pitäisi hävitä kun oikeaa on painettu kahdesti", ruudut[2][2].isEnabled(), true);
    }
    
    @Test
    public void ruutujaAukeaaAinakinYmparillaOlevat1() {
        logiikka.painaEnsimmaistaRuutua(2, 2);
        assertEquals("Ymparillä ruudut eivät auenneet", ruudut[2][2].isEnabled(), true);
    }
    
    @Test
    public void ensimmaistaKertaaPainaessaYmparoivatRuudutAukeavat() {
        for (int i = 0; i < 10; i++) {
            logiikka.paataPeli("", java.awt.Color.red);
            logiikka.painaVasenta(2, 2);
            List<Ruutu> ymparoivatRuudut = ymparoivatRuudut();
            
            assertEquals("Ymparöivien ruutujen pitivät olla avattuja", ruudutOvatAvattuja(ymparoivatRuudut), true);
        }
    }
    
    public boolean ruudutOvatAvattuja(List<Ruutu> ymparoivatRuudut) {
        for (Ruutu ruutu : ymparoivatRuudut) {
            if (ruutu.isEnabled()) {
                return false;
            }
        }
        return true;
    }
}
