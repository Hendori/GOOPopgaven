
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Demo-klasse voor een layout manager van type GridLayout
 */
@SuppressWarnings("serial")
public class GridLayoutDemo extends JFrame {
  
  @SuppressWarnings("unused")
private static final int AANTAL = 100;

  public GridLayoutDemo() {
    super();
    initialize();
  }

  /**
   * Plaats met behulp van een GridLayout-manager 
   * AANTAL knoppen op het scherm, met hun volgnummer
   * als opschrift
   */
  private void initialize() {
    setSize(400, 300);
    setTitle("GridLayout Manager");
    // TODO voeg hier uw code toe
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        GridLayoutDemo gui = new GridLayoutDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}
