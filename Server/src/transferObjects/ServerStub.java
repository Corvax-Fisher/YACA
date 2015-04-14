package transferObjects;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class ServerStub {
	private static HashMap<String, ObjectOutputStream> clients = new HashMap<String, ObjectOutputStream>();
	
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
	
	
	
	
	public void addUser(String name, ObjectOutputStream outStream) {
		clients.put(name, outStream);
	}
	
	public void removeUser(String name) {
		clients.remove(name);
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
				ObjectOutputStream outStream = (ObjectOutputStream) clients.get(name);
				outStream.writeObject(type);
				outStream.writeObject(to);
				outStream.flush();
				System.out.println("Server Message wrote");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
