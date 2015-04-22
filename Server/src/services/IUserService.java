package services;

import java.util.List;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;

public interface IUserService {

	public void showProfile(MessageTO messageTO);

	public void saveProfile(ProfileTO profileTO);

	public void register(RegisterTO registerTO, List<String> roomList);

	public boolean logIn(LoginTO loginTO, List<String> roomList);

	public boolean logInGuest(LoginTO loginTO, List<String> roomList);

	public void logOut(MessageTO messageTO);

}