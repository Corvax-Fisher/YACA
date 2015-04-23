package delegate;

import connection.MessageTO;
import connection.ServerStub;

public class ServerServiceDelegate implements IServerServiceDelegate {
	//hier die TOs erstellen
	public ServerStub serverStub;
	
	public ServerServiceDelegate() {
		serverStub = new ServerStub();
	}
	
	@Override
	public void updateChat(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "updatechat", body));
	}
	
	@Override
	public void roomUserList(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "roomuserlist", body));
	}
	@Override
	public void updateUserList(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "updateuserlist", body));
	}
	
	@Override
	public void kick(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "kick", body));
	}
	
	@Override
	public void ban(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "ban", body));
	}
	
	@Override
	public void mute(String from, String to, String room) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "mute", null));
	}
	
	@Override
	public void userJoined(String user, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(user, to, room, "userjoined", body));
	}
	
	@Override
	public void userLeft(String user, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(user, to, room, "userleft", body));
	}

	@Override
	public void userLoggedIn(String to, String type, Object body) {
		serverStub.sendObject(to, new MessageTO(null, to, null, type, body));
	}

	@Override
	public void userLoggedOut(String user, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(user, to, room, "userloggedout", body));
	}

	@Override
	public void sendRoomList(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "sendroomlist", body));
	}

	@Override
	public void updateRoomList(String from, String to, String room, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, "updateroomlist", body));
		
	}
	
//	public void setServerStub(ServerStub serverStub) {
//		this.serverStub = serverStub;
//	}
	
	public ServerStub getServerStub() {
		return serverStub;
	}
	
}
