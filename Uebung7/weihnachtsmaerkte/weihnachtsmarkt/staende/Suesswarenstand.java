package weihnachtsmarkt.staende;

import zufall.Zufall;

public class Suesswarenstand extends Lebensmittelstand implements Verschiebarkeit{
    private final String suesswaren;

    public Suesswarenstand(){
        this.suesswaren = Zufall.suessware();
    }

    public void verschiebe(int index){
        int besucherProStunde = super.berechneBesucherProStunde();
        System.out.printf("Stand %d wurde verschoben und wird jetzt von %d Passanten pro Stunde besucht.", index, besucherProStunde);
        System.out.println();
    }

    public String toString(){
        String temp = "Preis pro 100g: " + this.getPreisProHundert() + " Euro";
        temp += System.lineSeparator() + "Verkaeufer: " + this.getVerkaeufer().getName();
        temp += System.lineSeparator() + "Besucher pro Stunde: " + this.getBesucherProStunde();
        return temp;
        }

    public String getName(){
        return "Suesswarenstand";
    }

    public static void main(String[] args){
        Suesswarenstand test = new Suesswarenstand();
        test.verschiebe(9);
    }
}
