package weihnachtsmarkt.staende;

public class Gluehweinstand extends Lebensmittelstand{

    public String toString(){
        String temp = "Preis pro 100g: " + this.getPreisProHundert() + " Euro";
        temp += System.lineSeparator() + "Verkaeufer: " + this.getVerkaeufer().getName();
        temp += System.lineSeparator() + "Besucher pro Stunde: " + this.getBesucherProStunde();
        return temp;
    }

    public String getName(){
        return "Gluehweinstand";
    }
}
