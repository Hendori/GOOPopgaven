package valuta;

import java.util.*;

/**
 * Klasse die een aantal Valuta-instanties beheert.
 */
public class ValutaBeheer {
  /**
   * ArrayList waarin valuta-instanties opgeslagen worden.
   */
  private ArrayList<Valuta> valutas = null;

  /**
   * Maak een lege arraylist voor valutas.
   */
  public ValutaBeheer() {
    valutas = new ArrayList<>();
  }

  /**
   * Voegt een valuta-instantie toe.
   * @param naam  naam van de toe te voegen valuta-instantie
   * @param koers  koers van de toe te voegen valuta-instantie
   */
  public void voegValutaToe(String naam, double koers) {
    Valuta v = new Valuta(naam, koers);
    valutas.add(v);
  }

  /**
   * Geeft het aantal valuta-instanties.
   * @return  het aantal valuta-instanties
   */
  public int getAantal() {
    return valutas.size();
  }

  /**
   * Geeft de valuta-instantie met een gegeven naam.
   * @param naam  de gegeven naam
   * @return  de valuta-instantie met de gegeven naam indien deze aanwezig is.
   * anders null.
   */
  public Valuta zoekValuta(String naam) {
    for (Valuta v : valutas) {
      if (naam.equals(v.getNaam())) {
        return v;
      }
    }
    return null;
  }

  /**
   * Rekent een bedrag in de aangeboden valutanaam om
   * in een bedrag in de gevraagde valutanaam.
   * @param bedrag  het om te rekenen bedrag
   * @param aangeboden  naam van de aangeboden valuta
   * @param gevraagd  naam van de gevraagde valuta
   * @return  het bedrag in aangeboden valuta omgerekend in gevraagde valuta
   */
  public double wissel(double bedrag, String aangeboden, String gevraagd) {
    Valuta valutaAang = this.zoekValuta(aangeboden);
    Valuta valutaGevr = this.zoekValuta(gevraagd);
    return bedrag * valutaAang.getKoers()/valutaGevr.getKoers();
  }

  /**
   * Wijzigt de koers van een valuta waarvan de naam gegeven is.
   * @param naam  naam van de valuta
   * @param koers de nieuwe koers
   */
  public void wijzigKoers(String naam, double koers) {
    Valuta v = this.zoekValuta(naam);
    v.setKoers(koers);
  }

  /**
   * Geeft de koers van de valuta met een gegeven naam.
   * @param naam  naam van de valuta
   * @return  koers van de valuta
   */
  public double getKoers(String naam) {
    Valuta v = this.zoekValuta(naam);
    return v.getKoers();
  }

  /**
   * Geeft de namen van de valutas die door deze instantie beheerd worden.
   * @return  namen van de valuta's
   */
  public ArrayList<String> valutaNamen() {
    ArrayList<String> namen = new ArrayList<>();
    for (Valuta v : valutas) {
      namen.add(v.getNaam());
    }
    return namen;
  }

  /**
   * Voegt een aantal valuta toe.
   */
  public void vul() {
    voegValutaToe("Amerikaanse dollar", 0.6358);
    voegValutaToe("Australische dollar", 0.5908);
    voegValutaToe("Canadese dollar", 0.6273);
    voegValutaToe("Deense kroon", 0.1341);
    voegValutaToe("Engelse pond", 1.2537);
    voegValutaToe("Europese euro", 1.0000);
    voegValutaToe("Japanse yen", 0.0062);
    voegValutaToe("Noorse kroon", 0.1259);
    voegValutaToe("Poolse zloty", 0.2893);
    voegValutaToe("Zuid-afrikaanse rand", 0.0818);
    voegValutaToe("Zweedse kroon", 0.1068);
    voegValutaToe("Zwitserse franc", 0.6279);
  }
}