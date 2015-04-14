package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLRoomDAO implements RoomDAO {

	@Override
	public RoomPAO getRoom(int id) {
		RoomPAO room[];
		
		room = (RoomPAO[]) SQLDB.execute( new SQLRoomGetCommand(id) );
		
		return room[0];
	}

	@Override
	public List<RoomPAO> getAllRooms() {
		RoomPAO room[] = (RoomPAO[]) SQLDB.execute( new SQLRoomGetAllCommand() );

		return new ArrayList<RoomPAO>(Arrays.asList(room));
	}

	@Override
	public boolean insertRoom(RoomPAO room) {
		if( room == null ) return false;
		if( room.getRoomName() == null ||
			room.getRoomID() <= 0 )
			return false;
			
		return SQLDB.execute( new SQLRoomInsertCommand(room) );
	}

	@Override
	public boolean updateRoom(RoomPAO room) {
		if( room == null ) return false;
		if( room.getRoomName() == null ||
			room.getRoomID() <= 0 )
			return false;
		
		return SQLDB.execute( new SQLRoomUpdateCommand(room) );
	}

	@Override
	public boolean deleteRoom(int id) {
		if( id <= 0 ) return false;
		
		return SQLDB.execute( new SQLRoomDeleteCommand(id) );
	}
	
	private class SQLRoomGetCommand implements SQLQueryCommand {
		
		private int roomId;
		
		public SQLRoomGetCommand(int roomId) {
			this.roomId = roomId;
		}
		
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			RoomPAO room[] = new RoomPAO[1];
			String paramQuery = "SELECT * FROM Rooms WHERE ID =?";
			
			PreparedStatement pstmnt;
			ResultSet rs;
			
			pstmnt = conn.prepareStatement(paramQuery);
			pstmnt.setInt(1, this.roomId);
			rs = pstmnt.executeQuery();
			
			if ( rs.next() )
				room[0] = new RoomPAO( rs.getInt("ID"), rs.getString("RoomName") );
			
			return room;
		}
		
	}
	
	private class SQLRoomGetAllCommand implements SQLQueryCommand {
		
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			ArrayList<RoomPAO> roomList = new ArrayList<RoomPAO>();
			RoomPAO[] rooms = null;
			
			Statement stmnt;
			ResultSet rs;
			
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery("SELECT * FROM Rooms");
			
			while ( rs.next() )
			{
				roomList.add( new RoomPAO( rs.getInt("ID"), rs.getString("RoomName") ) );
			}
			
			rooms = new RoomPAO[roomList.size()];
			for(int i = 0; i < roomList.size(); i++)
				rooms[i] = roomList.get(i);
			
			return rooms;
		}
		
	}
	
	private class SQLRoomInsertCommand implements SQLUpdateCommand {
		
		private RoomPAO room;
		
		public SQLRoomInsertCommand(RoomPAO room) {
			this.room = room;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String insertStmntStr = "INSERT INTO Rooms VALUES(?,?)";
			PreparedStatement pstmnt;
			
			pstmnt = conn.prepareStatement(insertStmntStr);
			pstmnt.setInt(		1, room.getRoomID()		);
			pstmnt.setString(	2, room.getRoomName()	);
			
			return pstmnt.executeUpdate();			
		}
		
	}

	private class SQLRoomUpdateCommand implements SQLUpdateCommand {
		
		private RoomPAO room;
		
		public SQLRoomUpdateCommand(RoomPAO room) {
			this.room = room;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String updateStmntStr = "UPDATE Rooms SET RoomName=? WHERE ID=?";
			PreparedStatement pstmnt;
			
			pstmnt = conn.prepareStatement(updateStmntStr);
			
			pstmnt.setString(	1, this.room.getRoomName()	);
			pstmnt.setInt(		2, this.room.getRoomID()	);
						
			return pstmnt.executeUpdate();			
		}
		
	}

	private class SQLRoomDeleteCommand implements SQLUpdateCommand {
		
		private int roomID;
		
		public SQLRoomDeleteCommand(int roomID) {
			this.roomID = roomID;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String deleteStmntStr = "DELETE FROM Rooms WHERE ID=?";

			PreparedStatement pstmnt;			
			
			pstmnt = conn.prepareStatement(deleteStmntStr);
			pstmnt.setInt(1, this.roomID);
			
			return pstmnt.executeUpdate();			
		}
		
	}

}
