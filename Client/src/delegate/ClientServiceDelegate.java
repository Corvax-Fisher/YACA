package delegate;
import connection.ClientStub;
import connection.LoginTO;
import connection.MessageTO;
import connection.RegisterTO;


public class ClientServiceDelegate implements IClientServiceDelegate {
	
	private ClientStub clientStub = null;

	public ClientServiceDelegate() {
		clientStub = new ClientStub("localhost");
	}

	@Override
	public void logIn(String name, String password) {
		if (clientStub.connect()) {
			clientStub.sendObject(new LoginTO(name, password, "login"));
		} else {
			System.out.println("Cant Connect");
		}
	}

	@Override
	public void logInGuest(String name) {
		if (clientStub.connect()) {
			clientStub.sendObject(new LoginTO(name, "", "loginguest"));
		} else {
			System.out.println("Cant Connect");
		}
	}
	
	@Override
	public void logOut(String from) {
		clientStub.sendObject(new MessageTO(from, null, null, "logout", null));
	}

	@Override
	public void register(String name, String password, String email) {
		if (clientStub.connect()) {
			clientStub.sendObject(new RegisterTO(name, password, email));
		} else {
			System.out.println("Cant Connect");
		}
	}

	@Override
	public void kick(String from, String to, String room) {
//		return clientStub.sendObject(new MessageTO(from, to, room, "kick", null));
	}

	@Override
	public void ban(String from, String to, String room) {
//		return clientStub.sendObject(new MessageTO(from, to, room, "ban", null));
	}

	@Override
	public void mute(String from, String to, String room) {
//		return clientStub.sendObject(new MessageTO(from, to, room, "mute", null));
	}

	@Override
	public void sendMessage(String from, String room, Object body) {
		clientStub.sendObject(new MessageTO(from, null, room, "message", body));
	}

	@Override
	public void sendPrivateMessage(String from, String to, String room, Object body) {
//		return clientStub.sendObject(new MessageTO(from, to, room, "sendPrivateMessage", body));
	}
	// FILE als String schicken (body) ? binaeres casten....
	@Override
	public void sendFile(String from, String to, String room, Object body) {
//		return clientStub.sendObject(new MessageTO(from, to, room, "sendFile", body));
	}
	// nur String uebergabe?
	@Override
	public void showProfile(String from, String to) {
//		return clientStub.sendObject(new MessageTO(from, to, null,"showProfile", null));
	}

	@Override
	public void saveProfile(String name, String password, String email, String realName, String role) {
//		return clientStub.sendObject(new ProfileTO(name, password, email, realName, role));
	}

	@Override
	public void joinRoom(String from, String roomName) {
		clientStub.sendObject(new MessageTO(from, null, roomName, "joinroom", null));
	}

	@Override
	public void leaveRoom(String from, String roomName) {
		clientStub.sendObject(new MessageTO(from, null, roomName, "leaveroom", null));
	}

	@Override
	public void getUserList(String name, String roomName){
		clientStub.sendObject(new MessageTO(name,null,roomName,"getuserlist",null));
	}
}
