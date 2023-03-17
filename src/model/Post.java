package model;

import java.time.LocalDate;

public class Post {
	private String msg;
	private LocalDate date;
	private int countOfLikes;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getDate() {
		return date;
	} //TODO use localdate
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	public void setCountOfLikes(int countOfLikes) {
		this.countOfLikes = countOfLikes;
	}
	
	
}
