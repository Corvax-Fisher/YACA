package server;

import javax.swing.JFrame;
import services.ClientSkeleton;
import services.ServiceFacade;
import database.*;

public class Server {

	private static ServiceFacade serviceFacade;
	private static ClientSkeleton clientSkeleton;
	
	
	public static void main(String[] args) {
		// UserDAO Test
		System.out.println("UserDAO Test:");
		UserDAO u = AbstractDAOFactory.getDAOFactory("SQL").createUserDAO();
		System.out.println(	u.insertUser(new UserPAO.Builder("TestUser")
										.password("pw")
										.roleID(1)
										.build())
							);
		System.out.println(	u.updateUser(new UserPAO.Builder("TestUser")
										.fullName("TestRealName")
										.build())
							);
		System.out.println(u.getAllUsers());
		System.out.println(u.getUser("Testuser"));
		System.out.println(u.deleteUser("TestUser"));
		System.out.println(u.getAllUsers());
		
		// RoleDAO Test
		System.out.println("RoleDAO Test:");
		RoleDAO r = AbstractDAOFactory.getDAOFactory("SQL").createRoleDAO();
		System.out.println(r.insertRole(new RolePAO(3,"moderator")));
		System.out.println(r.getRole(3));
		System.out.println(r.updateRole(new RolePAO(3,"updatedModerator")));
		System.out.println(r.getAllRoles());
		System.out.println(r.getRole(5));
		System.out.println(r.deleteRole(3));
		System.out.println(r.getAllRoles());
		
		// RoleDAO Test
		System.out.println("RoomDAO Test:");
		RoomDAO ro = AbstractDAOFactory.getDAOFactory("SQL").createRoomDAO();
		System.out.println(ro.insertRoom(new RoomPAO(21,"new room")));
		System.out.println(ro.getRoom(21));
		System.out.println(ro.updateRoom(new RoomPAO(21,"new room name")));
		System.out.println(ro.getAllRooms());
		System.out.println(ro.getRoom(55));
		System.out.println(ro.deleteRoom(21));
		System.out.println(ro.getAllRooms());
		
		JFrame frame = new JFrame("ChatServer");
    	frame.setLocation(200, 200);
    	frame.setSize(200, 200);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
		
		serviceFacade = new ServiceFacade();
		clientSkeleton = new ClientSkeleton(serviceFacade);
		clientSkeleton.start();
		
		while (true) {
			
			
		}
	}

}
