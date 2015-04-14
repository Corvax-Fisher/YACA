package database;

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
				if(j == null) j = new JSONDAOFactory();
				return j;
		}
	}
	
	public abstract UserDAO createUserDAO();
	public abstract RoomDAO createRoomDAO();
	public abstract RoleDAO createRoleDAO();
}
