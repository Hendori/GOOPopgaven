
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Eenvoudig voorbeeld van event handling.
 * Deze versie maakt gebruik van een binnenklasse en een lokale
 * klasse voor de luisteraars.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class EventVoorbeeld extends JFrame {
  
  public EventVoorbeeld() {
    super();
    initialize();
  }
  
  /**
   * Plaatst een label met een plaatje op het contentPane
   * en voegt er een luisteraar aan toe
   */
  public void initialize() {
    setSize(400, 300);
    setTitle("Event voorbeeld");
    Container pane = getContentPane();
    pane.setLayout(null);
    JLabel label = new JLabel();
    label.setBackground(Color.LIGHT_GRAY);
    label.setBounds(100, 40, 200, 100);
    
    // Voor de volgende opdrachten zie leereenheid 12
    // en/of de API Specification
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setHorizontalTextPosition(SwingConstants.TRAILING);
    label.setOpaque(true);
    label.setIcon(new ImageIcon("images" + File.separator + "notSelected.gif"));
    
    // Voeg een instantie van Luisteraar als MouseListener toe
    label.addMouseListener(new Luisteraar());   
    pane.add(label);
  
    // Creeer knop en voeg die toe
    JButton knop = new JButton();
    knop.setBackground(Color.LIGHT_GRAY);
    knop.setBounds(100, 160, 200, 50);
    knop.setText("Knop");
    pane.add(knop);

    // definitie van de lokale luisteraarklasse
    class EnterExitLuisteraar extends MouseAdapter {

      public void mouseEntered(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(Color.CYAN);
      }
      
      public void mouseExited(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(Color.LIGHT_GRAY);
      }
    }
    
    // Creeer een instantie van de zojuist gedefineerde 
    // klasse en voeg die als luisteraar toe aan knop en label
    EnterExitLuisteraar eel = new EnterExitLuisteraar();
    label.addMouseListener(eel);
    knop.addMouseListener(eel);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        EventVoorbeeld gui = new EventVoorbeeld();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
   
  /**
   * Luisteraarklasse als binnenklasse.
   * Hierbij is gebruik gemaakt van de MouseListener.
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

    /**
     * Event handler voor muisklik
     * Maakt de achtergrond van de bron groen.
     * Voorwaarde: de bron is een JLabel
     */
    public void mouseClicked(MouseEvent e) {
      ((JLabel)e.getSource()).setBackground(Color.GREEN);
    }

    /**
     * Event handler voor het binnegaan van de muiswijzer
     * in een JLabel-component
     * Maakt de achtergrond van de bron groen.
     * Voorwaarde: de bron is een JLabel
     */    
    public void mouseEntered(MouseEvent e) {
      ((JLabel)e.getSource()).setText("Entered");
    }
    
    /**
     * Event handler voor het verlaten van de muiswijzer
     * van een JLabel-component
     * Maakt de achtergrond van de bron lichtgrijs.
     * Voorwaarde: de bron is een JLabel
     */     
    public void mouseExited(MouseEvent e) {
      ((JLabel)e.getSource()).setText("");
      ((JLabel)e.getSource()).setBackground(Color.LIGHT_GRAY);
    }
  }
   
}
