package model;

public class Teaching {

	private String name;
	
	//nombre de créneau de 2h
	private int timeVolume;
	
	public Teaching(String nom, int vol){
		this.name = nom;
		this.timeVolume = vol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimeVolume() {
		return timeVolume;
	}

	public void setTimeVolume(int timeVolume) {
		this.timeVolume = timeVolume;
	}

	@Override
	public String toString() {
		return "("+name+","+timeVolume+"h)";
	}

	
	
	
	
}
