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
   * Entscheide ob ein Polynom 0 ist.
   * @return
   */
  public boolean isZero(){
      if(this.summands == Polynomial.ZERO){
          return this.summand.isZero();
      }else{
          return (this.summand.isZero() || this.summand == Monomial.ONE) && (this.summands.isZero());
      }
  }


  public String toString(){
      if(this.isZero()){
          return "0";
      }else{
          return this.summand.toString() + "+" + this.summands.toString();
      }
  }


  public int getDegree(){
      return Math.max(this.summand.getDegree(), this.summands.getDegree());
  }

  public Polynomial substitute(String toSubstitute, double value){
      if(this.isZero()){
          return Polynomial.ZERO;
      }else if(this.summands.isZero()){
          return new Polynomial(this.summand.substitute(toSubstitute, value));
      }else{
          return new Polynomial(this.summand.substitute(toSubstitute, value), this.substitute(toSubstitute, value));
      }
  }

  public double evaluate(double value){
      if(this.isZero()){
          return 0.0;
      }else{
          return this.summand.evaluate(value) + this.summands.evaluate(value);
      }
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
