package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskennta;
    private JTextField syotekentta;
    private Integer vanha;
    
    Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskennta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        vanha = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskennta.setText("" + sovellus.tulos());
    }

    @Override
    public void peruuta() {
        sovellus.nollaa();
        sovellus.plus(vanha);
        syotekentta.setText("");
        tuloskennta.setText("" + sovellus.tulos());
    }
    
}
