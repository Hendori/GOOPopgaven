/**
 * Deze klasse telt in een aparte thread van 0 
 * tot MAXTELLER; onderweg wordt tien keer een
 * voortgangsbericht afgedrukt.
 */
public class Berekening implements Runnable {
  // Constanten MAXTELLER en INTERVAL 
  public static final long MAXTELLER = 100000L;
  public static final long INTERVAL = MAXTELLER /10;
  
  /**
   * Telt van 0 tot MAXTELLER
   */
  public void run() { 
    long teller = 0;
    while (teller < MAXTELLER) {
      teller++;
      if (teller % INTERVAL == 0) {
        System.out.println("run is bij " + teller);
      }    
    }
  }
}

