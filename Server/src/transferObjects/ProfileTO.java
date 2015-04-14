package transferObjects;

import java.io.Serializable;

public class ProfileTO extends RegisterTO implements Serializable {

		private String realName;
		private String role;
	
	public ProfileTO(String name, String password, String email, String realName, String role) {
		super(name, password, email);
		this.realName = realName;
		this.role = role;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
