public class ZigZag extends State
{
	Vector2D velocity;
	int duration;
	
	public ZigZag(Vector2D velocity, int duration)
	{
		this();
		this.velocity = velocity;
		this.duration = duration;
	}
	
	public ZigZag()
	{
		nameOfState = "ZigZag";
	}
	
	@Override
	public void step(Entity e)
	{
		if (duration > 0)
		{
			e.position = e.position.plus(velocity);
			
			if (e.position.x>= 1060 || e.position.x <= 0)
			{
				velocity.x = 0 - velocity.x;
			}
			
			if (e.position.y > 560 || e.position.y <= 0)
			{
				velocity.y = 0 - velocity.y;
			}
			duration--;
		}
		else 
		{
			isOver = true;
		}
	}
}