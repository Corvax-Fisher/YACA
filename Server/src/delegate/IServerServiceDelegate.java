package delegate;

import java.util.List;

import connection.ServerStub;


public interface IServerServiceDelegate {

	public void updateChat(String from, String to, String room, Object body);

	public void roomUserList(String from, String to, String room, Object body);
	
	public void updateUserList(String from, String to, String room, Object body);

	public void kick(String user, String to, String room, Object body);

	public void ban(String user, String to, String room, Object body);

	public void mute(String user, String to, String room);

	public void userJoined(String user, String to, String room, Object body);

	public void userLeft(String user, String to, String room, Object body);
	
	public void userLoggedIn(String to, String type, Object body);
	
	public void userLoggedOut(String user, String to, String room, Object body);
	
	public void sendRoomList(String from, String to, String room, Object body);
	
	public void updateRoomList(String from, String to, String room, Object body);
	
//	public void setServerStub(ServerStub serverStub);
	
	public ServerStub getServerStub();

}