package services;
import java.util.List;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;


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
	
	//Update Chat Rueckgabewert? MessageTO?
	public void updateChat(MessageTO messageTO);

}
