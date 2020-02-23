import java.io.*;
import javax.imageio.*;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.*;

public class Speaker extends Entity
{
	Image img = null;
	
	Speaker(String name)
	{
		this.name = name;
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
	}
	
	@Override
	public void step(){}
}