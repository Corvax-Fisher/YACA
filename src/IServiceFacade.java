import java.util.ArrayList;

import DataTransferObjects.*;


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

	public boolean showProfile(String name);

	public boolean saveProfile(ProfileTO profilTO);

	public boolean joinRoom(MessageTO messageTO);

	public boolean leaveRoom(MessageTO messageTO);

	public ArrayList<String> getUserList(MessageTO messageTO);

	
	//Update Chat Rückgabewert? MessageTO?
	public boolean updateChat(MessageTO messageTO);

}
