package database.sql;

import database.AbstractDAOFactory;
import database.RoleDAO;
import database.RoomDAO;
import database.UserDAO;

public class SQLDAOFactory extends AbstractDAOFactory {

	@Override
	public UserDAO createUserDAO() {
		return new SQLUserDAO();
	}

	@Override
	public RoomDAO createRoomDAO() {
		return new SQLRoomDAO();
	}

	@Override
	public RoleDAO createRoleDAO() {
		return new SQLRoleDAO();
	}

}
