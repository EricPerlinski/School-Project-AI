package tools;

import model.Students;
import model.Teacher;

public class Lecture {
	
	private Students s;
	private Teacher t;
	
	Lecture(Teacher t, Students s){
		this.setS(s);
		this.setT(t);
	}

	public Students getS() {
		return s;
	}

	public void setS(Students s) {
		this.s = s;
	}
	


	public Teacher getT() {
		return t;
	}

	public void setT(Teacher t) {
		this.t = t;
	}
}
