import java.util.Random;

public class State
{
	public boolean isOver = false;
	public String nameOfState;
	
	public void step(Entity e){}
	
	public State(){}
	
	public State pickRandomState(int range)
	{
		Random rand = new Random();
		int n = rand.nextInt(range) + 1;
		switch(n)
		{
			case 1:
				return new Rest(rand.nextInt(100)+1);
			
			case 2:
				return new ZigZag(new Vector2D(14*Math.random()-7, 14*Math.random()-7), rand.nextInt(100)+1);
			
			case 3:
				return new GotoXY(new Vector2D( 1060*Math.random(), 540*Math.random() ), 7*Math.random()+1);
				
			case 4:
				return new Closest(7*Math.random()+1, rand.nextInt(100)+1);
		}
		return null;
	}
	
}