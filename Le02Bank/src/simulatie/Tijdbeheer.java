package simulatie;

import java.util.*;
import bank.*;

/**
 * Klasse Tijdbeheer laat de tijd verstrijken in de banksimulatie.
 * @author Open Universiteit Nederland
 */
public class Tijdbeheer {
  private GregorianCalendar huidigeDatum = null; // huidige datum
  private Bank bank = null;                      // bank in simulatie
  
  /**
   * Constructor. Maakt een nieuw Tijdbeheer-object 
   * @param bank  bank waarvoor de tijd moet worden gesimuleerd
   * @param datum datum van start van simulatie
   */
  public Tijdbeheer(Bank bank, GregorianCalendar datum) {
    this.bank = bank;
    huidigeDatum = datum;
  }
  
  /**
   * Wijzigt de datum in de simulatie.
   * Roept voor ieder verstreken maand/jaar de methode eindeMaand/eindeJaar aan.
   * @param datum nieuwe datum
   */
  public void wijzigDatum(GregorianCalendar datum) {
    if (huidigeDatum.before(datum)) {
      huidigeDatum.set(Calendar.DATE, 1);
      huidigeDatum.add(Calendar.MONTH, 1); // 1e van volgende maand
      while (!huidigeDatum.after(datum)) {
        bank.eindeMaand();
        if (huidigeDatum.get(Calendar.MONTH) == Calendar.JANUARY) {
          bank.eindeJaar();
        }
        huidigeDatum.add(Calendar.MONTH, 1); // volgende maand
      }
      huidigeDatum = datum;
    }
  }

}
