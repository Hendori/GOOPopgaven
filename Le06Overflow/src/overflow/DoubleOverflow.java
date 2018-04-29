package overflow;

/**
 * Klasse met voorbeeldcode die overflow, underflow en nuldeling met doubles veroorzaakt. 
 * @author Open Universiteit Nederland
 *
 */
public class DoubleOverflow {
  
  /**
   * Berekent een waarde groter dan Double.MAX_VALUE
   * @return het resultaat van de berekening
   */
  public static double positieveOverflow() {
    double d = Double.MAX_VALUE;
    d = d * 2;
    return d;
  }

  /**
   * Levert de body van methode positieveOverflow als String
   * @return de body van methode positieveOverflow als String
   */
  private static String positieveOverflowCode() {
    String res = "double d = Double.MAX_VALUE;\n";
    res = res + "d = d * 2;";
    return res;
  }

  /**
   * Berekent een waarde kleiner dan -Double.MAX_VALUE
   * @return het resultaat van de berekening
   */
  private static double negatieveOverflow() {
    double d = -Double.MAX_VALUE;
    d = d * 2;
    return d;
  }

  /**
   * Levert de body van methode negatieveOverflow als String
   * @return de body van methode negatieveOverflow als String
   */
  private static String negatieveOverflowCode() {
    String res = "double d = -Double.MAX_VALUE;\n";
    res = res + "d = d * 2;";
    return res;
  }

  /**
   * Berekent een positieve waarde kleiner dan Double.MIN_VALUE
   * @return het resultaat van de berekening
   */
  private static double positieveUnderflow() {
    double d = Double.MIN_VALUE;
    d = d / 2;
    return d;
  }

  /**
   * Levert de body van methode positieveUnderflow als String
   * @return de body van methode positieveUnderflow als String
   */
  private static String positieveUnderflowCode() {
    String res = "double d = Double.MIN_VALUE;\n";
    res = res + "d = d / 2;";
    return res;
  }

  /**
   * Berekent een negatieve waarde groter dan -Double.MIN_VALUE
   * @return het resultaat van de berekening
   */
  private static double negatieveUnderflow() {
    double d = -Double.MIN_VALUE;
    d = d / 2;
    return d;
  }

  /**
   * Levert de body van methode negatieveUnderflow als String
   * @return de body van methode negatieveUnderflow als String
   */
  private static String negatieveUnderflowCode() {
    String res = "double d = -Double.MIN_VALUE;\n";
    res = res + "d = d / 2;";
    return res;
  }

  /**
   * Berekent het resultaat van de deling 1.0 / 0.0
   * @return het resultaat van de berekening
   */
  private static double posDoorNul() {
    double d = 1.0;
    double e = 0.0;
    d = d / e;
    return d;
  }

  /**
   * Levert de body van methode posDoorNul als String
   * @return de body van methode posDoorNul als String
   */
  private static String posDoorNulCode() {
    String res = "double d = 1.0;\n";
    res = res + "double e = 0.0;\n";
    res = res + "d = d / e;";
    return res;
  }

  /**
   * Berekent het resultaat van de deling -1.0 / 0.0
   * @return het resultaat van de berekening
   */
  private static double negDoorNul() {
    double d = -1.0;
    double e = 0.0;
    d = d / e;
    return d;
  }

  /**
   * Levert de body van methode negDoorNul als String
   * @return de body van methode negDoorNul als String
   */
  private static String negDoorNulCode() {
    String res = "double d = -1.0;\n";
    res = res + "double e = 0.0;\n";
    res = res + "d = d / e;";
    return res;
  }

  /**
   * Berekent het resultaat van de deling 0.0 / 0.0
   * @return het resultaat van de berekening
   */
  private static double nulDoorNul() {
    double d = 0.0;
    double e = 0.0;
    d = d / e;
    return d;
  }

  /**
   * Levert de body van methode nulDoorNul als String
   * @return de body van methode nulDoorNul als String
   */
  private static String nulDoorNulCode() {
    String res = "double d = 0.0;\n";
    res = res + "double e = 0.0;\n";
    res = res + "d = d / e;";
    return res;
  }

  /**
   * Geeft de code van een berekening die tot een bepaald
   * type double overflow leidt
   * @param a  het gewenste type overflow
   * @return code die tot dat type overflow leidt
   */
  public static String getCode(DoubleOverflowEnum a) {
    switch (a) {
      case NEGNULDELING:
        return DoubleOverflow.negDoorNulCode();
      case POSNULDELING:
        return DoubleOverflow.posDoorNulCode();
      case NULNULDELING:
        return DoubleOverflow.nulDoorNulCode();
      case POSOVERFLOW:
        return DoubleOverflow.positieveOverflowCode();
      case NEGOVERFLOW:
        return DoubleOverflow.negatieveOverflowCode();
      case POSUNDERFLOW:
        return DoubleOverflow.positieveUnderflowCode();
      case NEGUNDERFLOW:
        return DoubleOverflow.negatieveUnderflowCode();
      default:
        return "Niet geimplementeerd";
    }
  }
  
  /**
   * Voert een berekening uit die tot een bepaald
   * type double overflow leidt
   * @param a  het gewenste type overflow
   * @return het resultaat van de berekening
   */
  public static String getResultaat(DoubleOverflowEnum a) {
    switch (a) {
      case NEGNULDELING:
        return "" + DoubleOverflow.negDoorNul();
      case POSNULDELING:
        return "" + DoubleOverflow.posDoorNul();
      case NULNULDELING:
        return "" + DoubleOverflow.nulDoorNul();
      case POSOVERFLOW:
        return "" + DoubleOverflow.positieveOverflow();
      case NEGOVERFLOW:
        return "" + DoubleOverflow.negatieveOverflow();
      case POSUNDERFLOW:
        return "" + DoubleOverflow.positieveUnderflow();
      case NEGUNDERFLOW:
        return "" + DoubleOverflow.negatieveUnderflow();
      default:
        return "";
    }
  }
}