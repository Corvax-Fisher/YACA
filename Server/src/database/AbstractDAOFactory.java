package database;

public abstract class AbstractDAOFactory {
	JSONDAOFactory j = null;
	SQLDAOFactory s = null;
	
	public AbstractDAOFactory getDAOFactory(String factoryName) {
		switch (factoryName) {
			case "JSON": 
				if(!j) j = new JSONDAOFactory();
				return j
			case "SQL": 
				if(!s) s = SQLDAOFactory();
				return s;
		}
	}
	
	public abstract UserDAO createUserDAO();
	public abstract RoomDAO createRoomDAO();
	public abstract RoleDAO createRoleDAO();
}
