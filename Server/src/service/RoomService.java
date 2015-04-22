package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import connection.LoginTO;
import connection.MessageTO;
import database.AbstractDAOFactory;
import database.RoomDAO;
import database.RoomPAO;
import delegate.IServerServiceDelegate;

public class RoomService implements IRoomService {
	
	private HashMap<String, Room> roomlist = new HashMap<String, Room>();
	
	private IServerServiceDelegate serverServiceDelegate;
	private RoomDAO roomDAO;
	private List<RoomPAO> roomPAO = new ArrayList<RoomPAO>();
	
	public RoomService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
	
		//RoomDAO erstellen
		roomDAO = AbstractDAOFactory.getDAOFactory("SQL").createRoomDAO();
		//Raumliste fuellen
		roomPAO.addAll(roomDAO.getAllRooms());
		
		// roomListe füllen
		for (RoomPAO roomPAOtemp : roomPAO) {
			roomlist.put(roomPAOtemp.getRoomName(),new Room(roomPAOtemp.getRoomName()));
		}
		
		// testUser einfuegen
		Room room = roomlist.get("Wetter");
		room.addUser("Alex");
		//room.addUser("Basti");

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
	public void joinRoom(MessageTO messageTO, List<String> userList) {
		Room room = roomlist.get(messageTO.getRoom());
		//Check ob Room in der Datenbank da ist
		if(room == null) {
			//Room erstellen
			room = new Room(messageTO.getRoom());
			roomlist.put(messageTO.getRoom(), room);
			//user einfuegen
			//RoomListe bei allen aktualisieren
//			updateRoomList(userList);
			//userListe beim user aktualisieren
		}
		room.addUser(messageTO.getFrom());
		
		List<String> userListCopy = new ArrayList<String>(room.getUserList());
		// hier durch user im room iterrieren und neue userliste schicken:
		for (String user : userListCopy) {
			serverServiceDelegate.userJoined(messageTO.getFrom(), user, room.getName(), userListCopy);
		}
		//Return false? wenn was schief geht? oder Raum Groesse ueberschritten?
		
	}

	@Override
	public void leaveRoom(MessageTO messageTO) {
		Room room = roomlist.get(messageTO.getRoom());
		room.removeUser(messageTO.getFrom());
		
		List<String> userListCopy = new ArrayList<String>(room.getUserList());
		// hier durch user im room iterrieren und neue userliste schicken:
		for (String user : userListCopy) {
			serverServiceDelegate.userLeft(messageTO.getFrom(), user, room.getName(), userListCopy);
		}	
	}

	@Override
	public List<String> getUserList(MessageTO messageTO) {
		return roomlist.get(messageTO.getRoom()).getUserList();	
	}
	
	public void fetchUserList(MessageTO mto) {
		List<String> userListCopy = new ArrayList<String>(getUserList(mto));
		serverServiceDelegate.roomUserList(mto.getFrom(), mto.getFrom(), mto.getRoom(), userListCopy);
	}

	@Override
	public void updateRoomList(List<String> userList) {
		for(String user : userList)
			serverServiceDelegate.updateRoomList(null, user, null, getAllRooms());
	}

//	@Override
//	public void getRoomList(LoginTO loginTO) {
//		serverServiceDelegate.sendRoomList(null, loginTO.getName(), null, getAllRooms());
//	}
	
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
	public void updateUserList(String from, String type, Room room) {
		List<String> userList = new ArrayList<String>(room.getUserList());
		// hier durch user im room iterrieren und neue userliste schicken:
		for (String user : userList) {
			serverServiceDelegate.updateUserList(from, user, room.getName(), userList);
		}
	}
	
	public void logOut(String user) {
		for (Map.Entry<String, Room> entry : roomlist.entrySet()) {
			//den jeweiligen Raum rausholen
			Room room = roomlist.get(entry.getKey());
			//user rauswerfen, falls vorhanden
			//und falls vorhanden die userliste in dem raum updaten
			if(room.removeUser(user)) {
				List<String> userList = new ArrayList<String>(room.getUserList());
				// hier durch user im room iterrieren und neue userliste schicken:
				for (String aUser : userList)
					serverServiceDelegate.userLoggedOut(user, aUser, room.getName(), userList);
			}
		}
	}
	
}
