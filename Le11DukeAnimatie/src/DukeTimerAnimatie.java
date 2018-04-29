import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Beweegt een plaatje met behulp van een timer.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class DukeTimerAnimatie extends JFrame {
  private static final int STARTPOSITIE = 20;
  private static final int EINDPOSITIE = 400;
  private static final int DELTAPOSITIE = 2;
  private JLabel dukeLabel = null;
  private JButton loopKnop = null;
  private Timer timer = null;
  private int x = STARTPOSITIE; // x-coordinaat van het label

  public DukeTimerAnimatie() {
    super();
    initialize();
  }
  
  /**
   * Bouwt de GUI op
   */
  private void initialize() {
    // Zet titel, afmeting, achtergrondkleur en geef
    // de contentPane layout null
    setTitle("Duke animatie (Timer)");
    setSize(500, 300);
    Container pane = getContentPane();
    pane.setLayout(null);
    pane.setBackground(Color.YELLOW);
    
    // Voeg een label toe met een plaatje
    dukeLabel = new JLabel();
    dukeLabel.setBounds(20, 40, 65, 80);
    dukeLabel.setIcon(new ImageIcon("images" + File.separator + "duke.gif"));
    pane.add(dukeLabel);  
    
    // Voeg een knop toe die naar ActionEvents luistert
    loopKnop = new JButton("Loop!");
    loopKnop.setBackground(Color.ORANGE);
    loopKnop.setBounds(210, 150, 80, 25);
    loopKnop.addActionListener(new LoopLuisteraar());
    pane.add(loopKnop);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        DukeTimerAnimatie gui = new DukeTimerAnimatie();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    });
  }


  /**
   * Luisteraar voor ActionEvents.
   * Bij het indrukken van de knop wordt een timer 
   * gecreeerd met een delay van 1 en een nieuwe
   * TimerLuisteraar
   */
  public class LoopLuisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      x = STARTPOSITIE;
      timer = new Timer(10, new TimerLuisteraar());
      timer.start();
    }
  }
  
  /**
   * De event handler ind e TimerLuisteraar verplaatst 
   * het plaatje steeds een stap

   */
  public class TimerLuisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (x < EINDPOSITIE) {
        x = x + DELTAPOSITIE;
        dukeLabel.setLocation(x, 40);
      } else {
        timer.stop();
      }
    }
  }
}
