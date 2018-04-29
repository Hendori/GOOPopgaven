package klok;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import klokgui.KlokFrame;

/**
 * Klasse Klok representeert een klok die de tijd aan kan
 * geven in verschillende steden. 
 */
public class Klok implements Runnable {
  
  private ArrayList<Stad> steden = new ArrayList<>();
  private Stad stad = null;
  private boolean stoppen = false;
  private GregorianCalendar tijd = new GregorianCalendar();
  private KlokFrame gui;
  
  /**
   * De constructor maakt de lijst met steden en zet
   * de huidige stad op de eerste van die lijst.
   * De huidige tijd wordt meteen getoond in de gui
   * @param gui  het KlokFrame dat de gui vormt
   */
  public Klok(KlokFrame gui){
    maakSteden();
    stad = steden.get(0);
    tijd.add(Calendar.MINUTE, stad.getTijdverschil());
    this.gui = gui;
  }

  public GregorianCalendar getTijd(){
    return tijd;
  }
  
  /**
   * Wijzigt de huidige stad
   * @index  de index van de nieuwe stad in de lijst met steden
   */
  public void wijzigStad(int index) {
    stad = steden.get(index);
  } 
  
  /**
   * Levert de lijst met namen van steden
   * @return lijst met stadsnamen
   */
  public ArrayList<String> getStadsnamen() {
    ArrayList<String> namen = new ArrayList<>();
    for (Stad stad: steden) {
      namen.add(stad.getNaam());
    }
    return namen;
  }
  
  /**
   * Verzet elke seconde de klok, tot deze moet stoppen.
   * De tijd wordt elke seconde opnieuw opgevraagd.
   */ 
  public void run() {
    while (!stoppen) {
      tijd = new GregorianCalendar();
      tijd.add(Calendar.MINUTE, stad.getTijdverschil());
      gui.update();
      try {
        Thread.sleep(1000);
      } 
      catch (InterruptedException e){}
    }
  }
  
  /**
   * Start de klok in een nieuwe thread.
   */
  public void startKlok() {
    Thread thread = new Thread(this);
    thread.start();
  }

  
  /**
   * Zorgt ervoor dat de klok stopt.
   */
  public void stopKlok() {
    stoppen = true;
  }
  
  // private methode
  
  /**
   * Maakt de lijst met steden.
   */
  private void maakSteden() {
    steden.add(new Stad("Amsterdam", 0));
    steden.add(new Stad("Londen", -60));
    steden.add(new Stad("New York", -360));
    steden.add(new Stad("Pretoria", +60));
    steden.add(new Stad("Moskou", +120));
    steden.add(new Stad("New Delhi", +270));
    steden.add(new Stad("Beijing", +420));
    steden.add(new Stad("Melbourne", +540));
    steden.add(new Stad("Wellington", +660));
  }
}
