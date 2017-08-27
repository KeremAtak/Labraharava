
package labraharava.logiikka;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import labraharava.komponentit.Ruudukko;
import labraharava.komponentit.Ruutu;

//Käyttämätön luokka, ei toimi
public class Ruudukkologiikka {
    
    private Ruudukko ruudukko;
    
    public Ruudukkologiikka(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }
    /**
     * Metodi alustaa ruudukon.
     */
    private void alustaRuudut() {
        for (int y = 0; y < ruudukko.getKorkeus(); y++) {
            for (int x = 0; x < ruudukko.getLeveys(); x++) {
                ruudut[x][y] = new Ruutu(logiikka, x, y);
                pelipaneeli.add(ruudut[x][y]);
            }
        }
    }
    
    /**
     * Metodi lukitsee kaikki ruudut, näyttää miinat ja värittää
     * miinat joko sinisellä tai punaisella.
     * @param c väri millä miinat värjätään, punainen kun pelaaja häviää ja sininen kun voittaa
     */
    public void lukitseRuudut(Color c) {
        for (int x = 0; x < ruudukko.getLeveys(); x++) {
            for (int y = 0; y < ruudukko.getKorkeus(); y++) {
                ruudukko.getRuutu(x, y).setEnabled(false);
                if (ruudukko.getRuutu(x, y).getMiina()) {
                    ruudukko.getRuutu(x, y).setText("X");
                    ruudukko.getRuutu(x, y).setBackground(c);
                }
            }
        }
    }
    
    /**
     * Metodi asettaa ruudukon ruutuihin miinoja annetun määrän.
     * Jos metodi arpoo miinan ruutuun missä on jo miina tai miina asetetaan kielletyn napin viereen
     * se arpoo uuden miinan koordinaatin
     * @param parit koordinaatit numeropareina mihin ei saa asettaa miinoja
     */
    public void asetaRuuduilleMiinat(List<Numeropari> parit) {
        Random random = new Random();
        int x = 0;
        int y = 0;
        for (Numeropari pari : parit) {
            System.out.println(pari.getX() + " " + pari.getY());
        }
        for (int i = 0; i < ruudukko.getMiinat(); i++) {
            while (true) { 
                x = random.nextInt(ruudukko.getLeveys());
                y = random.nextInt(ruudukko.getKorkeus());
                
                if (!ruudukko.getRuutu(x, y).getMiina() && !miinaAsetettuKiellettyynKenttaan(x, y, parit)) {
                    ruudukko.getRuutu(x, y).setMiina(true);
                    break;
                }
            }
        }
    }
    
    public boolean miinaAsetettuKiellettyynKenttaan(int x, int y, List<Numeropari> parit) {
        for (Numeropari pari : parit) {
            if (pari.getX() == x && pari.getY() == y) {
                return true;
            }
        }
        return false;
    }
}
