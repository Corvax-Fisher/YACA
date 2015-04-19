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
	
	private IServerServiceDelegate serverServiceDelegate;
	private AbstractDAOFactory abstractDAOFactory;
	private RoomDAO roomDAO;
	private List<RoomPAO> roomPAO = new ArrayList<RoomPAO>();
	
	public RoomService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
				
		//DAO Factory erstellen
		abstractDAOFactory = AbstractDAOFactory.getDAOFactory("SQL");
		//abstractDAOFactory.getDAOFactory("SQL");		
		//RoomDAO erstellen
		roomDAO = abstractDAOFactory.createRoomDAO();
		//Raumliste fuellen
		roomPAO.addAll(roomDAO.getAllRooms());
		
		// roomListe füllen
		for (RoomPAO roomPAOtemp : roomPAO) {
			roomlist.put(roomPAOtemp.getRoomName(),new Room(roomPAOtemp.getRoomName()));
		}
		
		// testUser einfuegen
		Room room = roomlist.get("Wetter");
		room.addUser("Alex");
		room.addUser("Basti");

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
			updateUserList(messageTO.getFrom(),"userjoined",room);
		}else {
			//Room erstellen
			//user einfuegen
			room = new Room(messageTO.getRoom());
			roomlist.put(messageTO.getRoom(), room);
			room.addUser(messageTO.getFrom());
			//RoomListe bei allen aktualisieren
			updateRoomList();
			//userListe beim user aktualisieren
			updateUserList(messageTO.getFrom(),"userjoinednewroom",room);
		}
		//Return false? wenn was schief geht? oder Raum Groesse ueberschritten?
		
	}

	@Override
	public void leaveRoom(MessageTO messageTO) {
		Room room = roomlist.get(messageTO.getRoom());
		room.removeUser(messageTO.getFrom());
		updateUserList(messageTO.getFrom(),"userleft",room);
	}

	@Override
	public List<String> getUserList(MessageTO messageTO) {
		
		return roomlist.get(messageTO.getRoom()).getUserList();	
		
	}
	

	@Override
	public void updateRoomList() {
		//durch alle Raume gehen
		for (Map.Entry<String, Room> entry : roomlist.entrySet()) {
			//den jeweiligen Raum rausholen
			Room room = roomlist.get(entry.getKey());
			//eine userliste erstellen, mit der raum userliste füllen
			List<String> userList = new ArrayList<String>();
			userList.addAll(room.getUserList());
			//durch userliste gehen und jedem einzelnen über raumupdate informieren
			for (int i = 0; i < userList.size(); i++) {
				serverServiceDelegate.updateRoomList(null, userList.get(i), null, "updateroomlist", getAllRooms());
			}
		}
	}

	@Override
	public void getRoomList(LoginTO loginTO) {
		serverServiceDelegate.sendRoomList(null, loginTO.getName(), null, "getroomlist", getAllRooms());
	}
	
	@Override
	public List<String> getAllRooms(){
		//Hashmap iterieren um alle name von rooms zu bekommen um als liste zu schicken( kleiner als ganze hashmap)
		List<String> rooms = new ArrayList<String>();
		for (Map.Entry<String, Room> entry : roomlist.entrySet()) {
			rooms.add(entry.getKey());
		}
		return rooms;
	}
	
	@Override
	public void updateUserList(String userConcerns, String type, Room room) {
		List<String> userList = new ArrayList<String>();
		//getUserList gibt was List oder arraylist? problem?
		userList.addAll(room.getUserList());
		// hier durch user im room iterrieren und neue userliste schicken:
		for (String user : userList) {
		serverServiceDelegate.updateUserList(userConcerns, user, room.getName(), type, userList);
		}
	}
	
	public void logOut(String user) {
		for (Map.Entry<String, Room> entry : roomlist.entrySet()) {
			//den jeweiligen Raum rausholen
			Room room = roomlist.get(entry.getKey());
			//user rauswerfen, falls vorhanden
			//und falls vorhanden die userliste in dem raum updaten
			if(room.removeUser(user)) {
				updateUserList(user, "userleft", room);
			}
		}
	}
	

}
