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
	public boolean logIn(String ip,LoginTO loginTO) {
		List<String> roomList = roomService.getAllRooms();
		serverServiceDelegate.getServerStub().addUser(loginTO.getName(), ip);
		if (loginTO.getType() == "login") {
			if(userService.logIn(loginTO, roomList)) {
				//roomService.getRoomList(loginTO);
				return true;
			} else {
				//serverServiceDelegate.getServerStub().removeUser(loginTO.getName());
				return false;
			}
		}else {
			if(userService.logInGuest(loginTO, roomList)) {
				//roomService.getRoomList(loginTO);
				return true;
			}else {
				//serverServiceDelegate.getServerStub().removeUser(loginTO.getName());
				return false;
			}
		}
	}
	@Override	
	public void logOut(MessageTO messageTO) {
		roomService.logOut(messageTO.getFrom());
		serverServiceDelegate.getServerStub().removeUser(messageTO.getFrom());
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
		//userliste vom raum fuer message holen und an chatservice uebergeben
		chatService.sendMessage(messageTO, roomService.getUserList(messageTO));
	}

	@Override
	public void sendPrivateMessage(MessageTO messageTO) {
		chatService.sendPrivateMessage(messageTO);
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
		serverServiceDelegate.updateUserList(null, messageTO.getFrom(), messageTO.getRoom(), "getuserlist", roomService.getUserList(messageTO));
	}

	@Override
	public void updateChat(MessageTO messageTO) {
		chatService.updateChat(messageTO);
	}
	
	
}
