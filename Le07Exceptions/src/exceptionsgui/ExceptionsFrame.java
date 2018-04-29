package exceptionsgui;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import exceptions.CheckedEnum;
import exceptions.CheckedExcep;
import exceptions.Err;
import exceptions.ErrEnum;
import exceptions.RuntimeEnum;
import exceptions.RuntimeExcep;

/**
 * Klasse waarmee diverse soorten errors en exceptions worden gedemonstreerd
 * @author Open Universiteit Nederland
 */
public class ExceptionsFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JTabbedPane mijnTabbladen = null;
  private JPanel errorPanel = null;
  private JPanel runtimeExceptionPanel = null;
  private JPanel checkedExceptionPanel = null;
  private JTextArea uitlegGebied = null;
  private JComboBox<ErrEnum> errorKeuze = null;
  private JComboBox<RuntimeEnum> runtimeKeuze = null;
  private JComboBox<CheckedEnum> checkedKeuze = null;
  private JTextArea errorGebied = null;
  private JTextArea runtimeGebied = null;
  private JTextArea checkedGebied = null;

  /**
   * This is the default constructor
   */
  public ExceptionsFrame() {
    super();
    initialize();
    mijnInit();
  }

  /**
   * Voegt de verschillende typen exceptions, uncheckedexceptions en errorr
   * toe aan de keuzelijsten en plaatst een
   * gebruiksaanwijzing in het uitvoergebied.
   */
  private void mijnInit() {
    uitlegGebied.append("Selecteer een tabblad.\n");
    uitlegGebied
        .append("Selecteer de foutsoort, u ziet de bijbehorende code\n");
    uitlegGebied.append("en het resultaat als deze code wordt uitgevoerd.");

    for (ErrEnum e : ErrEnum.values()) {
      errorKeuze.addItem(e);
    }
    for (RuntimeEnum e : RuntimeEnum.values()) {
      runtimeKeuze.addItem(e);
    }   
    for (CheckedEnum e : CheckedEnum.values()) {
      checkedKeuze.addItem(e);
    }
  }

  /**
   * Event handler; verwerkt keuze van een error soort
   */
  private void errorKeuzeAction() {
    errorGebied.setText("");
    ErrEnum keuze = (ErrEnum) errorKeuze.getSelectedItem();
    errorGebied.append(Err.getCode(keuze));
    errorGebied.append("\nHet resultaat van deze code is:\n");
    errorGebied.append(Err.getBoodschap(keuze));
  }

  /**
   * Event handler; verwerkt keuze van een unchecked exception soort
   */
  private void runtimeKeuzeAction() {
    runtimeGebied.setText("");
    RuntimeEnum keuze = (RuntimeEnum) runtimeKeuze.getSelectedItem();
    runtimeGebied.append(RuntimeExcep.getCode(keuze));
    runtimeGebied.append("\nHet resultaat van deze code is:\n");
    runtimeGebied.append(RuntimeExcep.getBoodschap(keuze));
  }

  /**
   * Event handler; verwerkt keuze van een checked exception soort
   */
  private void checkedKeuzeAction() {
    checkedGebied.setText("");
    CheckedEnum keuze = (CheckedEnum) checkedKeuze.getSelectedItem();
    checkedGebied.append(CheckedExcep.getCode(keuze));
    checkedGebied.append("\nHet resultaat van deze code is:\n");
    checkedGebied.append(CheckedExcep.getBoodschap(keuze));
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(568, 471);
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
      jContentPane.add(getUitlegGebied(), null);
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
      mijnTabbladen.setBounds(new Rectangle(15, 72, 469, 357));
      mijnTabbladen.addTab("Error", null, getErrorPanel(), null);
      mijnTabbladen.addTab("Runtime exception", null,
          getRuntimeExceptionPanel(), null);
      mijnTabbladen.addTab("CheckedException", null,
          getCheckedExceptionPanel(), null);
      mijnTabbladen.setBounds(new Rectangle(15, 72, 476, 364));
    }
    return mijnTabbladen;
  }

  /**
   * This method initializes errorPanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getErrorPanel() {
    if (errorPanel == null) {
      errorPanel = new JPanel();
      errorPanel.setLayout(null);
      errorPanel.add(getErrorKeuze(), null);
      errorPanel.add(getErrorArea(), null);
    }
    return errorPanel;
  }

  /**
   * This method initializes runtimeExceptionPanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getRuntimeExceptionPanel() {
    if (runtimeExceptionPanel == null) {
      runtimeExceptionPanel = new JPanel();
      runtimeExceptionPanel.setLayout(null);
      runtimeExceptionPanel.add(getRuntimeKeuze(), null);
      runtimeExceptionPanel.add(getRuntimeArea(), null);
    }
    return runtimeExceptionPanel;
  }

  /**
   * This method initializes checkedExceptionPanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getCheckedExceptionPanel() {
    if (checkedExceptionPanel == null) {
      checkedExceptionPanel = new JPanel();
      checkedExceptionPanel.setLayout(null);
      checkedExceptionPanel.add(getCheckedKeuze(), null);
      checkedExceptionPanel.add(getCheckedArea(), null);
    }
    return checkedExceptionPanel;
  }

  /**
   * This method initializes uitlegGebied
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getUitlegGebied() {
    if (uitlegGebied == null) {
      uitlegGebied = new JTextArea();
      uitlegGebied.setBounds(new Rectangle(18, 4, 372, 51));
      uitlegGebied.setFont(new Font("Dialog", Font.BOLD, 12));
    }
    return uitlegGebied;
  }

  /**
   * This method initializes errorKeuze
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<ErrEnum> getErrorKeuze() {
    if (errorKeuze == null) {
      errorKeuze = new JComboBox<>();
      errorKeuze.setBounds(new Rectangle(13, 12, 196, 22));
      errorKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          errorKeuzeAction();
        }
      });
    }
    return errorKeuze;
  }

  /**
   * This method initializes runtimeKeuze
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<RuntimeEnum> getRuntimeKeuze() {
    if (runtimeKeuze == null) {
      runtimeKeuze = new JComboBox<>();
      runtimeKeuze.setBounds(new Rectangle(5, 16, 167, 27));
      runtimeKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          runtimeKeuzeAction();

        }
      });
    }
    return runtimeKeuze;
  }

  /**
   * This method initializes checkedKeuze
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<CheckedEnum> getCheckedKeuze() {
    if (checkedKeuze == null) {
      checkedKeuze = new JComboBox<>();
      checkedKeuze.setBounds(new Rectangle(16, 12, 187, 25));
      checkedKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          checkedKeuzeAction();
        }
      });
    }
    return checkedKeuze;
  }

  /**
   * This method initializes errorArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getErrorArea() {
    if (errorGebied == null) {
      errorGebied = new JTextArea();
      errorGebied.setBounds(new Rectangle(13, 54, 437, 257));
    }
    return errorGebied;
  }

  /**
   * This method initializes runtimeArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getRuntimeArea() {
    if (runtimeGebied == null) {
      runtimeGebied = new JTextArea();
      runtimeGebied.setBounds(new Rectangle(17, 65, 434, 254));
    }
    return runtimeGebied;
  }

  /**
   * This method initializes checkedArea
   * 
   * @return javax.swing.JTextArea
   */
  private JTextArea getCheckedArea() {
    if (checkedGebied == null) {
      checkedGebied = new JTextArea();
      checkedGebied.setBounds(new Rectangle(18, 57, 435, 257));
    }
    return checkedGebied;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ExceptionsFrame gui = new ExceptionsFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

} // @jve:decl-index=0:visual-constraint="10,10"
