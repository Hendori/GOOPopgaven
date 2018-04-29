import javax.swing.JFrame;

/**
 * Illustreert het gebruik van tabbladen.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class Tabbladen extends JFrame {
  
  // Array met drie bestandsnamen van plaatjes
  //private String[] keuzes = {"duke.gif", "rotsen.gif", "mandjes.gif"};

  public Tabbladen() {
    super();
    initialize();
  }

  /**
   * Initialize zet nu alleen een titel.
   * De bedoeling is drie tabbladen toe te voegen waarop
   * de drie plaatjes getoond worden.
   */
  private void initialize() {
    setSize(290, 240);
    setTitle("Tabbladen");
    //Container pane = getContentPane();   
  }
  
  public static void main(String[] arg) {
    Tabbladen frame = new Tabbladen();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
}
