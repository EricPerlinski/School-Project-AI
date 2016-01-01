import java.util.Map;

public class Students {

	private Map<Availability,Teaching> timeTable;

	public Students() {
		super();
	}
	
	public Students(Map<Availability, Teaching> timeTable) {
		super();
		this.timeTable = timeTable;
	}

	/* Methods */
		
	public boolean addLecture(Availability a, Teaching t) {
		if (timeTable.containsKey(a)){
			timeTable.put(a, t);
			return true;
		}
		return false;
		
	}
	
	/* Getters & Setters */
	@Override
	public String toString() {
		return "Students [timeTable=" + timeTable + "]";
	}

	public Map<Availability,Teaching> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(Map<Availability,Teaching> timeTable) {
		this.timeTable = timeTable;
	}
	
	
	
	
	
}
