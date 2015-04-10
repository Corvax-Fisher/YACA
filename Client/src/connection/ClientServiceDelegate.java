package connection;
import java.util.List;

import sun.misc.resources.Messages_zh_TW;


public class ClientServiceDelegate implements IClientServiceDelegate {
	private ClientStub clientStub = null;
	

	public ClientServiceDelegate() {
		clientStub = new ClientStub(PORTFORSOCKETACCESS);
	}


	public boolean logIn(String name, String password) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new LoginTO(name, password, "logIn"));
		} else {
			return false;
		}
	}


	public boolean logInGuest(String name) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new LoginTO(name, null, "logInGuest"));
		} else {
			return false;
		}
	}

	// Log Out nur String übergabe? Server wird ja wissen von wem das logOut
	// geschickt wurde

	public boolean logOut() {
		clientStub.sendObject("logOut");
		return clientStub.disconnect();
	}


	public boolean register(String name, String password, String email) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new RegisterTO(name, password, email));
		} else {
			return false;
		}
	}


	public boolean kick(String from, String to, String room) {
		return clientStub
				.sendObject(new MessageTO(from, to, room, "kick", null));
	}


	public boolean ban(String from, String to, String room) {
		return clientStub
				.sendObject(new MessageTO(from, to, room, "ban", null));
	}


	public boolean mute(String from, String to, String room) {
		return clientStub
				.sendObject(new MessageTO(from, to, room, "mute", null));
	}


	public boolean sendMessage(String from,String room, String body) {
		return clientStub.sendObject(new MessageTO(from, null, room,
				"sendMessage", body));
	}


	public boolean sendPrivateMessage(String from, String to, String room,
			String body) {
		return clientStub.sendObject(new MessageTO(from, to, room,
				"sendPrivateMessage", body));
	}

	// FILE als String schicken (body) ? binäres casten....

	public boolean sendFile(String from, String to, String room, String body) {
		return clientStub.sendObject(new MessageTO(from, to, room, "sendFile",
				body));
	}

	// nur String übergabe?

	public ProfileTO showProfile(String from, String to) {
		return clientStub.sendObject(new MessageTO(from, to, null,"showProfile", null));
	}


	public boolean saveProfile(String name, String password, String email,
			String realName, String role) {
		return clientStub.sendObject(new ProfileTO(name, password, email,
				realName, role));
	}


	public boolean joinRoom(String name, String roomName) {
		return clientStub.sendObject(new MessageTO(name, null, roomName,
				"joinRoom", null));
	}


	public boolean leaveRoom(String name) {
		return clientStub.sendObject(new MessageTO(null, null, name,
				"leaveRoom", null));
	}
	
	//name notwendig um rechte zu prüfen ob man die userliste sehen darf?

	public List<String> getUserList(String roomName){
		return clientStub.sendObject(new MessageTO(null,null,roomName,"getUserList",null));
	}

}
