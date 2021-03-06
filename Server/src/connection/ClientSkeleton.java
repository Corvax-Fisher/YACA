package connection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import connection.*;
import delegate.ServiceFacade;



public class ClientSkeleton extends Thread {
	private static final int PORT = 32957;
	private ServerSocket listener;
	private static ServiceFacade servicefacade;
	private static HashMap<String, String> clients = new HashMap<String, String>();
	
	public ClientSkeleton(ServiceFacade servicefacade) {
		this.servicefacade = servicefacade;
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
			String ip = "";
        	try {
				inStream = new ObjectInputStream(socket.getInputStream());
				ip = socket.getInetAddress().getHostAddress();
	        	
				while (true) {
					String inputType = (String) inStream.readObject();
					System.out.println(inputType);
					
					switch (inputType.toLowerCase()) {
			            case "login":
			            	LoginTO loginContent = (LoginTO) inStream.readObject();
			            	System.out.println(ip);
							if(servicefacade.logIn(ip, loginContent)) {
								clients.put(ip, loginContent.getName());
							}
			                break;
			            case "message":
			            	MessageTO messageContent = (MessageTO) inStream.readObject();

			            	switch (messageContent.getType()) {
					            case "logout":
					            	//user aus clients löschen
					            	servicefacade.logOut(messageContent);
					            	return;
					            case "joinroom":
					            	servicefacade.joinRoom(messageContent);			            	
					                break;
					            case "leaveroom":
					            	servicefacade.leaveRoom(messageContent);
					                break;
					            case "message":
					            	servicefacade.sendMessage(messageContent);
					                break;
					            case "sendprivatemessage":
					            	servicefacade.sendPrivateMessage(messageContent);
					                break;
					            case "getuserlist":
					            	servicefacade.getUserList(messageContent);
						            break;
					            default: 
					                System.out.println("unimplemented Message");
					                break;
							}
			            	
			                break;
			            case "register":
			            	RegisterTO registerContent = (RegisterTO) inStream.readObject();
							clients.put(ip, registerContent.getName());
			            	servicefacade.register(ip, registerContent);
			                break;
			            default: 
			                System.out.println("unimplemented Type");
			                break;
					}					
				}
			}
        	catch (IOException | ClassNotFoundException e) {
        		System.out.println(e);
            	if(clients.get(ip) != null)
            		servicefacade.logOut(new MessageTO(clients.get(ip), null, null, "logout", null));
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
