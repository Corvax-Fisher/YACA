package userinterface;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;

public class Dispatcher {
	private MainView mainView;
	private LoginView loginView;
	private RegisterView registerView;
	private ProfileView profileView;
	private RoomListView roomListView;
	private UserListView userListView;
	private ChatView chatView;
	
	private HashMap<String, ChatView> activeRooms = new HashMap<String, ChatView>();
	
	private FrontController frontController;

	public Dispatcher(FrontController frontController){
		this.frontController = frontController;
		mainView = new MainView(frontController);
		loginView = new LoginView(frontController);
		registerView = new RegisterView(frontController);
		profileView = new ProfileView(frontController);
		roomListView = new RoomListView(frontController);
		userListView = new UserListView(frontController);
		
		mainView.setVisible(true);

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
			if (!activeRooms.containsKey(roomName)) {
				mainView.getTp().add(roomName, chatView = new ChatView(frontController, roomName));
				mainView.getTp().setSelectedIndex(mainView.getTp().getTabCount()-1);
				addChatView(roomName, chatView);
			}
			///chatView.userList.add(userListView);

		}
		else if(request.equalsIgnoreCase("LEAVE ROOM")) {
			int selectedIndex = mainView.getTp().getSelectedIndex();
			System.out.println("leaving room: "+ mainView.getTp().getTitleAt(selectedIndex));
			activeRooms.remove(mainView.getTp().getTitleAt(selectedIndex));
			mainView.getTp().remove(selectedIndex);
		}
		mainView.setVisible(true);
		
	}
	
	public void initRoomListView(List<String> roomList, String name) {
		for (String room : roomList) {
			roomListView.addRoom(room);
		}
		roomListView.setText(name);
	}
	
	public void showText(String text) {
		if(mainView.getPnlHome().getComponent(0) == registerView)
			registerView.setText(text);
		else if(mainView.getPnlHome().getComponent(0) == loginView)
			loginView.setText(text);
	}
	
	public void refreshUserList(String room, List<String> userList) {
		ChatView chatView = activeRooms.get(room);
		if(chatView != null) chatView.refreshUserList(userList);
	}

	public void updateChat(String from, String room, String msg) {
		ChatView chatView = activeRooms.get(room);
	    if(chatView != null) chatView.setText(msg);
	}
	
	private void addChatView(String roomName, ChatView chatView) {
		activeRooms.put(roomName, chatView);
	}

	public void refreshUserListView(List<String> userList) {
		userListView.clearUserList();
		if(!userList.isEmpty()) {
			for (String user : userList) {
				userListView.addUser(user);
			}	
		} else {
			userListView.addUser("Keiner im Raum");
		}		
	}
}
