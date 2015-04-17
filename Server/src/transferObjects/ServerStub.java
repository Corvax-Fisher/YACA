package transferObjects;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;


public class ServerStub {
	private static final int PORT = 32958;
	private static HashMap<String, ObjectOutputStream> clientOutputs = new HashMap<String, ObjectOutputStream>();
	private static HashMap<String, Socket> clientSockets = new HashMap<String, Socket>();
	
	public ServerStub() {
		
	}
	
	public void sendObject(String name, MessageTO mto) {
		new SendRequest(name, mto, "message").start();	
	}
	
	public void sendObject(String name, ProfileTO pto) {
		new SendRequest(name, pto, "profile").start();	
	}
	
	public void sendObject(String name, String message, String type) {
		new SendRequest(name, message, type).start();	
	}
	
	public void sendObject(String name, Object data, String type) {
		new SendRequest(name, data, type).start();	
	}
	
	
	public void addUser(String name, String ip) {
		try {
			Socket socket;
			socket = new Socket(ip, PORT);
			clientSockets.put(name, socket);
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			clientOutputs.put(name, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeUser(String name) {
		try {
			clientOutputs.get(name).close();
			clientSockets.get(name).close();
			clientOutputs.remove(name);
			clientSockets.remove(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private static class SendRequest extends Thread {
		private String name;
		private Object to;
		private String type;
		
		public SendRequest(String name, Object to, String type) {
			this.name = name;
			this.to = to;
			this.type = type;
		}
		
		public void run() {
			try {
				synchronized((ObjectOutputStream) clientOutputs.get(name)) {
					ObjectOutputStream outStream = (ObjectOutputStream) clientOutputs.get(name);
					outStream.writeObject(type);
					outStream.writeObject(to);
					outStream.flush();
					System.out.println("Server Message wrote");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
