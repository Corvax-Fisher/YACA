package services;

import java.util.List;

import transferObjects.MessageTO;

public interface IChatService {

	public void sendMessage(MessageTO messageTO, List<String> userList);

	public void sendPrivateMessage(MessageTO messageTO);

	public void sendFile(MessageTO messageTO);

	public boolean updateChat(MessageTO messageTO);


}