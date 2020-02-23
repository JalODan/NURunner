import java.util.Random;

public class AssessmentFactory
{	
	public AssessmentFactory(){}
	
	public Assessment createAssessment(Vector2D position)
	{
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;
		switch(n)
		{
			case 1:
				return new Homework(position, rand.nextInt(3)+1);
			
			case 2:
				return new Lab(position, rand.nextInt(3)+2);
			
			case 3:
				return new Quiz(position, rand.nextInt(3)+3);
		}
		return null;
		
	}
}