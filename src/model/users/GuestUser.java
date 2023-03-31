package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import service.MainService;

public class GuestUser {
	private long generatedID;
	private static long idCounter = 1;

	public long getGeneratedID() {
		return generatedID;
	}
	public void setGeneratedID() {
		generatedID = idCounter++;
	}
	
	public GuestUser() {
		setGeneratedID();
	}

	public String toString() {
		return "GUESTUSER ID: " + generatedID;
	}
	
	//TODO add find functions
	public ArrayList<User> findUsersByUsernameOrSurname(String input) {
		ArrayList<User> foundUsers = new ArrayList<>();
		for (User temp: MainService.allRegisterdUsers) {
			if (temp.getUsername().contains(input) || temp.getSurname().contains(input)) {
				foundUsers.add(temp);
			}
		}
		return foundUsers;
	}
	public ArrayList<Page> findPagesByTitleOrDescription(String inputWord) {
		ArrayList<Page> foundPages = new ArrayList<>();
		for (User temp: MainService.allRegisterdUsers) {
			if (temp instanceof BusinessUser) {
				BusinessUser bizUser = (BusinessUser)temp;
				for (Page tempPage: bizUser.getAllPages()) {
					if (tempPage.getTitle().toLowerCase().contains(inputWord.toLowerCase())
							|| tempPage.getDescription().toLowerCase().contains(inputWord.toLowerCase())) {
						foundPages.add(tempPage);
					}
				}
			}
		}
		return foundPages;
	}
	public ArrayList<Post> findPublicPostsInPrivateUserOrInPage(String inputWord) {
		ArrayList<Post> foundPosts = new ArrayList<>();
		for (User temp: MainService.allRegisterdUsers) {
			if (temp instanceof PrivateUser) {
				PrivateUser privUser = (PrivateUser)temp;
				for (Post tempPost: privUser.getAllPublicPosts()) {
					if (tempPost.getMsg().toLowerCase().contains(inputWord)) {
						foundPosts.add(tempPost);
					}
				}
			}
			if (temp instanceof BusinessUser) {
				BusinessUser bizUser = (BusinessUser)temp;
				for (Page tempPage: bizUser.getAllPages()) {
					for (Post tempPost: tempPage.getPostsInPage()) {
						if (tempPost.getMsg().toLowerCase().contains(inputWord)) {
							foundPosts.add(tempPost);
						}
					}
				}
			}
		}
		return foundPosts;
	}
}
