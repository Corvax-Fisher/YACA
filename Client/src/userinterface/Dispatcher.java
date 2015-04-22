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
		mainView = new MainView();
		loginView = new LoginView(frontController);
		registerView = new RegisterView(frontController);
		profileView = new ProfileView(frontController);
		roomListView = new RoomListView(frontController);
		userListView = new UserListView(frontController);
	}

	public void dispatch(String request){
		
		if(request.equalsIgnoreCase("LOGIN")){
			mainView.getPnlHome().remove(registerView);
			mainView.getPnlHome().add(loginView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("REGISTER")){
			mainView.getPnlHome().remove(loginView);
			mainView.getPnlHome().add(registerView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("PROFILE")){
			mainView.add(profileView, BorderLayout.CENTER);
		}
		else if(request.equalsIgnoreCase("ROOMLIST")){
			mainView.getPnlHome().remove(loginView);
			mainView.getPnlHome().remove(registerView);
			mainView.getPnlHome().add(roomListView, BorderLayout.EAST);
			mainView.getPnlHome().add(userListView, BorderLayout.WEST);
		}
		else if(request.equalsIgnoreCase("USERLIST")){
			mainView.add(userListView);
		}
		else if(request.equalsIgnoreCase("CHAT")){
			String roomName = roomListView.getJoinedRoom();
			mainView.getTp().add(roomName, chatView = new ChatView(frontController, roomName));
			frontController.addChatView(roomName, chatView);
			///chatView.userList.add(userListView);

		}
		else if(request.equalsIgnoreCase("CLOSE")) {
			mainView.getTp().remove(mainView.getTp().getSelectedIndex());			
		}
		
		mainView.setVisible(true);
	}
	
}
