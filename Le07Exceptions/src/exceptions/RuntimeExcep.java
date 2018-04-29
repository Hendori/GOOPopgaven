package exceptions;

import java.util.ArrayList;
import java.util.BitSet;

import javax.swing.JLabel;

/**
 * Klasse met voorbeeld code die Runtime Exceptions veroorzaakt
 * @author Open Universiteit Nederland
 * 
 */
public class RuntimeExcep {

  /**
   * Levert het try-blok van methode arithmeticException als String
   * @return het try-blok van methode arithmeticException als String
   */
  private static String arithmeticExceptionCode() {
    String res = "int i = 1;\n";
    res = res + "int j = 0;\n";
    res = res + "i = i / j;\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er  
   * een ArithmeticException is opgetreden 
   * @return  melding of er een ArithmeticException is opgetreden
   */
  private static String arithmeticException() {
    try {
      int i = 1;
      int j = 0;
      i = i / j;
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode arrayStoreException als String
   * @return het try-blok van methode arrayStoreException als String
   */
  private static String arrayStoreExceptionCode() {
    String res = "Object x[] = new String[3];\n";
    res = res + "x[1] = new Integer(0);\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er 
   * een ArrayStoreException is opgetreden 
   * @return  melding of er een ArrayStoreException is opgetreden
   */
  private static String arrayStoreException() {
    try {
      Object x[] = new String[3];
      x[1] = new Integer(0);
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode classCastException als String
   * @return het try-blok van methode classCastException als String
   */
  private static String classCastExceptionCode() {
    String res = "Object i = new Integer(0);\n";
    res = res + "String s = (String) i;\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er
   * een ClassCastException is opgetreden 
   * @return  melding of er een ClassCastException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String classCastException() {
    try {
      Object i = new Integer(0);
      String s = (String) i;
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode illegalArgumentException als String
   * @return het try-blok van methode illegalArgumentException als String
   */
  private static String illegalArgumentExceptionCode() {
    String res = "ArrayList<String> lijst = new ArrayList<>(-2)\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er
   * een IllegalArgumentException is opgetreden 
   * @return  melding of er een IllegalArgumentException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String illegalArgumentException() {
    try {
      ArrayList<String> lijst = new ArrayList<>(-2);
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode numberFormatException als String
   * @return het try-blok van methode numberFormatException als String
   */
  private static String numberFormatExceptionCode() {
    String res = "String s = \"a\";\n";
    res = res + "int i = Integer.parseInt(s);\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er 
   * een NumberFormatException is opgetreden 
   * @return  melding of er een NumberFormatException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String numberFormatException() {
    try {
      String s = "a";
      int i = Integer.parseInt(s);
      return "Geen numberformat exception";
    }
    catch (NumberFormatException e) {

      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode indexOutOfBoundsException als String
   * @return het try-blok van methode indexOutOfBoundsException als String
   */
  private static String indexOutOfBoundsExceptionCode() {
    String res = "BitSet b = new BitSet();\n";
    res = res + "b.set(-1);\n\n";
    return res;

  }

  /**
   * Levert een melding waaruit blijkt of er
   * een IndexOutOfBoundsException is opgetreden 
   * @return  melding of er een IndexOutOfBoundsException is opgetreden
   */
  private static String indexOutOfBoundsException() {
    try {
      BitSet b = new BitSet();
      b.set(-1);
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode arrayIndexOutOfBoundsException als String
   * @return het try-blok van methode arrayIndexOutOfBoundsException als String
   */
  private static String arrayIndexOutOfBoundsExceptionCode() {
    String res = "int[] a = new int[3];\n";
    res = res + "a[3] = 0;\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er
   * een ArrayIndexOutOfBoundsException is opgetreden 
   * @return  melding of er een ArrayIndexOutOfBoundsException is opgetreden
   */
  private static String arrayIndexOutOfBoundsException() {
    try {
      int[] a = new int[3];
      a[3] = 0;
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode stringIndexOutOfBoundsException als String
   * @return het try-blok van methode stringIndexOutOfBoundsException als String
   */
  private static String stringIndexOutOfBoundsExceptionCode() {
    String res = "String a = \"abc\";\n";
    res = res + "char c = a.charAt(3);\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er 
   * een StringIndexOutOfBoundsException is opgetreden 
   * @return  melding of er een StringIndexOutOfBoundsException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String stringIndexOutOfBoundsException() {
    try {
      String a = "abc";
      char c = a.charAt(3);
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode negativeArraySizeException als String
   * @return het try-blok van methode negativeArraySizeException als String
   */
  private static String negativeArraySizeExceptionCode() {
    String res = "int[] a = new int[-1];\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er 
   * een NegativeArraySizeException is opgetreden 
   * @return  melding of er een NegativeArraySizeException is opgetreden
   */
  @SuppressWarnings("unused")
  private static String negativeArraySizeException() {
    try {
      int[] a = new int[-1];
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode nullPointerException als String
   * @return het try-blok van methode nullPointerException als String
   */
  private static String nullPointerExceptionCode() {
    String res = "JLabel s = null;\n";
    res = res + "s.setText(\"a\");\n\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er
   * een NullPointerException is opgetreden 
   * @return  melding of er een NullPointerException is opgetreden
   */
  @SuppressWarnings("null")
  private static String nullPointerException() {
    try {
      JLabel s = null;
      s.setText("a");
      return "Geen runtime exception";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Levert het try-blok van methode concurrentModificationException als String
   * @return het try-blok van methode concurrentModificationException als String
   */
  private static String concurrentModificationExceptionCode() {
    String res = "ArrayList<String> lijst = new ArrayList<>();\n";
    res = res + "lijst.add(\"Aap\");lijst.add(\"Noot\");lijst.add(\"Mies\");\n";
    res = res + "int index = 0;\n";
    res = res + "for (String s: lijst){\n";
    res = res + "  if (s.charAt(0)=='A'){\n";
    res = res + "    lijst.remove(index);\n";
    res = res + "    index++;\n";
    res = res + "  }\n";
    res = res + "}\n";
    return res;
  }

  /**
   * Levert een melding waaruit blijkt of er 
   * een ConcurrentModificationException is opgetreden 
   * @return  melding of er een ConcurrentModificationException is opgetreden
   */
  private static String concurrentModificationException() {
    try {
      ArrayList<String> lijst = new ArrayList<>();
      lijst.add("Aap");
      lijst.add("Noot");
      lijst.add("Mies");
      int index = 0;
      for (String s : lijst) {
        if (s.charAt(0) == 'A') {
          lijst.remove(index);
          index++;
        }
      }
      return "Geen ConcurrentModificationException";
    }
    catch (RuntimeException e) {
      return e.toString();
    }
  }

  /**
   * Geeft code als string die een bepaald soort unchecked exception veroorzaakt  
   * @param exceptionnaam de naam van de unchecked exception
   * @return code als string die een bepaalde soort unchecked exception veroorzaakt 
   */
  public static String getCode(RuntimeEnum exceptionnaam) {
    switch (exceptionnaam) {
      case ARITHMETIC:
        return arithmeticExceptionCode();
      case ARRAYINDEXOUTOFBOUNDS:
        return arrayIndexOutOfBoundsExceptionCode();
      case ARRAYSTORE:
        return arrayStoreExceptionCode();
      case CLASSCAST:
        return classCastExceptionCode();
      case ILLEGALARGUMENT:
        return illegalArgumentExceptionCode();
      case INDEXOUTOFBOUNDS:
        return indexOutOfBoundsExceptionCode();
      case NEGATIVEARRAYSIZE :
        return negativeArraySizeExceptionCode();
      case NUMBERFORMAT:
        return numberFormatExceptionCode();
      case NULLPOINTER:
        return nullPointerExceptionCode();
      case STRINGINDEXOUTOFBOUNDS:
        return stringIndexOutOfBoundsExceptionCode();
      case CONCURRENTMODIFICATION:
        return concurrentModificationExceptionCode();
      default:
        return "niet geimplementeerd";
    }
  }

  /**
   * Levert een melding waaruit blijkt of er een
   * bepaalde soort unchecked exception is opgetreden
   * @param exceptionnaam de naam van de unchecked exception
   * @return melding waaruit blijkt of er een
   *         bepaalde soort unchecked exception is opgetreden
   */
  public static String getBoodschap(RuntimeEnum exceptionnaam) {
    switch (exceptionnaam) {
      case ARITHMETIC:
        return arithmeticException();
      case ARRAYINDEXOUTOFBOUNDS:
        return arrayIndexOutOfBoundsException();
      case ARRAYSTORE:
        return arrayStoreException();
      case CLASSCAST:
        return classCastException();
      case ILLEGALARGUMENT:
        return illegalArgumentException();
      case INDEXOUTOFBOUNDS:
        return indexOutOfBoundsException();
      case NEGATIVEARRAYSIZE:
        return negativeArraySizeException();
      case NUMBERFORMAT:
        return numberFormatException();
      case NULLPOINTER:
        return nullPointerException();
      case STRINGINDEXOUTOFBOUNDS:
        return stringIndexOutOfBoundsException();
      case CONCURRENTMODIFICATION:
        return concurrentModificationException();
      default:
        return "Niet geimplmenteerd";
    }
  }
}