package services;

import java.util.ArrayList;
import java.util.List;

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
	//private RoleDAO roleDAO;
	private UserPAO userPAO;
	//private RolePAO rolePAO;
	
	private List<String> guestUserList = new ArrayList<String>();
	private IServerServiceDelegate serverServiceDelegate = null;
	private AbstractDAOFactory abstractDAOFactory = null;
	
	public UserService(IServerServiceDelegate serverServiceDelegate){
		this.serverServiceDelegate = serverServiceDelegate;
		//DAO Factory erstellen
		abstractDAOFactory = AbstractDAOFactory.getDAOFactory("SQL");
		//roleDAO = abstractDAOFactory.createRoleDAO();
		userDAO = abstractDAOFactory.createUserDAO();
		guestUserList.add("Alex");
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
		UserPAO newUser = new UserPAO.Builder(registerTO.getName())
										.password(registerTO.getPassword())
										.build();
		//ruckgabe
		if(userDAO.insertUser(newUser)) {
			 serverServiceDelegate.userLoggedIn(registerTO.getName(), "registertrue", null);
		} else {
			 serverServiceDelegate.userLoggedIn(registerTO.getName(), "registerfalse", null);
		}
	}
	
	@Override
	public boolean logIn(LoginTO loginTO, List<String> roomList) {
		userPAO = userDAO.getUser(loginTO.getName());
		//wenn user vorhanden,
		 if (userPAO != null){
			 //PaswortCheck
			 if (userPAO.getPassword()==loginTO.getPassword()) {
				 //passwort richtig
				 serverServiceDelegate.userLoggedIn(loginTO.getName(), "loggedin", roomList);
				 return true;
			 }
			 //passwort falsch
			 serverServiceDelegate.userLoggedIn(loginTO.getName(), "wrongpass", null);
			 return false;
		 }
		 // user gibt es nicht oder falsch geschrieben
		 serverServiceDelegate.userLoggedIn(loginTO.getName(), "wronguser", null);
		 return false;
	}
	
	@Override
	public boolean logInGuest(LoginTO loginTO, List<String> roomList) {
		String newGuestName = loginTO.getName();
		Boolean nameUsed = false;
		for (String name : guestUserList) {
			if(name.equalsIgnoreCase(newGuestName))nameUsed=true;
		}
		userPAO = userDAO.getUser(newGuestName);
		//wenn user name schon beutzt wird,
		 if (userPAO != null || nameUsed){
			 serverServiceDelegate.userLoggedIn(newGuestName, "usernameused", null);
			 return false;
		 } else {
			 guestUserList.add(newGuestName);
			 serverServiceDelegate.userLoggedIn(newGuestName, "loggedinasguest", roomList);
			 return true;
		 }
	}
	

	@Override
	public void logOut(MessageTO messageTO) {
		//WAS HIER NOCH		
	}
	
//	private boolean userInGuestUserList(String name) {
//		for (int i = 0; i < guestUserList.size(); i++) {
//			if (guestUserList.get(i).equals(name));
//			return true;
//		}
//		return false;
//	}

}
