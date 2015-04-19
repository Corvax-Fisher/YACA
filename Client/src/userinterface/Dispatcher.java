package userinterface;

import java.awt.BorderLayout;

public class Dispatcher {
	public MainView mainView;
	public LoginView loginView;
	public RegisterView registerView;
	public ProfileView profileView;
	public RoomListView roomListView;
	public UserListView userListView;
	public ChatView chatView;
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
			mainView.pnlHome.remove(registerView);
			mainView.pnlHome.add(loginView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("REGISTER")){
			mainView.pnlHome.remove(loginView);
			mainView.pnlHome.add(registerView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("PROFILE")){
			mainView.add(profileView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("ROOMLIST")){
			mainView.pnlHome.remove(loginView);
			mainView.privateRoom.setVisible(true);
			mainView.pnlHome.add(roomListView, BorderLayout.EAST);
			mainView.pnlHome.add(userListView, BorderLayout.WEST);
		}
		else if(request.equalsIgnoreCase("USERLIST")){
			mainView.add(userListView);
		}
		else if(request.equalsIgnoreCase("CHAT")){
			mainView.pnlHome.add(chatView, BorderLayout.CENTER);
			mainView.pnlHome.remove(roomListView);
			mainView.pnlHome.add(userListView, BorderLayout.WEST);

		}
		mainView.setVisible(true);
	}
	
}
