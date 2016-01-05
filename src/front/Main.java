package front;

public class Main {

	public static void main(String[] args) {
		
		/* Create a basic scenario with teachers, rooms, equipments, availabilities and student groups */
		Scenario S1 = new Scenario();
		S1.basicScenario();
		S1.solveBranchAndBound();
		
		//System.out.println(S1.toString());
	
	}
	
}
