package database;

public class UserPAO {
	private String userName;
	private String password;
	private int roleID;
	private String fullName;
	
	public UserPAO(Builder builder) {
		this.userName = builder.userName;
		this.password = builder.password;
		this.roleID = builder.roleID;
		this.fullName = builder.fullName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "\nUser name: " + this.userName +
				", password: " + this.password + 
				", role ID: " + this.roleID + 
				", full name: " + this.fullName;
	}
	
    public static class Builder
    {
    	private String userName;
    	private String password;
    	private int roleID = 0;
    	private String fullName;
 
        public Builder(String userName) {
            this.userName = userName;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public Builder roleID(int roleID) {
        	this.roleID = roleID;
        	return this;
        }

        public UserPAO build() {
            UserPAO user =  new UserPAO(this);
            return user;
        }
    }
}
