// Teilaufgabe b
public class DuplicateFoundException extends Exception {
    private int value;

    public DuplicateFoundException(int value){
        this.value = value;
    }

    public String toString(){
        return "Doppeltes ELement: " + this.value;
    }
}
