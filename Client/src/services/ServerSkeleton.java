package services;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import transferObjects.*;


public class ServerSkeleton extends Thread {
	private static ObjectInputStream inStream;
	
	public ServerSkeleton(ObjectInputStream inStream) {
		this.inStream = inStream;
	}
	
	
	public void run() {
    	try {

			while (true) {
				String inputType = (String) inStream.readObject();
				//System.out.println(inputType);
				
				switch (inputType.toLowerCase()) {
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
    	
	}
}
