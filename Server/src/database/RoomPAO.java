package database;

public class RoomPAO {
	int roomID;
	String roomName;
	
	public RoomPAO(int roomID, String roomName){
		this.roomID = roomID;
		this.roomName = roomName;
	}
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString() {
		return "\nRoom ID: " + this.roomID +
				", room name: " + this.roomName;
	}
}
