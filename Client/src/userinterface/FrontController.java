package userinterface;

import services.ClientServiceDelegate;

public class FrontController {

	private Dispatcher dispatcher;
	private ClientServiceDelegate clientServiceDelegate;

	public FrontController(){
		dispatcher = new Dispatcher(this);
		clientServiceDelegate = new ClientServiceDelegate();
	}

	private boolean isAuthenticUser(){
		System.out.println("User is authenticated successfully.");
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
}
