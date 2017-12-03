public class Polynomial{

  private final Monomial summand;

  private final Polynomial summands;

  public Polynomial(Monomial summand, Polynomial summands){
    //TODO
      this.summand = summand;
      this.summands = summands;
  }

  public Polynomial(Polynomial toCopy){
    //TODO
      this.summand = toCopy.getSummand();
      this.summands = toCopy.getSummands();
  }

    /**
     * Lift-Konstruktor
     * @param toLift
     */
  public Polynomial(Monomial toLift){
      //TODO
        this.summand = toLift;
        this.summands = Polynomial.ZERO;
  }


  /**
  * The empty polynomial interpreted as 0, which is the default representation.
  */
  public static final Polynomial ZERO = new Polynomial(null,null);


    /**
     * Summandgetter
     * @return
     */
  public Monomial getSummand() {
        return this.summand;
  }

    /**
     * Summandsgetter
     * @return
     */
  public Polynomial getSummands() {
        return this.summands;
  }


  /**
   * Determine whether an polynomial is 0
   * @return the resulting boolean
   */
  public boolean isZero(){
      if((this.summands == Polynomial.ZERO || this.summands == null) && this.summand == null) {
          return true;
      }
      if(this.summands == Polynomial.ZERO || this.summands == null){

          return this.summand.isZero();
      }
      if(this.summand == null){

          return this.summands.isZero();
      }
      // this.summand and this.summands aren't null
      return this.summand.isZero() && this.summands.isZero();
  }

  /**
  * Convert an polynomial to String
  * @return the resulting String
  */
  public String toString(){
      if(this.isZero()){
          return "0"; //
      }else{
          if(this.summands == Polynomial.ZERO || this.summands == null){
                return this.summand.toString();
          }
          if(this.summand == null){
                return this.summands.toString();
          }
          return this.summand.toString() + "+" + this.summands.toString();
      }
  }


  /**
  * Get the degree of an polynomial object
  * a polynomial has as degree the maximum
  * of the degrees of the summands
  * @return the resulting degree of an polynomial
  */
  public int getDegree(){
      if(this.isZero()){
          return 0;
      }else{
          if(this.summand == null){
              return this.summands.getDegree();
          }
          if(this.summands == null || this.summands == Polynomial.ZERO){
              return this.summand.getDegree();
          }

          return Math.max(this.summand.getDegree(), this.summands.getDegree());
      }

  }


  /**
  * replace variable by value
  * @param toSubstitute the variable to be replaced
  * @param value value
  * @return the resulting polynomial object
  */
  public Polynomial substitute(String toSubstitute, double value){
      if(this.summand == null && (this.summands == null || this.summands == Polynomial.ZERO)){
          try{
              return new Polynomial(this);
          }catch(Exception e){
              System.out.println(e + "149");
          }
      }else if(this.summand != null && (this.summands == null || this.summands == Polynomial.ZERO)){
          try{
              return new Polynomial(this.summand.substitute(toSubstitute,value));
          }catch(Exception e){
              System.out.println(e + "155");
          }
      }else if(this.summand == null && (this.summands != null && this.summands != Polynomial.ZERO)){
          try{
              return new Polynomial(this.summands.substitute(toSubstitute, value));
          }catch(Exception e){
              System.out.println(e + "161");
          }
      }else{
          try{
              return new Polynomial(this.summand.substitute(toSubstitute,value), this.summands.substitute(toSubstitute,value));
          }catch(Exception e){
              System.out.println(e + "167");
          }
      }
      return null;
  }


  /**
  * Evaluate a literal by replacing
  * all variable with a constant
  * @param value value
  * @return the resulting value
  */
  public double evaluate(double value){
      if(this.summand == null && (this.summands == null || this.summands == Polynomial.ZERO)){
          try{
              return 0.0;
          }catch(Exception e){
              System.out.println(e + "185");
          }
      }else if(this.summand != null && (this.summands == null || this.summands == Polynomial.ZERO)){
          try{
              return this.summand.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "191");
          }
      }else if(this.summand == null && (this.summands != null && this.summands != Polynomial.ZERO)){
          try{
              return this.summands.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "197");
          }
      }else{
          try{
              return this.summand.evaluate(value) + this.summands.evaluate(value);
          }catch(Exception e){
              System.out.println(e + "203");
          }
      }
      return 0.0;
  }

  /**
  * @param input String representation of polynomial
  * @return the resulting polynomial
  */
  public static Polynomial parse(String input){
    if(input==null||input.equals("")){
      return ZERO;
    }
    String[] splitted = input.split("\\+",2);
    if(splitted.length==1){
      return new Polynomial(Monomial.parse(splitted[0]));
    }
    return new Polynomial(Monomial.parse(splitted[0]),parse(splitted[1]));
  }


  public static void main(String[] args){
    Polynomial p;
    Polynomial q;
    String[] testValues = {"0","(-3.1415)","(-1)*x^3+(3.0)*x*y^2","x+(-1)^5","3^5+2^6+(3)*(2)*(5)*(4)","x","x^4","x^2*y*z+2*x+(-3)", "x^2+2*x*y+y^2", "(0.0)*x^1000+(0.0)*x*y*z^100+(0.0)^7", "(0.0)*x^1+(0.0)^0"};
    int[] expectedDegrees = {0,0,3,1,0,1,4,4,2,0,0};
    int i = 0;
    for(String s : testValues ){
      System.out.println("----------------------------------------------------------------");
      System.out.println("Testing polynomial read from "+s+".");
      System.out.println("----------------------------");
      p = parse(s);
      System.out.println(p);
      System.out.println("isZero?: "+p.isZero());
      System.out.println("degree: "+p.getDegree());
      System.out.println("degree as expected: "+(p.getDegree()==expectedDegrees[i]));
      i++;
      q = p.substitute("x",1.);
      System.out.println("x substituted by 1: "+q);
      System.out.println("x substituted by 1, rest substituted by 0: "+q.evaluate(0.0));
    }
  }
}
