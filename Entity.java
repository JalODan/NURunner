import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public abstract class Entity
{
	public String name;
	public Vector2D position;
	public State state;
	public Common common;
	
	public abstract void draw(Graphics2D g2d);
	public abstract void step();
	
}

