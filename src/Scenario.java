import java.util.ArrayList;
import java.util.Arrays;

public class Scenario {
	
	private ArrayList<Teacher> AT;
	private ArrayList<Room> AR;
	
	
	/* Constructors */ 
	public Scenario(){
		super();
		this.setAT(new ArrayList<Teacher>());
		this.setAR(new ArrayList<Room>());
	}

	public void basicScenario(){
		
		// Creating availabilities
		ArrayList<Availability> u1 = new ArrayList<Availability>();
		u1.add(new Availability(WeekDays.j1, BeginHour.SIXTEEN));
		u1.add(new Availability(WeekDays.j2, BeginHour.FOURTEEN));
		
		ArrayList<Availability> u2 = new ArrayList<Availability>();
		u2.add(new Availability(WeekDays.j1, BeginHour.SIXTEEN));
		u2.add(new Availability(WeekDays.j2, BeginHour.TEN));
		
		ArrayList<Availability> u3 = new ArrayList<Availability>();
		u3.add(new Availability(WeekDays.j1, BeginHour.FOURTEEN));
		u3.add(new Availability(WeekDays.j2, BeginHour.EIGHT));
		
		
		//Creating new teachers
		Teacher t1 = new Teacher (u1);
		Teacher t2 = new Teacher (u2);
		Teacher t3 = new Teacher (u3);
		
		//Adding the skills 
		t1.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("English", 12))));
		t2.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("ComputerScience", 12))));
		t3.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("Mathematics", 12))));
		
		//Adding needed material
		t1.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.tableau,Equipment.retroprojecteur)));
		t2.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.salleTP,Equipment.tableau,Equipment.videoprojecteur)));
		t3.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur)));
		
		AT.add(t1);
		AT.add(t2);
		AT.add(t3);
		
		//Creating Rooms
		//TODO
	
	}
	
	
	/* Setters & Getters */
	public ArrayList<Room> getAR() {
		return AR;
	}

	public void setAR(ArrayList<Room> aR) {
		AR = aR;
	}

	public ArrayList<Teacher> getAT() {
		return AT;
	}

	public void setAT(ArrayList<Teacher> aT) {
		AT = aT;
	}
	
	
}
