package labraharava.testit.komponentit;

import java.awt.Dimension;
import junit.framework.Assert;
import labraharava.paakansio.Alustus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AlustusTest {
    
    private Alustus alustus;
    
    @Before
    public void setUp() {
        alustus = new Alustus();
        alustus.run();
    }
    
    @Test
    public void alustajaLuoOikeanKokoisenIkkunan() {
        assertEquals("Ikkunan koko ei ollut 900x950", alustus.getFrame().getSize(), new Dimension(900, 950));
    }
    
    @Test
    public void paneelitLuotu() {
        assertNotNull("Yläpaneelia ei ole luotu.", alustus.getYlapaneeli());
        assertNotNull("Pelipaneelia ei ole luotu.", alustus.getPelipaneeli());
    }
    
    
}
