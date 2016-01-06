package model;
import java.util.ArrayList;
import java.util.EnumSet;

import java.util.Iterator;
import java.util.Set;

import tools.BeginHour;
import tools.Equipment;
import tools.WeekDays;


public class Room implements Cloneable{
	
	private String name;
	private ArrayList<Availability> roomUnAvailabilities;
	private ArrayList<Availability> roomAvailabilities;
	private ArrayList<Equipment> roomEquipment;
	
	
	
	/* Constructors */
	public Room(String name){
		super();
		this.name = name;
		this.setRoomUnAvailabilities(new ArrayList<Availability>());
		this.setRoomAvailabilities(new ArrayList<Availability>());
		this.setRoomEquipment(new ArrayList<Equipment>());
	}
	
	public Room(String name, ArrayList<Availability> roomUnAvailabilities,	ArrayList<Equipment> roomEquipment) {
		super();
		this.name = name;
		this.setRoomUnAvailabilities(roomUnAvailabilities);
		this.initRoomAvailabilities();
		this.roomEquipment = roomEquipment;
		
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
	
	
	
	public boolean isRoomAvailable(WeekDays wd, BeginHour bh){
		for(Availability a : roomAvailabilities){
			//System.err.println("     wd : " + wd + " - bh : "+bh+" - bh.get() : "+bh.get()+" / a.getDay() : "+a.getDay()+" - a.getBeginning() : " + a.getBeginning() );
			if(a.getDay() == wd && a.getBeginning() == bh.get()){
				return true;
			}
		}
		return false;
	}
	
	public boolean isRoomAvailable(Availability a){
		for(Availability availability : roomAvailabilities){
			//System.err.println("     wd : " + a.getDay() + " - bh : "+a.getBeginning()+"  / a.getDay() : "+availability.getDay()+" - a.getBeginning() : " + availability.getBeginning() );
			if(a.getDay() == availability.getDay() && a.getBeginning() == availability.getBeginning()){
				return true;
			}
		}
		return false;
	}
	
	public void removeAvailability (WeekDays wd, BeginHour bh) {
		for (Availability availability : roomAvailabilities) {
			if (availability.getDay() == wd && availability.getBeginning() == bh.get() && availability.getEnd() == bh.get()+2){
				roomAvailabilities.remove(availability);
			}
		}
	}

	public void removeAvailability (Availability a) {
		for (int i=0;i<roomAvailabilities.size();i++) {
			if (roomAvailabilities.get(i).getDay() == a.getDay() && a.getBeginning() == roomAvailabilities.get(i).getBeginning()){
				roomAvailabilities.remove(i);
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
	
	public void addAvailability (Availability a) {
		boolean found = false;
		for (Availability availability : roomAvailabilities) {
			if (availability.getDay() == a.getDay() && availability.getBeginning() == a.getBeginning() && availability.getEnd() == a.getEnd()){
				found = true;
			}
		}
		
		if(!found) roomAvailabilities.add(new Availability(a.getDay(), a.getBeginning()));
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


	public Room clone(){
		Room r = new Room(this.name);
		for(Availability a : this.roomUnAvailabilities){
			r.roomUnAvailabilities.add(a.clone());
		}
		for(Availability a : this.roomAvailabilities){
			r.roomAvailabilities.add(a.clone());
		}
		for(Equipment e : this.roomEquipment){
			r.roomEquipment.add(e);
		}
		return r;
	}
		
}