import java.util.ArrayList;


public class Teacher {

	private ArrayList<Availability> unavailabilities;
	private ArrayList<Availability> availabilities;
	private ArrayList<Teaching> skills;
	private ArrayList<Equipment> material;
	
	/* Constructors */ 
	
	public Teacher() {
		this.unavailabilities = null;
		this.availabilities = null;
		this.skills = null;
		this.material = null;
	}
	
	public Teacher(ArrayList<Availability> unAvailabilities) {
		this.unavailabilities = unAvailabilities;
		this.initTeacherAvailabilities();
		this.skills = null;
		this.material = null;
	}
	
	public Teacher(ArrayList<Availability> unAvailabilities, ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		this.unavailabilities = unAvailabilities;
		this.initTeacherAvailabilities();
		this.skills = skills;
		this.material = material;
	}
	
	public Teacher(ArrayList<Availability> unavailabilities, ArrayList<Availability> availabilities, ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		super();
		this.unavailabilities = unavailabilities;
		this.availabilities = availabilities;
		this.skills = skills;
		this.material = material;
	}

	/* Init availabilities */ 
	
	public void initTeacherAvailabilities() {
		
		this.availabilities = new ArrayList<Availability>();
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.EIGHT));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.TEN));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.FOURTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.EIGHT));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.TEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.FOURTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.SIXTEEN));
		for (Availability availability : unavailabilities) {
			removeAvailability(availability.getDay(), availability.getBeginning());
		}
	}
	
	public void removeAvailability (Availability.weekDays wd, Availability.beginHour bh) {
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.ordinal() && availability.getEnd() == bh.ordinal()+2){
				availabilities.remove(availability);
			}
		}
	}
	
	public void removeAvailability (Availability.weekDays wd, int bh) {
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh && availability.getEnd() == bh +2){
				availabilities.remove(availability);
			}
		}
	}
	
	public void addAvailability (Availability.weekDays wd, Availability.beginHour bh) {
		boolean notfound = true;
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.ordinal() && availability.getEnd() == bh.ordinal()+2){
				notfound = false;
			}
		}
		
		if(notfound){
			availabilities.add(new Availability(wd, bh));
		}
	}
	/* Getters & Setters */
	
	public ArrayList<Availability> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(ArrayList<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public ArrayList<Teaching> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Teaching> skills) {
		this.skills = skills;
	}

	public ArrayList<Equipment> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Equipment> material) {
		this.material = material;
	}

	public ArrayList<Availability> getUnavailabilities() {
		return unavailabilities;
	}

	public void setUnavailabilities(ArrayList<Availability> unavailabilities) {
		this.unavailabilities = unavailabilities;
	}
	
	
	
}
