package database.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import database.UserDAO;
import database.UserPAO;
import database.UserPAO.Builder;

public class SQLUserDAO implements UserDAO {

	@Override
	public UserPAO getUser(String name) {
		UserPAO users[];
		
		users = (UserPAO[]) SQLDB.execute(new SQLUserGetCommand(name));
		
		return users[0];
	}

	@Override
	public List<UserPAO> getAllUsers() {
		UserPAO users[] = (UserPAO[]) SQLDB.execute(new SQLUserGetAllCommand());

		return new ArrayList<UserPAO>(Arrays.asList(users));
	}

	@Override
	public boolean insertUser(UserPAO user) {		
		
		if( user.getUserName() == null || 
			user.getPassword() == null ||
			user.getRoleID() <= 0)
			return false;
		
		return SQLDB.execute(new SQLUserInsertCommand(user));
	}

	@Override
	public boolean updateUser(UserPAO user) {
		String updateStmntStr = "UPDATE Users SET ";
		String updateVarsStr = "";
		
		if(user.getUserName() == null) return false;
		
		if(user.getPassword() != null) updateVarsStr += "Password=?,";
		if(user.getRoleID() > 0) updateVarsStr += "RoleID=?,";
		if(user.getFullName() != null) updateVarsStr += "FullName=?,";
		if(user.getEMail() != null) updateVarsStr += "eMail=?,";
		
		if(updateVarsStr.length() == 0) return false;
		else {
			updateVarsStr = updateVarsStr.substring(0, updateVarsStr.length()-1);
			updateStmntStr += updateVarsStr + " WHERE UserName=?";
		}
		
		return SQLDB.execute(new SQLUserUpdateCommand(user, updateStmntStr));

	}

	@Override
	public boolean deleteUser(String name) {
		
		if(name == null) return false;
		
		return SQLDB.execute( new SQLUserDeleteCommand(name) );
	}
		
	private class SQLUserGetCommand implements SQLQueryCommand {
		
		private String name;
		
		public SQLUserGetCommand(String userName) {
			this.name = userName;
		}
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			UserPAO user[] = new UserPAO[1];
			String paramQuery = "SELECT * FROM Users WHERE UserName =?";
			
			PreparedStatement pstmnt;
			ResultSet rs;
			
			pstmnt = conn.prepareStatement(paramQuery);
			pstmnt.setString(1, name);
			rs = pstmnt.executeQuery();
			
			if ( rs.next() )
				user[0] = new UserPAO.Builder(	rs.getString("UserName"))
									.password(	rs.getString("Password"))
									.roleID(	rs.getInt("RoleID")		)
									.fullName(	rs.getString("FullName"))
									.eMail(		rs.getString("eMail")	)
									.build();
			
			return user;
		}
		
	}
	
	private class SQLUserGetAllCommand implements SQLQueryCommand {
		
		@Override
		public Object[] execute(Connection conn) throws SQLException {
			ArrayList<UserPAO> userList = new ArrayList<UserPAO>();
			UserPAO[] users = null;
			
			Statement stmnt;
			ResultSet rs;
			
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery("SELECT * FROM Users");
			
			while ( rs.next() )
			{
				userList.add( new UserPAO.Builder(	rs.getString("UserName"))
										.password(	rs.getString("Password"))
										.roleID(	rs.getInt("RoleID")		)
										.fullName(	rs.getString("FullName"))
										.eMail(		rs.getString("eMail")	)
										.build() );
			}
			
			users = new UserPAO[userList.size()];
			for(int i = 0; i < userList.size(); i++)
				users[i] = userList.get(i);
			
			return users;
		}
		
	}
	
	private class SQLUserInsertCommand implements SQLUpdateCommand {
		
		private UserPAO user;
		
		public SQLUserInsertCommand(UserPAO user) {
			this.user = user;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String insertStmntStr = "INSERT INTO Users VALUES(?,?,?,?,?)";
			PreparedStatement pstmnt;
			
			pstmnt = conn.prepareStatement(insertStmntStr);
			pstmnt.setString(1, user.getUserName());
			pstmnt.setString(2, user.getPassword());
			pstmnt.setInt(3, user.getRoleID());
			if(user.getFullName() != null) 
					pstmnt.setString(4, user.getFullName());
			else 	pstmnt.setNull(4, java.sql.Types.VARCHAR);
			if(user.getEMail() != null) 
					pstmnt.setString(5, user.getEMail());
			else 	pstmnt.setNull(5, java.sql.Types.VARCHAR);
			
			return pstmnt.executeUpdate();			
		}
		
	}

	private class SQLUserUpdateCommand implements SQLUpdateCommand {
		
		private UserPAO user;
		private String updateStmntStr;
		
		public SQLUserUpdateCommand(UserPAO user, String updateStmntStr) {
			this.user = user;
			this.updateStmntStr = updateStmntStr;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			PreparedStatement pstmnt;
			int i = 1;
			
			pstmnt = conn.prepareStatement(updateStmntStr);
			
			if(user.getPassword() 	!= null) 	pstmnt.setString(	i++, user.getPassword()	);
			if(user.getRoleID() 	> 0) 		pstmnt.setInt(		i++, user.getRoleID()	);
			if(user.getFullName() 	!= null) 	pstmnt.setString(	i++, user.getFullName()	);
			if(user.getEMail() 		!= null) 	pstmnt.setString(	i++, user.getEMail()	);
			pstmnt.setString(i, user.getUserName());
			
			return pstmnt.executeUpdate();
		}
		
	}

	private class SQLUserDeleteCommand implements SQLUpdateCommand {
		
		private String name;
		
		public SQLUserDeleteCommand(String name) {
			this.name = name;
		}

		@Override
		public int execute(Connection conn) throws SQLException {
			String deleteStmntStr = "DELETE FROM Users WHERE UserName=?";

			PreparedStatement pstmnt;			
			
			pstmnt = conn.prepareStatement(deleteStmntStr);
			pstmnt.setString(1, name);
			
			return pstmnt.executeUpdate();			
		}
		
	}
	
}
