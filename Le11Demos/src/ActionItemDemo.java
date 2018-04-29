import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Demo-klasse die laat zien wanneer ActionEvents en ItemEvents
 * optreden en wat het verschil ertussen is
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class ActionItemDemo extends JFrame {

  private JTextArea tekstGebied = null;
  
  public ActionItemDemo() {
    super();
    initialize();
  }
  
  private void initialize() {
    setTitle("ActionEvent en ItemEvent");
    setSize(500, 400);
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    
    // Maak panel met tekstgebied; dit panel neemt het
    // grootste deel van de GUI in beslag
    JScrollPane scrollPane = new JScrollPane();
    pane.add(scrollPane, BorderLayout.CENTER);
    tekstGebied = new JTextArea();
    tekstGebied.setEditable(false);
    scrollPane.getViewport().add(tekstGebied);

    // Maak twee luisteraars voor respectievelijk
    // ActionEvents en ItemEvents
    ActionLuisteraar actionLuisteraar = new ActionLuisteraar();
    ItemLuisteraar itemLuisteraar = new ItemLuisteraar();
    
    // Plaats een panel bovenaan de GUI; alle andere
    // componenten worden daar aan toegevoegd.
    // De panel heeft een GridLayout 
    JPanel commandoPanel = new JPanel();
    pane.add(commandoPanel, BorderLayout.NORTH);
    commandoPanel.setLayout(new GridLayout(1,5, 10, 4));

    // Voeg een knop toe die reageert op ActionEvents
    // en ItemEvents
    JButton knop = new JButton("knop");
    knop.addActionListener(actionLuisteraar);
    knop.addItemListener(itemLuisteraar);
    commandoPanel.add(knop);
    
    // Voeg een tekstveld toe dat reageert op 
    // ActionEvents (Enter hit)
    JTextField tekst = new JTextField("tekst");
    tekst.addActionListener(actionLuisteraar);
    commandoPanel.add(tekst);
    
    // Voeg een keuzelijst toe met drie keuzen
    // die reageert op ActionEvents en ItemEvents
    JComboBox<String> combo = new JComboBox<>();
    combo.addActionListener(actionLuisteraar);
    combo.addItemListener(itemLuisteraar);
    commandoPanel.add(combo);
    combo.addItem("rood");
    combo.addItem("wit");
    combo.addItem("blauw");

    // Voeg twee checboxes toe op een apart
    // panel, die beide reageren op ActionEvents
    // en ItemEvents. Het panel krijgt een GrisLayout
    // om de checkboxes onder elkaar te krijgen.
    JPanel checkPanel = new JPanel();
    checkPanel.setLayout(new GridLayout(0,1));
    commandoPanel.add(checkPanel);
    JCheckBox check = new JCheckBox("check 1");
    check.addActionListener(actionLuisteraar);
    check.addItemListener(itemLuisteraar);
    checkPanel.add(check);
    check = new JCheckBox("check 2");
    check.addActionListener(actionLuisteraar);
    check.addItemListener(itemLuisteraar);
    checkPanel.add(check);

    // Voeg twee radiobuttons toe (in een groep) op een apart
    // panel, die beide reageren op ActionEvents
    // en ItemEvents. Het panel krijgt een GridLayout
    // om de checkboxes onder elkaar te krijgen.
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(0,1));
    commandoPanel.add(radioPanel);    
    JRadioButton radio1 = new JRadioButton("radio 1");
    radio1.addActionListener(actionLuisteraar);
    radio1.addItemListener(itemLuisteraar);
    radioPanel.add(radio1);
    JRadioButton radio2 = new JRadioButton("radio 2");
    radio2.addActionListener(actionLuisteraar);
    radio2.addItemListener(itemLuisteraar);
    radioPanel.add(radio2);
    ButtonGroup groep = new ButtonGroup();
    groep.add(radio1);
    groep.add(radio2);
    radio1.setSelected(true);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ActionItemDemo gui = new ActionItemDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }

  /**
   * Luisteraarklasse voor ActionEvents
   */
  public class ActionLuisteraar implements ActionListener {
    // attribuut teller telt het aantal ActionEvents
    private int teller = 0;
    
    /**
     * Verhoogt de teller en schrijft een bericht naar
     * het tekstgebied
     */
    public void actionPerformed(ActionEvent e) {
      teller++;
      tekstGebied.append("actionPerformed " + teller + ": " +
                          e.getSource().getClass() + "\n");
      System.out.println("actionPerformed " + teller + ": " + 
                         e.getSource().getClass());
    }
  }
  
  /**
   * Luisteraarklasse voor ItemEvents
   */
  public class ItemLuisteraar implements ItemListener {
    // attribuut teller telt het aantal ItemEvents
    private int teller = 0;
    
    /**
     * Verhoogt de teller en schrijft een bericht naar
     * het tekstgebied
     */
    public void itemStateChanged(ItemEvent e) {
      teller++;
      tekstGebied.append("itemStateChanged " + teller + ": " + 
                         e.getSource().getClass() + "\n");
      System.out.println("itemStateChanged " + teller + ": " + 
                         e.getSource().getClass());
    }
  }

}
