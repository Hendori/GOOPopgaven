package beoordeling;

/**
 * Beoordeling op een schaal van twee.
 * Een beoordeling kan voldoende of onvoldoende zijn.
 * Bij creatie is de score altijd voldoende.
 * @author Open Universiteit Nederland
 *
 */
public class Beoordeling2 {
  
  public enum Waarde {V, O}
  
  private Waarde waarde = Waarde.V; // score
  
  /**
   * Maakt de score voldoende.
   */
  public void setVoldoende(){
    waarde = Waarde.V;
  }
  
  /**
   * Maakt de score onvoldoende.
   */
  public void setOnvoldoende(){
    waarde = Waarde.O;
  }
  
  /**
   * String-representatie van de score.
   */
  public String toString(){
    if(waarde == Waarde.V)
      return "voldoende";
    else
      return "onvoldoende";
  }
}
