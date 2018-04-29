package exceptions;

/**
 * Klasse met voorbeeld code die checked exceptions veroorzaakt
 * @author Medewerker OUNL
 */
public class CheckedExcep {
  
  
  /**
   * Levert het try-blok van methode classNotFoundException als String
   * @return het try-blok van methode classNotFoundException als String
   */
  private static String classNotFoundExceptionCode() {
    String res = "Class c = Class.forName(\"ZoMaarWat\");\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet een ClassNotFoundException is opgetreden 
   * @return  melding of er al dan niet een ClassNotFoundException is opgetreden
   */
  private static String classNotFoundException() {
    try {
      Class.forName("ZoMaarWat");
      return "Geen ClassNotFoundException";
    }
    catch (ClassNotFoundException e) {
      return e.toString();
    }
  }
  
  /**
   * Levert het try-blok van methode instantiationException als String
   * @return het try-blok van methode instantiationException als String
   */
  private static String instantiationExceptionCode() {
    String res = "Class c = Class.forName(\"java.lang.Number\");\n";
    res = "Object n = c.newInstance(); //abstracte klasse\n\n";
    return res;
  }
  
  /**
   * Levert een melding waaruit blijkt of er al dan niet een InstantiationdException is opgetreden 
   * @return  melding of er al dan niet een InstantiationException is opgetreden
   */
  private static String instantiationException() throws ClassNotFoundException,
      IllegalAccessException {
    try {
      Class<?> c = Class.forName("java.lang.Number");
      c.newInstance(); // abstracte klasse
      return "Geen InstantiationException";
    }
    catch (InstantiationException e) {
      return e.toString();
    }
  }
  
  /**
   * Levert het try-blok van methode illegalAccessException als String
   * @return het try-blok van methode illegalAccessException als String
   */
  private static String illegalAccessExceptionCode() {
    String res = "Class c = Class.forName(\"java.lang.Math\");\n";
    res = res + "Object m = c.newInstance(); //statische klasse\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet een IllegaAccessExceptionException is opgetreden 
   * @return  melding of er al dan niet een IllegaslAccessException is opgetreden
   */
  private static String illegalAccessException() throws ClassNotFoundException,
      InstantiationException {
    try {
      Class<?> c = Class.forName("java.lang.Math");
      c.newInstance(); // statische klasse
      return "Geen IllegalAccesException";
    }
    catch (IllegalAccessException e) {
      return e.toString();
    }
  }
  
  /**
   * Levert het try-blok van methode cloneNotSupportedException als String
   * @return het try-blok van methode cloneNotSupportedException als String
   */
  private static String cloneNotSupportedExceptionCode() {
    String res = "Excep obj = new Excep();\n";
    res = res + "Excep copy = (Excep) obj.clone()\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er al dan niet een CloneNotSupportedException is opgetreden 
   * @return  melding of er al dan niet een CloneNotSupporteddException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String cloneNotSupportedException() {
    try {
      CheckedExcep obj = new CheckedExcep();
      CheckedExcep copy = (CheckedExcep) obj.clone();
      return "Geen CloneNotSupportedException";
    }
    catch (CloneNotSupportedException e) {
      return e.toString();
    }
  }
  
  /**
   * Geeft code als string die een bepaald soort checked exception veroorzaakt  
   * @param exceptionnaam de naam van de checked exception
   * @return code als string die een bepaalde soort checked exception veroorzaakt 
   */
  public static String getCode(CheckedEnum exceptionnaam) {
    switch (exceptionnaam) {
      case CLASSNOTFOUND:
        return classNotFoundExceptionCode();
      case CLONENOTSUPPORTED:
        return cloneNotSupportedExceptionCode();
      case INSTANTIATION:
        return instantiationExceptionCode();
      case ILLEGALACCESS:
        return illegalAccessExceptionCode();
      default:
        return "Niet geimplementeerd";
    }
  }
  
  /**
   * Levert een melding waaruit blijkt of er al dan niet bepaalde soort checked exception is opgetreden
   * @param exceptionnaam de naam van de checked exception
   * @return melding waaruit blijkt of er al dan niet bepaalde soort checked exception is opgetreden
   */
  public static String getBoodschap(CheckedEnum exceptionnaam) {
    switch (exceptionnaam) {
      case CLASSNOTFOUND:
        return classNotFoundException();
      case CLONENOTSUPPORTED:
        return cloneNotSupportedException();
      case INSTANTIATION:
        try {
          return instantiationException();
        }
        catch (ClassNotFoundException e) {

          e.printStackTrace();
        }
        catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      case ILLEGALACCESS:
        try {
          return illegalAccessException();
        }
        catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
        catch (InstantiationException e) {
          e.printStackTrace();
        }
      default:
        return "Niet geimplementeerd";
    }
  }
}
