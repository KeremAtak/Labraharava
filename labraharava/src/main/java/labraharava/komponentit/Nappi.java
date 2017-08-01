
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.layout.Border;
import javax.swing.*;
import labraharava.miina.Logiikka;

public class Nappi extends JButton {
    
    private Boolean miina;
    private int miinatYmparilla;
    private Logiikka logiikka;
    private int x;
    private int y;
    
    public Nappi(Logiikka logiikka, int x, int y) {
        this.x = x;
        this.y = y;
        this.miina = false;
        this.logiikka = logiikka;
        this.setPreferredSize(new Dimension(60, 60));
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    painaVasenta();
                }
                if (e.getButton() == 3) {
                    painaOikeaa();
                }
            }
        });
    }
    
    private void painaVasenta() {
        logiikka.painaVasenta(x, y);
    }
    
    private void painaOikeaa() {
        logiikka.painaOikeaa(x, y);
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
