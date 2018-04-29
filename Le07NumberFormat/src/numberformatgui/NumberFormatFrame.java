package numberformatgui;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Klasse waarmee het opgooien, vangen of propageren 
 * van een NumberFormatException wordt getoond.
 * @author Open Universiteit Nederland
 * 
 */
public class NumberFormatFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JButton okKnop = null;
  private JTextField invoerVeld = null;
  private JTextArea uitvoerGebied = null;
  private JLabel foutLabel = null;

  /**
   * This is the default constructor
   */
  public NumberFormatFrame() {
    super();
    initialize();
  }

  // Opdrachten 7.7, 7.8b, 7.9, 7.12 
  /**
   * Leest een geheel getal uit invoerVeld en toont dit in uitvoerGebied 
   * Bijzonderheid: Als de invoer geen getal is, wordt dit gemeld in foutLabel
   */
  private void okKnopAction() {
    foutLabel.setText("");
    try {
      int i = Integer.parseInt(invoerVeld.getText());
      uitvoerGebied.append("i = " + i + "\n");
    }
    catch (NumberFormatException exception) {
      foutLabel.setText("FOUT: Tekstveld bevat geen geheel getal." );
    }
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(374, 241);
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
      foutLabel = new JLabel();
      foutLabel.setBounds(new Rectangle(20, 168, 331, 25));
      foutLabel.setFont(new Font("Dialog", Font.BOLD, 12));
      foutLabel.setText("");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getOkKnop(), null);
      jContentPane.add(getInvoerVeld(), null);
      jContentPane.add(getUitvoerGebied(), null);
      jContentPane.add(foutLabel, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes okKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getOkKnop() {
    if (okKnop == null) {
      okKnop = new JButton();
      okKnop.setBounds(new Rectangle(218, 15, 64, 27));
      okKnop.setText("OK");
      okKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          okKnopAction();
        }
      });
    }
    return okKnop;
  }

  /**
   * This method initializes invoerVeld
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getInvoerVeld() {
    if (invoerVeld == null) {
      invoerVeld = new JTextField();
      invoerVeld.setBounds(new Rectangle(21, 15, 189, 27));
    }
    return invoerVeld;
  }

  /**
   * This method initializes uitvoerGebied
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getUitvoerGebied() {
    if (uitvoerGebied == null) {
      uitvoerGebied = new JTextArea();
      uitvoerGebied.setBounds(new Rectangle(18, 50, 329, 111));
    }
    return uitvoerGebied;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        NumberFormatFrame gui = new NumberFormatFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

} // @jve:decl-index=0:visual-constraint="10,10"
