package database.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class SQLDB {
	
	static boolean execute(SQLUpdateCommand cmd) {
		Connection conn = connect();
		PreparedStatement pstmnt = null;
		ResultSet rs = null;
		
		int res = -1;
		boolean ex = false;
		
		if(conn != null) {
			try {				
				res = cmd.execute(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				ex = true;
			} finally {
				releaseResourcesAndDisconnect(conn, rs, pstmnt);
			}
		} else return false;
		
		if(res > 0 && ex == false) return true;
		else return false;
	}
	
	static Object[] execute(SQLQueryCommand cmd) {
		Object[] list = null;
		
		Connection conn = connect();
		PreparedStatement pstmnt = null;
		ResultSet rs = null;
		
		if(conn != null) {
			try {				
				list = cmd.execute(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				releaseResourcesAndDisconnect(conn, rs, pstmnt);
			}
		} 
		return list;
	}
		
	private static Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:file:db/db", "SA", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	private static void releaseResourcesAndDisconnect(Connection conn, ResultSet rs, Statement stmnt) {
		try {
			if (rs != null) rs.close();
			if (stmnt != null) stmnt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
