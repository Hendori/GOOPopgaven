package test;

import java.util.ArrayList;

import beoordeling.Beoordeling;
import beoordeling.Beoordeling10;
import beoordeling.Beoordeling100;
import beoordeling.Beoordeling2;
import beoordeling.Optelbaar;

/**
 * Testklasse voor de klassen uit de package beoordeling.
 * @author Open Universiteit Nederland
 */
public class BeoordelingTest {
  
  // creeer twee beoordelingen van elke soort
  private Beoordeling2 b21 = new Beoordeling2();
  private Beoordeling2 b22 = new Beoordeling2();
  private Beoordeling10 b101 = new Beoordeling10(6);
  private Beoordeling10 b102 = new Beoordeling10(9);
  private Beoordeling100 b1001 = new Beoordeling100(45);
  private Beoordeling100 b1002 = new Beoordeling100(75);
  
  // lijst voor beoordelingen
  private ArrayList<Beoordeling> lijst1 = new ArrayList<>();
  // lijst voor beoordelingen die optelbaar zijn
  private ArrayList<Optelbaar> lijst2 = new ArrayList<>();
  
  /**
   * Maakt twee lijsten met beoordelingen.
   */
  public BeoordelingTest(){
    // maak de beoordeling b22 onvoldoende
    b22.setOnvoldoende();
    
    // voeg twee niet-optelbare en twee optelbare
    // beoordelingen toe aan lijst1
    lijst1.add(b21);
    lijst1.add(b22);
    lijst1.add(b101);
    lijst1.add(b1002);
    
    // voeg  vier optelbare beoordelingen toe aan lijst2
    lijst2.add(b101);
    lijst2.add(b102);
    lijst2.add(b1001);
    lijst2.add(b1002);
  }
  
  /**
   * Methode voor het testen van methode standaardWaarde.
   * Voor alle scoren van de lijst met optelbare 
   * beoordelingen wordt methode standaardWaarde aangeroepen 
   * om het cijfer op tien te bepalen.
   * Dan wordt de gemiddelde van alle cijfers op de 
   * standaarduitvoer getoond.
   */
  private void toonEindcijfer(){
    int cijfer = 0;
    for(Optelbaar o: lijst2){
      cijfer = cijfer + o.standaardWaarde();
    }
    cijfer = cijfer / lijst2.size();
    System.out.println("Eindcijfer: " + cijfer);
  }
  
  /**
   * Methode voor het testen van methode isVoldoende.
   * Voor alle scoren van de lijst met beoordelingen
   * wordt methode isVoldoende aangeroepen. Het resultaat wordt
   * op de standaarduitvoer getoond.
   */
  private void toonVoldoende(){
    for(Beoordeling b: lijst1){
      String s = "voldoende";
      if(!b.isVoldoende())
        s = "onvoldoende";
      System.out.println(b.toString() + " is " + s);
    }
  }
  
  /**
   * Maakt een nieuwe instantie en roet de twee testmethoden op.
   * @param args
   */
  public static void main(String[] args) {
    BeoordelingTest bt = new BeoordelingTest();
    bt.toonVoldoende();
    bt.toonEindcijfer();
  }
}
