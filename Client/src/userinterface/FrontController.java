package userinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import services.ClientServiceDelegate;
import transferObjects.MessageTO;

public class FrontController {
	
	private String name;
	
	private HashMap<String, ChatView> activeRooms = new HashMap<String, ChatView>();
	
	//private List<String> activeRooms = new ArrayList<String>();
	private Dispatcher dispatcher;
	private ClientServiceDelegate clientServiceDelegate;
	private Boolean isAuthenticUser = false;
	

	public FrontController(){
		dispatcher = new Dispatcher(this);
		clientServiceDelegate = new ClientServiceDelegate();
	}

	private boolean isAuthenticUser(){
		//System.out.println("User is authenticated successfully.");
		//if(isAuthenticUser)return true; else return false;
		return true;
	}

	private void trackRequest(String request){
		System.out.println("Page requested: " + request);
	}

	public void dispatchRequest(String request){
		//log each request
		trackRequest(request);

		//authenticate the user
		if(isAuthenticUser()){
			dispatcher.dispatch(request);
		}	
	}
	
	public void register(String name, String password, String email) {
		clientServiceDelegate.register(name, password, email);
		this.name = name;
	}
	
	public void logInGuest(String name) {
		clientServiceDelegate.logInGuest(name);
		this.name = name;
	}
	
	public void logIn(String name, String password) {
		clientServiceDelegate.logIn(name, password);		
		this.name = name;
	}
	
	public void getUserList(String room) {
		clientServiceDelegate.getUserList(name, room);
	}
	
	public void setText(String view, String text) {
		if (view.equals("loginView")) {
			dispatcher.loginView.setText(text);
		}else if(view.equals("registerView")) {
			dispatcher.registerView.setText(text);
		}
	}
	
	public void loggedIn(List<String> roomList, String type) {
		
		if(type.equals("loggedinasguest") || type.equals("registertrue") || type.equals("loggedin")) {
			isAuthenticUser=true;
			System.out.println("eingeloggt");
			dispatcher.roomListView.setText(name);
			for (String room : roomList) {
				dispatcher.roomListView.addRoom(room);
			}
			dispatchRequest("ROOMLIST");
		}
	}
	
	public void roomUserList(List<String> userList) {
		dispatcher.userListView.clearUserList();
		if(!userList.isEmpty()) {
			for (String user : userList) {
				dispatcher.userListView.addUser(user);
			}
		}else {
			dispatcher.userListView.addUser("Keiner im Raum");
		}
	}
	
	public void joinRoom(String room) {
		if (!activeRooms.containsKey(room)) {
		dispatchRequest("CHAT");
		clientServiceDelegate.joinRoom(name, room);
		} 
	}
	
	
	//User joine und room userList unterscheiden.
	public void userJoined(String from, String room, List<String> userList ) {
		if(activeRooms.containsKey(room)) {
			ChatView chatView = activeRooms.get(room);
			//LANGFORM NEUE LISTE ERSTELLEN
		chatView.clearUserList();
		for (String user : userList) {
			chatView.addUser(user);
		}
		    chatView.setText("\n" + from + " has joined");
		}
	}
	
	
	public void addChatView(String roomName, ChatView chatView) {
		activeRooms.put(roomName, chatView);
	}
	
	public void sendMessage(String msg, String room) {
		clientServiceDelegate.sendMessage(name, room, msg);
	}
	
	public void recieveMessage(String from, String room, String msg) {
		ChatView chatView = activeRooms.get(room);
		chatView.setText("\n" + from + ": " + msg);
	}
	
	public void leaveRoom(String room) {
		activeRooms.remove(room);
		dispatcher.dispatch("close");
		clientServiceDelegate.leaveRoom(name, room);
	}
	
	public void userLeft(String user, String room) {
		ChatView chatView = activeRooms.get(room);
		chatView.setText("\n" + user + ": " + "left");
	}
}
