package Server.src.services;
import java.util.List;

import Server.src.transferObjects.LoginTO;
import Server.src.transferObjects.MessageTO;
import Server.src.transferObjects.ProfileTO;
import Server.src.transferObjects.RegisterTO;


public interface IServiceFacade {

	public String logIn(LoginTO loginTO);

	public String logInGuest(LoginTO loginTO);

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
	public void updateChat(MessageTO messageTO);

}
