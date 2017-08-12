
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.layout.Border;
import javax.swing.*;
import labraharava.logiikka.Logiikka;

public class Ruutu extends JButton {
    
    private Boolean miina;
    private int miinatYmparilla;
    private Logiikka logiikka;
    
    public Ruutu(Logiikka logiikka, int x, int y) {
        this.miina = false;
        this.logiikka = logiikka;
        this.setPreferredSize(new Dimension(450, 450));
        
        Nappi nappi = new Nappi(logiikka, x, y);
        
        this.addMouseListener(nappi.getNapinKuuntelija());
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
