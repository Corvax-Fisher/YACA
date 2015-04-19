package services;
import transferObjects.*;
import userinterface.FrontController;

public class ServerService {
	
	private static FrontController frontController;
	
	public ServerService (FrontController frontController) {
		this.frontController = frontController;
	}
	
	public void updateChat(MessageTO mto) {
		
	}
	
	public void updateUserList(MessageTO mto) {
		
	}

	public void kick() {
		
	}
	
	public void ban() {
		
	}
	
	public void mute() {
		
	}
	
	public void userJoined() {
				
	}
	
	public void userLeft() {
		
	}
	
	public void logInError(MessageTO mTo) {
		if (mTo.getType().equals("usernameused")) {
			frontController.setText("loginView", "username used");
		}
		
	}
	
	public void loggedIn(MessageTO mTo) {
		frontController.loggedIn(mTo);
	}
	
	public void roomUserList(MessageTO mTo) {
		frontController.roomUserList(mTo);
	}
	
	
}
