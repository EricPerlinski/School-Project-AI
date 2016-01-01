import java.util.ArrayList;


public class Teacher {
	
	private enum Equipment {
		videoprojecteur,
		retroprojecteur,
		salleTP,
		tableau;
	}

	private ArrayList<Availability> availabilities;
	private ArrayList<Teaching> skills;
	private ArrayList<Equipment> material;
	
	public Teacher(ArrayList<Availability> availabilities,
			ArrayList<Teaching> skills, ArrayList<Equipment> material) {
		super();
		this.availabilities = availabilities;
		this.skills = skills;
		this.material = material;
	}

	public ArrayList<Availability> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(ArrayList<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public ArrayList<Teaching> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Teaching> skills) {
		this.skills = skills;
	}

	public ArrayList<Equipment> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Equipment> material) {
		this.material = material;
	}
	
	
	
}
