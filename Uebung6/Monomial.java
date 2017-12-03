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
    //有问题
  public boolean isZero(){
//      if(this.factors == Monomial.ONE){
//          return this.factor.isZero();
//      }else{
//          return this.factor.isZero() || this.factors.isZero();
//      }

      if((this.factors == null || this.factors == Monomial.ONE) && this.factor == null){
          return false;
      }

      if(this.factors == null){
          return this.factor.isZero();
      }

      if(this.factor == null){
          return this.factors.isZero();
      }
      // this.factor and this.factors aren't null
      return this.factor.isZero() || this.factors.isZero();
  }


  public String toString(){
      if(this.factor == null && this.factors == null){
            return "";
      }else if(this.factor == null){
          if(this.factors == Monomial.ONE){
              return "1";
          }else{
              return this.factors.toString();
          }
      }else if(this.factors == null){
          return this.factor.toString();
      }else{
          String res = this.factor.toString();
          if(!(this.factors.toString().equals(""))){
              res = res + "*" + this.factors.toString();
          }
          return res;
      }
  }

  public int getDegree(){
      if(this.isZero()){
          return 0;
      }else{
          if(this.factors == null){
              return 0;
          }else if(this.factor == null){
                    if(this.factors == Monomial.ONE){
                        return 0;
                     }
              return this.factors.getDegree();
          }else{
              return this.factor.getDegree() + this.factors.getDegree();
          }
      }
  }

  public Monomial substitute(String toSubstitute, double value){
      if(this.factor == null && (this.factors == null || this.factors == Monomial.ONE)){
            try{
                return new Monomial(this);
            }catch(Exception e){
                System.out.println(e + "188");
            }
      }else if(this.factor != null && (this.factors == null || this.factors == Monomial.ONE)){
            try{
                return new Monomial(this.factor.substitute(toSubstitute,value));
            }catch(Exception e){
                System.out.println(e + "194");
            }
      }else if(this.factor == null && (this.factors != null && this.factors != Monomial.ONE)){
            try{
                return new Monomial(this.factors.substitute(toSubstitute, value));
            }catch(Exception e){
                System.out.println(e + "200");
            }
      }else{
          try{
              return new Monomial(this.factor.substitute(toSubstitute,value), this.factors.substitute(toSubstitute,value));
          }catch(Exception e){
              System.out.println(e + "206");
          }
      }
      return null;
  }

  public double evaluate(double value){
      if(this.factor == null && (this.factors == null || this.factors == Monomial.ONE)){
          try{
              return 1.0;
          }catch(Exception e){
              System.out.println(e + "225");
          }
      }else if(this.factor != null && (this.factors == null || this.factors == Monomial.ONE)){
          try{
              return this.factor.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "231");
          }
      }else if(this.factor == null && (this.factors != null && this.factors != Monomial.ONE)){
          try{
              return this.factors.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "237");
          }
      }else{
          try{
              return this.factor.evaluate(value) * this.factors.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "243");
          }
      }
      return 0.0;
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
