package services;
import java.util.List;

import transferObjects.ProfileTO;

public interface IClientServiceDelegate {
	

	public void logIn(String name, String password);

	public void logInGuest(String name);

	public void logOut(String from);

	public void register(String name, String password, String email);

	public void kick(String from, String to, String room);

	public void ban(String from, String to, String room);

	public void mute(String from, String to, String room);

	public void sendMessage(String from, String room, Object body);

	public void sendPrivateMessage(String from, String to, String room, Object body);

	public void sendFile(String from, String to, String room, Object body);

	public void showProfile(String from, String to);

	public void saveProfile(String name, String password, String email, String realName, String role);

	public void joinRoom(String from, String roomName);

	public void leaveRoom(String from, String roomName);

	public void getUserList(String from, String roomName);

}