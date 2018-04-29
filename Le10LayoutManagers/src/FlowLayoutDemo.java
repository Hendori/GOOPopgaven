
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Demo-klasse voor een layout manager van type FlowLayout
 */
@SuppressWarnings("serial")
public class FlowLayoutDemo extends JFrame {
  
  @SuppressWarnings("unused")
  private static final int AANTAL = 100;

  public FlowLayoutDemo() {
    super();
    initialize();
  }

  /**
   * Plaats met behulp van een FlowLayout-manager 
   * AANTAL knoppen op het scherm, met hun volgnummer
   * als opschrift
   */
  private void initialize() {
    setSize(400, 300);
    setTitle("FlowLayout Manager");
    // TODO voeg hier uw code toe
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        FlowLayoutDemo gui = new FlowLayoutDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}