/**
 * Diese Klasse implementiert einen Aufzug, der zu bestimmten Stockwerken gefahren werden kann.
 */
public class Aufzug {
    private int aktuellesStockwerk; // aktuelles Stockwerk

    private int AnzahlPersonen; // die Anzahl Personen, die aktuell im Aufzug sind

    private boolean isTuerAuf; //

    private final int maxStockwerk;

    private final int minStockwerk;

    private final int maxPersonen;

    private int ID;

    private static int IDiterator = 0;

    /**
     * Erzeuge einen Aufzug mit maxStockwerk, maxPersonen, minStockwerk,
     * isTuerAuf = false, AnzahlPersonen = 0, aktuellesStockwerk = 0.
     * @param maxStockwerk das hoechste Stockwerk
     * @param minStockwerk das niedrigste Stockwerk
     * @param maxPersonen die Anzahl an maximalen Personen
     */
    public Aufzug(int maxStockwerk, int minStockwerk, int maxPersonen){
        this.maxStockwerk = maxStockwerk;
        this.minStockwerk = minStockwerk;
        this.maxPersonen = maxPersonen;

        this.isTuerAuf = false;
        this.AnzahlPersonen = 0;
        this.aktuellesStockwerk = this.minStockwerk;

        this.ID = Aufzug.IDiterator;
        Aufzug.IDiterator++;

    }

    /**
     * Erzeuge einen Aufzug mit maxStockwerk, maxPersonen, minStockwerk = 0,
     * isTuerAuf = false, AnzahlPersonen = 0, aktuellesStockwerk = 0.
     * @param maxStockwerk das hoechste Stockwerk
     * @param maxPersonen die Anzahl an maximalen Personen
     */
    public Aufzug(int maxStockwerk, int maxPersonen){
        this.maxStockwerk = maxStockwerk;
        this.maxPersonen = maxPersonen;
        this.minStockwerk = 0;

        this.isTuerAuf = false;
        this.AnzahlPersonen = 0;
        this.aktuellesStockwerk = this.minStockwerk;

        this.ID = Aufzug.IDiterator;
        Aufzug.IDiterator++;
    }

    /**
     * Oeffne die Tuer
     */
    public void tuerOeffnen(){
        this.isTuerAuf = true;
    }

    /**
     * Schliesse die Tuer
     */
    public void tuerSchliessen(){
        this.isTuerAuf = false;
    }

    /**
     * Simuliere den Fall, dass Passagieren einsteigen moechten.
     * @param anzahlAnEinstiegPersonen die Anzahl der Personen, die einsteigen moechten
     * @return die Anzahl der Personen, die nicht einsteigen koennen.
     */
    public int einsteigen(int anzahlAnEinstiegPersonen){
        int NichtEinstiegPersonen;

        if(this.isTuerAuf
                && this.AnzahlPersonen + anzahlAnEinstiegPersonen <= maxPersonen){

                this.AnzahlPersonen = this.AnzahlPersonen + anzahlAnEinstiegPersonen;
                NichtEinstiegPersonen = 0;
                return NichtEinstiegPersonen;
        }else if(this.isTuerAuf
                && this.AnzahlPersonen + anzahlAnEinstiegPersonen > maxPersonen){

                NichtEinstiegPersonen = this.AnzahlPersonen + anzahlAnEinstiegPersonen - maxPersonen;

                this.AnzahlPersonen = maxPersonen;

                return NichtEinstiegPersonen;
        }else{
            return anzahlAnEinstiegPersonen;
        }

    }

    /**
     * Simuliere den Fall, dass Passagieren aussteigen moechenten.
     * @param anzahlAnAusstiegPersonen die Anzahl der Personen, die aussteigen moechten.
     */
    public void aussteigen(int anzahlAnAusstiegPersonen){
        if(this.isTuerAuf
                && this.AnzahlPersonen - anzahlAnAusstiegPersonen >= 0){
            this.AnzahlPersonen = this.AnzahlPersonen - anzahlAnAusstiegPersonen;
        }else if(this.isTuerAuf
                && this.AnzahlPersonen - anzahlAnAusstiegPersonen < 0){
            this.AnzahlPersonen = 0;
        }
    }

    /**
     * Faehrt zu angegebenem Stockwerk
     * @param stockwerk das Stockwerk, das man erreichen moechten.
     * @return Gibt zurueck, ob der Aufzug tatsaechlich gefahren ist.
     */
    public boolean fahren(int stockwerk){
        if(!isTuerAuf && minStockwerk <= stockwerk
                && stockwerk <= maxStockwerk){

            this.aktuellesStockwerk = stockwerk;
            return true;
        }else if(!isTuerAuf && stockwerk < minStockwerk){

            this.aktuellesStockwerk = this.minStockwerk;
            return true;
        }else if(!isTuerAuf && stockwerk > maxStockwerk){

            this.aktuellesStockwerk = this.maxStockwerk;
            return true;
        }

        return false;
    }

    /**
     * Gibt das aktuelle Stockwerk zurueck
     * @return der Index des aktuellen Stockwerk
     */
    public int getAktuellesStockwerk(){
        return this.aktuellesStockwerk;
    }

    /**
     * Gibt die Anzahl der Personen, die aktuell im Aufzug sind, zurueck
     * @return die Anzahl der aktuell im Aufzug stehenden Personen
     */
    public int getAnzahlPersonen(){
        return this.AnzahlPersonen;
    }

    /**
     * Gibt true zurueck, wenn die Tuer auf ist, sonst false.
     * @return ob die Tuer auf ist.
     */
    public boolean isTuerAuf(){
        return this.isTuerAuf;
    }

    /**
     * Gibt das maximale Stockwerk zurueck.
     * @return das maximale Stockwerk
     */
    public int getMaxStockwerk(){
        return this.maxStockwerk;
    }

    /**
     * Gibt das minimale Stockwerk zurueck.
     * @return das minimale Stockwerk
     */
    public int getMinStockwerk(){
        return this.minStockwerk;
    }

    /**
     * Gibt die Anzahl der maximal tragbaren Personen zurueck
     * @return die Anzahl der maximalen Personen
     */
    public int getMaxPersonen(){
        return this.maxPersonen;
    }

    /**
     * Gibt die ID des Aufzuges zurueck, die ID von 0 anfaengt.
     * @return ID
     */
    public int getID(){
        return this.ID;
    }
}
