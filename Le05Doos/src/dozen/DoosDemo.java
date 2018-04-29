package dozen;

/**
 * Klasse voor het testen van de klasse Doos.
 * @author Open Universiteit Nederland
 *
 */
public class DoosDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Doos<Integer> integerDoos = new Doos<>();
    integerDoos.bewaar(10);
//    integerDoos.bewaar("10"); // opdracht a
    Integer i = integerDoos.getObject();
    System.out.println(i);
//    // opdracht b
//    Doos<String> stringDoos = new Doos<>();
//    stringDoos.bewaar("10");
//    stringDoos = integerDoos;

//    // opdracht c
//    Doos<Object> stringDoos = new Doos<>();
//    stringDoos.bewaar("10");
//    stringDoos = integerDoos;

  }
}

