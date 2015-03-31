package connection;
import java.util.ArrayList;


/*
public class ClientServiceDelegate {
	private ClientStub clientStub = null;
	private static final int PORTFORSOCKETACCESS = 9050;

	public ClientServiceDelegate() {
		clientStub = new ClientStub(PORTFORSOCKETACCESS);
	}

	public boolean logIn(String name, String password) {
		return clientStub.sendObject(new LoginTO(name, password, "logIn"));
	}

	public boolean logInGuest(String name) {
		return clientStub.sendObject(new LoginTO(name, null, "logInGuest"));
	}

	// Log Out nur String übergabe?
	public boolean logOut() {
		return clientStub.sendObject("logOut");
	}

	public boolean register(String name, String password, String email) {
		return clientStub.sendObject(new RegisterTO(name, password, email));
	}

	public boolean kick(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "kick", null));
	}

	public boolean ban(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "ban", null));
	}

	public boolean mute(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "mute", null));
	}

	public boolean sendMessage(String from, String to, String room, String body) {
		return clientStub.sendObject(new MessageTO(from, to, room,
				"sendMessage", body));
	}
	
	public boolean sendPrivateMessage(String from, String to, String room,
			String body) {
		return clientStub.sendObject(new MessageTO(from, to, room,
				"sendPrivateMessage", body));
	}
	
	//FILE als String schicken? binäres casten....
	public boolean sendFile(String from, String to, String room,
			String body) {
		return clientStub.sendObject(new MessageTO(from, to, room,
				"sendFile", body));		
	}

	// nur String übergabe?
	public boolean showProfile(String name) {
		return clientStub.sendObject(name);
	}

	public boolean saveProfile(String name, String password, String email,
			String realName, String role) {
		return clientStub.sendObject(new ProfileTO(name, password, email,
				realName, role));
	}
	
	//reicht name?
	public boolean joinRoom(String name) {
		return clientStub.sendObject(new MessageTO(null, null, name, "joinRoom", null));
	}
	
	public boolean leaveRoom(String name) {
		return clientStub.sendObject(new MessageTO(null, null, name, "leaveRoom", null));
	}
	
//	public ArrayList<String> getUserList(String roomName){
//		return 
//	}

}
*/