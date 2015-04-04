package connection;

import java.io.Serializable;

public class LoginTO extends Credentials implements Serializable {
	
	private String type;
	
	public LoginTO(String name, String password, String type){
		this.name = name;
		this.password = password;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;  
	}
}
