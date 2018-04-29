package overflowgui;

import overflow.IntOverflow;
import overflow.IntOverflowEnum;

import overflow.DoubleOverflow;
import overflow.DoubleOverflowEnum;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.Dimension;

/**
 * Toepassing waarmee de resultaten van nuldeling en overflow bij type int en
 * double wordt gedemonstreerd.
 * 
 * @author Open Universiteit Nederland
 */
public class OverflowFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JTabbedPane mijnTabbladen = null;
  private JPanel doublePanel = null;
  private JPanel intPanel = null;
  private JComboBox<DoubleOverflowEnum> doubleKeuze = null;
  private JTextArea doubleGebied = null;
  private JComboBox<IntOverflowEnum> intKeuze = null;
  private JTextArea intGebied = null;
  private JTextArea uitlegGebied = null;

  /**
   * This is the default constructor
   */
  public OverflowFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Voegt de verschillende typen double overflow en integer
   * overflow toe aan de keuzelijsten en plaatst een
   * gebruiksaanwijzing in het uitvoergebied.
   */
  private void mijnInit() {
    for (DoubleOverflowEnum d : DoubleOverflowEnum.values()) {
      doubleKeuze.addItem(d);
    }
    for (IntOverflowEnum d : IntOverflowEnum.values()) {
      intKeuze.addItem(d);
    }
    uitlegGebied.append("Kies een tabblad en daarop een foutsoort.\n");
    uitlegGebied.append(" Dan ziet u code en het resultaat van deze code. \n");
  }

  /**
   * Event handler; verwerkt keuze van een type double overflow
   */
  private void doubleKeuzeAction() {
    doubleGebied.setText("");
    DoubleOverflowEnum keuze = (DoubleOverflowEnum) doubleKeuze
        .getSelectedItem();
    doubleGebied.append(DoubleOverflow.getCode(keuze));
    doubleGebied.append("\n\nHet resultaat van deze code is : \n\n");
    doubleGebied.append("" + DoubleOverflow.getResultaat(keuze));
  }

  /**
   * Event handler; verwerkt keuze van een type int overflow
   */
  private void intKeuzeAction() {
    intGebied.setText("");
    IntOverflowEnum keuze = (IntOverflowEnum) intKeuze.getSelectedItem();
    intGebied.append(IntOverflow.getCode(keuze));
    intGebied.append("\n\nHet resultaat van deze code is : \n\n");
    intGebied.append("" + IntOverflow.getResultaat(keuze));
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(303, 303);
    this.setSize(new Dimension(303, 294));
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
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getMijnTabbladen(), null);
      jContentPane.add(getUitlegArea(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes mijnTabbladen
   * 
   * @return javax.swing.JTabbedPane
   */
  private JTabbedPane getMijnTabbladen() {
    if (mijnTabbladen == null) {
      mijnTabbladen = new JTabbedPane();
      mijnTabbladen.setBounds(new Rectangle(8, 75, 248, 191));
      mijnTabbladen.addTab("int", null, getIntPanel(), null);
      mijnTabbladen.addTab("double", null, getDoublePanel(), null);
      mijnTabbladen.setSize(new Dimension(248, 172));

    }
    return mijnTabbladen;
  }

  /**
   * This method initializes doublePanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getDoublePanel() {
    if (doublePanel == null) {
      doublePanel = new JPanel();
      doublePanel.setLayout(null);
      doublePanel.add(getDoubleComboBox(), null);
      doublePanel.add(getDoubleArea(), null);
    }
    return doublePanel;
  }

  /**
   * This method initializes intPanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getIntPanel() {
    if (intPanel == null) {
      intPanel = new JPanel();
      intPanel.setLayout(null);
      intPanel.add(getIntComboBox(), null);
      intPanel.add(getIntArea(), null);
    }
    return intPanel;
  }

  /**
   * This method initializes doubleComboBox
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<DoubleOverflowEnum> getDoubleComboBox() {
    if (doubleKeuze == null) {
      doubleKeuze = new JComboBox<>();
      doubleKeuze.setBounds(new Rectangle(9, 6, 135, 17));
      doubleKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          doubleKeuzeAction();
        }
      });
    }
    return doubleKeuze;
  }

  /**
   * This method initializes doubleArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getDoubleArea() {
    if (doubleGebied == null) {
      doubleGebied = new JTextArea();
      doubleGebied.setBounds(new Rectangle(5, 25, 220, 124));
    }
    return doubleGebied;
  }

  /**
   * This method initializes intComboBox
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<IntOverflowEnum> getIntComboBox() {
    if (intKeuze == null) {
      intKeuze = new JComboBox<>();
      intKeuze.setBounds(new Rectangle(9, 6, 135, 17));
      intKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          intKeuzeAction();
        }
      });
    }
    return intKeuze;
  }

  /**
   * This method initializes intArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getIntArea() {
    if (intGebied == null) {
      intGebied = new JTextArea();
      intGebied.setBounds(new Rectangle(9, 27, 220, 118));
    }
    return intGebied;
  }

  /**
   * This method initializes uitlegArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getUitlegArea() {
    if (uitlegGebied == null) {
      uitlegGebied = new JTextArea();
      uitlegGebied.setBounds(new Rectangle(11, 7, 276, 61));
    }
    return uitlegGebied;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        OverflowFrame gui = new OverflowFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

} // @jve:decl-index=0:visual-constraint="10,10"
