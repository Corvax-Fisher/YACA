package services;

import transferObjects.MessageTO;

public class ServerServiceDelegate implements IServerServiceDelegate {
	//hier die TOs erstellen
	//private IServerStub serverStub = null;
	
	public ServerServiceDelegate() {

		//this.serverStub = serverStub;
		
	}
	
	@Override
	public void updateChat(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(new MessageTO(from, to, room, type, body));
	}
	
	@Override
	public void updateUserList(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(new MessageTO(from, to, room, type, body));
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
	public void userLoggedIn(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(new MessageTO(from, to, room, type, body));
	}

	@Override
	public void sendRoomList(String from, String to, String room, String type, Object body) {
		serverStub.sendObject(new MessageTO(from, to, room, type, body));
	}

	@Override
	public void updateRoomList(String from, String to, String room,	String type, Object body) {
		serverStub.sendObject(new MessageTO(from, to, room, type, body));
		
	}
	
	
}
