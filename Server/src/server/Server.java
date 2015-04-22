package server;

import javax.swing.JFrame;
import services.ClientSkeleton;
import services.ServiceFacade;
import database.*;

public class Server {

	private static ServiceFacade serviceFacade;
	private static ClientSkeleton clientSkeleton;
	
	
	public static void main(String[] args) {
		
		UserDAO userDAO = AbstractDAOFactory.getDAOFactory("SQL").createUserDAO();
		System.out.println("users:");
		System.out.println(userDAO.getAllUsers());
		
		RoleDAO roleDAO = AbstractDAOFactory.getDAOFactory("SQL").createRoleDAO();
		System.out.println("Roles:");
		System.out.println(roleDAO.getAllRoles());
		
		RoomDAO roomDAO = AbstractDAOFactory.getDAOFactory("SQL").createRoomDAO();
		System.out.println("rooms:");
		System.out.println(roomDAO.getAllRooms());
		
		JFrame frame = new JFrame("ChatServer");
    	frame.setLocation(200, 200);
    	frame.setSize(200, 200);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
		
		serviceFacade = new ServiceFacade();
		clientSkeleton = new ClientSkeleton(serviceFacade);
		clientSkeleton.start();
		
	}

}
