public class Main {

    public static void simuliere (Coffeemaker machine){
        // zu Beginn werden alle Faecher des Kaffeevollautomaten machine maximal auffuellen.
        machine.refill();

        labelA:
        while(true) {

            SimpleIO.output("Was moechten Sie trinken? \n" + "Zur Auswahl stehen", "");

            for (Hotdrink hotdrink : machine.sorts) {
                String str = "";
                int amountOfLarge = 0;
                int amountOfNormal = 0;

                double water = machine.currentwater / hotdrink.water;
                double milk = machine.currentmilk / hotdrink.milk;
                double beans = machine.currentbeans / hotdrink.beans;

                amountOfLarge = Math.min(Math.min((int) (water / 2), (int) (milk / 2)), (int) (beans / 2));
                amountOfNormal = Math.min(Math.min((int) (water), (int) (milk)), (int) (beans));


                if (amountOfNormal > 0) {
                    if (amountOfLarge > 0) {
                        str = "" + hotdrink.name + " Gross/Normal";
                        SimpleIO.output(str, "Verfuegbares Getraenk");
                    } else {
                        str = "" + hotdrink.name + " Nur Normal";
                        SimpleIO.output(str, "Verfuegbares Getraenk");
                    }
                }

            }

            String getraenk = SimpleIO.getString("Eingabe des Benutzers: ");
            String groesse = SimpleIO.getString("Gross? (J)a/ (N)ein");

            labelB:
            for(Hotdrink hotdrink : machine.sorts){

                switch(groesse){
                    case "J":
                        if(machine.getDrink(getraenk, true)){
                            SimpleIO.output("Hier ist Ihr gross " + hotdrink.name,"");
                            break labelB;
                        }else{
                            break labelA;
                        }
                    case "Ja":
                        if(machine.getDrink(getraenk, true)){
                            SimpleIO.output("Hier ist Ihr gross " + hotdrink.name,"");
                            break labelB;
                        }else{
                            break labelA;
                        }
                    case "N":
                        if(machine.getDrink(getraenk, false)){
                            SimpleIO.output("Hier ist Ihr normal " + hotdrink.name,"");
                            break labelB;
                        }else{
                            break labelA;
                        }
                    case "Nein":
                        if(machine.getDrink(getraenk, false)){
                            SimpleIO.output("Hier ist Ihr normal " + hotdrink.name,"");
                            break labelB;
                        }else{
                            break labelA;
                    }
                }

            }

        }

    }

    public static void main (String [] arguments) {

        Coffeemaker bean_to_cup  = new Coffeemaker();

        bean_to_cup.maxwater = 2.;

        bean_to_cup.maxmilk = 0.75;

        bean_to_cup.maxbeans = 1.0;

        bean_to_cup.sorts = new Hotdrink[3];

        String[] names = {"Latte Macchiato", "Milchkaffee", "Espresso"};

        double [] waterArray = {0.2, 0.2, 0.05};

        double [] milkArray = {0.3, 0.1, 0.0};

        double [] beansArray = {0.04, 0.05, 0.01};

        for(int i = 0; i < 3; i++){

            bean_to_cup.sorts[i] = new Hotdrink();

            bean_to_cup.sorts[i].name = names[i];

            bean_to_cup.sorts[i].water = waterArray[i];

            bean_to_cup.sorts[i].milk = milkArray[i];

            bean_to_cup.sorts[i].beans = beansArray[i];

        }

        bean_to_cup.refill();

        simuliere( bean_to_cup );

    }
}
