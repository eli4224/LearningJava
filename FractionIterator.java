import java.util.Iterator;

public class FractionIterator { 
  
  int x = 1;
  int y = 1;
  int returnx;
  int returny;
  int diagnollinenumber = 1;
  int counter = 0;
  
  
  public FractionIterator(){ 
    
  }
  public boolean hasNext(){ 
    return false;
  }
  public String next(){
    
    returnx = x;
    returny = y;
    Fraction fractiongcf;
    fractiongcf = new Fraction(30,90);
    
    while(counter < diagnollinenumber) {
      
      if(counter == 0) {
        x = diagnollinenumber;
        y = 1;
        counter = counter + 1;
        
        if(counter == diagnollinenumber) {
          counter = 0;
          diagnollinenumber = diagnollinenumber + 1;
        }
        if (fractiongcf.gcd(x,y) == 1){
          return(x + "/" + y);
        }
        else {
          return(next());
        }
      }else {
        
        x = x - 1;
        y = y + 1;
        counter = counter + 1;
        
        if(counter == diagnollinenumber) {
          counter = 0;
          diagnollinenumber = diagnollinenumber + 1;
        }
        if (fractiongcf.gcd(x,y) == 1){
          return(x + "/" + y);
        }
        else {
          return(next());
        }
      }
    }
    return("an error has occured");
     
    
  }
}