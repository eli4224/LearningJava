/**
 * This class represents a rational number, aka a fraction.
 */
public class Fraction{
  public static void main(String[ ] args) {
    Fraction fraction1;
    FractionIterator fractioniterator1;
    fraction1 = new Fraction(16,32);
    fractioniterator1 = new FractionIterator();
    
    System.out.println(fraction1.gcd(16,32));
    
    for(int counter = 0; counter < 50; counter++) {
      System.out.println(fractioniterator1.next());
    }
    
  }
  /**
   * This represents the numerator of the fraction
   */
  private int numerator;
  /**
   * This represents the denominator of the fraction
   */
  private int denominator;
  
  /**
   * Constructs a fraction instance with a given a numerator and denominator, then simplifies
   * @param tempnumerator the unsiplified numerator 
   * @param tempdenominator the unsiplified denominator
   */
  public Fraction(int tempnumerator, int tempdenominator){
    int gcd = gcd(tempnumerator,tempdenominator);
    numerator = tempnumerator/gcd;
    denominator = tempdenominator/gcd;
  }
  
  /**
   * Finds the greatest common denominator of two values.
   */
  public static int gcd(int nom, int dem){
    
    if(Math.min(nom,dem) == 1) {
      return(1);
    }
    
    for(int factor = 2; factor <= Math.min(nom, dem); factor++) {
      if(nom % factor == 0 && dem % factor == 0) {
        //System.out.println(factor);
        return(factor*gcd((nom/factor), (dem/factor)));
      }
    }
    return(1);
  }
  
  /**
   * A getter function for the numerator
   * @returns this.numerator
   */
  public int getNumberator(){
    
    return(numerator);
  }
  /**
   * A getter function for the denominator
   * @returns this.denominator
   */
  public int getDenominator(){ 
    return(denominator);  
  }
  /**
   * Checks if the fraction is improper
   * @return will be true if and only if the nunerator > denominator
   */
  public boolean isImpropor(){ 
    return(numerator > denominator);
  }
  /**
   * 
   */
  public float toFloat(){ 
    return (float)(numerator) / (float)(denominator);
  }
  /**
   * 
   * @returns
   */
  @Override
  public String toString(){ 
    return(numerator + "/" + denominator);
  }
  /**
   * 
   * @param other
   */
  public Fraction plus(Fraction other){ 
    return(null);
  }
  /**
   * 
   * @param other
   */
  public Fraction times(Fraction other){ 
    return new Fraction(numerator*other.numerator, denominator*other.denominator);
  }
  
}