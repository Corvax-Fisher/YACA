package database;

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
