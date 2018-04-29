package breuk;
/**
 * Klasse die een breuk representeert 
 * en enkele elementaire bewerkingen op breuken kan uitvoeren. 
 * @author Open Universiteit Nederland
 *
 */
public class Breuk {
  private int teller = 0, noemer = 1;
  
  /**
   * Maakt een nieuwe breuk instantie
   * @param teller de teller
   * @param noemer de noemer
   */
  public Breuk(int teller, int noemer){
    if (teller >= 0 && noemer > 0) {
      this.teller = teller;
      this.noemer = noemer;
    }
  }
  /**
   * Geeft teller van deze breuk
   * @return de teller
   */
  public int getTeller() {
    return teller;
  }
  /**
   * Geeft noemer van deze breuk
   * @return de noemer
   */
  public int getNoemer() {
    return noemer;
  }
  
  /**
   * Vereenvoudigt deze breuk door teller en noemer
   * te delen door hun grootste gemene deler
   */
  @SuppressWarnings("unused")
  public void vereenvoudig() {   
    // Dit is het algoritme van Euclides
    int grootste = noemer;
    int kleinste = teller;
	int n = 0;
    while (kleinste != 0) {
      int rest = grootste % kleinste;
      grootste = kleinste;
      kleinste = rest;
      n++;
    }
    teller = teller / grootste;
    noemer = noemer / grootste;
  }
  
  
  /**
   * Telt deze breuk op bij een andere breuk  en vereenvoudigt het resultaat zo ver mogelijk
   * @param ander andere breuk
   * @return som van deze breuk met andere breuk, zover mogelijk vereenvoudigd
   */
  public Breuk plus(Breuk ander) {
    int somT = teller * ander.noemer + ander.teller *noemer;
    int somN = noemer * ander.noemer;
    Breuk som = new Breuk(somT, somN);
    som.vereenvoudig();
    return som;
  }

    
  /**
   * Vergelijkt deze breuk met een andere breuk.
   * Twee breuken zijn gelijk als ze na vereenvoudiging 
   * zelfde teller en noemer hebben.
   * @param obj een andere breuk
   * @return true als breuken gelijk zijn, anders false
   */
  public boolean equals(Object obj){
    if (obj instanceof Breuk)    {
      Breuk anderbreuk = (Breuk)obj;
      this.vereenvoudig();
      anderbreuk.vereenvoudig();
      return (this.teller==anderbreuk.teller && this.noemer==anderbreuk.noemer);
    }
    return false;
  }
  
  /**
   * Geeft de string representatie van deze breuk
   * 
   * @return de string representatie van deze breuk.
   */
  public String toString() {
    return teller + "/" + noemer;
  }
}
