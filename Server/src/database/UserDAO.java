package database;

import java.util.List;

public interface UserDAO {
	public UserPAO getUser(String name);
	public List<UserPAO> getAllUsers();
	public boolean insertUser(UserPAO user);
	public boolean updateUser(UserPAO user);
	public boolean deleteUser(String name);
}
