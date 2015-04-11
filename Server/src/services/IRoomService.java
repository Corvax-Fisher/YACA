package Server.src.services;

import java.util.List;

import Server.src.transferObjects.MessageTO;

public interface IRoomService {

	public boolean ban(MessageTO messageTO);

	public boolean kick(MessageTO messageTO);

	public boolean mute(MessageTO messageTO);

	public boolean joinRoom(MessageTO messageTO);

	public boolean leaveRoom(MessageTO messageTO);

	public List<String> getUserList(MessageTO messageTO);

	public void updateUserList(Room room);

}