public class Rest extends State
{
	int duration;
	
	public Rest()
	{
		nameOfState = "Rest";
	}
	public Rest(int duration)
	{
		this();
		this.duration = duration;
	}
	
	@Override
	public void step(Entity e)
	{
		if (duration<=0)
			isOver = true;
		else 
			duration--;
	}
	
}