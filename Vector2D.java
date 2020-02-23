public class Vector2D
{
	public double x;
	public double y;
	
	Vector2D()
	{
		x=0; y=0;
	}
	Vector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	Vector2D(Vector2D other)
	{
		x = other.x;
		y = other.y;
	}
	
	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Vector2D other)
	{
		double dx = x - other.x;
		double dy = y - other.y;
		return Math.sqrt(dx*dx+dy*dy) ;
	}
	
	public void normalize()
	{
		double length = Math.sqrt(x*x+y*y);
		x = x / length;
		y = y / length;
	}
	
	public Vector2D plus(Vector2D other)
	{
		Vector2D res = new Vector2D(this.x + other.x, this.y + other.y);
		return res;
	}
	
	public Vector2D minus(Vector2D other)
	{
		Vector2D res = new Vector2D(this.x - other.x, this.y - other.y);
		return res;
	}
}