package service;

import java.util.List;

import connection.MessageTO;
import delegate.IServerServiceDelegate;

public class ChatService implements IChatService {
	
	private IServerServiceDelegate serverServiceDelegate = null;

	public ChatService(IServerServiceDelegate serverServiceDelegate) {
		
		this.serverServiceDelegate = serverServiceDelegate;
		
	}
	
	@Override
	public void sendMessage(MessageTO messageTO, List<String> userList) {
		//An alle in der Liste durchgehen und nachricht schicken
		for (String to : userList) {
			serverServiceDelegate.updateChat(messageTO.getFrom(), to, messageTO.getRoom(), "updatechat", messageTO.getBody());
		}
	}
	
	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		//ueberpruefung ob Raum vorhanden, und User enthalten sinnvoll?
		serverServiceDelegate.updateChat(messageTO.getFrom(), messageTO.getTo(), messageTO.getRoom(), "updatechat", messageTO.getBody());
	}
	
	@Override
	public void sendFile(MessageTO messageTO) {
		//an alle oder nur einen?
		if(messageTO.getTo() == null) {
			serverServiceDelegate.updateChat(messageTO.getFrom(),null,messageTO.getRoom(), "sendfile",messageTO.getBody());
		}else {
			serverServiceDelegate.updateChat(messageTO.getFrom(),messageTO.getTo(),messageTO.getRoom(), "updatechat",messageTO.getBody());
		}
	}
	
	@Override
	public boolean updateChat(MessageTO messageTO) {
		//Was macht man hier?
		return false;
	}

}
