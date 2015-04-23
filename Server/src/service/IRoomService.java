package service;

import java.util.List;

import connection.LoginTO;
import connection.MessageTO;

public interface IRoomService {

	public void ban(MessageTO messageTO);

	public void kick(MessageTO messageTO);

	public void mute(MessageTO messageTO);

	public void joinRoom(MessageTO messageTO, List<String> userList);

	public void leaveRoom(MessageTO messageTO);

	public List<String> getUserList(MessageTO messageTO);
	
	public void fetchUserList(MessageTO mto);

	public void updateUserList(String userConcerns, Room room);
	
//	public void getRoomList(LoginTO loginTO);
	
	public void updateRoomList(List<String> userList);
	
	public void logOut(String string);

	public List<String> getAllRooms();

}