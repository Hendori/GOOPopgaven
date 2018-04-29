import java.awt.*;
import javax.swing.*;

/**
 * Deze klasse demonstreert het gebruik van checkboxes en radiobuttons.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class ToggleButtonsDemo extends JFrame {
  
  public ToggleButtonsDemo() {
    super();
    initialize();
  }
  
  /**
   * Toont twee panels. Op het linkerpanel moeten vier
   * checkboxes worden geplaatst; op het rechterpanel vier
   * radiobuttons.
   */
  private void initialize() {
    setSize(300, 150);
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(1, 2, 10, 10));
    pane.setBackground(Color.BLACK);
    
    JPanel links = new JPanel();
    links.setBackground(Color.DARK_GRAY);
    pane.add(links);

    JPanel rechts = new JPanel();
    rechts.setBackground(Color.DARK_GRAY);
    pane.add(rechts);
    
    // TODO voeg hier uw code toe
  }
  
  public static void main(String[] arg) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ToggleButtonsDemo gui = new ToggleButtonsDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}
