package Server.src.services;

public interface IServerServiceDelegate {

	public void updateChat(String from, String to, String room, String type, String body);

	public void updateUserList(String from, String to, String room, String type, String body);

	public void kick();

	public void ban();

	public void mute();

	public void userJoined();

	public void userLeft();

}