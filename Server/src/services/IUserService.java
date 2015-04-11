package Server.src.services;

import Server.src.transferObjects.LoginTO;
import Server.src.transferObjects.MessageTO;
import Server.src.transferObjects.ProfileTO;
import Server.src.transferObjects.RegisterTO;

public interface IUserService {

	public ProfileTO showProfile(MessageTO messageTO);

	public boolean saveProfile(ProfileTO profileTO);

	public boolean register(RegisterTO registerTO);

	public String logIn(LoginTO loginTO);

	public String logInGuest(LoginTO loginTO);

	public boolean logOut(String logOutTxt);

}