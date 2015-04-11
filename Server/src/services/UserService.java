package Server.src.services;

import Server.src.database.UserPAO.Builder;
import Server.src.database.RolePAO;
import Server.src.database.AbstractDAOFactory;
import Server.src.database.RoleDAO;
import Server.src.database.UserDAO;
import Server.src.database.UserPAO;
import Server.src.transferObjects.LoginTO;
import Server.src.transferObjects.MessageTO;
import Server.src.transferObjects.ProfileTO;
import Server.src.transferObjects.RegisterTO;

public class UserService implements IUserService{
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private UserPAO userPAO;
	private RolePAO rolePAO;
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
		userPAO = userDAO.getUser(messageTO.getTo());
		//Die role brauche ich auch
		rolePAO = roleDAO.getRole();
		
		return new ProfileTO()
		
	}
	
	@Override
	public boolean saveProfile(ProfileTO profileTO) {
		
	}
	
	@Override
	public boolean register(RegisterTO registerTO) {
		
	}
	
	@Override
	public String logIn(LoginTO loginTO) {
		userPAO = userDAO.getUser(loginTO.getName());
		//wenn user vorhanden,
		 if (userPAO != null){
			 //PaswortCheck
			 if (userPAO.getPassword()==loginTO.getPassword()) {
				 //passwort richtig
				 return "logged in";
			 }
			 //passwort falsch
			 return "wrong password";
		 }
		 // user gibt es nicht oder falsch geschrieben
		 return "username unknown";
	}
	
	@Override
	public String logInGuest(LoginTO loginTO) {
		userPAO = userDAO.getUser(loginTO.getName());
		//wenn user name schon beutzt wird,
		 if (userPAO != null){
			 return "username unavailable";
		 } else {
			 //insert Guest user
			 //String userName = loginTO.getName();
			 Builder builder = new Builder(loginTO.getName());
			 //UserPAO newuserPAO;
			 //builder.build(newuserPAO);
			 return "logged in as guest";
		 }
	}
	
	@Override
	public boolean logOut(String logOutTxt) {
		//User aus allen Räumen werfen? oder delet user
	}

}
