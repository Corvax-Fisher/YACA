package services;

import java.util.ArrayList;
import java.util.List;

import database.RoomPAO;

public class Room {
	
	private List<String> userList = new ArrayList<String>();
	private String name;
	
	
	public Room(String name) {
		this.name = name;
	}
	
	public List<String> getUserList(){
		return userList;
	}
	
	public String getName() {
		return name;		
	}
	
		
	public void addUser(String user) {
		//try?
		userList.add(user);
		
	}
	
	public boolean removeUser(String user) {
		if(userList.remove(user)) {
			return true;
		}else {
			return false;
		}
	}
}
