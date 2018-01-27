/**
 * Diese Klasse implementiert eine Aufzugsteuerung. Der Aufzug kann zu
 * bestimmten Stockwerken gerufen werden und mit der Methode aufzugStarten()
 * wird jeweils immer ein neues Stockwerk abgearbeitet, sofern mindestens eines
 * angefragt ist.
 */
public class AufzugSteuerung {
    private final boolean[] stockwerkAngefragt;

    private AufzugZustand zustand;

    private final Aufzug aufzug;

    /**
     * Erzeugt eine Steuerung zu einem gegebenen Aufzug.
     * @param aufzug der zu steuernde Aufzug
     */
    public AufzugSteuerung(Aufzug aufzug) {
        // d)
        this.aufzug = aufzug;
        this.aufzug.tuerOeffnen();
        if(this.aufzug.getMinStockwerk() <= 0){
            this.stockwerkAngefragt = new boolean[aufzug.getMaxStockwerk() - aufzug.getMinStockwerk() + 1];
        }else{
            this.stockwerkAngefragt = new boolean[aufzug.getMaxStockwerk() - aufzug.getMinStockwerk()];
        }

        this.zustand = AufzugZustand.Warten;
    }

    /**
     * Gibt das aktuelle Stockwerk, normalisiert als Array-Index, zurueck.
     * @return Index des aktuellen Stockwerks
     */
    private int aktuellesStockwerk() {
        return aufzug.getAktuellesStockwerk() - aufzug.getMinStockwerk();
    }

    /**
     * Faehrt den Aufzug zu einem gegebenen Stockwerk.
     * @param stockwerk Der Array-Index des Stockwerks
     */
    private void fahren(int stockwerk) {
        aufzug.tuerSchliessen();
        aufzug.fahren(stockwerk + aufzug.getMinStockwerk());
        aufzug.tuerOeffnen();
    }

    /**
     * Ruft den Aufzug zu einem gegebenen Stockwerk. Das Stockwerk
     * wird intern in einen Array-Index umgerechnet. Das aktuelle
     * Stockwerk kann nicht angefragt werden, der Aufzug ist ja schon da.
     * @param stockwerk Die Nummer des Stockwerks
     */
    public void rufen(int stockwerk) {
        if(aufzug.getAktuellesStockwerk() != stockwerk
                && stockwerk <= aufzug.getMaxStockwerk()
                && stockwerk >= aufzug.getMinStockwerk()) {
            this.stockwerkAngefragt[stockwerk - aufzug.getMinStockwerk()] = true;
        }
    }


    /**
     * Arbeitet ein Stockwerk ab, sofern mindestens ein Stockwerk
     * angefragt ist.
     */
    public void aufzugStarten() {
        // e)
            int anfrageIndex1 = 0;
            boolean isanfrageIndex1Besetzt = false;
            int anfrageIndex2 = 0;
            boolean isanfrageIndex2Besetzt = false;

            int minEntfernung = this.stockwerkAngefragt.length;

            //erste Schleife
            for(int i = 0;i < this.stockwerkAngefragt.length;i++){
                int tempEntfernung = Math.abs(this.aktuellesStockwerk() - i);
                if(this.stockwerkAngefragt[i] && tempEntfernung <= minEntfernung){
                    minEntfernung = tempEntfernung;
                    anfrageIndex1 = i;
                    isanfrageIndex1Besetzt = true;

                }
            }

            //zweite Schleife
            minEntfernung = Math.abs(this.aktuellesStockwerk() - anfrageIndex1);
            for(int i = 0;i < this.stockwerkAngefragt.length;i++){
                int tempEntfernung = Math.abs(this.aktuellesStockwerk() - i);
                if(this.stockwerkAngefragt[i] && tempEntfernung <= minEntfernung && !(i == anfrageIndex1)){
                    anfrageIndex2 = i;
                    isanfrageIndex2Besetzt = true;

                }
            }


            switch (this.zustand) {
                case Warten:
                    if(isanfrageIndex1Besetzt && isanfrageIndex2Besetzt
                            && anfrageIndex1 - this.aktuellesStockwerk() >= 0){

                        if(anfrageIndex1 == this.aktuellesStockwerk()){
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                        }else {
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                            this.zustand = AufzugZustand.Hoch;
                        }
                     }else if(isanfrageIndex1Besetzt && isanfrageIndex2Besetzt
                            && anfrageIndex2 - this.aktuellesStockwerk() >= 0) {

                        if(anfrageIndex2 == this.aktuellesStockwerk()){
                            this.stockwerkAngefragt[anfrageIndex2] = false;
                        }else{
                            this.fahren(anfrageIndex2);
                            this.stockwerkAngefragt[anfrageIndex2] = false;
                            this.zustand = AufzugZustand.Hoch;

                        }
                    }else if(isanfrageIndex1Besetzt) {
                        if (anfrageIndex1 - this.aktuellesStockwerk() > 0) {
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                            this.zustand = AufzugZustand.Hoch;
                        } else {
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                            this.zustand = AufzugZustand.Runter;
                        }
                    }
                    if(isanfrageIndex1Besetzt == false && isanfrageIndex2Besetzt == false) {
                        this.zustand = AufzugZustand.Warten;
                    }
                    break;

                case Hoch:
                    if(isanfrageIndex1Besetzt && isanfrageIndex2Besetzt){
                        if(anfrageIndex1 - this.aktuellesStockwerk() > 0){
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                        }else{
                            this.fahren(anfrageIndex2);
                            this.stockwerkAngefragt[anfrageIndex2] = false;
                        }
                    }else if(isanfrageIndex1Besetzt){
                        if(anfrageIndex1 - this.aktuellesStockwerk() >= 0){
                            if(anfrageIndex1 == this.aktuellesStockwerk()){
                                break;
                            }else{
                                this.fahren(anfrageIndex1);
                                this.stockwerkAngefragt[anfrageIndex1] = false;
                            }
                        }else if(anfrageIndex1 - this.aktuellesStockwerk() < 0){
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                            this.zustand = AufzugZustand.Runter;
                        }
                    }
                    if(isanfrageIndex1Besetzt == false && isanfrageIndex2Besetzt == false) {
                        this.zustand = AufzugZustand.Warten;
                    }
                    break;
                case Runter:
                    if(isanfrageIndex1Besetzt && isanfrageIndex2Besetzt){
                        if(anfrageIndex1 - this.aktuellesStockwerk() < 0){
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                        }else{
                            this.fahren(anfrageIndex2);
                            this.stockwerkAngefragt[anfrageIndex2] = false;
                        }
                    }else if(isanfrageIndex1Besetzt){
                        if(anfrageIndex1 - this.aktuellesStockwerk() <= 0){
                            if(anfrageIndex1 == this.aktuellesStockwerk()){
                                break;
                            }else{
                                this.fahren(anfrageIndex1);
                                this.stockwerkAngefragt[anfrageIndex1] = false;
                            }
                        }else if(anfrageIndex1 - this.aktuellesStockwerk() > 0){
                            this.fahren(anfrageIndex1);
                            this.stockwerkAngefragt[anfrageIndex1] = false;
                            this.zustand = AufzugZustand.Hoch;
                        }
                    }
                    if(isanfrageIndex1Besetzt == false && isanfrageIndex2Besetzt == false) {
                        this.zustand = AufzugZustand.Warten;
                    }
                    break;
            }
    }
}
