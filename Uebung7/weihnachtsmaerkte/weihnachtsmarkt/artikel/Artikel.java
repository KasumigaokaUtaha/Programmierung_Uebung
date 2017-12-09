package weihnachtsmarkt.artikel;

import zufall.Zufall;

public class Artikel {
    private String name;
    private double preis;

    public Artikel(){
        this.name = Zufall.artikel();
        this.preis = Zufall.zahl(1000)/100.0;
    }

    public String getName() {
        return this.name;
    }

    public String toString(){
        return name + " (" + preis + " Euro)";
    }

    public double getPreis() {
        return this.preis;
    }
}
