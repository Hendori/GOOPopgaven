package bibliotheekgui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * Bouwsteen voor gebruikersinterface voor de bibliotheek
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class BibliotheekFrame extends JFrame {
 
  public BibliotheekFrame() {
    super();
    initialize();
  }
  
  /**
   * Methode initialize geeft het frame een titel en geeft
   * de contentPane een BorderLayout. 
   */
  private void initialize(){
    setSize(450, 350);
    setTitle("Bibliotheek");   
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    // TODO voeg hier uw code toe
  }
   
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        BibliotheekFrame gui = new BibliotheekFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
  
}
