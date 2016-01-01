
public class Availability {
	
	private WeekDays day;
	private int beginning;
	private int end;
	
	public Availability(WeekDays day, BeginHour beginning) {
		super();
		this.day = day;
		this.beginning = beginning.get();
		this.end = beginning.get() +  2;
	}

	public WeekDays getDay() {
		return day;
	}

	public void setDay(WeekDays day) {
		this.day = day;
	}

	public int getBeginning() {
		return beginning;
	}

	public void setBeginning(int beginning) {
		this.beginning = beginning;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
