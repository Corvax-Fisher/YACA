package DataTransferObjects;

import java.io.Serializable;

public class RegisterTO extends Credentials implements Serializable {

	private String email;
	
	public RegisterTO(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;  
	}
}
