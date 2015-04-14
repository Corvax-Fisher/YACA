package transferObjects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientStub {
	private static final int PORT = 32957;
	private static String serverIP;
	private static ObjectOutputStream outStream;
	private static ObjectInputStream inStream;

	private static Socket socket;
	
	public ClientStub(String ip){
		this.serverIP = ip;
	}
	
	public void sendObject(LoginTO lto) {
		new SendRequest(lto, "login").start();	
	}
	
	public void sendObject(MessageTO mto) {
		new SendRequest(mto, "message").start();	
	}
	
	
	
	public ObjectInputStream getInStream() {
		return inStream;
	}
	
	
	private static class SendRequest extends Thread {
		private Object to;
		private String type;
		
		public SendRequest(Object to, String type) {
			this.to = to;
			this.type = type;
		}
		
		public void run() {
			try {
				outStream.writeObject(type);
				outStream.writeObject(to);
				outStream.flush();
				if(inStream == null) inStream = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void connect() {
		try {
			socket = new Socket(serverIP, PORT);
			outStream = new ObjectOutputStream(socket.getOutputStream());
			
			System.out.println("test");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			outStream.close();
			socket.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
