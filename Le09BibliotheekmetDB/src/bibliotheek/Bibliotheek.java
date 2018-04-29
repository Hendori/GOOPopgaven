package bibliotheek;

import java.util.ArrayList;

import bibliotheekdata.BibliotheekMapper;
import bibliotheekdata.BibliotheekException;

/**
 * Deze klasse beheert een bibliotheek van boeken.
 * Er kan een boek worden toegevoegd en de auteur van een
 * gegeven titel kan worden opgezocht.
 * @author Medewerker OUNL
 *
 */ 
public class Bibliotheek  {

  private BibliotheekMapper bestand = null;
  private ArrayList<Boek> boekenlijst = null;
  
  /**
   * Opent een nieuwe bibliotheek iut een gegeven database 
   * @param bestandsnaam
   * @throws BibliotheekException
   */
  public void open(String url) throws BibliotheekException {
    bestand = new BibliotheekMapper(url); 
    boekenlijst = bestand.leesAlleBoeken();
  } 

//  public Bibliotheek() throws BibliotheekException{
//    bestand = new BibliotheekMapper();
//    boekenlijst = bestand.leesAlleBoeken();
//  }
  
  /**
   * Voegt een boek toe aan de boekenlijst.
   * Voorwaarde: er is nog geen boek met deze titel
   * @param titel  de titel van het boek
   * @param auteur  de auteur van het boek
   */
  public void voegBoekToe(String titel, String auteur) throws BibliotheekException {
    if (geefAuteur(titel) == null) {
      Boek boek = new Boek(titel, auteur);
      boekenlijst.add(boek);   
      bestand.schrijfBoek(boek);
    }
  }

  /**
   * Levert een lijst van titels van alle boeken
   * @return  de lijst met titels 
   */
  public ArrayList<Boek> getBoekenlijst() {
    
    return boekenlijst;
  }
  
  /**
   * Zoekt de auteur van een boek
   * @param titel  de titel van het boek
   * @return de auteur van het boek of "Titel niet gevonden"
   *         als de titel niet in de lijst voorkomt       
   */
  public String geefAuteur(String titel){
    for (Boek boek : boekenlijst) {
      if (boek.getTitel().equals(titel)){
	// boek met gevraagde titel gevonden
	return boek.getAuteur();
      }     
    }
    return null;
  }
  
  /**
   * Sluit het bestand af.
   */
  public void sluitAf() {    
    bestand.sluitAf();
  }
}
