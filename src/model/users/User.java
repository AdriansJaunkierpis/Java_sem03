package model.users;

import model.GuestUser;

public class User extends GuestUser {
	private String username;
	private String nameAndSurname;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNameAndSurname() {
		return nameAndSurname;
	}
	public void setNameAndSurname(String nameAndSurname) {
		if(nameAndSurname != null && nameAndSurname.matches("([A-ZĀČĒĢĪĶĻŅŠŪŽ]){1}[a-zāčēģīķļņšūž]+[ ]?")) {
			this.nameAndSurname = nameAndSurname;
		} else {
			this.nameAndSurname = "Unknown";
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		super();
		setUsername("Unknown");
		setNameAndSurname("Unknown");
		setPassword("1234");
	};
	public User(String username, String nameAndSurname, String password) {
		super();
		this.username = username;
		this.nameAndSurname = nameAndSurname;
		this.password = password;
	}
	
	
}
