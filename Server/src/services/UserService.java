package services;

import database.UserPAO.Builder;
import database.RolePAO;
import database.AbstractDAOFactory;
import database.RoleDAO;
import database.UserDAO;
import database.UserPAO;
import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;

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
	public void showProfile(MessageTO messageTO) {
		//Name von demjenigen dessen Profile ich sehen will in ein UserPAO. 
		//Aber wie lese ich die daten der PAO aus
		//userPAO = userDAO.getUser(messageTO.getTo());
		//Die role brauche ich auch
		//rolePAO = roleDAO.getRole();
		
		
		
	}
	
	@Override
	public void saveProfile(ProfileTO profileTO) {
		
	}
	
	@Override
	public void register(RegisterTO registerTO) {
		
	}
	
	@Override
	public boolean logIn(LoginTO loginTO) {
		userPAO = userDAO.getUser(loginTO.getName());
		//wenn user vorhanden,
		 if (userPAO != null){
			 //PaswortCheck
			 if (userPAO.getPassword()==loginTO.getPassword()) {
				 //passwort richtig
				 serverServiceDelegate.userLoggedIn(loginTO.getName(), null, null, "loggedin", null);
				 return true;
			 }
			 //passwort falsch
			 serverServiceDelegate.userLoggedIn(loginTO.getName(), null, null, "wrongpass", null);
			 return false;
		 }
		 // user gibt es nicht oder falsch geschrieben
		 serverServiceDelegate.userLoggedIn(loginTO.getName(), null, null, "wronguser", null);
		 return false;
	}
	
	@Override
	public void logInGuest(LoginTO loginTO) {
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
	public void logOut(MessageTO messageTO) {
		// TODO Auto-generated method stub
		
	}

}
