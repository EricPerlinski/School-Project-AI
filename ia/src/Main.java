import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		//Availabilities
		ArrayList<Availability> aT1 = new ArrayList<Availability>();
		aT1.add(new Availability(Availability.weekDays.j1, Availability.beginHour.EIGHT));
		aT1.add(new Availability(Availability.weekDays.j1, Availability.beginHour.TEN));
		aT1.add(new Availability(Availability.weekDays.j1, Availability.beginHour.FORTEEN));
		aT1.add(new Availability(Availability.weekDays.j2, Availability.beginHour.EIGHT));
		aT1.add(new Availability(Availability.weekDays.j2, Availability.beginHour.TEN));
		aT1.add(new Availability(Availability.weekDays.j2, Availability.beginHour.SIXTEEN));
		
		ArrayList<Availability> aT2 = new ArrayList<Availability>();
		aT2.add(new Availability(Availability.weekDays.j2, Availability.beginHour.EIGHT));
		aT2.add(new Availability(Availability.weekDays.j2, Availability.beginHour.FORTEEN));
		aT2.add(new Availability(Availability.weekDays.j2, Availability.beginHour.SIXTEEN));
		aT2.add(new Availability(Availability.weekDays.j1, Availability.beginHour.EIGHT));
		aT2.add(new Availability(Availability.weekDays.j1, Availability.beginHour.TEN));
		aT2.add(new Availability(Availability.weekDays.j1, Availability.beginHour.FORTEEN));
		
		ArrayList<Availability> aT3 = new ArrayList<Availability>();
		aT3.add(new Availability(Availability.weekDays.j1, Availability.beginHour.EIGHT));
		aT3.add(new Availability(Availability.weekDays.j1, Availability.beginHour.TEN));
		aT3.add(new Availability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN));
		aT3.add(new Availability(Availability.weekDays.j2, Availability.beginHour.TEN));
		aT3.add(new Availability(Availability.weekDays.j2, Availability.beginHour.FORTEEN));
		aT3.add(new Availability(Availability.weekDays.j2, Availability.beginHour.SIXTEEN));
		
		//Skills
		ArrayList<Teaching> skillsT1 = new ArrayList<Teaching>();
		skillsT1.add(new Teaching("English", vol))
		
		Teacher t1 = new Teacher(aT1, skills, material)

	}

}
