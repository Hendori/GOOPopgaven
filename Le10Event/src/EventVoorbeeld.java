
import java.awt.*;
import java.io.File;

import javax.swing.*;

/**
 * Eenvoudige demoklasse voor event handling
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
