package userinterface;

import java.util.HashMap;
import java.util.List;

import delegate.ClientServiceDelegate;

public class FrontController {
	
	private String name;
		
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
	
	// View Methods
	
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
	
	public void joinRoom(String room) {
		dispatchRequest("CHAT");
		clientServiceDelegate.joinRoom(name, room);
	}
	
	public void sendMessage(String msg, String room) {
		clientServiceDelegate.sendMessage(name, room, msg);
	}
	
	public void sendPrivateMessage(String to, String msg, String room) {
		clientServiceDelegate.sendPrivateMessage(name, to, room, msg);
	}
	
	public void leaveRoom(String room) {
		dispatchRequest("LEAVE ROOM");
		clientServiceDelegate.leaveRoom(name, room);
	}
	
	public void logOut() {
		clientServiceDelegate.logOut(name);
	}
	
	//Server Methods
	
	public void loggedIn(List<String> roomList, String type) {
		
		if(type.equals("loggedinasguest") || type.equals("registertrue") || type.equals("loggedin")) {
			isAuthenticUser=true;
			System.out.println("eingeloggt");
			
			dispatcher.initRoomListView(roomList, name);
			dispatchRequest("ROOMLIST");
		}
	}
	
	public void roomUserList(List<String> userList) {
		dispatcher.refreshUserListView(userList);
	}
	
	public void updateUserList(String room, List<String> userList) {
		dispatcher.refreshUserList(room, userList);
	}

	public void userJoined(String user, String room, List<String> userList ) {
		dispatcher.refreshUserList(room, userList);
		dispatcher.updateChat(user, room, user + " has joined\n");
	}
	
	public void updateChat(String from, String room, String msg) {
		dispatcher.updateChat(from, room, from + ": " + msg + "\n");
	}
	
	public void userLeft(String user, String room, List<String> userList) {
		dispatcher.refreshUserList(room, userList);
		dispatcher.updateChat(user, room, user + " has left the room\n");
	}

	public void userLoggedOut(String user, String room, List<String> userList) {
		dispatcher.refreshUserList(room, userList);
		dispatcher.updateChat(user, room, user + " has logged out\n");
	}
	
	public void showText(String text) {
		dispatcher.showText(text);
	}
	
}
