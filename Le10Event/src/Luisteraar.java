

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Luisteraarklasse voor muisevents. 
 * @author Open Universiteit Nederland
 */
public class Luisteraar implements MouseListener {

  /**
   * Event handler voor indrukken van de muisknop
   * Plaatst het plaatje selected.gif op de bron.
   * Voorwaarde: de bron is een JLabel
   */
  public void mousePressed(MouseEvent e) {
    ((JLabel)e.getSource()).setIcon(new ImageIcon("images" + File.separator + "selected.gif"));
  }
  
  /**
   * Event handler voor loslaten van de muisknop
   * Plaatst het plaatje notSelected.gif op de bron.
   * Voorwaarde: de bron is een JLabel
   */
  public void mouseReleased(MouseEvent e) {
    ((JLabel)e.getSource()).setIcon(new ImageIcon("images" + File.separator + "notSelected.gif"));    
  }

  // De overige methoden van MouseListener hebben 
  // lege implementaties
  public void mouseClicked(MouseEvent e) {   
  }

  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
}
