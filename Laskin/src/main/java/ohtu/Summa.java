package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskennta;
    private JTextField syotekentta;
    private Integer vanha;
    
    Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskennta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        vanha = sovellus.tulos();
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
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
