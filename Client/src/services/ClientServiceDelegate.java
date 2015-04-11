package Client.src.services;
import java.util.List;

import Client.src.transferObjects.LoginTO;
import Client.src.transferObjects.MessageTO;
import Client.src.transferObjects.ProfileTO;
import Client.src.transferObjects.RegisterTO;
import sun.misc.resources.Messages_zh_TW;


public class ClientServiceDelegate implements IClientServiceDelegate {
	
	private ClientStub clientStub = null;

	public ClientServiceDelegate() {
		clientStub = new ClientStub(PORTFORSOCKETACCESS);
	}

	@Override
	public String logIn(String name, String password) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new LoginTO(name, password, "logIn"));
		} else {
			return "can not connect";
		}
	}

	@Override
	public String logInGuest(String name) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new LoginTO(name, null, "logInGuest"));
		} else {
			return "can not connect";
		}
	}
	// Log Out nur String übergabe? Server wird ja wissen von wem das logOut
	// geschickt wurde
	@Override
	public boolean logOut(String from) {
		clientStub.sendObject(new MessageTO(from, null, null, "logOut", null));
		return clientStub.disconnect();
	}

	@Override
	public boolean register(String name, String password, String email) {
		if (clientStub.connect()) {
			return clientStub.sendObject(new RegisterTO(name, password, email));
		} else {
			return false;
		}
	}

	@Override
	public boolean kick(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "kick", null));
	}

	@Override
	public boolean ban(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "ban", null));
	}

	@Override
	public boolean mute(String from, String to, String room) {
		return clientStub.sendObject(new MessageTO(from, to, room, "mute", null));
	}

	@Override
	public boolean sendMessage(String from, String room, String body) {
		return clientStub.sendObject(new MessageTO(from, null, room, "sendMessage", body));
	}

	@Override
	public boolean sendPrivateMessage(String from, String to, String room, String body) {
		return clientStub.sendObject(new MessageTO(from, to, room, "sendPrivateMessage", body));
	}
	// FILE als String schicken (body) ? binäres casten....
	@Override
	public boolean sendFile(String from, String to, String room, String body) {
		return clientStub.sendObject(new MessageTO(from, to, room, "sendFile", body));
	}
	// nur String übergabe?
	@Override
	public ProfileTO showProfile(String from, String to) {
		return clientStub.sendObject(new MessageTO(from, to, null,"showProfile", null));
	}

	@Override
	public boolean saveProfile(String name, String password, String email, String realName, String role) {
		return clientStub.sendObject(new ProfileTO(name, password, email, realName, role));
	}

	@Override
	public boolean joinRoom(String name, String roomName) {
		return clientStub.sendObject(new MessageTO(name, null, roomName, "joinRoom", null));
	}

	@Override
	public boolean leaveRoom(String name) {
		return clientStub.sendObject(new MessageTO(null, null, name, "leaveRoom", null));
	}
	//name notwendig um rechte zu prüfen ob man die userliste sehen darf?
	@Override
	public List<String> getUserList(String roomName){
		return clientStub.sendObject(new MessageTO(null,null,roomName,"getUserList",null));
	}
}
