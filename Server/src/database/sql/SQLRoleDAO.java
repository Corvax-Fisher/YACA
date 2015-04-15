package database.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import database.RoleDAO;
import database.RolePAO;

public class SQLRoleDAO implements RoleDAO {

	@Override
	public RolePAO getRole(int id) {
		RolePAO role[];
		
		role = (RolePAO[]) SQLDB.execute( new SQLRoleGetCommand(id) );
		
		return role[0];
	}

	@Override
	public List<RolePAO> getAllRoles() {
		RolePAO role[] = (RolePAO[]) SQLDB.execute( new SQLRoleGetAllCommand() );

		return new ArrayList<RolePAO>(Arrays.asList(role));
	}

	@Override
	public boolean insertRole(RolePAO role) {
		if( role == null ) return false;
		if( role.getRoleName() == null ||
			role.getRoleID() <= 0 )
			return false;
			
		return SQLDB.execute( new SQLRoleInsertCommand(role) );
	}

	@Override
	public boolean updateRole(RolePAO role) {
		if( role == null ) return false;
		if( role.getRoleName() == null ||
			role.getRoleID() <= 0 )
			return false;
		
		return SQLDB.execute( new SQLRoleUpdateCommand(role) );
	}

	@Override
	public boolean deleteRole(int id) {
		if( id <= 0 ) return false;
		
		return SQLDB.execute( new SQLRoleDeleteCommand(id) );
	}
	
	private class SQLRoleGetCommand implements SQLQueryCommand {
		
		private int roleId;
		
		public SQLRoleGetCommand(int roleId) {
			this.roleId = roleId;
		}
		
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			RolePAO role[] = new RolePAO[1];
			String paramQuery = "SELECT * FROM Roles WHERE ID =?";
			
			PreparedStatement pstmnt;
			ResultSet rs;
			
			pstmnt = conn.prepareStatement(paramQuery);
			pstmnt.setInt(1, this.roleId);
			rs = pstmnt.executeQuery();
			
			if ( rs.next() )
				role[0] = new RolePAO( rs.getInt("ID"), rs.getString("RoleName") );
			
			return role;
		}
		
	}
	
	private class SQLRoleGetAllCommand implements SQLQueryCommand {
		
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			ArrayList<RolePAO> roleList = new ArrayList<RolePAO>();
			RolePAO[] roles = null;
			
			Statement stmnt;
			ResultSet rs;
			
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery("SELECT * FROM Roles");
			
			while ( rs.next() )
			{
				roleList.add( new RolePAO( rs.getInt("ID"), rs.getString("RoleName") ) );
			}
			
			roles = new RolePAO[roleList.size()];
			for(int i = 0; i < roleList.size(); i++)
				roles[i] = roleList.get(i);
			
			return roles;
		}
		
	}
	
	private class SQLRoleInsertCommand implements SQLUpdateCommand {
		
		private RolePAO role;
		
		public SQLRoleInsertCommand(RolePAO role) {
			this.role = role;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String insertStmntStr = "INSERT INTO Roles VALUES(?,?)";
			PreparedStatement pstmnt;
			
			pstmnt = conn.prepareStatement(insertStmntStr);
			pstmnt.setInt(		1, role.getRoleID()		);
			pstmnt.setString(	2, role.getRoleName()	);
			
			return pstmnt.executeUpdate();			
		}
		
	}

	private class SQLRoleUpdateCommand implements SQLUpdateCommand {
		
		private RolePAO role;
		
		public SQLRoleUpdateCommand(RolePAO role) {
			this.role = role;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String updateStmntStr = "UPDATE Roles SET RoleName=? WHERE ID=?";
			PreparedStatement pstmnt;
			
			pstmnt = conn.prepareStatement(updateStmntStr);
			
			pstmnt.setString(	1, this.role.getRoleName()	);
			pstmnt.setInt(		2, this.role.getRoleID()	);
						
			return pstmnt.executeUpdate();			
		}
		
	}

	private class SQLRoleDeleteCommand implements SQLUpdateCommand {
		
		private int roleID;
		
		public SQLRoleDeleteCommand(int roleID) {
			this.roleID = roleID;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String deleteStmntStr = "DELETE FROM Roles WHERE ID=?";

			PreparedStatement pstmnt;			
			
			pstmnt = conn.prepareStatement(deleteStmntStr);
			pstmnt.setInt(1, this.roleID);
			
			return pstmnt.executeUpdate();			
		}
		
	}

}
