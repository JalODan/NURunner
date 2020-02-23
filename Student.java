import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.FontMetrics;
import javax.swing.*;
import java.awt.event.*;

public class Student extends Entity
{
	public int grade;
	public double rad = 30;
	
	Student()
	{
		grade = 0;
		position = new Vector2D(1070*Math.random(), 570*Math.random());
		state = new State();
		state = state.pickRandomState(3);
	}
	
	Student(String name)
	{
		this();
		this.name = name;
	}
	
	Student(Student other)
	{
		this.grade = grade;
		this.position = new Vector2D(other.position);
		this.name = name;
	}
	
	public void setCommon()
	{
		common = Common.getSingleCommon();
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{
		
		Ellipse2D student = new Ellipse2D.Double(position.x, position.y, rad, rad);
		g2d.setPaint(Color.CYAN);
		if (grade >= 100)
			g2d.setPaint(Color.MAGENTA);
		g2d.fill(student);
		
		g2d.setPaint(Color.BLACK);
		FontMetrics fm = g2d.getFontMetrics();
		double textWidth = fm.getStringBounds(Integer.toString(grade), g2d).getWidth();
		double textHeight = fm.getStringBounds(Integer.toString(grade), g2d).getHeight();
		g2d.drawString(Integer.toString(grade), (int)(position.x+(rad/2-textWidth/2)), (int)(position.y+rad/2+textHeight/2));
		
		textWidth = fm.getStringBounds(name, g2d).getWidth();
		g2d.drawString(name, (int)(position.x+(rad/2-textWidth/2)), (int)(position.y));
		
		textWidth = fm.getStringBounds(state.nameOfState, g2d).getWidth();
		g2d.drawString(state.nameOfState, (int)(position.x+(rad/2-textWidth/2)), (int)(position.y+rad+textHeight));
		
	}
	
	@Override
	public void step()
	{
		if (!state.isOver)
			state.step(this);
		else
		{
			if (this.common.assessments.size()!=0)
				state = state.pickRandomState(4);
			else 
				state = state.pickRandomState(3);
		}
		
		if (grade >= 100)
		{
			state = new GotoXY(common.stella, 7*Math.random());
			if (position.distanceTo(common.stella) <= 25)
				state = new Stationary();
		}
	}
}