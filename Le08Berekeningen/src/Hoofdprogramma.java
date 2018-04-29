/**
 * Demo voor threads.
 * Dit programma start een hulpthread die van 1 tot 
 * Berekening.MAXTELLER telt, en telt dan zelf van
 * Berekening.MAXTELLER terug naar 0.
 */
public class Hoofdprogramma {

  public static void main(String[] args){
    // creeer en start een nieuwe thread met een 
    // Berekening-instantie als target
    Berekening berekening = new Berekening();
    Thread hulpthread = new Thread(berekening);
    hulpthread.start();

    // Tel van Berekening.MAXTELLER terug naar 0
    // en print onderweg zo af en toe iets af.
    long teller = Berekening.MAXTELLER;
    while (teller > 0) {
      teller--;
      if (teller % Berekening.INTERVAL == 0) {
        System.out.println("main is bij " + teller);
      }    
    }
  }
}
