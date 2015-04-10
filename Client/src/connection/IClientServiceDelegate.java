package connection;
import java.util.List;

public interface IClientServiceDelegate {
	public static final int PORTFORSOCKETACCESS = 9050;

	public boolean logIn(String name, String password);

	public boolean logInGuest(String name);

	// Log Out nur String übergabe? Server wird ja wissen von wem das logOut
	// geschickt wurde
	public boolean logOut();

	public boolean register(String name, String password, String email);

	public boolean kick(String from, String to, String room);

	public boolean ban(String from, String to, String room);

	public boolean mute(String from, String to, String room);

	public boolean sendMessage(String from, String to, String room,
			String body);

	public boolean sendPrivateMessage(String from, String to,
			String room, String body);

	// FILE als String schicken (body) ? binäres casten....
	public boolean sendFile(String from, String to, String room,
			String body);

	// nur String übergabe?
	public boolean showProfile(String name);

	public boolean saveProfile(String name, String password,
			String email, String realName, String role);

	public boolean joinRoom(String name, String roomName);

	public boolean leaveRoom(String name);

	//name notwendig um rechte zu prüfen ob man die userliste sehen darf
	public List<String> getUserList(String roomName);

}