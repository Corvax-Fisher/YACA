package services;

import java.util.ArrayList;
import java.util.List;

import database.RoomPAO;

public class Room {
	
	public List<String> userList = new ArrayList<String>();
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
