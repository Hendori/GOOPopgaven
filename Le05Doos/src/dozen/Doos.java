package dozen;

/**
 * Generieke klasse voor het bewaren van
 * een object van type T.
 * @author Open Universiteit Nederland
 *
 * @param <T> het type van het object in de doos
 */
public class Doos<T> {
  private T object = null; // het object in de doos
  
  /**
   * Plaatst een object in de doos.
   * @param object het te bewaren object
   */
  public void bewaar(T object){
    this.object = object;
  }
  
  public T getObject(){
    return object;
  }
  
  public String toString(){
    return "Doos: " + object;
  }  
}
