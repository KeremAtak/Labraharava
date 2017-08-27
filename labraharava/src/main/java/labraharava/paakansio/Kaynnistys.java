package labraharava.paakansio;
/**
 * Käynnistys luo alustajan ja käynnistää sen.
 */
public class Kaynnistys {
   
    /**
     * Käynnistäjän konstruktori. Luo alustajan ja käynnistää sen.
     * @param args komentorivin argumentit
    */
    public static void main(String args[]) {
        Alustus alustus = new Alustus();
        alustus.run();
    }
}
