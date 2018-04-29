package wedstrijdgui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * User interface voor drie renners, waarvan de positie
 * wordt weergegeven in een JLabel. 
 * Elke renner heeft een knop waarmee die versneld kan worden.
 * Labels tonen de nummers van de renner en de winnaar wanneer
 * die bekend is.
 */
public class WedstrijdFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel renner1Label = null;
  private JLabel renner2Label = null;
  private JLabel renner3Label = null;
  private JButton snellerKnop0 = null;
  private JButton snellerKnop1 = null;
  private JButton snellerKnop2 = null;
  private JLabel winstLabel = null;
  private JLabel nummer1Label = null;
  private JLabel nummer2Label = null;
  private JLabel nummer0Label = null;
  /**
   * This is the default constructor
   */
  public WedstrijdFrame() {
    super();
    initialize();
  }
  
  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(514, 277);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Wedstrijd");
  }


  /**
   * This method initializes JContentPane
   */
  private JPanel getJContentPane() {
    if (jContentPane == null)      {
      nummer0Label = new JLabel();
      nummer0Label.setBounds(new Rectangle(467, 22, 21, 32));
      nummer0Label.setForeground(Color.red);
      nummer0Label.setText("0");
      nummer0Label.setFont(new Font("Dialog", Font.BOLD, 24));
      nummer1Label = new JLabel();
      nummer1Label.setFont(new Font("Dialog", Font.BOLD, 24));
      nummer1Label.setForeground(Color.red);
      nummer1Label.setBounds(new Rectangle(467, 76, 21, 32));
      nummer1Label.setText("1");
      nummer2Label = new JLabel();
      nummer2Label.setFont(new Font("Dialog", Font.BOLD, 24));
      nummer2Label.setForeground(Color.red);
      nummer2Label.setBounds(new Rectangle(467, 130, 21, 32));
      nummer2Label.setText("2");
      winstLabel = new JLabel();
      winstLabel.setBounds(new Rectangle(9, 185, 474, 31));
      winstLabel.setFont(new Font("Dialog", Font.BOLD, 24));
      winstLabel.setForeground(Color.red);
      winstLabel.setText("");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getRenner1Label(), null);
      jContentPane.add(getRenner2Label(), null);
      jContentPane.add(getRenner3Label(), null);
      jContentPane.add(getSnellerKnop0(), null);
      jContentPane.add(getSnellerKnop1(), null);      
      jContentPane.add(getSnellerKnop2(), null);
      jContentPane.add(winstLabel, null);
      winstLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
      winstLabel.setForeground(Color.red);
      jContentPane.add(nummer1Label, null);
      jContentPane.add(nummer2Label, null);
      jContentPane.add(nummer0Label, null);
      nummer0Label.setFont(new Font("Dialog", Font.BOLD, 24));
      nummer0Label.setForeground(Color.red);
    }
    return jContentPane;
  }

  /**
   * This method initializes renner1Label       
   *    
   * @return javax.swing.JProgressBar   
   */
  private JLabel getRenner1Label() {
    if (renner1Label == null) {
      renner1Label = new JLabel();
      renner1Label.setBounds(new Rectangle(102, 23, 337, 31));
      renner1Label.setFont(new Font("Dialog", Font.BOLD, 12));
    }
    return renner1Label;
  }

  /**
   * This method initializes renner2Label       
   *    
   * @return javax.swing.JProgressBar   
   */
  private JLabel getRenner2Label() {
    if (renner2Label == null) {
      renner2Label = new JLabel();
      renner2Label.setBounds(new Rectangle(102, 77, 337, 31));
      renner2Label.setFont(new Font("Dialog", Font.BOLD, 12));
    }
    return renner2Label;
  }

  /**
   * This method initializes renner3Label       
   *    
   * @return javax.swing.JProgressBar   
   */
  private JLabel getRenner3Label() {
    if (renner3Label == null) {
      renner3Label = new JLabel();
      renner3Label.setBounds(new Rectangle(102, 131, 337, 31));
      renner3Label.setText("");
      renner3Label.setFont(new Font("Dialog", Font.BOLD, 12));
    }
    return renner3Label;
  }

  /**
   * This method initializes snellerKnop0	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getSnellerKnop0() {
    if (snellerKnop0 == null) {
      snellerKnop0 = new JButton();
      snellerKnop0.setBounds(new Rectangle(6, 23, 86, 31));
      snellerKnop0.setText("Sneller");
    }
    return snellerKnop0;
  }

  /**
   * This method initializes snellerKnop1	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getSnellerKnop1() {
    if (snellerKnop1 == null) {
      snellerKnop1 = new JButton();
      snellerKnop1.setText("Sneller");
      snellerKnop1.setBounds(new Rectangle(6, 77, 85, 31));
    }
    return snellerKnop1;
  }

  /**
   * This method initializes snellerKnop2	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getSnellerKnop2() {
    if (snellerKnop2 == null) {
      snellerKnop2 = new JButton();
      snellerKnop2.setBounds(new Rectangle(6, 131, 85, 31));
      snellerKnop2.setText("Sneller");
    }
    return snellerKnop2;
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        WedstrijdFrame gui = new WedstrijdFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
