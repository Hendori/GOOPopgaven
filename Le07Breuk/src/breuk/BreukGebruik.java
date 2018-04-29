package breuk;

/**
 * Klasse die gebruik wordt om het gebruik van een NulnoemerException te
 * demonstreren
 * 
 * @author Open Universiteit Nederland
 * 
 */
public class BreukGebruik {
  /**
   * Creeert drie breuk instanties 
   * en schrijft de stringrepresentaties naar de standaarduitvoer naar 
   * @param args nvt
   */
  public static void main(String[] args) {
    Breuk b1 = new Breuk(1, 2);
    System.out.println("breuk1: " + b1);
    Breuk b2 = new Breuk(1, 0);
    System.out.println("breuk2: " + b2);
    Breuk b3 = new Breuk(1, 3);
    System.out.println("breuk3: " + b3);
    System.out.println("Einde ....");
  }
}
