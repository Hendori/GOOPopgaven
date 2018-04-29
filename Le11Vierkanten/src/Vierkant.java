import java.awt.Color;

import javax.swing.JPanel;

/**
 * Representeert een vierkante panel.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class Vierkant extends JPanel {
  private static final int AFMETING = 40;
  
  @SuppressWarnings("unused")
  private static final int DELTA = 10; // verplaatsing in pixels
  
  /**
   * Maakt een vierkante panel.
   */
  public Vierkant(Color kleur) {
    setSize(AFMETING, AFMETING);
    setBackground(kleur);  
    setFocusable(true);
  }
}
