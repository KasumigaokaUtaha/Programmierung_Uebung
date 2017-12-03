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
     * Entscheide ob ein Literal 0 ist.
     * @return ob ein Literal 0 ist
     */
    public boolean isZero(){
        if(this != null){
            return this.name.equals("") && (this.value == 0.0);
        }
        return false;
    }

    /**
    * Converts a literal object to String
    * @return the name of the variable or the constant in bracket
    */
    public String toString(){
        if(this != null){
            switch(this.name){
                //Konstante
                case "":
                    return "(" + this.value + ")";
                //Variable
                default:
                    return this.name;
            }
        }
        return "";
    }

    /**
    * Get the degree of an literal object
    * Constant has degree 0
    * Variable has degree 1
    * @return the resulting degree of a literal
    */
    public int getDegree(){
        if(this != null){
            switch(this.name){
                //Konstante
                case "":
                    return 0;
                //Variable
                default:
                    return 1;
            }
        }
        return 0;
    }

    /**
    * replace variable by value
    * @param toSubstitute the variable to be replaced
    * @param value value
    * @return the resulting literal object
    */
    public Literal substitute(String toSubstitute, double value){
        if(this.isZero()){
            return new Literal(this);
        }else if(toSubstitute.equals(this.name)){
            return new Literal(value);
        }else{
            return new Literal(this);
        }
    }

    /**
    * Evaluate an literal by replacing
    * the variable with a constant
    * @param value value
    * @return the resulting value
    */
    public double evaluate(double value){
        if(this.isZero()){
            return 0.0;
        }else if(!this.name.equals("")){
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
        }catch(NumberFormatException e){
            name = input;
        }
    return new Literal(name);
  }
}
