package cdsdata;

import java.util.ArrayList;

import cds.CD;
import cds.Track;

/**
 * Deze klasse is verantwoordelijk voor de communicatie met de database 
 * @author Open Universiteit Nederland
 * 
 */
public class CDMapper {

  /**
   * Maakt verbinding met de database en initialiseert
   * PreparedStatement-objecten.
   * @throws CDException
   */
  public CDMapper() throws CDException {
  }

  /**
   * Sluit de verbinding met de database.
   */
  public void sluitVerbinding() {
  }

  /**
   * Leest alle cd 's uit de database. De tracks bij een cd worden nog niet
   * gelezen. 
   * @return alle CD-objecten zonder de bijbehorende tracks
   * @throws CDException als er iets fout gaat
   */
  public ArrayList<CD> leesAlleCDs() throws CDException {
    return null;
  }

  /**
   * Leest tracks bij een gegeven cd
   * @param cd  de cd
   * @return de tracks bij de cd
   * @throws CDException
   */
  public ArrayList<Track> leesTracks(CD cd) throws CDException {
    return null;
  }
}
