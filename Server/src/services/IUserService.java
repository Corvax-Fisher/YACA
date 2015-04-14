package services;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;

public interface IUserService {

	public ProfileTO showProfile(MessageTO messageTO);

	public boolean saveProfile(ProfileTO profileTO);

	public boolean register(RegisterTO registerTO);

	public String logIn(LoginTO loginTO);

	public String logInGuest(LoginTO loginTO);

	public boolean logOut(String logOutTxt);

}