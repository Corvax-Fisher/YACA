package services;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import transferObjects.LoginTO;
import transferObjects.MessageTO;
import transferObjects.ServerStub;


public class ClientSkeleton extends Thread {
	private static final int PORT = 32957;
	private ServerSocket listener;
	private static ServerStub st;
	private static HashMap<String, String> clients = new HashMap<String, String>();
	
	public ClientSkeleton(ServerStub st) {
		this.st = st;
	}
	
	public void run() {
		try {
			listener = new ServerSocket(PORT);
			
			try {
	            while (!Thread.interrupted()) {
	                new HandleRequest(listener.accept()).start();
	            }
	        } 
	        finally {
	            listener.close();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static class HandleRequest extends Thread {
		private Socket socket;
		private ObjectInputStream inStream;
		
		
		public HandleRequest(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
        	try {
				inStream = new ObjectInputStream(socket.getInputStream());
				
				String ip = socket.getInetAddress().getHostAddress();
	        	
				while (true) {
					String inputType = (String) inStream.readObject();
					System.out.println(inputType);
					
					switch (inputType.toLowerCase()) {
			            case "login":
			            	LoginTO loginContent = (LoginTO) inStream.readObject();
							clients.put(ip, loginContent.getName());
							st.addUser(loginContent.getName(), new ObjectOutputStream(socket.getOutputStream()));
							
			                break;
			            case "message":
			            	MessageTO messageContent = (MessageTO) inStream.readObject();
			            	
			                break;
			            case "profile":
			            	MessageTO profileContent = (MessageTO) inStream.readObject();
			            	
			                break;
			            default: 
			                
			                break;
					}					
				}
			}
        	catch (IOException | ClassNotFoundException e) {
        		System.out.println(e);
            } 
        	finally {
                try {
                    socket.close();
                } 
                catch (IOException e) {
                	
                }
            }
        	
		}
		
	}
	
}
