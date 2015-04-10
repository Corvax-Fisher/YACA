package Server.src.connection;

public interface IChatService {

	public void sendMessage(MessageTO messageTO);

	public void sendPrivateMessage(MessageTO messageTO);

	public void sendFile(MessageTO messageTO);

	public void updateChat(MessageTO messageTO);

}