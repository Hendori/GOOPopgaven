package overflow;


/**
 * Klasse met voorbeeldcode die overflow en nuldeling met integers veroorzaakt. 
 * @author Open Universiteit Nederland
 *
 */
 public class IntOverflow {
   
   /**
    * Berekent een waarde groter dan Integer.MAX_VALUE
    * @return het resultaat van de berekening
    */ 
  private static int positieveOverflow() {
    int i = Integer.MAX_VALUE;
    i++;
    return i;
  }

  /**
   * Levert de body van methode positieveOverflow als String
   * @return de body van methode positieveOverflow als String
   */
  private static String positieveOverflowCode() {
    String res = "int i = Integer.MAX_VALUE;\n";
    res = res + "i++;";
    return res;
  }

  /**
   * Berekent een waarde kleiner dan Integer.MIN_VALUE
   * @return het resultaat van de berekening
   */
  private static int negatieveOverflow() {
    int i = Integer.MIN_VALUE;
    i--;
    return i;
  }

  /**
   * Levert de body van methode negatieveOverflow als String
   * @return de body van methode negatieveOverflow als String
   */
  private static String negatieveOverflowCode() {
    String res = "int i = Integer.MIN_VALUE;\n";
    res = res + "i--;";
    return res;
  }

  /**
   * Berekent het resultaat van de deling 1 / 0
   * @return het resultaat van de berekening
   */
  private static int posDoorNul() {
    int i = 1;
    int j = 0;
    i = i / j;
    return i;
  }

  /**
   * Levert de body van methode posDoorNul als String
   * @return de body van methode posDoorNul als String
   */
  private static String posDoorNulCode() {
    String res = "int i = 1;\n";
    res = res + "int j = 0;\n";
    res = res + "i = i / j;";
    return res;
  }
 
  /**
   * Berekent het resultaat van de deling -1 / 0
   * @return het resultaat van de berekening
   */
  public static int negDoorNul() {
    int i = -1;
    int j = 0;
    i = i / j;
    return i;
  }

 /**
  * Levert de body van methode negDoorNul als String
  * @return de body van methode negDoorNul als String
  */
  private static String negDoorNulCode() {
    String res = "int i = -1;\n";
    res = res + "int j = 0;\n";
    res = res + "i = i / j;";
    return res;
  }

  /**
   * Berekent het resultaat van de deling 0 / 0
   * @return het resultaat van de berekening
   */ 
  private static int nulDoorNul() {
    int i = 0;
    int j = 0;
    i = i / j;
    return i;
  }

  /**
   * Levert de body van methode nulDoorNul als String
   * @return de body van methode nulDoorNul als String
   */
  private static String nulDoorNulCode() {
    String res = "int i = 0;\n";
    res = res + "int j = 0;\n";
    res = res + "i = i / j;";
    return res;
  }

  /**
   * Geeft de code van een berekening die tot een bepaald
   * type int overflow of tot nuldeling leidt
   * @param a  het gewenste type overflow of nuldeling
   * @return code die tot dat type overflow of nuldeling leidt
   */
  public static String getCode  (IntOverflowEnum a) {
    switch (a) {
      case POSOVERFLOW:
        return IntOverflow.positieveOverflowCode();
      case NEGOVERFLOW:
        return IntOverflow.negatieveOverflowCode();
      case POSNULDELING:
        return IntOverflow.posDoorNulCode();
      case NEGNULDELING:
        return IntOverflow.negDoorNulCode();
      case NULNULDELING:
        return "" + IntOverflow.nulDoorNulCode();
      default:
        return "niet geimplementeerd.";
    }
  }
  
  /**
   * Voert een berekening uit die tot een bepaald
   * type int overflow of nuldeling leidt
   * @param a  het gewenste type overflow of nuldeling 
   * @return het resultaat van de berekening
   */
  @SuppressWarnings("unused")
  public static String getResultaat(IntOverflowEnum a) {
    switch (a) {
      case POSOVERFLOW:
        return ""+ IntOverflow.positieveOverflow();
      case NEGOVERFLOW:
        return  ""+ IntOverflow.negatieveOverflow();
      case POSNULDELING:
        try {
          int res = IntOverflow.posDoorNul();
        }
        catch (RuntimeException e) {
          return e.toString();
        }        
      case NEGNULDELING:
        try {
          int res = IntOverflow.negDoorNul();
        }
        catch (RuntimeException e) {
          return e.toString();
        }   
      case NULNULDELING:
        try {
          int res = IntOverflow.nulDoorNul();
        }
        catch (RuntimeException e) {
          return e.toString();
        }   
      default:
        return "";
    }

  }
}