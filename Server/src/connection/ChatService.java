package Server.src.connection;

public class ChatService implements IChatService {
	
	private IServerServiceDelegate serverServiceDelegate = null;

	public ChatService(IServerServiceDelegate serverServiceDelegate) {
		this.serverServiceDelegate = serverServiceDelegate;
		
	}
	
	@Override
	public void sendMessage(MessageTO messageTO) {
		//serverServiceDelegate.updateChat(new MessageTO(messageTO.getFrom(),"all",messageTO.getRoom()));
		
	}
	
	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		
	}
	
	@Override
	public void sendFile(MessageTO messageTO) {
		
	}
	
	@Override
	public void updateChat(MessageTO messageTO) {
		
	}

}
