public class Closest extends State
{
	double speedFactor;
	int duration;
	
	public Closest(double speedFactor, int duration)
	{
		this.speedFactor  = speedFactor;
		this.duration = duration;
		nameOfState = "Closest";
	}
	
	@Override 
	public void step(Entity e)
	{
		if (duration > 0)
		{
			Assessment closest = new Assessment();
			closest = e.common.findClosest(e);
			GotoXY go = new GotoXY(closest.position, speedFactor);
			go.step(e);
			duration--;
		}
		else 
		{
			isOver = true;
		}
	}
}