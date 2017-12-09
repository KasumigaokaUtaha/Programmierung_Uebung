package weihnachtsmarkt.staende;
import zufall.Zufall;
import io.SimpleIO;

public class Stand {
    private Verkaeufer verkaeufer;
    private int besucherProStunde;

    //
    public Stand(){
        this.verkaeufer = new Verkaeufer();
        this.besucherProStunde = this.berechneBesucherProStunde();
    }


    public int berechneBesucherProStunde(){
        return Zufall.zahl(100);
    }

    public void verkaufe(){
        boolean weiterKaufen = true;
        while(weiterKaufen){
            SimpleIO.output("Guten Tag!", "Kaufen");
            weiterKaufen = SimpleIO.getBoolean("Darf es sonst noch etwas sein?");
        }
    }

    protected void setBesucherProStunde(int number){
        this.besucherProStunde = number;
    }

    public Verkaeufer getVerkaeufer() {
        return this.verkaeufer;
    }

    public int getBesucherProStunde() {
        return this.besucherProStunde;
    }

    public String toString(){
        return "";
    }

    public String getName(){
        return "";
    }

    public static void main(String[] args){
        Stand test = new Stand();
        test.verkaufe();
    }
}
