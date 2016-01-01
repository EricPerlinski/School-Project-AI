
public class Availability {
	
	private final int EIGHT = 8;
	private final int TEN = 10;
	private final int FORTEEN = 14;
	private final int SIXTEEN = 16;

	public static enum weekDays {
		j1, 
		j2;
	}
	
	public static enum beginHour {
		EIGHT,
		TEN,
		FOURTEEN,
		SIXTEEN;
	}
	
	private weekDays day;
	private int beginning;
	private int end;
	
	public Availability(weekDays day, beginHour beginning) {
		super();
		this.day = day;
		this.beginning = beginning.ordinal();
		this.end = beginning.ordinal() + 2;
	}

	public weekDays getDay() {
		return day;
	}

	public void setDay(weekDays day) {
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
