package bank;

/**
 * Klasse Spaarrekening beheert het saldo voor een rekeninghouder
 * volgens de regels voor spaarrekeningen.
 * Een spaarrekening geeft rente, maar kent wel beperkende voorwaarden.
 * Bij een spaarrekening hoort een tegenrekening.
 * Er kan geen geld van een spaarrekening worden overgemaakt worden naar een
 * andere rekening.
 * Bij opname van een spaarrekening wordt het geld gestort op de tegenrekening.
 * @author Open Universiteit Nederland
 */
public class Spaarrekening extends Rekening {

  private final static double RENTEPERCENTAGE = 0.05;
  private final static double MAXOPNAME = 10000;
  private final static double BOETEPERCENTAGE = 0.08;
  
  private Betaalrekening tegenrekening = null;
  private double opgebouwderente = 0.0;
  private double opgenomen = 0.0;
  
  /**
   * Maakt een spaarrekening met gegeven rekeninghouder, rekeningnummer en
   * tegenrekening.
   * De tegenrekening moet een betaalrekening zijn.
   * @param rekeninghouder de rekeninghouder
   * @param nummer het rekeningnummer
   * @param rekening de tegenrekening 
   */
  public Spaarrekening(Rekeninghouder rekeninghouder, int nummer,
                       Betaalrekening rekening) {
    super(rekeninghouder, nummer);
    tegenrekening = rekening;
  }

  /**
   * Neemt geld op van de spaarrekening.
   * Opname van een spaarrekening betekent storten van het bedrag op
   * de tegenrekening.
   * @param bedrag het op te nemen bedrag
   * @return true als opnemen is gelukt, anders false
   */
  public boolean neemOp(double bedrag) {
    double vrij = Math.max(MAXOPNAME - opgenomen, 0);
    double boete = 0;
    if (vrij < bedrag) {
      boete = (bedrag - vrij) * BOETEPERCENTAGE;
    }
    if (saldo - (bedrag + boete) >= 0) {
      saldo = saldo - (bedrag + boete);
      opgenomen = opgenomen + bedrag;
      tegenrekening.stort(bedrag);
      return true;
    }
    return false; 
  }
  
  /**
   * Berekent rente opgebouwd in afgelopen maand.
   */
  public void eindeMaand() {
    opgebouwderente = opgebouwderente +
                      saldo * RENTEPERCENTAGE / 12;
  }
  
  /**
   * Stort opgebouwde rente op rekening.
   */
  public void eindeJaar() {
    saldo = saldo + opgebouwderente;
    opgebouwderente = 0;
    opgenomen = 0;
  }
 
}
