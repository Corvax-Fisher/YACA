package database;

import java.util.List;

public interface RoomDAO {
	public RoomPAO getRoom(int id);
	public List<RoomPAO> getAllRooms();
	public boolean insertRoom(RoomPAO room);
	public boolean updateRoom(RoomPAO room);
	public boolean deleteRoom(int id);
}
