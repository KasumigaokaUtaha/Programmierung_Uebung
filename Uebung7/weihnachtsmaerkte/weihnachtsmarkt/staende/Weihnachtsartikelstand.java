package weihnachtsmarkt.staende;

import io.SimpleIO;
import zufall.Zufall;
import weihnachtsmarkt.artikel.Artikel;

public class Weihnachtsartikelstand extends Stand implements Verschiebarkeit{
    private Artikel[] artikels;

    public Weihnachtsartikelstand(){
        super();

        int quantity = Zufall.zahl(20) + 1;
        super.setBesucherProStunde(berechneBesucherProStunde(quantity));
        artikels = new Artikel[quantity];
        for(int i = 0;i < quantity;i++){
            this.artikels[i] = new Artikel();
        }
    }

    @Override
    public void verkaufe(){
        boolean weiterKaufen = true;
        double res = 0;

        while(weiterKaufen){
            if(isArtikelErhaeltlich()){
                System.out.println("Guten Tag!");
                System.out.println("Unsere Artikel sind:");
                System.out.println(this.auflist());
                int index = SimpleIO.getInt("Welchen Artikel moechten Sie kaufen?");
                res += this.artikels[index].getPreis();
                System.out.println(this.artikels[index].getName() + " wird eingepackt. Viel Spass damit!");
                weiterKaufen = SimpleIO.getBoolean("Darf es sonst noch etwas sein?");
                this.artikels[index] = null;
            }else{
                System.out.println("Entschuldigung, Artikeln sind schon ausverkauft.");
                break;
            }

        }

        System.out.printf("%.2f Euro, bitte.", res);

    }

    
    public void verschiebe(int index){
        int besucherProStunde = this.berechneBesucherProStunde();
        System.out.printf("Stand %d wurde verschoben und wird jetzt von %d Passanten pro Stunde besucht.", index, besucherProStunde);
        System.out.println();
    }

    public Artikel[] getArtikels(){
        return this.artikels;
    }

    private boolean isArtikelErhaeltlich(){
        for(int i = 0; i < this.artikels.length;i++){
            if(this.artikels[i] != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public int berechneBesucherProStunde(){
        int quantity = Zufall.zahl(20) + 1;
        int res = this.berechneBesucherProStunde(quantity);
        return res;
    }

    public int berechneBesucherProStunde(int quantityOfArtikels){
        int res = 0;
        for(int i = 0;i < quantityOfArtikels;i++){
            res += Zufall.zahl(5);
        }
        return res;
    }

    public String auflist(){
        String res = "";
        for(int i = 0;i < this.artikels.length;i++){
            if(this.artikels[i] != null){
                res = res + i + ": " + this.artikels[i].toString() + System.lineSeparator();
            }
        }
        return res;
    }

    public String toString(){
        String temp = "Verkaeufer: " + this.getVerkaeufer().getName();
        temp += System.lineSeparator() + "Besucher pro Stunde: " + this.getBesucherProStunde();
        return temp;
    }

    public String getName(){
        return "Weihnachtsartikelstand";
    }

    public static void main(String[] args){
        Weihnachtsartikelstand test = new Weihnachtsartikelstand();
        test.verkaufe();

//        for(Artikel x : test.getArtikels()){
//            System.out.println(x.toString());
//        }
//
//        System.out.println(test.getBesucherProStunde());
//        test.verschiebe(10);
    }
}
