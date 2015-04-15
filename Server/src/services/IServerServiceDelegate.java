package services;

public interface IServerServiceDelegate {

	public void updateChat(String from, String to, String room, String type, Object body);

	public void updateUserList(String from, String to, String room, String type, Object body);

	public void kick();

	public void ban();

	public void mute();

	public void userJoined();

	public void userLeft();
	
	public void userLoggedIn(String from, String to, String room, String type, Object body);
	
	public void sendRoomList(String from, String to, String room, String type, Object body);
	
	public void updateRoomList(String from, String to, String room, String type, Object body);

}