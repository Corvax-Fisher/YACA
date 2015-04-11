package Server.src.services;

import Server.src.transferObjects.MessageTO;

public class ChatService implements IChatService {
	
	private IServerServiceDelegate serverServiceDelegate = null;

	public ChatService(IServerServiceDelegate serverServiceDelegate) {
		
		this.serverServiceDelegate = serverServiceDelegate;
		
	}
	
	@Override
	public void sendMessage(MessageTO messageTO) {
		//Überprüfung ob Raum vorhanden, und User enthalten sinnvoll?
		serverServiceDelegate.updateChat(messageTO.getFrom(),null,messageTO.getRoom() ,"updateChat" ,messageTO.getBody());
	}
	
	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		//Überprüfung ob Raum vorhanden, und User enthalten sinnvoll?
		serverServiceDelegate.updateChat(messageTO.getFrom(),messageTO.getTo(),messageTO.getRoom(), "updateChat",messageTO.getBody());
	}
	
	@Override
	public void sendFile(MessageTO messageTO) {
		//an alle oder nur einen?
		if(messageTO.getTo() == null) {
			serverServiceDelegate.updateChat(messageTO.getFrom(),null,messageTO.getRoom(), "sendFile",messageTO.getBody());
		}else {
			serverServiceDelegate.updateChat(messageTO.getFrom(),messageTO.getTo(),messageTO.getRoom(), "updateChat",messageTO.getBody());
		}
	}
	
	@Override
	public boolean updateChat(MessageTO messageTO) {
		//Was macht man hier?
	}

}
