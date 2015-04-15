package database;

import database.json.JSONDAOFactory;
import database.sql.SQLDAOFactory;

public abstract class AbstractDAOFactory {
	private static JSONDAOFactory j = null;
	private static SQLDAOFactory s = null;
	
	public static AbstractDAOFactory getDAOFactory(String factoryName) {
		switch (factoryName) {
			case "JSON": 
				if(j == null) j = new JSONDAOFactory();
				return j;
			case "SQL": 
				if(s == null) s = new SQLDAOFactory();
				return s;
			default:
				if(s == null) s = new SQLDAOFactory();
				return s;
		}
	}
	
	public abstract UserDAO createUserDAO();
	public abstract RoomDAO createRoomDAO();
	public abstract RoleDAO createRoleDAO();
}
