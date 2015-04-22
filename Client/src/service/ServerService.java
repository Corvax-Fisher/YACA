package service;
import connection.MessageTO;
import userinterface.FrontController;

public class ServerService {
	
	private static FrontController frontController;
	
	public ServerService (FrontController frontController) {
		this.frontController = frontController;
	}
	
	public void updateChat(MessageTO mto) {
		frontController.recieveMessage(mto.getFrom(), mto.getRoom(), (String)mto.getBody());
	}
	
	public void updateUserList(MessageTO mto) {
		
	}

	public void kick() {
		
	}
	
	public void ban() {
		
	}
	
	public void mute() {
		
	}
	
	public void userJoined(MessageTO mTo) {
		frontController.userJoined(mTo.getFrom(), mTo.getRoom(),(List<String>) mTo.getBody());		
	}
	
	public void userLeft(MessageTO mTo) {
		frontController.userLeft(mTo.getFrom(), mTo.getRoom());
	}
	
	public void logInError(MessageTO mTo) {
		if(mTo.getType().equals("wrongpass")) {
			frontController.setText("loginView", "wrong password");

		}else if (mTo.getType().equals("wronguser")) {
			frontController.setText("loginView", "username not in database");
		}else
			frontController.setText("loginView", "username used");
			frontController.setText("registerView", "username used");
	}
	
	public void loggedIn(MessageTO mTo) {
		frontController.loggedIn((List<String>)mTo.getBody(), mTo.getType());
	}
	
	public void roomUserList(MessageTO mTo) {
		frontController.roomUserList((List<String>)mTo.getBody());
	}
	
	
}
