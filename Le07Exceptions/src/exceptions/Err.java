package exceptions;

/**
 * Klasse met voorbeeld code die Errors veroorzaakt
 * 
 * @author OMedewerker OUNL
 */
public class Err {
  
  /**
   * Levert het try-blok van methode outOfMemoryError als String
   * @return het try-blok van methode outOfMemoryError als String
   */
  private static String outOfMemoryErrorCode() {
    String res = "int[][][] a = new int[1000][4000][4000];\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet een OutOfMemeryError is opgetreden 
   * @return  melding of er al dan niet een OutOfMemoryError is opgetreden
   */
  @SuppressWarnings("unused")
  private static String outOfMemoryError() {
    try {
      int[][][] a = new int[1000][4000][4000];
      return "Geen OutOfMemoryError!";
    }
    catch (OutOfMemoryError e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode stackOverflowError als String
   * @return het try-blok van methode stackOverflowError als String
   */
  private static String stackOverflowErrorCode() {
    String res = "private void addElement(String s){\n";
    res = res + "  if (s.length() > 0)\n";
    res = res + "    addElement(s);\n";
    res = res + "}\n\n";
    res = res + "aanroep: addElement(\"kees\")\n\n";
    return res;
  }

  /**
   * Voegt een gegeven String toe aan list als de stringlengte positief is.
   * NB: Deze methode bevat bewust een fout, waardoor de methode zich zelf 
   * eindeloos aanroept. 
   * @param s de String
   */
  private static void addElement(String s) {
    if (s.length() > 0) {
      addElement(s);
    }
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet StackOverflowError is opgetreden 
   * @return  melding of er al dan niet  een StackOverflowError is opgetreden
   */
  private static String stackOverflowError() {
    try {
      addElement("kees");
      return "Geen stackoverflow";
    }
    catch (StackOverflowError e) {
      return e.toString();
    }
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet bepaalde soort error is opgetreden
   * @param errornaam de naam van de error
   * @return melding waaruit blijkt of er al dan niet bepaalde soort error is opgetreden
   */
  public static String getBoodschap(ErrEnum errornaam) {
    switch (errornaam) {
      case OUTOFMEMORY:
        return outOfMemoryError();
      case STACKOVERFLOW:
        return stackOverflowError();
      default:
        return "Niet geimplmenteerd";
    }
  }

  /**
   * Geeft code als string die een bepaald soort error veroorzaakt  
   * @param errornaam de naam van de error
   * @return code als string die een bepaalde soort error veroorzaakt 
   */
  public static String getCode(ErrEnum errornaam) {
    switch (errornaam) {
      case OUTOFMEMORY:
        return outOfMemoryErrorCode();
      case STACKOVERFLOW:
        return stackOverflowErrorCode();
      default:
        return "Niet geimplementeerd.";
    }
  }
}