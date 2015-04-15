package services;
import java.util.List;

import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ProfileTO;
import transferObjects.RegisterTO;


public class ServiceFacade implements IServiceFacade {

	private IChatService chatService = null;
	private IRoomService roomService = null;
	private IUserService userService = null;
	private IServerServiceDelegate serverServiceDelegate = null;
	
	//ServerServiceDelegate hier notwendig? oder erst im ChatService
	//Haben so alle services das selbe serverServiceDelegate Object?
	public ServiceFacade() {
		this.serverServiceDelegate = new ServerServiceDelegate();
		this.chatService = new ChatService(serverServiceDelegate);
		this.roomService = new RoomService(serverServiceDelegate);
		this.userService = new UserService(serverServiceDelegate);
		
	}
	@Override
	public void logIn(LoginTO loginTO) {
		
		if (loginTO.getType() == "login") {
			if(userService.logIn(loginTO)) {
				roomService.getRoomList(loginTO);
			}
		}
		else userService.logInGuest(loginTO);
	}
	@Override	
	public void logOut(MessageTO messageTO) {
		return userService.logOut(messageTO); 
	}

	@Override
	public void register(RegisterTO registerTO) {
		userService.register(registerTO); 
	}

	@Override
	public void kick(MessageTO messageTO) {
		roomService.kick(messageTO);
	}

	@Override
	public void ban(MessageTO messageTO) {
		roomService.ban(messageTO);
	}

	@Override
	public void mute(MessageTO messageTO) {
		roomService.mute(messageTO);
	}

	@Override
	public void sendMessage(MessageTO messageTO) {
		chatService.sendMessage(messageTO);
	}

	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		return chatService.sendPrivateMessage(messageTO);
	}

	@Override
	public void sendFile(MessageTO messageTO) {
		roomService.kick(messageTO);
	}

	@Override
	public void showProfile(MessageTO messageTO) {
		userService.showProfile(messageTO); 
	}

	@Override
	public void saveProfile(ProfileTO profileTO) {
		userService.saveProfile(profileTO);
	}

	@Override
	public void joinRoom(MessageTO messageTO) {
		roomService.joinRoom(messageTO);
	}

	@Override
	public void leaveRoom(MessageTO messageTO) {
		roomService.leaveRoom(messageTO);
	}

	@Override
	public void getUserList(MessageTO messageTO) {
		roomService.getUserList(messageTO);
	}

	@Override
	public void updateChat(MessageTO messageTO) {
		chatService.updateChat(messageTO);
	}
	
	
}
