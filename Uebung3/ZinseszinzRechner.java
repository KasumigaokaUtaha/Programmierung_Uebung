public class ZinseszinzRechner {
    public static void main(String[] args){

        double Startbetrag = SimpleIO.getDouble("Bitte geben Sie den Startbetrag ein:");
        double Zinssatz = SimpleIO.getDouble("Bitte geben Sie den Zinssatz als Prozentwert ein:");

        SimpleIO.output("Bitte waehlen Sie aus:", "ZinseszinzRechner");
        SimpleIO.output("Ziel: Berechnet die Zeit, bis ein gegebener Betrag angespart wurde.", "ZinseszinzRechner");
        SimpleIO.output("Zeit: Berechnet den Betrag, der nach einer gegebenen Zeit angespart wurde.", "ZinseszinzRechner");
        String destination= SimpleIO.getString("Bitte geben Sie Ziel oder Zeit ein.");

        if(destination.equals("")) {
            System.out.println("Es tritt einen Fehler auf.Das Programm wird bald beenden.");
        }else if(destination.equals("Ziel")) {
            double Zielbetrag = SimpleIO.getDouble("Bitte geben Sie den Zielbetrag ein:");
            double res = Startbetrag;
            int year = 0;
            
            while(res < Zielbetrag){
                res += res  * (Zinssatz / 100);
                year++;
            }

            SimpleIO.output("Es dauert "+ year +" Jahre bei einem Zinssatz von " + Zinssatz +"%, um von " + Startbetrag +" auf den Betrag " + Zielbetrag + " zu sparen. Nach dieser Zeit hat man " + res + ".", "Zinseszinsrechner");
        }else if(destination.equals("Zeit")){
            int year = SimpleIO.getInt("Bitte geben Sie die Zeit ein:");
            double res = Startbetrag;

            for(int i = 0;i < year;i++){
                res += res * (Zinssatz / 100);
            }

            SimpleIO.output("Bei einem Zinssatz von " + Zinssatz + " und einem Startbetrag von " + Startbetrag + " hat man nach " + year + " Jahren " + res + " gespart.", "Zinseszinsrechner");
        }
    }
}
