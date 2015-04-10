package Server.src.connection;

import java.util.List;

import Server.src.database.AbstractDAOFactory;
import Server.src.database.RoomDAO;
import Server.src.database.RoomPAO;

public class RoomService implements IRoomService {
	
	public  List<RoomPAO> roomPAO;
	
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	private RoomDAO roomDAO = null;
	
	public RoomService(IServerServiceDelegate serverServiceDelegate, AbstractDAOFactory abstractDAOFactory,
			RoomDAO roomDAO) {
		this.serverServiceDelegate = serverServiceDelegate;
		this.abstractDAOFactory = abstractDAOFactory;
		this.roomDAO = roomDAO;
		
		//DAO Factory erstellen
		abstractDAOFactory.getDAOFactory("SQL");		
		//RoomDAO erstellen
		this.roomDAO = abstractDAOFactory.createRoomDAO();
		//Raumliste f�llen
		roomPAO.addAll(roomDAO.getAllRooms());
			
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
		for (int i = 0; i < roomPAO.size(); i++) {
		
			if (roomDAO.getRoom(i) == messageTO.getRoom()) {
				
			}
				
		}
	}

	@Override
	public boolean leaveRoom(MessageTO messageTO) {
		for (Room temp_room : room) {
			if (temp_room.getName() == messageTO.getRoom()) {
				if(temp_room.addUser(messageTO.getFrom())) {
					return true;
				}
			} 
		}
		return false;
	}

	@Override
	public List<String> getUserList(MessageTO messageTO) {
	}
	
	@Override
	public void updateUserList() {
	}
}
