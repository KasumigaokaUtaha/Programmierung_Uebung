import java.util.Objects;

public class Literal{
  private final Typ type;
  private final double value;
  private final String name;

    /**
     * Konstande Konstruktor
     * @param value
     */
  public Literal(double value){
    //TODO
      this.type = Typ.VALUE;
      this.value = value;
      this.name = "";
  }

    /**
     * Variable Konstruktor
     * @param name
     */
  public Literal(String name){
    //TODO
      this.type = Typ.VAR;
      this.value = 0;
      this.name = name;
  }

    /**
     * Kopierkonstuktor
     * @param toCopy
     */
  public Literal (Literal toCopy){
    //TODO
      this.type = toCopy.getType();
      this.value = toCopy.getValue();
      this.name = toCopy.getName();
  }

    /**
     * Typegetter
     * @return
     */
    public Typ getType() {
        return this.type;
    }

    /**
     * Valuegetter
     * @return
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Namegetter
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *Entscheide ob ein Literal 0 ist.
     * @return
     */
    public boolean isZero(){
        return Objects.equals(this.name, "") && (this.value == 0.0);
    }


    public String toString(){
        switch(this.name){
            //Konstante
            case "":
                return (this.value) + "";
            //Variable
            default:
                return this.name;
        }
    }

    public int getDegree(){
        switch(this.name){
            //Konstante
            case "":
                return 0;
            //Variable
            default:
                return 1;
        }
    }

    public Literal substitute(String toSubstitute, double value){
        if(this.isZero() || Objects.equals(this.name, "")){
            return this;
        }else if(toSubstitute == this.name){
            return new Literal(value);
        }else{
            return this;
        }
    }

    public double evaluate(double value){
        if(this.isZero()){
            return 0.0;
        }else if(!Objects.equals(this.name, "")){
            // Literal ist eine Variable
            return value;
        }else{
            // Literal ist eine Konstante
            return this.value;
        }
    }


    /**
     * Converts an input string to a literal
     * @param input  String representation of literal
     * @return the resulting literal
     */
    public static Literal parse(String input){
    if(input==null || input.equals("")){
      return new Literal(1.);
    }
    double value = 0.;
    String name = "";
    input = input.replaceAll("[()]","");
    try{
      value = Double.parseDouble(input);
      return new Literal(value);
    }
    catch(NumberFormatException e){
      name = input;
    }
    return new Literal(name);
  }

}
