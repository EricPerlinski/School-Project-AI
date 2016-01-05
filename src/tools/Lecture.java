package tools;

import model.Room;
import model.Teacher;

public class Lecture {
	
	private int value;
	private Room r;
	private Teacher t;
	
	Lecture(Teacher t, Room r){
		this.setR(r);
		this.setT(t);
		this.setValue(0);
		for(Equipment e : t.getMaterial()){
			if(r.getRoomEquipment().contains(e)){
				this.setValue(this.getValue()+1);
			}
		}
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
