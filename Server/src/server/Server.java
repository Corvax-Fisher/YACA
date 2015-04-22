package server;

import javax.swing.JFrame;

import connection.ClientSkeleton;
import database.*;
import delegate.ServiceFacade;

public class Server {

	private static ServiceFacade serviceFacade;
	private static ClientSkeleton clientSkeleton;
	
	
	public static void main(String[] args) {
		
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
