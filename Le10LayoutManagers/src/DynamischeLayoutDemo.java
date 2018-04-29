
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Klasse voor het demonstreren van dynamische wijzigingen
 * in de layout van een container. De gebruiker kan vragen 
 * een nieuwe knop toe te voegen aan een panel.
 */
@SuppressWarnings("serial")
public class DynamischeLayoutDemo extends JFrame {
  // attributen zijn een knop en een panel
  private JButton nieuwKnop = null;
  private JPanel knoppenPanel = null;
  private int volgnummer = 0;
  
  public DynamischeLayoutDemo() {
    super();
    initialize();
  }
  
  /**
   * Voegt een knop en een leeg knoppenPanel
   * toe 
   */
  private void initialize() {
    setTitle("Dynamische layout");
    setSize(400, 300);
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    nieuwKnop = new JButton("nieuw");
    nieuwKnop.addActionListener(new KnopLuisteraar());
    pane.add(nieuwKnop, BorderLayout.WEST);
    knoppenPanel = new JPanel();
    knoppenPanel.setBackground(Color.WHITE);
    pane.add(knoppenPanel, BorderLayout.CENTER);
  }
  
  /**
   * Event handler; creeert nieuwe knop en
   * voegt die toe aan het knoppenPanel
   */
  private void nieuweKnopAction() {
    JButton knop = new JButton("" + volgnummer);
    volgnummer++;
    knoppenPanel.add(knop);
    // TODO voeg hier uw code toe
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
    	DynamischeLayoutDemo gui = new DynamischeLayoutDemo();
        gui.setVisible(true);
  	    gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
  
  /**
   * Luisteraarklasse voor nieuwKnop.
   * Zie paragraaf 3 van leereenheid 11
   */
  public class KnopLuisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      nieuweKnopAction();
    }
  }
}
