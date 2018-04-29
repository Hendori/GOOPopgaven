package galgje;

/**
 * Representeert een spelletje Hangman.
 */
public class Galgje {
  public enum Uitslag {WINST, VERLIES, NIETAF}
  
  //het aantal malen dat een verkeerde letter mag worden geraden
  private static final int MAXFOUT = 4;

  // attributen
  private String goedString = null;       // de goed geraden symbolen, op de goede plaats
  private String foutString = "";  // de fout geraden symbolen, achter elkaar
  private String raadString = null;       // het te raden woord
  private Uitslag uitslag = Uitslag.NIETAF;

  /**
   * Zet de opgegeven string in raadString en vult
   * een goedstring met '+' tot hij even lang is als raadstring.
   */
  public Galgje(String rs) {
    raadString = rs;
    goedString = "";
    for(int k = 0; k < raadString.length(); k++)
      goedString = goedString + "+";
  }

  /**
   * Geeft de goede string.
   */
  public String getGoedString() {
    return goedString;
  }

  /**
   * Geeft de foute string.
   */
  public String getFoutString() {
    return foutString;
  }

  /**
   * Geeft de uitslag.
   */
  public Uitslag getUitslag() {
    return uitslag;
  }

  /**
   * Gaat na of het opgegeven symbool in de raadstring voorkomt.
   * Als het symbool voorkomt, wordt het op de corresponderende
   * plaats(en) in de goedstring gezet. Als alle letters geraden
   * zijn, wordt de uitslag: "je hebt gewonnen". Als het symbool
   * niet voorkomt, wordt het aan de foutstring toegevoed.
   * Als de foutstring langer is dan MAXFOUT wordt de uitslag:
   * "je hebt verloren".
   */
  public void probeer(char c) {
    String hulp = "";
    boolean geraden = false;
    for(int k = 0; k < raadString.length(); k++) {
      if(raadString.charAt(k) == c) {
        geraden = true;
        hulp = hulp + c;
      }
      else {
        hulp = hulp + goedString.charAt(k);
      }
    }
    goedString = hulp;
    if(!geraden)
      foutString = foutString + c;
    if(goedString.equals(raadString))
      uitslag = Uitslag.WINST;
    if(foutString.length() > MAXFOUT)
      uitslag = Uitslag.VERLIES;
  }
}
