package valuta;

/** Klasse voor valuanaam met bijbehorende wisselkoers */
public class Valuta
{
  /** valuta naam, bijvoorbeeld "Amerikaanse dollar"*/
  private String naam = null;

  /** wisselkoers in euro */
  private double koers = 0.0;

  /**
   * Initialiseert een valuta-instantie.
   * @param naam  valutanaam
   * @param koers  wisselkoers in euro
   */
  Valuta(String naam, double koers) {
    this.naam = naam;
    this.koers = koers;
  }

  /**
   * Kent een waarde toe aan de wisselkoers van deze valuta.
   * @param koers  wisselkoers in euro
   */
  public void setKoers(double koers) {
    this.koers = koers;
  }

  /**
   * Geeft de naam van deze valuta
   * @return  valutanaam
   */
  public String getNaam() {
    return naam;
  }

  /**
   * Geeft de koers van deze valuta.
   * @return   koers
   */
  public double getKoers() {
    return koers;
  }

  /**
   * Geeft een string-representatie van deze valuta-instantie
   * @return  een string representatie
   */
  public String toString() {
    return "("  + naam + ", "+ koers + ")";
  }


}