public class Power{
  private final int exponent;
  private final Literal literal;

    /**
     * Konstruktor
     * @param exponent  der Exponent
     * @param literal das Literal
     */
  public Power(int exponent, Literal literal){
    //TODO
      if(exponent < 0){
          this.exponent = 0;
      }else{
          this.exponent = exponent;
      }
      this.literal = literal;
  }

    /**
     * Konstruktor
     * @param literal das Literal
     */
  public Power(Literal literal){
    //TODO
        this.exponent = 1;
        this.literal = literal;
  }

    /**
     * Kopierkonstruktor
     * @param toCopy
     */
  public Power(Power toCopy){
    //TODO
      this.exponent = toCopy.getExponent();
      this.literal = toCopy.getLiteral();

  }

    /**
     * Exponentgetter
     * @return
     */
    public int getExponent() {
        return this.exponent;
    }

    /**
     * Literalgetter
     * @return
     */
    public Literal getLiteral() {
        return this.literal;
    }

    /**
     * Entscheide ob ein Potenz 0 ist.
     * @return
     */
    public boolean isZero(){
        return this.literal == null || (this.literal.isZero() && this.getExponent() > 0);
    }



    public String toString(){
        if(this.literal != null){
            switch(this.exponent){
                case 0:
                    return "1";
                case 1:
                    return this.literal.toString();
                default:
                    return this.literal.toString() + "^" + this.exponent;
            }
        }
        return null;
    }

    public int getDegree(){
        if(this.literal != null){
            return this.literal.getDegree() * this.exponent;
        }
        return 0;
    }

    public Power substitute(String toSubstitute, double value){
        if(this.isZero()){
            return new Power(this);
        }else{
            return new Power(this.exponent, this.literal.substitute(toSubstitute, value));
        }
    }

    public double evaluate(double value){
        if(this.isZero()){
            return 0.0;
        }else{
            return Math.pow(this.literal.evaluate(value), this.exponent);
        }
    }

/**
  * Converts an input string to a power
  * Input
  * @param input  String representation of literal ^ exponent
  * @return the resulting power
  */
    public static Power parse(String input){
        if(input == null || input.equals("")){
            return new Power(Literal.parse(""));
    }
    String[] splitted = input.split("\\^",2);
        if(splitted.length==1){
            return new Power(Literal.parse(splitted[0]));
        }
    int exponent = 1;
    try{
      exponent = Integer.parseInt(splitted[1]);
    }
    catch(NumberFormatException e){
      exponent = 1;
    }
    return new Power(exponent, Literal.parse(splitted[0]));
  }
}
