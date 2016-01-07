package model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import tools.BeginHour;
import tools.Lecture;
import tools.WeekDays;

public class Students implements Cloneable{

	private String name;
	private HashMap<Availability,Lecture> timeTable;

	public Students(String name) {
		super();
		this.setName(name);
		this.initTimeTable();
	}
	
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
	
	public boolean canAttendLecture(Teacher t){
		int nbvalues = 0;
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
			if(entry.getValue() == null){
				
			}else if(entry.getValue().getT().getName() == t.getName()){
				nbvalues += 1;
			}
		}
		return nbvalues < 2;
	}
	
	public boolean canAttendLecture(){
		int nullvalues = 0;
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
			if(entry.getValue() == null){
				nullvalues += 1;
			}
		}
		return nullvalues > 2;
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
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
			if(entry.getKey().getDay() == a.getDay() && entry.getKey().getBeginning() == a.getBeginning()){
				timeTable.put(entry.getKey(), l.clone());
				return true;
			}
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
				returnString += "              Time : " + entry.getKey() + "	/ Teacher : " + entry.getValue().getT().getName()+ "/ Room : " + entry.getValue().getR().getName() + "\n";
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
	
	public Students clone() {
		Students s = new Students(this.name);
		s.initTimeTable();
		for (HashMap.Entry<Availability, Lecture> entry : this.getTimeTable().entrySet()){
			if(entry.getValue() != null){
				s.addLecture(entry.getKey().clone(), entry.getValue().clone());
			}
		}
		return s;
	}
}