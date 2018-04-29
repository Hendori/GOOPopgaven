import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Applicatie die een aantal vierkanten toont.
 * @author Open Universiteit Nederland.
 */
@SuppressWarnings("serial")
public class VierkantenFrame extends JFrame {
  
  public VierkantenFrame() {
    super();
    initialize();
  }

  /**
   * Tekent tien blauwe vierkanten op random locaties
   */
  private void initialize() {
    setTitle("Vierkanten");
    setSize(500, 500);
    
    Container pane = getContentPane();
    pane.setLayout(null);
    pane.setBackground(Color.WHITE);

    for (int i = 0; i < 10; i++) {
      Vierkant vierkant = new Vierkant(Color.BLUE);
      vierkant.setLocation((int)(400 * Math.random()),
                           (int)(400 * Math.random()));
      pane.add(vierkant);
    }
  }
  
  public static void main(String[] arg) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        VierkantenFrame gui = new VierkantenFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}
