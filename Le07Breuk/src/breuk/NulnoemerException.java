package breuk;
/**
 * Exception klasse voor signaleren van een noemer in een breuk die nul wordt.
 * @author open Universiteit Nederland
 *
 */
@SuppressWarnings("serial")
public class NulnoemerException extends Exception{

  public NulnoemerException(){
     super();
  }
  
  public NulnoemerException(String message){
     super(message);
  }
  
  
}
