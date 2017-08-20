/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labraharava.komponentit;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import labraharava.paakansio.Alustus;

/**
  * Pelin yläpaneeli mikä sisältää pelin luomisnäppäimet.
  * Peli luodaan pelaajan syötteillä mikäli pelaajan syötteet
  * kelpaavat.
  */

public class Ylapaneeli extends JPanel {
    
    private Alustus alustus;
    private JButton uusiPeliNappi;
    private JTextField tekstikentta;
    private JTextField miinatekstikentta;
    private JTextField leveyskentta;
    private JTextField korkeuskentta;
    private JTextField miinakentta;
    
    /**
     * Yläpaneelin konstruktori. Kutsuu erillistä metodia
     * missä yläpaneeli luodaan.
     * @param alustus pelin alustus
     */
    
    public Ylapaneeli(Alustus alustus) {
        luoYlapaneelinKomponentit(alustus);
    }

    /**
     * Metodi luo pelipaneelin koon ja tyylin sekä komponentit.
     * @param alustus pelin alustus
     */
    
    public void luoYlapaneelinKomponentit(Alustus alustus) {
        this.alustus = alustus;
        this.setSize(new Dimension(600, 50));
        
        uusiPeliNappi = new JButton("Uusi peli");
        uusiPeliNappi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (onNumero(leveyskentta.getText()) && onNumero(korkeuskentta.getText()) && onNumero(miinakentta.getText())) {
                    
                    int leveys = Integer.parseInt(leveyskentta.getText());

                    int korkeus = Integer.parseInt(korkeuskentta.getText());

                    int miinat = Integer.parseInt(miinakentta.getText());
                    
                    alustus.valmisteleUusiPeli(leveys, korkeus, miinat);
                }
            }
        });
        
        tekstikentta = new JTextField();
        tekstikentta.setPreferredSize(new Dimension(100, 20));
        tekstikentta.setEditable(false);
        
        miinatekstikentta = new JTextField();
        miinatekstikentta.setPreferredSize(new Dimension(60, 20));
        miinatekstikentta.setEditable(false);
        
        leveyskentta = new JTextField();
        leveyskentta.setPreferredSize(new Dimension(60, 20));
        leveyskentta.setText("leveys");
        leveyskentta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                leveyskentta.setText("");
            }
        });
        
        korkeuskentta = new JTextField();
        korkeuskentta.setPreferredSize(new Dimension(60, 20));
        korkeuskentta.setText("korkeus");
        korkeuskentta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                korkeuskentta.setText("");
            }
        });
        
        this.miinakentta = new JTextField();
        this.miinakentta.setPreferredSize(new Dimension(60, 20));
        this.miinakentta.setText("miinat");
        miinakentta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                miinakentta.setText("");
            }
        });
        
        this.add(uusiPeliNappi);
        this.add(tekstikentta);
        this.add(miinatekstikentta);
        this.add(leveyskentta);
        this.add(korkeuskentta);
        this.add(miinakentta);
        
        alustus.getFrame().add(this);
    }
    
    /**
     * Metodi tarkistaa onko merkkijono kokonaisluku.
     * @param teksti tarkastettava merkkijono.
     * @return totuusarvo
     */
    private static boolean onNumero(String teksti) {
        try {
            int i = Integer.parseInt(teksti);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodi asettaa tekstit oikein uutta peliä varten.
     * @param teksti tekstikentan teksti
     * @param leveys pelin leveys
     * @param korkeus pelin korkeus
     * @param miinat pelin miinojen määrä
     */
    public void asetaTekstitUuttaPeliaVarten(String teksti, int leveys, int korkeus, int miinat) {
        tekstikentta.setText(teksti);
        miinatekstikentta.setText(Integer.toString(miinat) + "/" + Integer.toString(miinat));
        leveyskentta.setText(Integer.toString(leveys));
        korkeuskentta.setText(Integer.toString(korkeus));
        miinakentta.setText(Integer.toString(miinat));
    }
    
    public JButton getUusiPeliNappi() {
        return uusiPeliNappi;
    }
    
    public JTextField getTekstikentta() {
        return tekstikentta;
    }
    
    public JTextField getMiinatekstikentta() {
        return miinatekstikentta;
    }
    
    public JTextField getLeveyskentta() {
        return leveyskentta;
    }
    
    public JTextField getKorkeuskentta() {
        return korkeuskentta;
    }
    
    public JTextField getMiinakentta() {
        return miinakentta;
    }
}
