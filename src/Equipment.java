
public enum Equipment {
	
	videoprojecteur ("Vid�o projecteur"),
	retroprojecteur ("R�tro projecteur"),
	salleTP ("Salle de TP"),
	tableau ("Tableau");
			   
	private String name = "";
		   
	//Constructeur
	Equipment(String name){
		this.name = name;
	}
		   
	public String toString(){
		return name;
	}	
}
