package bibliotheek;

/**
 * Deze klasse beheert de gegevens (titel en auteur)
 * van een boek
 */ 
public class Boek {
  private String titel = null;
  private String auteur = null;
  
  /**
   * Creert een nieuw boek
   * @param titel  de titel van het boek
   * @param auteur  de auteur van het boek
   */ 
  public Boek(String titel, String auteur){
    this.titel = titel;
    this.auteur = auteur;
  }

  public String getAuteur() {
    return auteur;
  }

  public String getTitel() {
    return titel;
  }
  
  /**
   * Maakt een string-representatie van het boek.
   * @return de stringrepresentatie
   */
  public String toString() {
    return titel + " - " + auteur;
  }
}
