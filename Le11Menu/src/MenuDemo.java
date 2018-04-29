import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

/**
 * Voorbeeld van de opbouw van een menustuctuur.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class MenuDemo extends JFrame {

  public MenuDemo() {
    super();
    initialize();
  }
  
  /**
   * Maakt een menubalk met twee menu's. Het eerste menu bevat
   * twee gewone items, twee radiobuttons (in een groep), een 
   * checkbox-item en een submenu met twee keuzes.
   */
  private void initialize() {
    setSize(400, 300);
    setTitle("Menus");
    getContentPane().setBackground(Color.WHITE);
    
    // maak de menubalk
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    // maak de menus
    JMenu menu1 = new JMenu("Menu1");
    menuBar.add(menu1);
    JMenu menu2 = new JMenu("Menu2");
    menuBar.add(menu2);

    // voeg twee menu-items toe    
    JMenuItem menuItem1 = new JMenuItem("Item 1");
    menu1.add(menuItem1);
    JMenuItem menuItem2 = new JMenuItem("Item 2");
    menu1.add(menuItem2);

    // maak een groep radiobutton menu-items
    menu1.addSeparator();
    JRadioButtonMenuItem rbMenuItem1 =
                     new JRadioButtonMenuItem("Kies deze");
    menu1.add(rbMenuItem1);
    JRadioButtonMenuItem rbMenuItem2 =
                     new JRadioButtonMenuItem("Of deze");
    menu1.add(rbMenuItem2);
    ButtonGroup groep = new ButtonGroup();
    groep.add(rbMenuItem1);
    groep.add(rbMenuItem2);

    // voeg checkbox menu-item toe
    menu1.addSeparator();
    JCheckBoxMenuItem cbMenuItem =
                     new JCheckBoxMenuItem("Aan of uit");
    menu1.add(cbMenuItem);

    // voeg een separator en een submenu toe
    menu1.addSeparator();
    JMenu submenu = new JMenu("Submenu");
    menu1.add(submenu);
    JMenuItem subMenuItem1 = new JMenuItem("Subkeuze 1");
    submenu.add(subMenuItem1);
    JMenuItem subMenuItem2 = new JMenuItem("Subkeuze 2");
    submenu.add(subMenuItem2);
    
  }
  
  public static void main(String[] arg) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        MenuDemo gui = new MenuDemo();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }
}
