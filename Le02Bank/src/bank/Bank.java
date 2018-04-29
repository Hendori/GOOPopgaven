package bank;

import java.util.*;

/**
 * Klasse Bank beheert alle rekeningen en regelt het gehele
 * betalingsverkeer binnen de bank.
 * @author Open Universiteit Nederland
 */
public class Bank {
  
  private ArrayList<Rekening> rekeningen = null;
  private static int volgnummer = 1000;
  private final static int GEEN_REKENING = 0;
  
  /**
   * Maakt bank. Creeert een lege lijst rekeningen.
   */
  public Bank() {
    rekeningen = new ArrayList<>();
  }
  
  /**
   * Maakt een nieuwe betaalrekening en voegt deze toe aan
   * de bank.
   * @param naam naam van de rekeninghouder
   * @return het rekeningnummer van de nieuwe rekening
   */
  public int maakBetaalrekening(String naam) {
    int nummer = nieuwRekeningNummer();
    Rekeninghouder rekeninghouder = new Rekeninghouder(naam);
    Betaalrekening rekening = new Betaalrekening(rekeninghouder, nummer);
    rekeningen.add(rekening);
    return nummer;
  }
  
  /**
   * Maakt een nieuwe spaarrekening en voegt deze toe aan
   * de bank.
   * @param naam naam van de rekeninghouder
   * @param tegen nummer van de tegenrekening (een betaalrekening)
   * @return het rekeningnummer van de nieuwe rekening
   * (0 als rekening niet gemaakt kan worden)
   */
  public int maakSpaarrekening(String naam, int tegen) {
    Rekening rtegen = getRekening(tegen);
    if (rtegen != null && rtegen instanceof Betaalrekening) {
      int nummer = nieuwRekeningNummer();
      Rekeninghouder rekeninghouder = new Rekeninghouder(naam);
      Spaarrekening rekening = new Spaarrekening(rekeninghouder, nummer,
                                                 (Betaalrekening)rtegen);
      rekeningen.add(rekening);
      return nummer;
    }
    return GEEN_REKENING;
  }
  
  /**
   * Maakt geld over van een rekening naar een andere rekening.
   * @param van rekeningnummer van de rekening waarvan geld wordt overgemaakt
   * (moet betaalrekening zijn)
   * @param naar rekeningnummer van de rekening waarnaar geld wordt overgemaakt
   * @param bedrag het over te maken bedrag
   */
  public void maakOver(int van, int naar, double bedrag) {
    Rekening rvan = getRekening(van);
    Rekening rnaar = getRekening(naar);
    if (rvan != null && rnaar != null && rvan instanceof Betaalrekening) {
      if (rvan.neemOp(bedrag)) {
        rnaar.stort(bedrag);
      }
    }
  }
  
  /**
   * Stort geld op een rekening.
   * @param nummer rekeningnummer van rekening waarop wordt gestort
   * @param bedrag het te storten bedrag
   */
  public void stort(int nummer, double bedrag) {
    Rekening r = getRekening(nummer);
    if (r != null) {
      r.stort(bedrag);
    }
  }

  /**
   * Neemt geld op van rekening.
   * @param nummer rekeningnummer van rekening waarvan geld wordt opgenomen
   * @param bedrag het op te nemen bedrag
   */
  public void neemOp(int nummer, double bedrag) {
    Rekening r = getRekening(nummer);
    if (r != null) {
      r.neemOp(bedrag);
    }    
  }

  /**
   * Geeft het saldo van de rekening.
   * @param nummer rekeningnummer van de rekening.
   * @return het saldo (0.0 als rekening niet bestaat)
   */
  public double geefSaldo(int nummer) {
    Rekening r = getRekening(nummer);
    if (r != null) {
      return r.getSaldo();
    }
    return 0.0;
  }
  
  /**
   * Initieert acties die aan einde van iedere maand door rekeningen 
   * moeten worden uitgevoerd.
   */
  public void eindeMaand() {
    for (Rekening r : rekeningen) {
      r.eindeMaand();
    }
  }
  
  /**
   * Inititeert acties die aan einde van ieder jaar door rekeningen
   * moeten worden uitgevoerd.
   */
  public void eindeJaar() {
    for (Rekening r : rekeningen) {
      r.eindeJaar();
    }   
  }
  
  /**
   * Zoekt rekening bij rekeningnummer.
   * @param nummer het rekeningnummer
   * @return rekening (null als rekening niet bestaat)
   */
  private Rekening getRekening(int nummer) {
    for (Rekening r : rekeningen) {
      if (r.getNummer() == nummer) {
        return r;
      }
    }
    return null;
  }
  
  /**
   * Genereert een nieuw rekeningnummer.
   * @return nieuw rekeningnummer
   */
  private int nieuwRekeningNummer() {
    return volgnummer++;
  }

}
