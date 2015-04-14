package services;

import transferObjects.MessageTO;

public interface IChatService {

	public void sendMessage(MessageTO messageTO);

	public void sendPrivateMessage(MessageTO messageTO);

	public void sendFile(MessageTO messageTO);

	public boolean updateChat(MessageTO messageTO);

}