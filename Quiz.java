import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.FontMetrics;

public class Quiz extends Assessment
{
	public double rad = 25;
	public Quiz(Vector2D position, int points)
	{
		this.position = new Vector2D(position);
		this.points = points;
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{
		
		Ellipse2D quiz = new Ellipse2D.Double(position.x, position.y, rad, rad);
		g2d.setPaint(Color.BLUE);
		g2d.fill(quiz);
		
		g2d.setPaint(Color.BLACK);
		FontMetrics fm = g2d.getFontMetrics();
		double textWidth = fm.getStringBounds(Integer.toString(points), g2d).getWidth();
		double textHeight = fm.getStringBounds(Integer.toString(points), g2d).getHeight();
		g2d.drawString(Integer.toString(points), (int)(position.x+(rad/2-textWidth/2)), (int)(position.y+rad/2+textHeight/2));
		
	}
	
	@Override
	public void step(){}
}