package userinterface;

import java.awt.BorderLayout;

public class Dispatcher {
	private MainView mainView;
	private LoginView loginView;
	private RegisterView registerView;
	private ProfileView profileView;
	private RoomListView roomListView;
	private UserListView userListView;
	private ChatView chatView;
	private FrontController frontController;

	public Dispatcher(FrontController frontController){
		this.frontController = frontController;
		mainView = new MainView(frontController);
		loginView = new LoginView(frontController);
		registerView = new RegisterView(frontController);
		profileView = new ProfileView(frontController);
		roomListView = new RoomListView(frontController);
		userListView = new UserListView(frontController);
		chatView = new ChatView(frontController);
	}

	public void dispatch(String request){
		
		if(request.equalsIgnoreCase("LOGIN")){
			mainView.pnlHome.add(loginView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("REGISTER")){
			mainView.pnlHome.add(registerView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("PROFILE")){
			mainView.add(profileView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("ROOMLIST")){
			mainView.privateRoom.setVisible(true);
			mainView.pnlHome.add(roomListView, BorderLayout.EAST);
		}
		else if(request.equalsIgnoreCase("USERLIST")){
			mainView.add(userListView);
		}
		else if(request.equalsIgnoreCase("CHAT")){
			mainView.pnlHome.add(chatView, BorderLayout.CENTER);
		}
		mainView.setVisible(true);
	}
}
