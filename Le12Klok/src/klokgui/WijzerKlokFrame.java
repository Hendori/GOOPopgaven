package klokgui;

import javax.swing.*;
import java.awt.Rectangle;
import klok.Klok;


/**
 * Deze klasse toont een lopende klok met wijzers die
 * tijd aangeeft in een door de gebruiker gekozen stad.
 */
public class WijzerKlokFrame extends JFrame {
  
  private Klok klok = new Klok(this); // de klok 
  private static final long serialVersionUID = 1L;
  private KlokPanel klokPanel = null;
  private JPanel jContentPane = null;
  private JComboBox<String> stadKeuze = null;
  
  /**
   * This is the default constructor
   */
  public WijzerKlokFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Update de grafische representatie van de klok.
   */
  public void update() {
    paint(getGraphics());
//    klokPanel.repaint();
  }
  
  /**
   * Maakt de klok, voegt deze toe aan de interface.
   * Voegt de namen van de steden uit het domein toe
   * aan de keuzelijst
   */
  private void mijnInit() {
    for (String naam: klok.getStadsnamen()) {
      stadKeuze.addItem(naam);
    }
    klok.startKlok();
    klokPanel.setKlok(klok);

  }
  
  /**
   * Geeft een wijziging in de keuze van de stad door aan
   * de klok.
   */
  private void stadKeuzeAction() {
    int index = stadKeuze.getSelectedIndex();
    klok.wijzigStad(index);
  }
  
  /**
   * Bij het sluiten van het frame wordt eerst de klok gestopt.
   */
  private void closeWindow() {
    klok.stopKlok();
    System.exit(0);
  }
  
  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(230, 314);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Internationale klok");
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        closeWindow();
      }
    });
    klokPanel = new KlokPanel();
    klokPanel.setLocation(10, 10);
    jContentPane.add(klokPanel);
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getStadKeuze(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes stadKeuze  
   *    
   * @return javax.swing.JComboBox      
   */
  private JComboBox<String> getStadKeuze() {
    if (stadKeuze == null) {
      stadKeuze = new JComboBox<>();
      stadKeuze.setBounds(new Rectangle(50, 240, 120, 25));
      stadKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          stadKeuzeAction();
        }
      });
    }
    return stadKeuze;
  }
  
  public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        WijzerKlokFrame gui = new WijzerKlokFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
