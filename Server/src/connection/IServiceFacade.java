package Server.src.connection;
import java.util.List;


public interface IServiceFacade {

	public boolean logIn(LoginTO loginTO);

	public boolean logInGuest(LoginTO loginTO);

	public boolean logOut(String logOutTxt);

	public boolean register(RegisterTO registerTO);

	public boolean kick(MessageTO messageTO);

	public boolean ban(MessageTO messageTO);

	public boolean mute(MessageTO messageTO);

	public boolean sendMessage(MessageTO messageTO);

	public boolean sendPrivateMessage(MessageTO messageTO);

	public boolean sendFile(MessageTO messageTO);

	public ProfileTO showProfile(MessageTO messageTO);

	public boolean saveProfile(ProfileTO profilTO);

	public boolean joinRoom(MessageTO messageTO);

	public boolean leaveRoom(MessageTO messageTO);

	public List<String> getUserList(MessageTO messageTO);

	
	//Update Chat Rückgabewert? MessageTO?
	public boolean updateChat(MessageTO messageTO);

}
