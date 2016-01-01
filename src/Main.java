import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		

		// Creating availabilities
		ArrayList<Availability> u1 = new ArrayList<Availability>();
		u1.add(new Availability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN));
		u1.add(new Availability(Availability.weekDays.j2, Availability.beginHour.FOURTEEN));
		
		ArrayList<Availability> u2 = new ArrayList<Availability>();
		u2.add(new Availability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN));
		u2.add(new Availability(Availability.weekDays.j2, Availability.beginHour.TEN));
		
		ArrayList<Availability> u3 = new ArrayList<Availability>();
		u3.add(new Availability(Availability.weekDays.j1, Availability.beginHour.FOURTEEN));
		u3.add(new Availability(Availability.weekDays.j2, Availability.beginHour.EIGHT));
		
		
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
		
		//Creating Rooms
		//TODO
		
	}
}
