package services;
import java.util.List;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;


public interface IServiceFacade {

	public boolean logIn(String ip, LoginTO loginTO);

	//public void logInGuest(LoginTO loginTO);

	public void logOut(MessageTO messageTO);

	public void register(RegisterTO registerTO);

	public void kick(MessageTO messageTO);

	public void ban(MessageTO messageTO);

	public void mute(MessageTO messageTO);

	public void sendMessage(MessageTO messageTO);

	public void sendPrivateMessage(MessageTO messageTO);

	public void sendFile(MessageTO messageTO);

	public void showProfile(MessageTO messageTO);

	public void saveProfile(ProfileTO profilTO);

	public void joinRoom(MessageTO messageTO);

	public void leaveRoom(MessageTO messageTO);

	public void getUserList(MessageTO messageTO);
	
	public void updateChat(MessageTO messageTO);

}
