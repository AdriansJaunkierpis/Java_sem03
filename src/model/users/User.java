package model.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.Page;
import model.Post;
import model.PostType;
import service.MainService;

public abstract class User extends GuestUser {
	private String username;
	private String name; //for Business user it will be name of owner
	private String surname;
	private String encodedPassword;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if (username != null && username.matches("[a-z0-9.]{8,20}")) {
			this.username = username;
		} else {
			this.username = "default.user";
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEncodedPassword() {
		return encodedPassword;
	}
	public void setEncodedPassword(String encodedPassword) {
		if (encodedPassword != null && encodedPassword.matches("[A-Za-z0-9]{3,20}")) {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(encodedPassword.getBytes());
				encodedPassword = new String(md.digest());
			} catch (NoSuchAlgorithmException e) { 
				this.encodedPassword = "defaultpassword";
			}
			this.encodedPassword = encodedPassword;
		} else {
			encodedPassword = "defaultpassword";
		}
		
	}
	
	public User() {
		super();
		setUsername("default.user");
		setName("defaultname");
		setEncodedPassword("defaultpassword");
		setSurname("defaultsurname");
	};
	public User(String username, String name, String surname, String password) {
		super();
		setUsername(username);
		setName(name);
		setSurname(surname);
		setEncodedPassword(password);
	}
	
	public String toString() {
		return "USER ID: " + getGeneratedID() + ", " + name + " " + surname + ": " + username;
	}
	
	public boolean login() {
		for (User temp: MainService.allRegisterdUsers) {
			if (temp.getUsername().equals(username) && temp.getEncodedPassword().equals(encodedPassword)) {
				return true;
			}
		}
		return false;
	}
	
	public void followPage(Page page) throws Exception {
		if (page == null) {
			throw (new Exception("Page not found"));
		}
		page.addFollowers(this);
	}
	
	//TODO unfollow page
	
	public abstract Post createPost(Post post, PostType type);
	
}
