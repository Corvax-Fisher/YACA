package Server.src.connection;

public interface IUserService {

	public boolean showProfile(ProfileTO profileTO);

	public boolean saveProfile(ProfileTO profileTO);

	public boolean register(RegisterTO registerTO);

	public boolean logIn(LoginTO loginTO);

	public boolean logInGuest(LoginTO loginTO);

	public boolean logOut(String logOutTxt);

}