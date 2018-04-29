package klokgui;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import klok.Klok;
import java.util.*;

/**
 * Representeert een panel met een grafische klok.
 * @author Open Universiteit Nederland
 */
@SuppressWarnings("serial")
public class KlokPanel extends JPanel {
  
  private Klok klok = null;  //  @jve:decl-index=0:
  private static final int AFMETING = 200;
  private static final int STRAAL = 80;
  private static final int STREEP1 = 10;
  private static final int STREEP5 = 15;
  private static final double SECONDENWIJZER = 0.9;
  private static final double MINUTENWIJZER = 0.75;
  private static final double URENWIJZER = 0.6;
  
  public KlokPanel() {
    super();
    initialize();
  }

  public void setKlok(Klok klok) {
    this.klok = klok;
  }
  
  private void initialize() {
    setSize(AFMETING, AFMETING);
    setBackground(Color.BLUE);
  }
  
  /**
   * Tekent een klok met streepjes voor de minuten 
   * (elk vijfde streepje is wat langer) en drie wijzers
   * voor uren, minuten en seconden.
   */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    
    // teken met zo hoog mogelijk kwaliteit
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);   

    // transformatie naar centrum
    g2d.translate(AFMETING / 2, AFMETING / 2);
    // bewaar deze transformatie
    AffineTransform center = g2d.getTransform();
    
    // maak wijzerplaat
    Ellipse2D.Double cirkel = new Ellipse2D.Double(-STRAAL, -STRAAL, 2 * STRAAL, 2 * STRAAL);
    g2d.setColor(Color.ORANGE);
    g2d.fill(cirkel);
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(8.0f));
    g2d.draw(cirkel);
    
    // maak minutenaanduiding op rand; iedere 5 minuten wat groter
    g2d.setStroke(new BasicStroke(1.0f));
    Line2D.Double streep1 = new Line2D.Double(0, -STRAAL + STREEP1, 0, -STRAAL);
    Line2D.Double streep5 = new Line2D.Double(0, -STRAAL + STREEP5, 0, -STRAAL);
    
    for (int i = 0; i < 60; i++) {
      if (i % 5 == 0) {
        g2d.draw(streep5);
      } else {
        g2d.draw(streep1);
      }
      g2d.rotate(Math.PI / 30);
    }
    
    // de wijzers; deze halen hun informatie uit de klok
    int seconden = klok.getTijd().get(Calendar.SECOND);
    int minuten = klok.getTijd().get(Calendar.MINUTE);
    int uren = klok.getTijd().get(Calendar.HOUR) % 12;
    Line2D.Double wijzer = new Line2D.Double(0, 0, 0, -STRAAL);
    // secondenwijzer
    g2d.setTransform(center);
    g2d.rotate(Math.PI * seconden / 30);
    g2d.scale(1.0, SECONDENWIJZER);
    g2d.draw(wijzer);
    // minutenwijzer
    g2d.setStroke(new BasicStroke(3.0f));
    g2d.setTransform(center);
    g2d.rotate(Math.PI * minuten / 30);
    g2d.scale(1.0, MINUTENWIJZER);
    g2d.draw(wijzer);
    // urenwijzer
    g2d.setTransform(center);
    g2d.rotate(Math.PI * (uren + minuten / 60.0) / 6);
    g2d.scale(1.0, URENWIJZER);
    g2d.draw(wijzer);
  }
}
