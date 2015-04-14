package services;
import java.util.List;

import transferObjects.ProfileTO;

public interface IClientServiceDelegate {
	public static final int PORTFORSOCKETACCESS = 9050;

	public String logIn(String name, String password);

	public String logInGuest(String name);

	// Log Out nur String uebergabe? Server wird ja wissen von wem das logOut
	// geschickt wurde
	public boolean logOut(String from);

	public boolean register(String name, String password, String email);

	public boolean kick(String from, String to, String room);

	public boolean ban(String from, String to, String room);

	public boolean mute(String from, String to, String room);

	public boolean sendMessage(String from, String room, String body);

	public boolean sendPrivateMessage(String from, String to, String room, String body);
	// FILE als String schicken (body) ? binaeres casten....
	public boolean sendFile(String from, String to, String room, String body);
	// nur String uebergabe?
	public ProfileTO showProfile(String from, String to);

	public boolean saveProfile(String name, String password, String email, String realName, String role);

	public boolean joinRoom(String name, String roomName);

	public boolean leaveRoom(String name);
	//name notwendig um rechte zu pruefen ob man die userliste sehen darf
	public List<String> getUserList(String roomName);

}