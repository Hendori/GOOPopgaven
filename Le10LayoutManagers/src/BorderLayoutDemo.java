
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Demo-klasse voor een layout manager van type BorderLayout
 */
@SuppressWarnings("serial")
public class BorderLayoutDemo extends JFrame {

  public BorderLayoutDemo() {
    super();
    initialize();
  }

  /**
   * Plaats met behulp van een BorderLayout-manager 
   * vijf knoppen op het scherm, met hun positie
   * als opschrift
   */
  private void initialize() {
    setSize(400, 300);
    setTitle("BorderLayout Manager");
    // TODO voeg hier uw code toe
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        BorderLayoutDemo gui = new BorderLayoutDemo();
        gui.setVisible(true);
	    gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}
