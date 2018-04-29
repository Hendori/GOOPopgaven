import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Beweegt een plaatje met behulp van een thread.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class DukeThreadAnimatie extends JFrame implements Runnable {

  private static final int STARTPOSITIE = 20;
  private static final int EINDPOSITIE = 400;
  private static final int DELTAPOSITIE = 2;
  private JLabel dukeLabel = new JLabel();
  private JButton loopKnop = new JButton();
  private int x = STARTPOSITIE;   // x-coordinaat van het label
  
  public DukeThreadAnimatie() {
    super();
    initialize();
  }
  
  /**
   * Bouwt de GUI op
   */
  private void initialize() {
    // Zet titel, afmeting, achtergrondkleur en geef
    // de contentPane layout null
    setTitle("Duke animatie (thread)");
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

  /**
   * Verplaatst het plaatje stap voor stap van de 
   * startpositie naar de eindpositie
   */
  public void run() {
    x = STARTPOSITIE;
    while(x < EINDPOSITIE) {
      x = x + DELTAPOSITIE;
      dukeLabel.setLocation(x, 40);
      try {Thread.sleep(10);} catch(InterruptedException ex){}
    }
  }
  
  public static void main(String[] args) {
    DukeThreadAnimatie gui = new DukeThreadAnimatie();
    gui.setVisible(true);
    gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


  /**
   * Luisteraar voor ActionEvents.
   * De event handler start een nieuwe thread met als target
   * de huidige instantie van ThreadAnimatie.
   */
  public class LoopLuisteraar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Thread thread = new Thread(DukeThreadAnimatie.this, "Duke");
      thread.start();
    }
  }
}
