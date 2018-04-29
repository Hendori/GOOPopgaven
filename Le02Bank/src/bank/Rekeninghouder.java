package bank;

/**
 * Klasse Rekeninghouder beheert de gegevens van een rekeninghouder.
 * @author Open Universiteit Nederland
 */
public class Rekeninghouder {
  private String naam = "";  // naam van rekeninghouder
  
  /**
   * Constructor, genereert instantie van Rekeninghouder
   * @param naam  naam van rekeninghouder
   */
  public Rekeninghouder(String naam) {
    this.naam = naam;
  }
  
  /**
   * Geef naam van rekeninghouder
   * @return naam van rekeninghouder
   */
  public String getNaam() {
    return naam;
  }

  /**
   * Zet naam van rekeninghouder
   * @param naam naam van rekeninghouder
   */
  public void setNaam(String naam) {
    this.naam = naam;
  }

}
