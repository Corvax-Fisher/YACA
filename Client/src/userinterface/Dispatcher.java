package userinterface;

public class Dispatcher {
	private MainView mainView;
	private LoginView loginView;
	private RegisterView registerView;
	private ProfileView profileView;
	private RoomListView roomListView;
	private UserListView userListView;
	private ChatView chatView;

	public Dispatcher(){
		mainView = new MainView();
		loginView = new LoginView();
		registerView = new RegisterView();
		profileView = new ProfileView();
		roomListView = new RoomListView();
		userListView = new UserListView();
		chatView = new ChatView();
	}

	public void dispatch(String request){
		
		if(request.equalsIgnoreCase("LOGIN")){
			mainView.pnlHome.add(loginView);
		}
		else if(request.equalsIgnoreCase("REGISTER")){
			mainView.add(registerView);
		}
		else if(request.equalsIgnoreCase("PROFILE")){
			mainView.add(profileView);
		}
		else if(request.equalsIgnoreCase("ROOMLIST")){
			mainView.add(roomListView);
		}
		else if(request.equalsIgnoreCase("USERLIST")){
			mainView.add(userListView);
		}
		else if(request.equalsIgnoreCase("CHAT")){
			mainView.add(chatView);
		}
		mainView.setVisible(true);
	}
}
