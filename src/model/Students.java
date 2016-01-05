package model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import tools.BeginHour;
import tools.Lecture;
import tools.WeekDays;

public class Students {

	private String name;
	private HashMap<Availability,Lecture> timeTable;

	public Students(String name) {
		super();
		this.setName(name);
		this.initTimeTable();

		
	}
	
	/* Methods */

	public void initTimeTable(){
		this.timeTable = new HashMap<Availability,Lecture>();
		
		Set<WeekDays> weekdays = EnumSet.allOf(WeekDays.class);
		Set<BeginHour> beginhour = EnumSet.allOf(BeginHour.class);
		for (Iterator<WeekDays> iterator = weekdays.iterator(); iterator.hasNext();) {
			WeekDays wd = iterator.next();
			for (Iterator<BeginHour> iterator2 = beginhour.iterator(); iterator2.hasNext();) {
				BeginHour bh = iterator2.next();
				this.timeTable.put(new Availability(wd, bh), null);
			}
		}	
	}
	
	public int getAllLectureValues(){	
		int value = 0;
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
			if(entry.getValue() != null){
				value += entry.getValue().getValue();
			}
		}
		return value;
	}
	
	public boolean addLecture(Availability a, Lecture l) {
		if (timeTable.containsKey(a)){
			timeTable.put(a, l);
			return true;
		}
		return false;
		
	}
	
	/* Getters & Setters */
	@Override
	public String toString() {
		
		String returnString = "Students "+name+"\n";
		
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
			if(entry.getValue() != null){
				returnString += "              Time : " + entry.getKey() + "	/ Teacher : " + entry.getValue().getT()+ "/ Room : " + entry.getValue().getR() + "\n";
			}else {
				returnString += "              Time : " + entry.getKey() + "	/ unassigned \n" ;
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

	public HashMap<Availability,Lecture> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(HashMap<Availability,Lecture> timeTable) {
		this.timeTable = timeTable;
	}
}