package model;

import java.util.HashMap;

import tools.Lecture;

public class Students {

	private String name;
	private HashMap<Availability,Lecture> timeTable;

	public Students(String name) {
		super();
		this.setName(name);
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
	
	/* Getters & Setters */
	@Override
	public String toString() {
		return "Students "+name+"\n";
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