public class Coffeemaker {
    public Hotdrink[] sorts; // contains available drinks
    public double maxmilk; // in Liter
    public double currentmilk; // die aktuelle Fuellung in (Liter bzw. Kilogramm) beschreibt.

    public double maxwater; // in Liter
    public double currentwater; // die aktuelle Fuellung in (Liter bzw. Kilogramm) beschreibt.

    public double maxbeans; // in kilogramm
    public double currentbeans; // die aktuelle Fuellung in (Liter bzw. Kilogramm) beschreibt.

    // den Wassertank, den Milchtank und das Kaffeebohnenfach maximal auffuellt.
    public void refill() {
        this.currentmilk = this.maxmilk;
        this.currentwater = this.maxwater;
        this.currentbeans = this.maxbeans;
    }

    private void updateFuellstand(double water, double milk, double beans) {
        this.currentwater -= water;
        this.currentmilk -= milk;
        this.currentbeans -= beans;
    }

    public boolean getDrink(String hotdrinkName, boolean large) {
        for (Hotdrink hotdrink : this.sorts) {

            if (hotdrink.name.equals(hotdrinkName)) {
                if (large) {
                    if(this.currentwater >= hotdrink.water * 2) {
                        if (this.currentmilk >= hotdrink.milk * 2) {
                            if (this.currentbeans >= hotdrink.beans * 2) {
                                updateFuellstand(hotdrink.water * 2, hotdrink.milk * 2, hotdrink.beans * 2);
                                return true;
                            } else {
                                SimpleIO.output("Nicht genug Kaffeebohnen", "Error");
                                return false;
                            }
                        } else {
                            SimpleIO.output("Nicht genug Milch", "Error");
                            return false;
                        }
                    }else{
                        SimpleIO.output("Nicht genug Wasser","Error");
                        return false;
                    }
                } else {
                    if(this.currentwater >= hotdrink.water) {
                        if (this.currentmilk >= hotdrink.milk) {
                            if (this.currentbeans >= hotdrink.beans) {
                                updateFuellstand(hotdrink.water, hotdrink.milk, hotdrink.beans);
                                return true;
                            } else {
                                SimpleIO.output("Nicht genug Kaffeebohnen", "Error");
                                return false;
                            }
                        } else {
                            SimpleIO.output("Nicht genug Milch", "Error");
                            return false;
                        }
                    }else{
                        SimpleIO.output("Nicht genug Wasser","Error");
                        return false;
                    }
                }
            }
        }
        SimpleIO.output("Es gibt kein solches Heissgetraenk","Error");
        return false;
    }


    public String toString(){
        String str = "";
        for(Hotdrink hotdrink : this.sorts){
            int amountOfLarge = 0;
            int amountOfNormal = 0;

            double water = this.currentwater / hotdrink.water;
            double milk = this.currentmilk / hotdrink.milk;
            double beans = this.currentbeans / hotdrink.beans;

            amountOfLarge = Math.min(Math.min((int)(water / 2), (int)(milk / 2)), (int)(beans / 2));
            amountOfNormal = Math.min(Math.min((int)(water), (int)(milk)), (int)(beans));

            str += "There is still " + amountOfLarge + " large or " + amountOfNormal + " normal"+ " cup of " + hotdrink.name + " available. \n" + "water:"+ this.currentwater +"milk:" + this.currentmilk + "beans:" + this.currentbeans +"\n";
        }
        return str;
    }
}
