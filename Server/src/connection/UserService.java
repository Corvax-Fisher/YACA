package Server.src.connection;

public class UserService implements IUserService{
	
	private IUserDAO userDAO;
	private IRoleDAO roleDAO;
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	public UserService(IServerServiceDelegate serverServiceDelegate, AbstractDAOFactory abstractDAOFactory){
		this.serverServiceDelegate = serverServiceDelegate;
		this.abstractDAOFactory = abstractDAOFactory;
	}
	
	@Override
	public boolean showProfile(ProfileTO profileTO) {
		
	}
	
	@Override
	public boolean saveProfile(ProfileTO profileTO) {
		
	}
	
	@Override
	public boolean register(RegisterTO registerTO) {
		
	}
	
	@Override
	public boolean logIn(LoginTO loginTO) {
		 
	}
	
	@Override
	public boolean logInGuest(LoginTO loginTO) {
		
	}
	
	@Override
	public boolean logOut(String logOutTxt) {
		
	}

}
