import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Een gebruikersinterface waarmee een studiecentrum kan
 * worden geselecteerd. Een afbeelding van het geselecteerde
 * studiecentrum wordt getoond.
 * @author Open Universiteit Nederland
 *
 */
@SuppressWarnings("serial")
public class Studiecentra extends JFrame {

  private String[] plaatsnamen = {"amsterdam",
                                  "eindhoven",
                                  "heerlen",
                                  "rotterdam",
                                  "utrecht",
                                  "zwolle"};
  private JLabel fotoLabel = null;
  
  public Studiecentra() {
    super();
    initialize();
  }
  
  /**
   * Construeert een gebruikersinterface met links een knop voor
   * elke plaatsnaam en rechts een label waar een foto moet komen
   */
  private void initialize() {
    setSize(500, 300);
    setTitle("Studiecentra");
    
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
  
    // maak label voor afbeelding
    fotoLabel = new JLabel();
    fotoLabel.setBackground(Color.WHITE);
    fotoLabel.setOpaque(true);
    fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    pane.add(fotoLabel, BorderLayout.CENTER);
    
    // maak knoppen voor keuze
    JPanel keuzePanel = new JPanel();
    keuzePanel.setLayout(new GridLayout(0, 1));
    pane.add(keuzePanel, BorderLayout.WEST);
    
    // luisteraar voor alle knoppen
    Luisteraar luisteraar = new Luisteraar();
    // maak alle knoppen
    for (String plaats : plaatsnamen) {
      JButton knop = new JButton(plaats);
      keuzePanel.add(knop);
      knop.addActionListener(luisteraar);
    }
  }

  public static void main(String[] arg) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        Studiecentra gui = new Studiecentra();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
  
  /**
   * Luisteraarklasse voor de knoppen. Plaatst het juiste
   * plaatje op het label.
   * @author Open Universiteit Nederland
   */
  public class Luisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // TODO voeg hier uw code toe
    }
  }
}
