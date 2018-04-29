package bank;

/**
 * Klasse Betaalrekening beheert het saldo voor een rekeninghouder
 * volgens de regels voor betaalrekeningen.
 * Een betaalrekening wordt gebruikt voor het gewone betaalverkeer.
 * @author Open Universiteit Nederland
 */
public class Betaalrekening extends Rekening {

  /**
   * Maakt een betaalrekening met gegeven rekeninghouder en rekeningnummer.
   * @param rekeninghouder de rekeninghouder
   * @param nummer het rekeningnummer
   */
  public Betaalrekening(Rekeninghouder rekeninghouder, int nummer) {
    super(rekeninghouder, nummer);
  }
   
  /**
   * Neemt geld op van de rekening.
   * @param bedrag het op te nemen bedrag
   * @return true als opnemen mogelijk is, anders false
   */
  public boolean neemOp(double bedrag) {
    if (saldo - bedrag >= 0) {
      saldo = saldo - bedrag;
      return true;
    }
    return false; 
  }

}
