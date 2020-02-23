public class GotoXY extends State
{
	Vector2D destination;
	Vector2D velocity;
	boolean isVelocityInitialized;
	double speedFactor;
	
	public GotoXY(Vector2D destination, double speedFactor)
	{
		velocity = new Vector2D();
		this.destination = destination;
		this.speedFactor = speedFactor;
		isVelocityInitialized = false;
		nameOfState = "GotoXY";
	}
	
	@Override
	public void step(Entity e)
	{
		if (!isVelocityInitialized)
		{
			velocity = destination.minus(e.position);
			velocity.normalize();
			velocity.set(speedFactor*velocity.x, speedFactor*velocity.y);
			isVelocityInitialized = true;
		}
		
		if (e.position.distanceTo(destination) <= 10)
			isOver = true;
		else
			e.position = e.position.plus(velocity);
		
	}
}