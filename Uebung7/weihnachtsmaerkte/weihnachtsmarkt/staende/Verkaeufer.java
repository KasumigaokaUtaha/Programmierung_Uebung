package weihnachtsmarkt.staende;

import zufall.Zufall;

public class Verkaeufer {
    private String name;

    public Verkaeufer(){
        this.name = Zufall.name();
    }

    public String getName() {
        return this.name;
    }
}
