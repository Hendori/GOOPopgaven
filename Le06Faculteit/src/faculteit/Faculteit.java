package faculteit;

/**
 * Klasse die de faculteit van een natuurlijk getal berekent
 * 
 * @author Open Universiteit Nederland
 * 
 */
public class Faculteit {

  /**
   * Berekent de faculteit van een gegeven positief geheel getal kleiner dan 21. 
   * @param n het getal
   * @return n faculteit
   */
  public static long faculteit(int n) {
    long nfac = 1;
    for (int i = 2; i <= n; i++) {
      nfac = nfac * i;
    }
    return nfac;
  }

  /**
   * Berekent op recursieve wijze de faculteit van een gegeven positief geheel
   * getal kleiner dan 21.
   * @param n  het getal
   * @return n faculteit
   */
  public static long faculteitRec(int n) {
    if (n == 1)
      return 1;
    else
      return faculteitRec(n - 1) * n;
  }
}
