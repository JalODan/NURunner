import java.io.*;
import javax.imageio.*;
import java.awt.Graphics2D;
import java.awt.*;

public class UniversityMap extends Entity
{
	Image img = null;
	

	UniversityMap()
	{
		try
		{
			img = ImageIO.read(new File("../Demo/NUMap-Faded.jpg"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(img, 0, 0, 1100, 600 , null);
	}
	
	@Override
	public void step(){};
	
}