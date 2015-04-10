package Server.src.connection;

public interface IServerServiceDelegate {

	public void updateChat();

	public void updateUserList();

	public void kick();

	public void ban();

	public void mute();

	public void userJoined();

	public void userLeft();

}