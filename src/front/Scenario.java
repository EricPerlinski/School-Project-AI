package front;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import model.Availability;
import model.Room;
import model.Students;
import model.Teacher;
import tools.BeginHour;
import tools.Equipment;
import tools.Lecture;
import tools.Teaching;
import tools.WeekDays;

public class Scenario {

	private ArrayList<Teacher> AT;
	private ArrayList<Room> AR;
	private ArrayList<Students> AS;

	/* Constructors */ 
	public Scenario(){
		super();
		this.setAT(new ArrayList<Teacher>());
		this.setAR(new ArrayList<Room>());
		this.setAS(new ArrayList<Students>());
	}

	public void basicScenario(){

		// Creating unAvailabilities
		ArrayList<Availability> u1 = new ArrayList<Availability>();
		u1.add(new Availability(WeekDays.j1, BeginHour.SIXTEEN));
		u1.add(new Availability(WeekDays.j2, BeginHour.FOURTEEN));

		ArrayList<Availability> u2 = new ArrayList<Availability>();
		u2.add(new Availability(WeekDays.j1, BeginHour.SIXTEEN));
		u2.add(new Availability(WeekDays.j2, BeginHour.TEN));

		ArrayList<Availability> u3 = new ArrayList<Availability>();
		u3.add(new Availability(WeekDays.j1, BeginHour.FOURTEEN));
		u3.add(new Availability(WeekDays.j2, BeginHour.EIGHT));


		//Creating new teachers
		Teacher t1 = new Teacher ("t1", u1);
		Teacher t2 = new Teacher ("t2", u2);
		Teacher t3 = new Teacher ("t3", u3);

		//Adding the skills 
		t1.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("English", 12))));
		t2.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("ComputerScience", 12))));
		t3.setSkills(new ArrayList<Teaching>(Arrays.asList(new Teaching("Mathematics", 12))));

		//Adding needed material
		t1.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.tableau,Equipment.retroprojecteur)));
		t2.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.salleTP,Equipment.tableau,Equipment.videoprojecteur)));
		t3.setMaterial(new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur)));

		AT.add(t1);
		AT.add(t2);
		AT.add(t3);

		//Creating Rooms
		ArrayList<Availability> ur1 = new ArrayList<Availability>();
		ur1.add(new Availability(WeekDays.j1, BeginHour.TEN));

		ArrayList<Availability> ur2 = new ArrayList<Availability>();
		ur2.add(new Availability(WeekDays.j2, BeginHour.EIGHT));
		ur2.add(new Availability(WeekDays.j2, BeginHour.SIXTEEN));

		ArrayList<Availability> ur3 = new ArrayList<Availability>();
		ur3.add(new Availability(WeekDays.j1, BeginHour.FOURTEEN));
		ur3.add(new Availability(WeekDays.j2, BeginHour.SIXTEEN));

		Room r1 = new Room("r1", ur1, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));
		Room r2 = new Room("r2", ur2, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));
		Room r3 = new Room("r3", ur3, new ArrayList<Equipment>(Arrays.asList(Equipment.retroprojecteur,Equipment.tableau,Equipment.videoprojecteur,Equipment.salleTP)));

		AR.add(r1);
		AR.add(r2);
		AR.add(r3);

		//Creating student groups

		AS.add(new Students("s1"));
		AS.add(new Students("s2"));
		AS.add(new Students("s3"));

	}

	@Override
	public String toString() {

		String returnString =   "Scenario\n"
				+ "--------------------------------------------\n"
				+ "    Teachers : \n"
				+ "--------------------------------------------\n";

		for (Teacher t : AT) {
			returnString += t.toString();
		}

		returnString += "--------------------------------------------\n"
				+ "    Rooms : \n"
				+ "--------------------------------------------\n";

		for (Room r : AR){
			returnString += r.toString();
		}

		returnString += "--------------------------------------------\n"
				+ "    Student groups : \n"
				+ "--------------------------------------------\n";

		for (Students s : AS){
			returnString += s.toString() + "\n";




			returnString += "\n";
		}

		return returnString;
	}



	/* Setters & Getters */
	public ArrayList<Room> getAR() {
		return AR;
	}

	public void setAR(ArrayList<Room> aR) {
		AR = aR;
	}

	public ArrayList<Teacher> getAT() {
		return AT;
	}

	public void setAT(ArrayList<Teacher> aT) {
		AT = aT;
	}

	public ArrayList<Students> getAS() {
		return AS;
	}

	public void setAS(ArrayList<Students> aS) {
		AS = aS;
	}

	static int i = 0;

	private class Node implements Comparable<Node> {


		public int nb;
		public int h;
		ArrayList<Students> ArrayListOfStudents;
		ArrayList<Room> ArrayListOfRooms;
		ArrayList<Teacher> ArrayListOfTeachers;
		public int value;


		public Node() {
			i += 1;
			nb = i;
			ArrayListOfStudents = new ArrayList<Students>();
			for(Students slist : AS){
				Students stemp = slist.clone();
				ArrayListOfStudents.add(stemp);
			}

			ArrayListOfRooms = new ArrayList<Room>();
			for(Room rlist : AR){
				Room rtemp = rlist.clone();
				ArrayListOfRooms.add(rtemp);
			}

			ArrayListOfTeachers = new ArrayList<Teacher>();
			for(Teacher tlist : AT){
				Teacher ttemp = tlist.clone();
				ArrayListOfTeachers.add(ttemp);
			}
			value = 0;
		}

		public Node(Node parent) {
			h = parent.h + 1;
			i += 1;
			nb = i;
			ArrayListOfStudents = new ArrayList<Students>();
			for(Students slist : parent.ArrayListOfStudents){
				Students stemp = slist.clone();
				ArrayListOfStudents.add(stemp);
			}

			ArrayListOfRooms = new ArrayList<Room>();
			for(Room rlist : parent.ArrayListOfRooms){
				Room rtemp = rlist.clone();
				ArrayListOfRooms.add(rtemp);
			}

			ArrayListOfTeachers = new ArrayList<Teacher>();
			for(Teacher tlist : parent.ArrayListOfTeachers){
				Teacher ttemp = tlist.clone();
				ArrayListOfTeachers.add(ttemp);
			}

			value = parent.value;
		}

		public String toString(){
			String returnString = "\n"
					+ "\n"
					+ "\n"
					+ "===============================================\n"
					+ " Node : i = "+i+" / h = " + h + "\n"
					+ "===============================================\n";

			for(Students e : ArrayListOfStudents){
				returnString += e.toString();
			}

			/*for(Room i : ArrayListOfRooms){
	    		returnString += i.toString();
	    	}

	    	for(Teacher j : ArrayListOfTeachers){
	    		returnString += j.toString();
	    	}
			 */
			return returnString+"\n===============================================\n\n\n\n";
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}


	public void solveBranchAndBound() {

		Node best = new Node();
		Node root = new Node();

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(root);
		int nbnode = 0;
		int notexplored = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if(node.h < 18){
				//if(node.value >= best.value && node.h < node.ArrayListOfStudents.size()*8 -1){
				for(Students e : node.ArrayListOfStudents){
					if(!e.canAttendLecture()){
						System.out.println(node.nb + "    "+ node.h + "   " +e.getName());
					}else{
						for(Room r : node.ArrayListOfRooms){
							for(Teacher t : node.ArrayListOfTeachers){
								for (HashMap.Entry<Availability, Lecture> entry : e.getTimeTable().entrySet()){
									if(entry.getValue() == null){
										if(r.isRoomAvailable() && r.isRoomAvailable(entry.getKey()) && t.isTeacherAvailable() && t.isTeacherAvailable(entry.getKey()) && e.canAttendLecture(t) && entry.getValue() == null && node.h < 18){
											//System.out.println("OK Horaire : "+entry.getKey()+" / Etudiant : "+e.getName()+" / Room : "+r.getName()+"-"+r.isRoomAvailable(entry.getKey())+" / Teacher : "+t.getName()+"-"+t.isTeacherAvailable(entry.getKey()));
											Node tmp = new Node(node);
											for(Students x : tmp.ArrayListOfStudents){
												if(x.getName().equals(e.getName())){
													x.addLecture(entry.getKey(), new Lecture(t.clone(),r.clone()));
												}
											}

											for(Room y : tmp.ArrayListOfRooms){
												if(y.getName().equals(r.getName())){
													y.removeAvailability(entry.getKey());
												}
											}

											for(Teacher z : tmp.ArrayListOfTeachers){
												if(z.getName().equals(t.getName())){
													z.removeAvailability(entry.getKey());
												}
											}
											//System.out.println(tmp.toString());
											//tmp.ArrayListOfRooms.get(tmp.ArrayListOfRooms.indexOf(r)).removeAvailability(entry.getKey());
											//tmp.ArrayListOfTeachers.get(tmp.ArrayListOfTeachers.indexOf(t)).removeAvailability(entry.getKey());
											q.offer(tmp);
											nbnode++;
											//System.err.println(tmp.toString());
										}else{
											notexplored++;
										}

									}
								}
							}
						}
					}

				}
				System.out.println("Nodes : "+nbnode+" / Not explored : "+notexplored);

			}	
		}	
		System.out.println("Nodes : "+nbnode+" / Not explored : "+notexplored);
	}
}
