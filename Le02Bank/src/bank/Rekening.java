package bank;

/**
 * Klasse Rekening fungeert als superklasse voor de verschillende
 * soorten rekeningen.
 * @author Open Universiteit Nederland
 */
public class Rekening {
 
  protected Rekeninghouder rekeninghouder = null;
  protected int nummer = 0;
  protected double saldo = 0.0;
  
  /**
   * Maakt nieuw rekeningobject met gegeven rekeninghouder en
   * rekeningnummer
   * @param rekeninghouder  de rekeninghouder
   * @param nummer het rekeningnummer
   */
  public Rekening(Rekeninghouder rekeninghouder, int nummer) {
    this.rekeninghouder = rekeninghouder;
    this.nummer = nummer;
    saldo = 0.0;
  }
  
  /**
   * Geeft het rekeningnummer van de rekening.
   * @return het rekeningnummer
   */
  public int getNummer() {
    return nummer;
  }
  
  /**
   * Geeft het saldo van de rekening.
   * @return het saldo
   */
  public double getSaldo() {
    return saldo;
  }

  /**
   * Stort een bedrag op de rekening.
   * @param bedrag het te storten bedrag
   */
  public void stort(double bedrag) {
    saldo = saldo + bedrag;
  }
  
  /**
   * Neemt geld op van de rekening.
   * Doet echter niets. Deze methode wordt gedefinieerd in zijn subklassen.
   * @param bedrag het op te nemen bedrag
   * @return true
   */
  public boolean neemOp(double bedrag) {
    // herdefinitie in subklassen
    return true;
  }
  
  /**
   * Voert de acties uit die aan eind van maand op rekening moeten worden
   * uitgevoerd. Doet echter niets.
   * Deze methode wordt geherdefinieerd in zijn subklassen.
   */
  public void eindeMaand() {
    //herdefinitie in subklassen
  }
  
  /**
   * Voert de acties uit die aan eind van jaar op rekening moeten worden
   * uitgevoerd. Doet echter niets.
   * Deze methode wordt geherdefinieerd in zijn subklassen.
   */
  public void eindeJaar() {
    // herdefinitie in subklassen
  }
}
