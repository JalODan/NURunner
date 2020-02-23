import javax.swing.*;
import java.awt.*;


public class NURunner
{
		
	public static void main(String[] args)
	{
		new Window();
	}
}

class Window extends JFrame
{
	Window()
	{
		
		Display display = new Display();
		add(display);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NUGraduation");
		setVisible(true);
		pack();
		setResizable(false);
			
		
		
	}
}