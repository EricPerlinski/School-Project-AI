import java.util.ArrayList;


public class Room {
	
	private ArrayList<Availability> roomAvailabilities;
	private ArrayList<Equipment> roomEquipment;
	
	public Room(ArrayList<Availability> roomAvailabilities,	ArrayList<Equipment> roomEquipment) {
		super();
		this.roomAvailabilities = roomAvailabilities;
		this.roomEquipment = roomEquipment;
	}

	public ArrayList<Availability> getRoomAvailabilities() {
		return roomAvailabilities;
	}

	public void setRoomAvailabilities(ArrayList<Availability> roomAvailabilities) {
		this.roomAvailabilities = roomAvailabilities;
	}

	public ArrayList<Equipment> getRoomEquipment() {
		return roomEquipment;
	}

	public void setRoomEquipment(ArrayList<Equipment> roomEquipment) {
		this.roomEquipment = roomEquipment;
	}
	
	
	
	

}
