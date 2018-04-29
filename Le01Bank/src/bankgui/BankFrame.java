package bankgui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bank.Bank;
import simulatie.Tijdbeheer;

/**
 * Bankframe is de gebruikersinterface voor de bank.
 * @author Open Universiteit Nederland
 *
 */
public class BankFrame extends JFrame {
  //constante voor formatteren bedrag
  private static final DecimalFormat BEDRAGFORMAT = new DecimalFormat("##.00");
  
  private static final long serialVersionUID = 1L;
  private JTabbedPane mijnTabbladen = null;
  private JPanel openPanel = null;
  private JPanel stortPanel = null;
  private JPanel maakoverPanel = null;
  private JPanel saldoPanel = null;
  private JTextField openNaamVeld = null;
  private JButton openKnop = null;
  private JLabel openMeldingLabel = null;
  private JTextField stortNummerVeld = null;
  private JButton stortKnop = null;
  private JButton neemopKnop = null;
  private JComboBox<String> openKeuze = null;
  private JTextField openTegenVeld = null;
  private JLabel openNaamLabel = null;
  private JLabel openTegenLabel = null;
  private JLabel saldoNummerLabel = null;
  private JTextField saldoNummerVeld = null;
  private JLabel saldoMeldingLabel = null;
  private JButton saldoKnop = null;
  private JLabel stortNummerLabel = null;
  private JTextField stortBedragVeld = null;
  private JLabel stortBedragLabel = null;
  private JLabel overVanLabel = null;
  private JLabel overNaarLabel = null;
  private JTextField overVanVeld = null;
  private JTextField overNaarVeld = null;
  private JButton overKnop = null;
  private JLabel overBedragLabel = null;
  private JTextField overBedragVeld = null;
  private JPanel simulatiePanel = null;
  private JLabel huidigeDatumLabel = null;
  private JLabel nieuweDatumLabel = null;
  private JTextField huidigeDatumVeld = null;
  private JTextField nieuweDatumVeld = null;
  private JButton simulatieKnop = null;

  private Bank bank = null;
  private Tijdbeheer tijdbeheer = null;

  /**
   * Constructor
   */
  public BankFrame() {
    super();
    initialize();
    mijnInit();
  }

  /**
   * Koppelt de gebruikersinterface aan de bank en de simulatie
   * en initialiseert waarden van de gebruikersinterface.
   */
  private void mijnInit() {
    openKeuze.addItem("Betaalrekening");
    openKeuze.addItem("Spaarrekening");
    openKeuze.setSelectedIndex(-1);
    openTegenLabel.setVisible(false);
    openTegenVeld.setVisible(false);
    GregorianCalendar vandaag = new GregorianCalendar();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    huidigeDatumVeld.setText(formatter.format(vandaag.getTime()));
    bank = new Bank();
    tijdbeheer = new Tijdbeheer(bank, vandaag);
  }

  /**
   * Event handler aangeroepen bij wijziging tabblad.
   * Maakt meldingvelden leeg.
   */
  private void tabChangedAction() {
    openMeldingLabel.setText("");
    saldoMeldingLabel.setText("");
  }

  /**
   * Event handler aangeroepen bij selectie van te openen
   * rekenening. Maakt de benodigde invoervelden zichtbaar.
   */
  private void openComboBoxAction() {
    boolean visible = false;
    if (openKeuze.getSelectedIndex() > 0) {
      visible = true;
    }
    openTegenLabel.setVisible(visible);
    openTegenVeld.setVisible(visible);
  }

  /**
   * Event handler voor het openen van een rekening.
   * Maakt een nieuwe rekening.
   */
  private void openButtonAction() {
    String naam = openNaamVeld.getText();
    int nummer = 0;
    switch (openKeuze.getSelectedIndex()) {
      case 0: // betaalrekening
        nummer = bank.maakBetaalrekening(naam);
        break;
      case 1: // spaarrekening
        String t = openTegenVeld.getText();
        nummer = bank.maakSpaarrekening(naam, Integer.parseInt(t));
        break;
    }
    if (nummer == 0) {
      openMeldingLabel.setText("Fout bij maken rekening");
    } else {
      openMeldingLabel.setText("Nieuwe rekening met nummer " +
          nummer + " gemaakt");
    }
    openNaamVeld.setText("");
    openKeuze.setSelectedIndex(-1);
  }

  /**
   * Event handler bij storten van bedrag op rekening.
   * Vraagt de bank de stortingsopdracht uit te voeren.
   */
  private void stortButtonAction() {
    String n = stortNummerVeld.getText();
    int nummer = Integer.parseInt(n);
    String b = stortBedragVeld.getText();
    double bedrag = Double.parseDouble(b);
    bank.stort(nummer, bedrag);
    stortNummerVeld.setText("");
    stortBedragVeld.setText("");
  }

  /**
   * Event handler bij opnemen van bedrag van rekening.
   * Vraagt de bank de opname uit te voeren.
   */
  private void neemopButtonAction() {
    String n = stortNummerVeld.getText();
    int nummer = Integer.parseInt(n);
    String b = stortBedragVeld.getText();
    double bedrag = Double.parseDouble(b);
    bank.neemOp(nummer, bedrag);
    stortNummerVeld.setText("");
    stortBedragVeld.setText("");
  }  

  /**
   * Event handler bij opnemen van bedrag van rekening.
   * Vraagt de bank de overmakingsopdracht uit te voeren.
   */
  private void maakOverButtonAction() {
    String nv = overVanVeld.getText();
    int van = Integer.parseInt(nv);
    String nn = overNaarVeld.getText();
    int naar = Integer.parseInt(nn);
    String b = overBedragVeld.getText();
    double bedrag = Double.parseDouble(b);
    bank.maakOver(van, naar, bedrag);
    overVanVeld.setText("");
    overNaarVeld.setText("");
    overBedragVeld.setText("");
  }

  /**
   * Event handler bij opvragen van saldo van rekening.
   * Vraagt de bank het saldo en toont dit saldo.
   */
  private void saldoButtonAction() {
    String n = saldoNummerVeld.getText();
    int nummer = Integer.parseInt(n);
    double saldo = bank.geefSaldo(nummer);
    saldoMeldingLabel.setText("Saldo van rekening " + n +
        " is " + BEDRAGFORMAT.format(saldo));
    saldoNummerVeld.setText("");
  }  

  /**
   * Event handler voor het invoeren van nieuwe datum voor simulatie.
   */
  private void simulatieButtonAction() {
    String sdatum = nieuweDatumVeld.getText();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    formatter.setLenient(false);
    Date date = formatter.parse(sdatum, new ParsePosition(0));
    if (date != null) {
      GregorianCalendar datum = new GregorianCalendar();
      datum.setTime(date);
      tijdbeheer.wijzigDatum(datum);
      huidigeDatumVeld.setText(formatter.format(datum.getTime()));
      nieuweDatumVeld.setText("");
    }
  }

  /**
   * This method initializes this
   * 
   */
  private void initialize() {
    this.setTitle("Bank Simulatie");
    this.setContentPane(getMijnTabbladen());
    this.setSize(new Dimension(383, 251)); 		
  }

  /**
   * This method initializes mijnTabbladen	
   * 	
   * @return javax.swing.JTabbedPane	
   */
  private JTabbedPane getMijnTabbladen() {
    if (mijnTabbladen == null) {
      mijnTabbladen = new JTabbedPane();
      mijnTabbladen.addTab("Open", null, getOpenPanel(), null);
      mijnTabbladen.addTab("Stort / Neem op", null, getStortPanel(), null);
      mijnTabbladen.addTab("Maak over", null, getMaakoverPanel(), null);
      mijnTabbladen.addTab("Saldo", null, getSaldoPanel(), null);
      mijnTabbladen.addTab("Simulatie", null, getSimulatiePanel(), null);
      mijnTabbladen.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent e) {
          tabChangedAction();
        }
      });
    }
    return mijnTabbladen;
  }

  /**
   * This method initializes openPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getOpenPanel() {
    if (openPanel == null) {
      openTegenLabel = new JLabel();
      openTegenLabel.setBounds(new Rectangle(158, 45, 88, 16));
      openTegenLabel.setText("Tegenrekening:");
      openNaamLabel = new JLabel();
      openNaamLabel.setBounds(new Rectangle(13, 12, 43, 20));
      openNaamLabel.setText("Naam:");
      openMeldingLabel = new JLabel();
      openMeldingLabel.setBounds(new Rectangle(13, 142, 256, 20));
      openMeldingLabel.setText("");
      openPanel = new JPanel();
      openPanel.setLayout(null);
      openPanel.add(getOpenNaamTextField(), null);
      openPanel.add(getOpenButton(), null);
      openPanel.add(openMeldingLabel, null);
      openPanel.add(getOpenComboBox(), null);
      openPanel.add(getOpenTegenTextField(), null);
      openPanel.add(openNaamLabel, null);
      openPanel.add(openTegenLabel, null);
    }
    return openPanel;
  }

  /**
   * This method initializes stortPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getStortPanel() {
    if (stortPanel == null) {
      stortBedragLabel = new JLabel();
      stortBedragLabel.setBounds(new Rectangle(17, 44, 104, 20));
      stortBedragLabel.setText("Bedrag:");
      stortNummerLabel = new JLabel();
      stortNummerLabel.setBounds(new Rectangle(17, 15, 104, 20));
      stortNummerLabel.setText("Rekeningnummer:");
      stortPanel = new JPanel();
      stortPanel.setLayout(null);
      stortPanel.add(getStortNummerTextField(), null);
      stortPanel.add(getStortButton(), null);
      stortPanel.add(getNeemopButton(), null);
      stortPanel.add(stortNummerLabel, null);
      stortPanel.add(getStortBedragTextField(), null);
      stortPanel.add(stortBedragLabel, null);
    }
    return stortPanel;
  }

  /**
   * This method initializes maakoverPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getMaakoverPanel() {
    if (maakoverPanel == null) {
      overBedragLabel = new JLabel();
      overBedragLabel.setBounds(new Rectangle(5, 70, 142, 17));
      overBedragLabel.setText("Bedrag:");
      overNaarLabel = new JLabel();
      overNaarLabel.setBounds(new Rectangle(5, 41, 141, 16));
      overNaarLabel.setText("Rekeningnummer (naar):");
      overVanLabel = new JLabel();
      overVanLabel.setBounds(new Rectangle(5, 16, 141, 16));
      overVanLabel.setText("Rekeningnummer (van):");
      maakoverPanel = new JPanel();
      maakoverPanel.setLayout(null);
      maakoverPanel.add(overVanLabel, null);
      maakoverPanel.add(overNaarLabel, null);
      maakoverPanel.add(getOverVanTextField(), null);
      maakoverPanel.add(getOverNaarTextField(), null);
      maakoverPanel.add(getOverButton(), null);
      maakoverPanel.add(overBedragLabel, null);
      maakoverPanel.add(getOverBedragTextField(), null);
    }
    return maakoverPanel;
  }

  /**
   * This method initializes saldoPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getSaldoPanel() {
    if (saldoPanel == null) {
      saldoMeldingLabel = new JLabel();
      saldoMeldingLabel.setBounds(new Rectangle(11, 151, 283, 20));
      saldoMeldingLabel.setText("");
      saldoNummerLabel = new JLabel();
      saldoNummerLabel.setBounds(new Rectangle(11, 14, 119, 20));
      saldoNummerLabel.setText("Rekeningnummer:");
      saldoPanel = new JPanel();
      saldoPanel.setLayout(null);
      saldoPanel.add(saldoNummerLabel, null);
      saldoPanel.add(getSaldoNummerTextField(), null);
      saldoPanel.add(saldoMeldingLabel, null);
      saldoPanel.add(getSaldoButton(), null);
    }
    return saldoPanel;
  }

  /**
   * This method initializes openNaamTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getOpenNaamTextField() {
    if (openNaamVeld == null) {
      openNaamVeld = new JTextField();
      openNaamVeld.setBounds(new Rectangle(64, 12, 205, 20));
      openNaamVeld.setText("");
    }
    return openNaamVeld;
  }

  /**
   * This method initializes openButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getOpenButton() {
    if (openKnop == null) {
      openKnop = new JButton();
      openKnop.setBounds(new Rectangle(158, 99, 111, 26));
      openKnop.setMargin(new Insets(2, 2, 2, 2));
      openKnop.setText("Open rekening");
      openKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          openButtonAction();
        }
      });
    }
    return openKnop;
  }

  /**
   * This method initializes stortNummerTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getStortNummerTextField() {
    if (stortNummerVeld == null) {
      stortNummerVeld = new JTextField();
      stortNummerVeld.setBounds(new Rectangle(126, 15, 94, 20));
    }
    return stortNummerVeld;
  }

  /**
   * This method initializes stortButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getStortButton() {
    if (stortKnop == null) {
      stortKnop = new JButton();
      stortKnop.setBounds(new Rectangle(14, 82, 109, 26));
      stortKnop.setText("Stort");
      stortKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          stortButtonAction();
        }
      });
    }
    return stortKnop;
  }

  /**
   * This method initializes neemopButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getNeemopButton() {
    if (neemopKnop == null) {
      neemopKnop = new JButton();
      neemopKnop.setBounds(new Rectangle(14, 117, 109, 26));
      neemopKnop.setText("Neem op");
      neemopKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          neemopButtonAction();
        }
      });
    }
    return neemopKnop;
  }

  /**
   * This method initializes openComboBox	
   * 	
   * @return javax.swing.JComboBox	
   */
  private JComboBox<String> getOpenComboBox() {
    if (openKeuze == null) {
      openKeuze = new JComboBox<>();
      openKeuze.setBounds(new Rectangle(13, 45, 133, 20));
      openKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          openComboBoxAction();
        }
      });
    }
    return openKeuze;
  }

  /**
   * This method initializes openTegenTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getOpenTegenTextField() {
    if (openTegenVeld == null) {
      openTegenVeld = new JTextField();
      openTegenVeld.setBounds(new Rectangle(158, 67, 111, 20));
    }
    return openTegenVeld;
  }


  /**
   * This method initializes saldoNummerTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getSaldoNummerTextField() {
    if (saldoNummerVeld == null) {
      saldoNummerVeld = new JTextField();
      saldoNummerVeld.setLocation(new Point(138, 14));
      saldoNummerVeld.setSize(new Dimension(111, 20));
    }
    return saldoNummerVeld;
  }


  /**
   * This method initializes saldoButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getSaldoButton() {
    if (saldoKnop == null) {
      saldoKnop = new JButton();
      saldoKnop.setBounds(new Rectangle(138, 57, 111, 20));
      saldoKnop.setText("Geef saldo");
      saldoKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          saldoButtonAction();
        }
      });
    }
    return saldoKnop;
  }

  /**
   * This method initializes stortBedragTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getStortBedragTextField() {
    if (stortBedragVeld == null) {
      stortBedragVeld = new JTextField();
      stortBedragVeld.setBounds(new Rectangle(126, 44, 94, 20));
    }
    return stortBedragVeld;
  }

  /**
   * This method initializes overVanTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getOverVanTextField() {
    if (overVanVeld == null) {
      overVanVeld = new JTextField();
      overVanVeld.setBounds(new Rectangle(163, 16, 93, 17));
    }
    return overVanVeld;
  }

  /**
   * This method initializes overNaarTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getOverNaarTextField() {
    if (overNaarVeld == null) {
      overNaarVeld = new JTextField();
      overNaarVeld.setBounds(new Rectangle(163, 41, 94, 17));
    }
    return overNaarVeld;
  }

  /**
   * This method initializes overButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getOverButton() {
    if (overKnop == null) {
      overKnop = new JButton();
      overKnop.setBounds(new Rectangle(5, 100, 123, 26));
      overKnop.setText("Maak over");
      overKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          maakOverButtonAction();
        }
      });
    }
    return overKnop;
  }

  /**
   * This method initializes overBedragTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getOverBedragTextField() {
    if (overBedragVeld == null) {
      overBedragVeld = new JTextField();
      overBedragVeld.setBounds(new Rectangle(163, 70, 94, 17));
    }
    return overBedragVeld;
  }
  /**
   * This method initializes simulatiePanel 
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel getSimulatiePanel() {
    if (simulatiePanel == null) {
      nieuweDatumLabel = new JLabel();
      nieuweDatumLabel.setBounds(new Rectangle(7, 38, 84, 16));
      nieuweDatumLabel.setText("Nieuwe datum:");
      huidigeDatumLabel = new JLabel();
      huidigeDatumLabel.setText("Huidige datum:");
      huidigeDatumLabel.setBounds(new Rectangle(7, 13, 84, 16));
      simulatiePanel = new JPanel();
      simulatiePanel.setLayout(null);
      simulatiePanel.add(huidigeDatumLabel, null);
      simulatiePanel.add(nieuweDatumLabel, null);
      simulatiePanel.add(getHuidigeDatumTextField(), null);
      simulatiePanel.add(getNieuweDatumTextField(), null);
      simulatiePanel.add(getSimulatieButton(), null);
    }
    return simulatiePanel;
  }

  /**
   * This method initializes huidigeDatumTextField  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getHuidigeDatumTextField() {
    if (huidigeDatumVeld == null) {
      huidigeDatumVeld = new JTextField();
      huidigeDatumVeld.setBounds(new Rectangle(104, 13, 111, 17));
      huidigeDatumVeld.setEditable(false);
    }
    return huidigeDatumVeld;
  }

  /**
   * This method initializes nieuweDatumTextField 
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getNieuweDatumTextField() {
    if (nieuweDatumVeld == null) {
      nieuweDatumVeld = new JTextField();
      nieuweDatumVeld.setBounds(new Rectangle(104, 38, 111, 17));
    }
    return nieuweDatumVeld;
  }

  /**
   * This method initializes simulatieButton  
   *  
   * @return javax.swing.JButton  
   */
  private JButton getSimulatieButton() {
    if (simulatieKnop == null) {
      simulatieKnop = new JButton();
      simulatieKnop.setBounds(new Rectangle(7, 70, 91, 26));
      simulatieKnop.setText("Zet datum");
      simulatieKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          simulatieButtonAction();
        }
      });
    }
    return simulatieKnop;
  }

  /**
   * Main methode.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        BankFrame gui = new BankFrame();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
      }
    });
    
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
