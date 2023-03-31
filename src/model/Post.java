package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
	//1. variables
	private String msg;
	private LocalDateTime dateTime;
	//TODO need to change to Arraylist of User, which set the like to this post
	private int countOfLikes = 0;
	
	//2.getters and setters
	public String getMsg() {
		return msg;
	}
	public void setMsg(String inputMsg) {
		if(inputMsg!=null && inputMsg.length() > 3) {
			msg = inputMsg;
		}
		else
		{
			msg = "----";
		}
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	public void increaseLikes() {
		countOfLikes++;
	}
	
	//3. constructors
	public Post() {
		setDateTime();
		setMsg("Test msg");
	}
	
	public Post(String msg) {
		setDateTime();
		setMsg(msg);
	}
	
	//4. toString
	//24/03/2023 13:57:23 -> mana ziņa (3)
	public String toString() {
		return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))
				+ " -> " + msg + " (" + countOfLikes + ")";
	}
}