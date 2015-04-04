package database;

import java.util.List;

public interface RoleDAO {
	public RolePAO getRole(int id);
	public List<RolePAO> getAllRoles();
	public boolean insertRole(RolePAO role);
	public boolean updateRole(RolePAO role);
	public boolean deleteRole(int id);
}
