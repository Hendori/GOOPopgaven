package klokgui;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import klok.Klok;

/**
 * Deze klasse representeert een eenvoudige, tekstgeorienteerde
 * interface voor de klasse Klok, die de kloktijd 
 * toont op standaarduitvoer.
 */
public class TekstKlok {
  /**
   * Constante voor het formatten van datum en tijd
   */
  private static final SimpleDateFormat tijdformaat = 
      new SimpleDateFormat("dd-MM-yy HH:mm:ss");
  private Klok klok = new Klok(this);
  
  /**
   * Start de klok 
   */
  private void init() {
    klok.startKlok();
  }

  /**
   * Stopt de klok
   */
  private void stop() {
    klok.stopKlok();
  }
  
  /**
   * Toont de huidige tijd
   */
  public void update() {
    GregorianCalendar tijd = klok.getTijd();
    System.out.println(
      "In " + klok.getStadsnaam() + 
      " is het " + tijdformaat.format(tijd.getTime()));
  }
  
  /**
   * Creeert een instantie van TekstKlok, start de klok
   * en stopt die weer na 25 seconden.
   */
  public static void main(String[] args)  {  
    TekstKlok tk = new TekstKlok();
    tk.init();
    try {Thread.sleep(25000);} catch (InterruptedException e) {}
    tk.stop();
  }
}
