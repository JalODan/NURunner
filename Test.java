import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.FontMetrics;
import javax.swing.*;
import java.awt.event.*;
 
public class Test {
 
  public static void main(String[] args) 
	{
		
		Vector2D position = new Vector2D(0,0);
		Vector2D destination = new Vector2D(10,0);
		System.out.println(position.distanceTo(destination));
		System.out.println(destination.distanceTo(position));
	}
}