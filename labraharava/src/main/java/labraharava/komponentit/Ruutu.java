
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.layout.Border;
import javax.swing.*;
import labraharava.logiikka.Logiikka;

   /**
     * Pelin ruutu. Sisältää nappi-olion ja tiedon montako miinaa on ruudun ympärillä sekä
     * tiedon onko ruudussa miina.
     */

public class Ruutu extends JButton {
    
    private Boolean miina;
    private Nappi nappi;
    private int miinatYmparilla;
    /**
     * Ruudun konstruktori. Asettaa ruudulle koon, tiedon sen sijainnista koordinaatistossa sekä
     * luo ruudulle napin ja asettaa ruudulle napin kuuntelijan.
     * @param logiikka pelin logiikka
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    public Ruutu(Logiikka logiikka, int x, int y) {
        this.miina = false;
        this.setPreferredSize(new Dimension(450, 450));
        
        this.nappi = new Nappi(logiikka, x, y);
        
        this.addMouseListener(nappi.getNapinKuuntelija());
    }
    
    public Nappi getNappi() {
        return nappi;
    }
    
    public boolean getMiina() {
        return miina;
    }
    
    public void setMiina(Boolean miina) {
        this.miina = miina;
    }
    
    public int getMiinatYmparilla() {
        return miinatYmparilla;
    }
    
    public void setMiinatYmparilla(int miinatYmparilla) {
        this.miinatYmparilla = miinatYmparilla;
    }
}
