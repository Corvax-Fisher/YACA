package services;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import transferObjects.*;


public class ServerSkeleton extends Thread {
	private static final int PORT = 32958;
	private ServerSocket listener;
	private static ServerService serverService;
	
	public ServerSkeleton(ServerService serverService) {
		this.serverService = serverService;
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
				
				while (true) {
					String inputType = (String) inStream.readObject();
					System.out.println(inputType);
					
					switch (inputType.toLowerCase()) {
			            case "message":
			            	MessageTO messageContent = (MessageTO) inStream.readObject();
			            	System.out.println("Client - Message arrived: " + messageContent.getType());
			            	switch (messageContent.getType()) {
			            		case "usernameused":
			            			serverService.logInError(messageContent);
			            		  break;
					            default: 
					            	
					            break;	
			            	}
			                break;
			            case "profile":
			            	MessageTO profileContent = (MessageTO) inStream.readObject();
			            	
			                break;
			            default: 
			            	//Object test = inStream.readObject();
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
