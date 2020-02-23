import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.FontMetrics;

public class Lab extends Assessment
{
	public double side = 20;
	
	public Lab(Vector2D position, int points)
	{
		this.position = new Vector2D(position);
		this.points = points;
	}
	
	
	@Override
	public void draw(Graphics2D g2d)
	{
		
		Rectangle2D lab = new Rectangle2D.Double(position.x, position.y, side, side);
		g2d.setPaint(Color.GREEN);
		g2d.fill(lab);
		
		g2d.setPaint(Color.BLACK);
		FontMetrics fm = g2d.getFontMetrics();
		double textWidth = fm.getStringBounds(Integer.toString(points), g2d).getWidth();
		double textHeight = fm.getStringBounds(Integer.toString(points), g2d).getHeight();
		g2d.drawString(Integer.toString(points), (int)(position.x+(side/2-textWidth/2)), (int)(position.y+side/2+textHeight/2));
		
	}
	
	@Override
	public void step(){}
}