package services;

import java.util.List;

import transferObjects.LoginTO;
import transferObjects.MessageTO;

public interface IRoomService {

	public void ban(MessageTO messageTO);

	public void kick(MessageTO messageTO);

	public void mute(MessageTO messageTO);

	public void joinRoom(MessageTO messageTO);

	public void leaveRoom(MessageTO messageTO);

	public void getUserList(MessageTO messageTO);

	public void updateUserList(Room room);
	
	public void getRoomList(LoginTO loginTO);
	
	public void updateRoomList();

}