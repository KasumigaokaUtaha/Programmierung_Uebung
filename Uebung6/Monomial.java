public class Monomial{

  private final Power factor;

  private final Monomial factors;

    /**
     * Konstruktor
     * @param factor
     * @param factors
     */
  public Monomial(Power factor, Monomial factors){
    //TODO
      this.factor = factor;
      this.factors = factors;
  }

    /**
     * Konstruktor
     * @param toCopy
     */
  public Monomial(Monomial toCopy){
    //TODO
      this.factor = toCopy.getFactor();
      this.factors = toCopy.getFactors();

  }


    /**
     * Lift-Konstruktor
     * @param toLift
     */
  public Monomial(Power toLift){
        //TODO
      this.factor = toLift;
      this.factors = Monomial.ONE;
    }




  /**
  * The empty monomial interpreted as 1
  */
  public static final Monomial ONE = new Monomial(null,null);




    /**
     * Factorgetter
     * @return
     */
  public Power getFactor() {
        return this.factor;
  }


    /**
     * Factorsgetter
     * @return
     */
  public Monomial getFactors() {
        return this.factors;
  }

    /**
     * Entscheide ob ein Monom 0 ist.
     * @return
     */
  public boolean isZero(){
      if(this.factors == Monomial.ONE){
          return this.factor.isZero();
      }else{
          return this.factor.isZero() || this.factors.isZero();
      }
  }


  public String toString(){
      if(this.factor == null && this.factors == Monomial.ONE){
          return "1";
      }else if(this.factor == null){
          return this.factors.toString();
      }else if(this.factors == Monomial.ONE){
          return this.factor.toString();
      }else{
          return this.factor.toString() + "*" + this.factors.toString();
      }
  }

  public int getDegree(){
      if(this.isZero()){
          return 0;
      }else{
          return this.factor.getDegree() + this.factors.getDegree();
      }
  }

  public Monomial substitute(String toSubstitute, double value){
      if(this.isZero()){
          return Monomial.ONE;
      }else{
          return new Monomial(this.factor.substitute(toSubstitute, value), this.factors.substitute(toSubstitute, value));
      }
  }

  public double evaluate(double value){
      if(this.isZero()){
          return 0.0;
      }else if(!this.factors.isZero()){
          return this.factor.evaluate(value) * this.factors.evaluate(value);
      }else{
          return this.factor.evaluate(value);
      }
  }


/**
  * @param input String representation of monomial
  * @return the resulting monomial
  */
  public static Monomial parse(String input){
    if(input==null||input.equals("")){
      return ONE;
    }
    String[] splitted = input.split("\\*",2);
    if(splitted.length==1){
      return new Monomial(Power.parse(splitted[0]));
    }
    return new Monomial(Power.parse(splitted[0]),parse(splitted[1]));
  }

}
