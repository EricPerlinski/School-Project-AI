package front;
import java.util.ArrayList;
import java.util.Arrays;

import model.Availability;
import model.Room;
import model.Students;
import model.Teacher;
import tools.BeginHour;
import tools.Equipment;
import tools.Teaching;
import tools.WeekDays;

public class Scenario {
	
	private ArrayList<Teacher> AT;
	private ArrayList<Room> AR;
	private ArrayList<Students> AS;
	
	
	/* Constructors */ 
	public Scenario(){
		super();
		this.setAT(new ArrayList<Teacher>());
		this.setAR(new ArrayList<Room>());
		this.setAS(new ArrayList<Students>());
	}

	public void basicScenario(){
		
		// Creating unAvailabilities
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
		Teacher t1 = new Teacher ("t1", u1);
		Teacher t2 = new Teacher ("t2", u2);
		Teacher t3 = new Teacher ("t3", u3);
		
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
		ArrayList<Availability> ur1 = new ArrayList<Availability>();
		ur1.add(new Availability(WeekDays.j1, BeginHour.TEN));
		
		ArrayList<Availability> ur2 = new ArrayList<Availability>();
		ur2.add(new Availability(WeekDays.j2, BeginHour.EIGHT));
		ur2.add(new Availability(WeekDays.j2, BeginHour.SIXTEEN));
		
		ArrayList<Availability> ur3 = new ArrayList<Availability>();
		ur3.add(new Availability(WeekDays.j1, BeginHour.FOURTEEN));
		ur3.add(new Availability(WeekDays.j2, BeginHour.SIXTEEN));
		
		Room r1 = new Room("r1", ur1, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));
		Room r2 = new Room("r2", ur2, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));
		Room r3 = new Room("r3", ur3, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));
	
		AR.add(r1);
		AR.add(r2);
		AR.add(r3);
		
		//Creating student groups
		
		AS.add(new Students("s1"));
		AS.add(new Students("s2"));
		AS.add(new Students("s3"));
		
	}
	
	
	@Override
	public String toString() {
		
		String returnString =   "Scenario\n"
							  + "--------------------------------------------\n"
							  + "    Teachers : \n"
							  + "--------------------------------------------\n";
		
		for (Teacher t : AT) {
			returnString += t.toString();
		}
		
		returnString += "--------------------------------------------\n"
				      + "    Rooms : \n"
					  + "--------------------------------------------\n";
		
		for (Room r : AR){
			returnString += r.toString();
		}
		
		returnString += "--------------------------------------------\n"
			      + "    Student groups : \n"
				  + "--------------------------------------------\n";
	
		for (Students s : AS){
			returnString += s.toString();
		}
		
		return returnString;
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

	public ArrayList<Students> getAS() {
		return AS;
	}

	public void setAS(ArrayList<Students> aS) {
		AS = aS;
	}
	
	
}
