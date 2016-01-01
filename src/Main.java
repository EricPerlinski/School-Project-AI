import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		//Creating new teachers
		Teacher t1 = new Teacher ();
		Teacher t2 = new Teacher ();
		Teacher t3 = new Teacher ();
		
		
		//Fixing availabilities
		t1.removeAvailability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN);
		t1.removeAvailability(Availability.weekDays.j2, Availability.beginHour.FOURTEEN);
		
		t2.removeAvailability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN);
		t2.removeAvailability(Availability.weekDays.j2, Availability.beginHour.TEN);
		
		t3.removeAvailability(Availability.weekDays.j1, Availability.beginHour.FOURTEEN);
		t3.removeAvailability(Availability.weekDays.j2, Availability.beginHour.EIGHT);
		
		
		
		
			
		//Adding the skills 
		ArrayList<Teaching> skillsT1 = new ArrayList<Teaching>();
		skillsT1.add(new Teaching("English", vol));
		
		//Adding the needed materials
		Teacher t1 = new Teacher(aT1, skills, material);

	}

}
