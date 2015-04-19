package userinterface;

import java.util.ArrayList;
import java.util.List;

import services.ClientServiceDelegate;
import transferObjects.MessageTO;

public class FrontController {
	
	private String name;
	private List<String> activeRooms = new ArrayList<String>();
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
	
	public void logInGuest(String name) {
		clientServiceDelegate.logInGuest(name);
		this.name = name;
	}
	
	public void logIn(String name, String password) {
		clientServiceDelegate.logIn(name, password);		
	}
	
	public void getUserList(String room) {
		clientServiceDelegate.getUserList(name, room);
	}
	
	public void setText(String view, String text) {
		if (view.equals("loginView")) {
		dispatcher.loginView.setText(text);
		}
	}
	
	public void loggedIn(MessageTO mTo) {
		List<String> roomList = new ArrayList<String>();
		roomList = (List<String>)mTo.getBody();
		if(mTo.getType().equals("loggedinasguest")) {
			isAuthenticUser=true;
			System.out.println("eingeloggt");
			dispatchRequest("ROOMLIST");
			
			if(!roomList.isEmpty()) {
				for (String room : roomList) {
					dispatcher.roomListView.addRoom(room);
				}
				
			}
		}
	}
	
	public void roomUserList(MessageTO mTo) {
		List<String> userList = new ArrayList<String>();
		userList = (List<String>)mTo.getBody();
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
		dispatchRequest("CHAT");
		clientServiceDelegate.joinRoom(name, room);
		activeRooms.add(room);
	}
	
	
	//User joine und room userList unterscheiden.
	public void userJoined(MessageTO mTo) {
		if(activeRooms.contains(mTo.getRoom())) {
			//KURZFORM NUR ADDEN
		
//			dispatcher.userListView.addUser(mTo.getFrom());
//			dispatcher.chatView.setText(mTo.getFrom() + "has joined");
//		}
			
			//LANGFORM NEUE LISTE ERSTELLEN
		List<String> userList = new ArrayList<String>();
		userList = (List<String>)mTo.getBody();
		dispatcher.userListView.clearUserList();
		for (String user : userList) {
			dispatcher.userListView.addUser(user);
		}
		dispatcher.chatView.setText(mTo.getFrom() + " has joined");
		}
	}
}
