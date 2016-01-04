package model;

public class Students {

	private String name;
	

	public Students(String name) {
		super();
		this.setName(name);
	}
	
	/* Methods */
		
	
	
	/* Getters & Setters */
	@Override
	public String toString() {
		return "Students "+name+"\n";
	}
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
}