import java.awt.Graphics2D;

public class Assessment extends Entity
{
	public int points;
	
	public Assessment(){}
	
	@Override 
	public void step(){}
	
	@Override 
	public void draw(Graphics2D g2d){}
	
	public Assessment(Assessment other)
	{
		points = other.points;
		position = other.position;
		
	}
}