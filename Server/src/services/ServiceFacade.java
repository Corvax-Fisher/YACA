package Server.src.services;
import java.util.List;

import Server.src.transferObjects.LoginTO;
import Server.src.transferObjects.MessageTO;
import Server.src.transferObjects.ProfileTO;
import Server.src.transferObjects.RegisterTO;


public class ServiceFacade implements IServiceFacade {

	private IChatService chatService = null;
	private IRoomService roomService = null;
	private IUserService userService = null;
	private IServerServiceDelegate serverServiceDelegate = null;
	
	//ServerServiceDelegate hier notwendig? oder erst im ChatService
	//Haben so alle services das selbe serverServiceDelegate Object?
	public ServiceFacade() {
		this.chatService = new ChatService(serverServiceDelegate);
		this.roomService = new RoomService(serverServiceDelegate);
		this.userService = new UserService(serverServiceDelegate);
		this.serverServiceDelegate = serverServiceDelegate;
	}

	public String logIn(LoginTO loginTO) {
		return userService.logIn(loginTO); 
	}

	
	public String logInGuest(LoginTO loginTO) {
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
		return roomService.kick(messageTO);
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

	
	public void updateChat(MessageTO messageTO) {
		chatService.updateChat(messageTO);
	}
	
}
