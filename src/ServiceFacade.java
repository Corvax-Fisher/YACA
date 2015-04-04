import java.util.ArrayList;

import DataTransferObjects.*;

public class ServiceFacade implements IServiceFacade {

	private IChatService chatService = null;
	private IRoomService roomService = null;
	private IUserService userService = null;
	//private IServerServiceDelegate serverServiceDelegate = null;
	
	//ServerServiceDelegate hier notwendig? oder erst im ChatService
	public ServiceFacade(IChatService chatService, IRoomService roomService,
			IUserService userService, IServerServiceDelegate serverServiceDelegate) {
		this.chatService = chatService;
		this.roomService = roomService;
		this.userService = userService;
		//this.serverServiceDelegate = serverServiceDelegate;
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

	
	public boolean showProfile(String name) {
		return userService.showProfile(name); 
	}

	
	public boolean saveProfile(ProfileTO profilTO) {
		return userService.saveProfile(profilTO);
	}


	public boolean joinRoom(MessageTO messageTO) {
		return roomService.joinRoom(messageTO);
	}

	
	public boolean leaveRoom(MessageTO messageTO) {
		return roomService.leaveRoom(messageTO);
	}

	
	public ArrayList<String> getUserList(MessageTO messageTO) {
		return roomService.getUserList(messageTO);
	}

	
	public boolean updateChat(MessageTO messageTO) {
		return chatService.updateChat(messageTO);
	}
	
}
