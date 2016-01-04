package model;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import tools.BeginHour;
import tools.Equipment;
import tools.Lecture;
import tools.WeekDays;


public class Room {
	
	private String name;
	private ArrayList<Availability> roomUnAvailabilities;
	private ArrayList<Availability> roomAvailabilities;
	private ArrayList<Equipment> roomEquipment;
	private HashMap<Availability,Lecture> timeTable;
	
	
	/* Constructors */
	public Room(String name, ArrayList<Availability> roomUnAvailabilities,	ArrayList<Equipment> roomEquipment) {
		super();
		this.name = name;
		this.setRoomUnAvailabilities(roomUnAvailabilities);
		this.initRoomAvailabilities();
		this.roomEquipment = roomEquipment;
		this.setTimeTable(new HashMap<Availability,Lecture>());
	}

	
	/* Methods */
	
	
	
	public boolean addLecture(Availability a, Lecture l) {
		if (timeTable.containsKey(a)){
			timeTable.put(a, l);
			return true;
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void initRoomAvailabilities() {
		
		this.roomAvailabilities = new ArrayList<Availability>();
		Set<WeekDays> weekdays = EnumSet.allOf(WeekDays.class);
		Set<BeginHour> beginhour = EnumSet.allOf(BeginHour.class);
		for (Iterator<WeekDays> iterator = weekdays.iterator(); iterator.hasNext();) {
			WeekDays wd = iterator.next();
			for (Iterator<BeginHour> iterator2 = beginhour.iterator(); iterator2.hasNext();) {
				BeginHour bh = iterator2.next();
				boolean found = false;
				for (Availability availability : roomUnAvailabilities) {
					if(availability.getDay() == wd && availability.getBeginning() == bh.get()) 
						found = true;
				}
				if(!found) addAvailability(wd, bh);				
			}
		}
	}
	
	public void removeAvailability (WeekDays wd, BeginHour bh) {
		for (Availability availability : roomAvailabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.get() && availability.getEnd() == bh.get()+2){
				roomAvailabilities.remove(availability);
			}
		}
	}
	
	public void removeAvailability (WeekDays wd, int bh) {
		for (Availability availability : roomAvailabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh && availability.getEnd() == bh +2){
				roomAvailabilities.remove(availability);
			}
		}
	}
	
	public void addAvailability (WeekDays wd, BeginHour bh) {
		boolean found = false;
		for (Availability availability : roomAvailabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.get() && availability.getEnd() == bh.get()+2){
				found = true;
			}
		}
		
		if(!found) roomAvailabilities.add(new Availability(wd, bh));
	}
	
	
	/* Getters & Setters */
	
	@Override
	public String toString() {
		
		String returnString = "Room "+name+"\n"
							+ "\n              unavailabilities = "; 
		for (Availability availability : roomUnAvailabilities){
			returnString +=   "(" + availability;
		}
		returnString +=       "\n              availabilities = ";	
		for (Availability availability : roomAvailabilities){
			returnString +=   "(" + availability;
		}
		
		if(roomEquipment.isEmpty()) {
			returnString +=   "\n              No equipment\n";
		}else {
			returnString +=   "\n              equipment available = ";
			
			for (Equipment e : roomEquipment) {
				returnString += e.name() + ",";
			}
		}
			
			
			return returnString+"\n";
	}



	public ArrayList<Availability> getRoomAvailabilities() {
		return roomAvailabilities;
	}

	public void setRoomAvailabilities(ArrayList<Availability> roomAvailabilities) {
		this.roomAvailabilities = roomAvailabilities;
	}

	public ArrayList<Equipment> getRoomEquipment() {
		return roomEquipment;
	}

	public void setRoomEquipment(ArrayList<Equipment> roomEquipment) {
		this.roomEquipment = roomEquipment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Availability> getRoomUnAvailabilities() {
		return roomUnAvailabilities;
	}


	public void setRoomUnAvailabilities(ArrayList<Availability> roomUnAvailabilities) {
		this.roomUnAvailabilities = roomUnAvailabilities;
	}
	
	public HashMap<Availability, Lecture> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(HashMap<Availability, Lecture> timeTable) {
		this.timeTable = timeTable;
	}
	
	
	

}
