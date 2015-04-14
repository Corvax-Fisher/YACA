package services;

import java.util.List;

import database.AbstractDAOFactory;
import database.RoomDAO;
import database.RoomPAO;
import transferObjects.MessageTO;

public class RoomService implements IRoomService {
	
	
	public List<Room> room = null;
	
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	private RoomDAO roomDAO = null;
	private List<RoomPAO> roomPAO = null;
	
	public RoomService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
				
		//DAO Factory erstellen
		abstractDAOFactory.getDAOFactory("SQL");		
		//RoomDAO erstellen
		roomDAO = abstractDAOFactory.createRoomDAO();
		//Raumliste fuellen
		roomPAO.addAll(roomDAO.getAllRooms());
		
		//Muessen alle gepeicherten RoomPAOs in die List<Room> room eingetragen werden?
			
	}
		
	@Override
	public boolean ban(MessageTO messageTO) {
	}
	
	@Override
	public boolean kick(MessageTO messageTO) {
	}
	
	@Override
	public boolean mute(MessageTO messageTO) {
	}
	
	@Override
	public boolean joinRoom(MessageTO messageTO) {
		String userName = messageTO.getFrom();
		String roomName = messageTO.getRoom();
		//Check ob Room in der Datenbank da ist
		for (RoomPAO roomPAOtemp : roomPAO) {
			if (roomPAOtemp.getRoomName().equals(roomName)) {
				//Room vorhanden. Suche nach Room in der Liste. User in Userliste des Rooms eintragen
				for(Room roomtemp : room) {
					if (roomtemp.getName().equals(roomName)) {
						roomtemp.addUser(userName);
					}
				
				//Dann die geupdatete Userliste an alle im Raum verschicken...
				updateUserList(roomtemp);
				return true;
				}
			}
		}
		//Room noch nicht da:
		//neuen Room erstellen... wie sieht es hier mit Berechtigung aus, darf jeder einen Room erstellen?
		//wie werden die IDs von Rooms erstellt? Random Nr.? Oder gibt es fuer die Sichbarkeit IDS?
		
		
//		Boolean abbruch = false;
//		int randomIDNr;
//		do {
//			randomIDNr = (int) ((Math.random()*100)+1);
//			//Check ob idnr dann schon vergeben...
//			for (RoomPAO roomPAOtemp : roomPAO) {
//				if (roomPAOtemp.getRoomID() == randomIDNr) {
//					abbruch = false;
//				}
//			}abbruch = true;
//		} while (!abbruch);
//		
		
		//Room erstellen
		//user einfuegen
		roomDAO.insertRoom(new RoomPAO(randomIDNr,roomName));
		Room room = new Room(roomName);
		room.addUser(userName);
		updateUserList(room);
		return true;
		
		//Return false? wenn was schief geht? oder Raum Groesse ueberschritten?
		
	}

	@Override
	public boolean leaveRoom(MessageTO messageTO) {
	
	}

	@Override
	public List<String> getUserList(MessageTO messageTO) {
	}
	
	@Override
	public void updateUserList(Room room) {
		List<String> userList = null;
		userList.addAll(room.getUserList());
		String strUserList = userList.toString();
		serverServiceDelegate.updateUserList(null,null,room.getName(),"updateUserList", strUserList);
	}

}
