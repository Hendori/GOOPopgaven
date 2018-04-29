package calulatorgui;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import calculator.IntCalculator;
import calculator.OperatorEnum;

/**
 * Klasse waarmee eenvoudige berekeningen met integers kunnen worden uitgevoerd.
 * Na klikken op een OperatorEnum-knop wordt de vorige OperatorEnum toegepast op het
 * cumulatief resultaat en het nieuwe getal. Het nieuwe cumulatief resultaat
 * wordt getoond. Ook na klikken op de =-knop wordt de vorige OperatorEnum toegepast
 * op het cumulatief resultaat en het nieuwe getal.en wordt nieuwe cumulatief
 * resultaat wordt getoond. De calculator wordt dan gereset.
 * 
 * @author Open Universiteit Nederland
 * 
 */
public class CalculatorFrame extends JFrame {

  private IntCalculator calc = new IntCalculator(); // @jve:decl-index=0:

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JTextField invoerVeld = null;
  private JButton somKnop = null;
  private JButton verschilKnop = null;
  private JButton productKnop = null;
  private JButton quotientKnop = null;
  private JButton isKnop = null;
  private JTextField resultaatVeld = null;

  /**
   * This is the default constructor
   */
  public CalculatorFrame() {
    super();
    initialize();
    invoerVeld.requestFocusInWindow();
  }

  /**
   * Leest geheel getal uit invoerVeld 
   * @return getal in invoerVeld
   */
  private int leesInvoer() {
    return Integer.parseInt(invoerVeld.getText());
  }
    

  /**
   * Toont gegeven getal in resultaatVeld 
   * @param res  het gegeven getal
   */
  private void toonUitvoer(int res) {
    resultaatVeld.setText("" + res);
    resetInvoerVeld();
  }

  /**
   * reset invoerVeld
   */
  private void resetInvoerVeld() {
    invoerVeld.setText("");
    invoerVeld.requestFocusInWindow();
  }

  /**
   * Event handler voor somKnop: Past de vorige OperatorEnum 
   * toe op het cumulatief resultaat en het ingevoerde
   * getal. De volgende OperatorEnum die gebruikt wordt is +
   */
  private void somKnopAction() {
      int operand = leesInvoer();
      int res = calc.bereken(operand, OperatorEnum.SOM);
      toonUitvoer(res);
      resetInvoerVeld();
  }

  /**
   * Event handler voor verschilKnop: Past de vorige OperatorEnum 
   * toe op het cumulatief resultaat en het ingevoerde
   * getal. De volgende OperatorEnum die gebruikt wordt is -
   */
  private void verschilKnopAction() {
    int operand = leesInvoer();
    int res = calc.bereken(operand, OperatorEnum.VERSCHIL);
    toonUitvoer(res);
    resetInvoerVeld();
  }

  /**
   * Event handler voor productKnop: Past de vorige OperatorEnum 
   * toe op het cumulatief resultaat en het ingevoerde
   * getal. De volgende OperatorEnum die gebruikt wordt is *
   */
  private void productKnopAction() {
    int operand = leesInvoer();
    int res = calc.bereken(operand, OperatorEnum.PRODUCT);
    toonUitvoer(res);
    resetInvoerVeld();
  }
 
  /**
   * Event handler voor quotientKnop: Past de vorige OperatorEnum 
   * toe op het cumulatief resultaat en het ingevoerde
   * getal. De volgende OperatorEnum die gebruikt wordt is /
   */
  //private void quotientKnopAction() {
  //  int operand = leesInvoer();
  //  int res = calc.bereken(operand, OperatorEnum.QUOTIENT);
  //  toonUitvoer(res);
  //  resetInvoerVeld();
  //}
  private void quotientKnopAction() throws ArithmeticException{
    int res = 0;
    try {
      int operand = leesInvoer();
      res = calc.bereken(operand, OperatorEnum.QUOTIENT);
      toonUitvoer(res);
    }
    catch (ArithmeticException arithmeticEx) {
      System.out.println("Delen door 0 kan niet.");
    }
    resetInvoerVeld();
    
  }  

  
  
  

  /**
   * Event handler voor isKnop: Past de vorige OperatorEnum 
   * toe op het cumulatief resultaat en het ingevoerde
   * getal. De calculator wordt daarna gereset.
   */
  private void isKnopAction() {
    int operand = leesInvoer();
    int res = calc.getEindResultaat(operand);
    toonUitvoer(res);
    resetInvoerVeld();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(311, 200);
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
      jContentPane.add(getInvoerVeld(), null);
      jContentPane.add(getSomKnop(), null);
      jContentPane.add(getVerschilKnop(), null);
      jContentPane.add(getProductKnop(), null);
      jContentPane.add(getQuotientKnop(), null);
      jContentPane.add(getIsKnop(), null);
      jContentPane.add(getResultaatVeld(), null);

    }
    return jContentPane;
  }

  /**
   * This method initializes invoerVeld
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getInvoerVeld() {
    if (invoerVeld == null) {
      invoerVeld = new JTextField();
      invoerVeld.setBounds(new Rectangle(15, 18, 270, 25));
    }
    return invoerVeld;
  }

  /**
   * This method initializes somKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getSomKnop() {
    if (somKnop == null) {
      somKnop = new JButton();
      somKnop.setBounds(new Rectangle(11, 53, 45, 22));
      somKnop.setText("+");
      somKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          somKnopAction();
        }
      });
    }
    return somKnop;
  }

  /**
   * This method initializes verschilKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getVerschilKnop() {
    if (verschilKnop == null) {
      verschilKnop = new JButton();
      verschilKnop.setBounds(new Rectangle(67, 53, 45, 22));
      verschilKnop.setText("-");
      verschilKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          verschilKnopAction();
        }
      });
    }
    return verschilKnop;
  }

  /**
   * This method initializes productKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getProductKnop() {
    if (productKnop == null) {
      productKnop = new JButton();
      productKnop.setBounds(new Rectangle(123, 53, 45, 22));
      productKnop.setText("*");
      productKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          productKnopAction();
        }
      });
    }
    return productKnop;
  }

  /**
   * This method initializes quotientKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getQuotientKnop() {
    if (quotientKnop == null) {
      quotientKnop = new JButton();
      quotientKnop.setBounds(new Rectangle(179, 53, 45, 22));
      quotientKnop.setText("/");
      quotientKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          quotientKnopAction();
        }
      });
    }
    return quotientKnop;
  }

  /**
   * This method initializes isKnop
   * 
   * @return javax.swing.JButton
   */
  private JButton getIsKnop() {
    if (isKnop == null) {
      isKnop = new JButton();
      isKnop.setBounds(new Rectangle(235, 53, 45, 22));
      isKnop.setText("=");
      isKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          isKnopAction();
        }
      });
    }
    return isKnop;
  }

  /**
   * This method initializes resultaatVeld
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getResultaatVeld() {
    if (resultaatVeld == null) {
      resultaatVeld = new JTextField();
      resultaatVeld.setBounds(new Rectangle(15, 92, 270, 25));
      resultaatVeld.setEditable(false);
    }
    return resultaatVeld;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        CalculatorFrame gui = new CalculatorFrame();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

} // @jve:decl-index=0:visual-constraint="10,10"
