import java.io.*;
import javax.imageio.*;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.*;


public class Academician extends Entity
{
	Image img = null;
	
	Academician()
	{
		position = new Vector2D(1060*Math.random(), 540*Math.random());
		state = new State();
		state = state.pickRandomState(3);
	}
	
	Academician(String name)
	{
		this();
		this.name = name;
	}
	
	public Assessment createAssessment()
	{
		AssessmentFactory factory = new AssessmentFactory();
		
		Vector2D around = new Vector2D(100*Math.random(), 100*Math.random());
		return factory.createAssessment(around.plus(this.position));
	}
	
	
	@Override
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(img, (int)position.x, (int)position.y, 40, 60,  null);
		g2d.setPaint(Color.BLACK);
		FontMetrics fm = g2d.getFontMetrics();
		double textWidth = fm.getStringBounds(name, g2d).getWidth();
		double textHeight = fm.getStringBounds(name, g2d).getHeight();
		g2d.drawString(name, (int)(position.x+(15-textWidth/2)), (int)(position.y));
		
		textWidth = fm.getStringBounds(state.nameOfState, g2d).getWidth();
		g2d.drawString(state.nameOfState, (int)(position.x+(15-textWidth/2)), (int)(position.y+60+textHeight));
	}
	
	@Override
	public void step()
	{
		if (state.isOver)
			state = state.pickRandomState(3);
		else 	
			state.step(this);
	}
}