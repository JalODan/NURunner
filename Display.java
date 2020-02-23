
import javax.swing.*       ; 
import java.awt.Color      ; 
import java.awt.Graphics   ; 
import java.awt.Dimension  ; 
import java.awt.Graphics2D ; 

public class BallPanel extends JPanel
{
  public Display()
  {
    setBackground( Color.BLACK ) ;
  }

  @Override public Dimension getPreferredSize ()
  {
    return new Dimension( 400 , 300 ) ;
  }

  @Override public void paintComponent ( Graphics g )
  {
    super.paintComponent( g ) ;

    Graphics2D g2d = (Graphics2D) g ;
  }