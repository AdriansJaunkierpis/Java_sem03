package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
	private String msg;
	private LocalDateTime date;
	private int countOfLikes;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		if (msg != null && msg.length() > 3) {
			this.msg = msg;
		} else {
			msg = "----";
		}
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDateTime() {
		this.date = LocalDateTime.now();
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	public void increaseLikes() {
		countOfLikes++;
	}
	
	public Post() {
		setMsg("Test msg");
		setDateTime();
	}
	public Post(String msg) {
		setMsg(msg);
	}
	
	public String toString() {
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " -> " + msg + "( " + countOfLikes + ")";
	}
}
