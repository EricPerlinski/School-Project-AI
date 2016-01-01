import java.util.ArrayList;


public class Teacher {
	
	private enum Equipment {
		videoprojecteur,
		retroprojecteur,
		salleTP,
		tableau;
	}

	private ArrayList<Availability> availabilities;
	private ArrayList<Teaching> skills;
	private ArrayList<Equipment> material;
	
	
	
	/* Constructors */ 
	
	public Teacher() {
		this.initAvailabilities();
		this.skills = null;
		this.material = null;
	}
	
	public Teacher(ArrayList<Availability> availabilities,
			ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		super();
		this.availabilities = availabilities;
		this.skills = skills;
		this.material = material;
	}

	/* Init availabilities */ 
	
	public void initAvailabilities () {
		this.availabilities = new ArrayList<Availability>();
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.EIGHT));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.TEN));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.FOURTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j1, Availability.beginHour.SIXTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.EIGHT));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.TEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.FOURTEEN));
		this.availabilities.add(new Availability(Availability.weekDays.j2, Availability.beginHour.SIXTEEN));		
	}
	
	public void removeAvailability (Availability.weekDays wd, Availability.beginHour bh) {
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.ordinal() && availability.getEnd() == bh.ordinal()+2){
				availabilities.remove(availability);
			}
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
	
	
	
}
