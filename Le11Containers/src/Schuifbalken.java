import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Illustreert het gebruik van schuifbalken.
 * @author Open Universiteit Nederland
 *
 */
@SuppressWarnings("serial")
public class Schuifbalken extends JFrame {
  
  // Array met drie bestandsnamen van plaatjes
  private String[] keuzes = {"duke.gif", "rotsen.gif", "mandjes.gif"};
  
  // Keuzelijst
  private JComboBox<String> plaatjesKeuze = null;
  
  public Schuifbalken() {
    super();
    initialize();
  }

  /**
   * Maakt een editable keuzelijst met drie vaste keuzes.
   * Het is de bedoeling de bijbehorende plaatjes te tonen
   * in een venster met schuifbalken.
   */
  private void initialize() {
    setSize(290, 240);
    setTitle("Schuifbalken");
    
    Container pane = getContentPane();
    pane.setLayout(null);
    
    // Maak een editable keuzelijst met event handler
    plaatjesKeuze = new JComboBox<>(keuzes);
    plaatjesKeuze.setBounds(10, 20, 100, 25);
    plaatjesKeuze.setSelectedIndex(-1);
    plaatjesKeuze.setEditable(true);
    plaatjesKeuze.addActionListener(new KeuzeLuisteraar());
    pane.add(plaatjesKeuze);
    
  }
  
  public static void main(String[] arg) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        Schuifbalken gui = new Schuifbalken();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
  
  public class KeuzeLuisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      
    }
  }
}
