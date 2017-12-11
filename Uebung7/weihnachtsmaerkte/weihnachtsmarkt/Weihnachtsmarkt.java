package weihnachtsmarkt;
import io.SimpleIO;
import zufall.Zufall;
import weihnachtsmarkt.staende.*;

public class Weihnachtsmarkt {
    private Stand[] staenden;

    public Weihnachtsmarkt(int anzahlAnStand){
        this.staenden = new Stand[anzahlAnStand];
        int quotient = anzahlAnStand / 4;
        int remainder = anzahlAnStand % 4;

        for(int i = 0; i < 4; i++){
            for(int j = 0;j < quotient;){
                int position = Zufall.zahl(anzahlAnStand);
                if(this.staenden[position] == null){
                    switch(i){
                        case 0:
                            this.staenden[position] = new Weihnachtsartikelstand();
                            j++;
                            break;
                        case 1:
                            this.staenden[position] = new Suesswarenstand();
                            j++;
                            break;
                        case 2:
                            this.staenden[position] = new Gluehweinstand();
                            j++;
                            break;
                        case 3:
                            this.staenden[position] = new Flammkuchenstand();
                            j++;
                            break;
                    }
                }
            }
        }

        if(remainder > 0){
            for(int i = 0; i < remainder;i++){
                int index = castingIndex(this.staenden);
                switch(i){
                    case 0:
                        this.staenden[index] = new Weihnachtsartikelstand();
                        break;
                    case 1:
                        this.staenden[index] = new Suesswarenstand();
                        break;
                    case 2:
                        this.staenden[index] = new Gluehweinstand();
                }
            }
        }
    }

    private int castingIndex(Stand[] array){
        for(int i = 0;i < array.length;i++){
            if(array[i] == null){
                return i;
            }
        }
        return 0;
    }

    public Stand[] getStaenden(){
        return this.staenden;
    }

    //test
    public static void main(String[] args){
        Weihnachtsmarkt test = new Weihnachtsmarkt(5);
        boolean weiterKaufen = true;
        while(weiterKaufen){
            System.out.println("Der Weihnachtsmarkt besteht aus folgenden Staenden:" + System.lineSeparator());
            for(int i = 0;i < 5;i++){
                System.out.printf("%d: %s: ", i, test.getStaenden()[i].getName());
                System.out.println();
                System.out.println(test.getStaenden()[i].toString());
                System.out.println();
            }

            int index = SimpleIO.getInt("Welchen Stand moechten Sie besuchen?");
            test.getStaenden()[index].verkaufe();

            for(int j = 0;j < 5;j++){
                Stand temp = test.getStaenden()[j];
                if(temp instanceof Suesswarenstand && temp.getBesucherProStunde() < 30){
                    System.out.println();
                    ((Suesswarenstand) temp).verschiebe(j);
                }else if(temp instanceof Weihnachtsartikelstand && temp.getBesucherProStunde() < 30){
                    System.out.println();
                    ((Weihnachtsartikelstand) temp).verschiebe(j);
                }
            }
            boolean temp = SimpleIO.getBoolean("Moechten Sie den Weihnachtsmarkt verlassen?");
            weiterKaufen = !temp;
        }
    }
}
