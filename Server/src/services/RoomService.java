package services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.AbstractDAOFactory;
import database.RoomDAO;
import database.RoomPAO;
import transferObjects.LoginTO;
import transferObjects.MessageTO;

public class RoomService implements IRoomService {
	
	
	private HashMap<String, Room> roomlist = new HashMap<String, Room>();
	
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	private RoomDAO roomDAO = null;
	private List<RoomPAO> roomPAO = new ArrayList<RoomPAO>();
	
	public RoomService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
				
		//DAO Factory erstellen
		abstractDAOFactory.getDAOFactory("SQL");		
		//RoomDAO erstellen
		roomDAO = abstractDAOFactory.createRoomDAO();
		//Raumliste fuellen
		roomPAO.addAll(roomDAO.getAllRooms());
		
		// roomListe füllen
		for (RoomPAO roomPAOtemp : roomPAO) {
			roomlist.put(roomPAOtemp.getRoomName(),new Room(roomPAOtemp.getRoomName()));
		}		
	}
		
	@Override
	public void ban(MessageTO messageTO) {
	}
	
	@Override
	public void kick(MessageTO messageTO) {
	}
	
	@Override
	public void mute(MessageTO messageTO) {
	}
	
	@Override
	public void joinRoom(MessageTO messageTO) {
		Room room = roomlist.get(messageTO.getRoom());
		//Check ob Room in der Datenbank da ist
		if(room!=null) {
			//Ja, also User einfügen
			room.addUser(messageTO.getFrom());
			//Dann die geupdatete Userliste an alle im Raum verschicken...
			updateUserList(room);
		}else {
			//Room erstellen
			//user einfuegen
			room = new Room(messageTO.getRoom());
			roomlist.put(messageTO.getRoom(), room);
			room.addUser(messageTO.getFrom());
			//RoomListe bei allen aktualisieren
			
			updateRoomList();
			
			//userListe beim user aktualisieren
			updateUserList(room);
			
				
		}
		//Return false? wenn was schief geht? oder Raum Groesse ueberschritten?
		
	}

	@Override
	public void leaveRoom(MessageTO messageTO) {
		Room room = roomlist.get(messageTO.getRoom());
		room.removeUser(messageTO.getFrom());
		updateUserList(room);
	}

	@Override
	public void getUserList(MessageTO messageTO) {
		
	}
	

	@Override
	public void updateRoomList() {
		
		serverServiceDelegate.updateRoomList(null, null, null, "updateRoomList", getAllRooms());		
	}

	@Override
	public void getRoomList(LoginTO loginTO) {
		
		serverServiceDelegate.sendRoomList(null, loginTO.getName(), null, "getroomlist", getAllRooms());
	}
	
	
	public List<String> getAllRooms(){
		//Hashmap iterieren um alle name von rooms zu bekommen um als liste zu schicken( kleiner als ganze hashmap)
		List<String> rooms = new ArrayList<String>();
		for (Map.Entry<String, Room> entry : roomlist.entrySet()) {
			rooms.add(entry.getKey());
		}
		return rooms;
	}
	
	@Override
	public void updateUserList(Room room) {
		List<String> userList = new ArrayList<String>();
		
		//getUserList gibt was List oder arraylist? problem?
		userList.addAll(room.getUserList());
		
		// hier durch user im room iterrieren und neue userliste schicken:
		for (String user : userList) {
		serverServiceDelegate.updateUserList(null, user, room.getName(), "updateuserlist", userList);
		}
	}
	
	

}
