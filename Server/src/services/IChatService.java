package Server.src.services;

import Server.src.transferObjects.MessageTO;

public interface IChatService {

	public void sendMessage(MessageTO messageTO);

	public void sendPrivateMessage(MessageTO messageTO);

	public void sendFile(MessageTO messageTO);

	public void updateChat(MessageTO messageTO);

}