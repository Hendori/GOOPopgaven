package bibliotheekdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bibliotheek.Boek;

/**
 * De klasse BibliotheekMapper is verantwoordelijk voor het bijhouden van de
 * bibliotheek in een achterliggende database.
 */
public class BibliotheekMapper {

  @SuppressWarnings("unused")
  private Connection con = null;
  
  @SuppressWarnings("unused")
  private PreparedStatement prepLeesAlles = null;
  
  @SuppressWarnings("unused")
  private PreparedStatement prepVoegtoe = null;

  /**
   * Maakt verbinding met de database genoemd in url en initialissert
   * preparedstatement-objecten.
   * @param url  de url
   * @throws CDException als er iets fout gaat
   */
  public BibliotheekMapper(String url) throws BibliotheekException {
    
  }

  /**
   * Leest alle boeken in uit de bibliotkeekdatabase.
   * @return een ArrayList met alle Boek-objecten
   */
  public ArrayList<Boek> leesAlleBoeken() throws BibliotheekException {
    
    return null;
  }

  /**
   * Schrijft een boek naar de database
   * @param boek  het boek
   */
  public void schrijfBoek(Boek boek) throws BibliotheekException {
    
  }

  /**
   * Sluit de verbinding met de database
   */
  public void sluitAf() {
    
  }

  
}
