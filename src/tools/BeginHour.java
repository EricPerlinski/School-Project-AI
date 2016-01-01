package tools;

public enum BeginHour {

	EIGHT (8),
	TEN (10),
	FOURTEEN (14),
	SIXTEEN (16);
	
	private int hour;
	
	BeginHour(int hour){
		this.hour = hour;
	}
		
	public int get(){
		return hour;
	}
}
