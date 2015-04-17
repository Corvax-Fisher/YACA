package client;

import services.ServerService;
import services.ServerSkeleton;
import userinterface.FrontController;


public class Client {
	
	private static FrontController frontController;
	private static ServerService serverService;
	private static ServerSkeleton serverSkeleton;
	
	public static void main(String[] args) {
		frontController = new FrontController();
		serverService = new ServerService(frontController);
		serverSkeleton = new ServerSkeleton(serverService);
		
		frontController.dispatchRequest("LOGIN");
		
		while (true) {
			
			
		}
	}
}
