package tools;

import model.Room;
import model.Teacher;

public class Lecture {
	
	private Room r;
	private Teacher t;
	
	Lecture(Teacher t, Room r){
		this.setR(r);
		this.setT(t);
	}

	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}
	


	public Teacher getT() {
		return t;
	}

	public void setT(Teacher t) {
		this.t = t;
	}
}
