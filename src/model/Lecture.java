package model;

public class Lecture {
	private Room r;
	private Teaching t;
	
	Lecture(Room r, Teaching t){
		this.setR(r);
		this.setT(t);
		
	}

	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}

	public Teaching getT() {
		return t;
	}

	public void setT(Teaching t) {
		this.t = t;
	}
}
