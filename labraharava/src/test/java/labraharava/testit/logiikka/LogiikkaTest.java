package labraharava.testit.logiikka;

import java.util.ArrayList;
import java.util.List;
import labraharava.logiikka.Numeropari;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LogiikkaTest extends LogiikkatestinMetodit {
    
    @Test
    public void logiikkaOsaaTarkistaaMiinan1() {
        ruudut[2][2].setMiina(true);
        ruudut[2][3].setMiina(false);
        
        assertEquals("Logiikka ei osannut tarkistaa miinaa oikein", logiikka.onkoMiina(new Numeropari(2, 2)), true);
        assertEquals("Logiikka ei osannut tarkistaa miinaa oikein", logiikka.onkoMiina(new Numeropari(2, 3)), false);
    }
    
    @Test
    public void logiikkaOsaaTarkistaaMiinan2() {
        luoEinelioruudukko();
        ruudut[2][2].setMiina(true);
        ruudut[2][3].setMiina(false);
        
        assertEquals("Logiikka ei osannut tarkistaa miinaa oikein", logiikka.onkoMiina(new Numeropari(2, 2)), true);
        assertEquals("Logiikka ei osannut tarkistaa miinaa oikein", logiikka.onkoMiina(new Numeropari(2, 3)), false);
    }
    
    @Test
    public void logiikkaOsaaLaskeaMiinojenMaaran1() {
        poistaMiinat();
        ruudut[2][2].setMiina(true);
        ruudut[2][3].setMiina(true);
        List<Numeropari> numeroparit = new ArrayList<>();
        
        numeroparit.add(new Numeropari(2,1));
        numeroparit.add(new Numeropari(2,2));
        numeroparit.add(new Numeropari(2,3));
        
        assertEquals("Logiikka ei laskenut miinojen määrää oikein!", logiikka.laskeMiinat(numeroparit), 2);
    }
    
    @Test
    public void logiikkaOsaaLaskeaMiinojenMaaran2() {
        luoEinelioruudukko();
        poistaMiinat();
        ruudut[2][2].setMiina(true);
        ruudut[2][3].setMiina(true);
        List<Numeropari> numeroparit = new ArrayList<>();
        
        numeroparit.add(new Numeropari(2,1));
        numeroparit.add(new Numeropari(2,2));
        numeroparit.add(new Numeropari(2,3));
        
        assertEquals("Logiikka ei laskenut miinojen määrää oikein!", logiikka.laskeMiinat(numeroparit), 2);
    }
}
