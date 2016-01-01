
public enum Equipment {
	
	videoprojecteur ("Vidéo projecteur"),
	retroprojecteur ("Rétro projecteur"),
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
