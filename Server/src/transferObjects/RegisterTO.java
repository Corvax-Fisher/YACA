package Server.src.transferObjects;

import java.io.Serializable;

public class RegisterTO extends Credentials implements Serializable {

	private String email;
	
	public RegisterTO(String name, String password, String email) {
		super(name, password);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;  
	}
}
