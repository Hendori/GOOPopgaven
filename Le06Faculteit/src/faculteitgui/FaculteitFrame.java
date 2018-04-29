package faculteitgui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;

import faculteit.Faculteit;

/** 
 * Klasse waarmee de faculteit van een natuurlijk getal getoond wordt. 
 * @author Open Universiteit Nederland
 *
 */
public class FaculteitFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  private JPanel jContentPane = null;
  private JLabel getalLabel = null;
  private JTextField getalTextField = null;
  private JLabel uitkomstLabel = null;
  private JButton facKnop = null;

  /**
   * This is the default constructor
   */
  public FaculteitFrame() {
    super();
    initialize();
  }
  
  /**
   * Event handler voor berekenen faculteit
   * Leest getal n uit tekstveld en berekent en toont n!
   */
  private void facKnopAction() {
    int n = Integer.parseInt(getalTextField.getText());
    uitkomstLabel.setText(Faculteit.faculteitRec(n) + "");
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(311, 144);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("JFrame");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      uitkomstLabel = new JLabel();
      uitkomstLabel.setBounds(new Rectangle(19, 74, 164, 25));
      uitkomstLabel.setText("");
      getalLabel = new JLabel();
      getalLabel.setBounds(new Rectangle(15, 10, 238, 20));
      getalLabel.setText("voer positief geheel getal in kleiner dan 21");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getalLabel, null);
      jContentPane.add(getGetalTextField(), null);
      jContentPane.add(uitkomstLabel, null);
      jContentPane.add(getFacKnop(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes getalTextField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getGetalTextField() {
    if (getalTextField == null) {
      getalTextField = new JTextField();
      getalTextField.setBounds(new Rectangle(16, 41, 95, 26));
    }
    return getalTextField;
  }

  /**
   * This method initializes facKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getFacKnop() {
    if (facKnop == null) {
      facKnop = new JButton();
      facKnop.setBounds(new Rectangle(125, 41, 167, 26));
      facKnop.setText("bereken de faculteit");
      facKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          facKnopAction();
        }
      });
    }
    return facKnop;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
  	    FaculteitFrame gui = new FaculteitFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

} // @jve:decl-index=0:visual-constraint="10,10"
