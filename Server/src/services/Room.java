package Server.src.services;

import java.util.List;

import Server.src.database.RoomPAO;

public class Room {
	
	public List<String> userList;
	public String name;
	
	
	public Room(String name) {
		this.name = name;
	}
	
	public List<String> getUserList(){
		return userList;
	}
	
	public String getName() {
		return name;		
	}
	
		
	public boolean addUser(String user) {
		//try?
		if(userList.add(user)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void removeUser(String user) {
		userList.remove(user);
	}
}
