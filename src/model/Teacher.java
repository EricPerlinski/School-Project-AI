package model;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

import tools.BeginHour;
import tools.Equipment;
import tools.WeekDays;


public class Teacher {

	private String name;
	private ArrayList<Availability> unavailabilities;
	private ArrayList<Availability> availabilities;
	private ArrayList<Teaching> skills;
	private ArrayList<Equipment> material;
	
	/* Constructors */ 
	
	public Teacher(String name) {
		this.unavailabilities = null;
		this.availabilities = null;
		this.skills = null;
		this.material = null;
		this.setName(name);
	}
	
	public Teacher(String name, ArrayList<Availability> unAvailabilities) {
		this.unavailabilities = unAvailabilities;
		this.initTeacherAvailabilities();
		this.skills = null;
		this.material = null;
		this.setName(name);
	}
	
	public Teacher(String name, ArrayList<Availability> unAvailabilities, ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		this.unavailabilities = unAvailabilities;
		this.initTeacherAvailabilities();
		this.skills = skills;
		this.material = material;
		this.setName(name);
	}
	
	public Teacher(String name, ArrayList<Availability> unavailabilities, ArrayList<Availability> availabilities, ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		super();
		this.unavailabilities = unavailabilities;
		this.availabilities = availabilities;
		this.skills = skills;
		this.material = material;
		this.setName(name);
	}

	/* Init availabilities => add all possible availability to the availability list of the teacher, it doesn't add availabilities that are in the unavailability list */ 
	
	public void initTeacherAvailabilities() {
		
		this.availabilities = new ArrayList<Availability>();
		Set<WeekDays> weekdays = EnumSet.allOf(WeekDays.class);
		Set<BeginHour> beginhour = EnumSet.allOf(BeginHour.class);
		for (Iterator<WeekDays> iterator = weekdays.iterator(); iterator.hasNext();) {
			WeekDays wd = iterator.next();
			for (Iterator<BeginHour> iterator2 = beginhour.iterator(); iterator2.hasNext();) {
				BeginHour bh = iterator2.next();
				boolean found = false;
				for (Availability availability : unavailabilities) {
					if(availability.getDay() == wd && availability.getBeginning() == bh.get()) 
						found = true;
				}
				if(!found) addAvailability(wd, bh);				
			}
		}
	}
	
	public void removeAvailability (WeekDays wd, BeginHour bh) {
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.get() && availability.getEnd() == bh.get()+2){
				availabilities.remove(availability);
			}
		}
	}
	
	public void removeAvailability (WeekDays wd, int bh) {
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh && availability.getEnd() == bh +2){
				availabilities.remove(availability);
			}
		}
	}
	
	public void addAvailability (WeekDays wd, BeginHour bh) {
		boolean found = false;
		for (Availability availability : availabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.get() && availability.getEnd() == bh.get()+2){
				found = true;
			}
		}
		
		if(!found) availabilities.add(new Availability(wd, bh));
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

	@Override
	public String toString() {
		String returnString = "Teacher "+name+"\n"
							+ "\n              unavailabilities = "; 
		for (Availability availability : unavailabilities){
			returnString +=   "(" + availability;
		}
		returnString +=       "\n              availabilities = ";	
		for (Availability availability : unavailabilities){
			returnString +=   "(" + availability;
		}
		returnString +=       "\n              skills = ";
		for (Teaching t : skills){
			returnString += t + " ";
		}
		
		if(material.isEmpty()) {
			returnString +=   "\n              No equipment needed \n";
		}else {
			returnString +=   "\n              equipment needed = ";
			
			for (Equipment e : material) {
				returnString += e.name() + ",";
			}
		}
		
		
		return returnString+"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
