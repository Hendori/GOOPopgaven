package bibliotheekgui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import bibliotheek.Bibliotheek;
import bibliotheek.Boek;
import bibliotheekdata.BibliotheekException;
import bibliotheekdata.DBConst;

/**
 * Gebruikersinterface voor de bibliotheek
 * @author Medewerker OUNL
 *
 */
public class BibliotheekFrame extends JFrame {

  private Bibliotheek bibliotheek = new Bibliotheek();  //  @jve:decl-index=0:
  String url = DBConst.URL;
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel titelLabel = null;
  private JLabel auteurLabel = null;
  private JTextField titelVeld = null;
  private JTextField auteurVeld = null;
  private JButton voegtoeKnop = null;
  private JButton toonAuteurKnop = null;
  private JScrollPane jScrollPane = null;
  private JButton toonTitelsKnop = null;
  private JList<String> titelLijst = null;
  
  /**
   * This is the default constructor
   */
  public BibliotheekFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /*
   * Vraagt de bibliotheek het boekenbestand in te lezen
   */
  private void mijnInit() {
    try {
      bibliotheek.open(url);
    }
    catch (BibliotheekException e) {
      JOptionPane.showMessageDialog(this,
          e.getMessage(),
          "BibliotheekException", 
          JOptionPane.ERROR_MESSAGE); 
      e.printStackTrace();
      System.exit(0);
    }
  }
  
  /**
   * Haalt de titels uit de bibliotheek op en toont ze in een lijst. 
   * Gebruik van een JList komt aan de orde in leereenheid 12/13
   */
  private void toonTitelsKnopAction() {
    DefaultListModel<String> model = (DefaultListModel<String>)titelLijst.getModel();
    model.removeAllElements();
    model.addElement("titels: ");
    ArrayList<Boek> boeken = bibliotheek.getBoekenlijst();
    for (Boek boek: boeken) {
      model.addElement(boek.getTitel());
    }   
  }

  /**
   * Vraagt de bibliotheek een boek met de gegeven titel en
   * auteur toe te voegen
   */
  private void voegToeKnopAction() {
    try {
      bibliotheek.voegBoekToe(titelVeld.getText(), auteurVeld.getText());
    }
    catch (BibliotheekException e) {
      JOptionPane.showMessageDialog(this, e.getMessage(), "BibliotheekException", JOptionPane.ERROR_MESSAGE);
      if (bibliotheek != null){
        bibliotheek.sluitAf();         
      }
      System.exit(0);
    }
    titelVeld.setText("");
    auteurVeld.setText("");
  }
  
  /**
   * Toont de auteur van de geselecteerde titel
   */
  private void toonAuteurKnopAction() {
    String titel = (String)titelLijst.getSelectedValue();
    if (titel != null) {
      titelVeld.setText(titel);
      String auteur = bibliotheek.geefAuteur(titelVeld.getText());
      if (auteur == null) {
        auteurVeld.setText("Titel niet gevonden");
      } else {
        auteurVeld.setText(auteur);
      }
    }
  }
  
  /*
   * Slaat het bestand op en sluit af.
   */
  private void closeWindow() {
    
      bibliotheek.sluitAf();
    
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(412, 322);
    this.setContentPane(getJContentPane());
    this.setTitle("Mijn bibliotheek");
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        closeWindow();
      }
    });
  }

  /**
   * This method initializes titelVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTitelVeld() {
    if (titelVeld == null) {
      titelVeld = new JTextField();
      titelVeld.setBounds(new Rectangle(119, 6, 242, 27));
    }
    return titelVeld;
  }

  /**
   * This method initializes auteurVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getAuteurVeld() {
    if (auteurVeld == null) {
      auteurVeld = new JTextField();
      auteurVeld.setBounds(new Rectangle(119, 35, 242, 25));
    }
    return auteurVeld;
  }

  /**
   * This method initializes voegtoeKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getVoegtoeKnop() {
    if (voegtoeKnop == null) {
      voegtoeKnop = new JButton();
      voegtoeKnop.setBounds(new Rectangle(14, 80, 113, 26));
      voegtoeKnop.setText("voeg boek toe");
      voegtoeKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          voegToeKnopAction();
        }
      });
    }
    return voegtoeKnop;
  }

  /**
   * This method initializes toonAuteurKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getToonAuteurKnop() {
    if (toonAuteurKnop == null) {
      toonAuteurKnop = new JButton();
      toonAuteurKnop.setBounds(new Rectangle(141, 79, 99, 26));
      toonAuteurKnop.setText("toon auteur");
      toonAuteurKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          toonAuteurKnopAction();
        }
      });
    }
    return toonAuteurKnop;
  }

  /**
   * This method initializes jScrollPane	
   * 	
   * @return javax.swing.JScrollPane	
   */
  private JScrollPane getJScrollPane() {
    if (jScrollPane == null) {
      jScrollPane = new JScrollPane();
      jScrollPane.setPreferredSize(new Dimension(259, 50));
      jScrollPane.setLocation(new Point(13, 116));
      jScrollPane.setSize(new Dimension(259, 162));
      jScrollPane.setViewportView(getTitelLijst());
    }
    return jScrollPane;
  }

  /**
   * This method initializes toonTitelsKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getToonTitelsKnop() {
    if (toonTitelsKnop == null) {
      toonTitelsKnop = new JButton();
      toonTitelsKnop.setBounds(new Rectangle(254, 80, 93, 26));
      toonTitelsKnop.setText("toon titels");
      toonTitelsKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          toonTitelsKnopAction();
        }	
      });
    }
    return toonTitelsKnop;
  }

  /**
   * This method initializes titelLijst	
   * 	
   * @return javax.swing.JList	
   */
  private JList<String> getTitelLijst() {
    if (titelLijst == null) {
      titelLijst = new JList<>();
      titelLijst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      titelLijst.setSize(new Dimension(259, 162));
      titelLijst.setModel(new DefaultListModel<>());
    }
    return titelLijst;
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      auteurLabel = new JLabel();
      auteurLabel.setBounds(new Rectangle(13, 39, 85, 20));
      auteurLabel.setText("auteur");
      titelLabel = new JLabel();
      titelLabel.setBounds(new Rectangle(13, 18, 74, 15));
      titelLabel.setText("titel");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(titelLabel, null);
      jContentPane.add(auteurLabel, null);
      jContentPane.add(getTitelVeld(), null);
      jContentPane.add(getAuteurVeld(), null);
      jContentPane.add(getVoegtoeKnop(), null);
      jContentPane.add(getToonAuteurKnop(), null);
      jContentPane.add(getJScrollPane(), null);
      jContentPane.add(getToonTitelsKnop(), null);
    }
    return jContentPane;
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
