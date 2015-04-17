package transferObjects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientStub {
	private static final int PORT = 32957;
	private static String serverIP;
	private static ObjectOutputStream outStream;
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
	
	public void sendObject(RegisterTO rto) {
		new SendRequest(rto, "register").start();	
	}
	
	public void sendObject(String message, String type) {
		new SendRequest(message, type).start();	
	}
	
	public void sendObject(Object data, String type) {
		new SendRequest(data, type).start();	
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
				synchronized(outStream) {
					outStream.writeObject(type);
					outStream.writeObject(to);
					outStream.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean connect() {
		try {
			socket = new Socket(serverIP, PORT);
			outStream = new ObjectOutputStream(socket.getOutputStream());
			
			return true;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
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
