package bibliotheekdata;

import java.util.ArrayList;

import bibliotheek.Boek;

public class BibliotheekMapperTest {

  public static void main(String[] args) throws BibliotheekException {
    
    BibliotheekMapper bestand = new BibliotheekMapper(DBConst.URL );

    // Lees de boeken in en toon ze
    ArrayList<Boek> lijst = bestand.leesAlleBoeken();
    for (Boek boek : lijst) {
      System.out.println(boek.getTitel() + " van " + boek.getAuteur());
    }
    System.out.println();

    // schrijf 3 nieuwe boeken weg
    bestand.schrijfBoek(new Boek("Oorlog en vrede", "L. Tolstoi"));
    bestand.schrijfBoek(new Boek("Misdaad en straf", "F. Dostojewski"));
    bestand.schrijfBoek(new Boek("Dode zielen", "N. Gogol"));

    // Lees opnieuw de boeken en toon ze om te kijken of de nieuwe
    // goed zijn toegevoegd.
    lijst = bestand.leesAlleBoeken();
    for (Boek boek : lijst) {
      System.out.println(boek.getTitel() + " van " + boek.getAuteur());
    }
    System.out.println();
  }
}
