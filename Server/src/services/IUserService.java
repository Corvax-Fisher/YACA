package services;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;

public interface IUserService {

	public void showProfile(MessageTO messageTO);

	public void saveProfile(ProfileTO profileTO);

	public void register(RegisterTO registerTO);

	public boolean logIn(LoginTO loginTO);

	public boolean logInGuest(LoginTO loginTO);

	public void logOut(MessageTO messageTO);

}