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
	private Room room = null;
	
	public RoomService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
				
		//DAO Factory erstellen
		abstractDAOFactory.getDAOFactory("SQL");		
		//RoomDAO erstellen
		roomDAO = abstractDAOFactory.createRoomDAO();
		//Raumliste füllen
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
		
	}

	@Override
	public boolean leaveRoom(MessageTO messageTO) {
	
	}

	@Override
	public List<String> getUserList(MessageTO messageTO) {
	}
	
	@Override
	public void updateUserList() {
	}
}
