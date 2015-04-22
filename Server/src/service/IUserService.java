package service;

import java.util.List;

import connection.LoginTO;
import connection.MessageTO;
import connection.ProfileTO;
import connection.RegisterTO;

public interface IUserService {
	
	public List<String> getUserList();

	public void showProfile(MessageTO messageTO);

	public void saveProfile(ProfileTO profileTO);

	public void register(RegisterTO registerTO);

	public boolean logIn(LoginTO loginTO, List<String> roomList);

	public boolean logInGuest(LoginTO loginTO, List<String> roomList);

	public void logOut(MessageTO messageTO);

}