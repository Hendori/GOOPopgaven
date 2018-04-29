package beoordeling;

/**
 * Beoordeling op een schaal van 0 t/m 10.
 * @author Open Universiteit Nederland
 * 
 */
public class Beoordeling10 {
  private int waarde = 0; // score

  /**
   * Creert een instantie voor de gegeven waarde. Als de 
   * opgegeven waarde buiten het bereik valt wordt als 
   * waarde 0 of 10 gebruikt.
   * @param waarde de waarde van de score
   */
  public Beoordeling10(int waarde) {
    this.waarde = waarde;
    if (waarde < 0)
      waarde = 0;
    else if (waarde > 10)
      waarde = 10;
  }

  /**
   * String-representatie van de score.
   */
  public String toString() {
    return "" + waarde;
  }
}
