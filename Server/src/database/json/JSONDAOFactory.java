package database.json;

import database.AbstractDAOFactory;
import database.RoleDAO;
import database.RoomDAO;
import database.UserDAO;

public class JSONDAOFactory extends AbstractDAOFactory {

	@Override
	public UserDAO createUserDAO() {
		return new JSONUserDAO();
	}

	@Override
	public RoomDAO createRoomDAO() {
		return new JSONRoomDAO();
	}

	@Override
	public RoleDAO createRoleDAO() {
		return new JSONRoleDAO();
	}

}
