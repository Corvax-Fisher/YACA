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
			messageTO.setTo(to);
			updateChat(messageTO);
		}
	}
	
	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		updateChat(messageTO);
	}
	
	@Override
	public void sendFile(MessageTO messageTO) {
		//an alle oder nur einen?
//		if(messageTO.getTo() == null) {
//			serverServiceDelegate.sendFile(messageTO.getFrom(),null,messageTO.getRoom(),messageTO.getBody());
//		}else {
//			serverServiceDelegate.sendFile(messageTO.getFrom(),messageTO.getTo(),messageTO.getRoom(),messageTO.getBody());
//		}
	}
	
	@Override
	public boolean updateChat(MessageTO messageTO) {
		serverServiceDelegate.updateChat(messageTO.getFrom(), messageTO.getTo(), messageTO.getRoom(), messageTO.getBody());
		return false;
	}

}
