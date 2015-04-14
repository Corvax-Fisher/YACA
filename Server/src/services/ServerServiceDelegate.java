package services;

public class ServerServiceDelegate implements IServerServiceDelegate {
	//hier die TOs erstellen
	private IServerStub serverStub = null;
	
	public ServerServiceDelegate(IServerStub serverStub) {

		this.serverStub = serverStub;
		
	}
	
	@Override
	public void updateChat(String from, String to, String room, String type, String body) {
		
	}
	
	@Override
	public void updateUserList(String from, String to, String room, String type, String body) {
		
	}
	
	@Override
	public void kick() {
		
	}
	
	@Override
	public void ban() {
		
	}
	
	@Override
	public void mute() {
		
	}
	
	@Override
	public void userJoined() {
		
	}
	
	@Override
	public void userLeft() {
				
	}
	
}
