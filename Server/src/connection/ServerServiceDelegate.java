package Server.src.connection;

public class ServerServiceDelegate implements IServerServiceDelegate {
	
	private IServerStub serverStub = null;
	
	public ServerServiceDelegate(IServerStub serverStub) {

		this.serverStub = serverStub;
		
	}
	
	@Override
	public void updateChat() {
		
	}
	
	@Override
	public void updateUserList() {
		
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
