package userinterface;

import java.util.ArrayList;
import java.util.List;

import services.ClientServiceDelegate;
import transferObjects.MessageTO;

public class FrontController {

	private Dispatcher dispatcher;
	private ClientServiceDelegate clientServiceDelegate;
	private Boolean isAuthenticUser = false;
	private List<String> roomList = new ArrayList<String>();

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
	}
	
	public void logIn(String name, String password) {
		clientServiceDelegate.logIn(name, password);		
	}
	
	public void setText(String view, String text) {
		if (view.equals("loginView")) {
		dispatcher.loginView.setText(text);
		}
	}
	
	public void loggedIn(MessageTO mTo) {
		
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
}
