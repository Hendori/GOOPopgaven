
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Eenvoudig voorbeeld van event handling.
 * Deze versie maakt enkel gebruik van een lokale klasse
 * en een anonieme klasse als luisteraars.
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
    pane.add(label);
  
    // Creeer knop en voeg die toe
    JButton knop = new JButton();
    knop.setBackground(Color.LIGHT_GRAY);
    knop.setBounds(100, 160, 200, 50);
    knop.setText("Knop");
    pane.add(knop);

    // definitie van een lokale luisteraarklasse
    class EnterExitLuisteraar extends MouseAdapter {

      public void mouseEntered(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(Color.CYAN);
      }
      
      public void mouseExited(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(Color.LIGHT_GRAY);
      }
    }
    
    // Creeer een instantie van de zojuist gedefinieerde
    // luisteraar en voeg die toe aan knop en label
    EnterExitLuisteraar eel = new EnterExitLuisteraar();
    label.addMouseListener(eel);
    knop.addMouseListener(eel);
    
    // gebruik van een anonieme luisteraarklasse
    // toevoegen en definitie zijn gecombineerd
    label.addMouseListener(new MouseListener() {
 
      public void mousePressed(MouseEvent e) {
        ((JLabel)e.getSource()).setIcon(new ImageIcon("images" + File.separator + "selected.gif"));
      }

      public void mouseReleased(MouseEvent e) {
        ((JLabel)e.getSource()).setIcon(new ImageIcon("images" + File.separator + "notSelected.gif"));    
      }

      public void mouseClicked(MouseEvent e) {
        ((JLabel)e.getSource()).setBackground(Color.GREEN);
      }

      public void mouseEntered(MouseEvent e) {
        ((JLabel)e.getSource()).setText("Entered");
      }
      
      public void mouseExited(MouseEvent e) {
        ((JLabel)e.getSource()).setText("");
        ((JLabel)e.getSource()).setBackground(Color.LIGHT_GRAY);
      }
    });
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
 
}
