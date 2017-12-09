package weihnachtsmarkt.staende;

import io.SimpleIO;
import zufall.Zufall;


public class Lebensmittelstand extends Stand{
    private final double preisProHundert; // fixed price for 100g Things to sell

    public Lebensmittelstand() {
        this.preisProHundert = Zufall.zahl(300) / 100.0;
    }

    @Override
    public void verkaufe() {
        boolean weiterKaufen = true;
        double res = 0.0;
        int temp = 0;

        while(weiterKaufen){
            System.out.println("Guten Tag!");
            System.out.println("Preis pro 100g: " + this.preisProHundert + " Euro");
            int gramm = SimpleIO.getInt("Wie viel Gramm moechten Sie?");
            temp += gramm;
            System.out.println(gramm + " Gramm fuer Sie. Lassen Sie es sich schmecken!");
            weiterKaufen = SimpleIO.getBoolean("Darf es sonst noch etwas sein?");
        }

        res = temp / 100 * this.preisProHundert;
        System.out.println(res + "Euro, bitte.");

    }

    public String getName(){
        return "Lebensmittelstand";
    }

    public double getPreisProHundert(){
        return this.preisProHundert;
    }

    public static void main(String[] args){
        Lebensmittelstand test = new Lebensmittelstand();
        test.verkaufe();
    }
}
