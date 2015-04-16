package services;

import transferObjects.MessageTO;
import transferObjects.ServerStub;

public class ServerServiceDelegate implements IServerServiceDelegate {
	//hier die TOs erstellen
	public ServerStub serverStub;
	
	
	public ServerServiceDelegate() {
		serverStub = new ServerStub();
		
	}
	
	@Override
	public void updateChat(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, type, body));
	}
	
	@Override
	public void updateUserList(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, type, body));
	}
	
	@Override
	public void kick() {
		
	}
	
	@Override
	public void ban() {
		
	}
	
	@Override
	public void mute() {
		
	}
	
	@Override
	public void userJoined() {
		
	}
	
	@Override
	public void userLeft() {
				
	}

	@Override
	public void userLoggedIn(String to, String type) {
		serverStub.sendObject(to, new MessageTO(null, to, null, type, null));
	}

	@Override
	public void sendRoomList(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, type, body));
	}

	@Override
	public void updateRoomList(String from, String to, String room,	String type, Object body) {
		serverStub.sendObject(to, new MessageTO(from, to, room, type, body));
		
	}
	
	
}
