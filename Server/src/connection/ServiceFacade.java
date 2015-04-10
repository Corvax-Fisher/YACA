package Server.src.connection;
import java.util.List;


public class ServiceFacade implements IServiceFacade {

	private IChatService chatService = null;
	private IRoomService roomService = null;
	private IUserService userService = null;
	private IServerServiceDelegate serverServiceDelegate = null;
	
	//ServerServiceDelegate hier notwendig? oder erst im ChatService
	public ServiceFacade(IChatService chatService, IRoomService roomService,
			IUserService userService, IServerServiceDelegate serverServiceDelegate) {
		this.chatService = chatService(serverServiceDelegate);
		this.roomService = roomService(serverServiceDelegate);
		this.userService = userService(serverServiceDelegate);
		this.serverServiceDelegate = serverServiceDelegate;
	}

	public boolean logIn(LoginTO loginTO) {
		return userService.logIn(loginTO); 
	}

	
	public boolean logInGuest(LoginTO loginTO) {
		return userService.logInGuest(loginTO); 
	}

	
	public boolean logOut(String logOutTxt) {
		return userService.logOut(logOutTxt); 
	}

	
	public boolean register(RegisterTO registerTO) {
		return userService.register(registerTO); 
	}

	
	public boolean kick(MessageTO messageTO) {
		return roomService.kick(messageTO);
	}

	
	public boolean ban(MessageTO messageTO) {
		return roomService.ban(messageTO);
	}

	
	public boolean mute(MessageTO messageTO) {
		return roomService.mute(messageTO);
	}


	public boolean sendMessage(MessageTO messageTO) {
		return chatService.sendMessage(messageTO);
	}

	
	public boolean sendPrivateMessage(MessageTO messageTO) {
		return chatService.sendPrivateMessage(messageTO);
	}

	
	public boolean sendFile(MessageTO messageTO) {
		return chatService.kick(messageTO);
	}

	
	public ProfileTO showProfile(MessageTO messageTO) {
		return userService.showProfile(messageTO); 
	}

	
	public boolean saveProfile(ProfileTO profileTO) {
		return userService.saveProfile(profileTO);
	}


	public boolean joinRoom(MessageTO messageTO) {
		return roomService.joinRoom(messageTO);
	}

	
	public boolean leaveRoom(MessageTO messageTO) {
		return roomService.leaveRoom(messageTO);
	}

	
	public List<String> getUserList(MessageTO messageTO) {
		return roomService.getUserList(messageTO);
	}

	
	public boolean updateChat(MessageTO messageTO) {
		return chatService.updateChat(messageTO);
	}
	
}
