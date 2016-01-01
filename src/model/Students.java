package model;
import java.util.HashMap;


public class Students {

	private String name;
	private HashMap<Availability,Lecture> timeTable;

	public Students(String name) {
		super();
		this.setName(name);
		this.timeTable = new HashMap<Availability,Lecture>();
	}
	
	public Students(HashMap<Availability, Lecture> timeTable) {
		super();
		this.timeTable = timeTable;
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
		
		String returnString = "Students "+name+"\n";
		
		if(timeTable.isEmpty()){
			
			returnString += "\n              No timeTable \n"; 
		
		}
		for (HashMap.Entry<Availability, Lecture> entry : timeTable.entrySet())
		{
		    System.out.println("Time : " + entry.getKey() + "/ Room : " + entry.getValue().getR()+ "/ Lecture : " + entry.getValue().getT() + "\n");
		}
		
		return returnString+"\n";
	}

	public HashMap<Availability, Lecture> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(HashMap<Availability, Lecture> timeTable) {
		this.timeTable = timeTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
