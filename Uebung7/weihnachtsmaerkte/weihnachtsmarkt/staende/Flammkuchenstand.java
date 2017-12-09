package weihnachtsmarkt.staende;

public class Flammkuchenstand extends Lebensmittelstand{

    public Flammkuchenstand(){
        super();
    }

    public String toString(){
        String temp = "Preis pro 100g: " + this.getPreisProHundert() + " Euro";
        temp += System.lineSeparator() + "Verkaeufer: " + this.getVerkaeufer().getName();
        temp += System.lineSeparator() + "Besucher pro Stunde: " + this.getBesucherProStunde();
        return temp;
    }

    public String getName(){
        return "Flammkuchenstand";
    }


    public static void main(String[] args){
        Flammkuchenstand test = new Flammkuchenstand();
        System.out.println(test.toString());
    }
}
