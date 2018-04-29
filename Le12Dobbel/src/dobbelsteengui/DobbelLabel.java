package dobbelsteengui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import dobbelsteen.Dobbelsteen;

/**
 * Een label dat tevens Observer is en een dobbelsteen observeert.
 */
@SuppressWarnings("serial")
public class DobbelLabel extends JLabel implements Observer {

  /**
   * Haalt het aantal ogen van de dobbelsteen op,
   * en maak dat zichtbaar (als tekst)
   */
  public void update(Observable o, Object arg) {
    Dobbelsteen dobbelsteen =
        	       (Dobbelsteen) o;
    setText(dobbelsteen.getOgen() + "");
  }
}