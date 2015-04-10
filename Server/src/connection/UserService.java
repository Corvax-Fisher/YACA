package Server.src.connection;

import Server.src.database.AbstractDAOFactory;
import Server.src.database.RoleDAO;
import Server.src.database.UserDAO;
import Server.src.database.UserPAO;

public class UserService implements IUserService{
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	
	public UserService(IServerServiceDelegate serverServiceDelegate){
		this.serverServiceDelegate = serverServiceDelegate;
		//DAO Factory erstellen
		abstractDAOFactory.getDAOFactory("SQL");
		roleDAO = abstractDAOFactory.createRoleDAO();
		userDAO = abstractDAOFactory.createUserDAO();
	}
	
	@Override
	public ProfileTO showProfile(MessageTO messageTO) {
		//Name von demjenigen dessen Profile ich sehen will in ein UserPAO. 
		//Aber wie lese ich die daten der PAO aus
		UserPAO userPAO = userDAO.getUser(messageTO.getTo());
		//Die role brauche ich auch
		RolePAO rolePAO = roleDAO.getRole(userDAO.);
		
		return new ProfileTO()
		
	}
	
	@Override
	public boolean saveProfile(ProfileTO profileTO) {
		
	}
	
	@Override
	public boolean register(RegisterTO registerTO) {
		
	}
	
	@Override
	public boolean logIn(LoginTO loginTO) {
		//wenn user vorhanden,
		 if (userDAO.getUser(loginTO.getName()) != null){
			 //PaswortCheck
		 }
	}
	
	@Override
	public boolean logInGuest(LoginTO loginTO) {
		//wenn user name schon beutzt wird,
		 if (userDAO.getUser(loginTO.getName()) != null){
			 return false;
		 } else {
			 //insert Guest user
			 String userName = loginTO.getName();
			 UserPAO userPAO = new Builder()
			 userDAO.insertUser(new UserPAO(new Builder()
			 return true;
		 }
	}
	
	@Override
	public boolean logOut(String logOutTxt) {
		//User aus allen Räumen werfen? oder delet user
	}

}
