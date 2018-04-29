import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Demonstratie van het gebruik van keyevents. Bij indrukken van
 * een toets wordt getoond welke key-events dit veroorzaakt
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class KeyEventDemo extends JFrame {
  private JLabel opdrachtVeld = null;
  private JLabel pressedLabel = null;
  private JLabel typedLabel = null;
  
  public KeyEventDemo() {
    super();
    initialize();
  }

  /**
   * Maak de GUI
   */
  private void initialize() {
    // Zet titel en afmeting en geef de contentpane layout null
    setTitle("KeyEventDemo");
    setSize(500, 200);
    Container pane = getContentPane();
    pane.setLayout(null);
  
    // Voeg een label toe met instructie
    opdrachtVeld = new JLabel("Druk een toets in en u ziet welke events dit veroorzaakt");
    opdrachtVeld.setBounds(35, 30, 400, 30);
    pane.add(opdrachtVeld);

    // Voeg label toe die KeyPressed events laat zien
    pressedLabel = new JLabel();
    pressedLabel.setBounds(35, 80, 400, 30);
    pane.add(pressedLabel);
    
    // Voeg label toe die KeyTyped events laat zien
    typedLabel = new JLabel();
    typedLabel.setBounds(35, 120, 400, 30);
    pane.add(typedLabel);

    // Geef de contentPane de invoerfocus en een KyyListener
    pane.setFocusable(true);
    pane.requestFocusInWindow();
    pane.addKeyListener(new ToetsLuisteraar());
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        KeyEventDemo gui = new KeyEventDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
  
  /**
   * Luisteraarklasse die toont welke KeyEvents optreden
   */
  public class ToetsLuisteraar extends KeyAdapter {
    /**
     * Toont in een bericht welke event is opgetreden en
     * welke informatie er is over de ingedrukte toets
     */
    public void keyPressed(KeyEvent e) {
      typedLabel.setText("");
      pressedLabel.setText("keyPressed: KeyCode=" + e.getKeyCode() +
                           ", KeyChar=" + e.getKeyChar() + "\n");
    }
    
    /**
     * Toont in een bericht welke event is opgetreden en
     * welke informatie er is over de ingedrukte toets
     */
    public void keyTyped(KeyEvent e) {
      //typedLabel.setText(e.toString());
      typedLabel.setText("keyTyped: KeyCode=" + e.getKeyCode() +
                           ", KeyChar=" + e.getKeyChar() + "\n");
    }
  }

}
