package Server.src.connection;

public interface IUserService {

	public ProfileTO showProfile(MessageTO messageTO);

	public boolean saveProfile(ProfileTO profileTO);

	public boolean register(RegisterTO registerTO);

	public boolean logIn(LoginTO loginTO);

	public boolean logInGuest(LoginTO loginTO);

	public boolean logOut(String logOutTxt);

}