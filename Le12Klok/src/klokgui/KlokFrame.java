package klokgui;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import klok.Klok;

/**
 * Deze klasse toont een lopende klok die datum
 * en tijd aangeeft in een door de gebruiker
 * gekozen stad.
 *
 */
public class KlokFrame extends JFrame {
  /**
   * Constante voor het formatten van datum en tijd
   */
  private static final SimpleDateFormat tijdformaat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
  
  /**
   * De klok
   */
  private Klok klok = new Klok(this); 
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel tijdLabel = null;
  private JComboBox<String> stadKeuze = null;
 
  
  /**
   * This is the default constructor
   */
  public KlokFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Vraagt de tijd op bij de klok en toont deze in
   * het door tijdformaat beschreven formaat. Deze
   * methode moet elke seconde worden aangeroepen.
   *
   */
  public void update() {
    GregorianCalendar tijd = klok.getTijd();
    tijdLabel.setText(tijdformaat.format(tijd.getTime()));
  }
  
  /**
   * Voegt de namen van de steden uit het domein toe
   * aan de keuzelijst
   *
   */
  private void mijnInit() {
     for (String naam: klok.getStadsnamen()) {
      stadKeuze.addItem(naam);
    }
    klok.startKlok();
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
    this.setSize(264, 146);
    this.setLocation(new Point(300, 0));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Internationale klok");
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        closeWindow();
      }
    });
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      tijdLabel = new JLabel();
      tijdLabel.setBounds(new Rectangle(12, 12, 231, 42));
      tijdLabel.setFont(new Font("Dialog", Font.BOLD, 24));
      tijdLabel.setText("");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(tijdLabel, null);
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
      stadKeuze.setBounds(new Rectangle(63, 67, 129, 25));
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
        KlokFrame gui = new KlokFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
