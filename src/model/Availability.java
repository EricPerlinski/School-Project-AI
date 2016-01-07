package model;

import tools.BeginHour;
import tools.WeekDays;

public class Availability implements Cloneable{

	private WeekDays day;
	private int beginning;
	private int end;

	public Availability(WeekDays day, BeginHour beginning) {
		super();
		this.day = day;
		this.beginning = beginning.get();
		this.end = beginning.get() +  2;
	}

	public Availability(WeekDays day, int beginning) {
		super();
		this.day = day;
		this.beginning = beginning;
		this.end = beginning +  2;
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

	@Override
	public String toString() {
		return "("+ day.name() + "," + beginning + " - " + end + ")";
	}

	public Availability clone() {
		Availability a = new Availability(this.day,this.beginning);
		return a;
	}

}
