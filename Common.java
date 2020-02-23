import java.util.ArrayList;
import java.awt.Graphics2D;
import java.io.*;
import javax.imageio.*;
import java.awt.FontMetrics;

public class Common
{
	public int windowHeight = 600;
	public int windowWidth = 1100;
	public UniversityMap map;
	public ArrayList<Academician> academicians;
	public ArrayList<Student> students;
	public ArrayList<Speaker> speakers;
	public ArrayList<Assessment> assessments;
	public final Vector2D stella = new Vector2D(750, 480);	
	public boolean isFinished = false;
	
	private static Common singleCommon;
	
	private final String [] studentNames =
	{
		"Abay" , "Abilda" , "Abilkhaiyr" , "Ablan" , "Abylaikhan" , "Adil" , "Adilzhan" , "Adlet" , "Aidana" , "Aidyn" , "Aigerim" , "Aisana" ,
		"Akhmed" , "Akmyrza" , "Alan" , "Aldamzhar" , "Alexandra" , "Ali" , "Alibek" , "Alim" , "Alisher" , "Allan" , "Altair" , "Altynay" ,
		"Altynbek" , "Amangeldy" , "Amina" , "Anel" , "Angsar" , "Anuar" , "Ardan" , "Arman" , "Askhat" , "Assanali" , "Assem" , "Ayazhan" ,
		"Azamat" , "Azizkhan" , "Bagdat" , "Baglan" , "Bakdaulet" , "Bakdauren" , "Bakyt" , "Batyrbek" , "Batyrkhan" , "Bauyrzhan" , "Beibarys" ,
		"Bekzat" , "Bota" , "Damir" , "Dana" , "Danel" , "Daniyar" , "Darina" , "Dastan" , "Daulet" , "Dauren" , "Dnislam" , "Dulat" , "Eldar" ,
		"Emir" , "Galym" , "Gulnaz" , "Islam" , "Kamila" , "Kamilla" , "Karim" , "Kassym" , "Khadisha" , "Khafiz" , "Kuanysh" , "Kyran" , "Madi" ,
		"Madiyar" , "Magzhan" , "Makhambet" , "Mansur" , "Margulan" , "Maxim" , "Medet" , "Meirzhan" , "Miras" , "Mokhira" , "Murat" , "Nargiza" ,
		"Nartay" , "Nuradil" , "Nurbolat" , "Nurdaulet" , "Nurlan" , "Nursultan" , "Nurtileu" , "Olzhas" , "Rabbani" , "Raiymbek" , "Rakhat" ,
		"Ramazan" , "Ramilya" , "Rauan" , "Rollan" , "Rustem" , "Sabyr" , "Sagi" , "Saidgaffor" , "Saken" , "Salavat" , "Sandugash" , "Sanzhar" ,
		"Shapagat" , "Sherkhan" , "Shynggys" , "Shyngys" , "Tatyana" , "Temirlan" , "Temirzhan" , "Timur" , "Togzhan" , "Tomiris" , "Turgankhan" ,
		"Vladislav" , "Yeldos" , "Yerkali" , "Yerkhan" , "Yermek" , "Yernar" , "Yerzhan" , "Yussup" , "Zarina" , "Zhalgas" , "Zhanarys" , "Zhandos" ,
		"Zhangeldi" , "Zhannur" , "Zhansaya" , "Zhassulan" , "Zhibek" , "Zhuldyz"
	} ;
	
	public int randomInt(int from, int to)
	{
		return ( from + (int)((to-from) * Math.random()) );
	}
	
	public Assessment findClosest (Entity st)
	{
		Assessment closest = assessments.get(0);
		for (Assessment as : assessments)
		{
			if (st.position.distanceTo(as.position) < st.position.distanceTo(closest.position))
				closest = as;
		}
		return closest;
	}
	
	public void stepAllEntities()
	{
		
		for (Academician ac : academicians)
		{
			ac.step();
			
			if (!ac.state.nameOfState.equals("Rest") && !ac.state.nameOfState.equals("Stationary"))
			{
				int n = randomInt(1, 10);
				if (n==2)
				{
					Assessment as = new Assessment();
					as = ac.createAssessment();
					assessments.add(as);
				}
			}
		}
		
		
		for (Student st : students)
		{
			st.setCommon();
			st.step();
			if (assessments.size()!=0)
			{
				Assessment closest = findClosest(st);
				if (st.position.distanceTo(closest.position) <= 20)
				{
					st.grade += closest.points;
					assessments.remove(closest);
				}
			}
		}
		
		isFinished = true;
		
		for (Student st : students)
		{
			if (!st.state.nameOfState.equals("Stationary"))
				isFinished = false;
		}
		
		if (isFinished)
			startCeremony();
	}
	
	public void startCeremony()
	{
		Vector2D interval = new Vector2D(70,0);
		Vector2D shift = new Vector2D(-100,-100);
		for (Academician ac : academicians)
		{
			ac.state = new Stationary();
			
			ac.position = stella.plus(shift);
			shift = shift.plus(interval); 
		}
		
		/**/
	}
	public void drawAllEntities(Graphics2D g2d)
	{
		map.draw(g2d);
		for (Student st : students)
		{
			st.draw(g2d);
		}
		
		for (Academician ac : academicians)
		{
			ac.draw(g2d);
		}
		
		for (Assessment as : assessments)
		{
			if (!isFinished)
				as.draw(g2d);
		}
		
		if (isFinished)
		{
			FontMetrics fm = g2d.getFontMetrics();
			double textWidth = fm.getStringBounds("GRADUATION CEREMONY", g2d).getWidth();
			g2d.drawString("GRADUATION CEREMONY", (int)(stella.x - textWidth/2), (int)(stella.y + 100));
			
			for (Speaker sp : speakers)
			{
					sp.draw(g2d);
			}
		}
	}
	
	public static Common getSingleCommon()
	{
		if (singleCommon==null)
		{
			singleCommon = new Common();
		}
		return singleCommon;
	}
	
	private Common()
	{
		///////////////////////////////////////////////////////////
		map = new UniversityMap();
		///////////////////////////////////////////////////////////
		
		
		///////////////////////////////////////////////////////////
		students = new ArrayList<Student>(10);
		for (int i=0;i<10;i++)
		{
			int random = randomInt(0, studentNames.length);
			Student st = new Student(studentNames[random]);
			students.add(st);
			
		}
		///////////////////////////////////////////////////////////
		
		
		///////////////////////////////////////////////////////////
		Academician tem = new Academician("Temizer");
		Academician niv = new Academician("Nivelle");
		Academician kat = new Academician("Katsu");
		Academician tou = new Academician("Tourassis");
		
		try
		{
			tem.img = ImageIO.read(new File("../Demo/SelimTemizer.gif"));
			niv.img = ImageIO.read(new File("../Demo/HansDeNivelle.gif"));
			kat.img = ImageIO.read(new File("../Demo/ShigeoKatsu.gif"));
			tou.img = ImageIO.read(new File("../Demo/VassiliosTourassis.gif"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		academicians = new ArrayList<Academician>(4);
		academicians.add(tem);
		academicians.add(niv);
		academicians.add(kat);
		academicians.add(tou);
		///////////////////////////////////////////////////////////
		
		assessments = new ArrayList<Assessment>(100);
		///////////////////////////////////////////////////////////
		
		Speaker naz = new Speaker ("Nazarbayev");
		Speaker tok = new Speaker ("Tokayev");
		naz.position = stella.plus(new Vector2D(100, 0));
		tok.position = stella.plus(new Vector2D(-100, 0));
		
		
		try
		{
			naz.img = ImageIO.read(new File("../Demo/NursultanNazarbayev.gif"));
			tok.img = ImageIO.read(new File("../Demo/KassymJomartTokayev.gif"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		speakers = new ArrayList<Speaker>(2);
		speakers.add(naz);
		speakers.add(tok);
		
		
	}
}