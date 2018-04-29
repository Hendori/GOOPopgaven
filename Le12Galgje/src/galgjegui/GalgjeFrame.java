package galgjegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import galgje.Galgje;
import galgje.Galgje.Uitslag;

public class GalgjeFrame extends JFrame {
  
  private Galgje galgje = new Galgje("programmeren");  //  @jve:decl-index=0:

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel uitslagLabel = null;
  private JLabel raadLabel = null;
  private JTextField letterVeld = null;
  private JLabel misLabel = null;

  private JLabel aanwijzingLabel = null;

  /**
   * This is the default constructor
   */
  public GalgjeFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Toont het juiste aantal plusjes
   */
  private void mijnInit(){
    raadLabel.setText(galgje.getGoedString());
  }
  
  /**
   * Verwerkt de invoer van een letter door bij het galgje
   * de goede string, de foute letters tot nu toe
   * en de uitslag op te vragen
   */
  private void letterVeldAction() {
    String invoer = letterVeld.getText().trim();
    char c = invoer.charAt(0);
    galgje.probeer(c);
    raadLabel.setText(galgje.getGoedString());
    misLabel.setText(galgje.getFoutString());
    Uitslag uitslag = galgje.getUitslag();
    if (uitslag == Uitslag.WINST) {
      uitslagLabel.setText("Je hebt gewonnen");
    } 
    else if (uitslag == Uitslag.VERLIES) {
      uitslagLabel.setText("Je hebt verloren");
    }
    letterVeld.setText("");
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(241, 240);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Galgje");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      aanwijzingLabel = new JLabel();
      aanwijzingLabel.setBounds(new Rectangle(22, 103, 124, 47));
      aanwijzingLabel.setText("Voer een letter in");
      misLabel = new JLabel();
      misLabel.setBounds(new Rectangle(20, 163, 190, 33));
      misLabel.setFont(new Font("Dialog", Font.BOLD, 12));
      misLabel.setText("");
      raadLabel = new JLabel();
      raadLabel.setBounds(new Rectangle(20, 57, 190, 33));
      raadLabel.setFont(new Font("Dialog", Font.BOLD, 24));
      raadLabel.setText("");
      uitslagLabel = new JLabel();
      uitslagLabel.setBounds(new Rectangle(19, 12, 213, 33));
      uitslagLabel.setFont(new Font("Dialog", Font.BOLD, 24));
      uitslagLabel.setForeground(Color.red);
      uitslagLabel.setText("");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(uitslagLabel, null);
      jContentPane.add(raadLabel, null);
      jContentPane.add(getLetterVeld(), null);
      jContentPane.add(misLabel, null);
      jContentPane.add(aanwijzingLabel, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes letterVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getLetterVeld() {
    if (letterVeld == null) {
      letterVeld = new JTextField();
      letterVeld.setBounds(new Rectangle(154, 103, 55, 49));
      letterVeld.setFont(new Font("Dialog", Font.BOLD, 24));
      letterVeld.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          letterVeldAction();
        }
      });
    }
    return letterVeld;
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        GalgjeFrame gui = new GalgjeFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
