package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
	private String title;
	private String description;
	private ArrayList<User> followers = new ArrayList<>();
	private ArrayList<Post> postsInPage = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title !=null && title.length() > 3 && title.length() < 31) {
			this.title = title;
		}
		else {
			this.title = "TITLE";
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description != null && description.length() > 3 && description.length() < 151) {
			this.description = description;
		}
		else {
			this.description = "DESCRIPTION";
		}
	}
	public ArrayList<User> getFollowers() {
		return followers;
	}
	public void addFollowers(User follower) {
		if (follower != null && !followers.contains(follower)) {
			followers.add(follower);
		}
	}
	public void removeFollower(User unFollower) {
		if (unFollower != null && followers.contains(unFollower)) {
			followers.remove(unFollower);
		}
	}
	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}
	public void addPostInPage(Post post) {
		if (post != null) {
			postsInPage.add(post);
		}
	}
	public void removePostFromPage(Post post) {
		if (post != null && postsInPage.contains(post)) {
			postsInPage.remove(post);
		}
	}
	
	public Page() {
		setTitle("TITLE");
		setDescription("DESCRIPTION");
	}
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
	}
	
	public String toString() {
		return title + "(" + description + ") -->" + postsInPage + "-->" + followers.size();
	}
}
